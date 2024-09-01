package com.aurionpro.dbconnect.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="clients")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Client {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	@Column(name="clientid")
	private int clientId;

	@NotBlank(message = "mandatory")
	@NotNull(message = "mandatory")
	@Column(name="companyname")
	private String companyName;

	@NotNull(message = "mandatory")
	@Column(name="registrationnumber")
	private Long registrationNumber;
	
	@NotBlank(message = "mandatory")
	@NotNull(message = "mandatory")
	@Column(name="contactperson")
	private String contactPerson;
	
	@NotBlank(message = "mandatory")
	@NotNull(message = "mandatory")
	@Email(message = "Invalid email")
	@Column(name="contactemail")
	private String contactEmail;
	
	@NotNull(message = "mandatory")
	@Column(name="contactnumber")
	
	private Long contactNumber;
	
	@NotBlank(message = "mandatory")
	@NotNull(message = "mandatory")
	@Column(name = "address")
	private String address;
	
	@NotNull(message = "mandatory")
	@Column(name = "status")
	private ClientStatus status;
	
	@Column(name = "creationdate")
	private Date creationDate;
	
	@NotNull(message = "mandatory")
	@Column(name = "kycstatus")
	private ClientKycStatus clientKycStatus;
}