package com.revature.p2.myp2.serv;

import java.util.List;

import com.revature.p2.myp2.model.Accounts;
import com.revature.p2.myp2.model.Astatement;
import com.revature.p2.myp2.model.Tbr;
import com.revature.p2.myp2.model.Transactions;
import com.revature.p2.myp2.model.Users;

public interface AccountsServ {
    List<Accounts> findAll();
    Accounts save(Accounts account);
    Transactions sendMoney(
            Tbr transferBalanceRequest
    );
    Astatement getStatement(String accountNum);
	
    void deleteById(long accountsId);
    
    public void updateAccounts(long accountsId, Accounts Accounts);
	
    void save(long accountsId, Accounts accounts);
	
}