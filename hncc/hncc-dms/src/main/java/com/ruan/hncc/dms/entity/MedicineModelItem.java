package com.ruan.hncc.dms.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 成药模版项
 *
 * @author ruanteng
 * Date 2021-02-27 00:23:22
 * Copyright (C) hlhs
 */
@Data
@TableName("dms_medicine_model_item")
public class MedicineModelItem implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
			
	private Long id;
	/**
	 * 模板id
	 */
			
	private Long modelId;
	/**
	 * 状态
	 */
			
	private Integer status;
	/**
	 * 药品id
	 */
			
	private Long drugId;
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

}
