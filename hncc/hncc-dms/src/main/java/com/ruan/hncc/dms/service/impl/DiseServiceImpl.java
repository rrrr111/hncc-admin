package com.ruan.hncc.dms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruan.hncc.common.utils.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Map;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.ruan.hncc.dms.dao.DiseDao;
import com.ruan.hncc.dms.entity.Dise;
import com.ruan.hncc.dms.service.DiseService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 诊断类型（疾病）表
 *
 * @author ruanteng
 * Date 2021-02-27 00:56:42
 * Copyright (C) hlhs
 */
@Service("diseService")
public class DiseServiceImpl extends ServiceImpl<DiseDao, Dise> implements DiseService {

    @Override
    public IPage<Dise> getPage(Map<String, Object> params) {

        Integer pageNum = Integer.parseInt(String.valueOf(params.get("pageNum")));

        Integer pageSize = Integer.parseInt(String.valueOf(params.get("pageSize")));

        String code = (String) params.get("code");

        String name = (String) params.get("name");

        String icd = (String) params.get("icd");

        String catId = (String) params.get("catId");

        LambdaQueryWrapper<Dise> wrapper = new LambdaQueryWrapper<Dise>();

        if(StringUtils.isNotEmpty(code)){
            wrapper.like(Dise::getCode,code);
        }

        if(StringUtils.isNotEmpty(name)){
            wrapper.like(Dise::getName,name);
        }

        if(StringUtils.isNotEmpty(icd)){
            wrapper.like(Dise::getIcd,icd);
        }

        if(StringUtils.isNotEmpty(catId)){
            wrapper.eq(Dise::getCatId,catId);
        }

        return page(new Page<>(pageNum, pageSize),wrapper);

    }

    @Override
    public Integer createDise(Dise dise) {
        return this.baseMapper.insert(dise);
    }

    @Override
    public Dise getDiseById(Long id) {

        return this.baseMapper.selectById(id);
    }

    @Override
    public Integer modifyDise(Long id, Dise dise) {
        dise.setId(id);
        return this.baseMapper.updateById(dise);
    }

    @Override
    public Integer deleteDise(Long[] id) {
        return this.baseMapper.deleteBatchIds(Arrays.asList(id));
    }

    @Override
    public void deleteDiseByDiseCatalog(Long aLong) {
        this.baseMapper.delete(new LambdaQueryWrapper<Dise>().eq(Dise::getCatId,aLong));
    }
}