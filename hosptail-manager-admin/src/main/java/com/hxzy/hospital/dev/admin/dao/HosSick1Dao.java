package com.hxzy.hospital.dev.admin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hxzy.hospital.dev.admin.entity.HosSick;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HosSick1Dao extends BaseMapper<HosSick> {
    List<HosSick> findAll();
}
