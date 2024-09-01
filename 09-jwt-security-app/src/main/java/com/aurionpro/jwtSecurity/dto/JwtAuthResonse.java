package com.aurionpro.jwtSecurity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class JwtAuthResonse {
	private String accessToken;
	private String tokenType="Bearer";
}
