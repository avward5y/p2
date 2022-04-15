package com.revature.p2.myp2.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.p2.myp2.model.Astatement;
import com.revature.p2.myp2.model.Transactions;

@Repository
public interface TransRepo extends JpaRepository<Transactions, Long> {
    List<Transactions> findByAccountNumberEquals(String accountNumber);

	


//	 Astatement getAstatement(String accountNumber);
	 
	Transactions findAllByTransId(long transId);
//	Transactions findByAccountId(long accountId);


	@SuppressWarnings("unchecked")
	Transactions save(Transactions transactions);
	

}