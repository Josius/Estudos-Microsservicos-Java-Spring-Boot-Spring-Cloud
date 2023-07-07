package com.microservice.hruser.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class AppConfig {
	
	@Bean // Annotation para tornar a instância gerada pelo método seja um componente injetável no Spring
	public BCryptPasswordEncoder passwordEncoder(){

		return new BCryptPasswordEncoder();
	}
}
