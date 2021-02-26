package com.ruan.hncc.sms.dao;

import com.ruan.hncc.sms.entity.WorkloadRecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 门诊医生、科室工作量统计表
 *
 * @author ruanteng
 * Date 2021-02-27 00:29:54
 * Copyright (C) hlhs
 */
@Mapper
public interface WorkloadRecordDao extends BaseMapper<WorkloadRecord> {
	
}
