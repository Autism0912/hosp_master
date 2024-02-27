package com.hxzy.hospital.dev.admin.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("hos_order")
public class HosOrder {

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
