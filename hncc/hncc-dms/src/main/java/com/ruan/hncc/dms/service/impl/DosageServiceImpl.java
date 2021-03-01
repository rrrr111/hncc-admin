package com.ruan.hncc.dms.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.ruan.hncc.dms.dao.DosageDao;
import com.ruan.hncc.dms.entity.Dosage;
import com.ruan.hncc.dms.service.DosageService;

/**
 * 药品剂型表
 *
 * @author ruanteng
 * Date 2021-02-27 00:56:42
 * Copyright (C) hlhs
 */
@Service("dosageService")
public class DosageServiceImpl extends ServiceImpl<DosageDao, Dosage> implements DosageService {

}