package com.aurionpro.mapping.dto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalaryAccountDTO {
    private Long accountNumber;
    private String accountHolderName;

    @JsonManagedReference
    private List<SalaryTransactionDTO> salaryTransactions;

    @JsonBackReference
    private BankDTO bank;
}
