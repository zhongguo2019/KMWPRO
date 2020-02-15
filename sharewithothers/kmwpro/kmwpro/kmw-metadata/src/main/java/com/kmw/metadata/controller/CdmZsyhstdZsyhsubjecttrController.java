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
import com.kmw.metadata.domain.CdmZsyhstdZsyhsubjecttr;
import com.kmw.metadata.service.ICdmZsyhstdZsyhsubjecttrService;
import com.kmw.common.core.controller.BaseController;
import com.kmw.common.core.domain.AjaxResult;
import com.kmw.common.utils.poi.ExcelUtil;
import com.kmw.common.core.page.TableDataInfo;

/**
 * 数据标准事件主题Controller
 * 
 * @author kmw
 * @date 2020-02-13
 */
@Controller
@RequestMapping("/metadata/zsyhsubjecttr")
public class CdmZsyhstdZsyhsubjecttrController extends BaseController
{
    private String prefix = "metadata/zsyhsubjecttr";

    @Autowired
    private ICdmZsyhstdZsyhsubjecttrService cdmZsyhstdZsyhsubjecttrService;

    @RequiresPermissions("metadata:zsyhsubjecttr:view")
    @GetMapping()
    public String zsyhsubjecttr()
    {
        return prefix + "/zsyhsubjecttr";
    }

    /**
     * 查询数据标准事件主题列表
     */
    @RequiresPermissions("metadata:zsyhsubjecttr:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CdmZsyhstdZsyhsubjecttr cdmZsyhstdZsyhsubjecttr)
    {
        startPage();
        List<CdmZsyhstdZsyhsubjecttr> list = cdmZsyhstdZsyhsubjecttrService.selectCdmZsyhstdZsyhsubjecttrList(cdmZsyhstdZsyhsubjecttr);
        return getDataTable(list);
    }

    /**
     * 导出数据标准事件主题列表
     */
    @RequiresPermissions("metadata:zsyhsubjecttr:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CdmZsyhstdZsyhsubjecttr cdmZsyhstdZsyhsubjecttr)
    {
        List<CdmZsyhstdZsyhsubjecttr> list = cdmZsyhstdZsyhsubjecttrService.selectCdmZsyhstdZsyhsubjecttrList(cdmZsyhstdZsyhsubjecttr);
        ExcelUtil<CdmZsyhstdZsyhsubjecttr> util = new ExcelUtil<CdmZsyhstdZsyhsubjecttr>(CdmZsyhstdZsyhsubjecttr.class);
        return util.exportExcel(list, "zsyhsubjecttr");
    }

    /**
     * 新增数据标准事件主题
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存数据标准事件主题
     */
    @RequiresPermissions("metadata:zsyhsubjecttr:add")
    @Log(title = "数据标准事件主题", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CdmZsyhstdZsyhsubjecttr cdmZsyhstdZsyhsubjecttr)
    {
        return toAjax(cdmZsyhstdZsyhsubjecttrService.insertCdmZsyhstdZsyhsubjecttr(cdmZsyhstdZsyhsubjecttr));
    }

    /**
     * 修改数据标准事件主题
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        CdmZsyhstdZsyhsubjecttr cdmZsyhstdZsyhsubjecttr = cdmZsyhstdZsyhsubjecttrService.selectCdmZsyhstdZsyhsubjecttrById(id);
        mmap.put("cdmZsyhstdZsyhsubjecttr", cdmZsyhstdZsyhsubjecttr);
        return prefix + "/edit";
    }

    /**
     * 修改保存数据标准事件主题
     */
    @RequiresPermissions("metadata:zsyhsubjecttr:edit")
    @Log(title = "数据标准事件主题", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CdmZsyhstdZsyhsubjecttr cdmZsyhstdZsyhsubjecttr)
    {
        return toAjax(cdmZsyhstdZsyhsubjecttrService.updateCdmZsyhstdZsyhsubjecttr(cdmZsyhstdZsyhsubjecttr));
    }

    /**
     * 删除数据标准事件主题
     */
    @RequiresPermissions("metadata:zsyhsubjecttr:remove")
    @Log(title = "数据标准事件主题", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(cdmZsyhstdZsyhsubjecttrService.deleteCdmZsyhstdZsyhsubjecttrByIds(ids));
    }
}
