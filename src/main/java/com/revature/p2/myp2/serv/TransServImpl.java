package com.revature.p2.myp2.serv;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.p2.myp2.model.Account;
import com.revature.p2.myp2.model.Transactions;
import com.revature.p2.myp2.repo.AccountRepo;
import com.revature.p2.myp2.repo.TransRepo;

public class TransServImpl implements TransServ {
    
	@Autowired
	private TransRepo transactionRepository;
	
	@Autowired
    AccountRepo accountRepository;
	
	@Override
	public <S extends Transactions> S save(S entity) {
		// TODO Auto-generated method stub
		return transactionRepository.saveAndFlush(entity);
	}

	@Override
	public <S extends Transactions> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return transactionRepository.saveAll(entities);
	}

	@Override
	public Optional<Transactions> findById(Long id) {
		// TODO Auto-generated method stub
		return transactionRepository.findById(id);
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return transactionRepository.existsById(id);
	}

	@Override
	public Iterable<Transactions> findAll() {
		// TODO Auto-generated method stub
		return transactionRepository.findAll();
	}

	@Override
	public Iterable<Transactions> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return transactionRepository.findAllById(ids);
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		transactionRepository.deleteById(id);
	}

	@Override
	public void delete(Transactions entity) {
		// TODO Auto-generated method stub
     transactionRepository.delete(entity);		
	}

	@Override
	public void deleteAll(Iterable<? extends Transactions> entities) {
		// TODO Auto-generated method stub
		transactionRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		transactionRepository.deleteAll();
	}
}
