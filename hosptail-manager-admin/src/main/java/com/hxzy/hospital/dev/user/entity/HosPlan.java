package com.hxzy.hospital.dev.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.sql.Date;

/**
 * 治疗方式表
 * @TableName hos_plan
 */
@TableName(value ="hos_plan")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HosPlan implements Serializable {
    /**
     * 治疗方式id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 治疗时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date treatTime;

    /**
     * 仪器id
     */
    private Integer instrumId;

    /**
     * 耗材
     */
    private String sonsuName;

    /**
     * 治疗时长
     */
    private String costTime;

    /**
     * 治疗前
     */
    private String beforeTreat;

    /**
     * 治疗后
     */
    private String afterTreat;

    /**
     * 医生id
     */
    private Integer docId;

    /**
     * 护士id
     */
    private Integer nurseId;

    /**
     * 是否以治疗（0未治疗，1已治疗）
     */
    private Integer status;

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
     * 关联job查询医生
     */
    private Integer userId;

    private Integer sickId;

    private String energy;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}
