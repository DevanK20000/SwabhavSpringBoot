package com.aurionpro.dbconnect.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.aurionpro.dbconnect.entity.Customer;
import com.aurionpro.dbconnect.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("customerapp")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("customers")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @PostMapping("customers")
    public String addCustomer(@RequestBody Customer customer) {
        customerService.addCustomer(customer);
        return "customer added";
    }

    @GetMapping("customers/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable("id") Integer customerId) {
        Customer customer = customerService.getCustomer(customerId);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PutMapping("customers")
    public String updateCustomer(@RequestBody Customer customer) {
        customerService.updateCustomer(customer);
        return "Customers updated";
    }

    @DeleteMapping("customers/{id}")
    public String deleteCustomer(@PathVariable("id") Integer customerId) {
        customerService.deleteCustomer(customerId);
        return "deleted";
    }
}
