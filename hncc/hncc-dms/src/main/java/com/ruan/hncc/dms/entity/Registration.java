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
 * 就诊(门诊)信息表（一个病人一个病历号，多次就诊，多次就诊信息），也可以看作医院的挂号表
挂了号相当于开了一
 *
 * @author ruanteng
 * Date 2021-02-27 00:23:22
 * Copyright (C) hlhs
 */
@Data
@TableName("dms_registration")
public class Registration implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
			
	private Long id;
	/**
	 * 患者id
	 */
			
	private Long patientId;
	/**
	 * 创建时间
	 */
		@JsonFormat(pattern = DatePattern.NORM_DATETIME_PATTERN, timezone = "GMT+8")
		
	private Date createTime;
	/**
	 * 诊断状态
	 */
			
	private Integer endAttendance;
	/**
	 * 状态1待诊2就诊中3诊毕4已退号
	 */
			
	private Integer status;
	/**
	 * 排班id
	 */
			
	private Long skdId;
	/**
	 * 是否需要病历本
	 */
			
	private Integer needBook;
	/**
	 * 绑定状态
	 */
			
	private Integer bindStatus;
	/**
	 * 科室id
	 */
			
	private Long deptId;
	/**
	 * 就诊日期
	 */
		@JsonFormat(pattern = DatePattern.NORM_DATETIME_PATTERN, timezone = "GMT+8")
		
	private Date attendanceDate;
	/**
	 * 就诊年龄
	 */
			
	private String patientAgeStr;

}
