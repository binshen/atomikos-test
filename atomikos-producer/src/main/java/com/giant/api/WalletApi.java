package com.giant.api;

import com.giant.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wallet")
public class WalletApi {

    @Autowired
    private WalletService walletService;

    @RequestMapping("/save")
    public int insertWallet(@RequestParam int uid, @RequestParam float money) {
        return walletService.insertWallet(uid, money);
    }
}
