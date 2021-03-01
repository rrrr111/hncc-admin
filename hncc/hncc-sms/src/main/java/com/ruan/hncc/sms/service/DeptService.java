package com.ruan.hncc.sms.service;

import com.ruan.hncc.common.api.CommonPage;
import com.ruan.hncc.common.api.CommonResult;
import com.ruan.hncc.sms.entity.Dept;

import java.util.List;


/**
 * 科室表(done)
 *
 * @author ruanteng
 * Date 2021-02-27 00:29:54
 * Copyright (C) hlhs
 */
public interface DeptService {


    /**
     * 查询所有科室
     * @return
     */
    List<Dept> listAll();
}

