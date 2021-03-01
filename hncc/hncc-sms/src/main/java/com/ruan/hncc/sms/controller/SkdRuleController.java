package com.ruan.hncc.sms.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ruan.hncc.common.api.CommonPage;
import com.ruan.hncc.common.api.CommonResult;
import com.ruan.hncc.sms.entity.RegistrationRank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import com.ruan.hncc.sms.entity.SkdRule;
import com.ruan.hncc.sms.service.SkdRuleService;



/**
 * 排班规则表
 *
 * @author ruanteng
 * Date 2021-02-27 00:29:54
 * Copyright (C) hlhs
 */
@RestController
@RequestMapping("sms/skdrule")
public class SkdRuleController {
    @Resource
    private SkdRuleService skdRuleService;

    /**
     * 排班规则列表
     * @param params
     * @return
     */
    @GetMapping("/list")
    public CommonResult<CommonPage<SkdRule>> listPage(@RequestParam Map<String, Object> params){
       List list= skdRuleService.listSkdRulePage(params);
        IPage iPage = skdRuleService.getPage(params);
        iPage.setRecords(list);
        return CommonResult.success(CommonPage.restPage(iPage));

    }

    /**
     * 获得排班规则信息
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public CommonResult<SkdRule> getSkdRuleById(@PathVariable Long id){

        SkdRule skdRule= skdRuleService.getRegistrationRankById(id);

        return CommonResult.success(skdRule);
    }

    /**
     * 添加排班规则信息
     * @param skdRule
     * @return
     */
    @PostMapping("/create")
    public CommonResult<Integer> createSkdRule( SkdRule skdRule){

        Integer count = skdRuleService.createSkdRule(skdRule);

        if(0<count){
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    /**
     * 修改排班规则信息
     * @param id
     * @param skdRule
     * @return
     */
    @PutMapping("/update/{id}")
    public CommonResult<Integer> updateSkdRule(@PathVariable Long id, SkdRule skdRule){

        Integer count = skdRuleService.modifySkdRule(id,skdRule);

        if(0<count){
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    /**
     * 删除排班规则信息
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public CommonResult<Integer> deleteSkdRule(@PathVariable Long[] id){

        Integer count = skdRuleService.deleteSkdRule(id);

        if(0<count){
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

}
