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
import com.kmw.metadata.domain.CdmBhnsstdBhnsallsubject;
import com.kmw.metadata.service.ICdmBhnsstdBhnsallsubjectService;
import com.kmw.common.core.controller.BaseController;
import com.kmw.common.core.domain.AjaxResult;
import com.kmw.common.utils.poi.ExcelUtil;
import com.kmw.common.core.page.TableDataInfo;

/**
 * 商业银行案例一数据标准_所有主题Controller
 * 
 * @author kmw
 * @date 2020-02-07
 */
@Controller
@RequestMapping("/metadata/bhnsallsubject")
public class CdmBhnsstdBhnsallsubjectController extends BaseController
{
    private String prefix = "metadata/bhnsallsubject";

    @Autowired
    private ICdmBhnsstdBhnsallsubjectService cdmBhnsstdBhnsallsubjectService;

    @RequiresPermissions("metadata:bhnsallsubject:view")
    @GetMapping()
    public String bhnsallsubject()
    {
        return prefix + "/bhnsallsubject";
    }

    /**
     * 查询商业银行案例一数据标准_所有主题列表
     */
    @RequiresPermissions("metadata:bhnsallsubject:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CdmBhnsstdBhnsallsubject cdmBhnsstdBhnsallsubject)
    {
        startPage();
        List<CdmBhnsstdBhnsallsubject> list = cdmBhnsstdBhnsallsubjectService.selectCdmBhnsstdBhnsallsubjectList(cdmBhnsstdBhnsallsubject);
        return getDataTable(list);
    }

    /**
     * 导出商业银行案例一数据标准_所有主题列表
     */
    @RequiresPermissions("metadata:bhnsallsubject:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CdmBhnsstdBhnsallsubject cdmBhnsstdBhnsallsubject)
    {
        List<CdmBhnsstdBhnsallsubject> list = cdmBhnsstdBhnsallsubjectService.selectCdmBhnsstdBhnsallsubjectList(cdmBhnsstdBhnsallsubject);
        ExcelUtil<CdmBhnsstdBhnsallsubject> util = new ExcelUtil<CdmBhnsstdBhnsallsubject>(CdmBhnsstdBhnsallsubject.class);
        return util.exportExcel(list, "bhnsallsubject");
    }

    /**
     * 新增商业银行案例一数据标准_所有主题
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存商业银行案例一数据标准_所有主题
     */
    @RequiresPermissions("metadata:bhnsallsubject:add")
    @Log(title = "商业银行案例一数据标准_所有主题", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CdmBhnsstdBhnsallsubject cdmBhnsstdBhnsallsubject)
    {
        return toAjax(cdmBhnsstdBhnsallsubjectService.insertCdmBhnsstdBhnsallsubject(cdmBhnsstdBhnsallsubject));
    }

    /**
     * 修改商业银行案例一数据标准_所有主题
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        CdmBhnsstdBhnsallsubject cdmBhnsstdBhnsallsubject = cdmBhnsstdBhnsallsubjectService.selectCdmBhnsstdBhnsallsubjectById(id);
        mmap.put("cdmBhnsstdBhnsallsubject", cdmBhnsstdBhnsallsubject);
        return prefix + "/edit";
    }

    /**
     * 修改保存商业银行案例一数据标准_所有主题
     */
    @RequiresPermissions("metadata:bhnsallsubject:edit")
    @Log(title = "商业银行案例一数据标准_所有主题", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CdmBhnsstdBhnsallsubject cdmBhnsstdBhnsallsubject)
    {
        return toAjax(cdmBhnsstdBhnsallsubjectService.updateCdmBhnsstdBhnsallsubject(cdmBhnsstdBhnsallsubject));
    }

    /**
     * 删除商业银行案例一数据标准_所有主题
     */
    @RequiresPermissions("metadata:bhnsallsubject:remove")
    @Log(title = "商业银行案例一数据标准_所有主题", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(cdmBhnsstdBhnsallsubjectService.deleteCdmBhnsstdBhnsallsubjectByIds(ids));
    }
}
