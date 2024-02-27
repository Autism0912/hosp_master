package com.hxzy.hospital.dev.console.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hxzy.hospital.dev.console.dto.ConsoleDto;
import com.hxzy.hospital.dev.console.dto.TableOfVisitDto;
import com.hxzy.hospital.dev.console.entity.MyUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author : 龙强
 * @Date : 2023/10/30
 * @Version : 1.0
 */
@Mapper
public interface ConsoleServiceDao extends BaseMapper<MyUser> {
    ConsoleDto findNum();

    List<TableOfVisitDto> findByDay();

    ConsoleDto findByWeek();

    ConsoleDto findByMonth();

    ConsoleDto findByQuater();

    ConsoleDto findByYear();
}
