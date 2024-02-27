package com.hxzy.hospital.dev.admin.service;

import com.hxzy.hospital.dev.admin.entity.view.OrderSick;

import java.util.List;

public interface OrderSickService {

    List<OrderSick> getAll();

    OrderSick getId(Integer id);

    Integer update(OrderSick orderSick);
}
