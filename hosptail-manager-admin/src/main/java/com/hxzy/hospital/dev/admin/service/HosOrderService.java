package com.hxzy.hospital.dev.admin.service;

import com.hxzy.hospital.dev.admin.entity.HosOrder;
import org.springframework.stereotype.Service;

import java.util.List;


public interface HosOrderService {
    List<HosOrder> getAll();

    Integer setOrderApprova(Integer id);

}
