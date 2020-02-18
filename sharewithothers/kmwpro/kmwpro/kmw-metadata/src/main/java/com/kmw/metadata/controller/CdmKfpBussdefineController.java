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
import com.kmw.metadata.domain.CdmKfpBussdefine;
import com.kmw.metadata.service.ICdmKfpBussdefineService;
import com.kmw.common.core.controller.BaseController;
import com.kmw.common.core.domain.AjaxResult;
import com.kmw.common.utils.poi.ExcelUtil;
import com.kmw.common.core.page.TableDataInfo;

/**
 * 银行束语定义集Controller
 * 
 * @author kmw
 * @date 2020-02-17
 */
@Controller
@RequestMapping("/metadata/bussdefine")
public class CdmKfpBussdefineController extends BaseController
{
    private String prefix = "metadata/bussdefine";

    @Autowired
    private ICdmKfpBussdefineService cdmKfpBussdefineService;

    @RequiresPermissions("metadata:bussdefine:view")
    @GetMapping()
    public String bussdefine()
    {
        return prefix + "/bussdefine";
    }

    /**
     * 查询银行束语定义集列表
     */
    @RequiresPermissions("metadata:bussdefine:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CdmKfpBussdefine cdmKfpBussdefine)
    {
        startPage();
        List<CdmKfpBussdefine> list = cdmKfpBussdefineService.selectCdmKfpBussdefineList(cdmKfpBussdefine);
        return getDataTable(list);
    }

    /**
     * 导出银行束语定义集列表
     */
    @RequiresPermissions("metadata:bussdefine:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CdmKfpBussdefine cdmKfpBussdefine)
    {
        List<CdmKfpBussdefine> list = cdmKfpBussdefineService.selectCdmKfpBussdefineList(cdmKfpBussdefine);
        ExcelUtil<CdmKfpBussdefine> util = new ExcelUtil<CdmKfpBussdefine>(CdmKfpBussdefine.class);
        return util.exportExcel(list, "bussdefine");
    }

    /**
     * 新增银行束语定义集
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存银行束语定义集
     */
    @RequiresPermissions("metadata:bussdefine:add")
    @Log(title = "银行束语定义集", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CdmKfpBussdefine cdmKfpBussdefine)
    {
        return toAjax(cdmKfpBussdefineService.insertCdmKfpBussdefine(cdmKfpBussdefine));
    }

    /**
     * 修改银行束语定义集
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        CdmKfpBussdefine cdmKfpBussdefine = cdmKfpBussdefineService.selectCdmKfpBussdefineById(id);
        mmap.put("cdmKfpBussdefine", cdmKfpBussdefine);
        return prefix + "/edit";
    }

    /**
     * 修改保存银行束语定义集
     */
    @RequiresPermissions("metadata:bussdefine:edit")
    @Log(title = "银行束语定义集", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CdmKfpBussdefine cdmKfpBussdefine)
    {
        return toAjax(cdmKfpBussdefineService.updateCdmKfpBussdefine(cdmKfpBussdefine));
    }

    /**
     * 删除银行束语定义集
     */
    @RequiresPermissions("metadata:bussdefine:remove")
    @Log(title = "银行束语定义集", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(cdmKfpBussdefineService.deleteCdmKfpBussdefineByIds(ids));
    }
}
