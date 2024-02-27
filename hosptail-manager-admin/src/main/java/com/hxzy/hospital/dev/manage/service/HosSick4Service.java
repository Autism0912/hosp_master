package com.hxzy.hospital.dev.manage.service;/*
@Author:龙强
@date:2023/10/27
@version:1.0
*/

import com.hxzy.hospital.dev.admin.entity.HosSick;
import com.hxzy.hospital.dev.common.utils.Result;
import com.hxzy.hospital.dev.manage.dto.ManageDto;
import com.hxzy.hospital.dev.manage.vo.MedicalRecordVo;

import java.util.List;

public interface HosSick4Service {

    List<HosSick> findAll();
    Result<ManageDto> getAll(Integer offset, Integer limit, ManageDto manageDto, String name, Integer id, String time, String illness);

    ManageDto getByids(Integer id);

    boolean updateBy(ManageDto manageDto);

    int delete(Integer id);

    MedicalRecordVo getHosSickInfo(ManageDto manageDto);
}
