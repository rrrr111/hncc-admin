package com.ruan.hncc.sms.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ruan.hncc.common.api.CommonPage;
import com.ruan.hncc.common.api.CommonResult;
import com.ruan.hncc.sms.dto.SkdRuleItemDto;
import com.ruan.hncc.sms.entity.RegistrationRank;
import com.ruan.hncc.sms.entity.SkdRuleItem;
import com.ruan.hncc.sms.service.SkdRuleItemService;
import com.ruan.hncc.sms.vo.SkdRuleDaysOfWeekVo;
import com.ruan.hncc.sms.vo.SkdRuleVo;
import org.springframework.beans.BeanUtils;
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

    @Resource
    private SkdRuleItemService skdRuleItemService;

    /**
     * 排班规则列表
     *
     * @param params
     * @return
     */
    @GetMapping("/list")
    public CommonResult<CommonPage<SkdRule>> listPage(@RequestParam Map<String, Object> params) {
        List list = skdRuleService.listSkdRulePage(params);
        IPage iPage = skdRuleService.getPage(params);
        iPage.setRecords(list);
        return CommonResult.success(CommonPage.restPage(iPage));

    }

    /**
     * 获得排班规则信息
     *
     * @param
     * @return
     */
    @GetMapping("/getById")
    public CommonResult<SkdRuleVo> getSkdRuleById(@RequestParam Map<String, Object> params) {

        SkdRuleVo skdRuleVo = new SkdRuleVo();

        SkdRule skdRule = skdRuleService.getRegistrationRankById(Long.parseLong((String)params.get("id")));

        skdRuleVo.setSkdRule(skdRule);

        List<SkdRuleItem> list = skdRuleItemService.getList(params);
        List<SkdRuleDaysOfWeekVo> collect = null;
        if(list!=null && !list.isEmpty()){
          collect = list.stream().map(item -> {
                SkdRuleDaysOfWeekVo vo = new SkdRuleDaysOfWeekVo();
                BeanUtils.copyProperties(item, vo);
                String[] split = item.getDaysOfWeek().split(",");
                vo.setOneUp(split[0]);
                vo.setOneDown(split[1]);
                vo.setTwoUp(split[2]);
                vo.setTwoDown(split[3]);
                vo.setThreeUp(split[4]);
                vo.setThreeDown(split[5]);
                vo.setFourUp(split[6]);
                vo.setFourDown(split[7]);
                vo.setFiveUp(split[8]);
                vo.setFiveDown(split[9]);
                vo.setSixUp(split[10]);
                vo.setSixDown(split[11]);
                vo.setSevenUp(split[12]);
                vo.setSevenDown(split[13]);

                return vo;
            }).collect(Collectors.toList());
        }


        IPage<SkdRuleItem> listBySkdRuleId = skdRuleItemService.getListBySkdRuleId(params);
        listBySkdRuleId.setRecords(list);
        skdRuleVo.setIPage(CommonPage.restPage(listBySkdRuleId));
        skdRuleVo.setVos(collect);
        return CommonResult.success(skdRuleVo);
    }

    /**
     * 添加排班规则信息
     *
     * @param skdRuleItemDto
     * @return
     */
    @PostMapping("/create")
    public CommonResult<Integer> createSkdRule(@RequestBody SkdRuleItemDto[] skdRuleItemDto) {

        Integer count = skdRuleService.createSkdRuleAndRuleItem(skdRuleItemDto);

        if (0 < count) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    /**
     * 修改排班规则信息
     *
     * @param id
     * @param skdRuleItemDto
     * @return
     */
    @PutMapping("/update/{id}")
    public CommonResult<Integer> updateSkdRule(@PathVariable Long id, @RequestBody SkdRuleItemDto[] skdRuleItemDto) {

        Integer count = skdRuleService.modifySkdRuleAndRuleItem(id, skdRuleItemDto);
        if (0 < count) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    /**
     * 删除排班规则信息
     *
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public CommonResult<Integer> deleteSkdRule(@PathVariable Long[] id) {

        Integer count = skdRuleService.deleteSkdRule(id);

        if (0 < count) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

}
