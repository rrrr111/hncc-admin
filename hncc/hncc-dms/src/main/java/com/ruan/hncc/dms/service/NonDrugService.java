package com.ruan.hncc.dms.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ruan.hncc.dms.entity.NonDrug;

import java.util.List;
import java.util.Map;

/**
 * 非药品收费项目表
 *
 * @author ruanteng
 * Date 2021-02-27 00:23:22
 * Copyright (C) hlhs
 */
public interface NonDrugService {

    /**
     * 获取非处方药项目列表
     * @param code
     * @param name
     * @param mCode
     * @param rType
     * @param dept
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<NonDrug> list(String code,String name,String mCode,String rType,String dept,Integer pageNum,Integer pageSize);

    /**
     * 分页获取非处方药项目列表
     * @param params
     * @return
     */
    IPage<NonDrug> getPage(Map<String, Object> params);

}

