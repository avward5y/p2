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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.revature.p2.myp2.model.Dialect.Status;
import com.revature.p2.myp2.repo.AccountRepo;
import com.revature.p2.myp2.serv.AccountServ;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Represents a bank account that a User can own.
 * Every account can be of type CHECKING or SAVINGS.
 * Every account keeps a record of transactions on that account
 * Accounts must be approved before transactions can be performed on it.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name="Accounts")
@Table(name = "accounts")
public class Account implements Serializable {


	public Account(long l, String string, BigDecimal bigDecimal) {
		// TODO Auto-generated constructor stub
	}

	/**Automatically generated universally unique identifier */
	private static final long serialVersionUID = -662794077232408056L;
	
	public static enum AccountType {
		CHECKING, SAVINGS
	}
	
	private String accountNumber ;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="accounts_id")
	private Long accountsId;
//	@Column(name="accountsownerId")
//	private int ownerId;
	@Column(name="accountsbalance")
	private BigDecimal accountBalance;
	@Column(name="accountstype")
	private AccountType type;
	@Column(name="accountsapproved")
	private boolean approved;


	

    @ManyToOne
	@JsonBackReference
	   private User users;
	
	    @OneToMany(cascade=CascadeType.ALL, orphanRemoval=true)
	    @JoinColumn(name="usersid")
        private List<Transactions> transactions;
		
//		public Account(long l, String string ) {
			// TODO Auto-generated constructor stub
		}
	    
