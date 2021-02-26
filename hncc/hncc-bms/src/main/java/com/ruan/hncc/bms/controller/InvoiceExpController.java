package com.ruan.hncc.bms.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ruan.hncc.bms.entity.InvoiceExp;
import com.ruan.hncc.bms.service.InvoiceExpService;

import javax.annotation.Resource;


/**
 * 费用科目表
 *
 * @author ruanteng
 * Date 2021-02-27 00:11:43
 * Copyright (C) hlhs
 */
@RestController
@RequestMapping("bms/invoiceexp")
public class InvoiceExpController {
    @Resource
    private InvoiceExpService invoiceExpService;

}
