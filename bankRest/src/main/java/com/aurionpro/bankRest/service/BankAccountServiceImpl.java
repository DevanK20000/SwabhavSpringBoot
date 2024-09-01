package com.aurionpro.bankRest.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.aurionpro.bankRest.dto.BankAccountDto;
import com.aurionpro.bankRest.dto.PageResponse;
import com.aurionpro.bankRest.entity.BankAccount;
import com.aurionpro.bankRest.repository.BankAccountRepository;
import com.aurionpro.bankRest.utils.EntityToDtoConverter;

@Service
public class BankAccountServiceImpl {

    @Autowired
    private BankAccountRepository bankAccountRepository;

    public BankAccountDto createBankAccount(BankAccount bankAccount) {
        BankAccount savedAccount = bankAccountRepository.save(bankAccount);
        return EntityToDtoConverter.toBankAccountDto(savedAccount);
    }

    public BankAccountDto getBankAccountById(Long accountNumber) {
        Optional<BankAccount> bankAccount = bankAccountRepository.findById(accountNumber);
        return bankAccount.map(EntityToDtoConverter::toBankAccountDto).orElse(null);
    }

    public List<BankAccountDto> getAllBankAccounts() {
        List<BankAccount> bankAccounts = bankAccountRepository.findAll();
        return bankAccounts.stream()
                .map(EntityToDtoConverter::toBankAccountDto)
                .toList();
    }
    
    public PageResponse<BankAccountDto> getAllBankAccounts(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<BankAccount> bankAccountPage = bankAccountRepository.findAll(pageable);

        List<BankAccountDto> content = bankAccountPage.getContent().stream()
                .map(EntityToDtoConverter::toBankAccountDto)
                .collect(Collectors.toList());

        return new PageResponse<BankAccountDto>(
                bankAccountPage.getTotalPages(),
                bankAccountPage.getSize(),
                bankAccountPage.getTotalElements(),
                content,
                bankAccountPage.isLast()
        );
    }

    public BankAccountDto updateBankAccount(Long accountNumber, BankAccount updatedAccount) {
        Optional<BankAccount> existingAccount = bankAccountRepository.findById(accountNumber);
        if (existingAccount.isPresent()) {
            BankAccount account = existingAccount.get();
            account.setAccountType(updatedAccount.getAccountType());
            account.setBalance(updatedAccount.getBalance());
            account.setMinOrOverdueLimit(updatedAccount.getMinOrOverdueLimit());
            account.setCustomer(updatedAccount.getCustomer());
            BankAccount savedAccount = bankAccountRepository.save(account);
            return EntityToDtoConverter.toBankAccountDto(savedAccount);
        }
        return null;
    }

    public void deleteBankAccount(Long accountNumber) {
        bankAccountRepository.deleteById(accountNumber);
    }
}
