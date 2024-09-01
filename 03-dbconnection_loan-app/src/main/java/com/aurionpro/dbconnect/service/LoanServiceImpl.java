package com.aurionpro.dbconnect.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurionpro.dbconnect.entity.Loan;
import com.aurionpro.dbconnect.repository.LoanRepository;

@Service
public class LoanServiceImpl implements LoanService {

	   @Autowired
	    private LoanRepository loanRepository;

	    public List<Loan> getAllLoans() {
	        return loanRepository.getAllLoans();
	    }

	    public void addLoan(Loan loan) {
	        loanRepository.addLoan(loan);
	    }

	    public Loan getLoan(Integer loanId) {
	        return loanRepository.getLoan(loanId);
	    }

	    public void updateLoan(Loan loan) {
	        loanRepository.updateLoan(loan);
	    }

	    public void deleteLoan(Integer loanId) {
	        loanRepository.deleteLoan(loanId);
	    }
}
