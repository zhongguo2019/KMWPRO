package com.kmw.qywx.controller;

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
import com.github.pagehelper.PageInfo;
import com.kmw.common.CommonEntity;
import com.kmw.common.annotation.Log;
import com.kmw.common.enums.BusinessType;
import com.kmw.qywx.domain.WxDepartment;
import com.kmw.qywx.service.IWxDepartmentService;
import com.kmw.common.utils.StringConvert;
import com.kmw.common.core.controller.BaseController;
import com.kmw.common.core.domain.AjaxResult;
import com.kmw.common.utils.poi.ExcelUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.kmw.common.core.page.TableDataInfo;


/**
 * 企业微信部门信息Controller
 * 
 * @author kmw
 * @date 2020-03-07
 */
@Controller
@RequestMapping("/qywx/department")
public class WxDepartmentController extends BaseController
{
    private String prefix = "qywx/department";

    @Autowired
    private IWxDepartmentService wxDepartmentService;
    protected Logger logger = LoggerFactory.getLogger(getClass());
    @RequiresPermissions("qywx:department:view")
    @GetMapping()
    public String department()
    {
        return prefix + "/department";
    }

 /**
 *@function 查询企业微信部门信息列表
 */
    @RequiresPermissions("qywx:department:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(WxDepartment wxDepartment)
    {
        startPage();
        List<WxDepartment> list = wxDepartmentService.selectWxDepartmentList(wxDepartment);
        return getDataTable(list);
    }

/**
*@function  导出企业微信部门信息列表
*/
    @RequiresPermissions("qywx:department:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(WxDepartment wxDepartment)
    {
        List<WxDepartment> list = wxDepartmentService.selectWxDepartmentList(wxDepartment);
        ExcelUtil<WxDepartment> util = new ExcelUtil<WxDepartment>(WxDepartment.class);
        return util.exportExcel(list, "department");
    }

/**
*@function  新增企业微信部门信息
*/
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

/**
*@function  新增保存企业微信部门信息
*/
    @RequiresPermissions("qywx:department:add")
    @Log(title = "企业微信部门信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(WxDepartment wxDepartment)
    {
        return toAjax(wxDepartmentService.insertWxDepartment(wxDepartment));
    }

/**
*@function 修改企业微信部门信息
*/
    @GetMapping("/edit/{departId}")
    public String edit(@PathVariable("departId") String departId, ModelMap mmap)
    {
        WxDepartment wxDepartment = wxDepartmentService.selectWxDepartmentById(departId);
        mmap.put("wxDepartment", wxDepartment);
        return prefix + "/edit";
    }

/**
*@function 修改保存企业微信部门信息
*/
    @RequiresPermissions("qywx:department:edit")
    @Log(title = "企业微信部门信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(WxDepartment wxDepartment)
    {
        return toAjax(wxDepartmentService.updateWxDepartment(wxDepartment));
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
		logger.info("【通用实体查询】 分页显示 企业微信部门信息 ，Map参数：" + params.toString());
		TableDataInfo tableDataInfo = new TableDataInfo();
		params.put("pageNum", 0);
		params.put("pageSize", 100);
		if (params.containsKey("sortC")) { // 如果传过来的参数是驼峰式，这里需要将驼峰转成下划线式
			params.put("sortC", StringConvert.camelhumpToUnderline(params.get("sortC").toString()));
		}
		PageInfo<CommonEntity> page = wxDepartmentService.queryPageInfoEntity(params);
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
		logger.info("【通用实体查询】 分页显示 企业微信部门信息 ，Map参数：" + params.toString());
		List<CommonEntity> listEntity = wxDepartmentService.commonList(params);
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
		logger.info("【通用实体查询】 企业微信部门信息 ，Map参数：" + params.toString());
		CommonEntity commonEntity = wxDepartmentService.queryOne(params);
		return commonEntity;

	}



/**
*  @function 删除企业微信部门信息
*/
    @RequiresPermissions("qywx:department:remove")
    @Log(title = "企业微信部门信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(wxDepartmentService.deleteWxDepartmentByIds(ids));
    }
}
