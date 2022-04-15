package com.revature.p2.myp2.model;

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Astatement {
    BigDecimal currentBalance;
    List<Transactions> transactionHistory;
}