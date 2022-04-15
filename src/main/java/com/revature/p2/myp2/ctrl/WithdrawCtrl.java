//package com.revature.p2.myp2.ctrl;
//
//
//import org.springframework.web.bind.annotation.*;
//
//import com.revature.p2.myp2.model.Account;
//import com.revature.p2.myp2.model.AccountTrans;
//import com.revature.p2.myp2.model.TransType;
//import com.revature.p2.myp2.model.UserTrans;
//import com.revature.p2.myp2.utils.HttpStatus;
//import com.revature.p2.myp2.utils.Sjr;
//import com.revature.p2.myp2.utils.SjrImpl;
//
//import java.util.Date;
//import java.util.List;
//
///**
// * Created by IntelliJ IDEA.
// * Project : springboot-bank-account
// * User: hendisantika
// * Email: hendisantika@gmail.com
// * Telegram : @hendisantika34
// * Date: 2019-04-17
// * Time: 07:12
// */
//@RestController
//@RequestMapping(value = "/withdrawal")
//public class WithdrawCtrl extends BaseCtrl {
//
//    private static final double MAX_WITHDRAWAL_PER_TRANSACTION = 20000; // $20k
//    private static final double MAX_WITHDRAWAL_PER_DAY = 50000; // $50k
//    private static final int MAX_WITHDRAWAL_TRANSACTIONS_PER_DAY = 3;
//
//    @PostMapping("/")
//    public @ResponseBody
//    Sjr makeWithDrawal(@RequestBody UserTrans userTransaction) {
//
//        Sjr jsonResponse = new SjrImpl();
//
//        try {
//
//            double total = 0;
//
//            // check balance
//            double balance = accountService.findById(ACCOUNT_ID).get().();
//            if (userTransaction.getAmount() > balance) {
//                jsonResponse.setSuccess(false, "Error", "You have insufficient funds");
//                jsonResponse.setHttpResponseCode(HttpStatus.SC_NOT_ACCEPTABLE);
//                return jsonResponse;
//            }
//
//
//            // check maximum limit withdrawal for the day has been reached
//            List<AccountTrans> withdrawals = transactionsService.findByDateBetweenAndType(AccountUtils.getStartOfDay(new Date()),
//                    AccountUtils.getEndOfDay(new Date()), TransType.WITHDRAWAL.getId());
//
//            if (withdrawals.size() > 0) {
//                for (AccountTrans accountTransaction : withdrawals) {
//                    total += accountTransaction.getAmount();
//                }
//                if (total + userTransaction.getAmount() > MAX_WITHDRAWAL_PER_DAY) {
//                    jsonResponse.setSuccess(false, "Error", "Withdrawal per day should not be more than $50K");
//                    jsonResponse.setHttpResponseCode(HttpStatus.SC_NOT_ACCEPTABLE);
//                    return jsonResponse;
//                }
//            }
//
//            // Check whether the amount being withdrawn exceeds the MAX_WITHDRAWAL_PER_TRANSACTION
//            if (userTransaction.getAmount() > MAX_WITHDRAWAL_PER_TRANSACTION) {
//                jsonResponse.setSuccess(false, "Error", "Exceeded Maximum Withdrawal Per Transaction");
//                jsonResponse.setHttpResponseCode(HttpStatus.SC_NOT_ACCEPTABLE);
//                return jsonResponse;
//            }
//
//            // check whether transactions exceeds the max allowed per day
//            if (withdrawals.size() < MAX_WITHDRAWAL_TRANSACTIONS_PER_DAY) {
//                AccountTrans accountTransaction = new AccountTrans(TransType.WITHDRAWAL.getId(), userTransaction.getAmount(), new Date());
//                double amount = transactionsService.save(accountTransaction).getAmount();
//
//                Account account = accountService.findById(ACCOUNT_ID).get();
//                double newBalance = account.() - amount;
//                account.setAmount(newBalance);
//                accountService.save(account);
//
//                jsonResponse.setSuccess(true, "", "Withdrawal sucessfully Transacted");
//                jsonResponse.setHttpResponseCode(HttpStatus.SC_OK);
//
//            } else {
//                jsonResponse.setSuccess(false, "Error", "Maximum Withdrawal transactions for the day Exceeded");
//                jsonResponse.setHttpResponseCode(HttpStatus.SC_NOT_ACCEPTABLE);
//            }
//
//        } catch (Exception e) {
//            logger.error("exception", e);
//            jsonResponse.setSuccess(false, Sjr.DEFAULT_MSG_TITLE_VALUE, Sjr.DEFAULT_MSG_NAME_VALUE);
//            jsonResponse.setHttpResponseCode(HttpStatus.SC_INTERNAL_SERVER_ERROR);
//            return jsonResponse;
//        }
//
//        return jsonResponse;
//    }
//
//}