package com.aurionpro.bankRest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.bankRest.dto.BankAccountDto;
import com.aurionpro.bankRest.dto.CustomerDto;
import com.aurionpro.bankRest.dto.LoginDto;
import com.aurionpro.bankRest.service.AdminServices;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminServices adminServices;

    @PostMapping("/addLogin")
    public CustomerDto addLogin(@RequestBody LoginDto loginDto, @RequestBody CustomerDto customerDto) {
        return adminServices.addLogin(loginDto, customerDto);
    }

    @PostMapping("/customers/{customerId}/bankAccounts")
    public BankAccountDto addBankAccountToCustomer(@PathVariable int customerId, @RequestBody BankAccountDto bankAccountDto) {
        return adminServices.addBankAccountToCustomer(customerId, bankAccountDto);
    }
}
