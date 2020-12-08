package com.i2finance.bank.dao;
import com.i2finance.bank.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer> {
    //根据手机号查询是否有user对象
    User queryByPhone(String phone);

    //查询是否开户
    User queryByPhoneAndHaveAccount(String phone,byte account);







}
