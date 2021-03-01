package com.ruan.hncc.sms.dao;

import com.ruan.hncc.sms.entity.SkdRule;
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
public interface SkdRuleDao extends BaseMapper<SkdRule> {

    List listSkdRule(@Param("deptId") String deptId, @Param("cuurentPage") Integer cuurentPage, @Param("pageSize") Integer pageSize);
}
