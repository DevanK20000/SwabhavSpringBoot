package com.aurionpro.mapping.entity;

import java.sql.Date;

import com.aurionpro.mapping.entity.enums.SalaryStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "salary")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "salary_id")
    private Long salaryId;

    @Column(name = "salary_month")
    private String salaryMonth;

    @Column(name = "gross_salary")
    private Double grossSalary;

    @Column(name = "deductions")
    private Double deductions;

    @Column(name = "net_salary")
    private Double netSalary;

    @Column(name = "payment_date")
    private Date paymentDate;

    @Column(name = "status")
    private SalaryStatus status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "salary_transaction_id")
    private SalaryTransaction salaryTransaction;
}