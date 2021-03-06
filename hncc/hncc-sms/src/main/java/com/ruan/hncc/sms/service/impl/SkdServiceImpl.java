package com.ruan.hncc.sms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruan.hncc.common.utils.GetBetweenDate;
import com.ruan.hncc.common.utils.StringUtils;
import com.ruan.hncc.sms.dto.SkdDto;
import com.ruan.hncc.sms.entity.RegistrationRank;
import com.ruan.hncc.sms.entity.SkdRule;
import com.ruan.hncc.sms.entity.SkdRuleItem;
import com.ruan.hncc.sms.service.RegistrationRankService;
import com.ruan.hncc.sms.service.SkdRuleItemService;
import com.ruan.hncc.sms.service.SkdRuleService;
import com.ruan.hncc.sms.vo.SkdVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.ruan.hncc.sms.dao.SkdDao;
import com.ruan.hncc.sms.entity.Skd;
import com.ruan.hncc.sms.service.SkdService;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 排班时间表
 *
 * @author ruanteng
 * Date 2021-02-27 00:29:54
 * Copyright (C) hlhs
 */
@Service("skdService")
public class SkdServiceImpl extends ServiceImpl<SkdDao, Skd> implements SkdService {

    @Resource
    private RegistrationRankService rankService;


    @Resource
    private SkdRuleService skdRuleService;

    @Resource
    private SkdRuleItemService skdRuleItemService;

    @Override
    public List<SkdVo> listSkdPage(Map<String, Object> params) {

        String deptId = (String) params.get("deptId");

        String staffName = (String) params.get("staffName");

        String date = (String) params.get("date");

        Integer pageNum = Integer.parseInt(String.valueOf(params.get("pageNum")));

        Integer pageSize = Integer.parseInt(String.valueOf(params.get("pageSize")));

        Integer currentPage = (pageNum - 1) * pageSize;

        List<Skd> list = this.baseMapper.listSkdPage(deptId, staffName, date, currentPage, pageSize);

        //挂号级别列表
        List<RegistrationRank> rankList = rankService.listAll();

        if (list != null && !list.isEmpty()) {
            List<SkdVo> collect = list.stream().map(item -> {
                SkdVo skdVo = new SkdVo();
                BeanUtils.copyProperties(item, skdVo);
                skdVo.setRegistrationRankName(getRegistrationRankNameById(item.getRegistrationRankId(),rankList));
                return skdVo;
            }).collect(Collectors.toList());
            return collect;
        }

        return null;

    }

    private String getRegistrationRankNameById(Long id, List<RegistrationRank> rankList) {
        if (rankList != null && !rankList.isEmpty()) {
            List<RegistrationRank> collect = rankList.stream().filter(r -> {
                return r.getId().equals(id);
            }).collect(Collectors.toList());
            if (collect != null && !collect.isEmpty()) {
                return collect.get(0).getName();
            }
        }
        return null;
    }

    /**
     * 根据挂号级别id设置挂号级别
     *
     * @param skdVo
     * @param rankList
     * @return
     */
    private SkdVo getRegistrationLevel(SkdVo skdVo, List<RegistrationRank> rankList) {

        if (rankList != null && !rankList.isEmpty()) {
            rankList.stream().forEach(i -> {
                if (skdVo.getRegistrationRankId().equals(i.getId())) {
                    skdVo.setRegistrationRankName(i.getName());
                }
            });
        }

        return skdVo;

    }

    /**
     * 获得分页数据
     *
     * @param params
     * @return
     */
    @Override
    public IPage getPage(Map<String, Object> params) {
        String deptId = (String) params.get("deptId");

        String staffName = (String) params.get("staffName");

        String date = (String) params.get("date");

        Integer pageNum = Integer.parseInt(String.valueOf(params.get("pageNum")));

        Integer pageSize = Integer.parseInt(String.valueOf(params.get("pageSize")));


        LambdaQueryWrapper<Skd> wrapper = new LambdaQueryWrapper<Skd>();

        if (StringUtils.isNotEmpty(deptId)) {
            wrapper.eq(Skd::getDeptId, deptId);
        }

//        if (StringUtils.isNotEmpty(staffName)) {
//            wrapper.eq(Skd::getStaffName, staffName);
//        }

        if (StringUtils.isNotEmpty(date)) {
            wrapper.eq(Skd::getDate, date);
        }

        return page(new Page<>(pageNum, pageSize), wrapper);
    }

    @Override
    public Skd getRegistrationRankById(Long id) {
        return null;
    }

    @Override
    public Integer createSkd(Skd skd) {
        return this.baseMapper.insert(skd);
    }


    @Override
    public Integer modifySkd(Long id, Skd skd) {
        skd.setId(id);
        return this.baseMapper.updateById(skd);
    }

    /**
     * 删除排班计划
     *
     * @param id
     * @return
     */
    @Override
    public Integer deleteSkd(Long[] id) {
        return this.baseMapper.deleteBatchIds(Arrays.asList(id));
    }

    /**
     * 生成排班计划
     *
     * @param skdDto
     * @return
     */
    @Transactional
    @Override
    public Integer generatePlan(SkdDto skdDto) throws ParseException {

        //删除之前的排班计划
        this.baseMapper.deleteById(skdDto.getSkdRuleId());

        Integer count = 0;
        Date startTime = skdDto.getStartTime();

        Date endTime = skdDto.getEndTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String startDate = new SimpleDateFormat("yyyy-MM-dd").format(startTime);
        String endDate = new SimpleDateFormat("yyyy-MM-dd").format(endTime);
        List<String> betweenDate = GetBetweenDate.getBetweenDate(startDate, endDate);

        Long skdRuleId = skdDto.getSkdRuleId();

        SkdRule skdRule = skdRuleService.getRegistrationRankById(skdRuleId);

        List<SkdRuleItem> list = skdRuleItemService.listBySkdRuleId(skdRule.getId());

        if (list != null && !list.isEmpty()) {
            for (SkdRuleItem skdRuleItem : list) {
                String[] split = skdRuleItem.getDaysOfWeek().split(",");
                for (String s : betweenDate) {

                    Calendar cal = Calendar.getInstance();
                    cal.setTime(dateFormat.parse(s));
                    int date = cal.get(Calendar.DAY_OF_WEEK) - 1;


                    //周一
                    if (date == 1) {
                        if (split[0].equals("1")) {
                            Skd skd = new Skd();
                            skd.setDate(dateFormat.parse(s));
                            skd.setStatus(1);
                            skd.setRemain(skdRuleItem.getSkLimit());
                            skd.setNoon(0);
                            skd.setStaffId(skdRuleItem.getStaffId());
                            skd.setDeptId(skdRule.getDeptId());
                            skd.setSmsSkdRuleId(skdRule.getId());
                            skd.setSkLimit(skdRuleItem.getSkLimit());
                            if (split[1].equals("0")) {
                                this.baseMapper.delete(new LambdaQueryWrapper<Skd>()
                                        .eq(Skd::getDate, s).and(w -> {
                                            w.eq(Skd::getStaffId, skdRuleItem.getStaffId())
                                                    .and(w2 -> {
                                                        w2.eq(Skd::getNoon, 0);
                                                    });
                                        }));
                            }
                            Skd skd1 = this.baseMapper.selectOne(new LambdaQueryWrapper<Skd>()
                                    .eq(Skd::getDate, s).and(w -> {
                                        w.eq(Skd::getStaffId, skdRuleItem.getStaffId())
                                                .and(w2 -> {
                                                    w2.eq(Skd::getNoon, 0);
                                                });
                                    }));
                            if (skd1 == null) {
                                count = this.baseMapper.insert(skd);
                                if (count < 1) {
                                    throw new RuntimeException();
                                }
                            }

                        }

                        if (split[1].equals("1")) {
                            Skd skd = new Skd();
                            skd.setDate(dateFormat.parse(s));
                            skd.setStatus(1);
                            skd.setRemain(skdRuleItem.getSkLimit());
                            skd.setNoon(1);
                            skd.setStaffId(skdRuleItem.getStaffId());
                            skd.setDeptId(skdRule.getDeptId());
                            skd.setSmsSkdRuleId(skdRule.getId());
                            skd.setSkLimit(skdRuleItem.getSkLimit());
                            //判断另一个午别有没有排班
                            if (split[0].equals("0")) {
                                this.baseMapper.delete(new LambdaQueryWrapper<Skd>()
                                        .eq(Skd::getDate, s).and(w -> {
                                            w.eq(Skd::getStaffId, skdRuleItem.getStaffId())
                                                    .and(w2 -> {
                                                        w2.eq(Skd::getNoon, 0);
                                                    });
                                        }));
                            }
                            Skd skd1 = this.baseMapper.selectOne(new LambdaQueryWrapper<Skd>()
                                    .eq(Skd::getDate, s).and(w -> {
                                        w.eq(Skd::getStaffId, skdRuleItem.getStaffId())
                                                .and(w2 -> {
                                                    w2.eq(Skd::getNoon, 1);
                                                });
                                    }));
                            if (skd1 == null) {
                                count = this.baseMapper.insert(skd);
                                if (count < 1) {
                                    throw new RuntimeException();
                                }
                            }
                        }
                    }
                    //周二
                    if (date == 2) {
                        if (split[2].equals("1")) {
                            Skd skd = new Skd();
                            skd.setDate(dateFormat.parse(s));
                            skd.setStatus(1);
                            skd.setRemain(skdRuleItem.getSkLimit());
                            skd.setNoon(0);
                            skd.setStaffId(skdRuleItem.getStaffId());
                            skd.setDeptId(skdRule.getDeptId());
                            skd.setSmsSkdRuleId(skdRule.getId());
                            skd.setSkLimit(skdRuleItem.getSkLimit());
                            if (split[3].equals("0")) {
                                this.baseMapper.delete(new LambdaQueryWrapper<Skd>()
                                        .eq(Skd::getDate, s).and(w -> {
                                            w.eq(Skd::getStaffId, skdRuleItem.getStaffId())
                                                    .and(w2 -> {
                                                        w2.eq(Skd::getNoon, 0);
                                                    });
                                        }));
                            }
                            Skd skd1 = this.baseMapper.selectOne(new LambdaQueryWrapper<Skd>()
                                    .eq(Skd::getDate, s).and(w -> {
                                        w.eq(Skd::getStaffId, skdRuleItem.getStaffId())
                                                .and(w2 -> {
                                                    w2.eq(Skd::getNoon, 0);
                                                });
                                    }));
                            if (skd1 == null) {
                                count = this.baseMapper.insert(skd);
                                if (count < 1) {
                                    throw new RuntimeException();
                                }
                            }

                        }

                        if (split[3].equals("1")) {
                            Skd skd = new Skd();
                            skd.setDate(dateFormat.parse(s));
                            skd.setStatus(1);
                            skd.setRemain(skdRuleItem.getSkLimit());
                            skd.setNoon(1);
                            skd.setStaffId(skdRuleItem.getStaffId());
                            skd.setDeptId(skdRule.getDeptId());
                            skd.setSmsSkdRuleId(skdRule.getId());
                            skd.setSkLimit(skdRuleItem.getSkLimit());
                            //判断另一个午别有没有排班
                            if (split[2].equals("0")) {
                                this.baseMapper.delete(new LambdaQueryWrapper<Skd>()
                                        .eq(Skd::getDate, s).and(w -> {
                                            w.eq(Skd::getStaffId, skdRuleItem.getStaffId())
                                                    .and(w2 -> {
                                                        w2.eq(Skd::getNoon, 0);
                                                    });
                                        }));
                            }
                            Skd skd1 = this.baseMapper.selectOne(new LambdaQueryWrapper<Skd>()
                                    .eq(Skd::getDate, s).and(w -> {
                                        w.eq(Skd::getStaffId, skdRuleItem.getStaffId())
                                                .and(w2 -> {
                                                    w2.eq(Skd::getNoon, 1);
                                                });
                                    }));
                            if (skd1 == null) {
                                count = this.baseMapper.insert(skd);
                                if (count < 1) {
                                    throw new RuntimeException();
                                }
                            }
                        }
                    }
                    //周三
                    if (date == 3) {
                        if (split[4].equals("1")) {
                            Skd skd = new Skd();
                            skd.setDate(dateFormat.parse(s));
                            skd.setStatus(1);
                            skd.setRemain(skdRuleItem.getSkLimit());
                            skd.setNoon(0);
                            skd.setStaffId(skdRuleItem.getStaffId());
                            skd.setDeptId(skdRule.getDeptId());
                            skd.setSmsSkdRuleId(skdRule.getId());
                            skd.setSkLimit(skdRuleItem.getSkLimit());
                            if (split[5].equals("0")) {
                                this.baseMapper.delete(new LambdaQueryWrapper<Skd>()
                                        .eq(Skd::getDate, s).and(w -> {
                                            w.eq(Skd::getStaffId, skdRuleItem.getStaffId())
                                                    .and(w2 -> {
                                                        w2.eq(Skd::getNoon, 0);
                                                    });
                                        }));
                            }
                            Skd skd1 = this.baseMapper.selectOne(new LambdaQueryWrapper<Skd>()
                                    .eq(Skd::getDate, s).and(w -> {
                                        w.eq(Skd::getStaffId, skdRuleItem.getStaffId())
                                                .and(w2 -> {
                                                    w2.eq(Skd::getNoon, 0);
                                                });
                                    }));
                            if (skd1 == null) {
                                count = this.baseMapper.insert(skd);
                                if (count < 1) {
                                    throw new RuntimeException();
                                }
                            }

                        }

                        if (split[5].equals("1")) {
                            Skd skd = new Skd();
                            skd.setDate(dateFormat.parse(s));
                            skd.setStatus(1);
                            skd.setRemain(skdRuleItem.getSkLimit());
                            skd.setNoon(1);
                            skd.setStaffId(skdRuleItem.getStaffId());
                            skd.setDeptId(skdRule.getDeptId());
                            skd.setSmsSkdRuleId(skdRule.getId());
                            skd.setSkLimit(skdRuleItem.getSkLimit());
                            //判断另一个午别有没有排班
                            if (split[4].equals("0")) {
                                this.baseMapper.delete(new LambdaQueryWrapper<Skd>()
                                        .eq(Skd::getDate, s).and(w -> {
                                            w.eq(Skd::getStaffId, skdRuleItem.getStaffId())
                                                    .and(w2 -> {
                                                        w2.eq(Skd::getNoon, 0);
                                                    });
                                        }));
                            }
                            Skd skd1 = this.baseMapper.selectOne(new LambdaQueryWrapper<Skd>()
                                    .eq(Skd::getDate, s).and(w -> {
                                        w.eq(Skd::getStaffId, skdRuleItem.getStaffId())
                                                .and(w2 -> {
                                                    w2.eq(Skd::getNoon, 1);
                                                });
                                    }));
                            if (skd1 == null) {
                                count = this.baseMapper.insert(skd);
                                if (count < 1) {
                                    throw new RuntimeException();
                                }
                            }
                        }
                    }
                    //周四
                    if (date == 4) {
                        if (split[6].equals("1")) {
                            Skd skd = new Skd();
                            skd.setDate(dateFormat.parse(s));
                            skd.setStatus(1);
                            skd.setRemain(skdRuleItem.getSkLimit());
                            skd.setNoon(0);
                            skd.setStaffId(skdRuleItem.getStaffId());
                            skd.setDeptId(skdRule.getDeptId());
                            skd.setSmsSkdRuleId(skdRule.getId());
                            skd.setSkLimit(skdRuleItem.getSkLimit());
                            if (split[7].equals("0")) {
                                this.baseMapper.delete(new LambdaQueryWrapper<Skd>()
                                        .eq(Skd::getDate, s).and(w -> {
                                            w.eq(Skd::getStaffId, skdRuleItem.getStaffId())
                                                    .and(w2 -> {
                                                        w2.eq(Skd::getNoon, 0);
                                                    });
                                        }));
                            }
                            Skd skd1 = this.baseMapper.selectOne(new LambdaQueryWrapper<Skd>()
                                    .eq(Skd::getDate, s).and(w -> {
                                        w.eq(Skd::getStaffId, skdRuleItem.getStaffId())
                                                .and(w2 -> {
                                                    w2.eq(Skd::getNoon, 0);
                                                });
                                    }));
                            if (skd1 == null) {
                                count = this.baseMapper.insert(skd);
                                if (count < 1) {
                                    throw new RuntimeException();
                                }
                            }

                        }

                        if (split[7].equals("1")) {
                            Skd skd = new Skd();
                            skd.setDate(dateFormat.parse(s));
                            skd.setStatus(1);
                            skd.setRemain(skdRuleItem.getSkLimit());
                            skd.setNoon(1);
                            skd.setStaffId(skdRuleItem.getStaffId());
                            skd.setDeptId(skdRule.getDeptId());
                            skd.setSmsSkdRuleId(skdRule.getId());
                            skd.setSkLimit(skdRuleItem.getSkLimit());
                            //判断另一个午别有没有排班
                            if (split[6].equals("0")) {
                                this.baseMapper.delete(new LambdaQueryWrapper<Skd>()
                                        .eq(Skd::getDate, s).and(w -> {
                                            w.eq(Skd::getStaffId, skdRuleItem.getStaffId())
                                                    .and(w2 -> {
                                                        w2.eq(Skd::getNoon, 0);
                                                    });
                                        }));
                            }
                            Skd skd1 = this.baseMapper.selectOne(new LambdaQueryWrapper<Skd>()
                                    .eq(Skd::getDate, s).and(w -> {
                                        w.eq(Skd::getStaffId, skdRuleItem.getStaffId())
                                                .and(w2 -> {
                                                    w2.eq(Skd::getNoon, 1);
                                                });
                                    }));
                            if (skd1 == null) {
                                count = this.baseMapper.insert(skd);
                                if (count < 1) {
                                    throw new RuntimeException();
                                }
                            }
                        }
                    }
                    //周五
                    if (date == 5) {
                        if (split[8].equals("1")) {
                            Skd skd = new Skd();
                            skd.setDate(dateFormat.parse(s));
                            skd.setStatus(1);
                            skd.setRemain(skdRuleItem.getSkLimit());
                            skd.setNoon(0);
                            skd.setStaffId(skdRuleItem.getStaffId());
                            skd.setDeptId(skdRule.getDeptId());
                            skd.setSmsSkdRuleId(skdRule.getId());
                            skd.setSkLimit(skdRuleItem.getSkLimit());
                            if (split[9].equals("0")) {
                                this.baseMapper.delete(new LambdaQueryWrapper<Skd>()
                                        .eq(Skd::getDate, s).and(w -> {
                                            w.eq(Skd::getStaffId, skdRuleItem.getStaffId())
                                                    .and(w2 -> {
                                                        w2.eq(Skd::getNoon, 0);
                                                    });
                                        }));
                            }
                            Skd skd1 = this.baseMapper.selectOne(new LambdaQueryWrapper<Skd>()
                                    .eq(Skd::getDate, s).and(w -> {
                                        w.eq(Skd::getStaffId, skdRuleItem.getStaffId())
                                                .and(w2 -> {
                                                    w2.eq(Skd::getNoon, 0);
                                                });
                                    }));
                            if (skd1 == null) {
                                count = this.baseMapper.insert(skd);
                                if (count < 1) {
                                    throw new RuntimeException();
                                }
                            }

                        }

                        if (split[9].equals("1")) {
                            Skd skd = new Skd();
                            skd.setDate(dateFormat.parse(s));
                            skd.setStatus(1);
                            skd.setRemain(skdRuleItem.getSkLimit());
                            skd.setNoon(1);
                            skd.setStaffId(skdRuleItem.getStaffId());
                            skd.setDeptId(skdRule.getDeptId());
                            skd.setSmsSkdRuleId(skdRule.getId());
                            skd.setSkLimit(skdRuleItem.getSkLimit());
                            //判断另一个午别有没有排班
                            if (split[8].equals("0")) {
                                this.baseMapper.delete(new LambdaQueryWrapper<Skd>()
                                        .eq(Skd::getDate, s).and(w -> {
                                            w.eq(Skd::getStaffId, skdRuleItem.getStaffId())
                                                    .and(w2 -> {
                                                        w2.eq(Skd::getNoon, 0);
                                                    });
                                        }));
                            }
                            Skd skd1 = this.baseMapper.selectOne(new LambdaQueryWrapper<Skd>()
                                    .eq(Skd::getDate, s).and(w -> {
                                        w.eq(Skd::getStaffId, skdRuleItem.getStaffId())
                                                .and(w2 -> {
                                                    w2.eq(Skd::getNoon, 1);
                                                });
                                    }));
                            if (skd1 == null) {
                                count = this.baseMapper.insert(skd);
                                if (count < 1) {
                                    throw new RuntimeException();
                                }
                            }
                        }
                    }
                    //周六
                    if (date == 6) {
                        if (split[10].equals("1")) {
                            Skd skd = new Skd();
                            skd.setDate(dateFormat.parse(s));
                            skd.setStatus(1);
                            skd.setRemain(skdRuleItem.getSkLimit());
                            skd.setNoon(0);
                            skd.setStaffId(skdRuleItem.getStaffId());
                            skd.setDeptId(skdRule.getDeptId());
                            skd.setSmsSkdRuleId(skdRule.getId());
                            skd.setSkLimit(skdRuleItem.getSkLimit());
                            if (split[11].equals("0")) {
                                this.baseMapper.delete(new LambdaQueryWrapper<Skd>()
                                        .eq(Skd::getDate, s).and(w -> {
                                            w.eq(Skd::getStaffId, skdRuleItem.getStaffId())
                                                    .and(w2 -> {
                                                        w2.eq(Skd::getNoon, 0);
                                                    });
                                        }));
                            }
                            Skd skd1 = this.baseMapper.selectOne(new LambdaQueryWrapper<Skd>()
                                    .eq(Skd::getDate, s).and(w -> {
                                        w.eq(Skd::getStaffId, skdRuleItem.getStaffId())
                                                .and(w2 -> {
                                                    w2.eq(Skd::getNoon, 0);
                                                });
                                    }));
                            if (skd1 == null) {
                                count = this.baseMapper.insert(skd);
                                if (count < 1) {
                                    throw new RuntimeException();
                                }
                            }

                        }

                        if (split[11].equals("1")) {
                            Skd skd = new Skd();
                            skd.setDate(dateFormat.parse(s));
                            skd.setStatus(1);
                            skd.setRemain(skdRuleItem.getSkLimit());
                            skd.setNoon(1);
                            skd.setStaffId(skdRuleItem.getStaffId());
                            skd.setDeptId(skdRule.getDeptId());
                            skd.setSmsSkdRuleId(skdRule.getId());
                            skd.setSkLimit(skdRuleItem.getSkLimit());
                            //判断另一个午别有没有排班
                            if (split[10].equals("0")) {
                                this.baseMapper.delete(new LambdaQueryWrapper<Skd>()
                                        .eq(Skd::getDate, s).and(w -> {
                                            w.eq(Skd::getStaffId, skdRuleItem.getStaffId())
                                                    .and(w2 -> {
                                                        w2.eq(Skd::getNoon, 0);
                                                    });
                                        }));
                            }
                            Skd skd1 = this.baseMapper.selectOne(new LambdaQueryWrapper<Skd>()
                                    .eq(Skd::getDate, s).and(w -> {
                                        w.eq(Skd::getStaffId, skdRuleItem.getStaffId())
                                                .and(w2 -> {
                                                    w2.eq(Skd::getNoon, 1);
                                                });
                                    }));
                            if (skd1 == null) {
                                count = this.baseMapper.insert(skd);
                                if (count < 1) {
                                    throw new RuntimeException();
                                }
                            }
                        }
                    }
                    //周日
                    if (date == 0) {
                        if (split[12].equals("1")) {
                            Skd skd = new Skd();
                            skd.setDate(dateFormat.parse(s));
                            skd.setStatus(1);
                            skd.setRemain(skdRuleItem.getSkLimit());
                            skd.setNoon(0);
                            skd.setStaffId(skdRuleItem.getStaffId());
                            skd.setDeptId(skdRule.getDeptId());
                            skd.setSmsSkdRuleId(skdRule.getId());
                            skd.setSkLimit(skdRuleItem.getSkLimit());
                            if (split[13].equals("0")) {
                                this.baseMapper.delete(new LambdaQueryWrapper<Skd>()
                                        .eq(Skd::getDate, s).and(w -> {
                                            w.eq(Skd::getStaffId, skdRuleItem.getStaffId())
                                                    .and(w2 -> {
                                                        w2.eq(Skd::getNoon, 0);
                                                    });
                                        }));
                            }
                            Skd skd1 = this.baseMapper.selectOne(new LambdaQueryWrapper<Skd>()
                                    .eq(Skd::getDate, s).and(w -> {
                                        w.eq(Skd::getStaffId, skdRuleItem.getStaffId())
                                                .and(w2 -> {
                                                    w2.eq(Skd::getNoon, 0);
                                                });
                                    }));
                            if (skd1 == null) {
                                count = this.baseMapper.insert(skd);
                                if (count < 1) {
                                    throw new RuntimeException();
                                }
                            }

                        }

                        if (split[13].equals("1")) {
                            Skd skd = new Skd();
                            skd.setDate(dateFormat.parse(s));
                            skd.setStatus(1);
                            skd.setRemain(skdRuleItem.getSkLimit());
                            skd.setNoon(1);
                            skd.setStaffId(skdRuleItem.getStaffId());
                            skd.setDeptId(skdRule.getDeptId());
                            skd.setSmsSkdRuleId(skdRule.getId());
                            skd.setSkLimit(skdRuleItem.getSkLimit());
                            //判断另一个午别有没有排班
                            if (split[12].equals("0")) {
                                this.baseMapper.delete(new LambdaQueryWrapper<Skd>()
                                        .eq(Skd::getDate, s).and(w -> {
                                            w.eq(Skd::getStaffId, skdRuleItem.getStaffId())
                                                    .and(w2 -> {
                                                        w2.eq(Skd::getNoon, 0);
                                                    });
                                        }));
                            }
                            Skd skd1 = this.baseMapper.selectOne(new LambdaQueryWrapper<Skd>()
                                    .eq(Skd::getDate, s).and(w -> {
                                        w.eq(Skd::getStaffId, skdRuleItem.getStaffId())
                                                .and(w2 -> {
                                                    w2.eq(Skd::getNoon, 1);
                                                });
                                    }));
                            if (skd1 == null) {
                                count = this.baseMapper.insert(skd);
                                if (count < 1) {
                                    throw new RuntimeException();
                                }
                            }
                        }
                    }
                }
            }
        }
        return count;
    }

}