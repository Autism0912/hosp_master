package com.hxzy.hospital.dev.admin.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Ghl
 * @createTime 2023/4/26
 */
@Data
public class JobQueryDto implements Serializable {
    private String queryName;

    private Integer queryStatus;
}
