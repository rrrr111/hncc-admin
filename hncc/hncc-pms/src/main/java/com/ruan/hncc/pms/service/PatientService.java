package com.ruan.hncc.pms.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruan.hncc.pms.entity.Patient;

import java.util.Map;

/**
 * 病人基本信息表
 *
 * @author ruanteng
 * Date 2021-02-27 00:27:59
 * Copyright (C) hlhs
 */
public interface PatientService {

    /**
     * 获取病人列表
     * @param params
     * @return
     */
    Page<Patient> listPatientPage(Map<String, Object> params);

    /**
     * 新增病人
     * @param patient
     * @return
     */
    Integer createPatient(Patient patient);

    /**
     * 删除病人
     * @param id
     * @return
     */
    Integer deletePatient(Long[] id);


    /**
     * 修改病人信息
     * @param id
     * @param patient
     * @return
     */
    Integer modifyPatient(Long id, Patient patient);

    /**
     * 获取指定病人信息
     * @param id
     * @return
     */
    Patient getPatientById(Long id);
}

