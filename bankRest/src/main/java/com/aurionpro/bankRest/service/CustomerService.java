package com.aurionpro.bankRest.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.aurionpro.bankRest.dto.CustomerDto;
import com.aurionpro.bankRest.dto.PageResponse;
import com.aurionpro.bankRest.entity.Customer;
import com.aurionpro.bankRest.repository.CustomerRepository;
import com.aurionpro.bankRest.utils.EntityToDtoConverter;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public CustomerDto createCustomer(Customer customer) {
        Customer savedCustomer = customerRepository.save(customer);
        return EntityToDtoConverter.toCustomerDto(savedCustomer);
    }

    public CustomerDto getCustomerById(int customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        return customer.map(EntityToDtoConverter::toCustomerDto).orElse(null);
    }

    public PageResponse<CustomerDto> getAllCustomers(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Customer> customerPage = customerRepository.findAll(pageRequest);

        List<CustomerDto> content = customerPage.getContent().stream()
                .map(EntityToDtoConverter::toCustomerDto)
                .collect(Collectors.toList());

        return new PageResponse<>(
                customerPage.getTotalPages(),
                customerPage.getSize(),
                customerPage.getTotalElements(),
                content,
                customerPage.isLast()
        );
    }

    public CustomerDto updateCustomer(int customerId, Customer updatedCustomer) {
        Optional<Customer> existingCustomer = customerRepository.findById(customerId);
        if (existingCustomer.isPresent()) {
            Customer customer = existingCustomer.get();
            customer.setFirstName(updatedCustomer.getFirstName());
            customer.setLastName(updatedCustomer.getLastName());
            customer.setEmail(updatedCustomer.getEmail());
            customer.setLogin(updatedCustomer.getLogin());
            customer.setBankAccount(updatedCustomer.getBankAccount());
            Customer savedCustomer = customerRepository.save(customer);
            return EntityToDtoConverter.toCustomerDto(savedCustomer);
        }
        return null;
    }

    public void deleteCustomer(int customerId) {
        customerRepository.deleteById(customerId);
    }
}
