package com.ruan.hncc.sms.dao;

import com.ruan.hncc.sms.entity.FrequentUsed;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 医生常用诊断（疾病）、检查检验表(搁置)
 *
 * @author ruanteng
 * Date 2021-02-27 00:29:54
 * Copyright (C) hlhs
 */
@Mapper
public interface FrequentUsedDao extends BaseMapper<FrequentUsed> {
	
}
