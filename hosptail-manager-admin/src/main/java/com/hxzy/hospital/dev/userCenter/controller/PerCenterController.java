package com.hxzy.hospital.dev.userCenter.controller;


import com.baomidou.mybatisplus.extension.api.R;
import com.hxzy.hospital.dev.admin.entity.MyUser;
import com.hxzy.hospital.dev.common.utils.Result;
import com.hxzy.hospital.dev.common.utils.ResultCode;
import com.hxzy.hospital.dev.security.dto.JwtUserDto;
import com.hxzy.hospital.dev.userCenter.dto.PersonMsgDto;
import com.hxzy.hospital.dev.userCenter.entity.MyDept;
import com.hxzy.hospital.dev.userCenter.service.MyDeptService;
import com.hxzy.hospital.dev.userCenter.service.MyUserService;
import com.hxzy.hospital.dev.userCenter.vo.EditPassword;
import com.hxzy.hospital.dev.userCenter.vo.PersonMsgVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

import static com.sun.xml.internal.ws.api.message.Packet.Status.Request;

/**
 * 以下是接收用户中心的修改数据请求
 */

@Controller
@RequestMapping("/hos/user")
@Api(tags = "系统:用户中心")
public class PerCenterController {
    private final MyUserService myUserService;

    private final MyDeptService deptService;

    public PerCenterController(MyUserService myUserService, MyDeptService deptService) {
        this.myUserService = myUserService;
        this.deptService = deptService;
    }
    JwtUserDto jwtUserDto;
    @GetMapping("/info")
    @PreAuthorize("hasAnyAuthority('per:show')")
    @ApiOperation(value = "个人资料")
    public ModelAndView personMsg(HttpServletRequest request) {
        HttpSession session = request.getSession();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/system/user/user-center");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        //获取令牌中的数据
        jwtUserDto = (JwtUserDto) authentication.getPrincipal();

        //科室信息
        List<MyDept> list = deptService.findSection();
        //根据令牌中的数据查询
        PersonMsgDto personMsgDto = myUserService.findAll(jwtUserDto, list);


        modelAndView.addObject("principal", personMsgDto);

        return modelAndView;
    }

    PersonMsgDto personMsgDto = new PersonMsgDto();
    @GetMapping("/receive")
    @ResponseBody
    public Result userCenter(PersonMsgVO personMsgVO){

        System.out.println(personMsgVO);

        if (personMsgVO.getNickname()!=null){
            personMsgDto = myUserService.updabyName(personMsgVO,jwtUserDto);
        }
        System.out.println("djajg====>"+personMsgDto);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(personMsgDto);
        return Result.ok().code(ResultCode.TABLE_SUCCESS).data(Arrays.asList(modelAndView));
    }

    @GetMapping("/editpassword")
    @ResponseBody
    public Result editPassword(EditPassword editPassword){
        System.out.println(1111111);
        System.out.println(editPassword);
        int rs =  myUserService.editPassword(editPassword);
        System.out.println("rs:"+rs);
        if (rs==2){
            return Result.error().code(2);
        }
        if (rs==0){
            return Result.ok().code(ResultCode.TABLE_SUCCESS);
        }
       return Result.error().code(ResultCode.ERROR);
    }





}
