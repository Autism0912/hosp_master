package com.hxzy.hospital.dev.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hxzy.hospital.dev.admin.annotation.DataPermission;
import com.hxzy.hospital.dev.admin.dao.HosUserDao;
import com.hxzy.hospital.dev.admin.entity.HosUser;
import com.hxzy.hospital.dev.admin.service.HosUserService;
import com.hxzy.hospital.dev.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HosUserImpl extends ServiceImpl<HosUserDao, HosUser> implements HosUserService {

    @Autowired
    private HosUserDao hosUserDao;
    @Override
    @DataPermission(deptAlias = "d")
    public List<HosUser> getAll() {
        List<HosUser>hosUserList= hosUserDao.getAll();

        return hosUserList;
    }

    @Override
    public Result updateHosUser(HosUser hosUser) {
        int i = hosUserDao.updateById(hosUser);
        if (i>0){
            return Result.ok().message("更新成功");
        }
        return Result.error().message("更新失败");
    }

    @Override
    public HosUser getId(Integer id) {
        return hosUserDao.getById(id);
    }

    @Override
    public void updateID(HosUser hosUser) {
        int i = hosUserDao.updateId(hosUser);
    }

    @Override
    public void updateHosUserDel(Integer isDel,Integer id) {
        Integer integer = hosUserDao.updateIsdel(isDel,id);
    }

    @Override
    public Integer dele(Integer id) {
        int delete = hosUserDao.delete(id);
        System.out.println("delete"+delete);
        return delete;
    }

    @Override
    public List<HosUser> selectDocAll() {
        return hosUserDao.getAll();
    }
}
