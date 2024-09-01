package com.aurionpro.mapping.dto;

import java.sql.Date;
import com.aurionpro.mapping.entity.enums.SalaryStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalaryDTO {
    private Long salaryId;
    private String salaryMonth;
    private Double grossSalary;
    private Double deductions;
    private Double netSalary;
    private Date paymentDate;
    private SalaryStatus status;
}
