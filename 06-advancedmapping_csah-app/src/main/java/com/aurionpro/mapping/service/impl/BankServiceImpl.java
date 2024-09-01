package com.aurionpro.mapping.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.aurionpro.mapping.dto.BankDTO;
import com.aurionpro.mapping.dto.PageResponse;
import com.aurionpro.mapping.entity.Bank;
import com.aurionpro.mapping.repository.BankRepository;
import com.aurionpro.mapping.service.BankService;
import com.aurionpro.mapping.util.EntityToDTOConverter;
import com.aurionpro.mapping.util.DTOToEntityConverter;

@Service
public class BankServiceImpl implements BankService {

    @Autowired
    private BankRepository bankRepository;

    @Override
    public List<BankDTO> getAllBanks() {
        return bankRepository.findAll().stream()
                .map(EntityToDTOConverter::convertToBankDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PageResponse<BankDTO> getBanks(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Bank> banksPage = bankRepository.findAll(pageable);
        List<BankDTO> content = banksPage.getContent().stream()
                .map(EntityToDTOConverter::convertToBankDTO)
                .collect(Collectors.toList());
        return new PageResponse<>(banksPage.getTotalPages(), banksPage.getSize(), banksPage.getTotalElements(), banksPage.isLast(), content);
    }

    @Override
    public BankDTO getBankById(int bankId) {
        return bankRepository.findById(bankId)
                .map(EntityToDTOConverter::convertToBankDTO)
                .orElse(null);
    }

    @Override
    public BankDTO saveBank(BankDTO bankDTO) {
        Bank bank = DTOToEntityConverter.convertToBank(bankDTO);
        return EntityToDTOConverter.convertToBankDTO(bankRepository.save(bank));
    }

    @Override
    public BankDTO updateBank(BankDTO bankDTO) {
        Bank bank = DTOToEntityConverter.convertToBank(bankDTO);
        return EntityToDTOConverter.convertToBankDTO(bankRepository.save(bank));
    }

    @Override
    public void deleteBank(int bankId) {
        bankRepository.deleteById(bankId);
    }
}
