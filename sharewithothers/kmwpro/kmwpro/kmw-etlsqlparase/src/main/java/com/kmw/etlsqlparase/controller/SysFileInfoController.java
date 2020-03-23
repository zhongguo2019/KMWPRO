package com.kmw.etlsqlparase.controller;

import java.util.UUID;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.eclipse.jetty.util.StringUtil;
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
import com.kmw.common.config.Global;
import com.kmw.common.enums.BusinessType;
import com.kmw.etlsqlparase.domain.ParaseSqlEtlsql;
import com.kmw.etlsqlparase.domain.SysFileInfo;
import com.kmw.etlsqlparase.service.IParaseSqlEtlsqlService;
import com.kmw.etlsqlparase.service.ISysFileInfoService;
import com.kmw.etlsqlparase.service.impl.SysFileInfoServiceImpl;
import com.kmw.common.utils.StringConvert;
import com.kmw.common.utils.file.FileUploadUtils;
import com.kmw.common.utils.file.FileUtils;
import com.kmw.common.core.controller.BaseController;
import com.kmw.common.core.domain.AjaxResult;
import com.kmw.common.utils.poi.ExcelUtil;

import org.apache.commons.io.FilenameUtils;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.kmw.common.core.page.TableDataInfo;
import com.kmw.common.utils.StringUtils;
/**
 * 文件信息Controller
 * 
 * @author kmw
 * @date 2020-03-14
 */
@Controller
@RequestMapping("/etlsqlparase/info")
public class SysFileInfoController extends BaseController {
	private String prefix = "etlsqlparase/info";

	@Autowired
	private ISysFileInfoService sysFileInfoService;
	@Autowired
	private IParaseSqlEtlsqlService paraseSqlEtlsqlService;

	protected Logger logger = LoggerFactory.getLogger(getClass());

	@RequiresPermissions("etlsqlparase:info:view")
	@GetMapping()
	public String info() {
		return prefix + "/info";
	}

	/**
	 * @function 查询文件信息列表
	 */
	@RequiresPermissions("etlsqlparase:info:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(SysFileInfo sysFileInfo) {
		startPage();
		List<SysFileInfo> list = sysFileInfoService.selectSysFileInfoList(sysFileInfo);
		return getDataTable(list);
	}

	/**
	 * @function 导出文件信息列表
	 */
	@RequiresPermissions("etlsqlparase:info:export")
	@PostMapping("/export")
	@ResponseBody
	public AjaxResult export(SysFileInfo sysFileInfo) {
		List<SysFileInfo> list = sysFileInfoService.selectSysFileInfoList(sysFileInfo);
		ExcelUtil<SysFileInfo> util = new ExcelUtil<SysFileInfo>(SysFileInfo.class);
		return util.exportExcel(list, "info");
	}

	/**
	 * @function 新增文件信息
	 */
	@GetMapping("/add")
	public String add() {
		return prefix + "/add";
	}

	/**
	 * @function 新增保存文件信息
	 */
	@RequiresPermissions("etlsqlparase:info:add")
	@Log(title = "文件信息", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(@RequestParam("file") MultipartFile file, SysFileInfo fileInfo) throws IOException {

		AjaxResult ajaxResult = new AjaxResult();
		// 上传文件路径
		String filePath = Global.getUploadPath();

		// fileInfo.setFileName();

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("fileName", file.getOriginalFilename());

		List<CommonEntity> lstExist = sysFileInfoService.commonList(params);
		if (lstExist != null&&lstExist.size()>0) {
			 
				return AjaxResult.success("该文件已经在数据库中存在，请重新选择新的文件！");
 
		}

		// 上传并返回新文件名称
		String fileName = FileUploadUtils.upload(filePath, file);

		fileInfo.setFilePath(fileName);
		fileInfo.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		fileInfo.setFileName(file.getOriginalFilename());

		String extension = FileUploadUtils.getExtension(file);
		
	logger.info("path01\n"+	FileUploadUtils.getAbsoluteFile(filePath, fileName));
	logger.info("path02\n"+	FileUploadUtils.extractFilename(file));
	logger.info("filePath\n"+	filePath);
	logger.info("fileName\n"+	fileName);
	//logger.info("path01\n"+	FileUploadUtils.getAbsoluteFile(filePath, fileName));
	
		// 读取文本文件内容
		if (extension.toUpperCase().equals("SQL")) {
			
			String fileContentString = FileUploadUtils.readTxtFileContent(file);
			// 将文本信息存到后台的数据库中
			ParaseSqlEtlsql paraseEtlsql = new ParaseSqlEtlsql();
			
			paraseEtlsql.setEtlSql(StringUtils.toUTF8(FileUploadUtils.filterSqlComment(fileContentString)) );
			paraseEtlsql.setEtlSqlType("HIVESQL");
			paraseEtlsql.setRemark("通过文件导入");
			paraseEtlsql.setId(UUID.randomUUID().toString().replaceAll("-", ""));
			paraseSqlEtlsqlService.insertParaseSqlEtlsql(paraseEtlsql);
		}

		return toAjax(sysFileInfoService.insertSysFileInfo(fileInfo));
	}

	/**
	 * @function 修改文件信息
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap) {
		SysFileInfo sysFileInfo = sysFileInfoService.selectSysFileInfoById(id);
		mmap.put("sysFileInfo", sysFileInfo);
		return prefix + "/edit";
	}

	/**
	 * @function 修改保存文件信息
	 */
	@RequiresPermissions("etlsqlparase:info:edit")
	@Log(title = "文件信息", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(SysFileInfo sysFileInfo) {
		return toAjax(sysFileInfoService.updateSysFileInfo(sysFileInfo));
	}

	/**
	 * @function 按Map参数据查询，得到公共实体后分页
	 * 
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "queryPageInfo", method = RequestMethod.POST)
	@ResponseBody
	public PageInfo<CommonEntity> PageInfo(@RequestParam Map<String, Object> params, Model model) {
		logger.info("【通用实体查询】 分页显示 文件信息 ，Map参数：" + params.toString());
		TableDataInfo tableDataInfo = new TableDataInfo();
		params.put("pageNum", 0);
		params.put("pageSize", 100);
		if (params.containsKey("sortC")) { // 如果传过来的参数是驼峰式，这里需要将驼峰转成下划线式
			params.put("sortC", StringConvert.camelhumpToUnderline(params.get("sortC").toString()));
		}
		PageInfo<CommonEntity> page = sysFileInfoService.queryPageInfoEntity(params);
		return page;

	}

	/**
	 * @function 前台分页显示
	 * 
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "tableDataInfo", method = RequestMethod.POST)
	@ResponseBody
	public TableDataInfo tableDataInfo(@RequestParam Map<String, Object> params, Model model) {
		logger.info("【通用实体查询】 分页显示 文件信息 ，Map参数：" + params.toString());
		List<CommonEntity> listEntity = sysFileInfoService.commonList(params);
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
		logger.info("【通用实体查询】 文件信息 ，Map参数：" + params.toString());
		CommonEntity commonEntity = sysFileInfoService.queryOne(params);
		return commonEntity;

	}

	/**
	 * @function 删除文件信息
	 */
	@RequiresPermissions("etlsqlparase:info:remove")
	@Log(title = "文件信息", businessType = BusinessType.DELETE)
	@PostMapping("/remove")
	@ResponseBody
	public AjaxResult remove(String ids) {
		return toAjax(sysFileInfoService.deleteSysFileInfoByIds(ids));
	}
}
