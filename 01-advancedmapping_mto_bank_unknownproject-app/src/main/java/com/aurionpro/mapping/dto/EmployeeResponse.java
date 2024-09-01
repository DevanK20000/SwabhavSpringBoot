package com.aurionpro.mapping.dto;

import java.sql.Date;

import com.aurionpro.mapping.entity.enums.EmployeeStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
@Getter
@Setter
public class EmployeeResponse {
	private int employeeId;

	private String firstName;

	private String lastName;
	private Long phoneNumber;

	private String email;

	private String position;

	private Date hireDate;

	private Double salary;


	private Long bankIfscNumber;

	private EmployeeStatus employeeStatus;
}
