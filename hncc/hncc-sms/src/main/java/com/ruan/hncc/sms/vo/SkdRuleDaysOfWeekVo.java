package com.ruan.hncc.sms.vo;

import com.ruan.hncc.sms.entity.SkdRuleItem;
import lombok.Data;

import java.io.Serializable;

/**
 * @author ruanTeng
 * @version 1.0
 * @date 2021/3/5 22:59
 */
@Data
public class SkdRuleDaysOfWeekVo  extends SkdRuleItem implements Serializable {

    private static final long serialVersionUID = 1L;

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
