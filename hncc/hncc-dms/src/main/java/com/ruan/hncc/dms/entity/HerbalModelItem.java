package com.ruan.hncc.dms.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 草药模版项表
 *
 * @author ruanteng
 * Date 2021-02-27 00:23:22
 * Copyright (C) hlhs
 */
@Data
@TableName("dms_herbal_model_item")
public class HerbalModelItem implements Serializable {
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
	 * 说明
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
	 * 用量单位
	 */
			
	private Integer usageNumUnit;
	/**
	 * 药品模板id
	 */
			
	private Long modelId;

}
