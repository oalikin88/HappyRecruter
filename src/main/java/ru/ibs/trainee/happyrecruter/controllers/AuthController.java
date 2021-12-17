package ru.ibs.trainee.happyrecruter.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import ru.ibs.trainee.happyrecruter.auth.ERole;
import ru.ibs.trainee.happyrecruter.auth.JwtResponse;
import ru.ibs.trainee.happyrecruter.auth.LoginRequest;
import ru.ibs.trainee.happyrecruter.auth.MessageResponse;
import ru.ibs.trainee.happyrecruter.auth.SignUpRequest;
import ru.ibs.trainee.happyrecruter.config.jwt.JwtUtils;
import ru.ibs.trainee.happyrecruter.entities.Role;
import ru.ibs.trainee.happyrecruter.entities.User;
import ru.ibs.trainee.happyrecruter.repositories.RoleRepository;
import ru.ibs.trainee.happyrecruter.repositories.UserRepository;
import ru.ibs.trainee.happyrecruter.services.UserDetailsImpl;

@RestController
@RequestMapping("api/")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AuthController {

	@Autowired
	JwtUtils jwtUtils;
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	UserRepository userRepository;

	@PostMapping("signin")
	public ResponseEntity<?> authUser(@RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream().map(e -> e.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(), roles));
	}

	@PostMapping("signup")
	public ResponseEntity<?> registerUser(@RequestBody SignUpRequest signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: имя уже занято"));
		}

		User user = new User(signUpRequest.getUsername(), passwordEncoder.encode(signUpRequest.getPassword()));

		Set<String> reqRoles = signUpRequest.getRoles();
		Set<Role> roles = new HashSet<>();

		if (reqRoles == null) {
			Role userRole = roleRepository.findByName(ERole.USER)
					.orElseThrow(() -> new RuntimeException("Error, role is not found"));
			roles.add(userRole);
		} else {
			reqRoles.forEach(r -> {
				switch (r) {
				case "admin":
					Role adminRole = roleRepository.findByName(ERole.ADMIN)
							.orElseThrow(() -> new RuntimeException("Error, role is not found"));
					roles.add(adminRole);
					break;
				case "mod":
					Role modRole = roleRepository.findByName(ERole.MODERATOR)
							.orElseThrow(() -> new RuntimeException("Error, role is not found"));
					roles.add(modRole);
					break;

				default:
					Role userRole = roleRepository.findByName(ERole.USER)
							.orElseThrow(() -> new RuntimeException("Error, role is not found"));
					roles.add(userRole);
				}
			});

		}

		user.setRoles(roles);
		userRepository.save(user);
		return ResponseEntity.ok(new MessageResponse("User CREATED"));
	}

}
