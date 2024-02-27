package com.hxzy.hospital.dev.manage.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 是否删除（0未删除，1删除）
     */
    private Integer isDel;
    private Integer age;
    /**
     * 和order进行绑定
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
        HosSick other = (HosSick) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSickName() == null ? other.getSickName() == null : this.getSickName().equals(other.getSickName()))
            && (this.getSickPapertype() == null ? other.getSickPapertype() == null : this.getSickPapertype().equals(other.getSickPapertype()))
            && (this.getPapertypeCode() == null ? other.getPapertypeCode() == null : this.getPapertypeCode().equals(other.getPapertypeCode()))
            && (this.getSickSex() == null ? other.getSickSex() == null : this.getSickSex().equals(other.getSickSex()))
            && (this.getPrivanceId() == null ? other.getPrivanceId() == null : this.getPrivanceId().equals(other.getPrivanceId()))
            && (this.getCityId() == null ? other.getCityId() == null : this.getCityId().equals(other.getCityId()))
            && (this.getAreaId() == null ? other.getAreaId() == null : this.getAreaId().equals(other.getAreaId()))
            && (this.getSickAddr() == null ? other.getSickAddr() == null : this.getSickAddr().equals(other.getSickAddr()))
            && (this.getSickPhone() == null ? other.getSickPhone() == null : this.getSickPhone().equals(other.getSickPhone()))
            && (this.getSickCode() == null ? other.getSickCode() == null : this.getSickCode().equals(other.getSickCode()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getIsOneself() == null ? other.getIsOneself() == null : this.getIsOneself().equals(other.getIsOneself()))
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
        result = prime * result + ((getSickName() == null) ? 0 : getSickName().hashCode());
        result = prime * result + ((getSickPapertype() == null) ? 0 : getSickPapertype().hashCode());
        result = prime * result + ((getPapertypeCode() == null) ? 0 : getPapertypeCode().hashCode());
        result = prime * result + ((getSickSex() == null) ? 0 : getSickSex().hashCode());
        result = prime * result + ((getPrivanceId() == null) ? 0 : getPrivanceId().hashCode());
        result = prime * result + ((getCityId() == null) ? 0 : getCityId().hashCode());
        result = prime * result + ((getAreaId() == null) ? 0 : getAreaId().hashCode());
        result = prime * result + ((getSickAddr() == null) ? 0 : getSickAddr().hashCode());
        result = prime * result + ((getSickPhone() == null) ? 0 : getSickPhone().hashCode());
        result = prime * result + ((getSickCode() == null) ? 0 : getSickCode().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getIsOneself() == null) ? 0 : getIsOneself().hashCode());
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
        sb.append(", sickName=").append(sickName);
        sb.append(", sickPapertype=").append(sickPapertype);
        sb.append(", papertypeCode=").append(papertypeCode);
        sb.append(", sickSex=").append(sickSex);
        sb.append(", privanceId=").append(privanceId);
        sb.append(", cityId=").append(cityId);
        sb.append(", areaId=").append(areaId);
        sb.append(", sickAddr=").append(sickAddr);
        sb.append(", sickPhone=").append(sickPhone);
        sb.append(", sickCode=").append(sickCode);
        sb.append(", username=").append(username);
        sb.append(", isOneself=").append(isOneself);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", isDel=").append(isDel);
        sb.append(", costId=").append(costId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
