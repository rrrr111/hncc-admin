package com.ruan.hncc.dms.dao;

import com.ruan.hncc.dms.entity.CaseModel;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 病例模版表
 *
 * @author ruanteng
 * Date 2021-02-27 00:56:42
 * Copyright (C) hlhs
 */
@Mapper
public interface CaseModelDao extends BaseMapper<CaseModel> {
	
}
