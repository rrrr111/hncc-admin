package com.ruan.hncc.sms.dao;

import com.ruan.hncc.sms.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 角色表
 *
 * @author ruanteng
 * Date 2021-02-27 00:29:54
 * Copyright (C) hlhs
 */
@Mapper
public interface RoleDao extends BaseMapper<Role> {
	
}
