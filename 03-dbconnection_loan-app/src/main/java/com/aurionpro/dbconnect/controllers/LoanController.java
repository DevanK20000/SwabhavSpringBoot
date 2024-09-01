package com.aurionpro.dbconnect.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.aurionpro.dbconnect.entity.Loan;
import com.aurionpro.dbconnect.service.LoanService;

import java.util.List;

@RestController
@RequestMapping("loanapp")
public class LoanController {

 @Autowired
 private LoanService loanService;

 @GetMapping("loans")
 public ResponseEntity<List<Loan>> getAllLoans() {
     List<Loan> loans = loanService.getAllLoans();
     return new ResponseEntity<>(loans, HttpStatus.OK);
 }

 @PostMapping("loans")
 public String addLoan(@RequestBody Loan loan) {
     loanService.addLoan(loan);
     return "Loan added";
 }

 @GetMapping("loans/{id}")
 public ResponseEntity<Loan> getLoan(@PathVariable("id") Integer loanId) {
     Loan loan = loanService.getLoan(loanId);
     return new ResponseEntity<>(loan, HttpStatus.OK);
 }

 @PutMapping("loans")
 public String updateLoan(@RequestBody Loan loan) {
     loanService.updateLoan(loan);
     return "Loan updated";
 }

 @DeleteMapping("loans/{id}")
 public String deleteLoan(@PathVariable("id") Integer loanId) {
     loanService.deleteLoan(loanId);
     return "Loan deleted";
 }
}
