package com.aurionpro.dbconnect.service;

import java.util.List;

import com.aurionpro.dbconnect.entity.Payment;

public interface PaymentService {
	List<Payment> getAllPayments();

	void addPayment(Payment payment);

	Payment getPayment(Integer paymentId);

	void updatePayment(Payment payment);

	void deletePayment(Integer paymentId);
}
