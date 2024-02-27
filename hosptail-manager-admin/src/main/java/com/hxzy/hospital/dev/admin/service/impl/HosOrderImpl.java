package com.hxzy.hospital.dev.admin.service.impl;

import com.hxzy.hospital.dev.admin.dao.HosOrderDao;
import com.hxzy.hospital.dev.admin.entity.HosOrder;
import com.hxzy.hospital.dev.admin.service.HosOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HosOrderImpl implements HosOrderService {
    @Autowired
    private HosOrderDao hosOrderDao;

    @Override
    public List<HosOrder> getAll() {
        return hosOrderDao.getList();
    }

    @Override
    public Integer setOrderApprova(Integer id) {
        return hosOrderDao.setOrderApprova(id);
    }
}
