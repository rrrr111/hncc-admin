package com.ruan.hncc.sms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruan.hncc.common.utils.StringUtils;
import com.ruan.hncc.sms.entity.SkdRule;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.ruan.hncc.sms.dao.SkdRuleItemDao;
import com.ruan.hncc.sms.entity.SkdRuleItem;
import com.ruan.hncc.sms.service.SkdRuleItemService;

import java.util.List;
import java.util.Map;

/**
 * 排班规则表
 *
 * @author ruanteng
 * Date 2021-02-27 00:29:54
 * Copyright (C) hlhs
 */
@Service("skdRuleItemService")
public class SkdRuleItemServiceImpl extends ServiceImpl<SkdRuleItemDao, SkdRuleItem> implements SkdRuleItemService {

    @Override
    public Integer createSkdRUleItem(SkdRuleItem skdRuleItem) {
        return this.baseMapper.insert(skdRuleItem);
    }

    @Override
    public IPage<SkdRuleItem> getListBySkdRuleId(Map<String, Object> params) {

       String id= (String) params.get("id");

        Integer pageNum = Integer.parseInt(String.valueOf(params.get("pageNum")));

        Integer pageSize = Integer.parseInt(String.valueOf(params.get("pageSize")));

        LambdaQueryWrapper<SkdRuleItem> wrapper = new LambdaQueryWrapper<SkdRuleItem>();

        if(StringUtils.isNotEmpty(id)){
            wrapper.eq(SkdRuleItem::getSkRuleId,id);
        }

        return page(new Page<>(pageNum,pageSize),wrapper);
    }

    @Override
    public List<SkdRuleItem> listBySkdRuleId(Long ruleId) {
        return this.baseMapper.selectList(new LambdaQueryWrapper<SkdRuleItem>().eq(SkdRuleItem::getSkRuleId,ruleId));
    }

    @Override
    public List<SkdRuleItem> getList(Map<String, Object> params) {
        String id= (String) params.get("id");

        Integer pageNum = Integer.parseInt(String.valueOf(params.get("pageNum")));

        Integer pageSize = Integer.parseInt(String.valueOf(params.get("pageSize")));

        Integer currentPage  =  (pageNum-1)*pageSize;

        return this.baseMapper.getList(id,currentPage,pageSize);

    }

    @Override
    public Integer modifySkdRUleItem(SkdRuleItem skdRuleItem) {
        return this.baseMapper.updateById(skdRuleItem);
    }
}