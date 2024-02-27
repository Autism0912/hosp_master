package com.hxzy.hospital.dev.manage.vo;

import com.hxzy.hospital.dev.manage.dto.ManageDto;
import com.hxzy.hospital.dev.manage.dto.PlanDto;
import com.hxzy.hospital.dev.manage.dto.RepoDto;
import lombok.Data;

import java.util.List;

@Data
public class MedicalRecordVo {
    private  List<PlanDto> planDto;
    private ManageDto manageDto;

}
