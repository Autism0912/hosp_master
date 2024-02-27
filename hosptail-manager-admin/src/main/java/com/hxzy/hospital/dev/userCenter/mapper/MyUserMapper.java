package com.hxzy.hospital.dev.userCenter.mapper;

import com.hxzy.hospital.dev.userCenter.entity.MyUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 29503
* @description 针对表【my_user】的数据库操作Mapper
* @createDate 2023-10-18 18:31:31
* @Entity com.hxzy.hospital.dev.userCenter.entity.MyUser
*/
@Mapper
public interface MyUserMapper extends BaseMapper<MyUser> {

}




