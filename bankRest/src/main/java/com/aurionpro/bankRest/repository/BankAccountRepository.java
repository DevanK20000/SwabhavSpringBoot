package com.aurionpro.bankRest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurionpro.bankRest.entity.BankAccount;

public interface BankAccountRepository extends JpaRepository<BankAccount, Long>{

}
