package com.hxzy.hospital.dev.manage.dao;/*
@Author:龙强
@date:2023/10/27
@version:1.0
*/

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hxzy.hospital.dev.manage.dto.PlanDto;
import com.hxzy.hospital.dev.user.entity.HosPlan;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HosPlan4ServiceDao extends BaseMapper<HosPlan> {
    List<PlanDto> find(Integer id);
}
