package com.ruan.hncc.sms.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.ruan.hncc.sms.dao.SkdRuleDao;
import com.ruan.hncc.sms.entity.SkdRule;
import com.ruan.hncc.sms.service.SkdRuleService;

/**
 * 排班规则表
 *
 * @author ruanteng
 * Date 2021-02-27 00:29:54
 * Copyright (C) hlhs
 */
@Service("skdRuleService")
public class SkdRuleServiceImpl extends ServiceImpl<SkdRuleDao, SkdRule> implements SkdRuleService {

}