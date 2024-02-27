package com.hxzy.hospital.dev.userCenter.dao;/*
@Author:龙强
@date:2023/10/23
@version:1.0
*/

import com.hxzy.hospital.dev.userCenter.dto.OrderDto;
import com.hxzy.hospital.dev.userCenter.vo.SearchVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;

import java.util.List;

@Mapper
public interface OrderMapper {

    List<OrderDto> findAll(@Param("page") Integer page
            , @Param("limit") Integer limit);

    List<OrderDto> noStatus(@Param("page") Integer page
            , @Param("limit") Integer limit);

    List<OrderDto> areadyCode(@Param("page") Integer page
            , @Param("limit") Integer limit);

    List<OrderDto> search(SearchVO searchVO);

    OrderDto userDetail(Integer id);

    int update(OrderDto orderDto);

    OrderDto orderMsg(Integer id);
}
