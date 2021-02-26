package com.ruan.hncc.dms.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.ruan.hncc.dms.dao.MedicineItemRecordDao;
import com.ruan.hncc.dms.entity.MedicineItemRecord;
import com.ruan.hncc.dms.service.MedicineItemRecordService;

/**
 * 成药项记录表
 *
 * @author ruanteng
 * Date 2021-02-27 00:23:22
 * Copyright (C) hlhs
 */
@Service("medicineItemRecordService")
public class MedicineItemRecordServiceImpl extends ServiceImpl<MedicineItemRecordDao, MedicineItemRecord> implements MedicineItemRecordService {

}