package com.ruan.hncc.dms.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.ruan.hncc.dms.dao.NonDrugDao;
import com.ruan.hncc.dms.entity.NonDrug;
import com.ruan.hncc.dms.service.NonDrugService;

/**
 * 非药品收费项目表
 *
 * @author ruanteng
 * Date 2021-02-27 00:23:22
 * Copyright (C) hlhs
 */
@Service("nonDrugService")
public class NonDrugServiceImpl extends ServiceImpl<NonDrugDao, NonDrug> implements NonDrugService {

}