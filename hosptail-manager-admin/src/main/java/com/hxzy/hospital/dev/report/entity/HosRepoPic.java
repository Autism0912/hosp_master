package com.hxzy.hospital.dev.report.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 诊断报告与图片关联表
 * @TableName hos_repo_pic
 */
@TableName(value ="hos_repo_pic")
@Data
public class HosRepoPic implements Serializable {
    /**
     * 图片id
     */
    private Integer picId;

    /**
     * 诊断报告id
     */
    private Integer repoId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}