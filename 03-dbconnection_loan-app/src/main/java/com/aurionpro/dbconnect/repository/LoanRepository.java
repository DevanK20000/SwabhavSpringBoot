package com.aurionpro.dbconnect.repository;

import java.util.List;

import com.aurionpro.dbconnect.entity.Loan;

public interface LoanRepository {
	List<Loan> getAllLoans();
    void addLoan(Loan loan);
    Loan getLoan(Integer loanId);
    void updateLoan(Loan loan);
    void deleteLoan(Integer loanId);
}
