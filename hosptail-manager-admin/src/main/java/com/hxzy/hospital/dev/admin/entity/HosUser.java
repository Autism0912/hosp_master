package com.hxzy.hospital.dev.admin.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("hos_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HosUser extends BaseEntity{
     private Integer id;
     private String userCode;
     private String name;
     private Integer userSex;
     private String userMemo;
     private String userAdept;
     private Integer userId;
     private Integer isDel;
     private Integer deptId;
}
