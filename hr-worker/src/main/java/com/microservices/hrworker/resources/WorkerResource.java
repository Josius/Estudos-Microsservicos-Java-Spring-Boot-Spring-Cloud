package com.microservices.hrworker.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.hrworker.entities.Worker;
import com.microservices.hrworker.repositories.WorkerRepository;

@RefreshScope // Annotation para que a dependência Actuator atualize as configurações em tempo de execução (runtime)
@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {

	private static Logger logger = LoggerFactory.getLogger(WorkerResource.class);
	
	// annotation abaixo serve para recuperar uma configuração, no caso, recuperará do repositório do github, do arquivo ht-worker.properties o valor de test.config
	@Value("${test.config}")
	private String testConfig;

	@Autowired
	private Environment env;
	
	@Autowired
	private WorkerRepository repository;

	// endpoint para recuperar as configurações do servidor de configurações hr-config-server
	@GetMapping(value = "/configs")
	public ResponseEntity<Void> getConfigs() {

		logger.info("CONFIG= " + testConfig);
		return ResponseEntity.noContent().build();
	}

	@GetMapping
	public ResponseEntity<List<Worker>> findAll() {

		List<Worker> list = repository.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id) {

		// try {
		// 	Thread.sleep(3000L);
		// } catch (InterruptedException e) {
		// 	e.printStackTrace();
		// }
		
		logger.info("PORT = " + env.getProperty("local.server.port"));
		
		Worker obj = repository.findById(id).get();
		
		return ResponseEntity.ok().body(obj);
	}
}
