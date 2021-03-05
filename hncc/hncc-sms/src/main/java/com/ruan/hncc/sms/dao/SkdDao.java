package com.ruan.hncc.sms.dao;

import com.ruan.hncc.sms.entity.Skd;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 排班时间表
 *
 * @author ruanteng
 * Date 2021-02-27 00:29:54
 * Copyright (C) hlhs
 */
@Mapper
public interface SkdDao extends BaseMapper<Skd> {

    /**
     * 根据条件查询排班表
     * @param deptId
     * @param staffName
     * @param date
     * @param currentPage
     * @param pageSize
     * @return
     */
    List listSkdPage(@Param("deptId") String deptId, @Param("staffName") String staffName, @Param("date") String date, @Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize);

}
