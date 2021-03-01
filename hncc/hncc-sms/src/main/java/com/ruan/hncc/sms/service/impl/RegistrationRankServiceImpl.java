package com.ruan.hncc.sms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruan.hncc.common.utils.StringUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Map;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.ruan.hncc.sms.dao.RegistrationRankDao;
import com.ruan.hncc.sms.entity.RegistrationRank;
import com.ruan.hncc.sms.service.RegistrationRankService;

/**
 * 挂号级别表
 *
 * @author ruanteng
 * Date 2021-02-27 00:29:54
 * Copyright (C) hlhs
 */
@Service("registrationRankService")
public class RegistrationRankServiceImpl extends ServiceImpl<RegistrationRankDao, RegistrationRank> implements RegistrationRankService {

    /**
     * 获取挂号级别列表
     * @param map
     * @return
     */
    @Override
    public IPage listRegistrationRankPage(Map<String, Object> map) {

         String code = (String) map.get("code");

         String name= (String) map.get("name");

         String seqNo= (String) map.get("seqNo");

         BigDecimal price=(BigDecimal) map.get("price");

         String status=(String) map.get("status");

        Integer pageNum = Integer.parseInt(String.valueOf(map.get("pageNum")));

        Integer pageSize = Integer.parseInt(String.valueOf( map.get("pageSize")));

         LambdaQueryWrapper<RegistrationRank> wrapper = new LambdaQueryWrapper<RegistrationRank>();

        if(StringUtils.isNotEmpty(code)){
            wrapper.like(RegistrationRank::getCode,code);
        }

        if(StringUtils.isNotEmpty(name)){
            wrapper.like(RegistrationRank::getName,name);
        }

        if(StringUtils.isNotEmpty(seqNo)){
            wrapper.like(RegistrationRank::getSeqNo,seqNo);
        }

        if(price!=null){
            wrapper.eq(RegistrationRank::getPrice,price.toString());
        }

        if(StringUtils.isNotEmpty(status)){
            wrapper.like(RegistrationRank::getStatus,status);
        }

         return page(new Page<RegistrationRank>(pageNum,pageSize),wrapper);

    }

    /**
     * 获取挂号级别详细信息
     * @param id
     * @return
     */
    @Override
    public RegistrationRank getRegistrationRankById(Long id) {

        return this.baseMapper.selectById(id);
    }

    /**
     * 创建挂号级别信息
     * @param registrationRank
     * @return
     */
    @Override
    public Integer createRegistrationRank(RegistrationRank registrationRank) {

        return this.baseMapper.insert(registrationRank);
    }

    /**
     * 修改挂号级别信息
     * @param id
     * @param registrationRank
     * @return
     */
    @Override
    public Integer modifyRegistrationRank(Long id, RegistrationRank registrationRank) {
        registrationRank.setId(id);
        return this.baseMapper.updateById(registrationRank);
    }

    /**
     * 删除挂号级别信息
     * @param id
     * @return
     */
    @Override
    public Integer deleteRegistrationRank(Long[] id) {

        return this.baseMapper.deleteBatchIds(Arrays.asList(id));
    }
}