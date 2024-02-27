package com.hxzy.hospital.dev.manage.service.impl;/*
@Author:龙强
@date:2023/10/27
@version:1.0
*/

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hxzy.hospital.dev.common.utils.Result;
import com.hxzy.hospital.dev.common.utils.ResultCode;
import com.hxzy.hospital.dev.manage.dao.HosSick4ServiceDao;
import com.hxzy.hospital.dev.manage.dto.ManageDto;
import com.hxzy.hospital.dev.manage.dto.PlanDto;
import com.hxzy.hospital.dev.manage.entity.HosSick;
import com.hxzy.hospital.dev.manage.service.HosPic4Service;
import com.hxzy.hospital.dev.manage.service.HosPlan4Service;
import com.hxzy.hospital.dev.manage.service.HosSick4Service;
import com.hxzy.hospital.dev.manage.vo.MedicalRecordVo;
import com.hxzy.hospital.dev.user.entity.HosPic;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HosSick4ServiceImpl extends ServiceImpl<HosSick4ServiceDao,HosSick> implements HosSick4Service {
    private final HosSick4ServiceDao hosSick4ServiceDao;
    private final HosPlan4Service hosPlan4Service;
    private final HosPic4Service hosPic4Service;
    public HosSick4ServiceImpl(HosSick4ServiceDao hosSick4ServiceDao, HosPlan4Service hosPlan4Service, HosPic4Service hosPic4Service) {
        this.hosSick4ServiceDao = hosSick4ServiceDao;
        this.hosPlan4Service = hosPlan4Service;
        this.hosPic4Service = hosPic4Service;
    }

    @Override
    public List<com.hxzy.hospital.dev.admin.entity.HosSick> findAll() {
       return hosSick4ServiceDao.findAll();
    }

    @Override
    public Result<ManageDto> getAll(Integer offset, Integer limit, ManageDto manageDto, String name, Integer id, String time, String illness) {
        Page page = PageHelper.offsetPage(offset, limit);
        List<ManageDto> list = hosSick4ServiceDao.getAll(manageDto,name,id,time,illness);
        System.out.println("---->"+list);
        return Result.ok().count(page.getTotal()).data(list).code(ResultCode.TABLE_SUCCESS);
    }

    @Override
    public ManageDto getByids(Integer id) {
        return  hosSick4ServiceDao.getByid(id);
    }

    @Override
    public boolean updateBy(ManageDto manageDto) {
        HosSick hosSicks = super.getOne(new QueryWrapper<HosSick>().eq("sick_code",manageDto.getSickCode()));
//        HosSick hosSicks = hosSick4ServiceDao.getOne(manageDto.getSickCode());
        hosSicks.setSickName(manageDto.getSickName());
        hosSicks.setAge(manageDto.getAge());
        hosSicks.setSickSex(manageDto.getSex());
        hosSicks.setSickAddr(manageDto.getAddress());
        hosSicks.setSickPhone(manageDto.getPhone());
        hosSicks.setSickCode(manageDto.getSickCode());
        hosSicks.setSickPapertype(manageDto.getSickPapertype());
        hosSicks.setPapertypeCode(manageDto.getPapertypeCode());
        return super.updateById(hosSicks);
    }

    @Override
    public int delete(Integer id) {
        return hosSick4ServiceDao.deleteBy(id);
    }

    @Override
    public MedicalRecordVo getHosSickInfo(ManageDto manageDto) {
        ManageDto manageDto1 = this.getByids(manageDto.getId());
        //111
        List<PlanDto> planDto = hosPlan4Service.find(manageDto.getId());
        //封装图片信息
        List<PlanDto> planDtoList = planDto.stream().map(planDto1 -> {
            List<HosPic> hosPic = hosPic4Service.find(manageDto1.getSickCode());
            List<String> pictures = hosPic.stream().map(HosPic::getPath).collect(Collectors.toList());
            planDto1.setPictures(pictures);
            return planDto1;
        }).collect(Collectors.toList());

        MedicalRecordVo medicalRecordVo = new MedicalRecordVo();
        medicalRecordVo.setPlanDto(planDtoList);
        medicalRecordVo.setManageDto(manageDto1);
        return medicalRecordVo;
    }
}
