package com.aurionpro.mapping.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.aurionpro.mapping.dto.SalaryTransactionDTO;
import com.aurionpro.mapping.dto.PageResponse;
import com.aurionpro.mapping.entity.SalaryTransaction;
import com.aurionpro.mapping.repository.SalaryTransactionRepository;
import com.aurionpro.mapping.service.SalaryTransactionService;
import com.aurionpro.mapping.util.EntityToDTOConverter;
import com.aurionpro.mapping.util.DTOToEntityConverter;

@Service
public class SalaryTransactionServiceImpl implements SalaryTransactionService {

    @Autowired
    private SalaryTransactionRepository salaryTransactionRepository;

    @Override
    public List<SalaryTransactionDTO> getAllSalaryTransactions() {
        return salaryTransactionRepository.findAll().stream()
                .map(EntityToDTOConverter::convertToSalaryTransactionDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PageResponse<SalaryTransactionDTO> getSalaryTransactions(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<SalaryTransaction> salaryTransactionsPage = salaryTransactionRepository.findAll(pageable);
        List<SalaryTransactionDTO> content = salaryTransactionsPage.getContent().stream()
                .map(EntityToDTOConverter::convertToSalaryTransactionDTO)
                .collect(Collectors.toList());
        return new PageResponse<>(salaryTransactionsPage.getTotalPages(), salaryTransactionsPage.getSize(), salaryTransactionsPage.getTotalElements(), salaryTransactionsPage.isLast(), content);
    }

    @Override
    public SalaryTransactionDTO getSalaryTransactionById(int transactionId) {
        return salaryTransactionRepository.findById(transactionId)
                .map(EntityToDTOConverter::convertToSalaryTransactionDTO)
                .orElse(null);
    }

    @Override
    public SalaryTransactionDTO saveSalaryTransaction(SalaryTransactionDTO salaryTransactionDTO) {
        SalaryTransaction salaryTransaction = DTOToEntityConverter.convertToSalaryTransaction(salaryTransactionDTO);
        return EntityToDTOConverter.convertToSalaryTransactionDTO(salaryTransactionRepository.save(salaryTransaction));
    }

    @Override
    public SalaryTransactionDTO updateSalaryTransaction(SalaryTransactionDTO salaryTransactionDTO) {
        SalaryTransaction salaryTransaction = DTOToEntityConverter.convertToSalaryTransaction(salaryTransactionDTO);
        return EntityToDTOConverter.convertToSalaryTransactionDTO(salaryTransactionRepository.save(salaryTransaction));
    }

    @Override
    public void deleteSalaryTransaction(int transactionId) {
        salaryTransactionRepository.deleteById(transactionId);
    }
}
