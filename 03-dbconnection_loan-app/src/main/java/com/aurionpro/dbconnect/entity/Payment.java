package com.aurionpro.dbconnect.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "payment")
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "paymentid")
	private int paymentId;
	@Column(name="paymentdate")
	private Date paymentDate;
	@Column(name = "amount")
	private Double amount;
	@Column(name = "paymentmode")
	private PaymentMode paymentMode;
	@Column(name = "paymentstatus")
	private PaymentStatus paymetStatus;
	public Payment(int paymentId, Date paymentDate, Double amount, PaymentMode paymentMode,
			PaymentStatus paymetStatus) {
		super();
		this.paymentId = paymentId;
		this.paymentDate = paymentDate;
		this.amount = amount;
		this.paymentMode = paymentMode;
		this.paymetStatus = paymetStatus;
	}
	public Payment() {
		super();
	}
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public PaymentMode getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(PaymentMode paymentMode) {
		this.paymentMode = paymentMode;
	}
	public PaymentStatus getPaymetStatus() {
		return paymetStatus;
	}
	public void setPaymetStatus(PaymentStatus paymetStatus) {
		this.paymetStatus = paymetStatus;
	}
	
	
}
