package com.hxzy.hospital.dev.report.controller;

import com.hxzy.hospital.dev.admin.service.DeptService;
import com.hxzy.hospital.dev.admin.service.HosUserService;
import com.hxzy.hospital.dev.common.utils.PageTableRequest;
import com.hxzy.hospital.dev.common.utils.Result;
import com.hxzy.hospital.dev.common.utils.ResultCode;
import com.hxzy.hospital.dev.log.aop.MyLog;
import com.hxzy.hospital.dev.patinceMan.service.HosSickService;
import com.hxzy.hospital.dev.report.entity.HosRepo;
import com.hxzy.hospital.dev.report.service.HosRepoDtoService;
import com.hxzy.hospital.dev.report.service.HosRepoService;
import com.hxzy.hospital.dev.report.vo.HosRepoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/hospital/report")
@Api(tags = "系统: 诊断报告")
public class ReportController {

    @Autowired
    private HosRepoService hosRepoService;
    @Autowired
    private DeptService deptService;
    @Autowired
    private HosUserService hosUserService;
    @Autowired
    private HosSickService hosSickService;
    @Autowired
    private HosRepoDtoService dtoService;

    @GetMapping("/aiagnostic")
    @PreAuthorize("hasAnyAuthority('rep:show')")
    public String doReport(Model model){
        model.addAttribute("MyDept",deptService.selectDeptAll());
        model.addAttribute("HosDoc",hosUserService.selectDocAll());
        return "/report/rep-show";
    }
    //    String sickName, Integer deptId,String createTime, Integer userId
    @GetMapping
    @ResponseBody
    @ApiOperation(value = "诊断报告列表")
    @PreAuthorize("hasAnyAuthority('rep:show')")
    @MyLog("查询诊断报告")
    public Result reportList(PageTableRequest pageTableRequest, HosRepoVo hosRepoVo){
        return hosRepoService.getRepList(pageTableRequest,hosRepoVo);
    }

    @GetMapping("/add")
    @ApiOperation(value = "添加用户页面")
    public String doAdd(Model model){
        model.addAttribute("HosSick",hosSickService.selectSickAll());
        model.addAttribute("MyDept",deptService.selectDeptAll());
        model.addAttribute("HosDoc",hosUserService.selectDocAll());
        return "/report/rep-add";
    }

    @PostMapping
    @ResponseBody
    @MyLog("添加菜单")
    public Result addRepo(@RequestBody HosRepoVo hosRepoVo) throws ParseException {
        return hosRepoService.addRepo(hosRepoVo);
    }

    @GetMapping("/amend")
    @ApiOperation(value = "修改记录页面")
    public String doUpdate(Model model,HosRepo hosRepo) throws ParseException {
        model.addAttribute("hosRepoDto",dtoService.findById(hosRepo.getId()));
        model.addAttribute("MyDept",deptService.selectDeptAll());
        model.addAttribute("HosDoc",hosUserService.selectDocAll());
        return "/report/rep-amend";
    }
    @PutMapping
    @ResponseBody
    @MyLog("修改菜单")
    public Result updateRepo(@RequestBody HosRepoVo hosRepoVo){
        System.out.println("hosRepoVo:" +hosRepoVo);
        return hosRepoService.updateRepo(hosRepoVo);
    }

    @DeleteMapping
    @ResponseBody
    @MyLog("删除诊断记录")
    public Result deleteRepo(Integer id){
        int count = hosRepoService.deleteRepo(id);
        return Result.judge(count,"删除诊断记录");
    }

    @GetMapping("audit")
    @ApiOperation(value = "审核记录页面")
    public String doAudit(Model model,HosRepo hosRepo) throws ParseException {
        model.addAttribute("hosRepoDto",dtoService.findById(hosRepo.getId()));
        return "/report/rep-audit";
    }

    @PutMapping("auditRepo")
    @ResponseBody
    @MyLog("审核")
    public Result auditRepo(HosRepoVo hosRepoVo){
        System.out.println(hosRepoVo);
        return hosRepoService.auditRepo(hosRepoVo);
    }

    @GetMapping("/details")
    @ResponseBody
    @MyLog("详情Pdf")
    public Result doDetails(Integer id){
        System.out.println(id);
        String url = hosRepoService.getPdf(id);
        Map map = new HashMap<>();
        map.put("url","http://47.109.94.40:8888/images/test.pdf");
        return Result.ok().data2(map).code(ResultCode.TABLE_SUCCESS);
    }


}
