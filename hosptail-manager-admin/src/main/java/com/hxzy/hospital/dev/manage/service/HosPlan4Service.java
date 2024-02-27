package com.hxzy.hospital.dev.manage.service;/*
@Author:龙强
@date:2023/10/27
@version:1.0
*/

import com.baomidou.mybatisplus.extension.service.IService;
import com.hxzy.hospital.dev.manage.dto.PlanDto;
import com.hxzy.hospital.dev.user.entity.HosPlan;

import java.util.List;

public interface HosPlan4Service extends IService<HosPlan> {
    List<PlanDto> find(Integer id);
}
