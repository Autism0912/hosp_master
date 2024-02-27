package com.hxzy.hospital.dev.manage.service.impl;/*
@Author:龙强
@date:2023/10/27
@version:1.0
*/

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hxzy.hospital.dev.manage.dao.HosOrder4ServiceDao;
import com.hxzy.hospital.dev.manage.dto.ManageDto;
import com.hxzy.hospital.dev.manage.entity.HosOrder;
import com.hxzy.hospital.dev.manage.service.HosOrder4Service;
import org.springframework.stereotype.Service;

@Service
public class HosOrder4ServiceImpl extends ServiceImpl<HosOrder4ServiceDao, HosOrder> implements HosOrder4Service {

    @Override
    public void updateBy(ManageDto manageDto) {
        HosOrder hosOrder = super.getOne(new QueryWrapper<HosOrder>().eq("sick_code", manageDto.getSickCode()));
        hosOrder.setIllness(manageDto.getIllness());
        super.updateById(hosOrder);
    }
}
