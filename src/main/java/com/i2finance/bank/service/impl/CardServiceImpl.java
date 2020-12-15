package com.i2finance.bank.service.impl;

import com.i2finance.bank.bean.Card;
import com.i2finance.bank.bean.User;
import com.i2finance.bank.dao.CardDao;
import com.i2finance.bank.dao.UserDao;
import com.i2finance.bank.exception.BankException;
import com.i2finance.bank.service.ICardService;
import com.i2finance.bank.util.LoginUser;
import com.i2finance.bank.util.Result;
import com.i2finance.bank.util.StatusCode;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
public class CardServiceImpl implements ICardService {

    @Autowired
    CardDao cardDao;

    @Autowired
    UserDao userDao;


    @Override
    public Result addCard(String code, String password, String name) {
        Card repeat = cardDao.queryByCode(code);
        if (!Objects.isNull(repeat)) {
            //不为空,则表示银行卡号重复
            throw new BankException(StatusCode.CARD_EXISTED);
        }
        User user = LoginUser.user;
        Card card = new Card();
        card.setCode(code);
        card.setPassword(password);
        card.setName(name);
        card.setUId(user.getId());
        cardDao.save(card);

        return Result.success();
    }

    //转账
    @Transactional
    public Result transfer(String name, String code, String bank, String outCode, double outMoney) {
        byte haveAccount = LoginUser.user.getHaveAccount();
        //验证当前用户是否开户
        if ((byte)1!=haveAccount){
            throw new BankException(StatusCode.USER_NOT_HAVE_ACCOUNT);
        }

        Card cardOut = cardDao.queryByCode(outCode);

        Card card = cardDao.queryByCodeAndName(code, bank);
        if (Objects.isNull(card)){
            throw new BankException(StatusCode.CARD_NOT_EXIST);
        }
        //卡号存在,验证用户名是否正确
        int uId = card.getUId();
        User user = userDao.queryById(uId);
        //判断填写的用户名和数据库是否相同
        if (!StringUtils.equals(name, user.getName())){
            throw new BankException(StatusCode.DATA_ERROR);
        }

        //收款人信息正确,开始转账




    }
}
