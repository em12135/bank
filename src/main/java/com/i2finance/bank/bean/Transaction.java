package com.i2finance.bank.bean;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;
@Data
@Entity
public class Transaction implements Serializable {
    @Id
    private int tId;

    //收款人信息
    private String tInAccountName;
    private String tInBankName;
    private String tInBankCode;


    private String tOutBankCode;
    private double tOutMoney;
    private Date  tTime;
}
