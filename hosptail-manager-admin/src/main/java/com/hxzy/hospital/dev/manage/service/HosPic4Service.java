package com.hxzy.hospital.dev.manage.service;/*
@Author:龙强
@date:2023/10/27
@version:1.0
*/

import com.hxzy.hospital.dev.user.entity.HosPic;

import java.util.List;

public interface HosPic4Service {
    List<HosPic> find(String sickCode);
}
