//package com.revature.p2.myp2.ctrl;
//
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.revature.p2.myp2.model.Account;
//import com.revature.p2.myp2.utils.HttpStatus;
//import com.revature.p2.myp2.utils.Sjr;
//import com.revature.p2.myp2.utils.SjrImpl;
//
//import java.util.HashMap;
//import java.util.Optional;
//
///**
// * Created by IntelliJ IDEA.
// * Project : springboot-bank-account
// * User: hendisantika
// * Email: hendisantika@gmail.com
// * Telegram : @hendisantika34
// * Date: 2019-04-17
// * Time: 07:11
// */
//@RestController
//@RequestMapping(value = "/Account/{AccountId}/balance")
//public class BalanceCtrl extends BaseCtrl {
//
//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public @ResponseBody
//    Sjr getBalance() {
//
//        Sjr jsonResponse = new SjrImpl();
//        HashMap<String, Object> responseData = new HashMap<>();
//
//        try {
//            Optional<Account> account = Optional.of(accountService.findById(ACCOUNT_ID).get());
//
//            if (account.isPresent()) {
//                responseData.put("balance", "$" + account.get().getAccountNumber());
//
//                jsonResponse.setSuccess(true);
//                jsonResponse.setData(responseData);
//                jsonResponse.setHttpResponseCode(HttpStatus.SC_OK);
//            } else {
//                jsonResponse.setSuccess(false, "Resource not found", Sjr.RESOURCE_NOT_FOUND_MSG);
//                jsonResponse.setHttpResponseCode(HttpStatus.SC_NO_CONTENT);
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