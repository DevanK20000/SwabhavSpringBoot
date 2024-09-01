package com.aurionpro.dbconnect.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aurionpro.dbconnect.entity.Loan;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class LoanRepositoryImpl implements LoanRepository {

	@Autowired
    private EntityManager entityManager;

    @Override
    public List<Loan> getAllLoans() {
        return entityManager.createQuery("SELECT l FROM Loan l", Loan.class).getResultList();
    }

    @Override
    @Transactional
    public void addLoan(Loan loan) {
        entityManager.persist(loan);
    }

    @Override
    public Loan getLoan(Integer loanId) {
        return entityManager.find(Loan.class, loanId);
    }

    @Override
    @Transactional
    public void updateLoan(Loan loan) {
        entityManager.merge(loan);
    }

    @Override
    @Transactional
    public void deleteLoan(Integer loanId) {
    	 Loan loan = entityManager.find(Loan.class, loanId);
         if (loan != null) {
             entityManager.remove(loan);
         }
    }
}
