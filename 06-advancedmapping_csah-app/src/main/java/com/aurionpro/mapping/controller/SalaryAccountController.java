package com.aurionpro.mapping.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.aurionpro.mapping.dto.SalaryAccountDTO;
import com.aurionpro.mapping.dto.PageResponse;
import com.aurionpro.mapping.service.SalaryAccountService;

@RestController
@RequestMapping("/api/salaryaccounts")
public class SalaryAccountController {

    @Autowired
    private SalaryAccountService salaryAccountService;

    @GetMapping
    public List<SalaryAccountDTO> getAllSalaryAccounts() {
        return salaryAccountService.getAllSalaryAccounts();
    }

    @GetMapping("/page")
    public PageResponse<SalaryAccountDTO> getSalaryAccounts(@RequestParam int pageNo, @RequestParam int pageSize) {
        return salaryAccountService.getSalaryAccounts(pageNo, pageSize);
    }

    @GetMapping("/{id}")
    public SalaryAccountDTO getSalaryAccountById(@PathVariable Long id) {
        return salaryAccountService.getSalaryAccountById(id);
    }

    @PostMapping
    public SalaryAccountDTO saveSalaryAccount(@RequestBody SalaryAccountDTO salaryAccountDTO) {
        return salaryAccountService.saveSalaryAccount(salaryAccountDTO);
    }

    @PutMapping
    public SalaryAccountDTO updateSalaryAccount(@RequestBody SalaryAccountDTO salaryAccountDTO) {
        return salaryAccountService.updateSalaryAccount(salaryAccountDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteSalaryAccount(@PathVariable Long id) {
        salaryAccountService.deleteSalaryAccount(id);
    }
}
