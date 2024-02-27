package com.hxzy.hospital.dev.userCenter.vo;/*
@Author:龙强
@date:2023/10/24
@version:1.0
*/

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchVO {
    private Integer page;
    private Integer limit;
    private String nickname;
    private String  idCard;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String date;

    private Date datetime;
}
