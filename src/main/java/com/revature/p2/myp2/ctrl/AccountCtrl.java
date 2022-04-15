package com.revature.p2.myp2.ctrl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Status;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.revature.p2.myp2.model.Account;
import com.revature.p2.myp2.model.Asr;
import com.revature.p2.myp2.model.Dialect;
import com.revature.p2.myp2.model.Tbr;
import com.revature.p2.myp2.serv.AccountServ;



@RestController
@RequestMapping("/")
public class AccountCtrl {
	
    @Autowired 
    private AccountServ accountService;
    
//    @Transactional
//    public Account saveAccount(Account account) {
//    	try {return accountService.save(account);}
//    	catch(Exception ex) {
//    		System.out.println(ex);
//    	}
//     return null;
//    }
    @PostMapping("/create")
    public List <Account> create(@RequestBody Account account){
        accountService.save(account);
        return accountService.findAllAccounts();
    }
       
    @GetMapping("/Account")
    public List<Account> findAll() {
        return accountService.findAllAccounts();
    }
    
	@PutMapping("/Account/{accountsId}")
	public void updateAccount(@PathVariable Long accountsId , @RequestBody Account account) {
// TODO Auto-generated method stub
		accountService.save(accountsId , account);
	}

	@DeleteMapping("/Account/{accountsId}")
	public void deleteAccount(@PathVariable Long accountsId) {
// TODO Auto-generated method stub
		accountService.deleteById(accountsId);
	}
	
    @SuppressWarnings("rawtypes")
	@PutMapping("/Account/{accountsId}/sendmoney")
    public Dialect sendMoney(
            @RequestBody Tbr transferBalanceRequest
            ) {

        return Dialect.ok().setPayload(
                accountService.sendMoney(
                        transferBalanceRequest
                )
        );
    }
    @SuppressWarnings("rawtypes")
	@GetMapping("/statement")
    public Dialect getStatement(
            @RequestBody Asr accountStatementRequest

    ){
        return Dialect.ok().setPayload(
                accountService.getStatement(accountStatementRequest.getAccountNum())
        );

    }
    
    @PutMapping("/Account/{accountsId}/app")
    public void  status(boolean approved) {
   
    	accountService.status(approved);
    	
    
    
    }
    
    @PutMapping("/Account/{accountsId}/dep")
    public Account deposit(@PathVariable Long AccountId, @RequestBody Account amount) {
    	accountService.deposit(500);
    	return accountService.save(amount);
    	
    }

}


