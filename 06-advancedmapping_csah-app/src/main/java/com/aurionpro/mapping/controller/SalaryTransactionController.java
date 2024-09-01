package com.aurionpro.mapping.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.aurionpro.mapping.dto.SalaryTransactionDTO;
import com.aurionpro.mapping.dto.PageResponse;
import com.aurionpro.mapping.service.SalaryTransactionService;

@RestController
@RequestMapping("/api/salarytransactions")
public class SalaryTransactionController {

    @Autowired
    private SalaryTransactionService salaryTransactionService;

    @GetMapping
    public List<SalaryTransactionDTO> getAllSalaryTransactions() {
        return salaryTransactionService.getAllSalaryTransactions();
    }

    @GetMapping("/page")
    public PageResponse<SalaryTransactionDTO> getSalaryTransactions(@RequestParam int pageNo, @RequestParam int pageSize) {
        return salaryTransactionService.getSalaryTransactions(pageNo, pageSize);
    }

    @GetMapping("/{id}")
    public SalaryTransactionDTO getSalaryTransactionById(@PathVariable int id) {
        return salaryTransactionService.getSalaryTransactionById(id);
    }

    @PostMapping
    public SalaryTransactionDTO saveSalaryTransaction(@RequestBody SalaryTransactionDTO salaryTransactionDTO) {
        return salaryTransactionService.saveSalaryTransaction(salaryTransactionDTO);
    }

    @PutMapping
    public SalaryTransactionDTO updateSalaryTransaction(@RequestBody SalaryTransactionDTO salaryTransactionDTO) {
        return salaryTransactionService.updateSalaryTransaction(salaryTransactionDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteSalaryTransaction(@PathVariable int id) {
        salaryTransactionService.deleteSalaryTransaction(id);
    }
}
