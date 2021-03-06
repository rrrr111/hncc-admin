package com.ruan.hncc.sms.dto;

import cn.hutool.core.date.DatePattern;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ruanTeng
 * @version 1.0
 * @date 2021/3/6 8:36
 * 
 * 前端传过来的生成排班列表的数据
 */

@Data
public class SkdDto  implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 开始时间
     */
    @JsonFormat(pattern = DatePattern.NORM_DATE_PATTERN, timezone = "GMT+8")
    private Date startTime;

    /**
     * 结束时间
     */
    @JsonFormat(pattern = DatePattern.NORM_DATE_PATTERN, timezone = "GMT+8")
    private Date endTime;

    /**
     * 规则id
     */
    private Long skdRuleId;
    
}
