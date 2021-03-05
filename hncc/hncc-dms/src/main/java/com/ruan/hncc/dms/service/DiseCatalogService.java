package com.ruan.hncc.dms.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ruan.hncc.dms.entity.DiseCatalog;

import java.util.Map;

/**
 * 诊断类型（疾病）目录表
 *
 * @author ruanteng
 * Date 2021-02-27 00:56:42
 * Copyright (C) hlhs
 */
public interface DiseCatalogService {

    IPage<DiseCatalog> getPage(Map<String, Object> params);

    Integer createDiseCatalog(DiseCatalog diseCatalog);

    DiseCatalog getDiseCatalogById(Long id);

    Integer modifyDiseCatalog(Long id, DiseCatalog diseCatalog);

    Integer deleteDiseCatalog(Long[] id);
}

