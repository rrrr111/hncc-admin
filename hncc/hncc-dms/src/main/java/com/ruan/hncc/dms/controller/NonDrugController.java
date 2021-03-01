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
import com.ruan.hncc.dms.entity.NonDrug;
import com.ruan.hncc.dms.service.NonDrugService;



/**
 * 非药品收费项目表
 *
 * @author ruanteng
 * Date 2021-02-27 00:23:22
 * Copyright (C) hlhs
 */
@RestController
@RequestMapping("dms/nondrug")
public class NonDrugController {
    @Resource
    private NonDrugService nonDrugService;

    /**
     * 获取非药品管理列表
     * @param params
     * @return
     */
    @GetMapping("list")
    public CommonResult<CommonPage<NonDrug>> list(@RequestParam Map<String, Object> params) {

        String code = (String) params.get("code");

        String name = (String) params.get("name");

        String mCode = (String) params.get("mCode");

        String rType = (String) params.get("rType");

        String dept = (String)params.get("deptId");

        Integer pageNum = Integer.parseInt(String.valueOf(params.get("pageNum")));

        Integer pageSize = Integer.parseInt(String.valueOf( params.get("pageSize")));

        List<NonDrug> bClassList=nonDrugService.list(code,name,mCode,rType,dept,pageNum,pageSize);

        IPage<NonDrug> page = nonDrugService.getPage(params);

        page.setRecords(bClassList);

        return CommonResult.success(CommonPage.restPage(page));

    }

}
