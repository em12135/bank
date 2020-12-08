package com.i2finance.bank.bean;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

//该注解代表是一个实体类
@Entity
@Data
public class User implements Serializable {
    @Id
    private int uID;

    private String uName;
    private String uPassword;
    private String uPhone;

    //身份证号
    private String uCode;
    //是否开户,默认为0(未开户)
    private byte uHaveAccount;
}
