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
import com.kmw.metadata.domain.CdmZsyhstdZsyhsubjectpd;
import com.kmw.metadata.service.ICdmZsyhstdZsyhsubjectpdService;
import com.kmw.common.core.controller.BaseController;
import com.kmw.common.core.domain.AjaxResult;
import com.kmw.common.utils.poi.ExcelUtil;
import com.kmw.common.core.page.TableDataInfo;

/**
 * 数据标准产品主题Controller
 * 
 * @author kmw
 * @date 2020-02-13
 */
@Controller
@RequestMapping("/metadata/zsyhsubjectpd")
public class CdmZsyhstdZsyhsubjectpdController extends BaseController
{
    private String prefix = "metadata/zsyhsubjectpd";

    @Autowired
    private ICdmZsyhstdZsyhsubjectpdService cdmZsyhstdZsyhsubjectpdService;

    @RequiresPermissions("metadata:zsyhsubjectpd:view")
    @GetMapping()
    public String zsyhsubjectpd()
    {
        return prefix + "/zsyhsubjectpd";
    }

    /**
     * 查询数据标准产品主题列表
     */
    @RequiresPermissions("metadata:zsyhsubjectpd:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CdmZsyhstdZsyhsubjectpd cdmZsyhstdZsyhsubjectpd)
    {
        startPage();
        List<CdmZsyhstdZsyhsubjectpd> list = cdmZsyhstdZsyhsubjectpdService.selectCdmZsyhstdZsyhsubjectpdList(cdmZsyhstdZsyhsubjectpd);
        return getDataTable(list);
    }

    /**
     * 导出数据标准产品主题列表
     */
    @RequiresPermissions("metadata:zsyhsubjectpd:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CdmZsyhstdZsyhsubjectpd cdmZsyhstdZsyhsubjectpd)
    {
        List<CdmZsyhstdZsyhsubjectpd> list = cdmZsyhstdZsyhsubjectpdService.selectCdmZsyhstdZsyhsubjectpdList(cdmZsyhstdZsyhsubjectpd);
        ExcelUtil<CdmZsyhstdZsyhsubjectpd> util = new ExcelUtil<CdmZsyhstdZsyhsubjectpd>(CdmZsyhstdZsyhsubjectpd.class);
        return util.exportExcel(list, "zsyhsubjectpd");
    }

    /**
     * 新增数据标准产品主题
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存数据标准产品主题
     */
    @RequiresPermissions("metadata:zsyhsubjectpd:add")
    @Log(title = "数据标准产品主题", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CdmZsyhstdZsyhsubjectpd cdmZsyhstdZsyhsubjectpd)
    {
        return toAjax(cdmZsyhstdZsyhsubjectpdService.insertCdmZsyhstdZsyhsubjectpd(cdmZsyhstdZsyhsubjectpd));
    }

    /**
     * 修改数据标准产品主题
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        CdmZsyhstdZsyhsubjectpd cdmZsyhstdZsyhsubjectpd = cdmZsyhstdZsyhsubjectpdService.selectCdmZsyhstdZsyhsubjectpdById(id);
        mmap.put("cdmZsyhstdZsyhsubjectpd", cdmZsyhstdZsyhsubjectpd);
        return prefix + "/edit";
    }

    /**
     * 修改保存数据标准产品主题
     */
    @RequiresPermissions("metadata:zsyhsubjectpd:edit")
    @Log(title = "数据标准产品主题", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CdmZsyhstdZsyhsubjectpd cdmZsyhstdZsyhsubjectpd)
    {
        return toAjax(cdmZsyhstdZsyhsubjectpdService.updateCdmZsyhstdZsyhsubjectpd(cdmZsyhstdZsyhsubjectpd));
    }

    /**
     * 删除数据标准产品主题
     */
    @RequiresPermissions("metadata:zsyhsubjectpd:remove")
    @Log(title = "数据标准产品主题", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(cdmZsyhstdZsyhsubjectpdService.deleteCdmZsyhstdZsyhsubjectpdByIds(ids));
    }
}
