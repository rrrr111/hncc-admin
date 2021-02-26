package com.ruan.hncc.pms.service.impl;

import org.springframework.stereotype.Service;
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

}