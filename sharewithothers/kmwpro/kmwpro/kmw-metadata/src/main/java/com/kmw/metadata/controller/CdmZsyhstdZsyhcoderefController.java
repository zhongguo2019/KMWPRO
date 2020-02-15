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
import com.kmw.metadata.domain.CdmStdAllsubjectcoderef;
import com.kmw.metadata.domain.CdmZsyhstdZsyhcoderef;
import com.kmw.metadata.service.ICdmZsyhstdZsyhcoderefService;
import com.kmw.common.core.controller.BaseController;
import com.kmw.common.core.domain.AjaxResult;
import com.kmw.common.utils.poi.ExcelUtil;
import com.kmw.common.core.page.TableDataInfo;

/**
 * VIEWController
 * 
 * @author kmw
 * @date 2020-02-13
 */
@Controller
@RequestMapping("/metadata/zsyhcoderef")
public class CdmZsyhstdZsyhcoderefController extends BaseController
{
    private String prefix = "metadata/zsyhcoderef";

    @Autowired
    private ICdmZsyhstdZsyhcoderefService cdmZsyhstdZsyhcoderefService;

    @RequiresPermissions("metadata:zsyhcoderef:view")
    @GetMapping()
    public String zsyhcoderef()
    {
        return prefix + "/zsyhcoderef";
    }

    /**
     * 查询VIEW列表
     */
    @RequiresPermissions("metadata:zsyhcoderef:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CdmZsyhstdZsyhcoderef cdmZsyhstdZsyhcoderef)
    {
        startPage();
        List<CdmZsyhstdZsyhcoderef> list = cdmZsyhstdZsyhcoderefService.selectCdmZsyhstdZsyhcoderefList(cdmZsyhstdZsyhcoderef);
        return getDataTable(list);
    }

    /**
     * 导出VIEW列表
     */
    @RequiresPermissions("metadata:zsyhcoderef:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CdmZsyhstdZsyhcoderef cdmZsyhstdZsyhcoderef)
    {
        List<CdmZsyhstdZsyhcoderef> list = cdmZsyhstdZsyhcoderefService.selectCdmZsyhstdZsyhcoderefList(cdmZsyhstdZsyhcoderef);
        ExcelUtil<CdmZsyhstdZsyhcoderef> util = new ExcelUtil<CdmZsyhstdZsyhcoderef>(CdmZsyhstdZsyhcoderef.class);
        return util.exportExcel(list, "zsyhcoderef");
    }

    /**
     * 新增VIEW
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存VIEW
     */
    @RequiresPermissions("metadata:zsyhcoderef:add")
    @Log(title = "VIEW", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CdmZsyhstdZsyhcoderef cdmZsyhstdZsyhcoderef)
    {
        return toAjax(cdmZsyhstdZsyhcoderefService.insertCdmZsyhstdZsyhcoderef(cdmZsyhstdZsyhcoderef));
    }

    /**
     * 修改VIEW
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        CdmZsyhstdZsyhcoderef cdmZsyhstdZsyhcoderef = cdmZsyhstdZsyhcoderefService.selectCdmZsyhstdZsyhcoderefById(id);
        mmap.put("cdmZsyhstdZsyhcoderef", cdmZsyhstdZsyhcoderef);
        return prefix + "/edit";
    }
    /**
     * 查询各主题代码参数表列表
     */
    @GetMapping("/viewonecode/{dictcode}")
    public String viewonecode(@PathVariable("dictcode") String dictcode, ModelMap mmap)
    {
    	mmap.put("dictcode", dictcode);
        return prefix + "/zsyhcoderef_list";
    }
    /**
     * 查询各主题代码参数表列表
     */
    @RequiresPermissions("metadata:allsubjectcoderef:list")
    @PostMapping("/viewcodelist/{dictcode}")
    @ResponseBody
    public TableDataInfo viewcodelist(@PathVariable("dictcode")  String dictcode , ModelMap mmap)
    {
        startPage();
        CdmZsyhstdZsyhcoderef cdmZsyhstdZsyhcoderef = new CdmZsyhstdZsyhcoderef();
        cdmZsyhstdZsyhcoderef.setCodeId(dictcode);
         List<CdmZsyhstdZsyhcoderef> list = cdmZsyhstdZsyhcoderefService.selectCdmZsyhstdZsyhcoderefList(cdmZsyhstdZsyhcoderef);
         return getDataTable(list);

    }
    /**
     * 修改保存VIEW
     */
    @RequiresPermissions("metadata:zsyhcoderef:edit")
    @Log(title = "VIEW", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CdmZsyhstdZsyhcoderef cdmZsyhstdZsyhcoderef)
    {
        return toAjax(cdmZsyhstdZsyhcoderefService.updateCdmZsyhstdZsyhcoderef(cdmZsyhstdZsyhcoderef));
    }

    /**
     * 删除VIEW
     */
    @RequiresPermissions("metadata:zsyhcoderef:remove")
    @Log(title = "VIEW", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(cdmZsyhstdZsyhcoderefService.deleteCdmZsyhstdZsyhcoderefByIds(ids));
    }
}
