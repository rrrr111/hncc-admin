package com.ruan.hncc.dms.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 检查项检验项处置项记录表(开立的)
 *
 * @author ruanteng
 * Date 2021-02-27 00:23:22
 * Copyright (C) hlhs
 */
@Data
@TableName("dms_non_drug_item_record")
public class NonDrugItemRecord implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
			
	private Long id;
	/**
	 * 挂号id
	 */
			
	private Long registrationId;
	/**
	 * 状态：0 作废（删除）1未缴费 2未登记（已缴费） 3已登记 4已执行 5已退费 6已过期
	 */
			
	private Integer status;
	/**
	 * 目的
	 */
			
	private String aim;
	/**
	 * 要求
	 */
			
	private String demand;
	/**
	 * 记录状态
	 */
			
	private Integer logStatus;
	/**
	 * 检查结果
	 */
			
	private String checkResult;
	/**
	 * 结果图片url列表
	 */
			
	private String resultImgUrlList;
	/**
	 * 临床印象
	 */
			
	private String clinicalImpression;
	/**
	 * 临床诊断
	 */
			
	private String clinicalDiagnosis;
	/**
	 * 创建（开立）时间
	 */
		@JsonFormat(pattern = DatePattern.NORM_DATETIME_PATTERN, timezone = "GMT+8")
		
	private Date createTime;
	/**
	 * 执行医生id
	 */
			
	private Long excuteStaffId;
	/**
	 * 登记时间
	 */
		@JsonFormat(pattern = DatePattern.NORM_DATETIME_PATTERN, timezone = "GMT+8")
		
	private Date logDatetime;
	/**
	 * 非药品Id
	 */
			
	private Long noDrugId;
	/**
	 * 检查部位
	 */
			
	private String checkParts;
	/**
	 * 类型： 0检查 1检验  2处置
	 */
			
	private Integer type;
	/**
	 * 执行科室id
	 */
			
	private Long excuteDeptId;
	/**
	 * 开立医生id
	 */
			
	private Long createStaffId;
	/**
	 * 登记医生id
	 */
			
	private Long logStaffId;
	/**
	 * 执行时间
	 */
		@JsonFormat(pattern = DatePattern.NORM_DATETIME_PATTERN, timezone = "GMT+8")
		
	private Date excuteTime;
	/**
	 * 金额
	 */
			
	private BigDecimal amount;

}
