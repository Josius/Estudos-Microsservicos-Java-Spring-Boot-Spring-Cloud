// classe Bean de configuração para disponibilizar algumas instâncias de objetos
package com.microservices.hrpayroll.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
	
	// método com função de registrar uma instância única (padrão de projeto Singleton) de um objeto do tipo RestTemplate
	// tal instância ficará disponível para injetar em outros componentes
	// cria um componente a partir de uma chamada de método
	@Bean
	public RestTemplate restTemplate(){
		
		return new RestTemplate();
	}
}