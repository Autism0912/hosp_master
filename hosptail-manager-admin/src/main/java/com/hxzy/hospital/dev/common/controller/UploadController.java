package com.hxzy.hospital.dev.common.controller;

import cn.hutool.core.img.ImgUtil;
import cn.hutool.core.lang.Snowflake;
import com.hxzy.hospital.dev.common.config.UploadConfig;
import com.hxzy.hospital.dev.common.utils.Result;
import com.hxzy.hospital.dev.common.utils.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 图片上传管理
 * author: WiseZone
 * create: 2023/9/18 14:24
 * version: 1.0.0
 */
@RestController
@RequestMapping("/upload")
public class UploadController {
    private static final Snowflake SNOW_FLAKE = new Snowflake(1, 1);

    @Autowired
    private UploadConfig config;

    @PostMapping("report/image")
    public Result uploadEmp(MultipartFile file) throws IOException {
        //验证文件(文件类型)
        String filename = file.getOriginalFilename();
        if (!(filename.toLowerCase().endsWith(".jpg") || filename.toLowerCase().endsWith(".png"))) {
            return Result.error().message("上传影像文件类型错误");
        }
        //雪花算法(hutool)
        filename = SNOW_FLAKE.nextIdStr() + "_" + filename;
        //创建目标文件对象
        File dest = new File(config.getFolder(), filename);
        file.transferTo(dest);
//        List<String> list = new ArrayList<>();
//        list.add(config.getUrl() + "/" + filename);
        Map map = new HashMap<>();
        map.put("image_url", config.getUrl() + "/" + filename);
        return Result.ok().data2(map).code(ResultCode.TABLE_SUCCESS);
    }


}
