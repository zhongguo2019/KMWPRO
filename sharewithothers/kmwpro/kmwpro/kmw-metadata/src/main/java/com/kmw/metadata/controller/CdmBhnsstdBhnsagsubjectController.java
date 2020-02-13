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
import com.kmw.metadata.domain.CdmBhnsstdBhnsagsubject;
import com.kmw.metadata.service.ICdmBhnsstdBhnsagsubjectService;
import com.kmw.common.core.controller.BaseController;
import com.kmw.common.core.domain.AjaxResult;
import com.kmw.common.utils.poi.ExcelUtil;
import com.kmw.common.core.page.TableDataInfo;

/**
 * 协议主题Controller
 * 
 * @author kmw
 * @date 2020-02-07
 */
@Controller
@RequestMapping("/metadata/bhnsagsubject")
public class CdmBhnsstdBhnsagsubjectController extends BaseController
{
    private String prefix = "metadata/bhnsagsubject";

    @Autowired
    private ICdmBhnsstdBhnsagsubjectService cdmBhnsstdBhnsagsubjectService;

    @RequiresPermissions("metadata:bhnsagsubject:view")
    @GetMapping()
    public String bhnsagsubject()
    {
        return prefix + "/bhnsagsubject";
    }

    /**
     * 查询协议主题列表
     */
    @RequiresPermissions("metadata:bhnsagsubject:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CdmBhnsstdBhnsagsubject cdmBhnsstdBhnsagsubject)
    {
        startPage();
        List<CdmBhnsstdBhnsagsubject> list = cdmBhnsstdBhnsagsubjectService.selectCdmBhnsstdBhnsagsubjectList(cdmBhnsstdBhnsagsubject);
        return getDataTable(list);
    }

    /**
     * 导出协议主题列表
     */
    @RequiresPermissions("metadata:bhnsagsubject:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CdmBhnsstdBhnsagsubject cdmBhnsstdBhnsagsubject)
    {
        List<CdmBhnsstdBhnsagsubject> list = cdmBhnsstdBhnsagsubjectService.selectCdmBhnsstdBhnsagsubjectList(cdmBhnsstdBhnsagsubject);
        ExcelUtil<CdmBhnsstdBhnsagsubject> util = new ExcelUtil<CdmBhnsstdBhnsagsubject>(CdmBhnsstdBhnsagsubject.class);
        return util.exportExcel(list, "bhnsagsubject");
    }

    /**
     * 新增协议主题
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存协议主题
     */
    @RequiresPermissions("metadata:bhnsagsubject:add")
    @Log(title = "协议主题", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CdmBhnsstdBhnsagsubject cdmBhnsstdBhnsagsubject)
    {
        return toAjax(cdmBhnsstdBhnsagsubjectService.insertCdmBhnsstdBhnsagsubject(cdmBhnsstdBhnsagsubject));
    }

    /**
     * 修改协议主题
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        CdmBhnsstdBhnsagsubject cdmBhnsstdBhnsagsubject = cdmBhnsstdBhnsagsubjectService.selectCdmBhnsstdBhnsagsubjectById(id);
        mmap.put("cdmBhnsstdBhnsagsubject", cdmBhnsstdBhnsagsubject);
        return prefix + "/edit";
    }

    /**
     * 修改保存协议主题
     */
    @RequiresPermissions("metadata:bhnsagsubject:edit")
    @Log(title = "协议主题", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CdmBhnsstdBhnsagsubject cdmBhnsstdBhnsagsubject)
    {
        return toAjax(cdmBhnsstdBhnsagsubjectService.updateCdmBhnsstdBhnsagsubject(cdmBhnsstdBhnsagsubject));
    }

    /**
     * 删除协议主题
     */
    @RequiresPermissions("metadata:bhnsagsubject:remove")
    @Log(title = "协议主题", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(cdmBhnsstdBhnsagsubjectService.deleteCdmBhnsstdBhnsagsubjectByIds(ids));
    }
}
