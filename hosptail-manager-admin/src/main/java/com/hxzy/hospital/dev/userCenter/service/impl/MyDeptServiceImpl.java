package com.hxzy.hospital.dev.userCenter.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hxzy.hospital.dev.userCenter.entity.MyDept;
import com.hxzy.hospital.dev.userCenter.service.MyDeptService;
import com.hxzy.hospital.dev.userCenter.mapper.MyDeptMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 29503
* @description 针对表【my_dept】的数据库操作Service实现
* @createDate 2023-10-18 17:32:42
*/
@Service
public class MyDeptServiceImpl extends ServiceImpl<MyDeptMapper, MyDept>
    implements MyDeptService{

    @Override
    public List<MyDept> findSection() {
        return this.list();
    }

    @Override
    public void updateByName(String username) {

    }
}




