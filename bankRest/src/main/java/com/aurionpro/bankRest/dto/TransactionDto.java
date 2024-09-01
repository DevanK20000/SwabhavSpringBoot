package com.aurionpro.bankRest.dto;

import java.sql.Date;

import com.aurionpro.bankRest.entity.BankAccount;
import com.aurionpro.bankRest.entity.enums.TransactionType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TransactionDto {
	private Long transactionId;
	private Long senderAccount;
	private Long reciverAccount;
	private TransactionType transactionType;
	private Double ammount;
	private Date date;
}
