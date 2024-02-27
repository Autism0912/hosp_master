package com.hxzy.hospital.dev.admin.service.impl;

import com.hxzy.hospital.dev.admin.dao.RoleUserDao;
import com.hxzy.hospital.dev.admin.entity.MyRoleUser;
import com.hxzy.hospital.dev.admin.service.RoleUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author codermy
 * @createTime 2020/7/10
 */
@Service
public class RoleUserServiceImpl implements RoleUserService {
    @Autowired
    private RoleUserDao roleUserDao;
    @Override
    public List<MyRoleUser> getMyRoleUserByUserId(Integer userId) {
       return roleUserDao.getMyRoleUserByUserId(userId);

    }
}
