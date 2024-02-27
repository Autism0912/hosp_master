package com.hxzy.hospital.dev.console.controller;


import com.hxzy.hospital.dev.common.utils.Result;
import com.hxzy.hospital.dev.console.dto.ConsoleDto;
import com.hxzy.hospital.dev.console.service.ConsoleService;
import com.hxzy.hospital.dev.console.utils.FindByDate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Api(tags = "控制台")
@RequestMapping("/api/control")
public class ConsoleController {
    private final ConsoleService consoleService;
    private final FindByDate findByDate;


    public ConsoleController(ConsoleService consoleService, FindByDate findByDate) {
        this.consoleService = consoleService;
        this.findByDate = findByDate;
    }

    @GetMapping("/index")
    @PreAuthorize("hasAnyAuthority('con:show')")
    @ApiOperation(value = "控制台")
    public String consoletoIndex(Model model) {
        //查询用户总数
        ConsoleDto consoleDto = consoleService.findNum();
        model.addAttribute(consoleDto);
        return "/system/console/staging.html";
    }


    @GetMapping("/find/{id}")
    @ResponseBody
    public Result findByDay(Model model, @PathVariable("id") String label) {
//        ConsoleDto consoleDto = consoleService.findNum();
//        model.addAttribute(consoleDto);
       return findByDate.Date(Integer.parseInt(label));
//        model.addAttribute(consoleDto2);
        //写一个根据年月日季度去查的工具类
//        return "/system/console/staging.html";
    }


}
