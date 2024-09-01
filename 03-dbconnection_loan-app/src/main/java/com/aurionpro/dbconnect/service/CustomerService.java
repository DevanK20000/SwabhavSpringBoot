package com.aurionpro.dbconnect.service;

import java.util.List;

import com.aurionpro.dbconnect.entity.Customer;

public interface CustomerService {
	void addCustomer(Customer customer);
	List<Customer> getAllCustomers();
	Customer getCustomer(Integer customerId);
	void updateCustomer(Customer customer);
	void deleteCustomer(Integer customerId);
}
