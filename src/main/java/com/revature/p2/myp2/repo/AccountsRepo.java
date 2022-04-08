package com.revature.p2.myp2.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.p2.myp2.model.Accounts;

@Repository
public interface AccountsRepo extends JpaRepository<Accounts , Long> {
   
	Accounts findByAccountNumberEquals(String accountNumber);

//	Accounts findByAccountsNumberEquals(String toAccountNumber);

	Accounts findByAccountNumberEquals(long accountNumber);

	void save(String fromAccountNumber);

}