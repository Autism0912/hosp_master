package com.hxzy.hospital.dev.manage.service.impl;/*
@Author:龙强
@date:2023/10/27
@version:1.0
*/

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hxzy.hospital.dev.manage.dao.HosPlan4ServiceDao;
import com.hxzy.hospital.dev.manage.dto.PlanDto;
import com.hxzy.hospital.dev.manage.service.HosPlan4Service;
import com.hxzy.hospital.dev.user.entity.HosPlan;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HosPlan4ServiceImpl extends ServiceImpl<HosPlan4ServiceDao, HosPlan> implements HosPlan4Service {
   private final HosPlan4ServiceDao hosPlan4ServiceDao;

    public HosPlan4ServiceImpl(HosPlan4ServiceDao hosPlan4ServiceDao) {
        this.hosPlan4ServiceDao = hosPlan4ServiceDao;
    }

    @Override
    public List<PlanDto> find(Integer id) {
        return hosPlan4ServiceDao.find(id);
    }
}

