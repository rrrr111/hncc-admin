package com.ruan.hncc.pms.dao;

import com.ruan.hncc.pms.entity.Patient;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 病人基本信息表
 *
 * @author ruanteng
 * Date 2021-02-27 00:27:59
 * Copyright (C) hlhs
 */
@Mapper
public interface PatientDao extends BaseMapper<Patient> {
	
}
