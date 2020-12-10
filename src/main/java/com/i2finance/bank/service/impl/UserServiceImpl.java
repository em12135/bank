package com.i2finance.bank.service.impl;

import com.i2finance.bank.bean.User;
import com.i2finance.bank.dao.UserDao;
import com.i2finance.bank.exception.BankException;
import com.i2finance.bank.service.IUserService;
import com.i2finance.bank.util.JwtTokenUtils;
import com.i2finance.bank.util.Result;
import com.i2finance.bank.util.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    UserDao userDao;

    //注入redis客户端对象
    @Autowired
    private StringRedisTemplate redisTemplate;

    //判断手机号是否已经存在
    @Override
    public User isExist(String phone) {
        return userDao.queryByPhone(phone);
    }

    //注册功能
    @Override
    public Result register(String phone, String password) {
        User user = userDao.queryByPhone(phone);
        if (Objects.nonNull(user)) {
            //用户已经存在 ,需要跳转登录
            throw new BankException(StatusCode.USER_HAS_EXISTED);
        }
        User addUser = new User();
        addUser.setPhone(phone);
        addUser.setPassword(password);
        userDao.save(addUser);
        return Result.success();
    }

    //判断是否开户
    @Override
    public boolean haveAccount(User user) {
        User person = userDao.queryByPhoneAndHaveAccount(user.getPhone(), user.getHaveAccount());
        if (Objects.isNull(person)) {
            //为空表明没有数据,未开户
            return false;
        }
        return true;
    }

    //登录功能
    @Override
    public Result login(String phone, String password) {
        User user = userDao.queryByPhone(phone);
        //判断该手机号是否注册,
        if (Objects.isNull(user)) {
            //用户不存在,此处需要提示是否去注册,跳转页面
            throw new BankException(StatusCode.USER_NOT_EXIST);
        }
        //判断用户密码是否正确,如果不匹配,密码不正确
        if (!password.equals(user.getPassword())) {
            throw new BankException(StatusCode.USER_LOGIN_ERROR);
        }

        //登录成功,根据手机号产生token
        String token = JwtTokenUtils.createToken(phone);

        //将token存入redis                               //时间过期长度              时间单位
        redisTemplate.opsForValue().set(phone, token, JwtTokenUtils.EXPIRATION, TimeUnit.MILLISECONDS);

        /**
         *登陆成功后,需要验证其是否开户以及绑卡...  功能仍需完善
         */

        return Result.success(token);
    }

    @Override
    public Result createAccount() {

        return null;
    }

    public void getAccount() {

    }
}
