package com.hxzy.hospital.dev.userCenter.vo;/*
@Author:龙强
@date:2023/10/23
@version:1.0
*/

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderVO {
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
}
