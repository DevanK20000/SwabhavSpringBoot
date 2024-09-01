package com.aurionpro.dbconnect.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aurionpro.dbconnect.entity.Customer;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

	  	@Autowired
	    private EntityManager entityManager;

	    @Override
	    public List<Customer> getAllCustomers() {
	        return entityManager.createQuery("SELECT c FROM Customer c", Customer.class).getResultList();
	    }

	    @Override
	    @Transactional
	    public void addCustomer(Customer customer) {
	        entityManager.persist(customer);
	    }

	    @Override
	    public Customer getCustomer(Integer customerId) {
	        return entityManager.find(Customer.class, customerId);
	    }

	    @Override
	    @Transactional
	    public void updateCustomer(Customer customer) {
	        entityManager.merge(customer);
	    }

	    @Override
	    @Transactional
	    public void deleteCustomer(Integer customerId) {
	    	 Customer customer = entityManager.find(Customer.class, customerId);
	    	    if (customer != null) {
	    	        entityManager.remove(customer);
	    	    }
	    }
}
