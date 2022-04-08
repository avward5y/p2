package com.revature.p2.myp2.ctrl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.revature.p2.myp2.model.Accounts;
import com.revature.p2.myp2.model.Asr;
import com.revature.p2.myp2.model.Dialect;
import com.revature.p2.myp2.model.Tbr;
import com.revature.p2.myp2.model.Users;
import com.revature.p2.myp2.serv.AccountsServ;



@RestController
@RequestMapping("/")
public class AccountsCtrl {
	
    @Autowired 
    private AccountsServ accountService;
    
    
    @PostMapping("/create")
    public List<Accounts> create(@RequestBody Accounts account) {
        accountService.save(account);
        return accountService.findAll();
    }

    @GetMapping("/accounts")
    public List<Accounts> all() {
        return accountService.findAll();
    }
    
	@PutMapping("/accounts/{accountsId}")
	public void updateAccounts(@PathVariable long accountsId , @RequestBody Accounts Accounts) {
// TODO Auto-generated method stub
		accountService.save( accountsId, Accounts);
	}

	@DeleteMapping("/accounts/{accountsId}")
	public void deleteAccounts(long accountsId) {
// TODO Auto-generated method stub
		accountService.deleteById(accountsId);
	}

    @SuppressWarnings("rawtypes")
	@PutMapping("/sendmoney")
    public Dialect  sendMoney(
    		@RequestBody Tbr transferBalanceRequest
            ) {

        return Dialect.ok().setPayload(
                accountService.sendMoney(
                        transferBalanceRequest
                )
        );
    }
    @GetMapping("/statement")
    public Dialect getStatement(
            @RequestBody Asr accountStatementRequest

    ){
        return Dialect.ok().setPayload(
                accountService.getStatement(accountStatementRequest.getAccountNum())
        );

    }

}
