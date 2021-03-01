package com.ruan.hncc.pms.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruan.hncc.common.api.CommonPage;
import com.ruan.hncc.common.api.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import com.ruan.hncc.pms.entity.Patient;
import com.ruan.hncc.pms.service.PatientService;



/**
 * 病人基本信息表
 *
 * @author ruanteng
 * Date 2021-02-27 00:27:59
 * Copyright (C) hlhs
 */
@RestController
@RequestMapping("pms/patient")
public class PatientController {
    @Resource
    private PatientService patientService;


    @GetMapping("/{id}")
    public CommonResult<Patient> list(@PathVariable Long id){


        return CommonResult.success(patientService.getPatientById(id));
    }


    /**
     * 获取病人列表
     * @param params
     * @return
     */
    @GetMapping("/list")
    public CommonResult<CommonPage<Patient>> list(@RequestParam Map<String, Object> params){
        Page<Patient> patientPage = patientService.listPatientPage(params);

        return CommonResult.success(CommonPage.restPage(patientPage));
    }

    /**
     * 创建病人信息
     * @param patient
     * @return
     */
    @PostMapping("/list")
    public CommonResult<Integer> createPatient(@RequestBody Patient patient){
        Integer count =  patientService.createPatient(patient);
        if(0<count){
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    /**
     * 删除病人信息
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public CommonResult<Integer> createPatient(@PathVariable Long[]id){
        Integer count =  patientService.deletePatient(id);
        if(0<count){
            return CommonResult.success(count);
        }
        return CommonResult.failed();

    }

    /**
     * 修改病人信息
     * @param id
     * @param patient
     * @return
     */
    @PutMapping("/update/{id}")
    public  CommonResult<Integer> updatePatient(@PathVariable Long id,Patient patient){
        Integer count =  patientService.modifyPatient(id,patient);
        if(0<count){
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

}
