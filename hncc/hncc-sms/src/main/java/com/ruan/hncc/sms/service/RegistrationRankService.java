package com.ruan.hncc.sms.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ruan.hncc.sms.entity.RegistrationRank;

import java.util.List;
import java.util.Map;

/**
 * 挂号级别表
 *
 * @author ruanteng
 * Date 2021-02-27 00:29:54
 * Copyright (C) hlhs
 */
public interface RegistrationRankService {

    /**
     * 获取挂号级别列表
     * @param map
     * @return
     */
    IPage listRegistrationRankPage(Map<String, Object> map);

    /**
     * 查询挂号级别详情
     * @param id
     * @return
     */
    RegistrationRank getRegistrationRankById(Long id);

    /**
     * 创建挂号级别
     * @param registrationRank
     * @return
     */
    Integer createRegistrationRank(RegistrationRank registrationRank);

    /**
     * 修改挂号级别
     * @param id
     * @param registrationRank
     * @return
     */
    Integer modifyRegistrationRank(Long id, RegistrationRank registrationRank);

    /**
     * 删除挂号级别
     * @param id
     * @return
     */
    Integer deleteRegistrationRank(Long[] id);

    /**
     * 所有挂号级别
     * @return
     */
    List<RegistrationRank> listAll();

}

