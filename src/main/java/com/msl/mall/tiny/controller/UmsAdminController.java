package com.msl.mall.tiny.controller;

import com.msl.mall.tiny.common.api.CommonResult;
import com.msl.mall.tiny.mbg.model.UmsAdmin;
import com.msl.mall.tiny.service.UmsAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
@Api(tags = "UmsAdminController",description = "后台用户管理")
public class UmsAdminController {
    @Autowired
    private UmsAdminService adminService;
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @ApiOperation(value = "用户注册")
    @PostMapping("/register")

    public CommonResult<UmsAdmin> register(@RequestBody UmsAdmin umsAdminParam){
        UmsAdmin umsAdmin = adminService.register(umsAdminParam);
        if(umsAdmin==null){
            CommonResult.failed();
        }
        return CommonResult.success(umsAdmin);
    }

    @ApiOperation("登录以后返回Token")
    @PostMapping("/login")
    public CommonResult login(@RequestBody UmsAdmin umsAdmin){
        String token = adminService.login(umsAdmin.getUsername(), umsAdmin.getPassword());
        return null;
    }





}
