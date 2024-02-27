package com.hxzy.hospital.dev.admin.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Ghl
 * @createTime 2023/4/26
 */
@TableName("my_role")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString
@NoArgsConstructor
public class MyRole extends BaseEntity{
    private static final long serialVersionUID = -6525908145032868837L;

    private Integer roleId;

    private String roleName;

    /** 数据范围（1：所有数据权限；2：自定义数据权限；3：本部门数据权限；4：本部门及以下数据权限） */
    private String dataScope;

    private String description;


    /**
     * 判断是否为admin用户
     * @return
     */
    public boolean isAdmin()
    {
        return isAdmin(this.getRoleId());
    }

    public static boolean isAdmin(Integer roleId)
    {
        return roleId != null && 1L == roleId;
    }

    public MyRole(Integer roleId)
    {
        this.setRoleId(roleId);
    }
}
