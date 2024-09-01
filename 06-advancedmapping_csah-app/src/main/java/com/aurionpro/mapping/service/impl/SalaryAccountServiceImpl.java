package com.aurionpro.mapping.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.aurionpro.mapping.dto.SalaryAccountDTO;
import com.aurionpro.mapping.dto.PageResponse;
import com.aurionpro.mapping.entity.SalaryAccount;
import com.aurionpro.mapping.repository.SalaryAccountRepository;
import com.aurionpro.mapping.service.SalaryAccountService;
import com.aurionpro.mapping.util.EntityToDTOConverter;
import com.aurionpro.mapping.util.DTOToEntityConverter;

@Service
public class SalaryAccountServiceImpl implements SalaryAccountService {

    @Autowired
    private SalaryAccountRepository salaryAccountRepository;

    @Override
    public List<SalaryAccountDTO> getAllSalaryAccounts() {
        return salaryAccountRepository.findAll().stream()
                .map(EntityToDTOConverter::convertToSalaryAccountDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PageResponse<SalaryAccountDTO> getSalaryAccounts(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<SalaryAccount> salaryAccountsPage = salaryAccountRepository.findAll(pageable);
        List<SalaryAccountDTO> content = salaryAccountsPage.getContent().stream()
                .map(EntityToDTOConverter::convertToSalaryAccountDTO)
                .collect(Collectors.toList());
        return new PageResponse<>(salaryAccountsPage.getTotalPages(), salaryAccountsPage.getSize(), salaryAccountsPage.getTotalElements(), salaryAccountsPage.isLast(), content);
    }

    @Override
    public SalaryAccountDTO getSalaryAccountById(Long accountNumber) {
        return salaryAccountRepository.findById(accountNumber)
                .map(EntityToDTOConverter::convertToSalaryAccountDTO)
                .orElse(null);
    }

    @Override
    public SalaryAccountDTO saveSalaryAccount(SalaryAccountDTO salaryAccountDTO) {
        SalaryAccount salaryAccount = DTOToEntityConverter.convertToSalaryAccount(salaryAccountDTO);
        return EntityToDTOConverter.convertToSalaryAccountDTO(salaryAccountRepository.save(salaryAccount));
    }

    @Override
    public SalaryAccountDTO updateSalaryAccount(SalaryAccountDTO salaryAccountDTO) {
        SalaryAccount salaryAccount = DTOToEntityConverter.convertToSalaryAccount(salaryAccountDTO);
        return EntityToDTOConverter.convertToSalaryAccountDTO(salaryAccountRepository.save(salaryAccount));
    }

    @Override
    public void deleteSalaryAccount(Long accountNumber) {
        salaryAccountRepository.deleteById(accountNumber);
    }
}
