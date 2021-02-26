package com.ruan.hncc.bms.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 收费员日结表
 *
 * @author ruanteng
 * Date 2021-02-27 00:11:43
 * Copyright (C) hlhs
 */
@Data
@TableName("bms_operator_settle_record")
public class OperatorSettleRecord implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
			@ApiModelProperty(value = "")
	private Long id;
	/**
	 * 开始时间
	 */
		@JsonFormat(pattern = DatePattern.NORM_DATETIME_PATTERN, timezone = "GMT+8")
		@ApiModelProperty(value = "开始时间")
	private Date startDatetime;
	/**
	 * 截止时间
	 */
		@JsonFormat(pattern = DatePattern.NORM_DATETIME_PATTERN, timezone = "GMT+8")
		@ApiModelProperty(value = "截止时间")
	private Date endDatetime;
	/**
	 * 日结时间
	 */
		@JsonFormat(pattern = DatePattern.NORM_DATETIME_PATTERN, timezone = "GMT+8")
		@ApiModelProperty(value = "日结时间")
	private Date createDatetime;
	/**
	 * 收银员（日结员）id
	 */
			@ApiModelProperty(value = "收银员（日结员）id")
	private Long cashierId;
	/**
	 * 发票总数量
	 */
			@ApiModelProperty(value = "发票总数量")
	private Long invoiceNum;
	/**
	 * 冲红发票数量
	 */
			@ApiModelProperty(value = "冲红发票数量")
	private Long rushInvoiceNum;
	/**
	 * 重打发票数量
	 */
			@ApiModelProperty(value = "重打发票数量")
	private Long reprintInvoiceNum;
	/**
	 * 起始结束发票id串
	 */
			@ApiModelProperty(value = "起始结束发票id串")
	private String startEndInvoiceIdStr;
	/**
	 * 冲红发票id list
	 */
			@ApiModelProperty(value = "冲红发票id list")
	private String rushInvoiceIdListStr;
	/**
	 * 重打发票id list
	 */
			@ApiModelProperty(value = "重打发票id list")
	private String reprintInvoiceIdListStr;
	/**
	 * 成药总金额
	 */
			@ApiModelProperty(value = "成药总金额")
	private BigDecimal medicineAmount;
	/**
	 * 草药总金额
	 */
			@ApiModelProperty(value = "草药总金额")
	private BigDecimal herbalAmount;
	/**
	 * 检查总金额
	 */
			@ApiModelProperty(value = "检查总金额")
	private BigDecimal checkAmount;
	/**
	 * 处置总金额
	 */
			@ApiModelProperty(value = "处置总金额")
	private BigDecimal dispositionAmount;
	/**
	 * 挂号总金额
	 */
			@ApiModelProperty(value = "挂号总金额")
	private BigDecimal registrationAmount;
	/**
	 * 检验总金额
	 */
			@ApiModelProperty(value = "检验总金额")
	private BigDecimal testAmount;
	/**
	 * 总金额
	 */
			@ApiModelProperty(value = "总金额")
	private BigDecimal amount;
	/**
	 * 现金总金额
	 */
			@ApiModelProperty(value = "现金总金额")
	private BigDecimal cashAmount;
	/**
	 * 医保总金额
	 */
			@ApiModelProperty(value = "医保总金额")
	private BigDecimal insuranceAmount;
	/**
	 * 银行卡总金额
	 */
			@ApiModelProperty(value = "银行卡总金额")
	private BigDecimal bankCardAmount;
	/**
	 * 支付宝总金额
	 */
			@ApiModelProperty(value = "支付宝总金额")
	private BigDecimal alipayAmount;
	/**
	 * 微信总金额
	 */
			@ApiModelProperty(value = "微信总金额")
	private BigDecimal wechatAmount;
	/**
	 * 银行卡总金额
	 */
			@ApiModelProperty(value = "银行卡总金额")
	private BigDecimal creditCardAmount;
	/**
	 * 其他总金额
	 */
			@ApiModelProperty(value = "其他总金额")
	private BigDecimal otherAmount;
	/**
	 * 对账人id
	 */
			@ApiModelProperty(value = "对账人id")
	private Long verifyOperatorId;
	/**
	 * 对账时间
	 */
		@JsonFormat(pattern = DatePattern.NORM_DATETIME_PATTERN, timezone = "GMT+8")
		@ApiModelProperty(value = "对账时间")
	private Date verifyDatetime;
	/**
	 * 对账状态
	 */
			@ApiModelProperty(value = "对账状态")
	private Integer verifyStatus;

}
