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
 * 病例模版目录表
 *
 * @author ruanteng
 * Date 2021-02-27 00:56:42
 * Copyright (C) hlhs
 */
@Data
@TableName("dms_case_model_catalog")
public class CaseModelCatalog implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
			
	private Long id;
	/**
	 * 父模板（目录）Id
	 */
			
	private Long parentId;
	/**
	 * 层级（增加时不需传入）
	 */
			
	private Integer level;
	/**
	 * 类型 ： 2 模板 1 目录
	 */
			
	private Integer type;
	/**
	 * 状态： 1 正常（增加时不需传入）
	 */
			
	private Integer status;
	/**
	 * 模板id
	 */
			
	private Long modelId;
	/**
	 * 范围:0个人 1科室 2全院
	 */
			
	private Integer scope;
	/**
	 * 所属人Id
	 */
			
	private Long ownId;
	/**
	 * 创建时间（增加时不需传入）
	 */
		@JsonFormat(pattern = DatePattern.NORM_DATETIME_PATTERN, timezone = "GMT+8")
		
	private Date createTime;
	/**
	 * 目录或模板名
	 */
			
	private String name;

}
