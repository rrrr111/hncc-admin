package com.ruan.hncc.dms.entity;

import cn.hutool.core.date.DatePattern;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 非药品收费项目表
 *
 * @author ruanteng
 * Date 2021-02-27 00:23:22
 * Copyright (C) hlhs
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@TableName("dms_non_drug")
public class NonDrug implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId

    private Long id;
    /**
     * 项目编码
     */

    private String code;
    /**
     * 项目名称
     */

    private String name;
    /**
     * 规格
     */

    private String format;
    /**
     * 价格
     */

    private BigDecimal price;
    /**
     * 所属费用科目ID
     */

    private Long expClassId;
    /**
     * 拼音助记码
     */

    private String mnemonicCode;
    /**
     * 1检查2检验3处置
     */

    private Integer recordType;

    @TableField(exist = false)
    private String recordTypeName;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = DatePattern.NORM_DATETIME_PATTERN, timezone = "GMT+8")

    private Date createDate;
    /**
     * 状态
     */

    private Integer status;
    /**
     * 执行科室ID
     */

    private Long deptId;

    /**
     * 执行科室名
     */

    @TableField(exist = false)
    private String deptName;



}
