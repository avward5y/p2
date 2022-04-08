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
   
	
	private String fromAccountNum;

    private String toAccountNum;

    private BigDecimal amount;


	}

