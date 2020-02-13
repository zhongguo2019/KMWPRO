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
import com.kmw.metadata.domain.CdmBhnsstdBhnspdsubject;
import com.kmw.metadata.service.ICdmBhnsstdBhnspdsubjectService;
import com.kmw.common.core.controller.BaseController;
import com.kmw.common.core.domain.AjaxResult;
import com.kmw.common.utils.poi.ExcelUtil;
import com.kmw.common.core.page.TableDataInfo;

/**
 * 产品主题Controller
 * 
 * @author kmw
 * @date 2020-02-07
 */
@Controller
@RequestMapping("/metadata/bhnspdsubject")
public class CdmBhnsstdBhnspdsubjectController extends BaseController
{
    private String prefix = "metadata/bhnspdsubject";

    @Autowired
    private ICdmBhnsstdBhnspdsubjectService cdmBhnsstdBhnspdsubjectService;

    @RequiresPermissions("metadata:bhnspdsubject:view")
    @GetMapping()
    public String bhnspdsubject()
    {
        return prefix + "/bhnspdsubject";
    }

    /**
     * 查询产品主题列表
     */
    @RequiresPermissions("metadata:bhnspdsubject:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CdmBhnsstdBhnspdsubject cdmBhnsstdBhnspdsubject)
    {
        startPage();
        List<CdmBhnsstdBhnspdsubject> list = cdmBhnsstdBhnspdsubjectService.selectCdmBhnsstdBhnspdsubjectList(cdmBhnsstdBhnspdsubject);
        return getDataTable(list);
    }

    /**
     * 导出产品主题列表
     */
    @RequiresPermissions("metadata:bhnspdsubject:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CdmBhnsstdBhnspdsubject cdmBhnsstdBhnspdsubject)
    {
        List<CdmBhnsstdBhnspdsubject> list = cdmBhnsstdBhnspdsubjectService.selectCdmBhnsstdBhnspdsubjectList(cdmBhnsstdBhnspdsubject);
        ExcelUtil<CdmBhnsstdBhnspdsubject> util = new ExcelUtil<CdmBhnsstdBhnspdsubject>(CdmBhnsstdBhnspdsubject.class);
        return util.exportExcel(list, "bhnspdsubject");
    }

    /**
     * 新增产品主题
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存产品主题
     */
    @RequiresPermissions("metadata:bhnspdsubject:add")
    @Log(title = "产品主题", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CdmBhnsstdBhnspdsubject cdmBhnsstdBhnspdsubject)
    {
        return toAjax(cdmBhnsstdBhnspdsubjectService.insertCdmBhnsstdBhnspdsubject(cdmBhnsstdBhnspdsubject));
    }

    /**
     * 修改产品主题
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        CdmBhnsstdBhnspdsubject cdmBhnsstdBhnspdsubject = cdmBhnsstdBhnspdsubjectService.selectCdmBhnsstdBhnspdsubjectById(id);
        mmap.put("cdmBhnsstdBhnspdsubject", cdmBhnsstdBhnspdsubject);
        return prefix + "/edit";
    }

    /**
     * 修改保存产品主题
     */
    @RequiresPermissions("metadata:bhnspdsubject:edit")
    @Log(title = "产品主题", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CdmBhnsstdBhnspdsubject cdmBhnsstdBhnspdsubject)
    {
        return toAjax(cdmBhnsstdBhnspdsubjectService.updateCdmBhnsstdBhnspdsubject(cdmBhnsstdBhnspdsubject));
    }

    /**
     * 删除产品主题
     */
    @RequiresPermissions("metadata:bhnspdsubject:remove")
    @Log(title = "产品主题", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(cdmBhnsstdBhnspdsubjectService.deleteCdmBhnsstdBhnspdsubjectByIds(ids));
    }
}
