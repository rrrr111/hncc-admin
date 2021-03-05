package com.ruan.hncc.sms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruan.hncc.common.utils.StringUtils;
import com.ruan.hncc.sms.dto.SkdRuleItemDto;
import com.ruan.hncc.sms.entity.SkdRuleItem;
import com.ruan.hncc.sms.service.SkdRuleItemService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.ruan.hncc.sms.dao.SkdRuleDao;
import com.ruan.hncc.sms.entity.SkdRule;
import com.ruan.hncc.sms.service.SkdRuleService;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 排班规则表
 *
 * @author ruanteng
 * Date 2021-02-27 00:29:54
 * Copyright (C) hlhs
 */
@Service("skdRuleService")
public class SkdRuleServiceImpl extends ServiceImpl<SkdRuleDao, SkdRule> implements SkdRuleService {

    @Resource
    private SkdRuleItemService skdRuleItemService;

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
        return this.baseMapper.selectOne(new LambdaQueryWrapper<SkdRule>().eq(SkdRule::getId,id));
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

    @Transactional
    @Override
    public Integer createSkdRuleAndRuleItem(SkdRuleItemDto[] skdRuleItemDto) {

        SkdRule skdRule = new SkdRule();
        skdRule.setDeptId(skdRuleItemDto[0].getDeptId());
        skdRule.setOperatorId(skdRuleItemDto[0].getUserId());
        skdRule.setOperateTime(new Date());
        skdRule.setRuleName(skdRuleItemDto[0].getRuleName());
        skdRule.setDescription(skdRuleItemDto[0].getDescription());

        int insert = this.baseMapper.insert(skdRule);
        Integer count = 0;
        if(insert>0){
            SkdRuleItem skdRuleItem = null;
            for (SkdRuleItemDto ruleItemDto : skdRuleItemDto) {
                skdRuleItem = new SkdRuleItem();
                skdRuleItem.setStaffId(ruleItemDto.getStaffId());
                skdRuleItem.setSkLimit(ruleItemDto.getSkLimit());
                skdRuleItem.setSkRuleId(skdRule.getId());
                skdRuleItem.setStatus(1);
                StringBuffer buffer  = new StringBuffer();
                if(ruleItemDto.getOneUp()!=null){
                    buffer.append(ruleItemDto.getOneUp());
                }else{
                    buffer.append("0");
                }

                if(ruleItemDto.getOneDown()!=null){
                    buffer.append(","+ruleItemDto.getOneDown());
                }else{
                    buffer.append(",0");
                }

                if(ruleItemDto.getTwoUp()!=null){
                    buffer.append(","+ruleItemDto.getTwoUp());
                }else{
                    buffer.append(",0");
                }

                if(ruleItemDto.getTwoDown()!=null){
                    buffer.append(","+ruleItemDto.getTwoDown());
                }else{
                    buffer.append(",0");
                }

                if(ruleItemDto.getThreeUp()!=null){
                    buffer.append(","+ruleItemDto.getThreeUp());
                }else{
                    buffer.append(",0");
                }

                if(ruleItemDto.getThreeDown()!=null){
                    buffer.append(","+ruleItemDto.getThreeDown());
                }else{
                    buffer.append(",0");
                }

                if(ruleItemDto.getFourUp()!=null){
                    buffer.append(","+ruleItemDto.getFourUp());
                }else{
                    buffer.append(",0");
                }

                if(ruleItemDto.getFourDown()!=null){
                    buffer.append(","+ruleItemDto.getFourDown());
                }else{
                    buffer.append(",0");
                }

                if(ruleItemDto.getFiveUp()!=null){
                    buffer.append(","+ruleItemDto.getFiveUp());
                }else{
                    buffer.append(",0");
                }

                if(ruleItemDto.getFiveDown()!=null){
                    buffer.append(","+ruleItemDto.getFiveDown());
                }else{
                    buffer.append(",0");
                }

                if(ruleItemDto.getSixUp()!=null){
                    buffer.append(","+ruleItemDto.getSixUp());
                }else{
                    buffer.append(",0");
                }

                if(ruleItemDto.getSixDown()!=null){
                    buffer.append(","+ruleItemDto.getSixDown());
                }else{
                    buffer.append(",0");
                }

                if(ruleItemDto.getSevenUp()!=null){
                    buffer.append(","+ruleItemDto.getSevenUp());
                }else{
                    buffer.append(",0");
                }

                if(ruleItemDto.getSevenDown()!=null){
                    buffer.append(","+ruleItemDto.getSevenDown());
                }else{
                    buffer.append(",0");
                }

                if(buffer.toString().indexOf(",")==0){
                    skdRuleItem.setDaysOfWeek(buffer.toString().substring(0,buffer.toString().length()));
                }else{
                    skdRuleItem.setDaysOfWeek(buffer.toString());
                }
                count =  skdRuleItemService.createSkdRUleItem(skdRuleItem);
                if(count<0){
                    throw new RuntimeException();
                }
            }
        }


        return count;
    }

    @Transactional
    @Override
    public Integer modifySkdRuleAndRuleItem(Long id, SkdRuleItemDto[] skdRuleItemDto) {
        SkdRule skdRule = new SkdRule();
        skdRule.setId(id);
        skdRule.setRuleName(skdRuleItemDto[0].getRuleName());
        skdRule.setDescription(skdRuleItemDto[0].getDescription());
        int insert = this.baseMapper.updateById(skdRule);
        Integer count = 0;
        if(insert>0){
            SkdRuleItem skdRuleItem = null;
            for (SkdRuleItemDto ruleItemDto : skdRuleItemDto) {
                skdRuleItem = new SkdRuleItem();
                skdRuleItem.setId(ruleItemDto.getId());
                skdRuleItem.setSkLimit(ruleItemDto.getSkLimit());
                StringBuffer buffer  = new StringBuffer();
                if(ruleItemDto.getOneUp()!=null){
                    buffer.append(ruleItemDto.getOneUp());
                }else{
                    buffer.append("0");
                }

                if(ruleItemDto.getOneDown()!=null){
                    buffer.append(","+ruleItemDto.getOneDown());
                }else{
                    buffer.append(",0");
                }

                if(ruleItemDto.getTwoUp()!=null){
                    buffer.append(","+ruleItemDto.getTwoUp());
                }else{
                    buffer.append(",0");
                }

                if(ruleItemDto.getTwoDown()!=null){
                    buffer.append(","+ruleItemDto.getTwoDown());
                }else{
                    buffer.append(",0");
                }

                if(ruleItemDto.getThreeUp()!=null){
                    buffer.append(","+ruleItemDto.getThreeUp());
                }else{
                    buffer.append(",0");
                }

                if(ruleItemDto.getThreeDown()!=null){
                    buffer.append(","+ruleItemDto.getThreeDown());
                }else{
                    buffer.append(",0");
                }

                if(ruleItemDto.getFourUp()!=null){
                    buffer.append(","+ruleItemDto.getFourUp());
                }else{
                    buffer.append(",0");
                }

                if(ruleItemDto.getFourDown()!=null){
                    buffer.append(","+ruleItemDto.getFourDown());
                }else{
                    buffer.append(",0");
                }

                if(ruleItemDto.getFiveUp()!=null){
                    buffer.append(","+ruleItemDto.getFiveUp());
                }else{
                    buffer.append(",0");
                }

                if(ruleItemDto.getFiveDown()!=null){
                    buffer.append(","+ruleItemDto.getFiveDown());
                }else{
                    buffer.append(",0");
                }

                if(ruleItemDto.getSixUp()!=null){
                    buffer.append(","+ruleItemDto.getSixUp());
                }else{
                    buffer.append(",0");
                }

                if(ruleItemDto.getSixDown()!=null){
                    buffer.append(","+ruleItemDto.getSixDown());
                }else{
                    buffer.append(",0");
                }

                if(ruleItemDto.getSevenUp()!=null){
                    buffer.append(","+ruleItemDto.getSevenUp());
                }else{
                    buffer.append(",0");
                }

                if(ruleItemDto.getSevenDown()!=null){
                    buffer.append(","+ruleItemDto.getSevenDown());
                }else{
                    buffer.append(",0");
                }

                if(buffer.toString().indexOf(",")==0){
                    skdRuleItem.setDaysOfWeek(buffer.toString().substring(0,buffer.toString().length()));
                }else{
                    skdRuleItem.setDaysOfWeek(buffer.toString());
                }
                count =  skdRuleItemService.modifySkdRUleItem(skdRuleItem);
                if(count<0){
                    throw new RuntimeException();
                }
            }
        }


        return count;
    }
}