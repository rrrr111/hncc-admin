package com.ruan.hncc.pms.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 病人基本信息对象 pms_patient
 * 
 * @author ruanteng
 * @date 2021-02-24
 */
public class PmsPatient extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 出生日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "出生日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date dateOfBirth;

    /** 身份证号 */
    @Excel(name = "身份证号")
    private String identificationNo;

    /** 家庭住址 */
    @Excel(name = "家庭住址")
    private String homeAddress;

    /** 电话号码 */
    @Excel(name = "电话号码")
    private String phoneNo;

    /** 性别 */
    @Excel(name = "性别")
    private Long gender;

    /** 病历号 */
    @Excel(name = "病历号")
    private String medicalRecordNo;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setDateOfBirth(Date dateOfBirth) 
    {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getDateOfBirth() 
    {
        return dateOfBirth;
    }
    public void setIdentificationNo(String identificationNo) 
    {
        this.identificationNo = identificationNo;
    }

    public String getIdentificationNo() 
    {
        return identificationNo;
    }
    public void setHomeAddress(String homeAddress) 
    {
        this.homeAddress = homeAddress;
    }

    public String getHomeAddress() 
    {
        return homeAddress;
    }
    public void setPhoneNo(String phoneNo) 
    {
        this.phoneNo = phoneNo;
    }

    public String getPhoneNo() 
    {
        return phoneNo;
    }
    public void setGender(Long gender) 
    {
        this.gender = gender;
    }

    public Long getGender() 
    {
        return gender;
    }
    public void setMedicalRecordNo(String medicalRecordNo) 
    {
        this.medicalRecordNo = medicalRecordNo;
    }

    public String getMedicalRecordNo() 
    {
        return medicalRecordNo;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("dateOfBirth", getDateOfBirth())
            .append("identificationNo", getIdentificationNo())
            .append("homeAddress", getHomeAddress())
            .append("phoneNo", getPhoneNo())
            .append("gender", getGender())
            .append("medicalRecordNo", getMedicalRecordNo())
            .toString();
    }
}
