package ru.ibs.trainee.happyrecruter.controllers;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ru.ibs.trainee.happyrecruter.services.MyUserDetailsService;

@RestController
@RequestMapping("login")
public class UserAuthController {

	private MyUserDetailsService myUserDetailsService;

	public UserAuthController (MyUserDetailsService myUserDetailsService) {
		this.myUserDetailsService = myUserDetailsService;
	}

	 @GetMapping(path = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
	    public @ResponseBody UserDetails getUser(String username) {
	        return this.myUserDetailsService.loadUserByUsername(username);
	    }
	
}
