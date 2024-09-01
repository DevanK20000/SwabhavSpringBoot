package com.aurionpro.bankRest.utils;

import com.aurionpro.bankRest.dto.BankAccountDto;
import com.aurionpro.bankRest.dto.CustomerDto;
import com.aurionpro.bankRest.dto.LoginDto;
import com.aurionpro.bankRest.dto.TransactionDto;
import com.aurionpro.bankRest.entity.BankAccount;
import com.aurionpro.bankRest.entity.Customer;
import com.aurionpro.bankRest.entity.Login;
import com.aurionpro.bankRest.entity.Transaction;

public class EntityToDtoConverter {

	public static BankAccountDto toBankAccountDto(BankAccount bankAccount) {
		BankAccountDto bankAccountDto = new BankAccountDto();
		bankAccountDto.setAccountNumber(bankAccount.getAccountNumber());
		bankAccountDto.setAccountType(bankAccount.getAccountType());
		bankAccountDto.setBalance(bankAccount.getBalance());
		bankAccountDto.setMinOrOverdueLimit(bankAccount.getMinOrOverdueLimit());
		return bankAccountDto;
	}
	
	public static CustomerDto toCustomerDto(Customer customer) {
		CustomerDto customerDto = new CustomerDto();
		customerDto.setCustomeId(customer.getCustomeId());
		customerDto.setFirstName(customer.getFirstName());
		customerDto.setLastName(customer.getLastName());
		customerDto.setEmail(customer.getEmail());
		return customerDto;
	}
	
	public static LoginDto toLoginDto(Login login) {
		LoginDto loginDto = new LoginDto();
		loginDto.setLoginId(login.getLoginId());
		loginDto.setUsername(login.getUsername());
		loginDto.setPassword(login.getPassword());
		loginDto.setLoginType(login.getLoginType());
		return loginDto;
	}
	
	public static TransactionDto toTransactionDto(Transaction transaction) {
		TransactionDto transactionDto = new TransactionDto();
		transactionDto.setTransactionId(transaction.getTransactionId());
		transactionDto.setSenderAccount(transaction.getSenderAccount().getAccountNumber());
		transactionDto.setReciverAccount(transaction.getReciverAccount().getAccountNumber());
		transactionDto.setAmmount(transaction.getAmmount());
		transactionDto.setTransactionType(transaction.getTransactionType());
		transactionDto.setDate(transaction.getDate());
		return transactionDto;
	}
}
