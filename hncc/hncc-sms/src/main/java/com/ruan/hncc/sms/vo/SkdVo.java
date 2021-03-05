package com.ruan.hncc.sms.vo;

import com.ruan.hncc.sms.entity.Skd;
import lombok.Data;

/**
 * @author ruanTeng
 * @version 1.0
 * @date 2021/3/2 8:47
 */
@Data
public class SkdVo extends Skd {

    /**
     * 挂号级别
     */
    private String registrationRankName;

}
