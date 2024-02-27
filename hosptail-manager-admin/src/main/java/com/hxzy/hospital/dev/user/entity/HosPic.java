package com.hxzy.hospital.dev.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 图片信息表
 * @TableName hos_pic
 */
@TableName(value ="hos_pic")
@Data
public class HosPic implements Serializable {
    /**
     * 图片id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 患者图片的状态（0治疗前，1治疗后，2病例，3手术）
     */
    private Integer status;

    /**
     * 图片地址
     */
    private String path;

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

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}
