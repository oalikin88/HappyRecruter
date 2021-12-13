package ru.ibs.trainee.happyrecruter.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.CorsUtils;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import lombok.RequiredArgsConstructor;
import ru.ibs.trainee.happyrecruter.jwt.JwtProvider;
import ru.ibs.trainee.happyrecruter.jwt.JwtTokenVerifierFilter;
import ru.ibs.trainee.happyrecruter.jwt.JwtUsernameAndPasswordAuthenticationFilter;
import ru.ibs.trainee.happyrecruter.services.MyUserDetailsService;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private final PasswordEncoder passwordEncoder;
	private final MyUserDetailsService myUserDetailsService;
	private final JwtProvider jwtProvider;

	@Override
	protected void configure(HttpSecurity http) throws Exception { // метод конфигурации
		http

				.csrf().disable()
				 .cors().configurationSource(corsConfigurationSource()).and()// отключили
				// фичу, которая защищает от подделки межсайтовых запросов, отключаются куки
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // Spring Security никогда
																							// не создаст HttpSession и
																							// никогда не будет
																							// использовать его для
																							// получения SecurityContext
				.and().addFilter(new JwtUsernameAndPasswordAuthenticationFilter(authenticationManager(), jwtProvider)) // добавляем
																														// свой
																														// фильтр
																														// (JwtUsernameAndPasswordAuthenticationFilter)
				.addFilterAfter(new JwtTokenVerifierFilter(jwtProvider),
						JwtUsernameAndPasswordAuthenticationFilter.class) // добавляем ещё один
																			// фильтр(JwtTokenVerifierFilter)
				.authorizeRequests(req -> req.requestMatchers(CorsUtils::isPreFlightRequest).permitAll() // позволяет
																											// ограничить
																											// доступ к
																											// эндпоинтам
						.antMatchers("/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config#/", "swagger")
						.permitAll());
		// разрешаем доступ к главной странице
//                .antMatchers("manager/api/**").hasRole(MANAGER.name()) // только юзер с ролью менеджер может заходить по указанному адресу
//                .antMatchers(HttpMethod.DELETE, "/api/task/**").hasAuthority(TASK_WRITE.getPermission())
//                .antMatchers(HttpMethod.POST, "/api/task/**").hasAuthority(TASK_WRITE.getPermission())
//                .antMatchers(HttpMethod.PUT, "/api/task/**").hasAuthority(TASK_WRITE.getPermission())
//                .antMatchers("/api/task/**").hasAnyRole(EMPLOYEE.name(), TRAINEE.name())
//                .anyRequest() //ограничит доступ для любой другой конечной точки , отличной от PUBLIC_URL
//                .authenticated(); // пользователь должен быть аутентифицирован.
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(daoAuthenticationProvider());
	}
	
	  @Bean CorsConfigurationSource corsConfigurationSource() { CorsConfiguration
	  configuration = new CorsConfiguration();
	  configuration.setAllowedOrigins(Arrays.asList("*"));
	  configuration.setAllowedMethods(Arrays.asList("GET","POST","PUT"));
	  configuration.setAllowCredentials(true);
	 																	//the below three lines will add the relevant CORS response headers configuration.addAllowedOrigin("*");
	  configuration.addAllowedHeader("*"); configuration.addAllowedMethod("*");
	  UrlBasedCorsConfigurationSource source = new
	  UrlBasedCorsConfigurationSource(); source.registerCorsConfiguration("/**",
	  configuration); return source; }
	 

	/*
	 * @Bean public WebMvcConfigurer corsConfigurer() { return new
	 * WebMvcConfigurerAdapter() {
	 * 
	 * @Override public void addCorsMappings(CorsRegistry registry) {
	 * registry.addMapping("/project/**")
	 * .allowedOrigins("http://c286-185-253-182-161.ngrok.io")
	 * .allowedMethods("PUT", "DELETE","GET","POST")
	 * .allowedHeaders("Access-Control-Allow-Origin",
	 * "Access-Control-Allow-Methods", "Access-Control-Allow-Headers") //
	 * .exposedHeaders("header1", "header2") .allowCredentials(false).maxAge(3600);
	 * } }; }
	 */

	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider() { // проверка подлинности юзера и пароля
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(passwordEncoder);
		provider.setUserDetailsService(myUserDetailsService);
		return provider;
	}

}
