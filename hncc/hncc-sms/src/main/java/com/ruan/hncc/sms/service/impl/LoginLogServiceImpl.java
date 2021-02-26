package com.ruan.hncc.sms.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.ruan.hncc.sms.dao.LoginLogDao;
import com.ruan.hncc.sms.entity.LoginLog;
import com.ruan.hncc.sms.service.LoginLogService;

/**
 * 登录日志表
 *
 * @author ruanteng
 * Date 2021-02-27 00:29:54
 * Copyright (C) hlhs
 */
@Service("loginLogService")
public class LoginLogServiceImpl extends ServiceImpl<LoginLogDao, LoginLog> implements LoginLogService {

}