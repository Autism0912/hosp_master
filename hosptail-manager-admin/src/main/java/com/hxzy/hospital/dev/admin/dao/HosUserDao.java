package com.hxzy.hospital.dev.admin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hxzy.hospital.dev.admin.entity.HosUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HosUserDao extends BaseMapper<HosUser> {
    List<HosUser> getAll();

    HosUser getById(Integer id);

    int updateId(HosUser hosUser);

    Integer updateIsdel(Integer isDel,Integer id);

    int delete(Integer id);

}
