package com.ruan.hncc.sms.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 *
 * @author ruanteng
 * Date 2021-02-27 00:29:54
 * Copyright (C) hlhs
 */
@Data
@TableName("sms_dept_catalog")
public class DeptCatalog implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 科室分类id
	 */
	@TableId
			
	private Integer id;
	/**
	 * 科室分类名称
	 */
			
	private String name;

}
