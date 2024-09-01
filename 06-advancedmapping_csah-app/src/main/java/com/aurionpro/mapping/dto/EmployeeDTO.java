package com.aurionpro.mapping.dto;

import java.sql.Date;
import com.aurionpro.mapping.entity.enums.EmployeeStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private int employeeId;
    private String firstName;
    private String lastName;
    private Long phoneNumber;
    private String email;
    private String position;
    private Date hireDate;
    private Double salary;
    private SalaryAccountDTO salaryAccount;
    private Long bankIfscNumber;
    private EmployeeStatus employeeStatus;

    @JsonBackReference
    private ClientDTO client;
}
