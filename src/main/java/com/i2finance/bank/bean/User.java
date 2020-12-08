package com.i2finance.bank.bean;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

//该注解代表是一个实体类
@Entity
@Data
@Table(name = "user")
public class User implements Serializable {
    @Id
    @Column(name = "uid")
    private int id;
    @Column(name = "u_name")
    private String name;
    @Column(name = "u_password")
    private String password;
    @Column(name = "u_phone")
    private String phone;

    //身份证号
    @Column(name = "u_code")
    private String code;

    @Column(name = "u_have_account")
    //是否开户,默认为0(未开户)
    private byte haveAccount;
}
