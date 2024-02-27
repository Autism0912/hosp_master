package com.hxzy.hospital.dev.admin.service.impl;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hxzy.hospital.dev.admin.dao.OrderSickDao;
import com.hxzy.hospital.dev.admin.entity.view.OrderSick;
import com.hxzy.hospital.dev.admin.service.OrderSickService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderSickImpl implements OrderSickService {
    @Autowired
    private OrderSickDao orderSickDao;

    @Override
    public List<OrderSick> getAll() {
        return orderSickDao.getAll();
    }

    @Override
    public OrderSick getId(Integer id) {
        return orderSickDao.getById(id);
    }

    @Override
    public Integer update(OrderSick orderSick) {
        return orderSickDao.update(orderSick);
    }
}
