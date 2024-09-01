package com.aurionpro.bankRest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurionpro.bankRest.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long>{

}
