package com.ruan.hncc.sms.vo;

import cn.hutool.core.date.DatePattern;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruan.hncc.common.api.CommonPage;
import com.ruan.hncc.sms.entity.SkdRule;
import com.ruan.hncc.sms.entity.SkdRuleItem;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 排班规则表
 *
 * @author ruanteng
 * Date 2021-02-27 00:29:54
 * Copyright (C) hlhs
 */
@Data
public class SkdRuleVo implements Serializable {
	private static final long serialVersionUID = 1L;

	private SkdRule skdRule;

	private CommonPage iPage;

	private List<SkdRuleDaysOfWeekVo> vos;


}
