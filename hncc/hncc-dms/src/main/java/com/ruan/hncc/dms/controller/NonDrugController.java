package com.ruan.hncc.dms.controller;

import java.util.*;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ruan.hncc.common.api.CommonPage;
import com.ruan.hncc.common.api.CommonResult;
import com.ruan.hncc.dms.entity.Drug;
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

    @PostMapping("/create")
    public CommonResult<Integer> createNonDrug(@RequestBody NonDrug nonDrug){

//        处置以120开头+1位类型号+5位顺序号；例如120100001,120100002,12020003
//        检验以210开头+1位类型号+5位顺序号；例如 210100001
//        检查以240开头+1位类型号+5位顺序号；例如
        if(nonDrug.getRecordType()==1){
            nonDrug.setCode("1201"+ UUID.randomUUID().toString().substring(0,5));
        }

        if(nonDrug.getRecordType()==2){
            nonDrug.setCode("21001"+ UUID.randomUUID().toString().substring(0,5));
        }

        if(nonDrug.getRecordType()==3){
            nonDrug.setCode("2401"+ UUID.randomUUID().toString().substring(0,5));
        }

        nonDrug.setCreateDate(new Date());

        Integer count = nonDrugService.createNonDrug(nonDrug);

        if(count>0){
            return   CommonResult.success(count);
        }
        return CommonResult.failed();

    }

    @GetMapping("/{id}")
    public CommonResult<NonDrug> listPage(@PathVariable Long id) {

        NonDrug nonDrug = nonDrugService.getNonDrugById(id);

        return CommonResult.success(nonDrug);

    }

    @PutMapping("/update/{id}")
    public CommonResult<Integer> updateDrug(@PathVariable Long id,@RequestBody NonDrug drug) {
        Integer count = nonDrugService.updateNonDrug(id,drug);
        if (0 < count) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @DeleteMapping("/delete/{id}")
    public CommonResult<Integer> deleteDrug(@PathVariable Long[]id) {
        Integer count = nonDrugService.deleteNonDrug(id);
        if (0 < count) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }


}
