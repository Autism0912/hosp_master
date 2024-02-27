package com.hxzy.hospital.dev.console.utils;

import com.hxzy.hospital.dev.common.utils.Result;
import com.hxzy.hospital.dev.console.dto.ConsoleDto;
import com.hxzy.hospital.dev.console.service.ConsoleService;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author : 龙强
 * @Date : 2023/11/1
 * @Version : 1.0
 */

@Component
public class FindByDate {
    private final ConsoleService consoleService;

    public  FindByDate(ConsoleService consoleService) {
        this.consoleService = consoleService;
    }


    public Result Date(Integer date){
        Map<String,ConsoleDto> result = new HashMap<>();
        switch (date){
            case 1:
                //日
                 ConsoleDto consoleDto   = consoleService.findByDay();
                 result.put("res",consoleDto);
                break;
            case 2:
                consoleDto = consoleService.findByWeek();
                break;
            case 3:
                consoleDto = consoleService.findByMonth();
                break;
            case 4:
                consoleDto = consoleService.findByQuater();
                break;
            case 5:
                consoleDto = consoleService.findByYear();
                break;
            default:
                return Result.ok().data2(result);
        }
       return Result.ok().data2(result);
//        return Result.ok().data(Arrays.asList(result));
    }
}
