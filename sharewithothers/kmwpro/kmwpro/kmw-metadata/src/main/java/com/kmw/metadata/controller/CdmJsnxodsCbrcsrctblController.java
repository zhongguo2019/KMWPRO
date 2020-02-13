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
import com.kmw.metadata.domain.CdmJsnxodsCbrcsrctbl;
import com.kmw.metadata.service.ICdmJsnxodsCbrcsrctblService;
import com.kmw.common.core.controller.BaseController;
import com.kmw.common.core.domain.AjaxResult;
import com.kmw.common.utils.poi.ExcelUtil;
import com.kmw.common.core.page.TableDataInfo;

/**
 * 银监报送报来源分析Controller
 * 
 * @author kmw
 * @date 2020-02-07
 */
@Controller
@RequestMapping("/metadata/cbrcsrctbl")
public class CdmJsnxodsCbrcsrctblController extends BaseController
{
    private String prefix = "metadata/cbrcsrctbl";

    @Autowired
    private ICdmJsnxodsCbrcsrctblService cdmJsnxodsCbrcsrctblService;

    @RequiresPermissions("metadata:cbrcsrctbl:view")
    @GetMapping()
    public String cbrcsrctbl()
    {
        return prefix + "/cbrcsrctbl";
    }

    /**
     * 查询银监报送报来源分析列表
     */
    @RequiresPermissions("metadata:cbrcsrctbl:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CdmJsnxodsCbrcsrctbl cdmJsnxodsCbrcsrctbl)
    {
        startPage();
        List<CdmJsnxodsCbrcsrctbl> list = cdmJsnxodsCbrcsrctblService.selectCdmJsnxodsCbrcsrctblList(cdmJsnxodsCbrcsrctbl);
        return getDataTable(list);
    }

    /**
     * 导出银监报送报来源分析列表
     */
    @RequiresPermissions("metadata:cbrcsrctbl:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CdmJsnxodsCbrcsrctbl cdmJsnxodsCbrcsrctbl)
    {
        List<CdmJsnxodsCbrcsrctbl> list = cdmJsnxodsCbrcsrctblService.selectCdmJsnxodsCbrcsrctblList(cdmJsnxodsCbrcsrctbl);
        ExcelUtil<CdmJsnxodsCbrcsrctbl> util = new ExcelUtil<CdmJsnxodsCbrcsrctbl>(CdmJsnxodsCbrcsrctbl.class);
        return util.exportExcel(list, "cbrcsrctbl");
    }

    /**
     * 新增银监报送报来源分析
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存银监报送报来源分析
     */
    @RequiresPermissions("metadata:cbrcsrctbl:add")
    @Log(title = "银监报送报来源分析", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CdmJsnxodsCbrcsrctbl cdmJsnxodsCbrcsrctbl)
    {
        return toAjax(cdmJsnxodsCbrcsrctblService.insertCdmJsnxodsCbrcsrctbl(cdmJsnxodsCbrcsrctbl));
    }

    /**
     * 修改银监报送报来源分析
     */
    @GetMapping("/edit/{orderno}")
    public String edit(@PathVariable("orderno") Long orderno, ModelMap mmap)
    {
        CdmJsnxodsCbrcsrctbl cdmJsnxodsCbrcsrctbl = cdmJsnxodsCbrcsrctblService.selectCdmJsnxodsCbrcsrctblById(orderno);
        mmap.put("cdmJsnxodsCbrcsrctbl", cdmJsnxodsCbrcsrctbl);
        return prefix + "/edit";
    }

    /**
     * 修改保存银监报送报来源分析
     */
    @RequiresPermissions("metadata:cbrcsrctbl:edit")
    @Log(title = "银监报送报来源分析", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CdmJsnxodsCbrcsrctbl cdmJsnxodsCbrcsrctbl)
    {
        return toAjax(cdmJsnxodsCbrcsrctblService.updateCdmJsnxodsCbrcsrctbl(cdmJsnxodsCbrcsrctbl));
    }

    /**
     * 删除银监报送报来源分析
     */
    @RequiresPermissions("metadata:cbrcsrctbl:remove")
    @Log(title = "银监报送报来源分析", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(cdmJsnxodsCbrcsrctblService.deleteCdmJsnxodsCbrcsrctblByIds(ids));
    }
}
