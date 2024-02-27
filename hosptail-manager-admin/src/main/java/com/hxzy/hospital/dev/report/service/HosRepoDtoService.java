package com.hxzy.hospital.dev.report.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hxzy.hospital.dev.report.dto.HosRepoDto;

import java.text.ParseException;

public interface HosRepoDtoService extends IService<HosRepoDto> {
    HosRepoDto findById(Integer id) throws ParseException;
}
