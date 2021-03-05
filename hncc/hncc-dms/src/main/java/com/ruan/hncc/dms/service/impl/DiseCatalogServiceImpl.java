package com.ruan.hncc.dms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruan.hncc.common.utils.StringUtils;
import com.ruan.hncc.dms.service.DiseService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Map;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.ruan.hncc.dms.dao.DiseCatalogDao;
import com.ruan.hncc.dms.entity.DiseCatalog;
import com.ruan.hncc.dms.service.DiseCatalogService;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 诊断类型（疾病）目录表
 *
 * @author ruanteng
 * Date 2021-02-27 00:56:42
 * Copyright (C) hlhs
 */
@Service("diseCatalogService")
public class DiseCatalogServiceImpl extends ServiceImpl<DiseCatalogDao, DiseCatalog> implements DiseCatalogService {


    @Resource
    private DiseService diseService;

    @Override
    public IPage<DiseCatalog> getPage(Map<String, Object> params) {
        Integer pageNum = Integer.parseInt(String.valueOf(params.get("pageNum")));
        String name = (String) params.get("name");
        Integer pageSize = Integer.parseInt(String.valueOf( params.get("pageSize")));
        LambdaQueryWrapper<DiseCatalog> wrapper = new LambdaQueryWrapper<DiseCatalog>();
        if(StringUtils.isNotEmpty(name)){
            wrapper.like(DiseCatalog::getName,name);
        }
        return page(new Page<>(pageNum,pageSize),wrapper);
    }

    @Override
    public Integer createDiseCatalog(DiseCatalog diseCatalog) {
        return this.baseMapper.insert(diseCatalog);
    }

    @Override
    public DiseCatalog getDiseCatalogById(Long id) {
        return this.baseMapper.selectById(id);
    }

    @Override
    public Integer modifyDiseCatalog(Long id, DiseCatalog diseCatalog) {
        diseCatalog.setId(id);
        return this.baseMapper.updateById(diseCatalog);
    }

    @Transactional
    @Override
    public Integer deleteDiseCatalog(Long[] id) {

        for (Long aLong : id) {
            diseService.deleteDiseByDiseCatalog(aLong);
        }
        return this.baseMapper.deleteBatchIds(Arrays.asList(id));
    }
}