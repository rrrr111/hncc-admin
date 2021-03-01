package com.ruan.hncc.sms.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 挂号级别表
 *
 * @author ruanteng
 * Date 2021-02-27 00:29:54
 * Copyright (C) hlhs
 */
@Data
@TableName("sms_registration_rank")
public class RegistrationRank implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 号别id
	 */
	@TableId
			
	private Long id;
	/**
	 * 号别编码
	 */
			
	private String code;
	/**
	 * 号别名称
	 */
			
	private String name;
	/**
	 * 显示顺序号
	 */
			
	private Long seqNo;
	/**
	 * 挂号费
	 */
			
	private BigDecimal price;
	/**
	 * 状态：0->无效;1->有效
	 */
			
	private Integer status;


}
