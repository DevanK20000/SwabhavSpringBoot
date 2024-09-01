package com.aurionpro.bankRest.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aurionpro.bankRest.dto.BankAccountDto;
import com.aurionpro.bankRest.dto.CustomerDto;
import com.aurionpro.bankRest.dto.TransactionDto;
import com.aurionpro.bankRest.entity.BankAccount;
import com.aurionpro.bankRest.entity.Customer;
import com.aurionpro.bankRest.entity.Transaction;
import com.aurionpro.bankRest.entity.enums.AccountType;
import com.aurionpro.bankRest.entity.enums.TransactionType;
import com.aurionpro.bankRest.repository.BankAccountRepository;
import com.aurionpro.bankRest.repository.CustomerRepository;
import com.aurionpro.bankRest.repository.TransactionRepository;
import com.aurionpro.bankRest.utils.EntityToDtoConverter;

@Service
public class UserService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    public CustomerDto getCustomerById(int customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        return customer.map(EntityToDtoConverter::toCustomerDto).orElse(null);
    }

    public List<BankAccountDto> getCustomerBankAccounts(int customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        if (customer.isPresent()) {
            return customer.get().getBankAccount().stream()
                    .map(EntityToDtoConverter::toBankAccountDto)
                    .collect(Collectors.toList());
        }
        return null;
    }

    @Transactional
    public TransactionDto credit(Long accountNumber, Double amount) {
        Optional<BankAccount> bankAccountOpt = bankAccountRepository.findById(accountNumber);
        if (bankAccountOpt.isPresent()) {
            BankAccount bankAccount = bankAccountOpt.get();
            bankAccount.setBalance(bankAccount.getBalance() + amount);
            bankAccountRepository.save(bankAccount);

            Transaction transaction = new Transaction();
            transaction.setReciverAccount(bankAccount);
            transaction.setTransactionType(TransactionType.credit);
            transaction.setAmmount(amount);
            transaction.setSenderAccount(null); // Sender account is null for credit transactions

            Transaction savedTransaction = transactionRepository.save(transaction);
            return EntityToDtoConverter.toTransactionDto(savedTransaction);
        }
        throw new RuntimeException("Bank account not found");
    }

    @Transactional
    public TransactionDto debit(Long accountNumber, Double amount) {
        Optional<BankAccount> bankAccountOpt = bankAccountRepository.findById(accountNumber);
        if (bankAccountOpt.isPresent()) {
            BankAccount bankAccount = bankAccountOpt.get();
            AccountType accountType = bankAccount.getAccountType();
            double minOrOverdueLimit = bankAccount.getMinOrOverdueLimit();

            if (accountType == AccountType.saving) {
                if (bankAccount.getBalance() - amount < minOrOverdueLimit) {
                    throw new RuntimeException("Cannot debit below minimum account balance for salary account");
                }
            } else if (accountType == AccountType.current) {
                if (bankAccount.getBalance() - amount < -minOrOverdueLimit) {
                    throw new RuntimeException("Cannot exceed overdraft limit for current account");
                }
            }

            bankAccount.setBalance(bankAccount.getBalance() - amount);
            bankAccountRepository.save(bankAccount);

            Transaction transaction = new Transaction();
            transaction.setSenderAccount(bankAccount);
            transaction.setTransactionType(TransactionType.debit);
            transaction.setAmmount(amount);
            transaction.setReciverAccount(null); // Receiver account is null for debit transactions

            Transaction savedTransaction = transactionRepository.save(transaction);
            return EntityToDtoConverter.toTransactionDto(savedTransaction);
        }
        throw new RuntimeException("Bank account not found");
    }

    @Transactional
    public TransactionDto transfer(Long senderAccountNumber, Long receiverAccountNumber, Double amount) {
        // Perform debit operation on sender's account
        debit(senderAccountNumber, amount);

        // Perform credit operation on receiver's account
        credit(receiverAccountNumber, amount);

        // Create a new transaction to log the transfer
        Transaction transaction = new Transaction();
        transaction.setSenderAccount(bankAccountRepository.findById(senderAccountNumber).orElse(null));
        transaction.setReciverAccount(bankAccountRepository.findById(receiverAccountNumber).orElse(null));
        transaction.setTransactionType(TransactionType.transfer);
        transaction.setAmmount(amount);

        Transaction savedTransaction = transactionRepository.save(transaction);
        return EntityToDtoConverter.toTransactionDto(savedTransaction);
    }
}
