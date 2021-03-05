package com.ruan.hncc.dms.dao;

import com.ruan.hncc.dms.entity.Registration;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 就诊(门诊)信息表（一个病人一个病历号，多次就诊，多次就诊信息），也可以看作医院的挂号表
挂了号相当于开了一
 *
 * @author ruanteng
 * Date 2021-02-27 00:23:22
 * Copyright (C) hlhs
 */
@Mapper
public interface RegistrationDao extends BaseMapper<Registration> {

    List<Registration> getRegistrationList(@Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize, @Param("deptId") String deptId, @Param("endAttendance") String endAttendance, @Param("name") String name);
}
