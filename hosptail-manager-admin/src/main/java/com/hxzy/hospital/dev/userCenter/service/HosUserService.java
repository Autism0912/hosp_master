package com.hxzy.hospital.dev.userCenter.service;/*
@Author:龙强
@date:2023/10/23
@version:1.0
*/

import com.baomidou.mybatisplus.extension.service.IService;
import com.hxzy.hospital.dev.common.utils.Result;
import com.hxzy.hospital.dev.userCenter.dto.OrderDto;
import com.hxzy.hospital.dev.userCenter.vo.SearchVO;

import java.text.ParseException;
import java.util.List;

public interface HosUserService {
    List<OrderDto> findAll(Integer page, Integer limit);


    List<OrderDto> noStatus(Integer page, Integer limit);

    List<OrderDto> alreadyCode(Integer page, Integer limit);

    List<OrderDto> search(SearchVO searchVO) throws ParseException;

    OrderDto userdatail(Integer id);


    Result audit(OrderDto orderDto);

    OrderDto orderMsg(Integer id);

}
