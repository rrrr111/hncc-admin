package com.ruan.hncc.dms.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 非药品模版表
 *
 * @author ruanteng
 * Date 2021-02-27 00:23:22
 * Copyright (C) hlhs
 */
@Data
@TableName("dms_non_drug_model")
public class NonDrugModel implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 模版Id
	 */
	@TableId
			
	private Long id;
	/**
	 * 模版状态 0删除 1 正常
	 */
			
	private Integer status;
	/**
	 * 模版名称
	 */
			
	private String name;
	/**
	 * 模版所包括非药品的id
	 */
			
	private String nonDrugIdList;
	/**
	 * 模版范围 scope 0个人 1科室 2全院
	 */
			
	private Integer scope;
	/**
	 * 所属人Id
	 */
			
	private Long ownId;
	/**
	 * 目的
	 */
			
	private String aim;
	/**
	 * 创建时间
	 */
		@JsonFormat(pattern = DatePattern.NORM_DATETIME_PATTERN, timezone = "GMT+8")
		
	private Date createTime;
	/**
	 * 模版编码
	 */
			
	private String code;
	/**
	 * 模版类型 type 0检查 1检验  2处置
	 */
			
	private Integer type;

}
