package com.ruan.hncc.bms.dao;

import com.ruan.hncc.bms.entity.BillsRecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 医院账单流水表
 *
 * @author ruanteng
 * Date 2021-02-27 00:11:43
 * Copyright (C) hlhs
 */
@Mapper
public interface BillsRecordDao extends BaseMapper<BillsRecord> {
	
}
