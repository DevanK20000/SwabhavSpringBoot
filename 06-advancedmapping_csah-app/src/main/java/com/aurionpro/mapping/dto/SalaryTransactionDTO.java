package com.aurionpro.mapping.dto;

import java.sql.Date;
import com.aurionpro.mapping.entity.enums.SalaryTransactionStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalaryTransactionDTO {
    private Long transactionId;
    private Date transactionDate;
    private Double amount;
    private SalaryTransactionStatus status;
    private SalaryDTO salary;

    @JsonBackReference
    private SalaryAccountDTO salaryAccount;
}
