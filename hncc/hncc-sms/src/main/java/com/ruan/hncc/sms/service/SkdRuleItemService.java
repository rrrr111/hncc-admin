package com.ruan.hncc.sms.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ruan.hncc.sms.entity.SkdRuleItem;

import java.util.List;
import java.util.Map;

/**
 * 排班规则表
 *
 * @author ruanteng
 * Date 2021-02-27 00:29:54
 * Copyright (C) hlhs
 */
public interface SkdRuleItemService {

    Integer createSkdRUleItem(SkdRuleItem skdRuleItem);

    IPage<SkdRuleItem> getListBySkdRuleId(Map<String, Object> params);

    List<SkdRuleItem> listBySkdRuleId(Long ruleId);

    List<SkdRuleItem> getList(Map<String, Object> params);

    Integer modifySkdRUleItem(SkdRuleItem skdRuleItem);
}

