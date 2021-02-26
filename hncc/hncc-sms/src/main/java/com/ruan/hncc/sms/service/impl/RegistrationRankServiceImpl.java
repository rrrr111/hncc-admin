package com.ruan.hncc.sms.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.ruan.hncc.sms.dao.RegistrationRankDao;
import com.ruan.hncc.sms.entity.RegistrationRank;
import com.ruan.hncc.sms.service.RegistrationRankService;

/**
 * 挂号级别表
 *
 * @author ruanteng
 * Date 2021-02-27 00:29:54
 * Copyright (C) hlhs
 */
@Service("registrationRankService")
public class RegistrationRankServiceImpl extends ServiceImpl<RegistrationRankDao, RegistrationRank> implements RegistrationRankService {

}