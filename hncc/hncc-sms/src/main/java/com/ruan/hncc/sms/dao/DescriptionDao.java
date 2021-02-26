package com.ruan.hncc.sms.dao;

import com.ruan.hncc.sms.entity.Description;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 科室、员工描述表
 *
 * @author ruanteng
 * Date 2021-02-27 00:29:54
 * Copyright (C) hlhs
 */
@Mapper
public interface DescriptionDao extends BaseMapper<Description> {
	
}
