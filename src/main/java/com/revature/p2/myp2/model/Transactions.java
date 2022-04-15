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

import com.revature.p2.myp2.model.Transactions.TransactionType;

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
//@NoArgsConstructor
@ToString
@Entity
@Table(name="transactions")
public class Transactions implements Serializable {
	

	/**Automatically generated universally unique identifier */
	private static final long serialVersionUID = 4244173215207746743L;
	
	

	public static enum TransactionType {
		WITHDRAWAL, DEPOSIT, TRANSFER
	}
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="transId")
	private Long transId;
	@Column(name="transactionsfromAccountId")
	private String fromAccountId;
	@Column(name="transactionstoAccountId")
	private String toAccountId;
	@Column(name="transactionsamount")
	private BigDecimal amount;
	@Column(name="transactionstype")
	private TransactionType type;
	@Column(name="transactionstimestamp")
	private LocalDateTime timestamp;

	private String accountNumber;
	private  Timestamp transactionDateTime;
	
	protected Transactions() {
		
	}
	public Transactions (TransactionType type , BigDecimal amount , LocalDateTime timestamp) {
		     this.type = type;
		     this.amount = amount;
		     this.timestamp = timestamp;
		}
	
	public long getTransId() {
		return transId;
	}
	public void setTransId(long transId) {
		this.transId = transId;
	}
	public TransactionType getType () {
		return type;
	}
	public void setType(TransactionType type) {
		this.type = type;
	}
	public BigDecimal getAmount () {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTransId(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	
	
	
	public Transactions(long l, String fromAccountNumber, BigDecimal amount2, java.sql.Timestamp timestamp2) {
		// TODO Auto-generated constructor stub
	}



	@Column(name="transactionstimestamp", nullable=false,updatable=false,insertable=false,columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	Date transactionTimestamp;
}
//	Date transactionTimestamp;

//public Transactions(long l, String fromAccountId2, BigDecimal amount2, java.sql.Timestamp timestamp2) {
//	// TODO Auto-generated constructor stub
//}

	
	
