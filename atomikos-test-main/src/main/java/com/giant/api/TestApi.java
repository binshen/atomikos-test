package com.giant.api;

import com.giant.model.Wallet;
import com.giant.service.UserService;
import com.giant.service.WalletService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestApi {

    @Autowired
    private UserService userService;

    @Reference
    private WalletService walletService;

    @RequestMapping("/index_e1")
    @Transactional
    public int error1() {
        System.out.println("+++++++++++++++++++++++++++++++++++++++1");
        int userId = userService.insertUser("error1");
        System.out.println(userId);
        int result = walletService.insertWallet2(userId, 1000);
        System.out.println("+++++++++++++++++++++++++++++++++++++++1");
        return result;
    }

    @RequestMapping("/index_e2")
    @Transactional
    public int error2() {
        System.out.println("+++++++++++++++++++++++++++++++++++++++2");
        int userId = userService.insertUser2("error2");
        System.out.println(userId);
        int result = walletService.insertWallet(userId, 2000);
        System.out.println("+++++++++++++++++++++++++++++++++++++++2");
        return result;
    }

    @RequestMapping("/index_ok")
    @Transactional
    public int ok() {
        System.out.println("+++++++++++++++++++++++++++++++++++++++3");
        int userId = userService.insertUser("ok!!!");
        System.out.println(userId);
        int result = walletService.insertWallet(userId, 3000);
        System.out.println("+++++++++++++++++++++++++++++++++++++++3");
        return result;
    }
}
