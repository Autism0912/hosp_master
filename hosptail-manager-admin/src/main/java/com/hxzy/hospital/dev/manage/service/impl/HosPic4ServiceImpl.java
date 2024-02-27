package com.hxzy.hospital.dev.manage.service.impl;/*
@Author:龙强
@date:2023/10/27
@version:1.0
*/

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hxzy.hospital.dev.manage.dao.HosPic4ServiceDao;
import com.hxzy.hospital.dev.manage.service.HosPic4Service;
import com.hxzy.hospital.dev.user.entity.HosPic;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HosPic4ServiceImpl extends ServiceImpl<HosPic4ServiceDao, HosPic> implements HosPic4Service {
    private final HosPic4ServiceDao hosPic4ServiceDao;

    public HosPic4ServiceImpl(HosPic4ServiceDao hosPic4ServiceDao) {
        this.hosPic4ServiceDao = hosPic4ServiceDao;
    }

    @Override
    public List<HosPic> find(String sickCode) {
        return hosPic4ServiceDao.find(sickCode);
    }
}
