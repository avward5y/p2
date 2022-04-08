package com.revature.p2.myp2.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Represents a bank account that a User can own.
 * Every account can be of type CHECKING or SAVINGS.
 * Every account keeps a record of transactions on that account
 * Accounts must be approved before transactions can be performed on it.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name="Accounts")
@Table(name = "accounts")
public class Accounts implements Serializable {
	public Accounts(long l, String string, BigDecimal bigDecimal) {
		// TODO Auto-generated constructor stub
	}

	/**Automatically generated universally unique identifier */
	private static final long serialVersionUID = -662794077232408056L;

	public static enum AccountType {
		CHECKING, SAVINGS
	}
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="accounts_id")
	private long accountsId;
	@Column(name="accountsownerId")
	private Integer ownerId;
	@Column(name="accountsbalance")
	private BigDecimal currentBalance;
	@Column(name="accountstype")
	private AccountType type;
	@Column(name="accountsstatus")
	private boolean status;
	
	
	String accountNumber;
	
	
    @ManyToOne
	@JsonBackReference
	   private Users users;
	
	    @OneToMany(cascade=CascadeType.ALL, orphanRemoval=true)
	    @JoinColumn(name="accounts_id")
        private List<Transactions> transactions;

		
}