package com.ruan.hncc.dms.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import com.ruan.hncc.dms.entity.DiseCatalog;
import com.ruan.hncc.dms.service.DiseCatalogService;



/**
 * 诊断类型（疾病）目录表
 *
 * @author ruanteng
 * Date 2021-02-27 00:56:42
 * Copyright (C) hlhs
 */
@RestController
@RequestMapping("dms/disecatalog")
public class DiseCatalogController {
    @Resource
    private DiseCatalogService diseCatalogService;

}
