package com.ruan.hncc.dms.dto;

import cn.hutool.core.date.DatePattern;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author ruanTeng
 * @version 1.0
 * @date 2021/3/5 9:01
 */
@Data
public class RegistrationDto implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */

    private Long id;
    /**
     * 患者id
     */

    private Long patientId;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = DatePattern.NORM_DATETIME_PATTERN, timezone = "GMT+8")

    private Date createTime;
    /**
     * 诊断状态
     */

    private Integer endAttendance;
    /**
     * 状态1待诊2就诊中3诊毕4已退号
     */

    private Integer status;
    /**
     * 排班id
     */

    private Long skdId;
    /**
     * 是否需要病历本
     */

    private Integer needBook;
    /**
     * 绑定状态
     */

    private Integer bindStatus;
    /**
     * 科室id
     */

    private Long deptId;
    /**
     * 就诊日期
     */
    @JsonFormat(pattern = DatePattern.NORM_DATETIME_PATTERN, timezone = "GMT+8")

    private Date attendanceDate;
    /**
     * 就诊年龄
     */

    private String patientAgeStr;


    /**
     * 病历号
     */
    private String medicalRecordNo;

    /**
     * 性名
     */
    private String name;

    /**
     * 性别
     */
    private Integer gender;

    /**
     * 出生日期
     */
    @JsonFormat(pattern = DatePattern.NORM_DATETIME_PATTERN, timezone = "GMT+8")
    private Date dateOfBirth;

    /**
     * 看诊科室
     */

    private String deptName;


    /**
     * 身份证号
     */
    private String identificationNo;

    /**
     * 家庭住址
     */
    private String homeAddress;

    /**
     * 联系方法
     */
    private String phoneNo;


    /**
     * 看诊id
     */
    private Integer staffId;


    /**
     * 挂号级别
     */
    private Integer code;

    /**
     * 午别
     */
    private Integer noon;

    /**
     * 挂号应收金额
     */
    private BigDecimal price;


    /**
     * 支付方法
     */
    private String catCode;

}
