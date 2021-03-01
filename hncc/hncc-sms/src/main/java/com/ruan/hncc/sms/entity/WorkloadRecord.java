package com.ruan.hncc.sms.entity;

import cn.hutool.core.date.DatePattern;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 门诊医生、科室工作量统计表
 *
 * @author ruanteng
 * Date 2021-02-27 00:29:54
 * Copyright (C) hlhs
 */
@Data
@TableName("sms_workload_record")
public class WorkloadRecord implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
			
	private Long id;
	/**
	 * 创建时间
	 */
		@JsonFormat(pattern = DatePattern.NORM_DATETIME_PATTERN, timezone = "GMT+8")
		
	private Date createTime;
	/**
	 * 员工id
	 */
			
	private Long staffId;
	/**
	 * 开立成药总钱数
	 */
			
	private BigDecimal medicineAmount;
	/**
	 * 开立草药总钱数
	 */
			
	private BigDecimal herbalAmount;
	/**
	 * 开立检查总钱数
	 */
			
	private BigDecimal checkAmount;
	/**
	 * 开立处置总钱数
	 */
			
	private BigDecimal dispositionAmount;
	/**
	 * 挂号总钱数
	 */
			
	private BigDecimal registrationAmount;
	/**
	 * 开立检验总钱数
	 */
			
	private BigDecimal testAmount;
	/**
	 * 总钱数
	 */
			
	private BigDecimal amount;
	/**
	 * 统计哪天的工作量
	 */
		@JsonFormat(pattern = DatePattern.NORM_DATETIME_PATTERN, timezone = "GMT+8")
		
	private Date date;
	/**
	 * 状态
	 */
			
	private Integer status;
	/**
	 * 挂号总数
	 */
			
	private Long registrationNum;
	/**
	 * 执行检查总钱数
	 */
			
	private BigDecimal excuteCheckAmount;
	/**
	 * 执行测验总钱数
	 */
			
	private BigDecimal excuteTestAmount;
	/**
	 * 执行处置总钱数
	 */
			
	private BigDecimal excuteDispositionAmount;
	/**
	 * type : 0 个人 1 科室
	 */
			
	private Integer type;
	/**
	 * 科室id
	 */
			
	private Long deptId;
	/**
	 * 执行总人数
	 */
			
	private Long excuteNum;

}
