package com.ruoyi.system.domain.vo;

/**
 * @author ruanTeng
 * @version 1.0
 * @date 2021/3/2 13:53
 */

import com.ruoyi.common.core.domain.entity.SysDept;
import org.apache.poi.ss.formula.functions.T;

import java.util.List;

/**
 * 树状部门
 */
public class SysDeptTreeVo {

    private Long id;

    private String label;

    public List<SysDeptTreeVo> getChildren() {
        return children;
    }

    public void setChildren(List<SysDeptTreeVo> children) {
        this.children = children;
    }

    private List<SysDeptTreeVo> children;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }


}
