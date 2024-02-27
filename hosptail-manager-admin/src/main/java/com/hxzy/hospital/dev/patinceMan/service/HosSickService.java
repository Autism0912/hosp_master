package com.hxzy.hospital.dev.patinceMan.service;

import com.hxzy.hospital.dev.patinceMan.entity.HosSick;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author baby9
* @description 针对表【hos_sick(患者档案表)】的数据库操作Service
* @createDate 2023-10-25 09:36:47
*/
public interface HosSickService extends IService<HosSick> {

    List<HosSick> selectSickAll();
}
