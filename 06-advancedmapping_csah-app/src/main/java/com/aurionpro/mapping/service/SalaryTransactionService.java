package com.aurionpro.mapping.service;

import java.util.List;
import com.aurionpro.mapping.dto.SalaryTransactionDTO;
import com.aurionpro.mapping.dto.PageResponse;

public interface SalaryTransactionService {
    List<SalaryTransactionDTO> getAllSalaryTransactions();
    PageResponse<SalaryTransactionDTO> getSalaryTransactions(int pageNo, int pageSize);
    SalaryTransactionDTO getSalaryTransactionById(int transactionId);
    SalaryTransactionDTO saveSalaryTransaction(SalaryTransactionDTO salaryTransactionDTO);
    SalaryTransactionDTO updateSalaryTransaction(SalaryTransactionDTO salaryTransactionDTO);
    void deleteSalaryTransaction(int transactionId);
}
