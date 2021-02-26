package com.ruan.hncc.sms.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.ruan.hncc.sms.dao.DeptDao;
import com.ruan.hncc.sms.entity.Dept;
import com.ruan.hncc.sms.service.DeptService;

/**
 * 科室表(done)
 *
 * @author ruanteng
 * Date 2021-02-27 00:29:54
 * Copyright (C) hlhs
 */
@Service("deptService")
public class DeptServiceImpl extends ServiceImpl<DeptDao, Dept> implements DeptService {

}