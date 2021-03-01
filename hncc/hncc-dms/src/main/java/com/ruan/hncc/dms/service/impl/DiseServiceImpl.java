package com.ruan.hncc.dms.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.ruan.hncc.dms.dao.DiseDao;
import com.ruan.hncc.dms.entity.Dise;
import com.ruan.hncc.dms.service.DiseService;

/**
 * 诊断类型（疾病）表
 *
 * @author ruanteng
 * Date 2021-02-27 00:56:42
 * Copyright (C) hlhs
 */
@Service("diseService")
public class DiseServiceImpl extends ServiceImpl<DiseDao, Dise> implements DiseService {

}