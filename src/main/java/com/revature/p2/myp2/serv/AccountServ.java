package com.revature.p2.myp2.serv;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Primary;
import org.springframework.data.repository.CrudRepository;
import com.revature.p2.myp2.model.Account;
import com.revature.p2.myp2.model.Astatement;
import com.revature.p2.myp2.model.Tbr;
import com.revature.p2.myp2.model.Transactions;


@Primary
public interface AccountServ extends CrudRepository<Account, Long > {
	
	
    @SuppressWarnings("unchecked")
	Account save(Account account);
    Transactions sendMoney(
            Tbr  transferBalanceRequest
    ); 
		
	
    Astatement getStatement(String accountNumber);
	
    
    
    public void updateAccount(Long accountsId , Account Accounts);
	public List <Account> findAllAccounts();
    void save(Long accountsId, Account accounts);
//    public void deleteAccountById();
    public long count();
//    public <S extends Account> Iterable<S> saveAll(Iterable<S> entities);
//    public Optional<Account> findById(Long id);
    public boolean existsById(long accountsId);
//    public void delete(Account accountId);
    public void deleteAccount(Long accountsId);
	public boolean status (boolean approved);
	 public Account withdraw(double amount) ;
    public Account transfer(double amount);
    public Account deposit(double amount);
    
}