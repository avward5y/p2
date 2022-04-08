package com.revature.p2.myp2.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.p2.myp2.model.Transactions;

@Repository
public interface TransRepo extends JpaRepository<Transactions, Long> {
    List<Transactions> findByAccountNumberEquals(String accountNum);

	Transactions save(Transactions transactions);

	

}