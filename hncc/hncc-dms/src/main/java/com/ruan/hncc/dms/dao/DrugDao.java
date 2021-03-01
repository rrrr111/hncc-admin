package com.ruan.hncc.dms.dao;

import com.ruan.hncc.dms.entity.Drug;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 药品项目表（包括了重要、中成药、草药）
 *
 * @author ruanteng
 * Date 2021-02-27 00:56:42
 * Copyright (C) hlhs
 */
@Mapper
public interface DrugDao extends BaseMapper<Drug> {

    List<Drug> listDrug(@Param("code") String code, @Param("name") String name, @Param("dosageId") String dosageId, @Param("typeId") String typeId, @Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize);


}
