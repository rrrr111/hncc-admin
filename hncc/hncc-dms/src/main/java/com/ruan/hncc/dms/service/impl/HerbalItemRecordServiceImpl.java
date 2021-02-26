package com.ruan.hncc.dms.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.ruan.hncc.dms.dao.HerbalItemRecordDao;
import com.ruan.hncc.dms.entity.HerbalItemRecord;
import com.ruan.hncc.dms.service.HerbalItemRecordService;

/**
 * 草药项记录表
 *
 * @author ruanteng
 * Date 2021-02-27 00:23:22
 * Copyright (C) hlhs
 */
@Service("herbalItemRecordService")
public class HerbalItemRecordServiceImpl extends ServiceImpl<HerbalItemRecordDao, HerbalItemRecord> implements HerbalItemRecordService {

}