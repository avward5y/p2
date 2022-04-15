package com.revature.p2.myp2.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Tbr {
   
	
	public Tbr(Long accountsId, Long accountsId2, BigDecimal bigDecimal) {
		// TODO Auto-generated constructor stub
	}

	private String fromAccountNumber;

    private String toAccountNumber;

    private BigDecimal amount;


	}

