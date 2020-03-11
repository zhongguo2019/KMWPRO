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
import com.kmw.qywx.domain.QywxUserOperatelog;
import com.kmw.qywx.service.IQywxUserOperatelogService;
import com.kmw.common.utils.StringConvert;
import com.kmw.common.core.controller.BaseController;
import com.kmw.common.core.domain.AjaxResult;
import com.kmw.common.utils.poi.ExcelUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.kmw.common.core.page.TableDataInfo;


/**
 * 保留用户每次提交的消息内容Controller
 * 
 * @author kmw
 * @date 2020-03-04
 */
@Controller
@RequestMapping("/qywx/operatelog")
public class QywxUserOperatelogController extends BaseController
{
    private String prefix = "qywx/operatelog";

    @Autowired
    private IQywxUserOperatelogService qywxUserOperatelogService;
    protected Logger logger = LoggerFactory.getLogger(getClass());
    @RequiresPermissions("qywx:operatelog:view")
    @GetMapping()
    public String operatelog()
    {
        return prefix + "/operatelog";
    }

 /**
 *@function 查询保留用户每次提交的消息内容列表
 */
    @RequiresPermissions("qywx:operatelog:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(QywxUserOperatelog qywxUserOperatelog)
    {
        startPage();
        List<QywxUserOperatelog> list = qywxUserOperatelogService.selectQywxUserOperatelogList(qywxUserOperatelog);
        return getDataTable(list);
    }

/**
*@function  导出保留用户每次提交的消息内容列表
*/
    @RequiresPermissions("qywx:operatelog:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(QywxUserOperatelog qywxUserOperatelog)
    {
        List<QywxUserOperatelog> list = qywxUserOperatelogService.selectQywxUserOperatelogList(qywxUserOperatelog);
        ExcelUtil<QywxUserOperatelog> util = new ExcelUtil<QywxUserOperatelog>(QywxUserOperatelog.class);
        return util.exportExcel(list, "operatelog");
    }

/**
*@function  新增保留用户每次提交的消息内容
*/
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

/**
*@function  新增保存保留用户每次提交的消息内容
*/
    @RequiresPermissions("qywx:operatelog:add")
    @Log(title = "保留用户每次提交的消息内容", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(QywxUserOperatelog qywxUserOperatelog)
    {
        return toAjax(qywxUserOperatelogService.insertQywxUserOperatelog(qywxUserOperatelog));
    }

/**
*@function 修改保留用户每次提交的消息内容
*/
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        QywxUserOperatelog qywxUserOperatelog = qywxUserOperatelogService.selectQywxUserOperatelogById(id);
        mmap.put("qywxUserOperatelog", qywxUserOperatelog);
        return prefix + "/edit";
    }

/**
*@function 修改保存保留用户每次提交的消息内容
*/
    @RequiresPermissions("qywx:operatelog:edit")
    @Log(title = "保留用户每次提交的消息内容", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(QywxUserOperatelog qywxUserOperatelog)
    {
        return toAjax(qywxUserOperatelogService.updateQywxUserOperatelog(qywxUserOperatelog));
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
		logger.info("【通用实体查询】 分页显示 保留用户每次提交的消息内容 ，Map参数：" + params.toString());
		TableDataInfo tableDataInfo = new TableDataInfo();
		params.put("pageNum", 0);
		params.put("pageSize", 100);
		if (params.containsKey("sortC")) { // 如果传过来的参数是驼峰式，这里需要将驼峰转成下划线式
			params.put("sortC", StringConvert.camelhumpToUnderline(params.get("sortC").toString()));
		}
		PageInfo<CommonEntity> page = qywxUserOperatelogService.queryPageInfoEntity(params);
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
		logger.info("【通用实体查询】 分页显示 保留用户每次提交的消息内容 ，Map参数：" + params.toString());
		List<CommonEntity> listEntity = qywxUserOperatelogService.commonList(params);
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
		logger.info("【通用实体查询】 保留用户每次提交的消息内容 ，Map参数：" + params.toString());
		CommonEntity commonEntity = qywxUserOperatelogService.queryOne(params);
		return commonEntity;

	}



/**
*  @function 删除保留用户每次提交的消息内容
*/
    @RequiresPermissions("qywx:operatelog:remove")
    @Log(title = "保留用户每次提交的消息内容", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(qywxUserOperatelogService.deleteQywxUserOperatelogByIds(ids));
    }
}
