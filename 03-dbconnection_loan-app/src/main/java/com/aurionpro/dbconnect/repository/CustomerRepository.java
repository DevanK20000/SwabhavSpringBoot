package com.aurionpro.dbconnect.repository;

import java.util.List;

import com.aurionpro.dbconnect.entity.Customer;

public interface CustomerRepository {
	List<Customer> getAllCustomers();
	void addCustomer(Customer customer);
	Customer getCustomer(Integer cutomerId);
	void updateCustomer(Customer customer);
	void deleteCustomer(Integer customerId);
}
