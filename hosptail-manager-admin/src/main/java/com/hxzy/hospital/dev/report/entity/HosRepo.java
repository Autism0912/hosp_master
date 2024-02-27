package com.hxzy.hospital.dev.report.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

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

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        HosRepo other = (HosRepo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getRepoName() == null ? other.getRepoName() == null : this.getRepoName().equals(other.getRepoName()))
            && (this.getDes() == null ? other.getDes() == null : this.getDes().equals(other.getDes()))
            && (this.getIllDes() == null ? other.getIllDes() == null : this.getIllDes().equals(other.getIllDes()))
            && (this.getDocDiag() == null ? other.getDocDiag() == null : this.getDocDiag().equals(other.getDocDiag()))
            && (this.getIllHistory() == null ? other.getIllHistory() == null : this.getIllHistory().equals(other.getIllHistory()))
            && (this.getCheckMemo() == null ? other.getCheckMemo() == null : this.getCheckMemo().equals(other.getCheckMemo()))
            && (this.getDiagMemo() == null ? other.getDiagMemo() == null : this.getDiagMemo().equals(other.getDiagMemo()))
            && (this.getTreatId() == null ? other.getTreatId() == null : this.getTreatId().equals(other.getTreatId()))
            && (this.getSickCode() == null ? other.getSickCode() == null : this.getSickCode().equals(other.getSickCode()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getIsDel() == null ? other.getIsDel() == null : this.getIsDel().equals(other.getIsDel()))
            && (this.getIsCommit() == null ? other.getIsCommit() == null : this.getIsCommit().equals(other.getIsCommit()))
            && (this.getDeptId() == null ? other.getDeptId() == null : this.getDeptId().equals(other.getDeptId()))
            && (this.getDocId() == null ? other.getDocId() == null : this.getDocId().equals(other.getDocId()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCostId() == null ? other.getCostId() == null : this.getCostId().equals(other.getCostId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getRepoName() == null) ? 0 : getRepoName().hashCode());
        result = prime * result + ((getDes() == null) ? 0 : getDes().hashCode());
        result = prime * result + ((getIllDes() == null) ? 0 : getIllDes().hashCode());
        result = prime * result + ((getDocDiag() == null) ? 0 : getDocDiag().hashCode());
        result = prime * result + ((getIllHistory() == null) ? 0 : getIllHistory().hashCode());
        result = prime * result + ((getCheckMemo() == null) ? 0 : getCheckMemo().hashCode());
        result = prime * result + ((getDiagMemo() == null) ? 0 : getDiagMemo().hashCode());
        result = prime * result + ((getTreatId() == null) ? 0 : getTreatId().hashCode());
        result = prime * result + ((getSickCode() == null) ? 0 : getSickCode().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getIsDel() == null) ? 0 : getIsDel().hashCode());
        result = prime * result + ((getIsCommit() == null) ? 0 : getIsCommit().hashCode());
        result = prime * result + ((getDeptId() == null) ? 0 : getDeptId().hashCode());
        result = prime * result + ((getDocId() == null) ? 0 : getDocId().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCostId() == null) ? 0 : getCostId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", repoName=").append(repoName);
        sb.append(", des=").append(des);
        sb.append(", illDes=").append(illDes);
        sb.append(", docDiag=").append(docDiag);
        sb.append(", illHistory=").append(illHistory);
        sb.append(", checkMemo=").append(checkMemo);
        sb.append(", diagMemo=").append(diagMemo);
        sb.append(", treatId=").append(treatId);
        sb.append(", sickCode=").append(sickCode);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", isDel=").append(isDel);
        sb.append(", isCommit=").append(isCommit);
        sb.append(", deptId=").append(deptId);
        sb.append(", docId=").append(docId);
        sb.append(", status=").append(status);
        sb.append(", costId=").append(costId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
