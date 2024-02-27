package com.hxzy.hospital.dev.manage.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 预约单
 * @TableName hos_order
 */
@TableName(value ="hos_order")
@Data
public class HosOrder implements Serializable {
    /**
     * 预约单id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 患者编号
     */
    private String sickCode;

    /**
     * 预约项目id
     */
    private Integer projId;

    /**
     * 看病次数
     */
    private Integer seeCount;

    /**
     * 病情
     */
    private String illness;

    /**
     * 预约时间
     */
    private Date orderTime;

    /**
     * 备注
     */
    private String memo;

    /**
     * 审核状态（0未通过，1通过，2待审核，3取消）
     */
    private Integer orderStatus;

    /**
     * 预约地点
     */
    private String orderAddr;

    /**
     * 注意事项
     */
    private String orderAtten;

    /**
     * 诊断报告id
     */
    private Integer repoId;

    /**
     * 就诊状态（0待接诊，1接诊中，2已完成）
     */
    private Integer orderApprova;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 是否删除
     */
    private Integer isDel;

    /**
     * 和sick进行绑定
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
        HosOrder other = (HosOrder) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSickCode() == null ? other.getSickCode() == null : this.getSickCode().equals(other.getSickCode()))
            && (this.getProjId() == null ? other.getProjId() == null : this.getProjId().equals(other.getProjId()))
            && (this.getSeeCount() == null ? other.getSeeCount() == null : this.getSeeCount().equals(other.getSeeCount()))
            && (this.getIllness() == null ? other.getIllness() == null : this.getIllness().equals(other.getIllness()))
            && (this.getOrderTime() == null ? other.getOrderTime() == null : this.getOrderTime().equals(other.getOrderTime()))
            && (this.getMemo() == null ? other.getMemo() == null : this.getMemo().equals(other.getMemo()))
            && (this.getOrderStatus() == null ? other.getOrderStatus() == null : this.getOrderStatus().equals(other.getOrderStatus()))
            && (this.getOrderAddr() == null ? other.getOrderAddr() == null : this.getOrderAddr().equals(other.getOrderAddr()))
            && (this.getOrderAtten() == null ? other.getOrderAtten() == null : this.getOrderAtten().equals(other.getOrderAtten()))
            && (this.getRepoId() == null ? other.getRepoId() == null : this.getRepoId().equals(other.getRepoId()))
            && (this.getOrderApprova() == null ? other.getOrderApprova() == null : this.getOrderApprova().equals(other.getOrderApprova()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getIsDel() == null ? other.getIsDel() == null : this.getIsDel().equals(other.getIsDel()))
            && (this.getCostId() == null ? other.getCostId() == null : this.getCostId().equals(other.getCostId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSickCode() == null) ? 0 : getSickCode().hashCode());
        result = prime * result + ((getProjId() == null) ? 0 : getProjId().hashCode());
        result = prime * result + ((getSeeCount() == null) ? 0 : getSeeCount().hashCode());
        result = prime * result + ((getIllness() == null) ? 0 : getIllness().hashCode());
        result = prime * result + ((getOrderTime() == null) ? 0 : getOrderTime().hashCode());
        result = prime * result + ((getMemo() == null) ? 0 : getMemo().hashCode());
        result = prime * result + ((getOrderStatus() == null) ? 0 : getOrderStatus().hashCode());
        result = prime * result + ((getOrderAddr() == null) ? 0 : getOrderAddr().hashCode());
        result = prime * result + ((getOrderAtten() == null) ? 0 : getOrderAtten().hashCode());
        result = prime * result + ((getRepoId() == null) ? 0 : getRepoId().hashCode());
        result = prime * result + ((getOrderApprova() == null) ? 0 : getOrderApprova().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getIsDel() == null) ? 0 : getIsDel().hashCode());
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
        sb.append(", sickCode=").append(sickCode);
        sb.append(", projId=").append(projId);
        sb.append(", seeCount=").append(seeCount);
        sb.append(", illness=").append(illness);
        sb.append(", orderTime=").append(orderTime);
        sb.append(", memo=").append(memo);
        sb.append(", orderStatus=").append(orderStatus);
        sb.append(", orderAddr=").append(orderAddr);
        sb.append(", orderAtten=").append(orderAtten);
        sb.append(", repoId=").append(repoId);
        sb.append(", orderApprova=").append(orderApprova);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", isDel=").append(isDel);
        sb.append(", costId=").append(costId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
