//package com.revature.p2.myp2.test;
//
//import java.math.BigDecimal;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.context.TestConfiguration;
//import org.springframework.context.annotation.Bean;
//import org.springframework.test.context.junit4.SpringRunner;
//import com.revature.p2.myp2.model.Accounts;
//import com.revature.p2.myp2.model.Tbr;
//import com.revature.p2.myp2.serv.AccountsServ;
//import com.revature.p2.myp2.serv.AccountsServImpl;
//
//
//@RunWith(SpringRunner.class)
//@DataJpaTest
//public class AccountServiceImplTest {
//
//    @TestConfiguration
//    static class AccountsServiceTestContextConfiguration {
//        @Bean
//        public AccountsServImpl AccountsServiceImplTest() {
//            return new AccountsServImpl();
//
//        }
//    }
//
//    @Autowired
//    private AccountsServImpl AccountsService;
//
//    @Test
//    public void sendMoneyTest() {
//        Account Accounts1 = new Account(0L, "1001", new BigDecimal(50000));
//        Account Accounts2 = new Account(0L, "2002", new BigDecimal(2000));
//        AccountsService.save(Accounts1);
//        AccountsService.save(Accounts2);
//
//        Tbr transferBalanceRequest =
//                new Tbr(
//                        Accounts1.getAccountsId(),
//                        Accounts2.getAccountsId(),
//                        new BigDecimal(3000)
//                );
//        AccountsService.sendMoney(transferBalanceRequest);
//        assertThat(AccountsService.findByAccountsId(Accounts1.getAccountsId())
//                .getCurrentBalance())
//                .isEqualTo(new BigDecimal(47000));
//        assertThat(AccountsService.findByAccountsId(Accounts2.getAccountsId())
//                .getCurrentBalance())
//                .isEqualTo(new BigDecimal(5000));
//
//    }
//
//    @Test
//    public void getStatement() {
//        Account Accounts1 = new Account(0L, "1001", new BigDecimal(50000));
//        Account Accounts2 = new Account(0L, "2002", new BigDecimal(2000));
//        AccountsServ.save(Accounts1);
//        AccountsServ.save(Accounts2);
//        Tbr transferBalanceRequest =
//                new Tbr(
//                        Accounts1.getAccountssId(),
//                        Accounts2.getAccountssId(),
//                        new BigDecimal(3000)
//                );
//
//        AccountsServ.sendMoney(transferBalanceRequest);
//        assertThat(AccountsServ.getStatement(Accounts1.getAccountsId())
//                .getCurrentBalance())
//                .isEqualTo(new BigDecimal(47000));
//        AccountsServ.sendMoney(transferBalanceRequest);
//        assertThat(AccountsServ.getStatement(Accounts1.getAccountsId())
//                .getCurrentBalance()).isEqualTo(new BigDecimal(44000));
//        assertThat(AccountsServ.getStatement(Accounts1.getAccountsId())
//                .getTransactionHistory().size()).isEqualTo(2);
//    }
//}