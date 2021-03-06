package com.i2finance.bank.web.controller;

import com.i2finance.bank.service.impl.UserServiceImpl;
import com.i2finance.bank.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Api(tags = "用户操作相关")
public class UserController {

    @Autowired
    UserServiceImpl userService;


    @ApiOperation("用户登录")
    @PostMapping("/login")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone", value = "登录手机号", required = true),
            @ApiImplicitParam(name = "password", value = "登录密码", required = true)
    })
    public Result login(String phone, String password) {

        return userService.login(phone, password);
    }

    @ApiOperation("用户注册")
    @PostMapping("/register")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone", value = "登录手机号", required = true),
            @ApiImplicitParam(name = "password", value = "登录密码", required = true)
    })
    public Result register(String phone, String password) {
        return userService.register(phone, password);
    }

    @ApiOperation("用户开户")
    @PostMapping("/createAccount")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name",value = "开户姓名",required = true),
            @ApiImplicitParam(name = "code",value = "身份证号码",required = true)
    })
    public Result openAccount(String name, String code) {

        return userService.createAccount(name, code);
    }

}
