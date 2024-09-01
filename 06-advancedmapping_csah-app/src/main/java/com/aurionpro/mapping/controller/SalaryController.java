package com.aurionpro.mapping.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.aurionpro.mapping.dto.SalaryDTO;
import com.aurionpro.mapping.dto.PageResponse;
import com.aurionpro.mapping.service.SalaryService;

@RestController
@RequestMapping("/api/salaries")
public class SalaryController {

    @Autowired
    private SalaryService salaryService;

    @GetMapping
    public List<SalaryDTO> getAllSalaries() {
        return salaryService.getAllSalaries();
    }

    @GetMapping("/page")
    public PageResponse<SalaryDTO> getSalaries(@RequestParam int pageNo, @RequestParam int pageSize) {
        return salaryService.getSalaries(pageNo, pageSize);
    }

    @GetMapping("/{id}")
    public SalaryDTO getSalaryById(@PathVariable int id) {
        return salaryService.getSalaryById(id);
    }

    @PostMapping
    public SalaryDTO saveSalary(@RequestBody SalaryDTO salaryDTO) {
        return salaryService.saveSalary(salaryDTO);
    }

    @PutMapping
    public SalaryDTO updateSalary(@RequestBody SalaryDTO salaryDTO) {
        return salaryService.updateSalary(salaryDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteSalary(@PathVariable int id) {
        salaryService.deleteSalary(id);
    }
}
