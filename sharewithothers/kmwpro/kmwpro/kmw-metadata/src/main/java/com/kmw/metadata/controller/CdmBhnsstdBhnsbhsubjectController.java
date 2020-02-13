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
import com.kmw.metadata.domain.CdmBhnsstdBhnsbhsubject;
import com.kmw.metadata.service.ICdmBhnsstdBhnsbhsubjectService;
import com.kmw.common.core.controller.BaseController;
import com.kmw.common.core.domain.AjaxResult;
import com.kmw.common.utils.poi.ExcelUtil;
import com.kmw.common.core.page.TableDataInfo;

/**
 * 机构主题Controller
 * 
 * @author kmw
 * @date 2020-02-07
 */
@Controller
@RequestMapping("/metadata/bhnsbhsubject")
public class CdmBhnsstdBhnsbhsubjectController extends BaseController
{
    private String prefix = "metadata/bhnsbhsubject";

    @Autowired
    private ICdmBhnsstdBhnsbhsubjectService cdmBhnsstdBhnsbhsubjectService;

    @RequiresPermissions("metadata:bhnsbhsubject:view")
    @GetMapping()
    public String bhnsbhsubject()
    {
        return prefix + "/bhnsbhsubject";
    }

    /**
     * 查询机构主题列表
     */
    @RequiresPermissions("metadata:bhnsbhsubject:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CdmBhnsstdBhnsbhsubject cdmBhnsstdBhnsbhsubject)
    {
        startPage();
        List<CdmBhnsstdBhnsbhsubject> list = cdmBhnsstdBhnsbhsubjectService.selectCdmBhnsstdBhnsbhsubjectList(cdmBhnsstdBhnsbhsubject);
        return getDataTable(list);
    }

    /**
     * 导出机构主题列表
     */
    @RequiresPermissions("metadata:bhnsbhsubject:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CdmBhnsstdBhnsbhsubject cdmBhnsstdBhnsbhsubject)
    {
        List<CdmBhnsstdBhnsbhsubject> list = cdmBhnsstdBhnsbhsubjectService.selectCdmBhnsstdBhnsbhsubjectList(cdmBhnsstdBhnsbhsubject);
        ExcelUtil<CdmBhnsstdBhnsbhsubject> util = new ExcelUtil<CdmBhnsstdBhnsbhsubject>(CdmBhnsstdBhnsbhsubject.class);
        return util.exportExcel(list, "bhnsbhsubject");
    }

    /**
     * 新增机构主题
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存机构主题
     */
    @RequiresPermissions("metadata:bhnsbhsubject:add")
    @Log(title = "机构主题", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CdmBhnsstdBhnsbhsubject cdmBhnsstdBhnsbhsubject)
    {
        return toAjax(cdmBhnsstdBhnsbhsubjectService.insertCdmBhnsstdBhnsbhsubject(cdmBhnsstdBhnsbhsubject));
    }

    /**
     * 修改机构主题
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        CdmBhnsstdBhnsbhsubject cdmBhnsstdBhnsbhsubject = cdmBhnsstdBhnsbhsubjectService.selectCdmBhnsstdBhnsbhsubjectById(id);
        mmap.put("cdmBhnsstdBhnsbhsubject", cdmBhnsstdBhnsbhsubject);
        return prefix + "/edit";
    }

    /**
     * 修改保存机构主题
     */
    @RequiresPermissions("metadata:bhnsbhsubject:edit")
    @Log(title = "机构主题", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CdmBhnsstdBhnsbhsubject cdmBhnsstdBhnsbhsubject)
    {
        return toAjax(cdmBhnsstdBhnsbhsubjectService.updateCdmBhnsstdBhnsbhsubject(cdmBhnsstdBhnsbhsubject));
    }

    /**
     * 删除机构主题
     */
    @RequiresPermissions("metadata:bhnsbhsubject:remove")
    @Log(title = "机构主题", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(cdmBhnsstdBhnsbhsubjectService.deleteCdmBhnsstdBhnsbhsubjectByIds(ids));
    }
}
