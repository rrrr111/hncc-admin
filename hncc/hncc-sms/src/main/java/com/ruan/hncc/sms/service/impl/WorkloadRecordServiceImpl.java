package com.ruan.hncc.sms.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.ruan.hncc.sms.dao.WorkloadRecordDao;
import com.ruan.hncc.sms.entity.WorkloadRecord;
import com.ruan.hncc.sms.service.WorkloadRecordService;

/**
 * 门诊医生、科室工作量统计表
 *
 * @author ruanteng
 * Date 2021-02-27 00:29:54
 * Copyright (C) hlhs
 */
@Service("workloadRecordService")
public class WorkloadRecordServiceImpl extends ServiceImpl<WorkloadRecordDao, WorkloadRecord> implements WorkloadRecordService {

}