package com.hxzy.hospital.dev.patinceMan.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hxzy.hospital.dev.patinceMan.entity.HosSick;
import com.hxzy.hospital.dev.patinceMan.service.HosSickService;
import com.hxzy.hospital.dev.patinceMan.mapper.HosSickMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author baby9
* @description 针对表【hos_sick(患者档案表)】的数据库操作Service实现
* @createDate 2023-10-25 09:36:47
*/
@Service
public class HosSickServiceImpl extends ServiceImpl<HosSickMapper, HosSick>
    implements HosSickService{
    @Autowired
    private HosSickMapper hosSickMapper;

    @Override
    public List<HosSick> selectSickAll() {
        return hosSickMapper.selectSickAll();
    }
}




