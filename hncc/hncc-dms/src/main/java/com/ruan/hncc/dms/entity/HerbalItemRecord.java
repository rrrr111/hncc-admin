package com.ruan.hncc.dms.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 草药项记录表
 *
 * @author ruanteng
 * Date 2021-02-27 00:23:22
 * Copyright (C) hlhs
 */
@Data
@TableName("dms_herbal_item_record")
public class HerbalItemRecord implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
			
	private Long id;
	/**
	 * 状态
	 */
			
	private Integer status;
	/**
	 * 处方id
	 */
			
	private Long prescriptionId;
	/**
	 * 医嘱
	 */
			
	private String medicalAdvice;
	/**
	 * 脚注
	 */
			
	private String footnote;
	/**
	 * 药品id
	 */
			
	private Long drugId;
	/**
	 * 用量
	 */
			
	private Long usageNum;
	/**
	 * 单位
	 */
			
	private Integer usageNumUnit;
	/**
	 * 总量
	 */
			
	private Long totalNum;
	/**
	 * 当前数量
	 */
			
	private Long currentNum;

}
