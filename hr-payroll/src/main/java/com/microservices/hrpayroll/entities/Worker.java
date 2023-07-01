// classe copiada do projeto 'hr-worker' para executar chamadas RestTemplate
// o que está comentado faz parte do JPA, entretanto, não precisamos do JPA nesta Entity, por isso tudo está comentado. Também poderíamos apagar essas linhas

package com.microservices.hrpayroll.entities;

import java.io.Serializable;

// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
// @Entity
// @Table(name = "tb_worker")
public class Worker implements Serializable {
	
	private static final long serialVersionUID = 1l;

	@EqualsAndHashCode.Include
	// @Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Double dailyIncome;
}
