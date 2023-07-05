package com.microservices.hrworker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class HrWorkerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrWorkerApplication.class, args);
	}

}

/* PARA RODAR Worker EM PORTAS DIFERENTES:
 * 1 - ABRIR QUANTOS TERMINAIS NECESSÁRIOS NO DIRETÓRIO RAIZ DE WORKER (onde está o pom.xml)
 * 2 - USAR ESTE COMANDO PARA CADA TERMINAL TROCANDO P/A PORTA NECESSÁRIA:
 * 		SERVER_PORT=XXXX mvn spring-boot:run
 * 
 * caminho
 * cd C:/Users/jram/Documents/Estudos/'Estudos-Microsservicos-Java-Spring-Boot-Spring-Cloud'/hr-worker
 */