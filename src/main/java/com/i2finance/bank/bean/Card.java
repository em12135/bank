package com.i2finance.bank.bean;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
@DynamicInsert
@DynamicUpdate
public class Card implements Serializable {
    @Column(name = "c_id")
    @Id
    private int Id;

    @Column(name = "c_code")
    private String Code;
    @Column(name = "c_name")
    private String Name;
    @Column(name = "c_balance")
    private double Balance;
    @Column(name = "c_u_id")
    private int UId;
    @Column(name = "c_password")
    private String Password;
}
