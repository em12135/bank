package com.i2finance.bank.service;

import com.i2finance.bank.bean.User;
import com.i2finance.bank.util.Result;

public interface IUserService {
    User isExist(String phone);

    //注册
    Result register(String phone,String password);

    boolean haveAccount(User user);

    //登录
    Result login(String phone,String password);

    //开户
    Result createAccount();



}
