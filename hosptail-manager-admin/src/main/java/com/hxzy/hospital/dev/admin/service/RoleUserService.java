package com.hxzy.hospital.dev.admin.service;

import com.hxzy.hospital.dev.admin.entity.MyRoleUser;

import java.util.List;

/**
 * @author Ghl
 * @createTime 2023/4/26
 */
public interface RoleUserService {
    /**
     * 返回用户拥有的角色
     * @param userId
     * @return
     */
    List<MyRoleUser> getMyRoleUserByUserId(Integer userId);
}
