package com.aurionpro.dbconnect.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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

	@Column(name="companyname")
	private String companyName;
	
	@Column(name="registrationnumber")
	private Long registrationNumber;
	
	@Column(name="contactperson")
	private String contactPerson;
	
	@Column(name="contactemail")
	private String contactEmail;
	
	@Column(name="contactnumber")
	private Long contactNumber;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "status")
	private ClientStatus status;
	
	@Column(name = "creationdate")
	private Date creationDate;
	
	@Column(name = "kycstatus")
	private ClientKycStatus clientKycStatus;
}