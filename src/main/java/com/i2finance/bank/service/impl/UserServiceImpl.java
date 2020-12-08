package com.i2finance.bank.service.impl;

import com.i2finance.bank.bean.User;
import com.i2finance.bank.dao.UserDao;
import com.i2finance.bank.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    UserDao userDao;

    //判断手机号是否已经存在
    @Override
    public User isExist(String phone) {
        return userDao.queryByPhone(phone);
    }

    //注册
    @Override
    public void register(User user) {
        userDao.save(user);
    }

    //判断是否开户
    @Override
    public boolean haveAccount(User user) {
        User person = userDao.queryByPhoneAndHaveAccount(user.getPhone(), user.getHaveAccount());
        if (Objects.isNull(person)){
            //为空表明没有数据,未开户
            return false;
        }
        return true;
    }

    public void getAccount() {

    }
}
