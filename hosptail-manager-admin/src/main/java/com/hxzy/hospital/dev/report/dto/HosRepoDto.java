package com.hxzy.hospital.dev.report.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class HosRepoDto {
    /**
     * 报告id
     */
    private Integer id;

    /**
     * 患者姓名
     */
    private String sickName;

    /**
     * 申请科室
     */
    private String deptName;

    /**
     * 申请时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 报告名称
     */
    private String repoName;

    /**
     * 上传时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    /**
     * 医生姓名
     */
    private String docName;

    /**
     * 审核状态
     */
    private Integer status;

    /**
     * 患者编号
     */
    private String costId;

    /**
     * 部门id
     */
    private Integer deptId;

    /**
     * 医生id
     */
    private Integer docId;

    /**
     * 影像图片
     */
    private String file;

    /**
     * 检查所见
     */
    private String checkMemo;

    /**
     * 诊断意见
     */
    private String diagMemo;

}
