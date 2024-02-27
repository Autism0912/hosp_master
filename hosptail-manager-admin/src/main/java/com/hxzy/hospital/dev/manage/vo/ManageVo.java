package com.hxzy.hospital.dev.manage.vo;

import lombok.Data;

import java.util.Date;

@Data
public class ManageVo {
    private Integer id;

    private String name;
    private String illness;
    private Date time;
}
