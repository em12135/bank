package com.i2finance.bank.dao;

import com.i2finance.bank.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer> {

}
