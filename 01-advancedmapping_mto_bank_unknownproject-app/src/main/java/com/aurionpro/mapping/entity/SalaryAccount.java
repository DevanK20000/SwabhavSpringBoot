package com.aurionpro.mapping.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="salaryaccount")
@Data
public class SalaryAccount {
	@Id
	@Column
	private Long accountNumber;

	@Column
	private String accountHolderName;
}

