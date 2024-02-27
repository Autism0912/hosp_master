package com.hxzy.hospital.dev.manage.dao;/*
@Author:龙强
@date:2023/10/27
@version:1.0
*/

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hxzy.hospital.dev.manage.dto.RepoDto;
import com.hxzy.hospital.dev.user.entity.HosRepo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HosRepo4ServiceDao extends BaseMapper<HosRepo> {
    RepoDto find(String sickCode);
}
