package com.aurionpro.mapping.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.aurionpro.mapping.dto.BankDTO;
import com.aurionpro.mapping.dto.PageResponse;
import com.aurionpro.mapping.service.BankService;

@RestController
@RequestMapping("/api/banks")
public class BankController {

    @Autowired
    private BankService bankService;

    @GetMapping
    public List<BankDTO> getAllBanks() {
        return bankService.getAllBanks();
    }

    @GetMapping("/page")
    public PageResponse<BankDTO> getBanks(@RequestParam int pageNo, @RequestParam int pageSize) {
        return bankService.getBanks(pageNo, pageSize);
    }

    @GetMapping("/{id}")
    public BankDTO getBankById(@PathVariable int id) {
        return bankService.getBankById(id);
    }

    @PostMapping
    public BankDTO saveBank(@RequestBody BankDTO bankDTO) {
        return bankService.saveBank(bankDTO);
    }

    @PutMapping
    public BankDTO updateBank(@RequestBody BankDTO bankDTO) {
        return bankService.updateBank(bankDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteBank(@PathVariable int id) {
        bankService.deleteBank(id);
    }
}
