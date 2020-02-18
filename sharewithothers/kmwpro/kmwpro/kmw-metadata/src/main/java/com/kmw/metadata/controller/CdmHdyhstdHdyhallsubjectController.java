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
import com.kmw.metadata.domain.CdmHdyhstdHdyhallsubject;
import com.kmw.metadata.service.ICdmHdyhstdHdyhallsubjectService;
import com.kmw.common.core.controller.BaseController;
import com.kmw.common.core.domain.AjaxResult;
import com.kmw.common.utils.poi.ExcelUtil;
import com.kmw.common.core.page.TableDataInfo;

/**
 * 商业银行案例三Controller
 * 
 * @author kmw
 * @date 2020-02-16
 */
@Controller
@RequestMapping("/metadata/hdyhallsubject")
public class CdmHdyhstdHdyhallsubjectController extends BaseController
{
    private String prefix = "metadata/hdyhallsubject";

    @Autowired
    private ICdmHdyhstdHdyhallsubjectService cdmHdyhstdHdyhallsubjectService;

    @RequiresPermissions("metadata:hdyhallsubject:view")
    @GetMapping()
    public String hdyhallsubject()
    {
        return prefix + "/hdyhallsubject";
    }

    /**
     * 查询商业银行案例三列表
     */
    @RequiresPermissions("metadata:hdyhallsubject:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CdmHdyhstdHdyhallsubject cdmHdyhstdHdyhallsubject)
    {
        startPage();
        List<CdmHdyhstdHdyhallsubject> list = cdmHdyhstdHdyhallsubjectService.selectCdmHdyhstdHdyhallsubjectList(cdmHdyhstdHdyhallsubject);
        return getDataTable(list);
    }

    /**
     * 导出商业银行案例三列表
     */
    @RequiresPermissions("metadata:hdyhallsubject:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CdmHdyhstdHdyhallsubject cdmHdyhstdHdyhallsubject)
    {
        List<CdmHdyhstdHdyhallsubject> list = cdmHdyhstdHdyhallsubjectService.selectCdmHdyhstdHdyhallsubjectList(cdmHdyhstdHdyhallsubject);
        ExcelUtil<CdmHdyhstdHdyhallsubject> util = new ExcelUtil<CdmHdyhstdHdyhallsubject>(CdmHdyhstdHdyhallsubject.class);
        return util.exportExcel(list, "hdyhallsubject");
    }

    /**
     * 新增商业银行案例三
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存商业银行案例三
     */
    @RequiresPermissions("metadata:hdyhallsubject:add")
    @Log(title = "商业银行案例三", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CdmHdyhstdHdyhallsubject cdmHdyhstdHdyhallsubject)
    {
        return toAjax(cdmHdyhstdHdyhallsubjectService.insertCdmHdyhstdHdyhallsubject(cdmHdyhstdHdyhallsubject));
    }

    /**
     * 修改商业银行案例三
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        CdmHdyhstdHdyhallsubject cdmHdyhstdHdyhallsubject = cdmHdyhstdHdyhallsubjectService.selectCdmHdyhstdHdyhallsubjectById(id);
        mmap.put("cdmHdyhstdHdyhallsubject", cdmHdyhstdHdyhallsubject);
        return prefix + "/edit";
    }

    /**
     * 修改保存商业银行案例三
     */
    @RequiresPermissions("metadata:hdyhallsubject:edit")
    @Log(title = "商业银行案例三", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CdmHdyhstdHdyhallsubject cdmHdyhstdHdyhallsubject)
    {
        return toAjax(cdmHdyhstdHdyhallsubjectService.updateCdmHdyhstdHdyhallsubject(cdmHdyhstdHdyhallsubject));
    }

    /**
     * 删除商业银行案例三
     */
    @RequiresPermissions("metadata:hdyhallsubject:remove")
    @Log(title = "商业银行案例三", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(cdmHdyhstdHdyhallsubjectService.deleteCdmHdyhstdHdyhallsubjectByIds(ids));
    }
    
    /**
     * 查询案例二数据标准列表
     */
    @RequiresPermissions("metadata:zsyhallsubject:list")
    @GetMapping("/listbysubject/{subjectName}")
    public String zsyhallsubject(@PathVariable("subjectName") String subjectName, ModelMap mmap)
    {
		/*
		 * CdmZsyhstdZsyhallsubject cdmZsyhstdZsyhallsubject = new
		 * CdmZsyhstdZsyhallsubject();
		 * cdmZsyhstdZsyhallsubject.setBankName(subjectName);
		 * mmap.put("cdmZsyhstdZsyhallsubject", cdmZsyhstdZsyhallsubject);
		 */
    	
    	mmap.put("subjectName", subjectName);
    	 return prefix + "/hdyhallsubject_subject";
    }
}
