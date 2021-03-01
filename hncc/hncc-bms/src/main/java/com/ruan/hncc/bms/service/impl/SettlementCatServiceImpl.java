package com.ruan.hncc.bms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruan.hncc.common.utils.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Map;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.ruan.hncc.bms.dao.SettlementCatDao;
import com.ruan.hncc.bms.entity.SettlementCat;
import com.ruan.hncc.bms.service.SettlementCatService;

/**
 * j结算类别
 *
 * @author ruanteng
 * Date 2021-02-27 00:11:43
 * Copyright (C) hlhs
 */
@Service("settlementCatService")
public class SettlementCatServiceImpl extends ServiceImpl<SettlementCatDao, SettlementCat> implements SettlementCatService {

    @Override
    public IPage listPage(Map<String, Object> params) {
        String name = (String)params.get("name");

        Integer pageNum = Integer.parseInt(String.valueOf(params.get("pageNum")));

        Integer pageSize = Integer.parseInt(String.valueOf( params.get("pageSize")));

        LambdaQueryWrapper<SettlementCat> wrapper = new LambdaQueryWrapper<SettlementCat>();

        if(StringUtils.isNotEmpty(name)){
            wrapper.like(SettlementCat::getName,name);
        }

        return page(new Page<>(pageNum,pageSize),wrapper);

    }

    /**
     * 获取结算详细信息
     * @param id
     * @return
     */
    @Override
    public SettlementCat getSettlementCatById(Long id) {
        return this.baseMapper.selectById(id);
    }

    /**
     * 创建结算
     * @param drug
     * @return
     */
    @Override
    public Integer createSettlementCat(SettlementCat drug) {
        return this.baseMapper.insert(drug);
    }

    /**
     * 修改结算
     * @param id
     * @param drug
     * @return
     */
    @Override
    public Integer updateSettlementCat(Long id, SettlementCat drug) {
        drug.setId(id);
        return this.baseMapper.updateById(drug);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @Override
    public Integer deleteSettlementCat(Long[] id) {
        return this.baseMapper.deleteBatchIds(Arrays.asList(id));
    }
}