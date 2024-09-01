package com.aurionpro.jwtSecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aurionpro.jwtSecurity.dto.JwtAuthResonse;
import com.aurionpro.jwtSecurity.dto.LoginDto;
import com.aurionpro.jwtSecurity.dto.RegistrationDto;
import com.aurionpro.jwtSecurity.entity.User;
import com.aurionpro.jwtSecurity.service.AuthService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("/api")
public class AuthController {
	@Autowired
	private AuthService authService;
	
	@PostMapping("/register")
	public ResponseEntity<User> register(@RequestBody RegistrationDto registrationDto) {
		//TODO: process POST request
		return ResponseEntity.ok(authService.register(registrationDto));
	}
	
	@GetMapping("/login")
	public ResponseEntity<JwtAuthResonse> login(@RequestBody LoginDto loginDto) {
		String token = authService.login(loginDto);
		JwtAuthResonse jwtAuthResonse = new JwtAuthResonse();
		jwtAuthResonse.setAccessToken(token);
		
		return ResponseEntity.ok(jwtAuthResonse);
	}
	
}
