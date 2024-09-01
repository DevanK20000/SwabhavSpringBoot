package com.aurionpro.dbconnect.service;

import java.util.List;

import com.aurionpro.dbconnect.entity.Loan;

public interface LoanService {
    List<Loan> getAllLoans();
    void addLoan(Loan loan);
    Loan getLoan(Integer loanId);
    void updateLoan(Loan loan);
    void deleteLoan(Integer loanId);
}
