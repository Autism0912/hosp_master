package com.hxzy.hospital.dev.manage.service.impl;/*
@Author:龙强
@date:2023/10/27
@version:1.0
*/

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hxzy.hospital.dev.manage.dao.HosRepo4ServiceDao;
import com.hxzy.hospital.dev.manage.dto.RepoDto;
import com.hxzy.hospital.dev.manage.service.HosRepo4Service;
import com.hxzy.hospital.dev.user.entity.HosRepo;
import org.springframework.stereotype.Service;

@Service
public class HosRepo4ServiceImpl extends ServiceImpl<HosRepo4ServiceDao, HosRepo> implements HosRepo4Service {

    private final HosRepo4ServiceDao hosRepo4ServiceDao;

    public HosRepo4ServiceImpl(HosRepo4ServiceDao hosRepo4ServiceDao) {
        this.hosRepo4ServiceDao = hosRepo4ServiceDao;
    }

    @Override
    public RepoDto find(String sickCode) {
        return hosRepo4ServiceDao.find(sickCode);
    }
}
