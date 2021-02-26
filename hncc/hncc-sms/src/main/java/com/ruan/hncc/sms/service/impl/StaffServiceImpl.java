package com.ruan.hncc.sms.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.ruan.hncc.sms.dao.StaffDao;
import com.ruan.hncc.sms.entity.Staff;
import com.ruan.hncc.sms.service.StaffService;

/**
 * 员工表
 *
 * @author ruanteng
 * Date 2021-02-27 00:29:54
 * Copyright (C) hlhs
 */
@Service("staffService")
public class StaffServiceImpl extends ServiceImpl<StaffDao, Staff> implements StaffService {

}