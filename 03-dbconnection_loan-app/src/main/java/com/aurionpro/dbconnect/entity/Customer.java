package com.aurionpro.dbconnect.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customerid")
	private int customerId;
	@Column(name = "firstname")
	private String firstName;
	@Column(name = "dateofbirth")
	private Date date;
	@Column(name = "emailid")
	private String emailId;
	@Column(name = "mobilenumber")
	private Long mobileNumber;
	public Customer(int customerId, String firstName, Date date, String emailId, Long mobileNumber) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.date = date;
		this.emailId = emailId;
		this.mobileNumber = mobileNumber;
	}
	public Customer() {
		super();
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public Long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", date=" + date + ", emailId="
				+ emailId + ", mobileNumber=" + mobileNumber + "]";
	}
}
