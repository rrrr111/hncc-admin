package com.ruan.hncc.sms.entity;

import cn.hutool.core.date.DatePattern;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 员工表
 *
 * @author ruanteng
 * Date 2021-02-27 00:29:54
 * Copyright (C) hlhs
 */
@Data
@TableName("sms_staff")
public class Staff implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
			
	private Long id;
	/**
	 * 登录名
	 */
			
	private String username;
	/**
	 * 登录密码
	 */
			
	private String password;
	/**
	 * 状态：0->有效;1->无效
	 */
			
	private Integer status;
	/**
	 * 创建时间
	 */
		@JsonFormat(pattern = DatePattern.NORM_DATETIME_PATTERN, timezone = "GMT+8")
		
	private Date createTime;
	/**
	 * 性别
	 */
			
	private Integer gender;
	/**
	 * 是否参与排班：0->否;1->是
	 */
			
	private Integer skdFlag;
	/**
	 * 职称
	 */
			
	private String title;
	/**
	 * 真实姓名
	 */
			
	private String name;
	/**
	 * 所在科室
	 */
			
	private Long deptId;
	/**
	 * 角色
	 */
			
	private Long roleId;
	/**
	 * 挂号级别id
	 */
			
	private Long registrationRankId;

}
