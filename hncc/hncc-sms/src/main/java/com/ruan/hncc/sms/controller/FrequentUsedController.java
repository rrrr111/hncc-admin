package com.ruan.hncc.sms.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import com.ruan.hncc.sms.entity.FrequentUsed;
import com.ruan.hncc.sms.service.FrequentUsedService;



/**
 * 医生常用诊断（疾病）、检查检验表(搁置)
 *
 * @author ruanteng
 * Date 2021-02-27 00:29:54
 * Copyright (C) hlhs
 */
@RestController
@RequestMapping("sms/frequentused")
public class FrequentUsedController {
    @Resource
    private FrequentUsedService frequentUsedService;

}
