package com.i2finance.bank.service;

import com.i2finance.bank.util.Result;

public interface ICardService {
    //用户绑卡
    Result addCard(String code,String password,String name);


}
