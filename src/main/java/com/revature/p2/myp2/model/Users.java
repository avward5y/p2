package com.revature.p2.myp2.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "Users")
@Table(name ="users")

//@UniqueConstraint(columnNames = "usersappact_id") })
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "usersid")
	private int id;
	@Column(name = "usersusername")
	private String username;
	@Column(name = "userspassword")
	private String password;
	@Column(name = "usersfirstname")
	private String firstname;
	@Column(name = "userslastname")
	private String lastname;
//	@Column(name = "usersapproved")
//	private boolean approved;
//	@Column(name = "usersappactId")
	@Column(name = "usersemail")
	private String email;
	@Column(name = "usersmobile")
	private long mobile;
	private boolean active = true;
	@SuppressWarnings("unused")
	private enum type {
		Checkings , Savings }
	
	 @OneToMany(cascade = CascadeType.ALL)
	 @JoinTable(name="USERS_ACCOUNT_MAPPING", joinColumns={@JoinColumn(name="MY_USER_ID", referencedColumnName="usersid")}
	  ,inverseJoinColumns={@JoinColumn(name="MY_ACCOUNT_ID", referencedColumnName="accounts_id")})
	 @JsonManagedReference
	 private Set<Accounts> Accountss;
	
}


	