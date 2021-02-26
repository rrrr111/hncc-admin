package com.ruan.hncc.bms.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.ruan.hncc.bms.dao.InvoiceExpDao;
import com.ruan.hncc.bms.entity.InvoiceExp;
import com.ruan.hncc.bms.service.InvoiceExpService;

/**
 * 费用科目表
 *
 * @author ruanteng
 * Date 2021-02-27 00:11:43
 * Copyright (C) hlhs
 */
@Service("invoiceExpService")
public class InvoiceExpServiceImpl extends ServiceImpl<InvoiceExpDao, InvoiceExp> implements InvoiceExpService {

}