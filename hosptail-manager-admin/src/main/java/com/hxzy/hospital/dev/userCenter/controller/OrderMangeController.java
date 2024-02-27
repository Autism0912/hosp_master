package com.hxzy.hospital.dev.userCenter.controller;/*
@Author:龙强
@date:2023/10/23
@version:1.0
*/

import com.hxzy.hospital.dev.common.utils.Result;
import com.hxzy.hospital.dev.common.utils.ResultCode;

import com.hxzy.hospital.dev.userCenter.dto.OrderDto;
import com.hxzy.hospital.dev.userCenter.service.HosUserService;
import com.hxzy.hospital.dev.userCenter.vo.SearchVO;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.util.List;

@Controller
@RequestMapping("/hospital/user")
//@Api(tags = "系统:用户中心")
public class OrderMangeController {
    private final HosUserService hosUserService;

    public OrderMangeController(HosUserService hosUserService, OrderDto orderDto) {
        this.hosUserService = hosUserService;
    }

    @GetMapping("/orderManage")
    public String orderMange() {
        return "/system/user/order-manage";
    }

    @GetMapping("/hosData")
    @ResponseBody
    public Result hosData(Integer page, Integer limit) {
        List<OrderDto> orderDtos = hosUserService.findAll((page-1)*limit, limit);
        return Result.ok().data(orderDtos).count((long) orderDtos.size()).code(ResultCode.TABLE_SUCCESS);
    }

    @GetMapping("/hosData/nostatus")
    @ResponseBody
    public Result hosDataNoStatus(Integer page, Integer limit){
       List<OrderDto> orderDtos =  hosUserService.noStatus((page-1)*limit,limit);
//        System.out.println(orderDtos);
        return Result.ok().data(orderDtos).count((long) orderDtos.size()).code(ResultCode.TABLE_SUCCESS);
    }

    @GetMapping("/hosData/alreadyCode")
    @ResponseBody
    public Result alreadyCode(Integer page, Integer limit){
        List<OrderDto> orderDtos =  hosUserService.alreadyCode((page-1)*limit,limit);
        return Result.ok().data(orderDtos).count((long) orderDtos.size()).code(ResultCode.TABLE_SUCCESS);
    }

    @GetMapping("/search")
    @ResponseBody
    public Result search(SearchVO searchVO) throws ParseException {
        System.out.println(searchVO);
        List<OrderDto> orderDtos =  hosUserService.search(searchVO);
        return Result.ok().data(orderDtos).count((long) orderDtos.size()).code(ResultCode.TABLE_SUCCESS);
    }

    @GetMapping("/details/{id}")
    public ModelAndView details(@PathVariable("id") Integer id){
        OrderDto orderDto  = hosUserService.userdatail(id);
        System.out.println("or========>"+orderDto);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("order",orderDto);
        modelAndView.setViewName("/system/user/order-details");
        return modelAndView;
    }
    @GetMapping("/msg/{id}")
    @ResponseBody
    public ModelAndView msg(@PathVariable("id") Integer id){
        System.out.println("id===========>"+id);
        OrderDto orderDto =  hosUserService.orderMsg(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg",orderDto);
        modelAndView.setViewName("/system/user/order-msg");
        return modelAndView;
    }

    @GetMapping("/audit")
    @ResponseBody
    public Result audit(OrderDto orderDto){
        Result result = hosUserService.audit(orderDto);
        System.out.println("res"+result);
        return result;
    }
}
