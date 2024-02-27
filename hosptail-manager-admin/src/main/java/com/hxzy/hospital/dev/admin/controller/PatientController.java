package com.hxzy.hospital.dev.admin.controller;

import com.hxzy.hospital.dev.admin.entity.HosOrder;
import com.hxzy.hospital.dev.admin.entity.view.OrderSick;
import com.hxzy.hospital.dev.admin.service.HosOrderService;
import com.hxzy.hospital.dev.admin.service.OrderSickService;
import com.hxzy.hospital.dev.common.utils.Result;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

import static com.hxzy.hospital.dev.common.utils.ResultCode.TABLE_SUCCESS;

@Controller
@RequestMapping("/hospital/reservation")
@Api(tags = "患者预约患者")
public class PatientController {
    @Autowired
    private HosOrderService hosOrderService;
    @Autowired
    private OrderSickService orderSickService;
    @GetMapping("order")
    public String order(){
        return "system/patient/order";
    }
    @GetMapping()
    @ResponseBody
    public Result getALL(){

//        List<HosOrder> list=hosOrderService.getAll();
        List<OrderSick> list=orderSickService.getAll();
//        System.out.println(list);
        return Result.ok().data(list).code(TABLE_SUCCESS);
    }
    @GetMapping("get")
    public String Get(Integer id, Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        OrderSick orderSick = orderSickService.getId(id);
        session.setAttribute("orderSick",orderSick);
        model.addAttribute("orderSick",orderSick);
        return "system/patient/patients";
    }
    @PostMapping
    @ResponseBody
    public Result post(Integer id){
        Integer i= hosOrderService.setOrderApprova(id);
        return Result.ok();
    }

    @RequestMapping(value = "/save",method = RequestMethod.PUT)
    @ResponseBody
    public Result save(OrderSick orderSick,HttpServletRequest request){
        HttpSession session = request.getSession();
        OrderSick orderSick1 = (OrderSick)session.getAttribute("orderSick");
        orderSick.setId(orderSick1.getId());
        System.out.println(orderSick);
        Integer i= orderSickService.update(orderSick1);
        return Result.ok();
    }
}
