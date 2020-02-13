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
import com.kmw.metadata.domain.CdmZsyhstdZsyhallsubject;
import com.kmw.metadata.service.ICdmZsyhstdZsyhallsubjectService;
import com.kmw.common.core.controller.BaseController;
import com.kmw.common.core.domain.AjaxResult;
import com.kmw.common.utils.poi.ExcelUtil;
import com.kmw.common.core.page.TableDataInfo;

/**
 * 案例二数据标准Controller
 * 
 * @author kmw
 * @date 2020-02-12
 */
@Controller
@RequestMapping("/metadata/zsyhallsubject")
public class CdmZsyhstdZsyhallsubjectController extends BaseController
{
    private String prefix = "metadata/zsyhallsubject";

    @Autowired
    private ICdmZsyhstdZsyhallsubjectService cdmZsyhstdZsyhallsubjectService;

    @RequiresPermissions("metadata:zsyhallsubject:view")
    @GetMapping()
    public String zsyhallsubject()
    {
        return prefix + "/zsyhallsubject";
    }

    /**
     * 查询案例二数据标准列表
     */
    @RequiresPermissions("metadata:zsyhallsubject:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CdmZsyhstdZsyhallsubject cdmZsyhstdZsyhallsubject)
    {
        startPage();
        List<CdmZsyhstdZsyhallsubject> list = cdmZsyhstdZsyhallsubjectService.selectCdmZsyhstdZsyhallsubjectList(cdmZsyhstdZsyhallsubject);
        return getDataTable(list);
    }

    /**
     * 导出案例二数据标准列表
     */
    @RequiresPermissions("metadata:zsyhallsubject:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CdmZsyhstdZsyhallsubject cdmZsyhstdZsyhallsubject)
    {
        List<CdmZsyhstdZsyhallsubject> list = cdmZsyhstdZsyhallsubjectService.selectCdmZsyhstdZsyhallsubjectList(cdmZsyhstdZsyhallsubject);
        ExcelUtil<CdmZsyhstdZsyhallsubject> util = new ExcelUtil<CdmZsyhstdZsyhallsubject>(CdmZsyhstdZsyhallsubject.class);
        return util.exportExcel(list, "zsyhallsubject");
    }

    /**
     * 新增案例二数据标准
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存案例二数据标准
     */
    @RequiresPermissions("metadata:zsyhallsubject:add")
    @Log(title = "案例二数据标准", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CdmZsyhstdZsyhallsubject cdmZsyhstdZsyhallsubject)
    {
        return toAjax(cdmZsyhstdZsyhallsubjectService.insertCdmZsyhstdZsyhallsubject(cdmZsyhstdZsyhallsubject));
    }

    /**
     * 修改案例二数据标准
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        CdmZsyhstdZsyhallsubject cdmZsyhstdZsyhallsubject = cdmZsyhstdZsyhallsubjectService.selectCdmZsyhstdZsyhallsubjectById(id);
        mmap.put("cdmZsyhstdZsyhallsubject", cdmZsyhstdZsyhallsubject);
        return prefix + "/edit";
    }

    /**
     * 修改保存案例二数据标准
     */
    @RequiresPermissions("metadata:zsyhallsubject:edit")
    @Log(title = "案例二数据标准", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CdmZsyhstdZsyhallsubject cdmZsyhstdZsyhallsubject)
    {
        return toAjax(cdmZsyhstdZsyhallsubjectService.updateCdmZsyhstdZsyhallsubject(cdmZsyhstdZsyhallsubject));
    }

    /**
     * 删除案例二数据标准
     */
    @RequiresPermissions("metadata:zsyhallsubject:remove")
    @Log(title = "案例二数据标准", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(cdmZsyhstdZsyhallsubjectService.deleteCdmZsyhstdZsyhallsubjectByIds(ids));
    }
}
