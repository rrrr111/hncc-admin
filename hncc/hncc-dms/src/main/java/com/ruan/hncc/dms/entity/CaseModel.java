package com.ruan.hncc.dms.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 病例模版表
 *
 * @author ruanteng
 * Date 2021-02-27 00:56:42
 * Copyright (C) hlhs
 */
@Data
@TableName("dms_case_model")
public class CaseModel implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 模板Id
	 */
	@TableId
			
	private Long id;
	/**
	 * 主诉
	 */
			
	private String chiefComplaint;
	/**
	 * 症状
	 */
			
	private String historyOfPresentIllness;
	/**
	 * 历史治疗
	 */
			
	private String historyOfTreatment;
	/**
	 * 既往史
	 */
			
	private String pastHistory;
	/**
	 * 过敏史
	 */
			
	private String allergies;
	/**
	 * 健康检查
	 */
			
	private String healthCheckup;
	/**
	 * 初步诊断Id串
	 */
			
	private String priliminaryDiseIdList;
	/**
	 * 初诊诊断id串对应诊断名字串
	 */
			
	private String priliminaryDiseStrList;
	/**
	 * 病历模板名
	 */
			
	private String name;
	/**
	 * 状态
	 */
			
	private Integer status;

}
