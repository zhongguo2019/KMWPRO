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
import com.kmw.metadata.domain.CdmZsyhstdZsyhsubjectag;
import com.kmw.metadata.service.ICdmZsyhstdZsyhsubjectagService;
import com.kmw.common.core.controller.BaseController;
import com.kmw.common.core.domain.AjaxResult;
import com.kmw.common.utils.poi.ExcelUtil;
import com.kmw.common.core.page.TableDataInfo;

/**
 * 数据标准协议主题Controller
 * 
 * @author kmw
 * @date 2020-02-13
 */
@Controller
@RequestMapping("/metadata/zsyhsubjectag")
public class CdmZsyhstdZsyhsubjectagController extends BaseController
{
    private String prefix = "metadata/zsyhsubjectag";

    @Autowired
    private ICdmZsyhstdZsyhsubjectagService cdmZsyhstdZsyhsubjectagService;

    @RequiresPermissions("metadata:zsyhsubjectag:view")
    @GetMapping()
    public String zsyhsubjectag()
    {
        return prefix + "/zsyhsubjectag";
    }

    /**
     * 查询数据标准协议主题列表
     */
    @RequiresPermissions("metadata:zsyhsubjectag:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CdmZsyhstdZsyhsubjectag cdmZsyhstdZsyhsubjectag)
    {
        startPage();
        List<CdmZsyhstdZsyhsubjectag> list = cdmZsyhstdZsyhsubjectagService.selectCdmZsyhstdZsyhsubjectagList(cdmZsyhstdZsyhsubjectag);
        return getDataTable(list);
    }

    /**
     * 导出数据标准协议主题列表
     */
    @RequiresPermissions("metadata:zsyhsubjectag:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CdmZsyhstdZsyhsubjectag cdmZsyhstdZsyhsubjectag)
    {
        List<CdmZsyhstdZsyhsubjectag> list = cdmZsyhstdZsyhsubjectagService.selectCdmZsyhstdZsyhsubjectagList(cdmZsyhstdZsyhsubjectag);
        ExcelUtil<CdmZsyhstdZsyhsubjectag> util = new ExcelUtil<CdmZsyhstdZsyhsubjectag>(CdmZsyhstdZsyhsubjectag.class);
        return util.exportExcel(list, "zsyhsubjectag");
    }

    /**
     * 新增数据标准协议主题
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存数据标准协议主题
     */
    @RequiresPermissions("metadata:zsyhsubjectag:add")
    @Log(title = "数据标准协议主题", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CdmZsyhstdZsyhsubjectag cdmZsyhstdZsyhsubjectag)
    {
        return toAjax(cdmZsyhstdZsyhsubjectagService.insertCdmZsyhstdZsyhsubjectag(cdmZsyhstdZsyhsubjectag));
    }

    /**
     * 修改数据标准协议主题
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        CdmZsyhstdZsyhsubjectag cdmZsyhstdZsyhsubjectag = cdmZsyhstdZsyhsubjectagService.selectCdmZsyhstdZsyhsubjectagById(id);
        mmap.put("cdmZsyhstdZsyhsubjectag", cdmZsyhstdZsyhsubjectag);
        return prefix + "/edit";
    }

    /**
     * 修改保存数据标准协议主题
     */
    @RequiresPermissions("metadata:zsyhsubjectag:edit")
    @Log(title = "数据标准协议主题", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CdmZsyhstdZsyhsubjectag cdmZsyhstdZsyhsubjectag)
    {
        return toAjax(cdmZsyhstdZsyhsubjectagService.updateCdmZsyhstdZsyhsubjectag(cdmZsyhstdZsyhsubjectag));
    }

    /**
     * 删除数据标准协议主题
     */
    @RequiresPermissions("metadata:zsyhsubjectag:remove")
    @Log(title = "数据标准协议主题", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(cdmZsyhstdZsyhsubjectagService.deleteCdmZsyhstdZsyhsubjectagByIds(ids));
    }
}
