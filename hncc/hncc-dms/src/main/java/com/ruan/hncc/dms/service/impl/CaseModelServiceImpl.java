package com.ruan.hncc.dms.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.ruan.hncc.dms.dao.CaseModelDao;
import com.ruan.hncc.dms.entity.CaseModel;
import com.ruan.hncc.dms.service.CaseModelService;

/**
 * 病例模版表
 *
 * @author ruanteng
 * Date 2021-02-27 00:56:42
 * Copyright (C) hlhs
 */
@Service("caseModelService")
public class CaseModelServiceImpl extends ServiceImpl<CaseModelDao, CaseModel> implements CaseModelService {

}