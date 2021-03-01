package com.ruan.hncc.sms.entity;

import cn.hutool.core.date.DatePattern;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 排班规则表
 *
 * @author ruanteng
 * Date 2021-02-27 00:29:54
 * Copyright (C) hlhs
 */
@Data
@TableName("sms_skd_rule")
public class SkdRule implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
			
	private Long id;
	/**
	 * 状态
	 */
			
	private Integer status;
	/**
	 * 操作人id
	 */
			
	private Long operatorId;

	/**
	 * 操作人name
	 */

	@TableField(exist = false)
	private String operatorName;
	/**
	 * 创建时间
	 */
		@JsonFormat(pattern = DatePattern.NORM_DATETIME_PATTERN, timezone = "GMT+8")
		
	private Date operateTime;
	/**
	 * 规则名
	 */
			
	private String ruleName;
	/**
	 * 描述
	 */
			
	private String description;
	/**
	 * 科室id
	 */
			
	private Long deptId;

	/**
	 * 科室name
	 */
	@TableField(exist = false)
	private String deptName;

}
