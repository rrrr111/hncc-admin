package com.ruan.hncc.dms.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ruan.hncc.common.api.CommonPage;
import com.ruan.hncc.common.api.CommonResult;
import com.ruan.hncc.dms.entity.Dise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import com.ruan.hncc.dms.entity.Registration;
import com.ruan.hncc.dms.service.RegistrationService;



/**
 * 就诊(门诊)信息表（一个病人一个病历号，多次就诊，多次就诊信息），也可以看作医院的挂号表
挂了号相当于开了一
 *
 * @author ruanteng
 * Date 2021-02-27 00:23:22
 * Copyright (C) hlhs
 */
@RestController
@RequestMapping("dms/registration")
public class RegistrationController {
    @Resource
    private RegistrationService registrationService;

    @GetMapping("/list")
    public CommonResult<CommonPage<Registration>> listPage(@RequestParam Map<String, Object> params) {

        List<Registration> list = registrationService.getListPage(params);

        IPage<Registration> iPage = registrationService.getPage(params);
        iPage.setRecords(list);

        return CommonResult.success(CommonPage.restPage(iPage));

    }




    @PostMapping("/create")
    public CommonResult<Integer> createRegistration(@RequestBody Registration registration) {
        Integer count = registrationService.createRegistration(registration);
        if (0 < count) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @GetMapping("/{id}")
    public CommonResult<Registration> getRegistrationById(@PathVariable Long id) {

        Registration registration = registrationService.getRegistrationById(id);

        return CommonResult.success(registration);

    }

    @PutMapping("/update/{id}")
    public CommonResult<Integer> modifyDiseCatalog(@PathVariable Long id, @RequestBody Registration registration) {
        Integer count = registrationService.modifyRegistration(id,registration);
        if (0 < count) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @DeleteMapping("/delete/{id}")
    public CommonResult<Integer> deleteDrug(@PathVariable Long[]id) {
        Integer count = registrationService.deleteRegistration(id);
        if (0 < count) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

}
