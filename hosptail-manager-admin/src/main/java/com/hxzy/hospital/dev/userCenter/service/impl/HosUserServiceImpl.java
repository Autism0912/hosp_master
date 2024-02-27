package com.hxzy.hospital.dev.userCenter.service.impl;/*
@Author:龙强
@date:2023/10/23
@version:1.0
*/

import com.hxzy.hospital.dev.common.utils.Result;
import com.hxzy.hospital.dev.common.utils.ResultCode;
import com.hxzy.hospital.dev.userCenter.dao.OrderMapper;
import com.hxzy.hospital.dev.userCenter.dto.OrderDto;
import com.hxzy.hospital.dev.userCenter.service.HosUserService;
import com.hxzy.hospital.dev.userCenter.utils.CastDate;
import com.hxzy.hospital.dev.userCenter.vo.SearchVO;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class HosUserServiceImpl  implements HosUserService {
    private final OrderMapper orderMapper;

    public HosUserServiceImpl(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    @Override
    public List<OrderDto> findAll(Integer page, Integer limit) {
        List<OrderDto> orderDtos = orderMapper.findAll(page,limit);
        List<OrderDto> orderDtos2 = new ArrayList<>();
        orderRefacterIncluedAge(orderDtos, orderDtos2);
        return orderDtos2;
    }

    @Override
    public List<OrderDto> noStatus(Integer page, Integer limit) {
        List<OrderDto> orderDtos = orderMapper.noStatus(page,limit);
        List<OrderDto> orderDtos2 = new ArrayList<>();
        orderRefacterIncluedAge(orderDtos,orderDtos2);
        return orderDtos2;
    }

    @Override
    public List<OrderDto> alreadyCode(Integer page, Integer limit) {
        List<OrderDto> orderDtos = orderMapper.areadyCode(page,limit);
        List<OrderDto> orderDtos2 = new ArrayList<>();
        orderRefacterIncluedAge(orderDtos,orderDtos2);
        return orderDtos2;
    }

    @Override
    public List<OrderDto> search(SearchVO searchVO) throws ParseException {
        //判断search是否为空对象
        if (searchVO.getDate().equals("") && searchVO.getNickname().equals("") && searchVO.getIdCard().equals("")){
            List<OrderDto> all = orderMapper.findAll((searchVO.getPage() - 1) * searchVO.getLimit(), searchVO.getLimit());
            List<OrderDto> orderDtos2 = new ArrayList<>();
            orderRefacterIncluedAge(all,orderDtos2);
            return orderDtos2;
        }else {
            List<OrderDto> all =  orderMapper.search(searchVO);
            List<OrderDto> orderDtos2 = new ArrayList<>();
            orderRefacterIncluedAge(all,orderDtos2);
            return orderDtos2;
        }
    }

    @Override
    public OrderDto userdatail(Integer id) {
        OrderDto orderDto =  orderMapper.userDetail(id);
        return  logoutYear(orderDto);
    }

    @Override
    public Result audit(OrderDto orderDto) {
       int count =  orderMapper.update(orderDto);
       if (count>0){
           return Result.ok().code(ResultCode.TABLE_SUCCESS);
       }
        System.out.println("count"+count);
        return Result.error().code(ResultCode.ERROR);
    }

    @Override
    public OrderDto orderMsg(Integer id) {
        OrderDto orderDto =  orderMapper.orderMsg(id);
        OrderDto orderDto1 = logoutYear(orderDto);
        System.out.println(orderDto);
        return orderDto1;
    }


    private  OrderDto logoutYear(OrderDto orderDto) {
        Calendar calendar = Calendar.getInstance();
        Integer year = calendar.get(Calendar.YEAR);
        OrderDto orderDtos1 = new OrderDto();
        orderDtos1.setId(orderDto.getId());
        orderDtos1.setSickName(orderDto.getSickName());
        orderDtos1.setSickCode(orderDto.getSickCode());
        orderDtos1.setProjName(orderDto.getProjName());
        orderDtos1.setCreateTime(orderDto.getCreateTime());
        orderDtos1.setSickSex(orderDto.getSickSex());
        orderDtos1.setPapertypeCode(orderDto.getPapertypeCode());
        orderDtos1.setSickPhone(orderDto.getSickPhone());
        orderDtos1.setAge(year - Integer.parseInt(orderDto.getPapertypeCode().substring(6,10)));
        orderDtos1.setOrderStatus(orderDto.getOrderStatus());
        orderDtos1.setDeptName(orderDto.getDeptName());
        orderDtos1.setName(orderDto.getName());
        orderDtos1.setSickAddr(orderDto.getSickAddr());
        orderDtos1.setIllDes(orderDto.getIllDes());
        orderDtos1.setIllHistory(orderDto.getIllHistory());
        orderDtos1.setDecDiag(orderDto.getDecDiag());
        return orderDtos1;
    }

    private  void orderRefacterIncluedAge(List<OrderDto> orderDtos,  List<OrderDto> orderDtos2) {
        Calendar calendar = Calendar.getInstance();
        Integer year = calendar.get(Calendar.YEAR);
        for (OrderDto orderDto : orderDtos) {
            OrderDto orderDto1 = new OrderDto();
            orderDto1.setId(orderDto.getId());
            orderDto1.setSickName(orderDto.getSickName());
            orderDto1.setSickCode(orderDto.getSickCode());
            orderDto1.setProjName(orderDto.getProjName());
            orderDto1.setCreateTime(orderDto.getCreateTime());
            orderDto1.setSickSex(orderDto.getSickSex());
            orderDto1.setAge(year - Integer.parseInt(orderDto.getPapertypeCode().substring(6,10)));
            orderDto1.setOrderStatus(orderDto.getOrderStatus());
            orderDtos2.add(orderDto1);
        }
    }
}
