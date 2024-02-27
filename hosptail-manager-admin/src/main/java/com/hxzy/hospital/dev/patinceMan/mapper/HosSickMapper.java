package com.hxzy.hospital.dev.patinceMan.mapper;

import com.hxzy.hospital.dev.patinceMan.entity.HosSick;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author baby9
* @description 针对表【hos_sick(患者档案表)】的数据库操作Mapper
* @createDate 2023-10-25 09:36:47
* @Entity com.hxzy.hospital.dev.patinceMan.entity.HosSick
*/
@Mapper
public interface HosSickMapper extends BaseMapper<HosSick> {

    List<HosSick> selectSickAll();

    HosSick findByName(String sickName);

    HosSick fandByCostId(Integer costId);
}




