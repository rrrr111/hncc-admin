package com.ruan.hncc.bms.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 发票表
 *
 * @author ruanteng
 * Date 2021-02-27 00:11:43
 * Copyright (C) hlhs
 */
@Data
@TableName("bms_invoice_record")
public class InvoiceRecord implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * 创建时间
	 */
		@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTime;
	/**
	 * 发票号
	 */
	private Long invoiceNo;
	/**
	 * 账单id
	 */
	private Long billId;
	/**
	 * 总金额
	 */
	private BigDecimal amount;
	/**
	 * 冻结状态
	 */
	private Integer freezeStatus;
	/**
	 * 关联发票id
	 */
	private Long associateId;
	/**
	 * 对账人id
	 */
	private Long operatorId;
	/**
	 * 支付类别id
	 */
	private Long settlementCatId;
	/**
	 * 所属日结记录id
	 */
	private Long settleRecordId;
	/**
	 * 
	 */
	private String itemList;
	/**
	 * 类型
	 */
	private Integer type;

}
