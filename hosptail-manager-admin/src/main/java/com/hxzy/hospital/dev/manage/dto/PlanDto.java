package com.hxzy.hospital.dev.manage.dto;

import com.hxzy.hospital.dev.user.entity.HosPlan;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class PlanDto extends HosPlan {
    private String nurseName;
    private String userName;
    private String instrumName;
    private String costTime;
    //诊断结果
    private String docDiag;
    private String diagMemo;

    private String deptName;

    private Integer seeCount;
    //诊断评价
    //诊断图片
    private List<String> pictures;
}
