package ru.ibs.trainee.happyrecruter.dto;

import lombok.Data;

@Data
public class AuthenticationRequestDTO {

	private String email;
	private String password;
}
