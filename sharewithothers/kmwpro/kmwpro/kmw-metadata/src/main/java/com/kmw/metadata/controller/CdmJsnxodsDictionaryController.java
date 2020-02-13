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
import com.kmw.metadata.service.ICdmJsnxodsDictionaryService;
import com.kmw.common.core.controller.BaseController;
import com.kmw.common.core.domain.AjaxResult;
import com.kmw.common.utils.poi.ExcelUtil;
import com.kmw.common.core.page.TableDataInfo;

/**
 * 江苏农信ODS数据字典Controller
 * 
 * @author kmw
 * @date 2020-02-06
 */
@Controller
@RequestMapping("/metadata/dictionary")
public class CdmJsnxodsDictionaryController extends BaseController
{
    private String prefix = "metadata/dictionary";

    @Autowired
    private ICdmJsnxodsDictionaryService cdmJsnxodsDictionaryService;

    @RequiresPermissions("metadata:dictionary:view")
    @GetMapping()
    public String dictionary()
    {
        return prefix + "/dictionary";
    }

    /**
     * 查询江苏农信ODS数据字典列表
     */
    @RequiresPermissions("metadata:dictionary:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CdmJsnxodsDictionary cdmJsnxodsDictionary)
    {
        startPage();
        List<CdmJsnxodsDictionary> list = cdmJsnxodsDictionaryService.selectCdmJsnxodsDictionaryList(cdmJsnxodsDictionary);
        return getDataTable(list);
    }

    /**
     * 导出江苏农信ODS数据字典列表
     */
    @RequiresPermissions("metadata:dictionary:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CdmJsnxodsDictionary cdmJsnxodsDictionary)
    {
        List<CdmJsnxodsDictionary> list = cdmJsnxodsDictionaryService.selectCdmJsnxodsDictionaryList(cdmJsnxodsDictionary);
        ExcelUtil<CdmJsnxodsDictionary> util = new ExcelUtil<CdmJsnxodsDictionary>(CdmJsnxodsDictionary.class);
        return util.exportExcel(list, "dictionary");
    }

    /**
     * 新增江苏农信ODS数据字典
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存江苏农信ODS数据字典
     */
    @RequiresPermissions("metadata:dictionary:add")
    @Log(title = "江苏农信ODS数据字典", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CdmJsnxodsDictionary cdmJsnxodsDictionary)
    {
        return toAjax(cdmJsnxodsDictionaryService.insertCdmJsnxodsDictionary(cdmJsnxodsDictionary));
    }

    /**
     * 修改江苏农信ODS数据字典
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap)
    {
        CdmJsnxodsDictionary cdmJsnxodsDictionary = cdmJsnxodsDictionaryService.selectCdmJsnxodsDictionaryById(id);
        mmap.put("cdmJsnxodsDictionary", cdmJsnxodsDictionary);
        return prefix + "/edit";
    }
    
    /**
     * 查询江苏农信ODS数据字典列表
     */
    @RequiresPermissions("metadata:dictionary:listone")
    @PostMapping("/listone")
    @ResponseBody
    public TableDataInfo listone(@PathVariable("tblEnname") String tblEnname,CdmJsnxodsDictionary cdmJsnxodsDictionary)
    {
        startPage();
        List<CdmJsnxodsDictionary> list = cdmJsnxodsDictionaryService.selectCdmJsnxodsDictionaryList(cdmJsnxodsDictionary);
        return getDataTable(list);
    }
    /**
     * 修改保存江苏农信ODS数据字典
     */
    @RequiresPermissions("metadata:dictionary:edit")
    @Log(title = "江苏农信ODS数据字典", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CdmJsnxodsDictionary cdmJsnxodsDictionary)
    {
        return toAjax(cdmJsnxodsDictionaryService.updateCdmJsnxodsDictionary(cdmJsnxodsDictionary));
    }

    /**
     * 删除江苏农信ODS数据字典
     */
    @RequiresPermissions("metadata:dictionary:remove")
    @Log(title = "江苏农信ODS数据字典", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(cdmJsnxodsDictionaryService.deleteCdmJsnxodsDictionaryByIds(ids));
    }
}
