package com.hxzy.hospital.dev.userCenter.dto;

import com.hxzy.hospital.dev.userCenter.entity.MyDept;
import lombok.Data;

import java.util.List;

@Data
public class PersonMsgDto {
    /**
     * 用户编号
     */
    private Integer id;
    /**
     * 部门编号
     */
    private Integer depId;
    /**
     * 用户名
     */
    private String nickName;
    /**
     *医生姓名
     */
    private String userName;

    /**
     * 医生性别
     */
    private String sex;

    /**
     * 所述科室
     */
    private List<MyDept> deps;

    /**
     * 医生简介
     */
    private String introduce;
    /**
     * 医生专项
     */
    private String major;

    /**
     * 电话号码
     */
    private String phone;
}
