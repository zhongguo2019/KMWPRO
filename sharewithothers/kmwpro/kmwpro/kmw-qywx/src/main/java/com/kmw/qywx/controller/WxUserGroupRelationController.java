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
import com.kmw.qywx.domain.WxUserGroupRelation;
import com.kmw.qywx.service.IWxUserGroupRelationService;
import com.kmw.utils.StringConvert;
import com.kmw.common.core.controller.BaseController;
import com.kmw.common.core.domain.AjaxResult;
import com.kmw.common.utils.poi.ExcelUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.kmw.common.core.page.TableDataInfo;


/**
 * 分组信息与用户对应关系Controller
 * 
 * @author kmw
 * @date 2020-02-27
 */
@Controller
@RequestMapping("/qywx/relation")
public class WxUserGroupRelationController extends BaseController
{
    private String prefix = "qywx/relation";

    @Autowired
    private IWxUserGroupRelationService wxUserGroupRelationService;
    protected Logger logger = LoggerFactory.getLogger(getClass());
    @RequiresPermissions("qywx:relation:view")
    @GetMapping()
    public String relation()
    {
        return prefix + "/relation";
    }

 /**
 *@function 查询分组信息与用户对应关系列表
 */
    @RequiresPermissions("qywx:relation:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(WxUserGroupRelation wxUserGroupRelation)
    {
        startPage();
        List<WxUserGroupRelation> list = wxUserGroupRelationService.selectWxUserGroupRelationList(wxUserGroupRelation);
        return getDataTable(list);
    }

/**
*@function  导出分组信息与用户对应关系列表
*/
    @RequiresPermissions("qywx:relation:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(WxUserGroupRelation wxUserGroupRelation)
    {
        List<WxUserGroupRelation> list = wxUserGroupRelationService.selectWxUserGroupRelationList(wxUserGroupRelation);
        ExcelUtil<WxUserGroupRelation> util = new ExcelUtil<WxUserGroupRelation>(WxUserGroupRelation.class);
        return util.exportExcel(list, "relation");
    }

/**
*@function  新增分组信息与用户对应关系
*/
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

/**
*@function  新增保存分组信息与用户对应关系
*/
    @RequiresPermissions("qywx:relation:add")
    @Log(title = "分组信息与用户对应关系", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(WxUserGroupRelation wxUserGroupRelation)
    {
        return toAjax(wxUserGroupRelationService.insertWxUserGroupRelation(wxUserGroupRelation));
    }

/**
*@function 修改分组信息与用户对应关系
*/
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        WxUserGroupRelation wxUserGroupRelation = wxUserGroupRelationService.selectWxUserGroupRelationById(id);
        mmap.put("wxUserGroupRelation", wxUserGroupRelation);
        return prefix + "/edit";
    }

/**
*@function 修改保存分组信息与用户对应关系
*/
    @RequiresPermissions("qywx:relation:edit")
    @Log(title = "分组信息与用户对应关系", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(WxUserGroupRelation wxUserGroupRelation)
    {
        return toAjax(wxUserGroupRelationService.updateWxUserGroupRelation(wxUserGroupRelation));
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
		logger.info("【通用实体查询】 分页显示 分组信息与用户对应关系 ，Map参数：" + params.toString());
		TableDataInfo tableDataInfo = new TableDataInfo();
		params.put("pageNum", 0);
		params.put("pageSize", 100);
		if (params.containsKey("sortC")) { // 如果传过来的参数是驼峰式，这里需要将驼峰转成下划线式
			params.put("sortC", StringConvert.camelhumpToUnderline(params.get("sortC").toString()));
		}
		PageInfo<CommonEntity> page = wxUserGroupRelationService.queryPageInfoEntity(params);
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
		logger.info("【通用实体查询】 分页显示 分组信息与用户对应关系 ，Map参数：" + params.toString());
		List<CommonEntity> listEntity = wxUserGroupRelationService.commonList(params);
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
		logger.info("【通用实体查询】 分组信息与用户对应关系 ，Map参数：" + params.toString());
		CommonEntity commonEntity = wxUserGroupRelationService.queryOne(params);
		return commonEntity;

	}



/**
*  @function 删除分组信息与用户对应关系
*/
    @RequiresPermissions("qywx:relation:remove")
    @Log(title = "分组信息与用户对应关系", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(wxUserGroupRelationService.deleteWxUserGroupRelationByIds(ids));
    }
}
