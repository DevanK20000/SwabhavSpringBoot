package com.aurionpro.mapping.service;

import java.util.List;
import com.aurionpro.mapping.dto.BankDTO;
import com.aurionpro.mapping.dto.PageResponse;

public interface BankService {
    List<BankDTO> getAllBanks();
    PageResponse<BankDTO> getBanks(int pageNo, int pageSize);
    BankDTO getBankById(int bankId);
    BankDTO saveBank(BankDTO bankDTO);
    BankDTO updateBank(BankDTO bankDTO);
    void deleteBank(int bankId);
}
