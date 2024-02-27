package com.hxzy.hospital.dev.manage.controller;

import com.hxzy.hospital.dev.common.utils.PageTableRequest;
import com.hxzy.hospital.dev.common.utils.Result;
import com.hxzy.hospital.dev.manage.dto.ManageDto;
import com.hxzy.hospital.dev.manage.service.*;
import com.hxzy.hospital.dev.manage.vo.MedicalRecordVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@RestController
@RequestMapping("/hospital")
public class MannageController {
    @Autowired
    private HosSick4Service hosSickService;
    @Autowired
    private HosOrder4Service hosOrderService;

    @GetMapping("/fileManagement/management")
    public ModelAndView getMannage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/system/mannage/mannage");
        return modelAndView;
    }

    @GetMapping("/fileManagement/manage")
    @ResponseBody
    public Result<ManageDto> getmanage(PageTableRequest pageTableRequest, ManageDto manageDto,
                                       @RequestParam("sname") String name,
                                       @RequestParam("recordid") Integer id,
                                       @RequestParam("date") String time,
                                       @RequestParam("illness") String illness){
        pageTableRequest.countOffset();
        return hosSickService.getAll(pageTableRequest.getOffset(),pageTableRequest.getLimit(),manageDto,name,id,time,illness);
    }
    @RequestMapping("/fileManagement/detail")
    public ModelAndView getDetail(ManageDto manageDto){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("sick",hosSickService.getByids(manageDto.getId()));
        modelAndView.setViewName("/system/mannage/detail");
        return modelAndView;
    }

    @RequestMapping("/edit")
    public ModelAndView getEdit(ManageDto manageDto){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("sick",hosSickService.getByids(manageDto.getId()));
        modelAndView.setViewName("/system/mannage/updateManage");
        return modelAndView;
    }
    @PutMapping("/edit/update")
    public Result update(@RequestBody ManageDto manageDto){
        hosSickService.updateBy(manageDto);
        hosOrderService.updateBy(manageDto);
        return Result.ok();
    }

    @DeleteMapping("/delete")
    @ResponseBody
    public Result<ManageDto> delete(Integer id){
       int count = hosSickService.delete(id);
       return Result.judge(count,"删除用户");
    }
    @GetMapping("/record")
    public ModelAndView record(ManageDto manageDto){
        ModelAndView modelAndView = new ModelAndView();
        MedicalRecordVo hosSickInfo = hosSickService.getHosSickInfo(manageDto);
        modelAndView.addObject("medicalRecordVo",hosSickInfo);
        modelAndView.setViewName("/system/mannage/index");
        return modelAndView;
    }


}
