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
    @Column
    private Long salaryId;

    @Column
    private String salaryMonth;

    @Column
    private Double grossSalary;

    @Column
    private Double deductions;

    @Column
    private Double netSalary;

    @Column
    private Date paymentDate;

    @Column
    private SalaryStatus status;
}