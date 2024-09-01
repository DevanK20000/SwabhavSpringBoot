package com.aurionpro.dbconnect.repository;

import java.util.List;

import com.aurionpro.dbconnect.entity.Payment;

public interface PaymentRepository {
    List<Payment> getAllPayments();
    void addPayment(Payment payment);
    Payment getPayment(Integer paymentId);
    void updatePayment(Payment payment);
    void deletePayment(Integer paymentId);
}
