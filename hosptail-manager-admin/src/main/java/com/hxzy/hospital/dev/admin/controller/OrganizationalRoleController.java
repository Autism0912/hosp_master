package com.hxzy.hospital.dev.admin.controller;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.extension.api.R;
//import com.hxzy.hospital.dev.admin.entity.HosUser;
import com.hxzy.hospital.dev.admin.entity.HosUser;
import com.hxzy.hospital.dev.admin.entity.MyDept;
import com.hxzy.hospital.dev.admin.entity.MyRole;
import com.hxzy.hospital.dev.admin.service.DeptService;

import com.hxzy.hospital.dev.admin.service.HosUserService;
import com.hxzy.hospital.dev.common.utils.Result;
import com.hxzy.hospital.dev.common.utils.UserConstants;
import com.hxzy.hospital.dev.log.aop.MyLog;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.hxzy.hospital.dev.common.utils.ResultCode.TABLE_SUCCESS;

@Controller
@RequestMapping("/api/organizationalRole")
@Api(tags = "系统：组织角色")
public class OrganizationalRoleController {
    @Autowired
    private DeptService deptService;
    @Autowired
    private HosUserService hosUserService;
    @GetMapping("index")
    public String index(){
        return "system/organizationalRole/organizationalRole";
    }
    @PutMapping("deptParent")
    @ResponseBody
    //修改状态
    public Result getDeptParent(@RequestBody Map<String,Object> map){
        String id = (String)map.get("id");
        Integer isDel = (Integer)map.get("isDel");
        Integer i = Integer.parseInt(id);
        HosUser hosUser = hosUserService.getId(i);
        hosUser.setIsDel(isDel);
        hosUserService.updateHosUserDel(isDel,i);
        return Result.ok().code(TABLE_SUCCESS);
    }
    @GetMapping("deptSeed/{parentId}")
    @ResponseBody
    public Result getDeptSeed(@PathVariable("parentId") Integer parentId){
        List<MyDept> deptList= deptService.getDeptSeed(parentId);
        return Result.ok().data(deptList).code(TABLE_SUCCESS);
    }
    @GetMapping(value = "/add")
    @ApiOperation(value = "新增科室页面")
    public String editPermission(Model model, MyDept dept, HttpServletRequest httpServletRequest) {
        HttpSession session = httpServletRequest.getSession();
        session.setAttribute("parentId",dept.getDeptId());
        model.addAttribute("myDept",deptService.getDeptById(dept.getDeptId()));
        return "system/organizationalRole/addDept";
    }
    @GetMapping("/update")
    public String update(Model model, HosUser hosUser,HttpServletRequest request){//@PathVariable("roleId")String roleId
        HttpSession session = request.getSession();
        HosUser byId=new HosUser();
        if (ObjectUtil.isNull(hosUser.getId())){
            Integer id = (Integer)session.getAttribute("id");
            byId.setId(id);
            hosUser.setId(id);
            hosUserService.updateID(hosUser);
            System.out.println("hosUserNull:"+byId);
        }else {
            session.setAttribute("id",hosUser.getId());
             byId = hosUserService.getId(hosUser.getId());
            System.out.println("hosUserNotNull:"+byId);
            model.addAttribute("HosUser",byId);
            return "system/organizationalRole/roleUpdate";
        }

        MyRole myRole = new MyRole();

        Date date =new Date();
        byId.setUpdateTime(date);
        return "system/organizationalRole/organizationalRole";
    }
    @PostMapping
    @ResponseBody
    public Result<MyDept> savePermission(@RequestBody Map<String,Object> map, HttpServletRequest httpServletRequest) {
        HttpSession session = httpServletRequest.getSession();
        Integer parentId = (Integer)session.getAttribute("parentId");
        System.out.println("祖id为:"+parentId);
        MyDept dept=new MyDept();
        String deptName = (String) map.get("deptName");
        dept.setDeptName(deptName);
        dept.setParentId(parentId);
        dept.setStatus(1);
        Map<String,Object> map1=new HashMap<>();
        dept.setParams(map);
        System.out.println(dept);
//        boolean save = deptService.save(dept);
        int i = deptService.insertDept(dept);
        return Result.ok();
    }
    @DeleteMapping
    @ResponseBody
    public Result delete(Integer id){
        Integer d = hosUserService.dele(id);
        return Result.ok();
    }
    @GetMapping("rights")
    public String rights(Integer id,Model model){
        HosUser hosUser = hosUserService.getId(id);
        model.addAttribute("HosUser",hosUser);
        return "system/organizationalRole/rights";
    }
}
