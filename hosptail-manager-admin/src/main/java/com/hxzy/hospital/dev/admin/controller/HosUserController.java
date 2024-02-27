package com.hxzy.hospital.dev.admin.controller;

import com.hxzy.hospital.dev.admin.entity.HosUser;
import com.hxzy.hospital.dev.admin.service.HosUserService;
import com.hxzy.hospital.dev.common.utils.Result;
import com.hxzy.hospital.dev.common.utils.ResultCode;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/api/hosUser")
@Api(tags = "用户描述信息")
public class HosUserController {
    @Autowired
    private HosUserService hosUserService;
    @GetMapping
    @ResponseBody
    public Result<HosUser> getHosUser(){
        List<HosUser> hosUserList=hosUserService.getAll();
        return Result.ok().code(ResultCode.TABLE_SUCCESS).data(hosUserList);
    }
    @PutMapping
    @ResponseBody
    @PreAuthorize("hasAnyAuthority('hos:update')")
    public Result update(HosUser hosUser){
        return hosUserService.updateHosUser(hosUser);
    }
}
