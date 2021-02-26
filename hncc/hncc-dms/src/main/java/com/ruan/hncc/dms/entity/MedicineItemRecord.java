package com.ruan.hncc.dms.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 成药项记录表
 *
 * @author ruanteng
 * Date 2021-02-27 00:23:22
 * Copyright (C) hlhs
 */
@Data
@TableName("dms_medicine_item_record")
public class MedicineItemRecord implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
			
	private Long id;
	/**
	 * 药品id
	 */
			
	private Long drugId;
	/**
	 * 状态
	 */
			
	private Integer status;
	/**
	 * 处方id
	 */
			
	private Long prescriptionId;
	/**
	 * 用法
	 */
			
	private Integer medicineUsage;
	/**
	 * 频率
	 */
			
	private Integer frequency;
	/**
	 * 天数
	 */
			
	private Long days;
	/**
	 * 数量
	 */
			
	private Long num;
	/**
	 * 医嘱
	 */
			
	private String medicalAdvice;
	/**
	 * 退药数量
	 */
			
	private Long refundNum;
	/**
	 * 用量
	 */
			
	private Long usageNum;
	/**
	 * 用法
	 */
			
	private Integer usageMeans;
	/**
	 * 单位
	 */
			
	private Integer usageNumUnit;
	/**
	 * 当前量
	 */
			
	private Long currentNum;

}
