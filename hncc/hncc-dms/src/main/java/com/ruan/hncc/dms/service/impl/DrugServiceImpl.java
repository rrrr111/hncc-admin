package com.ruan.hncc.dms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruan.hncc.common.utils.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.ruan.hncc.dms.dao.DrugDao;
import com.ruan.hncc.dms.entity.Drug;
import com.ruan.hncc.dms.service.DrugService;

/**
 * 药品项目表（包括了重要、中成药、草药）
 *
 * @author ruanteng
 * Date 2021-02-27 00:56:42
 * Copyright (C) hlhs
 */
@Service("drugService")
public class DrugServiceImpl extends ServiceImpl<DrugDao, Drug> implements DrugService {

    /**
     * 获得列表
     * @param params
     * @return
     */
    @Override
    public List<Drug> getPageDrug(Map<String, Object> params) {
        String code = (String) params.get("code");

        String name = (String) params.get("name");

        String dosageId = (String) params.get("dosageId");

        String typeId = (String) params.get("typeId");

        Integer pageNum = Integer.parseInt(String.valueOf(params.get("pageNum")));

        Integer pageSize = Integer.parseInt(String.valueOf( params.get("pageSize")));

        Integer currentPage = (pageNum-1)*pageSize;

        return this.baseMapper.listDrug(code,name,dosageId,typeId,currentPage,pageSize);


    }

    /**
     * 分页
     * @param params
     * @return
     */
    @Override
    public IPage<Drug> getPage(Map<String, Object> params) {
        String code = (String) params.get("code");

        String name = (String) params.get("name");

        String dosageId = (String) params.get("dosageId");

        String typeId = (String) params.get("typeId");

        Integer pageNum = Integer.parseInt(String.valueOf(params.get("pageNum")));

        Integer pageSize = Integer.parseInt(String.valueOf( params.get("pageSize")));

        LambdaQueryWrapper<Drug> wrapper = new LambdaQueryWrapper<Drug>();

        if(StringUtils.isNotEmpty(code)){
            wrapper.like(Drug::getCode,code);
        }

        if(StringUtils.isNotEmpty(name)){
            wrapper.like(Drug::getName,name);
        }

        if(StringUtils.isNotEmpty(dosageId)){
            wrapper.eq(Drug::getDosageId,dosageId);
        }

        if(StringUtils.isNotEmpty(typeId)){
            wrapper.like(Drug::getTypeId,typeId);
        }


        return page(new Page<>(pageNum,pageSize),wrapper);
    }

    /**
     * 获取详细信息
     * @param id
     * @return
     */
    @Override
    public Drug getDrugById(Long id) {

        return this.baseMapper.selectById(id);

    }

    /**
     * 创建
     * @param drug
     * @return
     */
    @Override
    public Integer createDrug(Drug drug) {
        return this.baseMapper.insert(drug);
    }

    /**
     * 修改
     * @param id
     * @param drug
     * @return
     */
    @Override
    public Integer updateDrug(Long id, Drug drug) {
        drug.setId(id);
        return this.baseMapper.updateById(drug);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @Override
    public Integer deleteDrug(Long[] id) {
        return this.baseMapper.deleteBatchIds(Arrays.asList(id));
    }
}