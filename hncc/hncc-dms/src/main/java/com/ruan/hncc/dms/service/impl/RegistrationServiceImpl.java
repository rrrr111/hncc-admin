package com.ruan.hncc.dms.service.impl;

import org.springframework.stereotype.Service;
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

}