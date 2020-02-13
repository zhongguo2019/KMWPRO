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
import com.kmw.metadata.domain.CdmBhnsstdBhnscoderef;
import com.kmw.metadata.service.ICdmBhnsstdBhnscoderefService;
import com.kmw.common.core.controller.BaseController;
import com.kmw.common.core.domain.AjaxResult;
import com.kmw.common.utils.poi.ExcelUtil;
import com.kmw.common.core.page.TableDataInfo;

/**
 * 各主题代码参数表Controller
 * 
 * @author kmw
 * @date 2020-02-12
 */
@Controller
@RequestMapping("/metadata/bhnscoderef")
public class CdmBhnsstdBhnscoderefController extends BaseController
{
    private String prefix = "metadata/bhnscoderef";

    @Autowired
    private ICdmBhnsstdBhnscoderefService cdmBhnsstdBhnscoderefService;

    @RequiresPermissions("metadata:bhnscoderef:view")
    @GetMapping()
    public String bhnscoderef()
    {
        return prefix + "/bhnscoderef";
    }

    /**
     * 查询各主题代码参数表列表
     */
    @RequiresPermissions("metadata:bhnscoderef:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CdmBhnsstdBhnscoderef cdmBhnsstdBhnscoderef)
    {
        startPage();
        List<CdmBhnsstdBhnscoderef> list = cdmBhnsstdBhnscoderefService.selectCdmBhnsstdBhnscoderefList(cdmBhnsstdBhnscoderef);
        return getDataTable(list);
    }


    /**
     * 导出各主题代码参数表列表
     */
    @RequiresPermissions("metadata:bhnscoderef:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CdmBhnsstdBhnscoderef cdmBhnsstdBhnscoderef)
    {
        List<CdmBhnsstdBhnscoderef> list = cdmBhnsstdBhnscoderefService.selectCdmBhnsstdBhnscoderefList(cdmBhnsstdBhnscoderef);
        ExcelUtil<CdmBhnsstdBhnscoderef> util = new ExcelUtil<CdmBhnsstdBhnscoderef>(CdmBhnsstdBhnscoderef.class);
        return util.exportExcel(list, "bhnscoderef");
    }

    /**
     * 新增各主题代码参数表
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存各主题代码参数表
     */
    @RequiresPermissions("metadata:bhnscoderef:add")
    @Log(title = "各主题代码参数表", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CdmBhnsstdBhnscoderef cdmBhnsstdBhnscoderef)
    {
        return toAjax(cdmBhnsstdBhnscoderefService.insertCdmBhnsstdBhnscoderef(cdmBhnsstdBhnscoderef));
    }

    /**
     * 修改各主题代码参数表
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        CdmBhnsstdBhnscoderef cdmBhnsstdBhnscoderef = cdmBhnsstdBhnscoderefService.selectCdmBhnsstdBhnscoderefById(id);
        mmap.put("cdmBhnsstdBhnscoderef", cdmBhnsstdBhnscoderef);
        return prefix + "/edit";
    }
    /**
     * 查询各主题代码参数表列表
     */
    @GetMapping("/viewonecode/{dictcode}")
    public String viewonecode(@PathVariable("dictcode") String dictcode, ModelMap mmap)
    {
    	mmap.put("dictcode", dictcode);
        return prefix + "/bhnscoderef_list";
    }
    /**
     * 查询各主题代码参数表列表
     */
    @RequiresPermissions("metadata:bhnscoderef:list")
    @PostMapping("/viewcodelist/{dictcode}")
    @ResponseBody
    public TableDataInfo viewcodelist(@PathVariable("dictcode")  String dictcode, ModelMap mmap)
    {
        startPage();
        CdmBhnsstdBhnscoderef cdmBhnsstdBhnscoderef = new CdmBhnsstdBhnscoderef();
        cdmBhnsstdBhnscoderef.setCodeId(dictcode);
        List<CdmBhnsstdBhnscoderef> list = cdmBhnsstdBhnscoderefService.selectCdmBhnsstdBhnscoderefList(cdmBhnsstdBhnscoderef);
        return getDataTable(list);
    }
    /**
     * 修改保存各主题代码参数表
     */
    @RequiresPermissions("metadata:bhnscoderef:edit")
    @Log(title = "各主题代码参数表", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CdmBhnsstdBhnscoderef cdmBhnsstdBhnscoderef)
    {
        return toAjax(cdmBhnsstdBhnscoderefService.updateCdmBhnsstdBhnscoderef(cdmBhnsstdBhnscoderef));
    }

    /**
     * 删除各主题代码参数表
     */
    @RequiresPermissions("metadata:bhnscoderef:remove")
    @Log(title = "各主题代码参数表", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(cdmBhnsstdBhnscoderefService.deleteCdmBhnsstdBhnscoderefByIds(ids));
    }
}
