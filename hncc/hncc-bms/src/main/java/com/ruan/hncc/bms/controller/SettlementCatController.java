package com.ruan.hncc.bms.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ruan.hncc.common.api.CommonPage;
import com.ruan.hncc.common.api.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ruan.hncc.bms.entity.SettlementCat;
import com.ruan.hncc.bms.service.SettlementCatService;

import javax.annotation.Resource;
import javax.ws.rs.DELETE;


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


    /**
     * 获取结算列表
     * @param
     * @return
     */
    @GetMapping("/listAll")
    public CommonResult<List<SettlementCat>> listAll(){

        List<SettlementCat> settlementCats = settlementCatService.listAll();

        return CommonResult.success(settlementCats);

    }


    /**
     * 获取结算列表
     * @param params
     * @return
     */
    @GetMapping("/list")
    public CommonResult<CommonPage<SettlementCat>> listPage(@RequestParam Map<String, Object> params){

       IPage iPage  = settlementCatService.listPage(params);

        return CommonResult.success(CommonPage.restPage(iPage));

    }

    /**
     * 获取结算详细信息
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public CommonResult<SettlementCat> listPage(@PathVariable Long id) {

        SettlementCat settlementCat = settlementCatService.getSettlementCatById(id);

        return CommonResult.success(settlementCat);

    }

    /**
     * 创建结算信息
     * @param drug
     * @return
     */
    @PostMapping("/create")
    public CommonResult<Integer> createSettlementCat(@RequestBody SettlementCat drug) {
        Integer count = settlementCatService.createSettlementCat(drug);
        if (0 < count) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    /**
     * 修改详细信息
     * @param id
     * @param drug
     * @return
     */
    @PutMapping("/update/{id}")
    public CommonResult<Integer> updateDrug(@PathVariable Long id,@RequestBody SettlementCat drug) {
        Integer count = settlementCatService.updateSettlementCat(id,drug);
        if (0 < count) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    /**
     * 删除详细信息
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public CommonResult<Integer> deleteDrug(@PathVariable Long[]id) {
        Integer count = settlementCatService.deleteSettlementCat(id);
        if (0 < count) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }


}
