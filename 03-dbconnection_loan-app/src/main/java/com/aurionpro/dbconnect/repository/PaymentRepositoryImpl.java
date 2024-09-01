package com.aurionpro.dbconnect.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aurionpro.dbconnect.entity.Payment;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class PaymentRepositoryImpl implements PaymentRepository {
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Payment> getAllPayments() {
		return entityManager.createQuery("SELECT p FROM Payment p", Payment.class).getResultList();
	}

	@Override
	@Transactional
	public void addPayment(Payment payment) {
		entityManager.persist(payment);
	}

	@Override
	public Payment getPayment(Integer paymentId) {
		return entityManager.find(Payment.class, paymentId);
	}

	@Override
	@Transactional
	public void updatePayment(Payment payment) {
		entityManager.merge(payment);
	}

	@Override
	@Transactional
	public void deletePayment(Integer paymentId) {
		Payment payment = entityManager.find(Payment.class, paymentId);
		if (payment != null) {
			entityManager.remove(payment);
		}
	}
}
