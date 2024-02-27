package com.hxzy.hospital.dev.admin.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Ghl
 * @createTime 2023/4/26
 */
@TableName("my_role_dept")
@Data
public class MyRoleDept implements Serializable {

    private static final long serialVersionUID = 8925514042332235875L;

    private Integer roleId;

    private Integer deptId;
}
