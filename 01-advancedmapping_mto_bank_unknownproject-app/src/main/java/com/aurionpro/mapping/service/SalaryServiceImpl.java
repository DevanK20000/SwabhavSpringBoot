package com.aurionpro.mapping.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.aurionpro.mapping.dto.PageRespose;
import com.aurionpro.mapping.dto.SalaryResponse;
import com.aurionpro.mapping.entity.Salary;
import com.aurionpro.mapping.entity.SalaryTransaction;
import com.aurionpro.mapping.repository.SalaryRepository;

@Service
public class SalaryServiceImpl implements SalaryService {

    @Autowired
    private SalaryRepository salaryRepository;

    @Override
    public PageRespose<SalaryResponse> getAllSalary(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Salary> salaryPage = salaryRepository.findAll(pageable);
        List<SalaryResponse> salaryResponses = salaryPage.getContent().stream()
                .map(this::convertToResponse)
                .toList();
        return new PageRespose<>(
        			salaryPage.getTotalPages(),
        			salaryPage.getSize(),
        			salaryPage.getTotalElements(),
        			salaryResponses,
        			salaryPage.isLast()
        		);
    }

    @Override
    public SalaryResponse getSalaryById(Integer salaryId) {
        Optional<Salary> salary = salaryRepository.findById(salaryId);
        return salary.map(this::convertToResponse).orElse(null);
    }

    @Override
    public Salary addSalary(Salary salary) {
        return salaryRepository.save(salary);
    }

    @Override
    public Salary updateSalary(Salary salary) {
        return salaryRepository.save(salary);
    }

    @Override
    public void deleteSalary(Integer salaryId) {
        salaryRepository.deleteById(salaryId);
    }

    @Override
    public SalaryTransaction getSalaryTransactionBySalaryId(Integer salaryId) {
        Optional<Salary> salary = salaryRepository.findById(salaryId);
        return salary.map(Salary::getSalaryTransaction).orElse(null);
    }

    @Override
    public Salary updateSalaryTransactionBySalaryId(Integer salaryId, SalaryTransaction salaryTransaction) {
        Optional<Salary> salary = salaryRepository.findById(salaryId);
        if (salary.isPresent()) {
            Salary existingSalary = salary.get();
            existingSalary.setSalaryTransaction(salaryTransaction);
            salaryRepository.save(existingSalary);
            return existingSalary;
        }
        return null;
    }

    private SalaryResponse convertToResponse(Salary salary) {
        // Convert Salary entity to SalaryResponse DTO
        return new SalaryResponse(salary.getSalaryId(), salary.getSalaryMonth(), salary.getGrossSalary(),
                salary.getDeductions(), salary.getNetSalary(), salary.getPaymentDate(), salary.getStatus());
    }
}
