package com.ruan.hncc.dms.dao;

import com.ruan.hncc.dms.entity.NonDrug;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 非药品收费项目表
 *
 * @author ruanteng
 * Date 2021-02-27 00:23:22
 * Copyright (C) hlhs
 */
@Mapper
public interface NonDrugDao extends BaseMapper<NonDrug> {
	
}
