package com.aurionpro.mapping.entity;

import java.sql.Date;

import com.aurionpro.mapping.entity.enums.SalaryTransactionStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	@Column(name = "transaction_id")
	private Long transactionId;

	@Column(name = "transaction_date")
	private Date transactionDate;

	@Column(name = "amount")
	private Double amount;

	@Column(name = "status")
	private SalaryTransactionStatus status;

}
