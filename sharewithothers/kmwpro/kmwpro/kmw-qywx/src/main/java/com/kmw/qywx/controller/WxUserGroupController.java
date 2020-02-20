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
import com.kmw.qywx.domain.WxUserGroup;
import com.kmw.qywx.service.IWxUserGroupService;
import com.kmw.utils.StringConvert;
import com.kmw.common.core.controller.BaseController;
import com.kmw.common.core.domain.AjaxResult;
import com.kmw.common.utils.poi.ExcelUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.kmw.common.core.page.TableDataInfo;


/**
 * 微信用户分组信息Controller
 * 
 * @author kmw
 * @date 2020-02-20
 */
@Controller
@RequestMapping("/qywx/group")
public class WxUserGroupController extends BaseController
{
    private String prefix = "qywx/group";

    @Autowired
    private IWxUserGroupService wxUserGroupService;
    protected Logger logger = LoggerFactory.getLogger(getClass());
    @RequiresPermissions("qywx:group:view")
    @GetMapping()
    public String group()
    {
        return prefix + "/group";
    }

    /**
     * 查询微信用户分组信息列表
     */
    @RequiresPermissions("qywx:group:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(WxUserGroup wxUserGroup)
    {
        startPage();
        List<WxUserGroup> list = wxUserGroupService.selectWxUserGroupList(wxUserGroup);
        return getDataTable(list);
    }

    /**
     * 导出微信用户分组信息列表
     */
    @RequiresPermissions("qywx:group:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(WxUserGroup wxUserGroup)
    {
        List<WxUserGroup> list = wxUserGroupService.selectWxUserGroupList(wxUserGroup);
        ExcelUtil<WxUserGroup> util = new ExcelUtil<WxUserGroup>(WxUserGroup.class);
        return util.exportExcel(list, "group");
    }

    /**
     * 新增微信用户分组信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存微信用户分组信息
     */
    @RequiresPermissions("qywx:group:add")
    @Log(title = "微信用户分组信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(WxUserGroup wxUserGroup)
    {
        return toAjax(wxUserGroupService.insertWxUserGroup(wxUserGroup));
    }

    /**
     * 修改微信用户分组信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        WxUserGroup wxUserGroup = wxUserGroupService.selectWxUserGroupById(id);
        mmap.put("wxUserGroup", wxUserGroup);
        return prefix + "/edit";
    }

    /**
     * 修改保存微信用户分组信息
     */
    @RequiresPermissions("qywx:group:edit")
    @Log(title = "微信用户分组信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(WxUserGroup wxUserGroup)
    {
        return toAjax(wxUserGroupService.updateWxUserGroup(wxUserGroup));
    }

	/**
	 *按Map参数据查询，得到公共实体后分页
	 * 
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "queryPageInfo", method = RequestMethod.POST)
	@ResponseBody
	public PageInfo PageInfo(@RequestParam Map<String, Object> params, Model model) {
		logger.info("【通用实体查询】 分页显示 微信用户分组信息 ，Map参数：" + params.toString());
		TableDataInfo tableDataInfo = new TableDataInfo();
		params.put("pageNum", 0);
		params.put("pageSize", 100);
		if (params.containsKey("sortC")) { // 如果传过来的参数是驼峰式，这里需要将驼峰转成下划线式
			params.put("sortC", StringConvert.camelhumpToUnderline(params.get("sortC").toString()));
		}
		
		
		PageInfo<CommonEntity> page = wxUserGroupService.queryPageInfoEntity(params);
		return page;

	}

	/**
	 * 前台分页显示
	 * 
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "tableDataInfo", method = RequestMethod.POST)
	@ResponseBody
	public TableDataInfo tableDataInfo(@RequestParam Map<String, Object> params, Model model) {
		logger.info("【通用实体查询】 分页显示 微信用户分组信息 ，Map参数：" + params.toString());
		List<CommonEntity> listEntity = wxUserGroupService.commonList(params);
		return getDataTable(listEntity);

	}

	/**
	 * 查询一条记录
	 * 
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "queryOneEntity", method = RequestMethod.POST)
	@ResponseBody
	public CommonEntity queryOne(@RequestParam Map<String, Object> params, ModelMap mmap) {
		logger.info("【通用实体查询】 微信用户分组信息 ，Map参数：" + params.toString());
		CommonEntity commonEntity = wxUserGroupService.queryOne(params);
		return commonEntity;

	}



    /**
     * 删除微信用户分组信息
     */
    @RequiresPermissions("qywx:group:remove")
    @Log(title = "微信用户分组信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(wxUserGroupService.deleteWxUserGroupByIds(ids));
    }
}
