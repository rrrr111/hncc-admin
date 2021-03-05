package com.ruan.hncc.sms.controller;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ruan.hncc.common.api.CommonPage;
import com.ruan.hncc.common.api.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import com.ruan.hncc.sms.entity.RegistrationRank;
import com.ruan.hncc.sms.service.RegistrationRankService;



/**
 * 挂号级别表
 *
 * @author ruanteng
 * Date 2021-02-27 00:29:54
 * Copyright (C) hlhs
 */
@RestController
@RequestMapping("/sms/registrationrank")
public class RegistrationRankController {
    @Resource
    private RegistrationRankService registrationRankService;

    /**
     * 挂号级别列表
     * @param
     * @return
     */
    @GetMapping("/listAll")
    public CommonResult<List<RegistrationRank>> listAll(){

        List<RegistrationRank> listAll= registrationRankService.listAll();

        return CommonResult.success(listAll);

    }


    /**
     * 挂号级别列表
     * @param params
     * @return
     */
    @GetMapping("/list")
    public CommonResult<CommonPage<RegistrationRank>> listPage(@RequestParam Map<String, Object> params){

        IPage iPage = registrationRankService.listRegistrationRankPage(params);

        return CommonResult.success(CommonPage.restPage(iPage));

    }

    /**
     * 获得详细级别信息
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public CommonResult<RegistrationRank> getRegistrationRankById(@PathVariable Long id){

       RegistrationRank registrationRank= registrationRankService.getRegistrationRankById(id);

        return CommonResult.success(registrationRank);
    }

    /**
     * 添加挂号级别信息
     * @param registrationRank
     * @return
     */
    @PostMapping("/create")
    public CommonResult<Integer> createRegistrationRank(@RequestBody RegistrationRank registrationRank){

        Integer count = registrationRankService.createRegistrationRank(registrationRank);

        if(0<count){
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    /**
     * 修改挂号级别信息
     * @param id
     * @param registrationRank
     * @return
     */
    @PutMapping("/update/{id}")
    public CommonResult<Integer> updateRegistrationRank(@PathVariable Long id,@RequestBody RegistrationRank registrationRank){

        Integer count = registrationRankService.modifyRegistrationRank(id,registrationRank);

        if(0<count){
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    /**
     * 删除挂号级别信息
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public CommonResult<Integer> deleteRegistrationRank(@PathVariable Long[] id){

        Integer count = registrationRankService.deleteRegistrationRank(id);

        if(0<count){
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }
}
