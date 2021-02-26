package com.ruan.hncc.sms.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.ruan.hncc.sms.dao.SkdDao;
import com.ruan.hncc.sms.entity.Skd;
import com.ruan.hncc.sms.service.SkdService;

/**
 * 排班时间表
 *
 * @author ruanteng
 * Date 2021-02-27 00:29:54
 * Copyright (C) hlhs
 */
@Service("skdService")
public class SkdServiceImpl extends ServiceImpl<SkdDao, Skd> implements SkdService {

}