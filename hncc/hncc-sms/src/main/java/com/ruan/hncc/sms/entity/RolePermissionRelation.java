package com.ruan.hncc.sms.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 员工角色与权限关系表
 *
 * @author ruanteng
 * Date 2021-02-27 00:29:54
 * Copyright (C) hlhs
 */
@Data
@TableName("sms_role_permission_relation")
public class RolePermissionRelation implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
			
	private Long id;
	/**
	 * 
	 */
			
	private Long roleId;
	/**
	 * 
	 */
			
	private Long permissionId;

}
