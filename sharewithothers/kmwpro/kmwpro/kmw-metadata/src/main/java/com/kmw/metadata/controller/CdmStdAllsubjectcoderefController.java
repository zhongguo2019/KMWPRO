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
import com.kmw.metadata.domain.CdmStdAllsubjectcoderef;
import com.kmw.metadata.service.ICdmStdAllsubjectcoderefService;
import com.kmw.common.core.controller.BaseController;
import com.kmw.common.core.domain.AjaxResult;
import com.kmw.common.utils.poi.ExcelUtil;
import com.kmw.common.core.page.TableDataInfo;

/**
 * 数据标准所有主题码值对照Controller
 * 
 * @author kmw
 * @date 2020-02-12
 */
@Controller
@RequestMapping("/metadata/allsubjectcoderef")
public class CdmStdAllsubjectcoderefController extends BaseController
{
    private String prefix = "metadata/allsubjectcoderef";

    @Autowired
    private ICdmStdAllsubjectcoderefService cdmStdAllsubjectcoderefService;

    @RequiresPermissions("metadata:allsubjectcoderef:view")
    @GetMapping()
    public String allsubjectcoderef()
    {
        return prefix + "/allsubjectcoderef";
    }

    /**
     * 查询数据标准所有主题码值对照列表
     */
    @RequiresPermissions("metadata:allsubjectcoderef:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CdmStdAllsubjectcoderef cdmStdAllsubjectcoderef)
    {
        startPage();
        List<CdmStdAllsubjectcoderef> list = cdmStdAllsubjectcoderefService.selectCdmStdAllsubjectcoderefList(cdmStdAllsubjectcoderef);
        return getDataTable(list);
    }

    /**
     * 导出数据标准所有主题码值对照列表
     */
    @RequiresPermissions("metadata:allsubjectcoderef:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CdmStdAllsubjectcoderef cdmStdAllsubjectcoderef)
    {
        List<CdmStdAllsubjectcoderef> list = cdmStdAllsubjectcoderefService.selectCdmStdAllsubjectcoderefList(cdmStdAllsubjectcoderef);
        ExcelUtil<CdmStdAllsubjectcoderef> util = new ExcelUtil<CdmStdAllsubjectcoderef>(CdmStdAllsubjectcoderef.class);
        return util.exportExcel(list, "allsubjectcoderef");
    }

    /**
     * 新增数据标准所有主题码值对照
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存数据标准所有主题码值对照
     */
    @RequiresPermissions("metadata:allsubjectcoderef:add")
    @Log(title = "数据标准所有主题码值对照", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CdmStdAllsubjectcoderef cdmStdAllsubjectcoderef)
    {
        return toAjax(cdmStdAllsubjectcoderefService.insertCdmStdAllsubjectcoderef(cdmStdAllsubjectcoderef));
    }

    /**
     * 修改数据标准所有主题码值对照
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        CdmStdAllsubjectcoderef cdmStdAllsubjectcoderef = cdmStdAllsubjectcoderefService.selectCdmStdAllsubjectcoderefById(id);
        mmap.put("cdmStdAllsubjectcoderef", cdmStdAllsubjectcoderef);
        return prefix + "/edit";
    }

    /**
     * 修改保存数据标准所有主题码值对照
     */
    @RequiresPermissions("metadata:allsubjectcoderef:edit")
    @Log(title = "数据标准所有主题码值对照", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CdmStdAllsubjectcoderef cdmStdAllsubjectcoderef)
    {
        return toAjax(cdmStdAllsubjectcoderefService.updateCdmStdAllsubjectcoderef(cdmStdAllsubjectcoderef));
    }
    /**
     * 查询各主题代码参数表列表
     */
    @GetMapping("/viewonecode/{dictcode}")
    public String viewonecode(@PathVariable("dictcode") String dictcode, ModelMap mmap)
    {
    	mmap.put("dictcode", dictcode);
        return prefix + "/allsubjectcoderef_list";
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
        CdmStdAllsubjectcoderef cdmStdAllsubjectcoderef = new CdmStdAllsubjectcoderef();
        cdmStdAllsubjectcoderef.setCodeId(dictcode);
        List<CdmStdAllsubjectcoderef> list = cdmStdAllsubjectcoderefService.selectCdmStdAllsubjectcoderefList(cdmStdAllsubjectcoderef);
        return getDataTable(list);
    }
    /**
     * 删除数据标准所有主题码值对照
     */
    @RequiresPermissions("metadata:allsubjectcoderef:remove")
    @Log(title = "数据标准所有主题码值对照", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(cdmStdAllsubjectcoderefService.deleteCdmStdAllsubjectcoderefByIds(ids));
    }
    
   
}
