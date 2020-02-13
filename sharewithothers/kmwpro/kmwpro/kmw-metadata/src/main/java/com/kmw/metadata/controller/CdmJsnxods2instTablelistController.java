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
import com.kmw.metadata.domain.CdmJsnxods2instTablelist;
import com.kmw.metadata.service.ICdmJsnxods2instTablelistService;
import com.kmw.common.core.controller.BaseController;
import com.kmw.common.core.domain.AjaxResult;
import com.kmw.common.utils.poi.ExcelUtil;
import com.kmw.common.core.page.TableDataInfo;

/**
 * 江苏农信省联社给各法人下发的数据库Controller
 * 
 * @author kmw
 * @date 2020-02-06
 */
@Controller
@RequestMapping("/metadata/tablelist")
public class CdmJsnxods2instTablelistController extends BaseController
{
    private String prefix = "metadata/tablelist";

    @Autowired
    private ICdmJsnxods2instTablelistService cdmJsnxods2instTablelistService;

    @RequiresPermissions("metadata:tablelist:view")
    @GetMapping()
    public String tablelist()
    {
        return prefix + "/tablelist";
    }

    /**
     * 查询江苏农信省联社给各法人下发的数据库列表
     */
    @RequiresPermissions("metadata:tablelist:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CdmJsnxods2instTablelist cdmJsnxods2instTablelist)
    {
        startPage();
        List<CdmJsnxods2instTablelist> list = cdmJsnxods2instTablelistService.selectCdmJsnxods2instTablelistList(cdmJsnxods2instTablelist);
        return getDataTable(list);
    }

    /**
     * 导出江苏农信省联社给各法人下发的数据库列表
     */
    @RequiresPermissions("metadata:tablelist:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CdmJsnxods2instTablelist cdmJsnxods2instTablelist)
    {
        List<CdmJsnxods2instTablelist> list = cdmJsnxods2instTablelistService.selectCdmJsnxods2instTablelistList(cdmJsnxods2instTablelist);
        ExcelUtil<CdmJsnxods2instTablelist> util = new ExcelUtil<CdmJsnxods2instTablelist>(CdmJsnxods2instTablelist.class);
        return util.exportExcel(list, "tablelist");
    }

    /**
     * 新增江苏农信省联社给各法人下发的数据库
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存江苏农信省联社给各法人下发的数据库
     */
    @RequiresPermissions("metadata:tablelist:add")
    @Log(title = "江苏农信省联社给各法人下发的数据库", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CdmJsnxods2instTablelist cdmJsnxods2instTablelist)
    {
        return toAjax(cdmJsnxods2instTablelistService.insertCdmJsnxods2instTablelist(cdmJsnxods2instTablelist));
    }

    /**
     * 修改江苏农信省联社给各法人下发的数据库
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        CdmJsnxods2instTablelist cdmJsnxods2instTablelist = cdmJsnxods2instTablelistService.selectCdmJsnxods2instTablelistById(id);
        mmap.put("cdmJsnxods2instTablelist", cdmJsnxods2instTablelist);
        return prefix + "/edit";
    }

    /**
     * 修改保存江苏农信省联社给各法人下发的数据库
     */
    @RequiresPermissions("metadata:tablelist:edit")
    @Log(title = "江苏农信省联社给各法人下发的数据库", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CdmJsnxods2instTablelist cdmJsnxods2instTablelist)
    {
        return toAjax(cdmJsnxods2instTablelistService.updateCdmJsnxods2instTablelist(cdmJsnxods2instTablelist));
    }

    /**
     * 删除江苏农信省联社给各法人下发的数据库
     */
    @RequiresPermissions("metadata:tablelist:remove")
    @Log(title = "江苏农信省联社给各法人下发的数据库", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(cdmJsnxods2instTablelistService.deleteCdmJsnxods2instTablelistByIds(ids));
    }
}
