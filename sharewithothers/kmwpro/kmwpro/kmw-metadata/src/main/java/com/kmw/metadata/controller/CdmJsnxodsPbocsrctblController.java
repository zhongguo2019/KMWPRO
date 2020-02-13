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
import com.kmw.metadata.domain.CdmJsnxodsPbocsrctbl;
import com.kmw.metadata.service.ICdmJsnxodsPbocsrctblService;
import com.kmw.common.core.controller.BaseController;
import com.kmw.common.core.domain.AjaxResult;
import com.kmw.common.utils.poi.ExcelUtil;
import com.kmw.common.core.page.TableDataInfo;

/**
 * 人行报送报来源分析Controller
 * 
 * @author kmw
 * @date 2020-02-07
 */
@Controller
@RequestMapping("/metadata/pbocsrctbl")
public class CdmJsnxodsPbocsrctblController extends BaseController
{
    private String prefix = "metadata/pbocsrctbl";

    @Autowired
    private ICdmJsnxodsPbocsrctblService cdmJsnxodsPbocsrctblService;

    @RequiresPermissions("metadata:pbocsrctbl:view")
    @GetMapping()
    public String pbocsrctbl()
    {
        return prefix + "/pbocsrctbl";
    }

    /**
     * 查询人行报送报来源分析列表
     */
    @RequiresPermissions("metadata:pbocsrctbl:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CdmJsnxodsPbocsrctbl cdmJsnxodsPbocsrctbl)
    {
        startPage();
        List<CdmJsnxodsPbocsrctbl> list = cdmJsnxodsPbocsrctblService.selectCdmJsnxodsPbocsrctblList(cdmJsnxodsPbocsrctbl);
        return getDataTable(list);
    }

    /**
     * 导出人行报送报来源分析列表
     */
    @RequiresPermissions("metadata:pbocsrctbl:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CdmJsnxodsPbocsrctbl cdmJsnxodsPbocsrctbl)
    {
        List<CdmJsnxodsPbocsrctbl> list = cdmJsnxodsPbocsrctblService.selectCdmJsnxodsPbocsrctblList(cdmJsnxodsPbocsrctbl);
        ExcelUtil<CdmJsnxodsPbocsrctbl> util = new ExcelUtil<CdmJsnxodsPbocsrctbl>(CdmJsnxodsPbocsrctbl.class);
        return util.exportExcel(list, "pbocsrctbl");
    }

    /**
     * 新增人行报送报来源分析
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存人行报送报来源分析
     */
    @RequiresPermissions("metadata:pbocsrctbl:add")
    @Log(title = "人行报送报来源分析", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CdmJsnxodsPbocsrctbl cdmJsnxodsPbocsrctbl)
    {
        return toAjax(cdmJsnxodsPbocsrctblService.insertCdmJsnxodsPbocsrctbl(cdmJsnxodsPbocsrctbl));
    }

    /**
     * 修改人行报送报来源分析
     */
    @GetMapping("/edit/{orderno}")
    public String edit(@PathVariable("orderno") Long orderno, ModelMap mmap)
    {
        CdmJsnxodsPbocsrctbl cdmJsnxodsPbocsrctbl = cdmJsnxodsPbocsrctblService.selectCdmJsnxodsPbocsrctblById(orderno);
        mmap.put("cdmJsnxodsPbocsrctbl", cdmJsnxodsPbocsrctbl);
        return prefix + "/edit";
    }

    /**
     * 修改保存人行报送报来源分析
     */
    @RequiresPermissions("metadata:pbocsrctbl:edit")
    @Log(title = "人行报送报来源分析", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CdmJsnxodsPbocsrctbl cdmJsnxodsPbocsrctbl)
    {
        return toAjax(cdmJsnxodsPbocsrctblService.updateCdmJsnxodsPbocsrctbl(cdmJsnxodsPbocsrctbl));
    }

    /**
     * 删除人行报送报来源分析
     */
    @RequiresPermissions("metadata:pbocsrctbl:remove")
    @Log(title = "人行报送报来源分析", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(cdmJsnxodsPbocsrctblService.deleteCdmJsnxodsPbocsrctblByIds(ids));
    }
}
