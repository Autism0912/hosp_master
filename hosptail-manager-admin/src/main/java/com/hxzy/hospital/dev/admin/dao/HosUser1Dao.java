package com.hxzy.hospital.dev.admin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hxzy.hospital.dev.admin.entity.HosUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HosUser1Dao extends BaseMapper<HosUser> {
    List<HosUser> findAll();
}
