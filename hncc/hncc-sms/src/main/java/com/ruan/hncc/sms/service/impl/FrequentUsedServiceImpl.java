package com.ruan.hncc.sms.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.ruan.hncc.sms.dao.FrequentUsedDao;
import com.ruan.hncc.sms.entity.FrequentUsed;
import com.ruan.hncc.sms.service.FrequentUsedService;

/**
 * 医生常用诊断（疾病）、检查检验表(搁置)
 *
 * @author ruanteng
 * Date 2021-02-27 00:29:54
 * Copyright (C) hlhs
 */
@Service("frequentUsedService")
public class FrequentUsedServiceImpl extends ServiceImpl<FrequentUsedDao, FrequentUsed> implements FrequentUsedService {

}