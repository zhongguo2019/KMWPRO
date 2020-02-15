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
import com.kmw.metadata.domain.CdmZsyhstdZsyhsubjectas;
import com.kmw.metadata.service.ICdmZsyhstdZsyhsubjectasService;
import com.kmw.common.core.controller.BaseController;
import com.kmw.common.core.domain.AjaxResult;
import com.kmw.common.utils.poi.ExcelUtil;
import com.kmw.common.core.page.TableDataInfo;

/**
 * 数据标准资产主题Controller
 * 
 * @author kmw
 * @date 2020-02-13
 */
@Controller
@RequestMapping("/metadata/zsyhsubjectas")
public class CdmZsyhstdZsyhsubjectasController extends BaseController
{
    private String prefix = "metadata/zsyhsubjectas";

    @Autowired
    private ICdmZsyhstdZsyhsubjectasService cdmZsyhstdZsyhsubjectasService;

    @RequiresPermissions("metadata:zsyhsubjectas:view")
    @GetMapping()
    public String zsyhsubjectas()
    {
        return prefix + "/zsyhsubjectas";
    }

    /**
     * 查询数据标准资产主题列表
     */
    @RequiresPermissions("metadata:zsyhsubjectas:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CdmZsyhstdZsyhsubjectas cdmZsyhstdZsyhsubjectas)
    {
        startPage();
        List<CdmZsyhstdZsyhsubjectas> list = cdmZsyhstdZsyhsubjectasService.selectCdmZsyhstdZsyhsubjectasList(cdmZsyhstdZsyhsubjectas);
        return getDataTable(list);
    }

    /**
     * 导出数据标准资产主题列表
     */
    @RequiresPermissions("metadata:zsyhsubjectas:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CdmZsyhstdZsyhsubjectas cdmZsyhstdZsyhsubjectas)
    {
        List<CdmZsyhstdZsyhsubjectas> list = cdmZsyhstdZsyhsubjectasService.selectCdmZsyhstdZsyhsubjectasList(cdmZsyhstdZsyhsubjectas);
        ExcelUtil<CdmZsyhstdZsyhsubjectas> util = new ExcelUtil<CdmZsyhstdZsyhsubjectas>(CdmZsyhstdZsyhsubjectas.class);
        return util.exportExcel(list, "zsyhsubjectas");
    }

    /**
     * 新增数据标准资产主题
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存数据标准资产主题
     */
    @RequiresPermissions("metadata:zsyhsubjectas:add")
    @Log(title = "数据标准资产主题", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CdmZsyhstdZsyhsubjectas cdmZsyhstdZsyhsubjectas)
    {
        return toAjax(cdmZsyhstdZsyhsubjectasService.insertCdmZsyhstdZsyhsubjectas(cdmZsyhstdZsyhsubjectas));
    }

    /**
     * 修改数据标准资产主题
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        CdmZsyhstdZsyhsubjectas cdmZsyhstdZsyhsubjectas = cdmZsyhstdZsyhsubjectasService.selectCdmZsyhstdZsyhsubjectasById(id);
        mmap.put("cdmZsyhstdZsyhsubjectas", cdmZsyhstdZsyhsubjectas);
        return prefix + "/edit";
    }

    /**
     * 修改保存数据标准资产主题
     */
    @RequiresPermissions("metadata:zsyhsubjectas:edit")
    @Log(title = "数据标准资产主题", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CdmZsyhstdZsyhsubjectas cdmZsyhstdZsyhsubjectas)
    {
        return toAjax(cdmZsyhstdZsyhsubjectasService.updateCdmZsyhstdZsyhsubjectas(cdmZsyhstdZsyhsubjectas));
    }

    /**
     * 删除数据标准资产主题
     */
    @RequiresPermissions("metadata:zsyhsubjectas:remove")
    @Log(title = "数据标准资产主题", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(cdmZsyhstdZsyhsubjectasService.deleteCdmZsyhstdZsyhsubjectasByIds(ids));
    }
}
