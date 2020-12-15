package com.i2finance.bank.dao;

import com.i2finance.bank.bean.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardDao extends JpaRepository<Card,Integer> {
    //查询此用户绑定了哪些卡
    List<Card> findAllByUId(int uid);

    //查看次银行卡号是否已经存在
    Card queryByCode(String code);

    //查询转账相关
    Card queryByCodeAndName(String code,String name);








}
