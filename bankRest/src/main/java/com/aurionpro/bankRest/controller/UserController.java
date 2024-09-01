package com.aurionpro.bankRest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.bankRest.dto.BankAccountDto;
import com.aurionpro.bankRest.dto.CustomerDto;
import com.aurionpro.bankRest.dto.TransactionDto;
import com.aurionpro.bankRest.service.UserService;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users/{customerId}")
    public CustomerDto getCustomerById(@PathVariable int customerId) {
        return userService.getCustomerById(customerId);
    }

    @GetMapping("/users/{customerId}/bankAccounts")
    public List<BankAccountDto> getCustomerBankAccounts(@PathVariable int customerId) {
        return userService.getCustomerBankAccounts(customerId);
    }

    @PostMapping("/users/{accountNumber}/credit")
    public TransactionDto credit(@PathVariable Long accountNumber, @RequestParam Double amount) {
        return userService.credit(accountNumber, amount);
    }

    @PostMapping("/users/{accountNumber}/debit")
    public TransactionDto debit(@PathVariable Long accountNumber, @RequestParam Double amount) {
        return userService.debit(accountNumber, amount);
    }

    @PostMapping("/users/transfer")
    public TransactionDto transfer(@RequestParam Long senderAccountNumber, @RequestParam Long receiverAccountNumber, @RequestParam Double amount) {
        return userService.transfer(senderAccountNumber, receiverAccountNumber, amount);
    }
}
