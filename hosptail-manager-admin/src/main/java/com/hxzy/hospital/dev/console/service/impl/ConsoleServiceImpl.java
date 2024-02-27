package com.hxzy.hospital.dev.console.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hxzy.hospital.dev.console.dao.ConsoleServiceDao;
import com.hxzy.hospital.dev.console.dto.ConsoleDto;
import com.hxzy.hospital.dev.console.dto.TableOfVisitDto;
import com.hxzy.hospital.dev.console.entity.MyUser;
import com.hxzy.hospital.dev.console.service.ConsoleService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author : 龙强
 * @Date : 2023/10/30
 * @Version : 1.0
 */
@Service
public class ConsoleServiceImpl extends ServiceImpl<ConsoleServiceDao, MyUser> implements ConsoleService {
    private final ConsoleServiceDao consoleServiceDao;

    public ConsoleServiceImpl(ConsoleServiceDao consoleServiceDao) {
        this.consoleServiceDao = consoleServiceDao;
    }

    @Override
    public ConsoleDto findNum() {
        ConsoleDto num = consoleServiceDao.findNum();
        System.out.println(num);
        return consoleServiceDao.findNum();
    }

    @Override
    public  ConsoleDto findByDay() {
        ConsoleDto consoleDto = new ConsoleDto();
        ConsoleDto num = consoleServiceDao.findNum();
        consoleDto.setPay(num.getPay());
        consoleDto.setReceive(num.getReceive());
        consoleDto.setUserCount(num.getUserCount());
        consoleDto.setRePeopleNum(num.getRePeopleNum());
        List<TableOfVisitDto> byDay = consoleServiceDao.findByDay();
        List time = new ArrayList();//时间
        List money = new ArrayList();//钱
        for (TableOfVisitDto tableOfVisitDto : byDay) {
            time.add(tableOfVisitDto.getDat());
            money.add(tableOfVisitDto.getMoney());
        }
        consoleDto.setMoney(money);//加入DTO
        consoleDto.setTime(time);
        consoleDto.setTableOfVisits(byDay);
        System.out.println(consoleDto);
        return consoleDto;
    }

    @Override
    public ConsoleDto findByWeek() {
        return consoleServiceDao.findByWeek();
    }

    @Override
    public ConsoleDto findByMonth() {
        return consoleServiceDao.findByMonth();
    }

    @Override
    public ConsoleDto findByQuater() {
        return consoleServiceDao.findByQuater();
    }

    @Override
    public ConsoleDto findByYear() {
        return consoleServiceDao.findByYear();
    }
}
