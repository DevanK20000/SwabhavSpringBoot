package com.aurionpro.mapping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.mapping.dto.PageRespose;
import com.aurionpro.mapping.dto.SalaryResponse;
import com.aurionpro.mapping.entity.Salary;
import com.aurionpro.mapping.entity.SalaryTransaction;
import com.aurionpro.mapping.service.SalaryService;

@RestController
@RequestMapping("salaryapp")
public class SalaryController {

    @Autowired
    private SalaryService salaryService;

    @GetMapping
    public ResponseEntity<PageRespose<SalaryResponse>> getAllSalaries(
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "10") int pageSize) {
        PageRespose<SalaryResponse> salaries = salaryService.getAllSalary(pageNo, pageSize);
        return ResponseEntity.ok(salaries);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SalaryResponse> getSalaryById(@PathVariable Integer id) {
        SalaryResponse salary = salaryService.getSalaryById(id);
        return salary != null ? ResponseEntity.ok(salary) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Salary> addSalary(@RequestBody Salary salary) {
        Salary newSalary = salaryService.addSalary(salary);
        return ResponseEntity.ok(newSalary);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Salary> updateSalary(@PathVariable Integer id, @RequestBody Salary salary) {
        salary.setSalaryId(id.longValue());
        Salary updatedSalary = salaryService.updateSalary(salary);
        return ResponseEntity.ok(updatedSalary);
    }

    @DeleteMapping("/{id}")
    public String deleteSalary(@PathVariable Integer id) {
    	salaryService.deleteSalary(id);
      return "deleted";
    }

    @GetMapping("/{id}/transactions")
    public ResponseEntity<SalaryTransaction> getSalaryTransactionBySalaryId(@PathVariable Integer id) {
        SalaryTransaction transaction = salaryService.getSalaryTransactionBySalaryId(id);
        return transaction != null ? ResponseEntity.ok(transaction) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}/transactions")
    public ResponseEntity<Salary> updateSalaryTransactionBySalaryId(@PathVariable Integer id, @RequestBody SalaryTransaction salaryTransaction) {
        Salary updatedSalary = salaryService.updateSalaryTransactionBySalaryId(id, salaryTransaction);
        return updatedSalary != null ? ResponseEntity.ok(updatedSalary) : ResponseEntity.notFound().build();
    }
}
