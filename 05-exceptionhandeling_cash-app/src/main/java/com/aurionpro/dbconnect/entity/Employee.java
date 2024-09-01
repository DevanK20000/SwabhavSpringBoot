package com.aurionpro.dbconnect.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
	
	@NotBlank(message = "mandatory")
	@NotNull(message = "mandatory")
	@Column(name="firstname")
	private String firstName;
	
	@NotBlank(message = "mandatory")
	@NotNull(message = "mandatory")
	@Column(name="lastname")
	private String lastName;
	
	@NotBlank(message = "mandatory")
	@NotNull(message = "mandatory")
	@Column(name="phonenumber")
	private Long phoneNumber;
	
	@NotBlank(message = "mandatory")
	@NotNull(message = "mandatory")
	@Email(message = "Enter valid email")
	@Column(name="email")
	private String email;
	
	@NotBlank(message = "mandatory")
	@NotNull(message = "mandatory")
	@Column(name="position")
	private String position;
	
	@NotNull(message = "mandatory")
	@Column(name="hiredate")
	private Date hireDate;
	
	@NotBlank(message = "mandatory")
	@NotNull(message = "mandatory")
	@Min(value = 0)
	@Column(name="salary")
	private Double salary;
	
	@NotNull(message = "mandatory")
	@Column(name="bankaccountnumber")
	private Long bankAccountNumber;
	
	@NotNull(message = "mandatory")
	@Column(name="bankifscNumber")
	private Long bankIfscNumber;

	@NotNull(message = "mandatory")
	@Column(name = "status")
	private EmployeeStatus employeeStatus;
}
