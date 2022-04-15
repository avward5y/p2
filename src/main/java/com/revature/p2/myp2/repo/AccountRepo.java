package com.revature.p2.myp2.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.p2.myp2.model.Account;


@Repository
public interface AccountRepo extends JpaRepository<Account , Long> {
   
    Account findByAccountNumberEquals(String accountNumber);
	Account findByAccountNumberEquals(long accountNumber);


}