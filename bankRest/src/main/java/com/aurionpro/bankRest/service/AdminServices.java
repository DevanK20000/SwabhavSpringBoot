package com.aurionpro.bankRest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aurionpro.bankRest.dto.BankAccountDto;
import com.aurionpro.bankRest.dto.CustomerDto;
import com.aurionpro.bankRest.dto.LoginDto;
import com.aurionpro.bankRest.entity.BankAccount;
import com.aurionpro.bankRest.entity.Customer;
import com.aurionpro.bankRest.entity.Login;
import com.aurionpro.bankRest.repository.BankAccountRepository;
import com.aurionpro.bankRest.repository.CustomerRepository;
import com.aurionpro.bankRest.repository.LoginRepository;
import com.aurionpro.bankRest.utils.DtoToEntityConverter;
import com.aurionpro.bankRest.utils.EntityToDtoConverter;

@Service
public class AdminServices {

    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Transactional
    public CustomerDto addLogin(LoginDto loginDto, CustomerDto customerDto) {
        // Convert DTOs to entities
        Login login = DtoToEntityConverter.toLoginEntity(loginDto);

        // Save login entity
        Login savedLogin = loginRepository.save(login);

        // Convert CustomerDto to Customer entity and set the saved login
        Customer customer = DtoToEntityConverter.toCustomerEntity(customerDto);
        customer.setLogin(savedLogin);

        // Save customer entity
        Customer savedCustomer = customerRepository.save(customer);

        // Convert saved customer entity to DTO and return
        return EntityToDtoConverter.toCustomerDto(savedCustomer);
    }

    @Transactional
    public BankAccountDto addBankAccountToCustomer(int customerId, BankAccountDto bankAccountDto) {
        // Find the customer by ID
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        // Convert BankAccountDto to BankAccount entity
        BankAccount bankAccount = DtoToEntityConverter.toBankAccountEntity(bankAccountDto);
        bankAccount.setCustomer(customer);

        // Save bank account entity
        BankAccount savedBankAccount = bankAccountRepository.save(bankAccount);

        // Convert saved bank account entity to DTO and return
        return EntityToDtoConverter.toBankAccountDto(savedBankAccount);
    }
    
    
}
