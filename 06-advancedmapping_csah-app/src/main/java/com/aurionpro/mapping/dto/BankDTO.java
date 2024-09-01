package com.aurionpro.mapping.dto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankDTO {
    private int bankId;
    private String bankName;
    private String ifsco;

    @JsonManagedReference
    private List<SalaryAccountDTO> salaryAccounts;
}
