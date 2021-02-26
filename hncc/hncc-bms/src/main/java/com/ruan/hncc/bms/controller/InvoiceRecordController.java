package com.ruan.hncc.bms.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ruan.hncc.bms.entity.InvoiceRecord;
import com.ruan.hncc.bms.service.InvoiceRecordService;

import javax.annotation.Resource;


/**
 * 发票表
 *
 * @author ruanteng
 * Date 2021-02-27 00:11:43
 * Copyright (C) hlhs
 */
@RestController
@RequestMapping("bms/invoicerecord")
public class InvoiceRecordController {
    @Resource
    private InvoiceRecordService invoiceRecordService;

}
