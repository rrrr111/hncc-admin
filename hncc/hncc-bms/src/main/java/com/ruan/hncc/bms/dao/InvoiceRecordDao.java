package com.ruan.hncc.bms.dao;

import com.ruan.hncc.bms.entity.InvoiceRecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 发票表
 *
 * @author ruanteng
 * Date 2021-02-27 00:11:43
 * Copyright (C) hlhs
 */
@Mapper
public interface InvoiceRecordDao extends BaseMapper<InvoiceRecord> {
	
}
