package com.hxzy.hospital.dev.admin.entity.view;

import com.baomidou.mybatisplus.annotation.TableName;
import com.hxzy.hospital.dev.admin.entity.HosOrder;
import lombok.Data;

import java.util.Date;


@Data
@TableName("order_sick")
public class OrderSick  {
    private String sickName;
    private Integer sicKSex;
    private String sickPhone;
    private String papertypeCode;
    private long id;
    private String sickCode;
    private long projId;
    private long seeCount;
    private String illness;
    private Date orderTime=new Date();
    private String memo;
    private long orderStatus;
    private String orderAddr;
    private String orderAtten;
    private long repoId;
    private long orderApprova;
    private Date createTime = new Date();
    private Date updateTime=new Date();
    private long isDel;
    private long costId;
}
