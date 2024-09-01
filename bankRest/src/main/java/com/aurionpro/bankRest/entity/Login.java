package com.aurionpro.bankRest.entity;

import com.aurionpro.bankRest.entity.enums.LoginType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Logins")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Login {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int loginId;
	
	@NotBlank
	@NotNull
	@Min(4)
	@Column
	private String username;
	
	
	@NotBlank
	@NotNull
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,10}$", message = "Minimum eight and maximum 10 characters, at least one uppercase letter, one lowercase letter, one number and one special character")
	@Column
	private String password;
	
	@NotNull
	@Column
	private LoginType loginType;
}
