package com.ruan.hncc.sms.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.ruan.hncc.sms.dao.RolePermissionRelationDao;
import com.ruan.hncc.sms.entity.RolePermissionRelation;
import com.ruan.hncc.sms.service.RolePermissionRelationService;

/**
 * 员工角色与权限关系表
 *
 * @author ruanteng
 * Date 2021-02-27 00:29:54
 * Copyright (C) hlhs
 */
@Service("rolePermissionRelationService")
public class RolePermissionRelationServiceImpl extends ServiceImpl<RolePermissionRelationDao, RolePermissionRelation> implements RolePermissionRelationService {

}