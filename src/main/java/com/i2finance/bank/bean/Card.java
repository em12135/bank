package com.i2finance.bank.bean;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
public class Card implements Serializable {
    @Id
    private int cId;

    private String cCode;
    private String cName;
    private double cBalance;
    private int cUId;
    private String cPassword;
}
