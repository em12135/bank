package com.i2finance.bank.bean;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@ApiModel
@DynamicInsert
@DynamicUpdate
@Data
@Entity
public class Transaction implements Serializable {
    @Id
    @Column(name = "t_id")
    private int tId;

    //收款人信息
    @Column(name = "t_in_account_name")
    private String tInAccountName;
    @Column(name = "t_in_bank_name")
    private String tInBankName;
    @Column(name = "t_in_bank_code")
    private String tInBankCode;


    @Column(name = "t_out_bank_code")
    private String tOutBankCode;
    @Column(name = "t_out_money")
    private double tOutMoney;
    @Column(name = "t_time")
    private Date  tTime;
    @Column(name = "t_card_id")
    private int tCardId;
}
