package com.ruan.hncc.sms.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.ruan.hncc.sms.dao.DescriptionDao;
import com.ruan.hncc.sms.entity.Description;
import com.ruan.hncc.sms.service.DescriptionService;

/**
 * 科室、员工描述表
 *
 * @author ruanteng
 * Date 2021-02-27 00:29:54
 * Copyright (C) hlhs
 */
@Service("descriptionService")
public class DescriptionServiceImpl extends ServiceImpl<DescriptionDao, Description> implements DescriptionService {

}