package com.hxzy.hospital.dev.admin.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author Ghl
 * @createTime 2023/4/26
 */
@Data
public class MenuIndexDto implements Serializable {

    private Integer id;

    private Integer parentId;

    private String title;

    private String icon;

    private Integer type;

    private String href;

    private String permission;

    private List<MenuIndexDto> children;
}
