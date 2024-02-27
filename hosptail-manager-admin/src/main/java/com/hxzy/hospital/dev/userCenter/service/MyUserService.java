package com.hxzy.hospital.dev.userCenter.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hxzy.hospital.dev.security.dto.JwtUserDto;
import com.hxzy.hospital.dev.userCenter.dto.PersonMsgDto;
import com.hxzy.hospital.dev.userCenter.entity.MyDept;
import com.hxzy.hospital.dev.userCenter.entity.MyUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hxzy.hospital.dev.userCenter.vo.EditPassword;
import com.hxzy.hospital.dev.userCenter.vo.PersonMsgVO;

import java.util.ArrayList;
import java.util.List;

/**
* @author 29503
* @description 针对表【my_user】的数据库操作Service
* @createDate 2023-10-18 18:31:31
*/
public interface MyUserService extends IService<MyUser> {

    PersonMsgDto findAll(JwtUserDto jwtUserDto,List<MyDept> list);

    PersonMsgDto  updabyName(PersonMsgVO personMsgVO,JwtUserDto jwtUserDto);

    int editPassword(EditPassword editPassword);
}
