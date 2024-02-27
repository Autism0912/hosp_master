package com.hxzy.hospital.dev.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hxzy.hospital.dev.admin.entity.HosUser;
import com.hxzy.hospital.dev.common.utils.Result;

import java.util.List;

public interface HosUserService extends IService<HosUser> {
    List<HosUser> getAll();

    Result updateHosUser(HosUser hosUser);

    HosUser getId(Integer id);

    void updateID(HosUser hosUser);

    void updateHosUserDel(Integer isDel,Integer id);

    Integer dele(Integer id);

    List<HosUser> selectDocAll();
}
