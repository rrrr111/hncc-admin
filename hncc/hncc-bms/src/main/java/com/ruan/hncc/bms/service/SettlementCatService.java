package com.ruan.hncc.bms.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ruan.hncc.bms.entity.SettlementCat;

import java.util.Map;

/**
 * j结算类别
 *
 * @author ruanteng
 * Date 2021-02-27 00:11:43
 * Copyright (C) hlhs
 */
public interface SettlementCatService {

    IPage listPage(Map<String, Object> params);

    SettlementCat getSettlementCatById(Long id);

    Integer createSettlementCat(SettlementCat drug);

    Integer updateSettlementCat(Long id, SettlementCat drug);

    Integer deleteSettlementCat(Long[] id);
}

