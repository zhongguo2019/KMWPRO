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
import com.kmw.metadata.domain.CdmZsyhstdZsyhsubjectcu;
import com.kmw.metadata.service.ICdmZsyhstdZsyhsubjectcuService;
import com.kmw.common.core.controller.BaseController;
import com.kmw.common.core.domain.AjaxResult;
import com.kmw.common.utils.poi.ExcelUtil;
import com.kmw.common.core.page.TableDataInfo;

/**
 * 数据标准客户主题Controller
 * 
 * @author kmw
 * @date 2020-02-13
 */
@Controller
@RequestMapping("/metadata/zsyhsubjectcu")
public class CdmZsyhstdZsyhsubjectcuController extends BaseController
{
    private String prefix = "metadata/zsyhsubjectcu";

    @Autowired
    private ICdmZsyhstdZsyhsubjectcuService cdmZsyhstdZsyhsubjectcuService;

    @RequiresPermissions("metadata:zsyhsubjectcu:view")
    @GetMapping()
    public String zsyhsubjectcu()
    {
        return prefix + "/zsyhsubjectcu";
    }

    /**
     * 查询数据标准客户主题列表
     */
    @RequiresPermissions("metadata:zsyhsubjectcu:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CdmZsyhstdZsyhsubjectcu cdmZsyhstdZsyhsubjectcu)
    {
        startPage();
        List<CdmZsyhstdZsyhsubjectcu> list = cdmZsyhstdZsyhsubjectcuService.selectCdmZsyhstdZsyhsubjectcuList(cdmZsyhstdZsyhsubjectcu);
        return getDataTable(list);
    }

    /**
     * 导出数据标准客户主题列表
     */
    @RequiresPermissions("metadata:zsyhsubjectcu:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CdmZsyhstdZsyhsubjectcu cdmZsyhstdZsyhsubjectcu)
    {
        List<CdmZsyhstdZsyhsubjectcu> list = cdmZsyhstdZsyhsubjectcuService.selectCdmZsyhstdZsyhsubjectcuList(cdmZsyhstdZsyhsubjectcu);
        ExcelUtil<CdmZsyhstdZsyhsubjectcu> util = new ExcelUtil<CdmZsyhstdZsyhsubjectcu>(CdmZsyhstdZsyhsubjectcu.class);
        return util.exportExcel(list, "zsyhsubjectcu");
    }

    /**
     * 新增数据标准客户主题
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存数据标准客户主题
     */
    @RequiresPermissions("metadata:zsyhsubjectcu:add")
    @Log(title = "数据标准客户主题", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CdmZsyhstdZsyhsubjectcu cdmZsyhstdZsyhsubjectcu)
    {
        return toAjax(cdmZsyhstdZsyhsubjectcuService.insertCdmZsyhstdZsyhsubjectcu(cdmZsyhstdZsyhsubjectcu));
    }

    /**
     * 修改数据标准客户主题
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        CdmZsyhstdZsyhsubjectcu cdmZsyhstdZsyhsubjectcu = cdmZsyhstdZsyhsubjectcuService.selectCdmZsyhstdZsyhsubjectcuById(id);
        mmap.put("cdmZsyhstdZsyhsubjectcu", cdmZsyhstdZsyhsubjectcu);
        return prefix + "/edit";
    }

    /**
     * 修改保存数据标准客户主题
     */
    @RequiresPermissions("metadata:zsyhsubjectcu:edit")
    @Log(title = "数据标准客户主题", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CdmZsyhstdZsyhsubjectcu cdmZsyhstdZsyhsubjectcu)
    {
        return toAjax(cdmZsyhstdZsyhsubjectcuService.updateCdmZsyhstdZsyhsubjectcu(cdmZsyhstdZsyhsubjectcu));
    }

    /**
     * 删除数据标准客户主题
     */
    @RequiresPermissions("metadata:zsyhsubjectcu:remove")
    @Log(title = "数据标准客户主题", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(cdmZsyhstdZsyhsubjectcuService.deleteCdmZsyhstdZsyhsubjectcuByIds(ids));
    }
}
