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
import com.kmw.metadata.domain.CdmBhnsstdBhnschsubject;
import com.kmw.metadata.service.ICdmBhnsstdBhnschsubjectService;
import com.kmw.common.core.controller.BaseController;
import com.kmw.common.core.domain.AjaxResult;
import com.kmw.common.utils.poi.ExcelUtil;
import com.kmw.common.core.page.TableDataInfo;

/**
 * 渠道主题Controller
 * 
 * @author kmw
 * @date 2020-02-07
 */
@Controller
@RequestMapping("/metadata/bhnschsubject")
public class CdmBhnsstdBhnschsubjectController extends BaseController
{
    private String prefix = "metadata/bhnschsubject";

    @Autowired
    private ICdmBhnsstdBhnschsubjectService cdmBhnsstdBhnschsubjectService;

    @RequiresPermissions("metadata:bhnschsubject:view")
    @GetMapping()
    public String bhnschsubject()
    {
        return prefix + "/bhnschsubject";
    }

    /**
     * 查询渠道主题列表
     */
    @RequiresPermissions("metadata:bhnschsubject:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CdmBhnsstdBhnschsubject cdmBhnsstdBhnschsubject)
    {
        startPage();
        List<CdmBhnsstdBhnschsubject> list = cdmBhnsstdBhnschsubjectService.selectCdmBhnsstdBhnschsubjectList(cdmBhnsstdBhnschsubject);
        return getDataTable(list);
    }

    /**
     * 导出渠道主题列表
     */
    @RequiresPermissions("metadata:bhnschsubject:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CdmBhnsstdBhnschsubject cdmBhnsstdBhnschsubject)
    {
        List<CdmBhnsstdBhnschsubject> list = cdmBhnsstdBhnschsubjectService.selectCdmBhnsstdBhnschsubjectList(cdmBhnsstdBhnschsubject);
        ExcelUtil<CdmBhnsstdBhnschsubject> util = new ExcelUtil<CdmBhnsstdBhnschsubject>(CdmBhnsstdBhnschsubject.class);
        return util.exportExcel(list, "bhnschsubject");
    }

    /**
     * 新增渠道主题
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存渠道主题
     */
    @RequiresPermissions("metadata:bhnschsubject:add")
    @Log(title = "渠道主题", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CdmBhnsstdBhnschsubject cdmBhnsstdBhnschsubject)
    {
        return toAjax(cdmBhnsstdBhnschsubjectService.insertCdmBhnsstdBhnschsubject(cdmBhnsstdBhnschsubject));
    }

    /**
     * 修改渠道主题
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        CdmBhnsstdBhnschsubject cdmBhnsstdBhnschsubject = cdmBhnsstdBhnschsubjectService.selectCdmBhnsstdBhnschsubjectById(id);
        mmap.put("cdmBhnsstdBhnschsubject", cdmBhnsstdBhnschsubject);
        return prefix + "/edit";
    }

    /**
     * 修改保存渠道主题
     */
    @RequiresPermissions("metadata:bhnschsubject:edit")
    @Log(title = "渠道主题", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CdmBhnsstdBhnschsubject cdmBhnsstdBhnschsubject)
    {
        return toAjax(cdmBhnsstdBhnschsubjectService.updateCdmBhnsstdBhnschsubject(cdmBhnsstdBhnschsubject));
    }

    /**
     * 删除渠道主题
     */
    @RequiresPermissions("metadata:bhnschsubject:remove")
    @Log(title = "渠道主题", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(cdmBhnsstdBhnschsubjectService.deleteCdmBhnsstdBhnschsubjectByIds(ids));
    }
}
