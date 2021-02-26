package com.ruan.hncc.sms.dao;

import com.ruan.hncc.sms.entity.Dept;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 科室表(done)
 *
 * @author ruanteng
 * Date 2021-02-27 00:29:54
 * Copyright (C) hlhs
 */
@Mapper
public interface DeptDao extends BaseMapper<Dept> {
	
}
