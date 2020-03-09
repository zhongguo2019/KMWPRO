package com.kmw.metadata.controller;

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
import com.kmw.metadata.domain.CdmShyhstdShyhallsubject;
import com.kmw.metadata.service.ICdmShyhstdShyhallsubjectService;
import com.kmw.common.utils.StringConvert;
import com.kmw.common.core.controller.BaseController;
import com.kmw.common.core.domain.AjaxResult;
import com.kmw.common.utils.poi.ExcelUtil;
import com.kmw.common.core.page.TableDataInfo;
import org.apache.commons.lang3.StringUtils;

/**
 * 商业银行案例四Controller
 * 
 * @author kmw
 * @date 2020-02-16
 */
@Controller
@RequestMapping("/metadata/shyhallsubject")
public class CdmShyhstdShyhallsubjectController extends BaseController {
	private String prefix = "metadata/shyhallsubject";

	@Autowired
	private ICdmShyhstdShyhallsubjectService cdmShyhstdShyhallsubjectService;

	@RequiresPermissions("metadata:shyhallsubject:view")
	@GetMapping()
	public String shyhallsubject() {
		return prefix + "/shyhallsubject";
	}

	/**
	 * 查询商业银行案例四列表
	 */
	@RequiresPermissions("metadata:shyhallsubject:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(CdmShyhstdShyhallsubject cdmShyhstdShyhallsubject) {
		startPage();
		List<CdmShyhstdShyhallsubject> list = cdmShyhstdShyhallsubjectService
				.selectCdmShyhstdShyhallsubjectList(cdmShyhstdShyhallsubject);
		return getDataTable(list);
	}

	/**
	 * 导出商业银行案例四列表
	 */
	@RequiresPermissions("metadata:shyhallsubject:export")
	@PostMapping("/export")
	@ResponseBody
	public AjaxResult export(CdmShyhstdShyhallsubject cdmShyhstdShyhallsubject) {
		List<CdmShyhstdShyhallsubject> list = cdmShyhstdShyhallsubjectService
				.selectCdmShyhstdShyhallsubjectList(cdmShyhstdShyhallsubject);
		ExcelUtil<CdmShyhstdShyhallsubject> util = new ExcelUtil<CdmShyhstdShyhallsubject>(
				CdmShyhstdShyhallsubject.class);
		return util.exportExcel(list, "shyhallsubject");
	}

	/**
	 * 新增商业银行案例四
	 */
	@GetMapping("/add")
	public String add() {
		return prefix + "/add";
	}

	/**
	 * 新增保存商业银行案例四
	 */
	@RequiresPermissions("metadata:shyhallsubject:add")
	@Log(title = "商业银行案例四", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(CdmShyhstdShyhallsubject cdmShyhstdShyhallsubject) {
		return toAjax(cdmShyhstdShyhallsubjectService.insertCdmShyhstdShyhallsubject(cdmShyhstdShyhallsubject));
	}

	/**
	 * 修改商业银行案例四
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap) {
		CdmShyhstdShyhallsubject cdmShyhstdShyhallsubject = cdmShyhstdShyhallsubjectService
				.selectCdmShyhstdShyhallsubjectById(id);
		mmap.put("cdmShyhstdShyhallsubject", cdmShyhstdShyhallsubject);
		return prefix + "/edit";
	}

	/**
	 * 修改保存商业银行案例四
	 */
	@RequiresPermissions("metadata:shyhallsubject:edit")
	@Log(title = "商业银行案例四", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(CdmShyhstdShyhallsubject cdmShyhstdShyhallsubject) {
		return toAjax(cdmShyhstdShyhallsubjectService.updateCdmShyhstdShyhallsubject(cdmShyhstdShyhallsubject));
	}

	/**
	 * 删除商业银行案例四
	 */
	@RequiresPermissions("metadata:shyhallsubject:remove")
	@Log(title = "商业银行案例四", businessType = BusinessType.DELETE)
	@PostMapping("/remove")
	@ResponseBody
	public AjaxResult remove(String ids) {
		return toAjax(cdmShyhstdShyhallsubjectService.deleteCdmShyhstdShyhallsubjectByIds(ids));
	}

	/**
	 * 查询案例二数据标准列表
	 */
	@RequiresPermissions("metadata:zsyhallsubject:list")
	@GetMapping("/listbysubject/{subjectName}")
	public String zsyhallsubject(@PathVariable("subjectName") String subjectName, ModelMap mmap) {
		/*
		 * CdmZsyhstdZsyhallsubject cdmZsyhstdZsyhallsubject = new
		 * CdmZsyhstdZsyhallsubject();
		 * cdmZsyhstdZsyhallsubject.setBankName(subjectName);
		 * mmap.put("cdmZsyhstdZsyhallsubject", cdmZsyhstdZsyhallsubject);
		 */

		mmap.put("subjectName", subjectName);
		return prefix + "/shyhallsubject_subject";
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
		logger.info("【通用实体查询】 分页显示当天工作记录信息表，Map参数：" + params.toString());
		TableDataInfo tableDataInfo = new TableDataInfo();
		params.put("pageNum", 0);
		params.put("pageSize", 100);
		if (params.containsKey("sortC")) { // 如果传过来的参数是驼峰式，这里需要将驼峰转成下划线式
			params.put("sortC", StringConvert.camelhumpToUnderline(params.get("sortC").toString()));
		}
		
		
		PageInfo<CommonEntity> page = cdmShyhstdShyhallsubjectService.queryPageInfoEntity(params);
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
		logger.info("【通用实体查询】 分页显示商业银行案例四信息，Map参数：" + params.toString());
		List<CommonEntity> listEntity = cdmShyhstdShyhallsubjectService.commonList(params);
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
		logger.info("【通用实体查询】 商业银行案例四信息，Map参数：" + params.toString());
		CommonEntity commonEntity = cdmShyhstdShyhallsubjectService.queryOne(params);
		return commonEntity;

	}


}
