package com.ruan.hncc.sms.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ruan.hncc.sms.entity.SkdRule;

import java.util.List;
import java.util.Map;

/**
 * 排班规则表
 *
 * @author ruanteng
 * Date 2021-02-27 00:29:54
 * Copyright (C) hlhs
 */
public interface SkdRuleService {

    List listSkdRulePage(Map<String, Object> params);

    IPage getPage(Map<String, Object> params);

    SkdRule getRegistrationRankById(Long id);

    Integer createSkdRule(SkdRule skdRule);

    Integer modifySkdRule(Long id, SkdRule skdRule);

    Integer deleteSkdRule(Long[] id);
}

