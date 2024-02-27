package com.hxzy.hospital.dev.manage.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 *
 * @TableName hos_order_sick
 */
@TableName(value ="hos_order_sick")
@Data
public class HosOrderSick implements Serializable {
    /**
     * 预约编号
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 患者姓名
     */
    private String sickName;

    /**
     * 卡号
     */
    private String sickCode;

    /**
     * 性别
     */
    private String sickSex;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 预约时间
     */
    private Date orderTime;

    /**
     * 诊断结果
     */
    private String illDes;

    /**
     * 状态
     */
    private Integer orderApprova;

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
        HosOrderSick other = (HosOrderSick) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSickName() == null ? other.getSickName() == null : this.getSickName().equals(other.getSickName()))
            && (this.getSickCode() == null ? other.getSickCode() == null : this.getSickCode().equals(other.getSickCode()))
            && (this.getSickSex() == null ? other.getSickSex() == null : this.getSickSex().equals(other.getSickSex()))
            && (this.getAge() == null ? other.getAge() == null : this.getAge().equals(other.getAge()))
            && (this.getOrderTime() == null ? other.getOrderTime() == null : this.getOrderTime().equals(other.getOrderTime()))
            && (this.getIllDes() == null ? other.getIllDes() == null : this.getIllDes().equals(other.getIllDes()))
            && (this.getOrderApprova() == null ? other.getOrderApprova() == null : this.getOrderApprova().equals(other.getOrderApprova()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSickName() == null) ? 0 : getSickName().hashCode());
        result = prime * result + ((getSickCode() == null) ? 0 : getSickCode().hashCode());
        result = prime * result + ((getSickSex() == null) ? 0 : getSickSex().hashCode());
        result = prime * result + ((getAge() == null) ? 0 : getAge().hashCode());
        result = prime * result + ((getOrderTime() == null) ? 0 : getOrderTime().hashCode());
        result = prime * result + ((getIllDes() == null) ? 0 : getIllDes().hashCode());
        result = prime * result + ((getOrderApprova() == null) ? 0 : getOrderApprova().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", sickName=").append(sickName);
        sb.append(", sickCode=").append(sickCode);
        sb.append(", sickSex=").append(sickSex);
        sb.append(", age=").append(age);
        sb.append(", orderTime=").append(orderTime);
        sb.append(", illDes=").append(illDes);
        sb.append(", orderApprova=").append(orderApprova);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
