package com.aurionpro.bankRest.entity;

import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.CurrentTimestamp;

import com.aurionpro.bankRest.entity.enums.TransactionType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="transactions")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long transactionId;
	
	@ManyToOne
	@JoinColumn(name = "senderAccountNumber")
	private BankAccount senderAccount;
	
	@ManyToOne
	@JoinColumn(name = "reciverAccountNumber")
	private BankAccount reciverAccount;
	
	@NotNull
	@Column
	private TransactionType transactionType;
	
	@NotNull
	@Min(0)
	@Column
	private Double ammount;
	
	@CreationTimestamp
	@Column(nullable = false, updatable = false)
	private Date date;
	
}
