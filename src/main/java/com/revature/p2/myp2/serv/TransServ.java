package com.revature.p2.myp2.serv;

import com.revature.p2.myp2.model.Transactions;
import org.springframework.context.annotation.Primary;
import org.springframework.data.repository.CrudRepository;


@Primary
public interface TransServ extends CrudRepository<Transactions, Long> {

//    List<Transactions> findByDateBetweenAndType(Date StartOfDay, Date endOfDay, int type);
    
//    public void deposit(double amount);
//    public void withdraw(double amount);
//    public void transfer(double amount, Account accountId); 
    
    

}