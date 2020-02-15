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
import com.kmw.metadata.domain.CdmZsyhstdZsyhsubjectbh;
import com.kmw.metadata.service.ICdmZsyhstdZsyhsubjectbhService;
import com.kmw.common.core.controller.BaseController;
import com.kmw.common.core.domain.AjaxResult;
import com.kmw.common.utils.poi.ExcelUtil;
import com.kmw.common.core.page.TableDataInfo;

/**
 * 数据标准机构主题Controller
 * 
 * @author kmw
 * @date 2020-02-13
 */
@Controller
@RequestMapping("/metadata/zsyhsubjectbh")
public class CdmZsyhstdZsyhsubjectbhController extends BaseController
{
    private String prefix = "metadata/zsyhsubjectbh";

    @Autowired
    private ICdmZsyhstdZsyhsubjectbhService cdmZsyhstdZsyhsubjectbhService;

    @RequiresPermissions("metadata:zsyhsubjectbh:view")
    @GetMapping()
    public String zsyhsubjectbh()
    {
        return prefix + "/zsyhsubjectbh";
    }

    /**
     * 查询数据标准机构主题列表
     */
    @RequiresPermissions("metadata:zsyhsubjectbh:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CdmZsyhstdZsyhsubjectbh cdmZsyhstdZsyhsubjectbh)
    {
        startPage();
        List<CdmZsyhstdZsyhsubjectbh> list = cdmZsyhstdZsyhsubjectbhService.selectCdmZsyhstdZsyhsubjectbhList(cdmZsyhstdZsyhsubjectbh);
        return getDataTable(list);
    }

    /**
     * 导出数据标准机构主题列表
     */
    @RequiresPermissions("metadata:zsyhsubjectbh:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CdmZsyhstdZsyhsubjectbh cdmZsyhstdZsyhsubjectbh)
    {
        List<CdmZsyhstdZsyhsubjectbh> list = cdmZsyhstdZsyhsubjectbhService.selectCdmZsyhstdZsyhsubjectbhList(cdmZsyhstdZsyhsubjectbh);
        ExcelUtil<CdmZsyhstdZsyhsubjectbh> util = new ExcelUtil<CdmZsyhstdZsyhsubjectbh>(CdmZsyhstdZsyhsubjectbh.class);
        return util.exportExcel(list, "zsyhsubjectbh");
    }

    /**
     * 新增数据标准机构主题
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存数据标准机构主题
     */
    @RequiresPermissions("metadata:zsyhsubjectbh:add")
    @Log(title = "数据标准机构主题", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CdmZsyhstdZsyhsubjectbh cdmZsyhstdZsyhsubjectbh)
    {
        return toAjax(cdmZsyhstdZsyhsubjectbhService.insertCdmZsyhstdZsyhsubjectbh(cdmZsyhstdZsyhsubjectbh));
    }

    /**
     * 修改数据标准机构主题
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        CdmZsyhstdZsyhsubjectbh cdmZsyhstdZsyhsubjectbh = cdmZsyhstdZsyhsubjectbhService.selectCdmZsyhstdZsyhsubjectbhById(id);
        mmap.put("cdmZsyhstdZsyhsubjectbh", cdmZsyhstdZsyhsubjectbh);
        return prefix + "/edit";
    }

    /**
     * 修改保存数据标准机构主题
     */
    @RequiresPermissions("metadata:zsyhsubjectbh:edit")
    @Log(title = "数据标准机构主题", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CdmZsyhstdZsyhsubjectbh cdmZsyhstdZsyhsubjectbh)
    {
        return toAjax(cdmZsyhstdZsyhsubjectbhService.updateCdmZsyhstdZsyhsubjectbh(cdmZsyhstdZsyhsubjectbh));
    }

    /**
     * 删除数据标准机构主题
     */
    @RequiresPermissions("metadata:zsyhsubjectbh:remove")
    @Log(title = "数据标准机构主题", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(cdmZsyhstdZsyhsubjectbhService.deleteCdmZsyhstdZsyhsubjectbhByIds(ids));
    }
}
