package com.hxzy.hospital.dev.admin.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author Ghl
 * @createTime 2023/4/26
 */
@TableName("my_menu")
@Data
public class MyMenu extends BaseEntity{

    private static final long serialVersionUID = -6525908145032868815L;

    private Integer menuId;

    private Integer parentId;

    private String menuName;

    private String icon;

    private Integer type;

    private String url;

    private String permission;

    private Integer sort;
}
