package com.ruan.hncc.dms.service.impl;

import com.ruan.hncc.common.api.CommonPage;
import com.ruan.hncc.common.api.CommonResult;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.ruan.hncc.dms.dao.CaseHistoryDao;
import com.ruan.hncc.dms.entity.CaseHistory;
import com.ruan.hncc.dms.service.CaseHistoryService;

/**
 * 病历表
 *
 * @author ruanteng
 * Date 2021-02-27 00:56:42
 * Copyright (C) hlhs
 */
@Service("caseHistoryService")
public class CaseHistoryServiceImpl extends ServiceImpl<CaseHistoryDao, CaseHistory> implements CaseHistoryService {
}