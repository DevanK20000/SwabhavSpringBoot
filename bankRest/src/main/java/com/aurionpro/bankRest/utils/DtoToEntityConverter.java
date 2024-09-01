package com.aurionpro.bankRest.utils;

import com.aurionpro.bankRest.dto.BankAccountDto;
import com.aurionpro.bankRest.dto.CustomerDto;
import com.aurionpro.bankRest.dto.LoginDto;
import com.aurionpro.bankRest.dto.TransactionDto;
import com.aurionpro.bankRest.entity.BankAccount;
import com.aurionpro.bankRest.entity.Customer;
import com.aurionpro.bankRest.entity.Login;
import com.aurionpro.bankRest.entity.Transaction;

public class DtoToEntityConverter {

    public static Customer toCustomerEntity(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setCustomeId(customerDto.getCustomeId());
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customer.setEmail(customerDto.getEmail());
        return customer;
    }

    public static BankAccount toBankAccountEntity(BankAccountDto bankAccountDto) {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setAccountNumber(bankAccountDto.getAccountNumber());
        bankAccount.setAccountType(bankAccountDto.getAccountType());
        bankAccount.setBalance(bankAccountDto.getBalance());
        bankAccount.setMinOrOverdueLimit(bankAccountDto.getMinOrOverdueLimit());
        return bankAccount;
    }

    public static Login toLoginEntity(LoginDto loginDto) {
        Login login = new Login();
        login.setLoginId(loginDto.getLoginId());
        login.setUsername(loginDto.getUsername());
        login.setPassword(loginDto.getPassword());
        login.setLoginType(loginDto.getLoginType());
        return login;
    }

    public static Transaction toTransactionEntity(TransactionDto transactionDto) {
        Transaction transaction = new Transaction();
        transaction.setTransactionId(transactionDto.getTransactionId());
        transaction.setAmmount(transactionDto.getAmmount());
        transaction.setTransactionType(transactionDto.getTransactionType());
        transaction.setDate(transactionDto.getDate());
        // TODO: You will need to set senderAccount and reciverAccount separately
        return transaction;
    }
}
