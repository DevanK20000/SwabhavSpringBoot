package com.aurionpro.bankRest.entity;

import java.util.List;

import com.aurionpro.bankRest.entity.enums.AccountType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "BankAccounts")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BankAccount {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long accountNumber;
	
	@NotNull
	@Column
	private AccountType accountType;
	
	@NotNull
	@Min(0)
	@Column
	private Double balance;
	
	@NotNull
	@Min(0)
	private Double minOrOverdueLimit;
	
	@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH})
	@JoinColumn(name="customeId")
	private Customer customer;
	
	@OneToMany(mappedBy = "senderAccount", cascade = CascadeType.ALL)
	private List<Transaction> sentTransactions;
	
	@OneToMany(mappedBy = "reciverAccount", cascade = CascadeType.ALL)
	private List<Transaction> receivedTransactions;
	
}
