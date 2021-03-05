package com.ruan.hncc.dms.controller;

import java.util.Arrays;
import java.util.Map;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ruan.hncc.common.api.CommonPage;
import com.ruan.hncc.common.api.CommonResult;
import com.ruan.hncc.dms.entity.DiseCatalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import com.ruan.hncc.dms.entity.Dise;
import com.ruan.hncc.dms.service.DiseService;



/**
 * 诊断类型（疾病）表
 *
 * @author ruanteng
 * Date 2021-02-27 00:56:42
 * Copyright (C) hlhs
 */
@RestController
@RequestMapping("dms/dise")
public class DiseController {
    @Resource
    private DiseService diseService;


    @GetMapping("/list")
    public CommonResult<CommonPage<Dise>> listPage(@RequestParam Map<String, Object> params) {


        IPage<Dise> iPage = diseService.getPage(params);


        return CommonResult.success(CommonPage.restPage(iPage));

    }




    @PostMapping("/create")
    public CommonResult<Integer> createDiseCatalog(@RequestBody Dise dise) {
        Integer count = diseService.createDise(dise);
        if (0 < count) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @GetMapping("/{id}")
    public CommonResult<Dise> getDiseCatalogById(@PathVariable Long id) {

        Dise dise = diseService.getDiseById(id);

        return CommonResult.success(dise);

    }

    @PutMapping("/update/{id}")
    public CommonResult<Integer> modifyDiseCatalog(@PathVariable Long id, @RequestBody Dise dise) {
        Integer count = diseService.modifyDise(id,dise);
        if (0 < count) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @DeleteMapping("/delete/{id}")
    public CommonResult<Integer> deleteDrug(@PathVariable Long[]id) {
        Integer count = diseService.deleteDise(id);
        if (0 < count) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }



}
