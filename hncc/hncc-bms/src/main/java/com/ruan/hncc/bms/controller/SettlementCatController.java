package com.ruan.hncc.bms.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ruan.hncc.bms.entity.SettlementCat;
import com.ruan.hncc.bms.service.SettlementCatService;

import javax.annotation.Resource;


/**
 * j结算类别
 *
 * @author ruanteng
 * Date 2021-02-27 00:11:43
 * Copyright (C) hlhs
 */
@RestController
@RequestMapping("bms/settlementcat")
public class SettlementCatController {
    @Resource
    private SettlementCatService settlementCatService;

}
