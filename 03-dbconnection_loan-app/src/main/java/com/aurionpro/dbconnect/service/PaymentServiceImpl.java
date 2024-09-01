package com.aurionpro.dbconnect.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurionpro.dbconnect.entity.Payment;
import com.aurionpro.dbconnect.repository.PaymentRepository;

@Service
public class PaymentServiceImpl implements PaymentService{
	
	@Autowired
    private PaymentRepository paymentRepository;

    public List<Payment> getAllPayments() {
        return paymentRepository.getAllPayments();
    }

    public void addPayment(Payment payment) {
        paymentRepository.addPayment(payment);
    }

    public Payment getPayment(Integer paymentId) {
        return paymentRepository.getPayment(paymentId);
    }

    public void updatePayment(Payment payment) {
        paymentRepository.updatePayment(payment);
    }

    public void deletePayment(Integer paymentId) {
    	paymentRepository.deletePayment(paymentId);
    }

}
