package com.aurionpro.mapping.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.aurionpro.mapping.dto.SalaryDTO;
import com.aurionpro.mapping.dto.PageResponse;
import com.aurionpro.mapping.entity.Salary;
import com.aurionpro.mapping.repository.SalaryRepository;
import com.aurionpro.mapping.service.SalaryService;
import com.aurionpro.mapping.util.EntityToDTOConverter;
import com.aurionpro.mapping.util.DTOToEntityConverter;

@Service
public class SalaryServiceImpl implements SalaryService {

    @Autowired
    private SalaryRepository salaryRepository;

    @Override
    public List<SalaryDTO> getAllSalaries() {
        return salaryRepository.findAll().stream()
                .map(EntityToDTOConverter::convertToSalaryDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PageResponse<SalaryDTO> getSalaries(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Salary> salariesPage = salaryRepository.findAll(pageable);
        List<SalaryDTO> content = salariesPage.getContent().stream()
                .map(EntityToDTOConverter::convertToSalaryDTO)
                .collect(Collectors.toList());
        return new PageResponse<>(salariesPage.getTotalPages(), salariesPage.getSize(), salariesPage.getTotalElements(), salariesPage.isLast(), content);
    }

    @Override
    public SalaryDTO getSalaryById(int salaryId) {
        return salaryRepository.findById(salaryId)
                .map(EntityToDTOConverter::convertToSalaryDTO)
                .orElse(null);
    }

    @Override
    public SalaryDTO saveSalary(SalaryDTO salaryDTO) {
        Salary salary = DTOToEntityConverter.convertToSalary(salaryDTO);
        return EntityToDTOConverter.convertToSalaryDTO(salaryRepository.save(salary));
    }

    @Override
    public SalaryDTO updateSalary(SalaryDTO salaryDTO) {
        Salary salary = DTOToEntityConverter.convertToSalary(salaryDTO);
        return EntityToDTOConverter.convertToSalaryDTO(salaryRepository.save(salary));
    }

    @Override
    public void deleteSalary(int salaryId) {
        salaryRepository.deleteById(salaryId);
    }
}
