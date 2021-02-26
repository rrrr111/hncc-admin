package com.ruan.hncc.dms.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.ruan.hncc.dms.dao.NonDrugItemRecordDao;
import com.ruan.hncc.dms.entity.NonDrugItemRecord;
import com.ruan.hncc.dms.service.NonDrugItemRecordService;

/**
 * 检查项检验项处置项记录表(开立的)
 *
 * @author ruanteng
 * Date 2021-02-27 00:23:22
 * Copyright (C) hlhs
 */
@Service("nonDrugItemRecordService")
public class NonDrugItemRecordServiceImpl extends ServiceImpl<NonDrugItemRecordDao, NonDrugItemRecord> implements NonDrugItemRecordService {

}