package com.ruan.hncc.dms.entity;

import cn.hutool.core.date.DatePattern;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 退药项记录表
 *
 * @author ruanteng
 * Date 2021-02-27 00:56:42
 * Copyright (C) hlhs
 */
@Data
@TableName("dms_drug_refund_item_record")
public class DrugRefundItemRecord implements Serializable {
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
	 * 类型
	 */
			
	private Integer type;
	/**
	 * 挂号id
	 */
			
	private Long registrationId;
	/**
	 * 药品id
	 */
			
	private Long drugId;
	/**
	 * 单位
	 */
			
	private Integer refundNumUnit;
	/**
	 * 数量
	 */
			
	private Long refundNum;
	/**
	 * 时间
	 */
		@JsonFormat(pattern = DatePattern.NORM_DATETIME_PATTERN, timezone = "GMT+8")
		
	private Date refundTime;
	/**
	 * 执行人id
	 */
			
	private Long excutorId;
	/**
	 * 退药记录id
	 */
			
	private Long refundItemRecordId;

}
