package ru.ibs.trainee.happyrecruter.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import ru.ibs.trainee.happyrecruter.model.Role;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class WebConfig extends WebSecurityConfigurerAdapter {

	private final UserDetailsService userDetailsService;
	
	
	
	

	public WebConfig(@Qualifier("UserDetailsServiceImpl") UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}




	@Override
	protected void configure(HttpSecurity http) throws Exception {
	    http
	    .csrf().disable()
	    .authorizeRequests()
	    .antMatchers("/").permitAll()
	    .anyRequest()
	    .authenticated()
	    .and()
	    .formLogin()
	    .loginPage("/auth/login").permitAll()
	    .defaultSuccessUrl("/auth/success")
	    .and()
	    .logout()
	    .logoutRequestMatcher(new AntPathRequestMatcher("/auth/logout", "POST"))
	    .invalidateHttpSession(true)
	    .clearAuthentication(true)
	    .deleteCookies("JSESSIONID")
	    .logoutSuccessUrl("/auth/login");
	    
	}
	
	
	

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(daoAuthenticationProvider());
	}
	
//	@Bean
//	@Override
//	protected UserDetailsService userDetailsService() {
//
//		return new InMemoryUserDetailsManager(
//				User.builder()
//				.username("admin")
//				.password(passwordEncoder().encode("admin"))
//				.authorities(Role.ADMIN.getAuthorities())
//				.build(),
//				User.builder()
//				.username("user")
//				.password(passwordEncoder().encode("user"))
//				.authorities(Role.USER.getAuthorities())
//				.build());
//	}
	
	@Bean
	protected PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(12);
	}

	@Bean
	protected DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		daoAuthenticationProvider.setUserDetailsService(userDetailsService);
		return daoAuthenticationProvider;
	}


//	@Bean
//	public WebMvcConfigurer corsConfigurer() {
//	    return new WebMvcConfigurer() {
//	        @Override
//	        public void addCorsMappings(CorsRegistry registry) {
//	            registry.addMapping("/**").allowedMethods("*");
//	        }
//	    }; 
//	  }
	
}
