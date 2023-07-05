package com.microservices.hrpayroll.entities;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Worker implements Serializable {
	
	private static final long serialVersionUID = 1l;

	@EqualsAndHashCode.Include
	private Long id;
	private String name;
	private Double dailyIncome;
}
