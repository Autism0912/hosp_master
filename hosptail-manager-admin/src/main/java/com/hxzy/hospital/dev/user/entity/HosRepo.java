package com.hxzy.hospital.dev.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 诊断报告表
 * @TableName hos_repo
 */
@TableName(value ="hos_repo")
@Data
public class HosRepo implements Serializable {
    /**
     * 诊断报告id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 诊断报告名
     */
    private String repoName;

    /**
     * 有无描述（0无，1有）
     */
    private Integer des;

    /**
     * 患者主述
     */
    private String illDes;

    /**
     * 医生诊断
     */
    private String docDiag;

    /**
     * 患者病史
     */
    private String illHistory;

    /**
     * 检查所见
     */
    private String checkMemo;

    /**
     * 诊断意见
     */
    private String diagMemo;

    /**
     * 治疗方案id
     */
    private Integer treatId;

    /**
     * 患者编号
     */
    private String sickCode;

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
     * 是否提交（0未提交，1已提交）
     */
    private Integer isCommit;

    /**
     * 部门id
     */
    private Integer deptId;

    /**
     * 医生id
     */
    private Integer docId;

    /**
     * 审核状态 0待审核 1未通过 2已完成
     */
    private Integer status;

    /**
     * 和order和sick进行绑定
     */
    private Integer costId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}
