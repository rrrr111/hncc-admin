package com.ruan.hncc.sms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruan.hncc.common.utils.StringUtils;
import com.ruan.hncc.sms.entity.RegistrationRank;
import com.ruan.hncc.sms.service.RegistrationRankService;
import com.ruan.hncc.sms.vo.SkdVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.ruan.hncc.sms.dao.SkdDao;
import com.ruan.hncc.sms.entity.Skd;
import com.ruan.hncc.sms.service.SkdService;

import javax.annotation.Resource;

/**
 * 排班时间表
 *
 * @author ruanteng
 * Date 2021-02-27 00:29:54
 * Copyright (C) hlhs
 */
@Service("skdService")
public class SkdServiceImpl extends ServiceImpl<SkdDao, Skd> implements SkdService {

    @Resource
  private   RegistrationRankService rankService;

    @Override
    public List<SkdVo> listSkdPage(Map<String, Object> params) {

        String deptId = (String) params.get("deptId");

        String staffName = (String) params.get("staffName");

        String date = (String) params.get("date");

        Integer pageNum = Integer.parseInt(String.valueOf(params.get("pageNum")));

        Integer pageSize = Integer.parseInt(String.valueOf(params.get("pageSize")));

        Integer currentPage = (pageNum - 1) * pageSize;

        List<Skd> list = this.baseMapper.listSkdPage(deptId, staffName, date, currentPage, pageSize);

        //挂号级别列表
        List<RegistrationRank> rankList = rankService.listAll();

        if(list!= null && !list.isEmpty()){
            List<SkdVo> collect = list.stream().map(item -> {
                SkdVo skdVo = new SkdVo();
                BeanUtils.copyProperties(item, skdVo);
                return skdVo;
            }).collect(Collectors.toList());
            return collect;
        }

        return null;

    }

    /**
     * 根据挂号级别id设置挂号级别
     * @param skdVo
     * @param rankList
     * @return
     */
    private SkdVo getRegistrationLevel(SkdVo skdVo,List<RegistrationRank> rankList ){

        if(rankList!= null && !rankList.isEmpty()){
            rankList.stream().forEach(i->{
                if(skdVo.getRegistrationRankId().equals(i.getId())){
                    skdVo.setRegistrationRankName(i.getName());
                }
            });
        }

        return skdVo;

    }

    /**
     * 获得分页数据
     * @param params
     * @return
     */
    @Override
    public IPage getPage(Map<String, Object> params) {
        String deptId = (String) params.get("deptId");

        String staffName = (String) params.get("staffName");

        String date = (String) params.get("date");

        Integer pageNum = Integer.parseInt(String.valueOf(params.get("pageNum")));

        Integer pageSize = Integer.parseInt(String.valueOf(params.get("pageSize")));


        LambdaQueryWrapper<Skd> wrapper = new LambdaQueryWrapper<Skd>();

        if(StringUtils.isNotEmpty(deptId)){
            wrapper.eq(Skd::getDeptId,deptId);
        }

        if(StringUtils.isNotEmpty(staffName)){
            wrapper.eq(Skd::getStaffName,staffName);
        }

        if(StringUtils.isNotEmpty(date)){
            wrapper.eq(Skd::getDate,date);
        }

        return page(new Page<>(pageNum,pageSize),wrapper);
    }

    @Override
    public Skd getRegistrationRankById(Long id) {
        return null;
    }

    @Override
    public Integer createSkd(Skd skd) {
        return this.baseMapper.insert(skd);
    }

    @Override
    public Integer modifySkd(Long id, Skd skd) {
        skd.setId(id);
        return this.baseMapper.updateById(skd);
    }

    @Override
    public Integer deleteSkd(Long[] id) {
        return this.baseMapper.deleteBatchIds(Arrays.asList(id));
    }
}