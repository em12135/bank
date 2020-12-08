package com.i2finance.bank.service;

import com.i2finance.bank.bean.User;

public interface IUserService {
    User isExist(String phone);

    void register(User user);

    boolean haveAccount(User user);



}
