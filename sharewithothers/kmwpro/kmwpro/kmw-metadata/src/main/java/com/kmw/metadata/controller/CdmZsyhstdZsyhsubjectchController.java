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
import com.kmw.metadata.domain.CdmZsyhstdZsyhsubjectch;
import com.kmw.metadata.service.ICdmZsyhstdZsyhsubjectchService;
import com.kmw.common.core.controller.BaseController;
import com.kmw.common.core.domain.AjaxResult;
import com.kmw.common.utils.poi.ExcelUtil;
import com.kmw.common.core.page.TableDataInfo;

/**
 * 数据标准渠道主题Controller
 * 
 * @author kmw
 * @date 2020-02-13
 */
@Controller
@RequestMapping("/metadata/zsyhsubjectch")
public class CdmZsyhstdZsyhsubjectchController extends BaseController
{
    private String prefix = "metadata/zsyhsubjectch";

    @Autowired
    private ICdmZsyhstdZsyhsubjectchService cdmZsyhstdZsyhsubjectchService;

    @RequiresPermissions("metadata:zsyhsubjectch:view")
    @GetMapping()
    public String zsyhsubjectch()
    {
        return prefix + "/zsyhsubjectch";
    }

    /**
     * 查询数据标准渠道主题列表
     */
    @RequiresPermissions("metadata:zsyhsubjectch:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CdmZsyhstdZsyhsubjectch cdmZsyhstdZsyhsubjectch)
    {
        startPage();
        List<CdmZsyhstdZsyhsubjectch> list = cdmZsyhstdZsyhsubjectchService.selectCdmZsyhstdZsyhsubjectchList(cdmZsyhstdZsyhsubjectch);
        return getDataTable(list);
    }

    /**
     * 导出数据标准渠道主题列表
     */
    @RequiresPermissions("metadata:zsyhsubjectch:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CdmZsyhstdZsyhsubjectch cdmZsyhstdZsyhsubjectch)
    {
        List<CdmZsyhstdZsyhsubjectch> list = cdmZsyhstdZsyhsubjectchService.selectCdmZsyhstdZsyhsubjectchList(cdmZsyhstdZsyhsubjectch);
        ExcelUtil<CdmZsyhstdZsyhsubjectch> util = new ExcelUtil<CdmZsyhstdZsyhsubjectch>(CdmZsyhstdZsyhsubjectch.class);
        return util.exportExcel(list, "zsyhsubjectch");
    }

    /**
     * 新增数据标准渠道主题
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存数据标准渠道主题
     */
    @RequiresPermissions("metadata:zsyhsubjectch:add")
    @Log(title = "数据标准渠道主题", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CdmZsyhstdZsyhsubjectch cdmZsyhstdZsyhsubjectch)
    {
        return toAjax(cdmZsyhstdZsyhsubjectchService.insertCdmZsyhstdZsyhsubjectch(cdmZsyhstdZsyhsubjectch));
    }

    /**
     * 修改数据标准渠道主题
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        CdmZsyhstdZsyhsubjectch cdmZsyhstdZsyhsubjectch = cdmZsyhstdZsyhsubjectchService.selectCdmZsyhstdZsyhsubjectchById(id);
        mmap.put("cdmZsyhstdZsyhsubjectch", cdmZsyhstdZsyhsubjectch);
        return prefix + "/edit";
    }

    /**
     * 修改保存数据标准渠道主题
     */
    @RequiresPermissions("metadata:zsyhsubjectch:edit")
    @Log(title = "数据标准渠道主题", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CdmZsyhstdZsyhsubjectch cdmZsyhstdZsyhsubjectch)
    {
        return toAjax(cdmZsyhstdZsyhsubjectchService.updateCdmZsyhstdZsyhsubjectch(cdmZsyhstdZsyhsubjectch));
    }

    /**
     * 删除数据标准渠道主题
     */
    @RequiresPermissions("metadata:zsyhsubjectch:remove")
    @Log(title = "数据标准渠道主题", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(cdmZsyhstdZsyhsubjectchService.deleteCdmZsyhstdZsyhsubjectchByIds(ids));
    }
}
