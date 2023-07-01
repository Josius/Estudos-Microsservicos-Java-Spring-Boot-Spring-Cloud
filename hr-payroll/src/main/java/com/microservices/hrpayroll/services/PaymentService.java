package com.microservices.hrpayroll.services;

import org.springframework.stereotype.Service;

import com.microservices.hrpayroll.entities.Payment;

// com a annotation @Component podemos registrar esta classe como um componente do Spring para ser injetada em outras classes, mas para tornar ela mais semântica, usamos o @Service
@Service
public class PaymentService {
	
	public Payment getPayment(long workerId, int days){

		return new Payment("Boble", 225.0, days);
	}
}
