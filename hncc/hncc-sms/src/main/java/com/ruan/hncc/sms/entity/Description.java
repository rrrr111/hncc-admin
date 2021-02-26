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
 * 科室、员工描述表
 *
 * @author ruanteng
 * Date 2021-02-27 00:29:54
 * Copyright (C) hlhs
 */
@Data
@TableName("sms_description")
public class Description implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
			
	private Long id;
	/**
	 * 
	 */
			
	private String description;
	/**
	 * 
	 */
			
	private Integer type;
	/**
	 * 
	 */
			
	private Integer status;
	/**
	 * 
	 */
			
	private String url;
	/**
	 * 
	 */
			
	private Long theId;
	/**
	 * 
	 */
			
	private BigDecimal star;

}
