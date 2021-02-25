package com.ruan.hncc.pms.service;

import java.util.List;
import com.ruan.hncc.pms.domain.PmsPatient;

/**
 * 病人基本信息Service接口
 * 
 * @author ruanteng
 * @date 2021-02-24
 */
public interface IPmsPatientService 
{
    /**
     * 查询病人基本信息
     * 
     * @param id 病人基本信息ID
     * @return 病人基本信息
     */
    public PmsPatient selectPmsPatientById(Long id);

    /**
     * 查询病人基本信息列表
     * 
     * @param pmsPatient 病人基本信息
     * @return 病人基本信息集合
     */
    public List<PmsPatient> selectPmsPatientList(PmsPatient pmsPatient);

    /**
     * 新增病人基本信息
     * 
     * @param pmsPatient 病人基本信息
     * @return 结果
     */
    public int insertPmsPatient(PmsPatient pmsPatient);

    /**
     * 修改病人基本信息
     * 
     * @param pmsPatient 病人基本信息
     * @return 结果
     */
    public int updatePmsPatient(PmsPatient pmsPatient);

    /**
     * 批量删除病人基本信息
     * 
     * @param ids 需要删除的病人基本信息ID
     * @return 结果
     */
    public int deletePmsPatientByIds(Long[] ids);

    /**
     * 删除病人基本信息信息
     * 
     * @param id 病人基本信息ID
     * @return 结果
     */
    public int deletePmsPatientById(Long id);
}
