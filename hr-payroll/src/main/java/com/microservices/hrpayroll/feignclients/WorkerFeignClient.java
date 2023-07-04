package com.microservices.hrpayroll.feignclients;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservices.hrpayroll.config.AppConfig;
import com.microservices.hrpayroll.entities.Worker;

@Component //bean gerenciado pelo Spring que poderá ser injetado em outras classes
@FeignClient(name = "hr-worker", path = "/workers") // entre () -> (1º nome do microsserviço, 2º endpoint do microsserviço)
// @LoadBalancerClient(name="hr-worker", configuration=AppConfig.class)
public interface WorkerFeignClient {
	
	// os métodos criados abaixo, nada mais são que as assinaturas dos métodos usados no WorkerResource, mais comumente conhecido como uma classe Controller.
	@GetMapping(value = "/{id}")
	ResponseEntity<Worker> findById(@PathVariable Long id);

}
