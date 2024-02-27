package com.hxzy.hospital.dev.manage.service;/*
@Author:龙强
@date:2023/10/27
@version:1.0
*/

import com.hxzy.hospital.dev.manage.dto.RepoDto;

public interface HosRepo4Service {
    RepoDto find(String sickCode);
}
