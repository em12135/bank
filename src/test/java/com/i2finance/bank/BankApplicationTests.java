package com.i2finance.bank;

import com.i2finance.bank.bean.Card;
import com.i2finance.bank.bean.User;
import com.i2finance.bank.dao.CardDao;
import com.i2finance.bank.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class BankApplicationTests {
    @Autowired
    private UserDao userDao;
    @Autowired
    private CardDao cardDao;

    @Test
    void contextLoads() {

    }

    @Test
    void test_card(){
        List<Card> cards = cardDao.findAllByUId(1);
        System.out.println(cards);
    }


    @Test
    void test_user(){
        User user = userDao.queryByPhone("123");
        System.out.println(user);
    }

}
