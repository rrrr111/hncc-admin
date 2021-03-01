package com.ruan.hncc.dms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruan.hncc.common.utils.StringUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.ruan.hncc.dms.dao.NonDrugDao;
import com.ruan.hncc.dms.entity.NonDrug;
import com.ruan.hncc.dms.service.NonDrugService;

/**
 * 非药品收费项目表
 *
 * @author ruanteng
 * Date 2021-02-27 00:23:22
 * Copyright (C) hlhs
 */
@Service("nonDrugService")
public class NonDrugServiceImpl extends ServiceImpl<NonDrugDao, NonDrug> implements NonDrugService {



    @Override
    public List<NonDrug> list(String code,String name,String mCode,String rType,String dept,Integer pageNum,Integer pageSize) {
//        String code = (String) params.get("code");
//        String name = (String) params.get("name");
//        String mCode = (String) params.get("mCode");
//        String rType = (String) params.get("rType");
//        String dept = (String)params.get("deptId");
//        Integer pageNum = Integer.parseInt(String.valueOf(params.get("pageNum")));
//        Integer pageSize = Integer.parseInt(String.valueOf( params.get("pageSize")));
        Integer currentPageNum = (pageNum-1)*pageSize;

        return this.baseMapper.listonDrug(code,name,mCode,rType,dept,currentPageNum,pageSize);

    }

    @Override
    public IPage<NonDrug> getPage(Map<String, Object> params) {

        String code = (String) params.get("code");
        String name = (String) params.get("name");
        String mCode = (String) params.get("mCode");
        String rType = (String) params.get("rType");
        String dept = (String)params.get("deptId");
        Integer pageNum = Integer.parseInt(String.valueOf(params.get("pageNum")));
        Integer pageSize = Integer.parseInt(String.valueOf( params.get("pageSize")));

        LambdaQueryWrapper<NonDrug> wrapper = new LambdaQueryWrapper<NonDrug>();

        if(StringUtils.isNotEmpty(code)){
            wrapper.like(NonDrug::getCode,code);
        }

        if(StringUtils.isNotEmpty(rType)){
            wrapper.eq(NonDrug::getRecordType,rType);
        }

        if(StringUtils.isNotEmpty(name)){
            wrapper.like(NonDrug::getName,name);
        }

        if(StringUtils.isNotEmpty(mCode)){
            wrapper.like(NonDrug::getMnemonicCode,mCode);
        }

        if(StringUtils.isNotEmpty(dept)){
            wrapper.like(NonDrug::getDeptName,mCode);
        }

        return page(new Page(pageNum,pageSize), wrapper);
    }
}