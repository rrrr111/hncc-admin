package com.ruan.hncc.dms.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ruan.hncc.dms.entity.Registration;

import java.util.List;
import java.util.Map;

/**
 * 就诊(门诊)信息表（一个病人一个病历号，多次就诊，多次就诊信息），也可以看作医院的挂号表
挂了号相当于开了一
 *
 * @author ruanteng
 * Date 2021-02-27 00:23:22
 * Copyright (C) hlhs
 */
public interface RegistrationService {

    List<Registration> getListPage(Map<String, Object> params);

    IPage<Registration> getPage(Map<String, Object> params);

    Integer createRegistration(Registration registration);

    Registration getRegistrationById(Long id);

    Integer modifyRegistration(Long id, Registration registration);

    Integer deleteRegistration(Long[] id);
}

