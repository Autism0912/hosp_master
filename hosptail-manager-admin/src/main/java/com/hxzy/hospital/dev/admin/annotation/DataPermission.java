package com.hxzy.hospital.dev.admin.annotation;

import java.lang.annotation.*;

/**
 * 数据权限过滤注解
 * @author Ghl
 * @createTime 2023/4/26
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataPermission {
    /**
     * 部门表的别名
     */
    public String deptAlias() default "";

    /**
     * 用户表的别名
     */
    public String userAlias() default "";
}
