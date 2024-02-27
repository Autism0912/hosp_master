package com.hxzy.hospital.dev.manage.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hxzy.hospital.dev.manage.entity.HosSick;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class ManageDto extends HosSick {
        private Integer id;
        private String sickName;
        private Integer sex;
        private Integer age;
        private Integer seeCount;
        private String phone;
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        @JsonFormat(pattern = "yyyy-MM-dd")
        private Date createTime;
        private String illness;
        private String address;
        private String sickCode;
        private String papertypeCode;
        private Integer sickPapertype;
}
