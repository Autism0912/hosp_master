package com.hxzy.hospital.dev.admin.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Ghl
 * @createTime 2023/4/26
 */
@Data
public class UserQueryDto implements Serializable {

    private String nickName;

    private String userName;

    private Integer deptId;
}
