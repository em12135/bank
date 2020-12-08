package com.i2finance.bank.web.controller;

import com.i2finance.bank.service.impl.UserServiceImpl;
import com.i2finance.bank.util.Result;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Api(tags = "用户操作相关")
public class UserController {
    //
    @Autowired
    UserServiceImpl userService;

    public Result login(String phone, String password) {
        return null;
    }

}
