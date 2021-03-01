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
 * 药品模版表
 *
 * @author ruanteng
 * Date 2021-02-27 00:56:42
 * Copyright (C) hlhs
 */
@Data
@TableName("dms_drug_model")
public class DrugModel implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 药品模版id
	 */
	@TableId
			
	private Long id;
	/**
	 * 药品模版状态
	 */
			
	private Integer status;
	/**
	 * 药品模版名字
	 */
			
	private String name;
	/**
	 * 药品模版范围类型 scope 0个人 1科室  2全院
	 */
			
	private Integer scope;
	/**
	 * 药品模版所属ID
	 */
			
	private Long ownId;
	/**
	 * 药品模版目的
	 */
			
	private String aim;
	/**
	 * 药品模版创建时间
	 */
		@JsonFormat(pattern = DatePattern.NORM_DATETIME_PATTERN, timezone = "GMT+8")
		
	private Date createTime;
	/**
	 * 药品模版编码
	 */
			
	private String code;
	/**
	 * 药品类型
	 */
			
	private Integer type;
	/**
	 * 草药：付数
	 */
			
	private Long pairNum;
	/**
	 * 草药：频次
	 */
			
	private Integer frequency;
	/**
	 * 草药：治法
	 */
			
	private String therapy;
	/**
	 * 草药：治法细节
	 */
			
	private String therapyDetails;
	/**
	 * 草药：医嘱
	 */
			
	private String medicalAdvice;

}
