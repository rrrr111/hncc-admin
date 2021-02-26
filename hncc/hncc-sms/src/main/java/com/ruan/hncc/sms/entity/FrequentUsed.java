package com.ruan.hncc.sms.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 医生常用诊断（疾病）、检查检验表(搁置)
 *
 * @author ruanteng
 * Date 2021-02-27 00:29:54
 * Copyright (C) hlhs
 */
@Data
@TableName("sms_frequent_used")
public class FrequentUsed implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 常用项id
	 */
	@TableId
			
	private Long id;
	/**
	 * 西医诊断列表
	 */
			
	private String medicineDiseIdList;
	/**
	 * 中医诊断列表
	 */
			
	private String herbalDiseIdList;
	/**
	 * 处置项id列表
	 */
			
	private String dispositionIdList;
	/**
	 * 检验项列表
	 */
			
	private String testIdList;
	/**
	 * 检查项列表
	 */
			
	private String checkIdList;
	/**
	 * 检查模板id列表
	 */
			
	private String checkModelIdList;
	/**
	 * 处置模板id列表
	 */
			
	private String dispositionModelIdList;
	/**
	 * 检验模板id列表
	 */
			
	private String testModelIdList;
	/**
	 * 药品模板id列表
	 */
			
	private String drugModelIdList;
	/**
	 * 所属用户id
	 */
			
	private Long staffId;
	/**
	 * 药品列表
	 */
			
	private String drugIdList;

}
