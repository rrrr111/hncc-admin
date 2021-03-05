package com.ruan.hncc.dms.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ruan.hncc.common.api.CommonPage;
import com.ruan.hncc.common.api.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import com.ruan.hncc.dms.entity.Drug;
import com.ruan.hncc.dms.service.DrugService;


/**
 * 药品项目表（包括了重要、中成药、草药）
 *
 * @author ruanteng
 * Date 2021-02-27 00:56:42
 * Copyright (C) hlhs
 */
@RestController
@RequestMapping("dms/drug")
public class DrugController {
    @Resource
    private DrugService drugService;

    @GetMapping("/list")
    public CommonResult<CommonPage<Drug>> listPage(@RequestParam Map<String, Object> params) {

        List<Drug> list = drugService.getPageDrug(params);

        IPage<Drug> iPage = drugService.getPage(params);

        iPage.setRecords(list);

        return CommonResult.success(CommonPage.restPage(iPage));

    }




    @PostMapping("/create")
    public CommonResult<Integer> createDrug(@RequestBody Drug drug) {
        Integer count = drugService.createDrug(drug);
        if (0 < count) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @GetMapping("/{id}")
    public CommonResult<Drug> listPage(@PathVariable Long id) {

        Drug drug = drugService.getDrugById(id);

        return CommonResult.success(drug);

    }

    @PutMapping("/update/{id}")
    public CommonResult<Integer> updateDrug(@PathVariable Long id,@RequestBody Drug drug) {
        Integer count = drugService.updateDrug(id,drug);
        if (0 < count) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @DeleteMapping("/delete/{id}")
    public CommonResult<Integer> deleteDrug(@PathVariable Long[]id) {
        Integer count = drugService.deleteDrug(id);
        if (0 < count) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }


}
