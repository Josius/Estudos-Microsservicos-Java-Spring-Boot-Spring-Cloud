package com.microservices.hrpayroll.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservices.hrpayroll.entities.Payment;
import com.microservices.hrpayroll.entities.Worker;
import com.microservices.hrpayroll.feignclients.WorkerFeignClient;

@Service
public class PaymentService {

	@Autowired
	private WorkerFeignClient workerFeignClient;

	public Payment getPayment(long workerId, int days) {

		// precisamos do '.getBody()' pq não podemos converter ResponseEntity<Worker> para Worker -> o endpoint do Worker retorna um obj ResponseEntity e abaixo estamos declarando somente worker, logo, para acessarmos o obj worker que está dentro do ResponseEntity, precisamos do '.getBody()', o qual é do tipo Worker
		Worker worker = workerFeignClient.findById(workerId).getBody();
		// return new Payment("Boble", 225.0, days);
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
}
