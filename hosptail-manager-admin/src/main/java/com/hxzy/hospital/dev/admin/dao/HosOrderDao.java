package com.hxzy.hospital.dev.admin.dao;

import com.hxzy.hospital.dev.admin.entity.HosOrder;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HosOrderDao {
     List<HosOrder> getList();

    Integer setOrderApprova(Integer id);
}
