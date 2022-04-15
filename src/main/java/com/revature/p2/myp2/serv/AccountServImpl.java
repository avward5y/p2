package com.revature.p2.myp2.serv;




import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.revature.p2.myp2.model.Account;
import com.revature.p2.myp2.model.Astatement;
import com.revature.p2.myp2.model.Tbr;
import com.revature.p2.myp2.model.Transactions;
import com.revature.p2.myp2.repo.AccountRepo;
import com.revature.p2.myp2.repo.TransRepo;

@Service
public class AccountServImpl implements AccountServ {

    @Autowired
    private AccountRepo accountRepository;

    @Autowired
    TransRepo transactionRepository;
    
    @SuppressWarnings("unchecked")
	public Account save(Account account) {
    	accountRepository.save(account);
    	return accountRepository.findByAccountNumberEquals(account.getAccountNumber());
    }
    
    public List<Account> findAll(){
    	return accountRepository.findAll();
    }

    public Account findByAccountNumber(String accountNumber) {
    	
    	Account account = accountRepository.findByAccountNumberEquals(accountNumber);
    	return account;
    }
	@Override
	public void updateAccount(Long accountsId , Account Account) {
		// TODO Auto-generated method stub
		accountRepository.save(Account);
	}

	@Override
	public Optional<Account> findById(Long accountsId) {
		// TODO Auto-generated method stub
		return accountRepository.findById(accountsId);
	}

	@Override
	public boolean existsById(Long accountsId) {
		// TODO Auto-generated method stub
		return accountRepository.existsById(accountsId);
	}

	
	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(Account entity) {
		// TODO Auto-generated method stub
		accountRepository.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends Account> entities) {
		// TODO Auto-generated method stub
		accountRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		accountRepository.deleteAll();
	}


	@Override
	public <S extends Account> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Iterable<Account> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(long accountsId) {
		// TODO Auto-generated method stub
		return accountRepository.existsById(accountsId);
	}

	@Override
	public List<Account> findAllAccounts() {
		// TODO Auto-generated method stub
		return accountRepository.findAll();
	}

	@Override
	public Account withdraw(double amount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account transfer(double amount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account deposit(double amount) {
		// TODO Auto-generated method stub
		return accountRepository.findByAccountNumberEquals("test456");
	
	}

	@Override
	public boolean status(boolean approved) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void save(Long accountsId, Account accounts) {
		// TODO Auto-generated method stub
	accountRepository.save(accounts);
		
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
      accountRepository.deleteById(id);
	}

	@Override
	public void deleteAccount(Long accountsId) {
		// TODO Auto-generated method stub
		accountRepository.deleteById(accountsId);
	}     

	@Override
	public Astatement getStatement(String accountNumber) {
	        Account account = accountRepository.findByAccountNumberEquals(accountNumber);
	        return new Astatement(account.getAccountBalance(),transactionRepository.findByAccountNumberEquals(accountNumber));
	    }

	 @Override
	        public Transactions sendMoney( Tbr transferBalanceRequest) {
	        String fromAccountNumber = transferBalanceRequest.getFromAccountNumber();
	        String toAccountNumber = transferBalanceRequest.getToAccountNumber();
	        BigDecimal amount = transferBalanceRequest.getAmount();
	        Account fromAccount = accountRepository.findByAccountNumberEquals(
	                fromAccountNumber
	        );
	        Account toAccount = accountRepository.findByAccountNumberEquals(toAccountNumber);
	        if(fromAccount.getAccountBalance().compareTo(BigDecimal.ONE) == 1
	                && fromAccount.getAccountBalance().compareTo(amount) == 1
	        ){
	            fromAccount.setAccountBalance(fromAccount.getAccountBalance().subtract(amount));
	            accountRepository.save(fromAccount);
	            toAccount.setAccountBalance(toAccount.getAccountBalance().add(amount));
	            accountRepository.save(toAccount);
	            Transactions transaction = transactionRepository.save(new Transactions(0L,fromAccountNumber,amount, new Timestamp(System.currentTimeMillis())));
	            return transaction;
	        }
	        return null;
	    }


}