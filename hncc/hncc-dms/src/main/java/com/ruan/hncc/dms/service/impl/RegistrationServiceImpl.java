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


import com.ruan.hncc.dms.dao.RegistrationDao;
import com.ruan.hncc.dms.entity.Registration;
import com.ruan.hncc.dms.service.RegistrationService;

/**
 * 就诊(门诊)信息表（一个病人一个病历号，多次就诊，多次就诊信息），也可以看作医院的挂号表
挂了号相当于开了一
 *
 * @author ruanteng
 * Date 2021-02-27 00:23:22
 * Copyright (C) hlhs
 */
@Service("registrationService")
public class RegistrationServiceImpl extends ServiceImpl<RegistrationDao, Registration> implements RegistrationService {

    @Override
    public List<Registration> getListPage(Map<String, Object> params) {

        Integer pageNum = Integer.parseInt(String.valueOf(params.get("pageNum")));

        Integer pageSize = Integer.parseInt(String.valueOf(params.get("pageSize")));

        String deptId = (String) params.get("deptId");

        String endAttendance = (String) params.get("endAttendance");

        String name = (String) params.get("name");


        Integer currentPage = (pageNum-1)*pageSize;

        return this.baseMapper.getRegistrationList(currentPage,pageSize,deptId,endAttendance,name);


    }

    @Override
    public IPage<Registration> getPage(Map<String, Object> params) {
        Integer pageNum = Integer.parseInt(String.valueOf(params.get("pageNum")));

        Integer pageSize = Integer.parseInt(String.valueOf(params.get("pageSize")));

        String deptId = (String) params.get("deptId");

        String endAttendance = (String) params.get("endAttendance");

        String name = (String) params.get("name");

        LambdaQueryWrapper<Registration> wrapper = new LambdaQueryWrapper<Registration>();

        if(StringUtils.isNotEmpty(deptId)){
            wrapper.eq(Registration::getDeptId,deptId);
        }

        if(StringUtils.isNotEmpty(endAttendance)){
            wrapper.eq(Registration::getEndAttendance,endAttendance);
        }




        return page(new Page<>(pageNum,pageSize),wrapper);
    }

    @Override
    public Integer createRegistration(Registration registration) {
        return this.baseMapper.insert(registration);
    }

    @Override
    public Registration getRegistrationById(Long id) {
        return this.baseMapper.selectById(id);
    }

    @Override
    public Integer modifyRegistration(Long id, Registration registration) {
        registration.setId(id);
        return this.baseMapper.updateById(registration);
    }

    @Override
    public Integer deleteRegistration(Long[] id) {
        return this.baseMapper.deleteBatchIds(Arrays.asList(id));
    }
}