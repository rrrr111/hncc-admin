package com.ruan.hncc.sms.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.ruan.hncc.sms.dao.PermissionDao;
import com.ruan.hncc.sms.entity.Permission;
import com.ruan.hncc.sms.service.PermissionService;

/**
 * 操作权限表
 *
 * @author ruanteng
 * Date 2021-02-27 00:29:54
 * Copyright (C) hlhs
 */
@Service("permissionService")
public class PermissionServiceImpl extends ServiceImpl<PermissionDao, Permission> implements PermissionService {

}