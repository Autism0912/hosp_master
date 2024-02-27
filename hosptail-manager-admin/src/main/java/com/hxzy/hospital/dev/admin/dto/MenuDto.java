package com.hxzy.hospital.dev.admin.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Ghl
 * @createTime 2023/4/26
 */
@Data
public class MenuDto implements Serializable {

    private Integer id;

    private Integer parentId;

    private String checkArr = "0";

    private String title;
}
