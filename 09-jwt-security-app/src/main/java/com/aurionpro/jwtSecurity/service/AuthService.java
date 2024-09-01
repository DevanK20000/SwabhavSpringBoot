package com.aurionpro.jwtSecurity.service;

import com.aurionpro.jwtSecurity.dto.LoginDto;
import com.aurionpro.jwtSecurity.dto.RegistrationDto;
import com.aurionpro.jwtSecurity.entity.User;

public interface AuthService {
	User register(RegistrationDto registrationDto);
	String login(LoginDto loginDto);
}
