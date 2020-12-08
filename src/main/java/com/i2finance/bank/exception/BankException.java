package com.i2finance.bank.exception;

import com.i2finance.bank.util.StatusCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

//自定义异常类
@Getter
@AllArgsConstructor
public class BankException extends RuntimeException{

private StatusCode statusCode;
}
