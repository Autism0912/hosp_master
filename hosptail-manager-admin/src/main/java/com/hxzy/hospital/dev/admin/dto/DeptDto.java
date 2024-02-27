package com.hxzy.hospital.dev.admin.dto;

import com.hxzy.hospital.dev.admin.entity.BaseEntity;
import lombok.Data;

/**
 * @author Ghl
 * @createTime 2023/4/26
 */
@Data
public class DeptDto extends BaseEntity {

    private Integer id;

    private Integer parentId;

    private String checkArr = "0";

    private String title;
}
