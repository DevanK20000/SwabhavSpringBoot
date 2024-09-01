package com.aurionpro.bankRest.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.aurionpro.bankRest.dto.PageResponse;
import com.aurionpro.bankRest.dto.TransactionDto;
import com.aurionpro.bankRest.entity.Transaction;
import com.aurionpro.bankRest.repository.TransactionRepository;
import com.aurionpro.bankRest.utils.EntityToDtoConverter;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public TransactionDto createTransaction(Transaction transaction) {
        Transaction savedTransaction = transactionRepository.save(transaction);
        return EntityToDtoConverter.toTransactionDto(savedTransaction);
    }

    public TransactionDto getTransactionById(Long transactionId) {
        Optional<Transaction> transaction = transactionRepository.findById(transactionId);
        return transaction.map(EntityToDtoConverter::toTransactionDto).orElse(null);
    }

    public PageResponse<TransactionDto> getAllTransactions(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Transaction> transactionPage = transactionRepository.findAll(pageRequest);

        List<TransactionDto> content = transactionPage.getContent().stream()
                .map(EntityToDtoConverter::toTransactionDto)
                .collect(Collectors.toList());

        return new PageResponse<>(
                transactionPage.getTotalPages(),
                transactionPage.getSize(),
                transactionPage.getTotalElements(),
                content,
                transactionPage.isLast()
        );
    }

    public TransactionDto updateTransaction(Long transactionId, Transaction updatedTransaction) {
        Optional<Transaction> existingTransaction = transactionRepository.findById(transactionId);
        if (existingTransaction.isPresent()) {
            Transaction transaction = existingTransaction.get();
            transaction.setSenderAccount(updatedTransaction.getSenderAccount());
            transaction.setReciverAccount(updatedTransaction.getReciverAccount());
            transaction.setTransactionType(updatedTransaction.getTransactionType());
            transaction.setAmmount(updatedTransaction.getAmmount());
            Transaction savedTransaction = transactionRepository.save(transaction);
            return EntityToDtoConverter.toTransactionDto(savedTransaction);
        }
        return null;
    }

    public void deleteTransaction(Long transactionId) {
        transactionRepository.deleteById(transactionId);
    }
}
