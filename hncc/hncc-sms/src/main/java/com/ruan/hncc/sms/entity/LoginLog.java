package com.ruan.hncc.sms.entity;

import cn.hutool.core.date.DatePattern;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 登录日志表
 *
 * @author ruanteng
 * Date 2021-02-27 00:29:54
 * Copyright (C) hlhs
 */
@Data
@TableName("sms_login_log")
public class LoginLog implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @TableId

    private Long id;
    /**
     *
     */

    private Long userId;
    /**
     *
     */
    @JsonFormat(pattern = DatePattern.NORM_DATETIME_PATTERN, timezone = "GMT+8")
    private Date createTime;
    /**
     *
     */

    private String ip;

}
