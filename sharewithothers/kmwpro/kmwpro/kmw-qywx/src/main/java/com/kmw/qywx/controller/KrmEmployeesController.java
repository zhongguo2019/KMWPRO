package com.kmw.qywx.controller;
import java.util.UUID;
import java.util.List;
import java.util.Map;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.kmw.common.CommonEntity;
import com.kmw.common.annotation.Log;
import com.kmw.common.enums.BusinessType;
import com.kmw.qywx.domain.KrmEmployees;
import com.kmw.qywx.service.IKrmEmployeesService;
import com.kmw.system.domain.SysUser;
import com.kmw.common.utils.StringConvert;
import com.kmw.common.core.controller.BaseController;
import com.kmw.common.core.domain.AjaxResult;
import com.kmw.common.utils.poi.ExcelUtil;
import com.kmw.framework.util.ShiroUtils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.kmw.common.core.page.TableDataInfo;


/**
 * 员工信息KRMController
 * 
 * @author kmw
 * @date 2020-03-20
 */
@Controller
@RequestMapping("/qywx/employees")
public class KrmEmployeesController extends BaseController
{
    private String prefix = "qywx/employees";

    @Autowired
    private IKrmEmployeesService krmEmployeesService;
    protected Logger logger = LoggerFactory.getLogger(getClass());
    @RequiresPermissions("qywx:employees:view")
    @GetMapping()
    public String employees()
    {
        return prefix + "/employees";
    }

 /**
 *@function 查询员工信息KRM列表
 */
    @RequiresPermissions("qywx:employees:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(KrmEmployees krmEmployees)
    {
        startPage();
        List<KrmEmployees> list = krmEmployeesService.selectKrmEmployeesList(krmEmployees);
        return getDataTable(list);
    }

/**
*@function  导出员工信息KRM列表
*/
    @RequiresPermissions("qywx:employees:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(KrmEmployees krmEmployees)
    {
        List<KrmEmployees> list = krmEmployeesService.selectKrmEmployeesList(krmEmployees);
        ExcelUtil<KrmEmployees> util = new ExcelUtil<KrmEmployees>(KrmEmployees.class);
        return util.exportExcel(list, "employees");
    }

/**
*@function  新增员工信息KRM
*/
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

/**
*@function  新增保存员工信息KRM
*/
    @RequiresPermissions("qywx:employees:add")
    @Log(title = "员工信息KRM", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(KrmEmployees krmEmployees)
    {
        String uuid = UUID.randomUUID().toString().replaceAll("-","");
    	krmEmployees.setId(uuid);
        return toAjax(krmEmployeesService.insertKrmEmployees(krmEmployees));
    }

/**
*@function 修改员工信息KRM
*/
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        KrmEmployees krmEmployees = krmEmployeesService.selectKrmEmployeesById(id);
        mmap.put("krmEmployees", krmEmployees);
        return prefix + "/edit";
    }

/**
*@function 修改保存员工信息KRM
*/
    @RequiresPermissions("qywx:employees:edit")
    @Log(title = "员工信息KRM", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(KrmEmployees krmEmployees)
    {
        return toAjax(krmEmployeesService.updateKrmEmployees(krmEmployees));
    }
/**
*@function 按Map参数据查询，得到公共实体后分页	 
* 
* @param params
* @return
 */
	@RequestMapping(value = "queryPageInfo", method = RequestMethod.POST)
	@ResponseBody
	public PageInfo<CommonEntity> PageInfo(@RequestParam Map<String, Object> params, Model model) {
		logger.info("【通用实体查询】 分页显示 员工信息KRM ，Map参数：" + params.toString());
		TableDataInfo tableDataInfo = new TableDataInfo();
		params.put("pageNum", 0);
		params.put("pageSize", 100);
		if (params.containsKey("sortC")) { // 如果传过来的参数是驼峰式，这里需要将驼峰转成下划线式
			params.put("sortC", StringConvert.camelhumpToUnderline(params.get("sortC").toString()));
		}
		PageInfo<CommonEntity> page = krmEmployeesService.queryPageInfoEntity(params);
		return page;

	}

/**
* @function  前台分页显示
* 
* @param params
* @return
*/
	@RequestMapping(value = "tableDataInfo", method = RequestMethod.POST)
	@ResponseBody
	public TableDataInfo tableDataInfo(@RequestParam Map<String, Object> params, Model model) {
		logger.info("【通用实体查询】 分页显示 员工信息KRM ，Map参数：" + params.toString());
		List<CommonEntity> listEntity = krmEmployeesService.commonList(params);
		return getDataTable(listEntity);

	}

/**
* @function 查询一条记录
* 
* @param params
* @return
*/
	@RequestMapping(value = "queryOneEntity", method = RequestMethod.POST)
	@ResponseBody
	public CommonEntity queryOne(@RequestParam Map<String, Object> params, ModelMap mmap) {
		logger.info("【通用实体查询】 员工信息KRM ，Map参数：" + params.toString());
		CommonEntity commonEntity = krmEmployeesService.queryOne(params);
		return commonEntity;

	}



/**
*  @function 删除员工信息KRM
*/
    @RequiresPermissions("qywx:employees:remove")
    @Log(title = "员工信息KRM", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(krmEmployeesService.deleteKrmEmployeesByIds(ids));
    }
    
    
    @RequiresPermissions("qywx:employees:view")
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<KrmEmployees> util = new ExcelUtil<KrmEmployees>(KrmEmployees.class);
        return util.importTemplateExcel("员工信息");
    }
   
    
    @Log(title = "导入员工信息", businessType = BusinessType.IMPORT)
    @RequiresPermissions("qywx:employees:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<KrmEmployees> util = new ExcelUtil<KrmEmployees>(KrmEmployees.class);
        List<KrmEmployees> empList = util.importExcel(file.getInputStream());
        String operName = ShiroUtils.getSysUser().getLoginName();
        String message = krmEmployeesService.importKrmEmployees(empList, updateSupport, operName);
        return AjaxResult.success(message);
    }
}
