package com.hxzy.hospital.dev.console.entity;

import lombok.Data;

@Data
public class MyUser {
  private long userId;
  private long deptId;
  private String userName;
  private String password;
  private String nickName;
  private String phone;
  private String email;
  private long status;
  private java.sql.Timestamp createTime;
  private java.sql.Timestamp updateTime;
  private long role;
  private String info;
  private String major;
}
