package com.ruan.hncc.sms.dao;

import com.ruan.hncc.sms.entity.SkdRuleItem;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 排班规则表
 *
 * @author ruanteng
 * Date 2021-02-27 00:29:54
 * Copyright (C) hlhs
 */
@Mapper
public interface SkdRuleItemDao extends BaseMapper<SkdRuleItem> {

    List<SkdRuleItem> getList(@Param("id") String id, @Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize);
}
