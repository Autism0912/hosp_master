package com.hxzy.hospital.dev.common.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * yml属性文件(Upload配置)
 * author: WiseZone
 * create: 2023/9/18 15:35
 * version: 1.0.0
 */
@ConfigurationProperties("upload")
@Data
public class UploadConfig {
    private int width;
    private int height;
    private String url;
    private String folder;
}
