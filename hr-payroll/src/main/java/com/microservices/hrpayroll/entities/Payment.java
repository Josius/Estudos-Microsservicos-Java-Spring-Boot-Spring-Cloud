package com.microservices.hrpayroll.entities;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Payment implements Serializable{
	
	private static final long serialVersionUID = 1l;
	
	private String name;
	private Double dailyIncome;
	private Integer days;

	public double getTotal(){

		return days * dailyIncome;
	}
}