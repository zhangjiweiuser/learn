package com.zhang.learn.chapter2023.chapter02.chapter0207.shipeiqi.mqservice;

import com.alibaba.fastjson2.JSON;
import com.zhang.learn.chapter2023.chapter02.chapter0207.shipeiqi.CreateAccount;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-07 16:18
 */
public class CreateAccountService {
    public void onMessage(String message){
        CreateAccount createAccount = JSON.parseObject(message, CreateAccount.class);
        String number = createAccount.getNumber();
    }
}
