package com.hxzy.hospital.dev.report.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hxzy.hospital.dev.report.dto.HosRepoDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HosRepoDtoMapper extends BaseMapper<HosRepoDto> {
    HosRepoDto findById(Integer id);
}
