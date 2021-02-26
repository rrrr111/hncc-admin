package com.ruan.hncc.pms.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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

}
