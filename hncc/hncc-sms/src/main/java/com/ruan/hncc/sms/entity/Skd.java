package com.ruan.hncc.sms.entity;

import cn.hutool.core.date.DatePattern;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 排班时间表
 *
 * @author ruanteng
 * Date 2021-02-27 00:29:54
 * Copyright (C) hlhs
 */
@Data
@TableName("sms_skd")
public class Skd implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId

    private Long id;
    /**
     * 上班日期
     */
    @JsonFormat(pattern = DatePattern.NORM_DATETIME_PATTERN, timezone = "GMT+8")
    private Date date;
    /**
     * 状态
     */

    private Integer status;
    /**
     * 剩余号数
     */

    private Long remain;
    /**
     * 午别（0上午1下午）
     */

    private Integer noon;
    /**
     * 员工id
     */

    private Long staffId;

    /**
     * 员工name
     */

    @TableField(exist = false)
    private String staffName;

    /**
     * 科室id
     */

    private Long deptId;

    /**
     * 科室name
     */

    @TableField(exist = false)
    private String deptName;
    /**
     * 挂号限额
     */

    private Long skLimit;
    /**
     *排班规则id
     */

    private Long smsSkdRuleId;


    /**
     * 挂号级别id
     */

    @TableField(exist = false)
    private Long registrationRankId;

//    /**
//     * 挂号级别name
//     */
//
//    @TableField(exist = false)
//    private Long registrationRankName;



}
