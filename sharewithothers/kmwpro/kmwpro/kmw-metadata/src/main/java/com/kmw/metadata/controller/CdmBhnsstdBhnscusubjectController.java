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
import com.kmw.metadata.domain.CdmBhnsstdBhnscusubject;
import com.kmw.metadata.service.ICdmBhnsstdBhnscusubjectService;
import com.kmw.common.core.controller.BaseController;
import com.kmw.common.core.domain.AjaxResult;
import com.kmw.common.utils.poi.ExcelUtil;
import com.kmw.common.core.page.TableDataInfo;

/**
 * VIEWController
 * 
 * @author kmw
 * @date 2020-02-07
 */
@Controller
@RequestMapping("/metadata/bhnscusubject")
public class CdmBhnsstdBhnscusubjectController extends BaseController
{
    private String prefix = "metadata/bhnscusubject";

    @Autowired
    private ICdmBhnsstdBhnscusubjectService cdmBhnsstdBhnscusubjectService;

    @RequiresPermissions("metadata:bhnscusubject:view")
    @GetMapping()
    public String bhnscusubject()
    {
        return prefix + "/bhnscusubject";
    }

    /**
     * 查询VIEW列表
     */
    @RequiresPermissions("metadata:bhnscusubject:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CdmBhnsstdBhnscusubject cdmBhnsstdBhnscusubject)
    {
        startPage();
        List<CdmBhnsstdBhnscusubject> list = cdmBhnsstdBhnscusubjectService.selectCdmBhnsstdBhnscusubjectList(cdmBhnsstdBhnscusubject);
        return getDataTable(list);
    }

    /**
     * 导出VIEW列表
     */
    @RequiresPermissions("metadata:bhnscusubject:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CdmBhnsstdBhnscusubject cdmBhnsstdBhnscusubject)
    {
        List<CdmBhnsstdBhnscusubject> list = cdmBhnsstdBhnscusubjectService.selectCdmBhnsstdBhnscusubjectList(cdmBhnsstdBhnscusubject);
        ExcelUtil<CdmBhnsstdBhnscusubject> util = new ExcelUtil<CdmBhnsstdBhnscusubject>(CdmBhnsstdBhnscusubject.class);
        return util.exportExcel(list, "bhnscusubject");
    }

    /**
     * 新增VIEW
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存VIEW
     */
    @RequiresPermissions("metadata:bhnscusubject:add")
    @Log(title = "VIEW", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CdmBhnsstdBhnscusubject cdmBhnsstdBhnscusubject)
    {
        return toAjax(cdmBhnsstdBhnscusubjectService.insertCdmBhnsstdBhnscusubject(cdmBhnsstdBhnscusubject));
    }

    /**
     * 修改VIEW
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        CdmBhnsstdBhnscusubject cdmBhnsstdBhnscusubject = cdmBhnsstdBhnscusubjectService.selectCdmBhnsstdBhnscusubjectById(id);
        mmap.put("cdmBhnsstdBhnscusubject", cdmBhnsstdBhnscusubject);
        return prefix + "/edit";
    }

    /**
     * 修改保存VIEW
     */
    @RequiresPermissions("metadata:bhnscusubject:edit")
    @Log(title = "VIEW", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CdmBhnsstdBhnscusubject cdmBhnsstdBhnscusubject)
    {
        return toAjax(cdmBhnsstdBhnscusubjectService.updateCdmBhnsstdBhnscusubject(cdmBhnsstdBhnscusubject));
    }

    /**
     * 删除VIEW
     */
    @RequiresPermissions("metadata:bhnscusubject:remove")
    @Log(title = "VIEW", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(cdmBhnsstdBhnscusubjectService.deleteCdmBhnsstdBhnscusubjectByIds(ids));
    }
}
