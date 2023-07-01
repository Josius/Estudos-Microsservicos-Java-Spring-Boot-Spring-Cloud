package com.microservices.hrpayroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

// 1 - para que exista uma config básica para que o Feign funcione e que exista uma instância dele a disposição para poder ser injetado, precisamos usar uma annotation na classe principal do projeto, esta no caso:
@EnableFeignClients
@SpringBootApplication
public class HrPayrollApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrPayrollApplication.class, args);
	}

}

// 2 - para fazer a comunicação de um projeto a outro usando Feign, precisamos declarar uma interface com as assinaturas das requisições que podemos fazer -> ver diretório feignclients deste projeto
// 3 - após as implementações dos serviços que chamam webservices externos irá ficar muito mais limpa a chamada em comparação ao usar o RestTemplate
// 4 - vantagem do Feign, estar integrado com as outras ferramentas do Spring Cloud