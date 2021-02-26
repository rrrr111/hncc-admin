package com.ruan.hncc.bms.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.ruan.hncc.bms.dao.InvoiceRecordDao;
import com.ruan.hncc.bms.entity.InvoiceRecord;
import com.ruan.hncc.bms.service.InvoiceRecordService;

/**
 * 发票表
 *
 * @author ruanteng
 * Date 2021-02-27 00:11:43
 * Copyright (C) hlhs
 */
@Service("invoiceRecordService")
public class InvoiceRecordServiceImpl extends ServiceImpl<InvoiceRecordDao, InvoiceRecord> implements InvoiceRecordService {

}