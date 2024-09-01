package com.aurionpro.bankRest.dto;

import com.aurionpro.bankRest.entity.enums.LoginType;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginDto {
	private int loginId;
	private String username;
	private String password;
	private LoginType loginType;
}
