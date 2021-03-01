package com.ruan.hncc.dms.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.ruan.hncc.dms.dao.DrugModelDao;
import com.ruan.hncc.dms.entity.DrugModel;
import com.ruan.hncc.dms.service.DrugModelService;

/**
 * 药品模版表
 *
 * @author ruanteng
 * Date 2021-02-27 00:56:42
 * Copyright (C) hlhs
 */
@Service("drugModelService")
public class DrugModelServiceImpl extends ServiceImpl<DrugModelDao, DrugModel> implements DrugModelService {

}