package com.hxzy.hospital.dev.admin.service.impl;

import cn.hutool.core.convert.Convert;
import com.hxzy.hospital.dev.admin.dao.DictDetailDao;
import com.hxzy.hospital.dev.admin.entity.MyDict;
import com.hxzy.hospital.dev.admin.entity.MyDictDetail;
import com.hxzy.hospital.dev.admin.service.DictDetailService;
import com.hxzy.hospital.dev.admin.service.DictService;
import com.hxzy.hospital.dev.common.utils.Result;
import com.hxzy.hospital.dev.common.utils.ResultCode;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DictDetailServiceImpl implements DictDetailService {
    @Autowired
    private DictService dictService;

    @Autowired
    private DictDetailDao dictDetailDao;

    @Override
    public Result<MyDictDetail> getDictByName(Integer offectPosition, Integer limit, String dictName) {
        MyDict dictByName =dictService.getDictByName(dictName);
        Integer dictId = dictByName.getDictId();
        Page page = PageHelper.offsetPage(offectPosition,limit);
        List<MyDictDetail> fuzzyDictDetailByPage = getDictDetail(dictId);
        return Result.ok().count(page.getTotal()).data(fuzzyDictDetailByPage).code(ResultCode.TABLE_SUCCESS);
    }

    @Override
    public List<MyDictDetail> getDictDetail(Integer dictId) {
        return dictDetailDao.getDictDetail(dictId);
    }

    @Override
    public int insertDictDetail(MyDictDetail myDictDetail) {
        return dictDetailDao.insertDictDetail(myDictDetail);
    }

    @Override
    public MyDictDetail getDictDetailById(Integer id) {
        return dictDetailDao.getDictDetailById(id);
    }

    @Override
    public int updateDictDetail(MyDictDetail myDictDetail) {
        return dictDetailDao.updateDictDetail(myDictDetail);
    }

    @Override
    public int deleteDictDetailByIds(String ids) {
        Integer[] dictDetailIds = Convert.toIntArray(ids);
        return dictDetailDao.deleteDictDetailByIds(dictDetailIds);
    }

    @Override
    public int deleteDictDetailByDictId(Integer dictId) {
        return dictDetailDao.deleteDictDetailByDictId(dictId);
    }
}
