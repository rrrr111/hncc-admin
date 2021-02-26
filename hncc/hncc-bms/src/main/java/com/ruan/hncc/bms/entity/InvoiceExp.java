package com.ruan.hncc.bms.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 费用科目表
 *
 * @author ruanteng
 * Date 2021-02-27 00:11:43
 * Copyright (C) hlhs
 */
@Data
@TableName("bms_invoice_exp")
public class InvoiceExp implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * 编码
	 */
	private String code;
	/**
	 * 类型
	 */
	private Integer type;
	/**
	 * 名称
	 */
	private String name;

}
