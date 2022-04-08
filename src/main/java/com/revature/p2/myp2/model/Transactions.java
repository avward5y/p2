package com.revature.p2.myp2.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.security.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * An individual transaction that can be performed on an account.
 * Can be a withdrawal, deposit or transfer.
 * For withdrawals or deposits, the toAccountId field is null.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="transactions")
public class Transactions implements Serializable {
	public Transactions(long l, String fromAccountId2, BigDecimal amount2, java.sql.Timestamp timestamp2) {
		// TODO Auto-generated constructor stub
	}

	/**Automatically generated universally unique identifier */
	private static final long serialVersionUID = 4244173215207746743L;
	
	

	public static enum TransactionType {
		WITHDRAWAL, DEPOSIT, TRANSFER
	}
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="transId")
	private long transId;
	@Column(name="transactionsfromAccountId")
	private String fromAccountId;
	@Column(name="transactionstoAccountId")
	private String toAccountId;
	@Column(name="transactionsamount")
	private Double amount;
	@Column(name="transactionstype")
	private TransactionType type;
	@Column(name="transactionstimestamp")
	private LocalDateTime timestamp;

	private String accountNumber;
	private  Timestamp transactionDateTime;
	
	@Column(name="transactionstimestamp", nullable=false,updatable=false,insertable=false,columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	Date transactionTimestamp;
	
	
}