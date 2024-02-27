package com.hxzy.hospital.dev.admin.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author Ghl
 * @createTime 2023/4/26
 */
@TableName("my_job")
@Data
public class MyJob extends BaseEntity {
    private static final long serialVersionUID = 8925514045582234222L;

    private Integer jobId;

    private String jobName;

    private Integer status;

    private Integer sort;

    /** 用户是否存在此岗位标识 默认不存在 */
    private boolean flag = false;
}
