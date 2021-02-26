package com.ruan.hncc.sms.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 科室表(done)
 *
 * @author ruanteng
 * Date 2021-02-27 00:29:54
 * Copyright (C) hlhs
 */
@Data
@TableName("sms_dept")
public class Dept implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
			
	private Long id;
	/**
	 * 科室编码
	 */
			
	private String code;
	/**
	 * 科室分类
	 */
			
	private Integer catId;
	/**
	 * 科室名称
	 */
			
	private String name;
	/**
	 * 科室类型
	 */
			
	private Integer type;
	/**
	 * 状态：0->无效;1->有效
	 */
			
	private Integer status;

}
