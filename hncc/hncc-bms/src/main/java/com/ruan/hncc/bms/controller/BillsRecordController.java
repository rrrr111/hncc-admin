package com.ruan.hncc.bms.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ruan.hncc.bms.entity.BillsRecord;
import com.ruan.hncc.bms.service.BillsRecordService;

import javax.annotation.Resource;


/**
 * 医院账单流水表
 *
 * @author ruanteng
 * Date 2021-02-27 00:11:43
 * Copyright (C) hlhs
 */
@RestController
@RequestMapping("bms/billsrecord")
public class BillsRecordController {
    @Resource
    private BillsRecordService billsRecordService;

}
