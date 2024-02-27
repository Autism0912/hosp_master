package com.hxzy.hospital.dev.report.vo;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class HosRepoVo {

    /**
     * 报告id
     */
    private Integer id;
    /**
     * 患者编号
     */
    private Integer costId;

    /**
     * 患者姓名
     */
    private String sickName;

    /**
     * 部门id
     */
    private Integer deptId;

    /**
     * 医生id
     */
    private Integer docId;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 更新时间
     */
    private String updateTime;

    /**
     * 诊断报告名
     */
    private String repoName;

    /**
     * 影像图片
     */
    private List<String> file;

    //private List<String> imageUrl;

    /**
     * 检查所见
     */
    private String checkMemo;

    /**
     * 诊断意见
     */
    private String diagMemo;

    /**
     * 审核状态
     */
    private Integer status;
}
