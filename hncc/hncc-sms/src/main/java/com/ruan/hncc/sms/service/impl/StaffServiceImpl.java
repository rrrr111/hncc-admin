package com.ruan.hncc.sms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruan.hncc.common.utils.StringUtils;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.ruan.hncc.sms.dao.StaffDao;
import com.ruan.hncc.sms.entity.Staff;
import com.ruan.hncc.sms.service.StaffService;

/**
 * 员工表
 *
 * @author ruanteng
 * Date 2021-02-27 00:29:54
 * Copyright (C) hlhs
 */
@Service("staffService")
public class StaffServiceImpl extends ServiceImpl<StaffDao, Staff> implements StaffService {

    @Override
    public IPage listStaffPage(Map<String, Object> params) {

        String deptId = (String) params.get("deptId");

        Integer pageNum = Integer.parseInt(String.valueOf(params.get("pageNum")));

        Integer pageSize = Integer.parseInt(String.valueOf(params.get("pageSize")));

        LambdaQueryWrapper<Staff> wrapper = new LambdaQueryWrapper<Staff>();

        if(StringUtils.isNotEmpty(deptId)){
            wrapper.eq(Staff::getDeptId,deptId);
        }

        return page(new Page<>(pageNum,pageSize),wrapper);

    }
}