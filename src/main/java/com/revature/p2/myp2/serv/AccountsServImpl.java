package com.revature.p2.myp2.serv;

import java.math.BigDecimal;
import java.sql.Timestamp;
//import java.security.Timestamp;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.revature.p2.myp2.model.Accounts;
import com.revature.p2.myp2.model.Astatement;
import com.revature.p2.myp2.model.Tbr;
import com.revature.p2.myp2.model.Transactions;
import com.revature.p2.myp2.repo.AccountsRepo;
import com.revature.p2.myp2.repo.TransRepo;

@Service
public class AccountsServImpl implements AccountsServ {

    @Autowired
    private AccountsRepo accountsRepository;

    @Autowired
    TransRepo transactionRepository;

    public Accounts save(Accounts account){
        accountsRepository.save(account);
        return accountsRepository.findByAccountNumberEquals(account.getAccountNumber());
    }

    public List<Accounts> findAll(){
        return accountsRepository.findAll();
    }

    public Accounts findByAccountNumber(String accountNum){
        Accounts account = accountsRepository.findByAccountNumberEquals(accountNum);
        return account;
    }


    @Override
    public Transactions sendMoney(
            Tbr transferBalanceRequest
    ) {
        String fromAccountNum = transferBalanceRequest.getFromAccountNum();
        String toAccountNum = transferBalanceRequest.getToAccountNum();
        BigDecimal amount = transferBalanceRequest.getAmount();
        Accounts fromAccount = accountsRepository.findByAccountNumberEquals(
                fromAccountNum
        );
        Accounts toAccount = accountsRepository.findByAccountNumberEquals(toAccountNum);
        if(fromAccount.getCurrentBalance().compareTo(BigDecimal.ONE) == 1
                && fromAccount.getCurrentBalance().compareTo(amount) == 1
        ){
            fromAccount.setCurrentBalance(fromAccount.getCurrentBalance().subtract(amount));
            accountsRepository.save(fromAccount);
            toAccount.setCurrentBalance(toAccount.getCurrentBalance().add(amount));
            accountsRepository.save(toAccount);
            Transactions transaction = transactionRepository.save(new Transactions(0L,fromAccountNum,amount,new Timestamp(System.currentTimeMillis())));
            return transaction;
        }
        return null;
    }

    @Override
    public Astatement getStatement(String AccountsId) {
        Accounts Accounts = accountsRepository.findByAccountNumberEquals(AccountsId);
        return new Astatement(Accounts.getCurrentBalance(),transactionRepository.findByAccountNumberEquals(AccountsId));
    }

	@Override
	public void deleteById(long accountsId) {
		// TODO Auto-generated method stub
		accountsRepository.deleteById(accountsId);
	}

	@Override
	public void updateAccounts(long accountsId, Accounts Accounts) {
		// TODO Auto-generated method stub
		accountsRepository.save(Accounts);
	}

	@Override
	public void save(long accountsId, Accounts accounts) {
		// TODO Auto-generated method stub
		accountsRepository.save(save(accounts));
	}

	
}