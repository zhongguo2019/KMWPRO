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
import com.kmw.metadata.domain.CdmBhnsstdBhnsallsubjectBhnsallcoderef;
import com.kmw.metadata.service.ICdmBhnsstdBhnsallsubjectBhnsallcoderefService;
import com.kmw.common.core.controller.BaseController;
import com.kmw.common.core.domain.AjaxResult;
import com.kmw.common.utils.poi.ExcelUtil;
import com.kmw.common.core.page.TableDataInfo;

/**
 * 商业银行案例一数据标准所有主题码值对照Controller
 * 
 * @author kmw
 * @date 2020-02-07
 */
@Controller
@RequestMapping("/metadata/bhnsallcoderef")
public class CdmBhnsstdBhnsallsubjectBhnsallcoderefController extends BaseController
{
    private String prefix = "metadata/bhnsallcoderef";

    @Autowired
    private ICdmBhnsstdBhnsallsubjectBhnsallcoderefService cdmBhnsstdBhnsallsubjectBhnsallcoderefService;

    @RequiresPermissions("metadata:bhnsallcoderef:view")
    @GetMapping()
    public String bhnsallcoderef()
    {
        return prefix + "/bhnsallcoderef";
    }

    /**
     * 查询商业银行案例一数据标准所有主题码值对照列表
     */
    @RequiresPermissions("metadata:bhnsallcoderef:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CdmBhnsstdBhnsallsubjectBhnsallcoderef cdmBhnsstdBhnsallsubjectBhnsallcoderef)
    {
        startPage();
        List<CdmBhnsstdBhnsallsubjectBhnsallcoderef> list = cdmBhnsstdBhnsallsubjectBhnsallcoderefService.selectCdmBhnsstdBhnsallsubjectBhnsallcoderefList(cdmBhnsstdBhnsallsubjectBhnsallcoderef);
        return getDataTable(list);
    }

    /**
     * 导出商业银行案例一数据标准所有主题码值对照列表
     */
    @RequiresPermissions("metadata:bhnsallcoderef:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CdmBhnsstdBhnsallsubjectBhnsallcoderef cdmBhnsstdBhnsallsubjectBhnsallcoderef)
    {
        List<CdmBhnsstdBhnsallsubjectBhnsallcoderef> list = cdmBhnsstdBhnsallsubjectBhnsallcoderefService.selectCdmBhnsstdBhnsallsubjectBhnsallcoderefList(cdmBhnsstdBhnsallsubjectBhnsallcoderef);
        ExcelUtil<CdmBhnsstdBhnsallsubjectBhnsallcoderef> util = new ExcelUtil<CdmBhnsstdBhnsallsubjectBhnsallcoderef>(CdmBhnsstdBhnsallsubjectBhnsallcoderef.class);
        return util.exportExcel(list, "bhnsallcoderef");
    }

    /**
     * 新增商业银行案例一数据标准所有主题码值对照
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存商业银行案例一数据标准所有主题码值对照
     */
    @RequiresPermissions("metadata:bhnsallcoderef:add")
    @Log(title = "商业银行案例一数据标准所有主题码值对照", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CdmBhnsstdBhnsallsubjectBhnsallcoderef cdmBhnsstdBhnsallsubjectBhnsallcoderef)
    {
        return toAjax(cdmBhnsstdBhnsallsubjectBhnsallcoderefService.insertCdmBhnsstdBhnsallsubjectBhnsallcoderef(cdmBhnsstdBhnsallsubjectBhnsallcoderef));
    }

    /**
     * 修改商业银行案例一数据标准所有主题码值对照
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        CdmBhnsstdBhnsallsubjectBhnsallcoderef cdmBhnsstdBhnsallsubjectBhnsallcoderef = cdmBhnsstdBhnsallsubjectBhnsallcoderefService.selectCdmBhnsstdBhnsallsubjectBhnsallcoderefById(id);
        mmap.put("cdmBhnsstdBhnsallsubjectBhnsallcoderef", cdmBhnsstdBhnsallsubjectBhnsallcoderef);
        return prefix + "/edit";
    }

    /**
     * 修改保存商业银行案例一数据标准所有主题码值对照
     */
    @RequiresPermissions("metadata:bhnsallcoderef:edit")
    @Log(title = "商业银行案例一数据标准所有主题码值对照", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CdmBhnsstdBhnsallsubjectBhnsallcoderef cdmBhnsstdBhnsallsubjectBhnsallcoderef)
    {
        return toAjax(cdmBhnsstdBhnsallsubjectBhnsallcoderefService.updateCdmBhnsstdBhnsallsubjectBhnsallcoderef(cdmBhnsstdBhnsallsubjectBhnsallcoderef));
    }

    /**
     * 删除商业银行案例一数据标准所有主题码值对照
     */
    @RequiresPermissions("metadata:bhnsallcoderef:remove")
    @Log(title = "商业银行案例一数据标准所有主题码值对照", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(cdmBhnsstdBhnsallsubjectBhnsallcoderefService.deleteCdmBhnsstdBhnsallsubjectBhnsallcoderefByIds(ids));
    }
}
