package com.ruan.hncc.sms.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ruan.hncc.sms.dto.SkdDto;
import com.ruan.hncc.sms.entity.Skd;
import com.ruan.hncc.sms.vo.SkdVo;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

/**
 * 排班时间表
 *
 * @author ruanteng
 * Date 2021-02-27 00:29:54
 * Copyright (C) hlhs
 */
public interface SkdService {

    /**
     * 排班列表
     * @param params
     * @return
     */
    List<SkdVo> listSkdPage(Map<String, Object> params);

    /**
     * 排班列表分页
     * @param params
     * @return
     */
    IPage getPage(Map<String, Object> params);

    /**
     * 获得详细排班信息
     * @param id
     * @return
     */
    Skd getRegistrationRankById(Long id);

    /**
     * 创建排班信息
     * @param skd
     * @return
     */
    Integer createSkd(Skd skd);

    /**
     * 修改排班信息
     * @param id
     * @param skd
     * @return
     */
    Integer modifySkd(Long id, Skd skd);

    /**
     * 删除排班信息
     * @param id
     * @return
     */
    Integer deleteSkd(Long[] id);

    /**
     * 生成排班计划
     * @param skdDto
     * @return
     */
    Integer generatePlan(SkdDto skdDto) throws ParseException;
}

