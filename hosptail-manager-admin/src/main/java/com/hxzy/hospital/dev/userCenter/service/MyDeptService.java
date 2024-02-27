package com.hxzy.hospital.dev.userCenter.service;

import com.hxzy.hospital.dev.userCenter.entity.MyDept;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author 29503
* @description 针对表【my_dept】的数据库操作Service
* @createDate 2023-10-18 17:32:42
*/
public interface MyDeptService extends IService<MyDept> {

    List<MyDept> findSection();

    void updateByName(String username);

}
