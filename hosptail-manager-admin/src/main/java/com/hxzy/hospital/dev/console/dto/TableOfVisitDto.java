package com.hxzy.hospital.dev.console.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.util.List;

/**
 * @Author : 龙强
 * @Date : 2023/11/2
 * @Version : 1.0
 */
@Data
public class TableOfVisitDto {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dat;
    private Double money;

}
