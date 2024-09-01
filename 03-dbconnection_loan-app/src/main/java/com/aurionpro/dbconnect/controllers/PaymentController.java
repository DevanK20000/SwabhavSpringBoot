package com.aurionpro.dbconnect.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.aurionpro.dbconnect.entity.Payment;
import com.aurionpro.dbconnect.service.PaymentService;

import java.util.List;

@RestController
@RequestMapping("paymentapp")
public class PaymentController {

 @Autowired
 private PaymentService paymentService;

 @GetMapping("payments")
 public ResponseEntity<List<Payment>> getAllPayments() {
     List<Payment> payments = paymentService.getAllPayments();
     return new ResponseEntity<>(payments, HttpStatus.OK);
 }

 @PostMapping("payments")
 public String addPayment(@RequestBody Payment payment) {
     paymentService.addPayment(payment);
     return "Payment added";
 }

 @GetMapping("payments/{id}")
 public ResponseEntity<Payment> getPayment(@PathVariable("id") Integer paymentId) {
     Payment payment = paymentService.getPayment(paymentId);
     return new ResponseEntity<>(payment, HttpStatus.OK);
 }

 @PutMapping("payments")
 public String updatePayment(@RequestBody Payment payment) {
     paymentService.updatePayment(payment);
     return "Payment updated";
 }

 @DeleteMapping("payments/{id}")
 public String deletePayment(@PathVariable("id") Integer paymentId) {
     paymentService.deletePayment(paymentId);
     return "Payment deleted";
 }
}
