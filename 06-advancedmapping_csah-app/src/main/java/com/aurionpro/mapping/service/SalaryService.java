package com.aurionpro.mapping.service;

import java.util.List;
import com.aurionpro.mapping.dto.SalaryDTO;
import com.aurionpro.mapping.dto.PageResponse;

public interface SalaryService {
    List<SalaryDTO> getAllSalaries();
    PageResponse<SalaryDTO> getSalaries(int pageNo, int pageSize);
    SalaryDTO getSalaryById(int salaryId);
    SalaryDTO saveSalary(SalaryDTO salaryDTO);
    SalaryDTO updateSalary(SalaryDTO salaryDTO);
    void deleteSalary(int salaryId);
}
