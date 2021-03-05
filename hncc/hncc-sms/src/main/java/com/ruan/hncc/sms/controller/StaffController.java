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
import com.ruan.hncc.sms.entity.Staff;
import com.ruan.hncc.sms.service.StaffService;



/**
 * 员工表
 *
 * @author ruanteng
 * Date 2021-02-27 00:29:54
 * Copyright (C) hlhs
 */
@RestController
@RequestMapping("sms/staff")
public class StaffController {
    @Resource
    private StaffService staffService;


//    /**
//     * 获取需要排班的医生列表
//     * @param params
//     * @return
//     */
//    @GetMapping("/list")
//    public CommonResult<CommonPage<Staff>> listRulePage(@RequestParam Map<String, Object> params){
//
//        IPage iPage = staffService.listStaffPage(params);
//
//        return CommonResult.success(CommonPage.restPage(iPage));
//
//    }
//
//    /**
//     * 列表
//     * @param params
//     * @return
//     */
//    @GetMapping("/list")
//    public CommonResult<CommonPage<Staff>> listPage(@RequestParam Map<String, Object> params){
//
//        IPage iPage = staffService.listStaffPage(params);
//
//        return CommonResult.success(CommonPage.restPage(iPage));
//
//    }
//
//    /**
//     * 获得信息
//     * @param id
//     * @return
//     */
//    @GetMapping("/{id}")
//    public CommonResult<Staff> getRegistrationRankById(@PathVariable Long id){
//
//        Staff staff= staffService.getStaffById(id);
//
//        return CommonResult.success(staff);
//    }
//
//    /**
//     * 添加
//     * @param staff
//     * @return
//     */
//    @PostMapping("/create")
//    public CommonResult<Integer> createRegistrationRank(@RequestBody Staff staff){
//
//        Integer count = staffService.createRStaff(staff);
//
//        if(0<count){
//            return CommonResult.success(count);
//        }
//        return CommonResult.failed();
//    }
//
//    /**
//     * 修改信息
//     * @param id
//     * @param
//     * @return
//     */
//    @PutMapping("/update/{id}")
//    public CommonResult<Integer> updateRegistrationRank(@PathVariable Long id,@RequestBody Staff staff){
//
//        Integer count = staffService.modifyStaff(id,staff);
//
//        if(0<count){
//            return CommonResult.success(count);
//        }
//        return CommonResult.failed();
//    }
//
//    /**
//     * 删除信息
//     * @param id
//     * @return
//     */
//    @DeleteMapping("/delete/{id}")
//    public CommonResult<Integer> deleteRegistrationRank(@PathVariable Long[] id){
//
//        Integer count = staffService.deleteStaff(id);
//
//        if(0<count){
//            return CommonResult.success(count);
//        }
//        return CommonResult.failed();
//    }

}
