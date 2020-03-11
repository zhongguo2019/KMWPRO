package com.kmw.etlsqlparase.controller;

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
import com.kmw.etlsqlparase.domain.ParaseEtlsql;
import com.kmw.etlsqlparase.service.IParaseEtlsqlService;
import com.kmw.common.utils.StringConvert;
import com.kmw.common.core.controller.BaseController;
import com.kmw.common.core.domain.AjaxResult;
import com.kmw.common.utils.poi.ExcelUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.kmw.common.core.page.TableDataInfo;


/**
 * 解析ETL加工过程的SQL语法得到中文解释Controller
 * 
 * @author kmw
 * @date 2020-03-02
 */
@Controller
@RequestMapping("/etlsqlparase/etlsql")
public class ParaseEtlsqlController extends BaseController
{
    private String prefix = "etlsqlparase/etlsql";

    @Autowired
    private IParaseEtlsqlService paraseEtlsqlService;
    protected Logger logger = LoggerFactory.getLogger(getClass());
    @RequiresPermissions("etlsqlparase:etlsql:view")
    @GetMapping()
    public String etlsql()
    {
        return prefix + "/etlsql";
    }

 /**
 *@function 查询解析ETL加工过程的SQL语法得到中文解释列表
 */
    @RequiresPermissions("etlsqlparase:etlsql:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ParaseEtlsql paraseEtlsql)
    {
        startPage();
        List<ParaseEtlsql> list = paraseEtlsqlService.selectParaseEtlsqlList(paraseEtlsql);
        return getDataTable(list);
    }

/**
*@function  导出解析ETL加工过程的SQL语法得到中文解释列表
*/
    @RequiresPermissions("etlsqlparase:etlsql:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ParaseEtlsql paraseEtlsql)
    {
        List<ParaseEtlsql> list = paraseEtlsqlService.selectParaseEtlsqlList(paraseEtlsql);
        ExcelUtil<ParaseEtlsql> util = new ExcelUtil<ParaseEtlsql>(ParaseEtlsql.class);
        return util.exportExcel(list, "etlsql");
    }

/**
*@function  新增解析ETL加工过程的SQL语法得到中文解释
*/
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

/**
*@function  新增保存解析ETL加工过程的SQL语法得到中文解释
*/
    @RequiresPermissions("etlsqlparase:etlsql:add")
    @Log(title = "解析ETL加工过程的SQL语法得到中文解释", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ParaseEtlsql paraseEtlsql)
    {
        return toAjax(paraseEtlsqlService.insertParaseEtlsql(paraseEtlsql));
    }

/**
*@function 修改解析ETL加工过程的SQL语法得到中文解释
*/
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        ParaseEtlsql paraseEtlsql = paraseEtlsqlService.selectParaseEtlsqlById(id);
        mmap.put("paraseEtlsql", paraseEtlsql);
        return prefix + "/edit";
    }

/**
*@function 修改保存解析ETL加工过程的SQL语法得到中文解释
*/
    @RequiresPermissions("etlsqlparase:etlsql:edit")
    @Log(title = "解析ETL加工过程的SQL语法得到中文解释", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ParaseEtlsql paraseEtlsql)
    {
        return toAjax(paraseEtlsqlService.updateParaseEtlsql(paraseEtlsql));
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
		logger.info("【通用实体查询】 分页显示 解析ETL加工过程的SQL语法得到中文解释 ，Map参数：" + params.toString());
		TableDataInfo tableDataInfo = new TableDataInfo();
		params.put("pageNum", 0);
		params.put("pageSize", 100);
		if (params.containsKey("sortC")) { // 如果传过来的参数是驼峰式，这里需要将驼峰转成下划线式
			params.put("sortC", StringConvert.camelhumpToUnderline(params.get("sortC").toString()));
		}
		PageInfo<CommonEntity> page = paraseEtlsqlService.queryPageInfoEntity(params);
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
		logger.info("【通用实体查询】 分页显示 解析ETL加工过程的SQL语法得到中文解释 ，Map参数：" + params.toString());
		List<CommonEntity> listEntity = paraseEtlsqlService.commonList(params);
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
		logger.info("【通用实体查询】 解析ETL加工过程的SQL语法得到中文解释 ，Map参数：" + params.toString());
		CommonEntity commonEntity = paraseEtlsqlService.queryOne(params);
		return commonEntity;

	}



/**
*  @function 删除解析ETL加工过程的SQL语法得到中文解释
*/
    @RequiresPermissions("etlsqlparase:etlsql:remove")
    @Log(title = "解析ETL加工过程的SQL语法得到中文解释", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(paraseEtlsqlService.deleteParaseEtlsqlByIds(ids));
    }
}
