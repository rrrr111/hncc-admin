package com.ruan.hncc.bms.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.ruan.hncc.bms.dao.BillsRecordDao;
import com.ruan.hncc.bms.entity.BillsRecord;
import com.ruan.hncc.bms.service.BillsRecordService;

/**
 * 医院账单流水表
 *
 * @author ruanteng
 * Date 2021-02-27 00:11:43
 * Copyright (C) hlhs
 */
@Service("billsRecordService")
public class BillsRecordServiceImpl extends ServiceImpl<BillsRecordDao, BillsRecord> implements BillsRecordService {

}