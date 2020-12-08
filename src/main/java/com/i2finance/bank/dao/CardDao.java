package com.i2finance.bank.dao;

import com.i2finance.bank.bean.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardDao extends JpaRepository<Card,Integer> {
    //查询此用户是否绑卡
    List<Card> findAllByUId(int uid);


}
