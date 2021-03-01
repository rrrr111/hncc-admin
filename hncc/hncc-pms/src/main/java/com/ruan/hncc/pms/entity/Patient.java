package com.ruan.hncc.pms.entity;

import cn.hutool.core.date.DatePattern;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 病人基本信息表
 *
 * @author ruanteng
 * Date 2021-02-27 00:27:59
 * Copyright (C) hlhs
 */
@Data
@TableName("pms_patient")
public class Patient implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
			
	private Long id;
	/**
	 * 姓名
	 */
			
	private String name;
	/**
	 * 出生日期
	 */
		@JsonFormat(pattern = DatePattern.NORM_DATETIME_PATTERN, timezone = "GMT+8")
		
	private Date dateOfBirth;
	/**
	 * 身份证号
	 */
			
	private String identificationNo;
	/**
	 * 家庭住址
	 */
			
	private String homeAddress;
	/**
	 * 电话号码
	 */
			
	private String phoneNo;
	/**
	 * 性别
	 */
			
	private Integer gender;
	/**
	 * 病历号
	 */
			
	private String medicalRecordNo;

}
