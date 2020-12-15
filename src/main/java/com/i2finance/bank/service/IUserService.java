package com.i2finance.bank.service;

import com.i2finance.bank.util.Result;

public interface IUserService {

    //注册
    Result register(String phone,String password);


    //登录
    Result login(String phone,String password);

    //开户
    Result createAccount(String name,String code);



}
