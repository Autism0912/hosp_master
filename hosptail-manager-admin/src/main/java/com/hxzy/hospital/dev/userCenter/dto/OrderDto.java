package com.hxzy.hospital.dev.userCenter.dto;/*
@Author:龙强
@date:2023/10/23
@version:1.0
*/

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class OrderDto {
    private Integer id;
    private String sickName;
    private Integer sickCode;
    private String  sickPhone;
    private String projName;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;
    private Integer sickSex;
    private String papertypeCode;
    private Integer age;
    private Integer orderStatus;
    private String deptName;
    private String name;
    private String sickAddr;
    private String illDes;
    private String decDiag;
    private String illHistory;
}
