package com.aurionpro.bankRest.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Customers")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int customeId;
	
	@NotNull
	@NotBlank
	@Column
	private String firstName;
	
	@NotNull
	@NotBlank
	@Column
	private String lastName;
	
	@Email
	private String email;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="loginId")
	private Login login;
	
	@OneToMany(mappedBy = "customer", cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH})
	private List<BankAccount> bankAccount;
}
