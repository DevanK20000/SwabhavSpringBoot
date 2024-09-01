package com.aurionpro.mapping.service;

import java.util.List;
import com.aurionpro.mapping.dto.SalaryAccountDTO;
import com.aurionpro.mapping.dto.PageResponse;

public interface SalaryAccountService {
    List<SalaryAccountDTO> getAllSalaryAccounts();
    PageResponse<SalaryAccountDTO> getSalaryAccounts(int pageNo, int pageSize);
    SalaryAccountDTO getSalaryAccountById(Long accountNumber);
    SalaryAccountDTO saveSalaryAccount(SalaryAccountDTO salaryAccountDTO);
    SalaryAccountDTO updateSalaryAccount(SalaryAccountDTO salaryAccountDTO);
    void deleteSalaryAccount(Long accountNumber);
}
