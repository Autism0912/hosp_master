package com.hxzy.hospital.dev.admin.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Ghl
 * @createTime 2023/4/26
 */
@TableName("my_user_job")
@Data
public class MyUserJob implements Serializable {

    private static final long serialVersionUID = 8925514045582235321L;

    private Integer userId;

    private Integer jobId;
}
