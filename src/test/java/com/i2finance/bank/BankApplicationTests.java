package com.i2finance.bank;

import com.i2finance.bank.bean.Card;
import com.i2finance.bank.bean.User;
import com.i2finance.bank.dao.CardDao;
import com.i2finance.bank.dao.UserDao;
import com.i2finance.bank.service.impl.UserServiceImpl;
import com.i2finance.bank.util.Result;
import com.i2finance.bank.util.StatusCode;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class BankApplicationTests {
    @Autowired
    private UserDao userDao;
    @Autowired
    private CardDao cardDao;

    @Autowired
    UserServiceImpl userService;

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

    @Test
    void test_userSave(){
        User user = new User();
        user.setId(1);
        user.setPassword("321");
        user.setPhone("321");
        userDao.save(user);
    }

    @Test
    void test_userFind(){
        Optional<User> byId = userDao.findById(2);
        User user = byId.get();
        System.out.println(user);
    }

    //测试返回值是否为空
//    @Test
//    void test_userService(){
//        User user = new User();
//        user.setPhone("321");
//        user.setHaveAccount((byte) 0);
//        boolean b = userService.haveAccount(user);    //该方法已删除 之前测试通过
//        System.out.println(b);
//    }

    @Test
    void test_stateCode(){
        //System.out.println(StatusCode.USER_NOT_EXIST.getCode()+StatusCode.USER_NOT_EXIST.getMessage());
        Result result = new Result(StatusCode.USER_NOT_EXIST);

        System.out.println(result);
    }

}
