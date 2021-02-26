package com.ruan.hncc.bms.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 医院账单流水表
 *
 * @author ruanteng
 * Date 2021-02-27 00:11:43
 * Copyright (C) hlhs
 */
@Data
@TableName("bms_bills_record")
public class BillsRecord implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * 账单类型
	 */
	private Integer type;
	/**
	 * 流水号
	 */
	private String billNo;
	/**
	 * 创建时间
	 */
		@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTime;
	/**
	 * 状态
	 */
	private Integer status;
	/**
	 * 发票数量
	 */
	private Integer invoiceNum;
	/**
	 * 挂号id
	 */
	private Long registrationId;
	/**
	 * 记录列表
	 */
	private String recordList;

}
