package com.ruan.hncc.sms.entity;

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
@TableName("sms_skd_rule_item")
public class SkdRuleItem implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
			
	private Long id;
	/**
	 * 医生id
	 */
			
	private Long staffId;
	/**
	 * 一周中的排班时间
	 */
			
	private String daysOfWeek;
	/**
	 * 状态
	 */
			
	private Integer status;
	/**
	 * 挂号限额
	 */
			
	private Long skLimit;
	/**
	 * 排班规则id(FK)
	 */
			
	private Long skRuleId;

}
