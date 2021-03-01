package com.ruan.hncc.dms.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ruan.hncc.dms.entity.Drug;

import java.util.List;
import java.util.Map;

/**
 * 药品项目表（包括了重要、中成药、草药）
 *
 * @author ruanteng
 * Date 2021-02-27 00:56:42
 * Copyright (C) hlhs
 */
public interface DrugService {

    /**
     * 获取药品项目表
     * @param params
     * @return
     */
    List<Drug> getPageDrug(Map<String, Object> params);

    /**
     * 获取药品项目页
     * @param params
     * @return
     */
    IPage<Drug> getPage(Map<String, Object> params);

    /**
     * 获得药品详细信息
     * @param id
     * @return
     */
    Drug getDrugById(Long id);

    /**
     * 添加药品信息
     * @param drug
     * @return
     */
    Integer createDrug(Drug drug);

    /**
     * 修改信息
     * @param id
     * @param drug
     * @return
     */
    Integer updateDrug(Long id, Drug drug);

    /**
     * 删除信息
     * @param id
     * @return
     */
    Integer deleteDrug(Long[] id);
}

