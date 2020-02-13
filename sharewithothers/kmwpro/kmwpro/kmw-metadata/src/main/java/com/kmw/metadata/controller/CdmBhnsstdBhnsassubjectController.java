package com.kmw.metadata.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.kmw.common.annotation.Log;
import com.kmw.common.enums.BusinessType;
import com.kmw.metadata.domain.CdmBhnsstdBhnsassubject;
import com.kmw.metadata.service.ICdmBhnsstdBhnsassubjectService;
import com.kmw.common.core.controller.BaseController;
import com.kmw.common.core.domain.AjaxResult;
import com.kmw.common.utils.poi.ExcelUtil;
import com.kmw.common.core.page.TableDataInfo;

/**
 * 资产主题Controller
 * 
 * @author kmw
 * @date 2020-02-07
 */
@Controller
@RequestMapping("/metadata/bhnsassubject")
public class CdmBhnsstdBhnsassubjectController extends BaseController
{
    private String prefix = "metadata/bhnsassubject";

    @Autowired
    private ICdmBhnsstdBhnsassubjectService cdmBhnsstdBhnsassubjectService;

    @RequiresPermissions("metadata:bhnsassubject:view")
    @GetMapping()
    public String bhnsassubject()
    {
        return prefix + "/bhnsassubject";
    }

    /**
     * 查询资产主题列表
     */
    @RequiresPermissions("metadata:bhnsassubject:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CdmBhnsstdBhnsassubject cdmBhnsstdBhnsassubject)
    {
        startPage();
        List<CdmBhnsstdBhnsassubject> list = cdmBhnsstdBhnsassubjectService.selectCdmBhnsstdBhnsassubjectList(cdmBhnsstdBhnsassubject);
        return getDataTable(list);
    }

    /**
     * 导出资产主题列表
     */
    @RequiresPermissions("metadata:bhnsassubject:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CdmBhnsstdBhnsassubject cdmBhnsstdBhnsassubject)
    {
        List<CdmBhnsstdBhnsassubject> list = cdmBhnsstdBhnsassubjectService.selectCdmBhnsstdBhnsassubjectList(cdmBhnsstdBhnsassubject);
        ExcelUtil<CdmBhnsstdBhnsassubject> util = new ExcelUtil<CdmBhnsstdBhnsassubject>(CdmBhnsstdBhnsassubject.class);
        return util.exportExcel(list, "bhnsassubject");
    }

    /**
     * 新增资产主题
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存资产主题
     */
    @RequiresPermissions("metadata:bhnsassubject:add")
    @Log(title = "资产主题", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CdmBhnsstdBhnsassubject cdmBhnsstdBhnsassubject)
    {
        return toAjax(cdmBhnsstdBhnsassubjectService.insertCdmBhnsstdBhnsassubject(cdmBhnsstdBhnsassubject));
    }

    /**
     * 修改资产主题
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        CdmBhnsstdBhnsassubject cdmBhnsstdBhnsassubject = cdmBhnsstdBhnsassubjectService.selectCdmBhnsstdBhnsassubjectById(id);
        mmap.put("cdmBhnsstdBhnsassubject", cdmBhnsstdBhnsassubject);
        return prefix + "/edit";
    }

    /**
     * 修改保存资产主题
     */
    @RequiresPermissions("metadata:bhnsassubject:edit")
    @Log(title = "资产主题", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CdmBhnsstdBhnsassubject cdmBhnsstdBhnsassubject)
    {
        return toAjax(cdmBhnsstdBhnsassubjectService.updateCdmBhnsstdBhnsassubject(cdmBhnsstdBhnsassubject));
    }

    /**
     * 删除资产主题
     */
    @RequiresPermissions("metadata:bhnsassubject:remove")
    @Log(title = "资产主题", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(cdmBhnsstdBhnsassubjectService.deleteCdmBhnsstdBhnsassubjectByIds(ids));
    }
}
