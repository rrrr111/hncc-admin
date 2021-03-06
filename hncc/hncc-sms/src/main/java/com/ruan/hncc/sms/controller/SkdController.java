package com.ruan.hncc.sms.controller;

import java.util.List;
import java.util.Map;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ruan.hncc.common.api.CommonPage;
import com.ruan.hncc.common.api.CommonResult;
import com.ruan.hncc.sms.entity.Skd;
import com.ruan.hncc.sms.vo.SkdVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import com.ruan.hncc.sms.service.SkdService;



/**
 * 排班时间表
 *
 * @author ruanteng
 * Date 2021-02-27 00:29:54
 * Copyright (C) hlhs
 */
@RestController
@RequestMapping("sms/skd")
public class SkdController {
    @Resource
    private SkdService skdService;

    /**
     * 列表
     * @param params
     * @return
     */
    @GetMapping("/list")
    public CommonResult<CommonPage<IPage>> listPage(@RequestParam Map<String, Object> params){
        List<SkdVo> list= skdService.listSkdPage(params);
        IPage iPage = skdService.getPage(params);
        iPage.setTotal(iPage.getRecords().size());
        iPage.setRecords(list);
        return CommonResult.success(CommonPage.restPage(iPage));

    }

    /**
     * 获得排班规则信息
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public CommonResult<Skd> getSkdById(@PathVariable Long id){

        Skd skd= skdService.getRegistrationRankById(id);

        return CommonResult.success(skd);
    }

    /**
     * 添加排班规则信息
     * @param skd
     * @return
     */
    @PostMapping("/create")
    public CommonResult<Integer> createSkd( Skd skd){

        Integer count = skdService.createSkd(skd);

        if(0<count){
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    /**
     * 修改排班规则信息
     * @param id
     * @param skd
     * @return
     */
    @PutMapping("/update/{id}")
    public CommonResult<Integer> updateSkd(@PathVariable Long id, Skd skd){

        Integer count = skdService.modifySkd(id,skd);

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
    public CommonResult<Integer> deleteSkd(@PathVariable Long[] id){

        Integer count = skdService.deleteSkd(id);

        if(0<count){
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

}
