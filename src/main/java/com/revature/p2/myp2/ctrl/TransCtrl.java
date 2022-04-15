package com.revature.p2.myp2.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.revature.p2.myp2.model.Transactions;
import com.revature.p2.myp2.serv.TransServ;

@RestController
@RequestMapping("/")
public class TransCtrl {

	
	@Autowired
	TransServ transactionsService;
	
	   @PostMapping("/trans/create")
	    public Iterable<Transactions> create(@RequestBody Transactions transactions) {
	        transactionsService.save(transactions);
	        return transactionsService.findAll();
	    }
	
	   @GetMapping("/trans")
	    public Iterable<Transactions> all() {
	        return transactionsService.findAll();
	    }
	    
	   
}
