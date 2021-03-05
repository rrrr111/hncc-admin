package com.ruan.hncc.dms.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ruan.hncc.dms.entity.Dise;

import java.util.Map;

/**
 * 诊断类型（疾病）表
 *
 * @author ruanteng
 * Date 2021-02-27 00:56:42
 * Copyright (C) hlhs
 */
public interface DiseService {

    IPage<Dise> getPage(Map<String, Object> params);

    Integer createDise(Dise dise);

    Dise getDiseById(Long id);

    Integer modifyDise(Long id, Dise dise);

    Integer deleteDise(Long[] id);

    void deleteDiseByDiseCatalog(Long aLong);
}

