package com.hxzy.hospital.dev.console.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @Author : 龙强
 * @Date : 2023/10/30
 * @Version : 1.0
 */
@Data
public class ConsoleDto {
    /**
     * 用户总数
     */
    private Integer userCount;
    /**
     * 接待患者总数
     */
    private Integer receive;
    /**
     * 就诊金额
     */
    private Integer pay;
    /**
     * 复诊人数
     */
    private Integer rePeopleNum;
    /**
     * 出诊人数
     */
    private Integer outPeopleNum;
    /**
     *图表的就诊金额及时间
     */
    private List<TableOfVisitDto> tableOfVisits;

    /**
     * 时间
     */
    private List<Date> time;

    /**
     * 金额
     */
    private List<Double> money;
}
