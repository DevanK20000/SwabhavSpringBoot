package com.aurionpro.bankRest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurionpro.bankRest.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
