package com.hxzy.hospital.dev.userCenter.service.impl;

import cn.hutool.Hutool;
import cn.hutool.crypto.digest.BCrypt;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hxzy.hospital.dev.security.dto.JwtUserDto;
import com.hxzy.hospital.dev.security.utils.AdminOffi;
import com.hxzy.hospital.dev.userCenter.dto.PersonMsgDto;
import com.hxzy.hospital.dev.userCenter.entity.MyDept;
import com.hxzy.hospital.dev.userCenter.entity.MyUser;
import com.hxzy.hospital.dev.userCenter.service.MyUserService;
import com.hxzy.hospital.dev.userCenter.mapper.MyUserMapper;
import com.hxzy.hospital.dev.userCenter.vo.EditPassword;
import com.hxzy.hospital.dev.userCenter.vo.PersonMsgVO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
* @author 29503
* @description 针对表【my_user】的数据库操作Service实现
* @createDate 2023-10-18 18:31:31
*/
@Service
public class MyUserServiceImpl extends ServiceImpl<MyUserMapper, MyUser>
    implements MyUserService{

    @Override
    public PersonMsgDto findAll(JwtUserDto jwtUserDto,List<MyDept> list) {
        MyUser myUser = this.getOne(new QueryWrapper<MyUser>().eq("user_name", jwtUserDto.getMyUser().getUserName()));
        PersonMsgDto personMsgDto = new PersonMsgDto();
        personMsgDto.setId(jwtUserDto.getMyUser().getUserId());

        personMsgDto.setDepId(jwtUserDto.getMyUser().getDeptId());
        personMsgDto.setUserName(jwtUserDto.getMyUser().getUserName());
        personMsgDto.setNickName(jwtUserDto.getMyUser().getNickName());
        personMsgDto.setPhone(jwtUserDto.getMyUser().getPhone());
        personMsgDto.setIntroduce(myUser.getInfo());
        personMsgDto.setMajor(myUser.getMajor());
        List<MyDept> stu = new ArrayList<>();
        for (MyDept myDept : list) {
            if (myDept.getParentId()!=0){
                stu.add(myDept);
            }
        }
        personMsgDto.setDeps(stu);
        return personMsgDto;
    }

    @Override
    public  PersonMsgDto  updabyName(PersonMsgVO personMsgVO,JwtUserDto jwtUserDto) {
            if (personMsgVO==null){
                return null;
            }
            //先进行查询是否有这个人的存在
        MyUser userName = this.getOne(new QueryWrapper<MyUser>().eq("user_name", personMsgVO.getUsername()));
        if (userName == null) {
                return null;
            }
            //查重,看看是否用户名重复
            UpdateWrapper<MyUser> userUpdateWrapper = new UpdateWrapper<>();
            userUpdateWrapper.eq("user_name",personMsgVO.getUsername());
            userUpdateWrapper.set("phone",personMsgVO.getPhone());
            userUpdateWrapper.set("nick_name",personMsgVO.getNickname());
            userUpdateWrapper.set("info",personMsgVO.getIntroduce());
            userUpdateWrapper.set("major",personMsgVO.getDesc());
            userUpdateWrapper.set("dept_id",AdminOffi.keshi(personMsgVO.getKeshi()));
            int update = baseMapper.update(userName, userUpdateWrapper);
            PersonMsgDto personMsgDto = new PersonMsgDto();
            if (update>0){
                jwtUserDto.getMyUser().setUserName(personMsgVO.getUsername());
                MyUser userName1 = this.getOne(new QueryWrapper<MyUser>().eq("user_name", personMsgVO.getUsername()));
                personMsgDto.setUserName(userName1.getUserName());
                personMsgDto.setNickName(userName1.getNickName());
                personMsgDto.setPhone(userName1.getPhone());
                personMsgDto.setIntroduce(userName1.getInfo());
                personMsgDto.setMajor(userName1.getMajor());
            }
        return personMsgDto;

    }

    @Override
    public int editPassword(EditPassword editPassword) {
        System.out.println(editPassword);
        //判断是否有当前用户
        MyUser current = this.getOne(new QueryWrapper<MyUser>().eq("user_id", editPassword.getId()));
        if (current==null){
            return 1;
        }
        //获取当前用户的原密码
        String oldpassword = current.getPassword();

        System.out.println("原密码"+oldpassword);

        if (!BCrypt.checkpw(editPassword.getOldpassword(), oldpassword)){
            return 2;
        }
        //有
        UpdateWrapper<MyUser> myUserUpdateWrapper = new UpdateWrapper<>();
        myUserUpdateWrapper.eq("user_id",editPassword.getId());
        myUserUpdateWrapper.set("password",BCrypt.hashpw(editPassword.getPword2()));
        boolean update = update(myUserUpdateWrapper);

//        boolean rs = update(new QueryWrapper<MyUser>().eq("password", BCrypt.hashpw(editPassword.getPword2())));
        if (update){
            return 0;
        }
        return 1;
    }
}




