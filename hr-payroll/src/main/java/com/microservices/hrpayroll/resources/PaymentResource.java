package com.microservices.hrpayroll.resources;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.hrpayroll.entities.Payment;
import com.microservices.hrpayroll.services.PaymentService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping(value = "/payments")
public class PaymentResource {

	private static final String PAYMENT_RESOURCE = "paymentResource";
	@Autowired
	private PaymentService service;

	@CircuitBreaker(name = PAYMENT_RESOURCE, fallbackMethod = "getPaymentAlternativo")
	@GetMapping(value = "/{workerId}/days/{days}")
	public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable Integer days) {

		Payment payment = service.getPayment(workerId, days);

		return ResponseEntity.ok().body(payment);
	}

	// uma ideia é fazer um CACHE dos últimos dados.
	// NOTA: nesta implementação, precisa necessariamente receber a exception Throwable abaixo.
	public ResponseEntity<Payment> getPaymentAlternativo(Long workerId, Integer days, Throwable e) {

		// mock
		Payment payment = new Payment("Brann", 400.0, days);
		return ResponseEntity.ok().body(payment);
	}
}
