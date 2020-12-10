package com.i2finance.bank.util;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Result<T> implements Serializable {
    private Integer code;
    private String message;
    private Long time;
    private T data;

    //构造器
    public Result(StatusCode statusCode, T data) {
        this.code = statusCode.getCode();
        this.message = statusCode.getMessage();
        this.time = new Date().getTime();
        this.data = data;
    }

    public Result(StatusCode statusCode) {
        this(statusCode, null);
    }

    //业务成功,也携带了数据
    public static <E> Result success(E data) {
        return new Result<E>(StatusCode.SUCCESS, data);
    }

    //业务失败,携带数据
    public static <F> Result fail(StatusCode statusCode, F data) {
        return new Result<>(statusCode, data);
    }

    //业务失败,无返回数据
    public static Result fail(StatusCode statusCode){
        return new Result(statusCode);
    }
}
