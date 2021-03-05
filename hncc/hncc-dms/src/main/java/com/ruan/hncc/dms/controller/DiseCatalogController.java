package com.ruan.hncc.dms.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ruan.hncc.common.api.CommonPage;
import com.ruan.hncc.common.api.CommonResult;
import com.ruan.hncc.dms.entity.Drug;
import com.ruan.hncc.dms.service.DiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import com.ruan.hncc.dms.entity.DiseCatalog;
import com.ruan.hncc.dms.service.DiseCatalogService;



/**
 * 诊断类型（疾病）目录表
 *
 * @author ruanteng
 * Date 2021-02-27 00:56:42
 * Copyright (C) hlhs
 */
@RestController
@RequestMapping("dms/disecatalog")
public class DiseCatalogController {
    @Resource
    private DiseCatalogService diseCatalogService;

    @Resource
    private DiseService diseService;

    @GetMapping("/list")
    public CommonResult<CommonPage<DiseCatalog>> listPage(@RequestParam Map<String, Object> params) {


        IPage<DiseCatalog> iPage = diseCatalogService.getPage(params);


        return CommonResult.success(CommonPage.restPage(iPage));

    }




    @PostMapping("/create")
    public CommonResult<Integer> createDiseCatalog(@RequestBody DiseCatalog diseCatalog) {
        Integer count = diseCatalogService.createDiseCatalog(diseCatalog);
        if (0 < count) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @GetMapping("/{id}")
    public CommonResult<DiseCatalog> getDiseCatalogById(@PathVariable Long id) {

        DiseCatalog diseCatalog = diseCatalogService.getDiseCatalogById(id);

        return CommonResult.success(diseCatalog);

    }

    @PutMapping("/update/{id}")
    public CommonResult<Integer> modifyDiseCatalog(@PathVariable Long id,@RequestBody DiseCatalog diseCatalog) {
        Integer count = diseCatalogService.modifyDiseCatalog(id,diseCatalog);
        if (0 < count) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @DeleteMapping("/delete/{id}")
    public CommonResult<Integer> deleteDrug(@PathVariable Long[]id) {

        Integer count = diseCatalogService.deleteDiseCatalog(id);
        if (0 < count) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

}
