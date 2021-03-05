package com.ruan.hncc.sms.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ruan.hncc.sms.entity.Staff;

import java.util.Map;

/**
 * 员工表
 *
 * @author ruanteng
 * Date 2021-02-27 00:29:54
 * Copyright (C) hlhs
 */
public interface StaffService {

    IPage listStaffPage(Map<String, Object> params);
}

