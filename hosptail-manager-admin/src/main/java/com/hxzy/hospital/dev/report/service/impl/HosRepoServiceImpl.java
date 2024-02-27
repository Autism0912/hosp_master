package com.hxzy.hospital.dev.report.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hxzy.hospital.dev.admin.dao.DeptDao;
import com.hxzy.hospital.dev.admin.dao.HosUserDao;
import com.hxzy.hospital.dev.admin.entity.HosUser;
import com.hxzy.hospital.dev.admin.entity.MyDept;
import com.hxzy.hospital.dev.common.utils.PageTableRequest;
import com.hxzy.hospital.dev.common.utils.Result;
import com.hxzy.hospital.dev.common.utils.ResultCode;
import com.hxzy.hospital.dev.patinceMan.entity.HosSick;
import com.hxzy.hospital.dev.patinceMan.mapper.HosSickMapper;
import com.hxzy.hospital.dev.report.dto.HosRepoDto;
import com.hxzy.hospital.dev.report.entity.HosPic;
import com.hxzy.hospital.dev.report.entity.HosRepo;
import com.hxzy.hospital.dev.report.entity.HosRepoPic;
import com.hxzy.hospital.dev.report.service.HosPicService;
import com.hxzy.hospital.dev.report.service.HosRepoPicService;
import com.hxzy.hospital.dev.report.service.HosRepoService;
import com.hxzy.hospital.dev.report.mapper.HosRepoMapper;
import com.hxzy.hospital.dev.report.vo.HosRepoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
* @author baby9
* @description 针对表【hos_repo(诊断报告表)】的数据库操作Service实现
* @createDate 2023-10-23 11:46:36
*/
@Service
public class HosRepoServiceImpl extends ServiceImpl<HosRepoMapper, HosRepo>
    implements HosRepoService {

    @Autowired
    private HosRepoMapper repoMapper;

    @Autowired
    private HosSickMapper sickMapper;

    @Autowired
    private DeptDao deptDao;

    @Autowired
    private HosUserDao hosUserDao;

    @Autowired
    private HosPicService hosPicService;

    @Autowired
    private HosRepoPicService hosRepoPicService;

    @Override
    public Result getRepList(PageTableRequest pageTableRequest, HosRepoVo hosRepoVo) {
        pageTableRequest.countOffset();
        Page page = PageHelper.offsetPage(pageTableRequest.getOffset(),pageTableRequest.getLimit());

        List<HosRepoDto> dtoList = new ArrayList<>();
        if (!ObjectUtils.isEmpty(hosRepoVo.getSickName())){
            HosSick byName = sickMapper.findByName(hosRepoVo.getSickName());
            if (ObjectUtils.isEmpty(byName)) {
                return Result.ok().count(page.getTotal()).data(dtoList).code(ResultCode.TABLE_SUCCESS);
            }
            hosRepoVo.setCostId(byName.getCostId());
        }
        List<HosRepo> hosRepos = repoMapper.selList(hosRepoVo);

        for (HosRepo repo : hosRepos) {
            HosRepoDto dto = new HosRepoDto();
            dto.setId(repo.getId());
            HosSick hosSick = sickMapper.fandByCostId(repo.getCostId());
            if (!ObjectUtils.isEmpty(hosSick)) {
                dto.setSickName(hosSick.getSickName());
            }
            MyDept myDept = deptDao.selectDeptById(repo.getDeptId());
            dto.setDeptName(myDept.getDeptName());
            dto.setCreateTime(repo.getCreateTime());
            dto.setRepoName(repo.getRepoName());
            dto.setUpdateTime(repo.getUpdateTime());
            HosUser hosUser = hosUserDao.getById(repo.getDocId());
            if (hosUser != null) {
                dto.setDocName(hosUser.getName());
            }
            dto.setStatus(repo.getStatus());
            dtoList.add(dto);
        }
        return Result.ok().count(page.getTotal()).data(dtoList).code(ResultCode.TABLE_SUCCESS);
    }

    @Override
    public Result addRepo(HosRepoVo hosRepoVo) throws ParseException {
        if (hosRepoVo.getCostId() != null) {
            HosRepo hosRepo = getHosRepo(hosRepoVo);
            repoMapper.insert(hosRepo);
            if (hosRepoVo.getFile() != null){
                for (String path : hosRepoVo.getFile()) {
                    HosPic hosPic = new HosPic();
                    hosPic.setPath(path);
                    hosPic.setStatus(0);
                    hosPicService.save(hosPic);
                    System.out.println(hosPic.getId());
                    HosRepoPic hosRepoPic = new HosRepoPic();
                    hosRepoPic.setRepoId(hosRepo.getId());
                    hosRepoPic.setPicId(hosPic.getId());
                    hosRepoPicService.save(hosRepoPic);
                }
            }
            return Result.ok().message("添加成功");
        }
        return Result.error().message("添加失败");
    }

    @Override
    public int deleteRepo(Integer id) {
        int count = repoMapper.deleteById(id);
        List<HosRepoPic> list = hosRepoPicService.list(new QueryWrapper<HosRepoPic>()
                .eq("repo_id",id));
        if (list != null) {
            hosRepoPicService.remove(new QueryWrapper<HosRepoPic>().eq("repo_id",id));
            for (HosRepoPic hosRepoPic : list) {
                hosPicService.remove(new QueryWrapper<HosPic>().eq("id",hosRepoPic.getPicId()));
            }
        }
        return count;
    }

    @Override
    public Result updateRepo(HosRepoVo hosRepoVo) {
        if (!ObjectUtils.isEmpty(hosRepoVo.getId())){
            repoMapper.updateRepo(hosRepoVo);
            if (hosRepoVo.getFile() != null){
                for (String path : hosRepoVo.getFile()) {
                    HosPic hosPic = new HosPic();
                    hosPic.setPath(path);
                    hosPic.setStatus(0);
                    hosPicService.save(hosPic);
                    System.out.println(hosPic.getId());
                    HosRepoPic hosRepoPic = new HosRepoPic();
                    hosRepoPic.setRepoId(hosRepoVo.getId());
                    hosRepoPic.setPicId(hosPic.getId());
                    hosRepoPicService.save(hosRepoPic);
                }
            }
            return Result.ok().message("修改成功");
        }
        return Result.ok().message("修改失败");
    }

    @Override
    public Result auditRepo(HosRepoVo hosRepoVo) {
        if (!ObjectUtils.isEmpty(hosRepoVo.getId())){
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String format = formatter.format(date);
            hosRepoVo.setUpdateTime(format);
            repoMapper.auditRepo(hosRepoVo);
            return Result.ok().message("审核成功");
        }
        return Result.ok().message("审核失败");
    }

    @Override
    public String getPdf(Integer id) {
        return null;
    }

    /**
     * HosRepoVo转HosRepo(添加)
     * @param hosRepoVo
     * @return HosRepo
     * @throws ParseException
     */
    private static HosRepo getHosRepo(HosRepoVo hosRepoVo) throws ParseException {
        HosRepo hosRepo = new HosRepo();
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (ObjectUtils.isEmpty(hosRepoVo.getCreateTime())) {
            Date date = ft.parse(hosRepoVo.getUpdateTime());
            hosRepo.setUpdateTime(date);
        }else {
            Date date = ft.parse(hosRepoVo.getCreateTime());
            hosRepo.setCreateTime(date);
        }
        hosRepo.setRepoName(hosRepoVo.getRepoName());
        hosRepo.setDes(0);
        hosRepo.setCheckMemo(hosRepoVo.getCheckMemo());
        hosRepo.setDiagMemo(hosRepoVo.getDiagMemo());
        hosRepo.setCostId(hosRepoVo.getCostId());
        hosRepo.setIsDel(0);
        hosRepo.setIsCommit(0);
        hosRepo.setDeptId(hosRepoVo.getDeptId());
        hosRepo.setDocId(hosRepoVo.getDocId());
        hosRepo.setStatus(0);
        return hosRepo;
    }
}




