package com.hxzy.hospital.dev.report.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hxzy.hospital.dev.report.dto.HosRepoDto;
import com.hxzy.hospital.dev.report.mapper.HosRepoDtoMapper;
import com.hxzy.hospital.dev.report.service.HosRepoDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class HosRepoDtoServiceImpl extends ServiceImpl<HosRepoDtoMapper, HosRepoDto>
        implements HosRepoDtoService {
    @Autowired
    private HosRepoDtoMapper hosRepoDtoMapper;

    @Override
    public HosRepoDto findById(Integer id) throws ParseException {
        return hosRepoDtoMapper.findById(id);
    }
}
