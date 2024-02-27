package com.hxzy.hospital.dev.report.service;

import com.hxzy.hospital.dev.common.utils.PageTableRequest;
import com.hxzy.hospital.dev.common.utils.Result;
import com.hxzy.hospital.dev.report.dto.HosRepoDto;
import com.hxzy.hospital.dev.report.entity.HosRepo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hxzy.hospital.dev.report.vo.HosRepoVo;

import java.text.ParseException;
import java.util.List;

/**
* @author baby9
* @description 针对表【hos_repo(诊断报告表)】的数据库操作Service
* @createDate 2023-10-23 11:46:36
*/
public interface HosRepoService extends IService<HosRepo> {

    Result getRepList(PageTableRequest pageTableRequest, HosRepoVo hosRepoVo);

    Result addRepo(HosRepoVo hosRepoVo) throws ParseException;

    int deleteRepo(Integer id);

    Result updateRepo(HosRepoVo hosRepoVo);

    Result auditRepo(HosRepoVo hosRepoVo);

    String getPdf(Integer id);
}
