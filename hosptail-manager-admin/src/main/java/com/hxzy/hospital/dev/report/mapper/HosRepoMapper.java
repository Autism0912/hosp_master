package com.hxzy.hospital.dev.report.mapper;

import com.hxzy.hospital.dev.report.entity.HosRepo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hxzy.hospital.dev.report.vo.HosRepoVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author baby9
* @description 针对表【hos_repo(诊断报告表)】的数据库操作Mapper
* @createDate 2023-10-23 11:46:36
* @Entity com.hxzy.hospital.dev.entity.HosRepo
*/
@Mapper
public interface HosRepoMapper extends BaseMapper<HosRepo> {

    List<HosRepo> selList(HosRepoVo hosRepoVo);

    Integer addRepo(HosRepo hosRepo);

    int updateRepo(HosRepoVo hosRepoVo);

    int auditRepo(HosRepoVo hosRepoVo);
}




