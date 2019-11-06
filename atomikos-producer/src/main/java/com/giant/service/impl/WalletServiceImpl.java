package com.giant.service.impl;

import com.giant.mapper.WalletMapper;
import com.giant.model.Wallet;
import com.giant.service.WalletService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WalletServiceImpl implements WalletService {

    @Autowired
    private WalletMapper walletMapper;

    @Override
    @Transactional
    public int insertWallet(int uid, float money) {
        Wallet wallet = new Wallet(uid, money);
        int result = walletMapper.insertWallet(wallet);
        if (result == 1) {
            return wallet.getId();
        } else {
            return 0;
        }
    }

    @Override
    @Transactional
    public int insertWallet2(int uid, float money) {
        Wallet wallet = new Wallet(uid, money);
        int result = walletMapper.insertWallet(wallet);
        if (result == 1) {
            result = result / 0;
            return wallet.getId();
        } else {
            return 0;
        }
    }
}
