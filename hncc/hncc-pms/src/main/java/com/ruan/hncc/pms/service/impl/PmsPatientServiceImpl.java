package com.ruan.hncc.pms.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruan.hncc.pms.mapper.PmsPatientMapper;
import com.ruan.hncc.pms.domain.PmsPatient;
import com.ruan.hncc.pms.service.IPmsPatientService;

/**
 * 病人基本信息Service业务层处理
 * 
 * @author ruanteng
 * @date 2021-02-24
 */
@Service
public class PmsPatientServiceImpl implements IPmsPatientService 
{
    @Autowired
    private PmsPatientMapper pmsPatientMapper;

    /**
     * 查询病人基本信息
     * 
     * @param id 病人基本信息ID
     * @return 病人基本信息
     */
    @Override
    public PmsPatient selectPmsPatientById(Long id)
    {
        return pmsPatientMapper.selectPmsPatientById(id);
    }

    /**
     * 查询病人基本信息列表
     * 
     * @param pmsPatient 病人基本信息
     * @return 病人基本信息
     */
    @Override
    public List<PmsPatient> selectPmsPatientList(PmsPatient pmsPatient)
    {
        return pmsPatientMapper.selectPmsPatientList(pmsPatient);
    }

    /**
     * 新增病人基本信息
     * 
     * @param pmsPatient 病人基本信息
     * @return 结果
     */
    @Override
    public int insertPmsPatient(PmsPatient pmsPatient)
    {
        return pmsPatientMapper.insertPmsPatient(pmsPatient);
    }

    /**
     * 修改病人基本信息
     * 
     * @param pmsPatient 病人基本信息
     * @return 结果
     */
    @Override
    public int updatePmsPatient(PmsPatient pmsPatient)
    {
        return pmsPatientMapper.updatePmsPatient(pmsPatient);
    }

    /**
     * 批量删除病人基本信息
     * 
     * @param ids 需要删除的病人基本信息ID
     * @return 结果
     */
    @Override
    public int deletePmsPatientByIds(Long[] ids)
    {
        return pmsPatientMapper.deletePmsPatientByIds(ids);
    }

    /**
     * 删除病人基本信息信息
     * 
     * @param id 病人基本信息ID
     * @return 结果
     */
    @Override
    public int deletePmsPatientById(Long id)
    {
        return pmsPatientMapper.deletePmsPatientById(id);
    }
}
