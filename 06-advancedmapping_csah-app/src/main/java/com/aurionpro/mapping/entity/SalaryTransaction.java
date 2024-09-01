package com.aurionpro.mapping.entity;

import java.sql.Date;

import com.aurionpro.mapping.entity.enums.SalaryTransactionStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "salary_transaction")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalaryTransaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long transactionId;

	@Column
	private Date transactionDate;

	@Column
	private Double amount;

	@Column
	private SalaryTransactionStatus status;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "salaryId")
	private Salary salary;

	@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH})
	@JsonBackReference
	private SalaryAccount salaryAccount;
}
