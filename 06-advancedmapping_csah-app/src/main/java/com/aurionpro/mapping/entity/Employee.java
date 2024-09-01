package com.aurionpro.mapping.entity;

import java.sql.Date;

import com.aurionpro.mapping.entity.enums.EmployeeStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	@Column
	private int employeeId;

	@Column
	private String firstName;

	@Column
	private String lastName;

	@Column
	private Long phoneNumber;

	@Column
	private String email;

	@Column
	private String position;

	@Column
	private Date hireDate;

	@Column
	private Double salary;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "accountNumber")
	private SalaryAccount salaryAccount;

	@Column
	private Long bankIfscNumber;

	@Column
	private EmployeeStatus employeeStatus;
	
	@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH})
	@JsonBackReference
	private Client client;
}
