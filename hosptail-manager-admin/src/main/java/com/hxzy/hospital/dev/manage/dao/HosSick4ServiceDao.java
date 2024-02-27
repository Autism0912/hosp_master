package com.hxzy.hospital.dev.manage.dao;/*
@Author:龙强
@date:2023/10/27
@version:1.0
*/

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hxzy.hospital.dev.manage.dto.ManageDto;
import com.hxzy.hospital.dev.manage.entity.HosSick;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HosSick4ServiceDao extends BaseMapper<HosSick> {
    List<ManageDto> getAll(ManageDto manageDto, String name, Integer id, String time, String illness);

    ManageDto getByid(Integer id);

    int deleteBy(Integer id);

    List<com.hxzy.hospital.dev.admin.entity.HosSick> findAll();
}
