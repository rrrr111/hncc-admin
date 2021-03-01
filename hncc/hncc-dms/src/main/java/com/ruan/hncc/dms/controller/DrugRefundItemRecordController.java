package com.ruan.hncc.dms.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import com.ruan.hncc.dms.entity.DrugRefundItemRecord;
import com.ruan.hncc.dms.service.DrugRefundItemRecordService;



/**
 * 退药项记录表
 *
 * @author ruanteng
 * Date 2021-02-27 00:56:42
 * Copyright (C) hlhs
 */
@RestController
@RequestMapping("dms/drugrefunditemrecord")
public class DrugRefundItemRecordController {
    @Resource
    private DrugRefundItemRecordService drugRefundItemRecordService;

}
