package com.ruan.hncc.sms.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 排班规则表
 *
 * @author ruanteng
 * Date 2021-02-27 00:29:54
 * Copyright (C) hlhs
 */
@Data
public class SkdRuleItemDto implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId

    private Long id;
    /**
     * 医生id
     */

    private Long staffId;
    /**
     * 一周中的排班时间
     */

    private String daysOfWeek;
    /**
     * 状态
     */

    private Integer status;
    /**
     * 挂号限额
     */

    private Long skLimit;
    /**
     * 排班规则id(FK)
     */

    private Long skRuleId;

    /**
     * 规则描述
     */
    private String description;

    /**
     * 科室id
     */
    private Long deptId;

    /**
     * 规则名
     */
    private String ruleName;

    /**
     * 操作人id
     */
    private Long userId;

    /**
     * 星期一上午
     */
    private String oneUp;

    /**
     * 星期一下午
     */
    private String oneDown;

    /**
     * 星期二上午
     */
    private String twoUp;

    /**
     * 星期二下午
     */
    private String twoDown;

    /**
     * 星期三上午
     */
    private String threeUp;

    /**
     * 星期三下午
     */
    private String threeDown;

    /**
     * 星期四上午
     */
    private String fourUp;

    /**
     * 星期四下午
     */
    private String fourDown;


    /**
     * 星期五上午
     */
    private String fiveUp;

    /**
     * 星期五下午
     */
    private String fiveDown;

    /**
     * 星期六上午
     */
    private String sixUp;

    /**
     * 星期六下午
     */
    private String sixDown;


    /**
     * 星期天上午
     */
    private String sevenUp;

    /**
     * 星期天下午
     */
    private String sevenDown;


}
