package com.ruan.hncc.bms.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ruan.hncc.bms.entity.OperatorSettleRecord;
import com.ruan.hncc.bms.service.OperatorSettleRecordService;

import javax.annotation.Resource;


/**
 * 收费员日结表
 *
 * @author ruanteng
 * Date 2021-02-27 00:11:43
 * Copyright (C) hlhs
 */
@RestController
@RequestMapping("bms/operatorsettlerecord")
public class OperatorSettleRecordController {
    @Resource
    private OperatorSettleRecordService operatorSettleRecordService;

}
