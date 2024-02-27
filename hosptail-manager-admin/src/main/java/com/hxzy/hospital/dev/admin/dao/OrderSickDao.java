package com.hxzy.hospital.dev.admin.dao;

import com.hxzy.hospital.dev.admin.entity.view.OrderSick;
import org.apache.ibatis.annotations.Mapper;

import java.util.*;
@Mapper
public interface OrderSickDao {
     List<OrderSick> getAll();

    OrderSick getById(Integer id);

    Integer update(OrderSick orderSick);
}
