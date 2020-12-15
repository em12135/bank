package com.i2finance.bank.web.controller;

import com.i2finance.bank.service.impl.CardServiceImpl;
import com.i2finance.bank.util.Result;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "银行卡相关")
@RestController
@RequestMapping("/card")
public class CardController {
    @Autowired
    CardServiceImpl cardService;


    @PostMapping("/add")
    @ApiOperation("用户绑定银行卡")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "code", value = "银行卡号", required = true),
            @ApiImplicitParam(name = "password", value = "银行卡密码", required = true),
            @ApiImplicitParam(name = "name", value = "开户行名称",required = true)
    })
    @ApiModelProperty
    public Result addCard(String code, String password, String name) {
        return cardService.addCard(code, password, name);
    }

}
