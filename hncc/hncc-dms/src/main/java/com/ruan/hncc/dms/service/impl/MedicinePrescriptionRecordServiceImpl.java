package com.ruan.hncc.dms.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.ruan.hncc.dms.dao.MedicinePrescriptionRecordDao;
import com.ruan.hncc.dms.entity.MedicinePrescriptionRecord;
import com.ruan.hncc.dms.service.MedicinePrescriptionRecordService;

/**
 * 成药处方表
 *
 * @author ruanteng
 * Date 2021-02-27 00:23:22
 * Copyright (C) hlhs
 */
@Service("medicinePrescriptionRecordService")
public class MedicinePrescriptionRecordServiceImpl extends ServiceImpl<MedicinePrescriptionRecordDao, MedicinePrescriptionRecord> implements MedicinePrescriptionRecordService {

}