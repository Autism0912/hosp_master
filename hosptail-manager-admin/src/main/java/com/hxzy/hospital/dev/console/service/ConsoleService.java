package com.hxzy.hospital.dev.console.service;

import com.hxzy.hospital.dev.console.dto.ConsoleDto;
import com.hxzy.hospital.dev.console.dto.TableOfVisitDto;

/**
 * @Author : 龙强
 * @Date : 2023/10/30
 * @Version : 1.0
 */
public interface ConsoleService {
    ConsoleDto findNum();


    ConsoleDto  findByDay();

    ConsoleDto findByWeek();

    ConsoleDto findByMonth();

    ConsoleDto findByQuater();

    ConsoleDto findByYear();
}
