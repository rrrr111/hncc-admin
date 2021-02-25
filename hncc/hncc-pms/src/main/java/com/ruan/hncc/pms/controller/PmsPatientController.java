package com.ruan.hncc.pms.controller;

import java.util.List;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import com.ruan.hncc.pms.domain.PmsPatient;
import com.ruan.hncc.pms.service.IPmsPatientService;
import org.springframework.web.bind.annotation.*;

/**
 * 病人基本信息Controller
 * 
 * @author ruanteng
 * @date 2021-02-24
 */
@RestController
@RequestMapping("/pms/patient")
public class PmsPatientController extends BaseController
{
    @Autowired
    private IPmsPatientService pmsPatientService;

    /**
     * 查询病人基本信息列表
     */
    //@PreAuthorize("@ss.hasPermi('pms:patient:list')")
    @GetMapping("/list")
    public TableDataInfo list(PmsPatient pmsPatient)
    {
        startPage();
        List<PmsPatient> list = pmsPatientService.selectPmsPatientList(pmsPatient);
        return getDataTable(list);
    }

    /**
     * 导出病人基本信息列表
     */
    //@PreAuthorize("@ss.hasPermi('pms:patient:export')")
    //@Log(title = "病人基本信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(PmsPatient pmsPatient)
    {
        List<PmsPatient> list = pmsPatientService.selectPmsPatientList(pmsPatient);
        ExcelUtil<PmsPatient> util = new ExcelUtil<PmsPatient>(PmsPatient.class);
        return util.exportExcel(list, "patient");
    }

    /**
     * 获取病人基本信息详细信息
     */
   // @PreAuthorize("@ss.hasPermi('pms:patient:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(pmsPatientService.selectPmsPatientById(id));
    }

    /**
     * 新增病人基本信息
     */
    //@PreAuthorize("@ss.hasPermi('pms:patient:add')")
    //@Log(title = "病人基本信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PmsPatient pmsPatient)
    {
        return toAjax(pmsPatientService.insertPmsPatient(pmsPatient));
    }

    /**
     * 修改病人基本信息
     */
    //@PreAuthorize("@ss.hasPermi('pms:patient:edit')")
    //@Log(title = "病人基本信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PmsPatient pmsPatient)
    {
        return toAjax(pmsPatientService.updatePmsPatient(pmsPatient));
    }

    /**
     * 删除病人基本信息
     */
    //@PreAuthorize("@ss.hasPermi('pms:patient:remove')")
    //@Log(title = "病人基本信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(pmsPatientService.deletePmsPatientByIds(ids));
    }
}
