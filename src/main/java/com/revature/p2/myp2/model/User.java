package com.revature.p2.myp2.model;

import java.util.List;
import java.util.Objects;
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


public class User {
	    
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "usersid")
	private Integer id;
	@Column(name = "usersusername")
	private String username;
	@Column(name = "userspassword")
	private String password;
	@Column(name = "usersfirstname")
	private String firstname;
	@Column(name = "userslastname")
	private String lastname;
	@Column(name = "usersemail")
	private String email;
	@Column(name = "usersmobile")
	private long mobile;
	private boolean active = false;
	@SuppressWarnings("unused")
	private enum type {
		Checkings , Savings }
	
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(username, user.username) &&
                Objects.equals(password, user.password);
    }
	

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, 
                            active);
    }
    
    @Override
    public String toString() {
        return "User{" +
                "id=" + id  +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", active=" + active +
                '}';
    }

	
	 @OneToMany(cascade = CascadeType.ALL)
	 @JoinTable(name="USERS_ACCOUNT_MAPPING", joinColumns={@JoinColumn(name="usersid", referencedColumnName="usersid")}
	  ,inverseJoinColumns={@JoinColumn(name="accounts_id", referencedColumnName="accounts_id")})
	 @JsonManagedReference
	 private Set<Account> accounts;
	
}


	