package com.i2finance.bank.util;

import com.i2finance.bank.exception.BankException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//统一异常处理
@RestControllerAdvice
public class BankExceptionHandler {
    @ExceptionHandler(Exception.class)
    public Result handlerException(Exception ex) {
        BankException bankException = null;
        if (ex instanceof BankException) {
            bankException = (BankException) ex;
        } else {
            bankException = new BankException(StatusCode.SYSTEM_INNER_ERROR);
        }
        return Result.fail(bankException.getStatusCode());
    }
}
