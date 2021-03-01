package com.ruan.hncc.pms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruan.hncc.common.utils.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.ruan.hncc.pms.dao.PatientDao;
import com.ruan.hncc.pms.entity.Patient;
import com.ruan.hncc.pms.service.PatientService;

/**
 * 病人基本信息表
 *
 * @author ruanteng
 * Date 2021-02-27 00:27:59
 * Copyright (C) hlhs
 */
@Service("patientService")
public class PatientServiceImpl extends ServiceImpl<PatientDao, Patient> implements PatientService {

    /**
     * 获取病人列表
     * @param params
     * @return
     */
    @Override
    public Page<Patient> listPatientPage(Map<String, Object> params) {
        String name = (String) params.get("name");

        Date dateOfBirth = (Date) params.get("dateOfBirth");

        String identificationNo = (String) params.get("identificationNo");

        String homeAddress = (String) params.get("homeAddress");

        String phoneNo = (String) params.get("phoneNo");

        String gender = (String) params.get("gender");

        String medicalRecordNo = (String) params.get("medicalRecordNo");

        Integer pageNum = Integer.parseInt((String) params.get("pageNum"));

        Integer pageSize = Integer.parseInt((String) params.get("pageSize"));

        LambdaQueryWrapper<Patient> wrapper = new LambdaQueryWrapper<Patient>();

        if(StringUtils.isNotEmpty(name)){
            wrapper.like(Patient::getName,name);
        }

        if(dateOfBirth!=null){
            wrapper.eq(Patient::getDateOfBirth,dateOfBirth);
        }

        if(StringUtils.isNotEmpty(identificationNo)){
            wrapper.like(Patient::getIdentificationNo,identificationNo);
        }

        if(StringUtils.isNotEmpty(homeAddress)){
            wrapper.like(Patient::getHomeAddress,homeAddress);
        }

        if(StringUtils.isNotEmpty(phoneNo)){
            wrapper.like(Patient::getPhoneNo,phoneNo);
        }

        if(StringUtils.isNotEmpty(gender)){
            wrapper.like(Patient::getGender,gender);
        }

        if(StringUtils.isNotEmpty(medicalRecordNo)){
            wrapper.like(Patient::getMedicalRecordNo,medicalRecordNo);
        }

        return  this.page(new Page<>(pageNum,pageSize),wrapper);


    }



    /**
     * 创建病人
     * @param patient
     * @return
     */
    @Override
    public Integer createPatient(Patient patient) {

        return this.baseMapper.insert(patient);

    }


    /**
     * 删除病人
     * @param id
     * @return
     */
    @Override
    public Integer deletePatient(Long[] id) {
        return this.baseMapper.deleteBatchIds(Arrays.asList(id));
    }

    /**
     * 修改病人信息
     * @param id
     * @param patient
     * @return
     */
    @Override
    public Integer modifyPatient(Long id, Patient patient) {
        patient.setId(id);
        return this.baseMapper.updateById(patient);
    }

    /**
     * 获取指定病人信息
     * @param id
     * @return
     */
    @Override
    public Patient getPatientById(Long id) {
        return this.baseMapper.selectById(id);
    }

}