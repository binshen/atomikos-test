package com.giant.model;

import lombok.Data;

@Data
public class Wallet {

    private int id;
    private int uid;
    private float money;

    public Wallet(int uid, float money) {
        this.uid = uid;
        this.money = money;
    }
}
