package com.hxzy.hospital.dev.manage.dao;/*
@Author:龙强
@date:2023/10/27
@version:1.0
*/

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hxzy.hospital.dev.user.entity.HosPic;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HosPic4ServiceDao extends BaseMapper<HosPic> {
    List<HosPic> find(String sickCode);
}
