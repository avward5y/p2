package com.revature.p2.myp2.ctrl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.revature.p2.myp2.serv.AccountServ;
import com.revature.p2.myp2.serv.TransServ;

public class BaseCtrl {
    protected static final long ACCOUNT_ID = 1L;
    protected final Log logger = LogFactory.getLog(getClass());
    @Autowired
    AccountServ accountService;

    @Autowired
    TransServ transactionsService;
}