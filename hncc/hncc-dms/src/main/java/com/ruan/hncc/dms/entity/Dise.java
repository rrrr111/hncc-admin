package com.ruan.hncc.dms.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 诊断类型（疾病）表
 *
 * @author ruanteng
 * Date 2021-02-27 00:56:42
 * Copyright (C) hlhs
 */
@Data
@TableName("dms_dise")
public class Dise implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
			
	private Long id;
	/**
	 * 目录id
	 */
			
	private Long catId;
	/**
	 * 疾病编码
	 */
			
	private String code;
	/**
	 * 疾病名称
	 */
			
	private String name;
	/**
	 * ICD编码
	 */
			
	private String icd;
	/**
	 * 状态
	 */
			
	private Integer status;

}
