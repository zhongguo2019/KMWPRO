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
import com.kmw.metadata.domain.CdmJsnxodsDictionary;
import com.kmw.metadata.domain.CdmJsnxodsTableall;
import com.kmw.metadata.service.ICdmJsnxodsDictionaryService;
import com.kmw.metadata.service.ICdmJsnxodsTableallService;
import com.kmw.common.core.controller.BaseController;
import com.kmw.common.core.domain.AjaxResult;
import com.kmw.common.utils.poi.ExcelUtil;
import com.kmw.common.core.page.TableDataInfo;

/**
 * ODS列Controller
 * 
 * @author kmw
 * @date 2020-02-06
 */
@Controller
@RequestMapping("/metadata/tableall")
public class CdmJsnxodsTableallController extends BaseController
{
    private String prefix = "metadata/tableall";

    @Autowired
    private ICdmJsnxodsTableallService cdmJsnxodsTableallService;
    
    @Autowired
    private ICdmJsnxodsDictionaryService cdmJsnxodsDictionaryService;

    @RequiresPermissions("metadata:tableall:view")
    @GetMapping()
    public String tableall()
    {
        return prefix + "/tableall";
    }

    /**
     * 查询ODS列列表
     */
    @RequiresPermissions("metadata:tableall:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CdmJsnxodsTableall cdmJsnxodsTableall)
    {
        startPage();
        List<CdmJsnxodsTableall> list = cdmJsnxodsTableallService.selectCdmJsnxodsTableallList(cdmJsnxodsTableall);
        return getDataTable(list);
    }

    /**
     * 导出ODS列列表
     */
    @RequiresPermissions("metadata:tableall:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CdmJsnxodsTableall cdmJsnxodsTableall)
    {
        List<CdmJsnxodsTableall> list = cdmJsnxodsTableallService.selectCdmJsnxodsTableallList(cdmJsnxodsTableall);
        ExcelUtil<CdmJsnxodsTableall> util = new ExcelUtil<CdmJsnxodsTableall>(CdmJsnxodsTableall.class);
        return util.exportExcel(list, "tableall");
    }

    /**
     * 新增ODS列
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存ODS列
     */
    @RequiresPermissions("metadata:tableall:add")
    @Log(title = "ODS列", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CdmJsnxodsTableall cdmJsnxodsTableall)
    {
        return toAjax(cdmJsnxodsTableallService.insertCdmJsnxodsTableall(cdmJsnxodsTableall));
    }

    /**
     * 修改ODS列
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        CdmJsnxodsTableall cdmJsnxodsTableall = cdmJsnxodsTableallService.selectCdmJsnxodsTableallById(id);
        mmap.put("cdmJsnxodsTableall", cdmJsnxodsTableall);
        return prefix + "/edit";
    }

    /**
     * 修改保存ODS列
     */
    @RequiresPermissions("metadata:tableall:edit")
    @Log(title = "ODS列", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CdmJsnxodsTableall cdmJsnxodsTableall)
    {
        return toAjax(cdmJsnxodsTableallService.updateCdmJsnxodsTableall(cdmJsnxodsTableall));
    }

    /**
     * 删除ODS列
     */
    @RequiresPermissions("metadata:tableall:remove")
    @Log(title = "ODS列", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(cdmJsnxodsTableallService.deleteCdmJsnxodsTableallByIds(ids));
    }
    
    /**
     * 查看详细
     */
    @GetMapping("/detail/{tblEnname}")

    public String detail(@PathVariable("tblEnname") String tblEnname, ModelMap mmap)
    {
      
     
        mmap.put("tblEnname", tblEnname);
        return prefix + "/detail";
    }
    
    /**
     * 查询江苏农信ODS数据字典列表
     */
    @RequiresPermissions("metadata:tableall:listone")
    @PostMapping("/listone/{tblEnname}")
    @ResponseBody
    public TableDataInfo listone(@PathVariable("tblEnname") String tblEnname, ModelMap mmap)
    {
        startPage();
       

        CdmJsnxodsDictionary cdmJsnxodsDictionary = new CdmJsnxodsDictionary ();
        cdmJsnxodsDictionary.setTblEnname(tblEnname);
        List<CdmJsnxodsDictionary> list = cdmJsnxodsDictionaryService.selectCdmJsnxodsDictionaryList(cdmJsnxodsDictionary);
        return getDataTable(list);
    }
}
