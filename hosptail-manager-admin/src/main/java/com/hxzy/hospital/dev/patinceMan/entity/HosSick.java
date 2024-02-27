package com.hxzy.hospital.dev.patinceMan.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 患者档案表
 * @TableName hos_sick
 */
@TableName(value ="hos_sick")
@Data
public class HosSick implements Serializable {
    /**
     * 患者档案id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 患者姓名
     */
    private String sickName;

    /**
     * 医保类型（0自费，1医保）
     */
    private Integer sickPapertype;

    /**
     * 身份证号
     */
    private String papertypeCode;

    /**
     * 性别（0男，1女）
     */
    private Integer sickSex;

    /**
     * 省id
     */
    private Integer privanceId;

    /**
     * 市id
     */
    private Integer cityId;

    /**
     * 区域id
     */
    private Integer areaId;

    /**
     * 详细地址
     */
    private String sickAddr;

    /**
     * 患者手机号
     */
    private String sickPhone;

    /**
     * 患者档案编号
     */
    private String sickCode;

    /**
     * 患者登陆账号
     */
    private String username;

    /**
     * 是否是本人（0本人，1不是本人）
     */
    private Integer isOneself;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 是否删除（0未删除，1删除）
     */
    private Integer isDel;

    /**
     * 和order进行绑定
     */
    private Integer costId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}