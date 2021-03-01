package com.ruan.hncc.dms.entity;

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
 * 草处方表
 *
 * @author ruanteng
 * Date 2021-02-27 00:23:22
 * Copyright (C) hlhs
 */
@Data
@TableName("dms_herbal_prescription_record")
public class HerbalPrescriptionRecord implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
			
	private Long id;
	/**
	 * 草药处方状态：status  0作废 1未缴费 2已缴费 3已过期
	 */
			
	private Integer status;
	/**
	 * 创建时间
	 */
		@JsonFormat(pattern = DatePattern.NORM_DATETIME_PATTERN, timezone = "GMT+8")
		
	private Date createTime;
	/**
	 * 总金额
	 */
			
	private BigDecimal amount;
	/**
	 * 处方名
	 */
			
	private String name;
	/**
	 * 治法
	 */
			
	private String therapy;
	/**
	 * 治法详情
	 */
			
	private String therapyDetails;
	/**
	 * 医嘱
	 */
			
	private String medicalAdvice;
	/**
	 * 付数
	 */
			
	private Long pairNum;
	/**
	 * 门诊Id(挂号号id)
	 */
			
	private Long registrationId;
	/**
	 * 频次
	 */
			
	private Integer frequency;
	/**
	 * 用法
	 */
			
	private Integer usageMeans;
	/**
	 * 类型（普诊）
	 */
			
	private Integer type;
	/**
	 * 开立人
	 */
			
	private Long createStaffId;

}
