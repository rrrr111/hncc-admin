package com.ruan.hncc.dms.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


import com.ruan.hncc.common.api.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import com.ruan.hncc.dms.entity.Dosage;
import com.ruan.hncc.dms.service.DosageService;



/**
 * 药品剂型表
 *
 * @author ruanteng
 * Date 2021-02-27 00:56:42
 * Copyright (C) hlhs
 */
@RestController
@RequestMapping("dms/dosage")
public class DosageController {
    @Resource
    private DosageService dosageService;

    @GetMapping("listAll")
    public CommonResult<List<Dosage>> listAll(){
        return CommonResult.success(dosageService.listAll());
    }

}
