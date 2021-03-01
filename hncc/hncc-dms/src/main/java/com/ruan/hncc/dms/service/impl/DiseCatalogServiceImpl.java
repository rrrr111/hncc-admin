package com.ruan.hncc.dms.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.ruan.hncc.dms.dao.DiseCatalogDao;
import com.ruan.hncc.dms.entity.DiseCatalog;
import com.ruan.hncc.dms.service.DiseCatalogService;

/**
 * 诊断类型（疾病）目录表
 *
 * @author ruanteng
 * Date 2021-02-27 00:56:42
 * Copyright (C) hlhs
 */
@Service("diseCatalogService")
public class DiseCatalogServiceImpl extends ServiceImpl<DiseCatalogDao, DiseCatalog> implements DiseCatalogService {

}