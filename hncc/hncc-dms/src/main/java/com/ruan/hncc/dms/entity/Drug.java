package com.ruan.hncc.dms.entity;

import cn.hutool.core.date.DatePattern;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 药品项目表（包括了重要、中成药、草药）
 *
 * @author ruanteng
 * Date 2021-02-27 00:56:42
 * Copyright (C) hlhs
 */
@Data
@TableName("dms_drug")
public class Drug implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
			
	private Long id;
	/**
	 * 药品编码
	 */
			
	private String code;
	/**
	 * 药品名称
	 */
			
	private String name;
	/**
	 * 药品规格
	 */
			
	private String format;
	/**
	 * 药品单价
	 */
			
	private BigDecimal price;
	/**
	 * 包装单位
	 */
			
	private String unit;
	/**
	 * 生产厂家
	 */
			
	private String manufacturer;
	/**
	 * 药品剂型
	 */
			
	private Long dosageId;

	/**
	 * 药品剂型name
	 */

	@TableField(exist = false)
	private String dosageName;

	/**
	 * 药品类型
	 */
			
	private Long typeId;
	/**
	 * 拼音助记码
	 */
			
	private String mnemonicCode;
	/**
	 * 创建时间
	 */
		@JsonFormat(pattern = DatePattern.NORM_DATETIME_PATTERN, timezone = "GMT+8")
		
	private Date createDate;
	/**
	 * 库存
	 */
			
	private Long stock;
	/**
	 * 通用名
	 */
			
	private String genericName;
	/**
	 * 状态
	 */
			
	private Integer status;




}
