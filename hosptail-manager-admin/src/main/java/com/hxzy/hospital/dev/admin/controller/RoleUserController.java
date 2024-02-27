package com.hxzy.hospital.dev.admin.controller;

import com.hxzy.hospital.dev.admin.entity.MyRoleUser;
import com.hxzy.hospital.dev.log.aop.MyLog;
import com.hxzy.hospital.dev.admin.service.RoleUserService;
import com.hxzy.hospital.dev.common.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 数据权限过滤注解
 * @author Ghl
 * @createTime 2023/4/26
 */
@Controller
@RequestMapping("/api/roleuser")
@Api(tags = "系统：用户角色管理")
public class RoleUserController {
    @Autowired
    private RoleUserService roleUserService;

    @PostMapping()
    @ResponseBody
    @ApiOperation(value = "通过用户id返回用户角色")
    @PreAuthorize("hasAnyAuthority('user:list')")
    @MyLog("查询用户角色")
    public Result getRoleUserByUserId(Integer userId) {
        List<MyRoleUser> tbRoleUser =roleUserService.getMyRoleUserByUserId(userId);
        if(tbRoleUser != null){
            return Result.ok().data(tbRoleUser);
        }else{
            return Result.error();
        }
    }
}
