package com.aurionpro.mapping.entity;

import java.sql.Date;

import com.aurionpro.mapping.entity.enums.EmployeeStatus;

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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="employees")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employeeid")
	private int employeeId;

	@Column(name="firstname")
	private String firstName;

	@Column(name="lastname")
	private String lastName;

	@Column(name="phonenumber")
	private Long phoneNumber;

	@Column(name="email")
	private String email;

	@Column(name="position")
	private String position;

	@Column(name="hiredate")
	private Date hireDate;

	@Column(name="salary")
	private Double salary;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "accountNumber")
	private SalaryAccount salaryAccount;

	@Column(name="bankifscNumber")
	private Long bankIfscNumber;

	@Column(name = "status")
	private EmployeeStatus employeeStatus;
}
