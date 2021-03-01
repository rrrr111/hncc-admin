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
 * 病历表
 *
 * @author ruanteng
 * Date 2021-02-27 00:56:42
 * Copyright (C) hlhs
 */

@Data
@TableName("dms_case_history")
public class CaseHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
			
	private Long id;
	/**
	 * 主诉
	 */
			
	private String chiefComplaint;
	/**
	 * 现病史
	 */
			
	private String historyOfPresentIllness;
	/**
	 * 现治疗情况
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
	 * 体格检查
	 */
			
	private String healthCheckup;
	/**
	 * 门诊号(挂号号)
	 */
			
	private Long registrationId;
	/**
	 * 初诊结果str串
	 */
			
	private String priliminaryDiseStrList;
	/**
	 * 发病时间
	 */
		@JsonFormat(pattern = DatePattern.NORM_DATETIME_PATTERN, timezone = "GMT+8")
	private Date startDate;
	/**
	 * 病人姓名
	 */
			
	private String name;
	/**
	 * 病人性别
	 */
			
	private Integer gender;
	/**
	 * 病人年龄
	 */
			
	private String ageStr;
	/**
	 * 检查部位字符串列表
	 */
			
	private String checkStrList;
	/**
	 * 处置字符串列表
	 */
			
	private String dispositionStrList;
	/**
	 * 草药处方列表
	 */
			
	private String herbalPrescriptionStrList;
	/**
	 * 创建时间
	 */
		@JsonFormat(pattern = DatePattern.NORM_DATETIME_PATTERN, timezone = "GMT+8")
		
	private Date createTime;
	/**
	 * 确诊诊断串
	 */
			
	private String definiteDiseStrList;
	/**
	 * 病人id
	 */
			
	private Long patientId;
	/**
	 * 检验结果字符串
	 */
			
	private String testStrList;
	/**
	 * 西药处方
	 */
			
	private String medicinePrescriptionStrList;
	/**
	 * 状态1 初诊结束 2确诊结束 3 诊毕
	 */
			
	private Integer status;
	/**
	 * 初诊疾病id列表
	 */
			
	private String priliminaryDiseIdList;
	/**
	 * 检查结果（门诊医生填写）
	 */
			
	private String checkResult;
	/**
	 * 检验结果（门诊医生填写）
	 */
			
	private String testResult;

}
