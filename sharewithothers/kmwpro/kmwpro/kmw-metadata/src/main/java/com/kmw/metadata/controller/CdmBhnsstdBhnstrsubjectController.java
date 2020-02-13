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
import com.kmw.metadata.domain.CdmBhnsstdBhnstrsubject;
import com.kmw.metadata.service.ICdmBhnsstdBhnstrsubjectService;
import com.kmw.common.core.controller.BaseController;
import com.kmw.common.core.domain.AjaxResult;
import com.kmw.common.utils.poi.ExcelUtil;
import com.kmw.common.core.page.TableDataInfo;

/**
 * 事件主题Controller
 * 
 * @author kmw
 * @date 2020-02-07
 */
@Controller
@RequestMapping("/metadata/bhnstrsubject")
public class CdmBhnsstdBhnstrsubjectController extends BaseController
{
    private String prefix = "metadata/bhnstrsubject";

    @Autowired
    private ICdmBhnsstdBhnstrsubjectService cdmBhnsstdBhnstrsubjectService;

    @RequiresPermissions("metadata:bhnstrsubject:view")
    @GetMapping()
    public String bhnstrsubject()
    {
        return prefix + "/bhnstrsubject";
    }

    /**
     * 查询事件主题列表
     */
    @RequiresPermissions("metadata:bhnstrsubject:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CdmBhnsstdBhnstrsubject cdmBhnsstdBhnstrsubject)
    {
        startPage();
        List<CdmBhnsstdBhnstrsubject> list = cdmBhnsstdBhnstrsubjectService.selectCdmBhnsstdBhnstrsubjectList(cdmBhnsstdBhnstrsubject);
        return getDataTable(list);
    }

    /**
     * 导出事件主题列表
     */
    @RequiresPermissions("metadata:bhnstrsubject:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CdmBhnsstdBhnstrsubject cdmBhnsstdBhnstrsubject)
    {
        List<CdmBhnsstdBhnstrsubject> list = cdmBhnsstdBhnstrsubjectService.selectCdmBhnsstdBhnstrsubjectList(cdmBhnsstdBhnstrsubject);
        ExcelUtil<CdmBhnsstdBhnstrsubject> util = new ExcelUtil<CdmBhnsstdBhnstrsubject>(CdmBhnsstdBhnstrsubject.class);
        return util.exportExcel(list, "bhnstrsubject");
    }

    /**
     * 新增事件主题
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存事件主题
     */
    @RequiresPermissions("metadata:bhnstrsubject:add")
    @Log(title = "事件主题", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CdmBhnsstdBhnstrsubject cdmBhnsstdBhnstrsubject)
    {
        return toAjax(cdmBhnsstdBhnstrsubjectService.insertCdmBhnsstdBhnstrsubject(cdmBhnsstdBhnstrsubject));
    }

    /**
     * 修改事件主题
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        CdmBhnsstdBhnstrsubject cdmBhnsstdBhnstrsubject = cdmBhnsstdBhnstrsubjectService.selectCdmBhnsstdBhnstrsubjectById(id);
        mmap.put("cdmBhnsstdBhnstrsubject", cdmBhnsstdBhnstrsubject);
        return prefix + "/edit";
    }

    /**
     * 修改保存事件主题
     */
    @RequiresPermissions("metadata:bhnstrsubject:edit")
    @Log(title = "事件主题", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CdmBhnsstdBhnstrsubject cdmBhnsstdBhnstrsubject)
    {
        return toAjax(cdmBhnsstdBhnstrsubjectService.updateCdmBhnsstdBhnstrsubject(cdmBhnsstdBhnstrsubject));
    }

    /**
     * 删除事件主题
     */
    @RequiresPermissions("metadata:bhnstrsubject:remove")
    @Log(title = "事件主题", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(cdmBhnsstdBhnstrsubjectService.deleteCdmBhnsstdBhnstrsubjectByIds(ids));
    }
}
