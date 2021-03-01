package com.ruan.hncc.sms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruan.hncc.common.utils.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.ruan.hncc.sms.dao.SkdRuleDao;
import com.ruan.hncc.sms.entity.SkdRule;
import com.ruan.hncc.sms.service.SkdRuleService;

/**
 * 排班规则表
 *
 * @author ruanteng
 * Date 2021-02-27 00:29:54
 * Copyright (C) hlhs
 */
@Service("skdRuleService")
public class SkdRuleServiceImpl extends ServiceImpl<SkdRuleDao, SkdRule> implements SkdRuleService {

    @Override
    public List listSkdRulePage(Map<String, Object> params) {
        String deptId=(String) params.get("deptId");

        Integer pageNum = Integer.parseInt(String.valueOf(params.get("pageNum")));

        Integer pageSize = Integer.parseInt(String.valueOf( params.get("pageSize")));

        Integer cuurentPage = (pageNum-1)*pageSize;
        return this.baseMapper.listSkdRule(deptId,cuurentPage,pageSize);
    }

    @Override
    public IPage getPage(Map<String, Object> params) {

        String deptId=(String) params.get("deptId");

        Integer pageNum = Integer.parseInt(String.valueOf(params.get("pageNum")));

        Integer pageSize = Integer.parseInt(String.valueOf( params.get("pageSize")));

        LambdaQueryWrapper<SkdRule> wrapper = new LambdaQueryWrapper<SkdRule>();

        if(StringUtils.isNotEmpty(deptId)){
            wrapper.eq(SkdRule::getDeptId,deptId);
        }

        return page(new Page<>(pageNum,pageSize),wrapper);
    }

    @Override
    public SkdRule getRegistrationRankById(Long id) {
        return null;
    }

    @Override
    public Integer createSkdRule(SkdRule skdRule) {
        return null;
    }

    @Override
    public Integer modifySkdRule(Long id, SkdRule skdRule) {
        return null;
    }

    @Override
    public Integer deleteSkdRule(Long[] id) {
        return null;
    }
}