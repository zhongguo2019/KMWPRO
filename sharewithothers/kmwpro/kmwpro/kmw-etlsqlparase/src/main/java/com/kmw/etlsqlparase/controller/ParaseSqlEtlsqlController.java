package com.kmw.etlsqlparase.controller;

import java.util.UUID;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
import com.kmw.etlsqlparase.domain.ParaseSqlEtlsql;
import com.kmw.etlsqlparase.service.IParaseSqlEtlsqlService;
import com.kmw.metadata.domain.CdmJsnxodsDictionary;
import com.kmw.metadata.domain.CdmJsnxodsTableall;
import com.kmw.metadata.service.ICdmJsnxodsDictionaryService;
import com.kmw.metadata.service.ICdmJsnxodsTableallService;
import com.kmw.utils.HiveParse;
import com.kmw.common.utils.StringConvert;
import com.kmw.common.core.controller.BaseController;
import com.kmw.common.core.domain.AjaxResult;
import com.kmw.common.utils.poi.ExcelUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.hadoop.hive.ql.parse.ParseException;
import org.apache.hadoop.hive.ql.parse.SemanticException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.kmw.common.core.page.TableDataInfo;

/**
 * 解析ETLController
 * 
 * @author kmw
 * @date 2020-03-15
 */
@Controller
@RequestMapping("/etlsqlparase/etlsql")
public class ParaseSqlEtlsqlController extends BaseController {
	private String prefix = "etlsqlparase/etlsql";

	@Autowired
	private IParaseSqlEtlsqlService paraseSqlEtlsqlService;
	
    @Autowired
    private ICdmJsnxodsTableallService cdmJsnxodsTableallService;
    
    
    @Autowired
    private ICdmJsnxodsDictionaryService cdmJsnxodsDictionaryService;
    
	protected Logger logger = LoggerFactory.getLogger(getClass());

	@RequiresPermissions("etlsqlparase:etlsql:view")
	@GetMapping()
	public String etlsql() {
		return prefix + "/etlsql";
	}

	/**
	 * @function 查询解析ETL列表
	 */
	@RequiresPermissions("etlsqlparase:etlsql:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(ParaseSqlEtlsql paraseSqlEtlsql) {
		startPage();
		List<ParaseSqlEtlsql> list = paraseSqlEtlsqlService.selectParaseSqlEtlsqlList(paraseSqlEtlsql);
		return getDataTable(list);
	}

	/**
	 * @function 导出解析ETL列表
	 */
	@RequiresPermissions("etlsqlparase:etlsql:export")
	@PostMapping("/export")
	@ResponseBody
	public AjaxResult export(ParaseSqlEtlsql paraseSqlEtlsql) {
		List<ParaseSqlEtlsql> list = paraseSqlEtlsqlService.selectParaseSqlEtlsqlList(paraseSqlEtlsql);
		ExcelUtil<ParaseSqlEtlsql> util = new ExcelUtil<ParaseSqlEtlsql>(ParaseSqlEtlsql.class);
		return util.exportExcel(list, "etlsql");
	}

	/**
	 * @function 新增解析ETL
	 */
	@GetMapping("/add")
	public String add() {
		return prefix + "/add";
	}

	/**
	 * @function 新增保存解析ETL
	 */
	@RequiresPermissions("etlsqlparase:etlsql:add")
	@Log(title = "解析ETL", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(ParaseSqlEtlsql paraseSqlEtlsql) {
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		paraseSqlEtlsql.setId(uuid);
		return toAjax(paraseSqlEtlsqlService.insertParaseSqlEtlsql(paraseSqlEtlsql));
	}

	/**
	 * @function 修改解析ETL
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap mmap) {
		ParaseSqlEtlsql paraseSqlEtlsql = paraseSqlEtlsqlService.selectParaseSqlEtlsqlById(id);
		mmap.put("paraseSqlEtlsql", paraseSqlEtlsql);
		return prefix + "/edit";
	}

	/**
	 * @function 修改保存解析ETL
	 */
	@RequiresPermissions("etlsqlparase:etlsql:edit")
	@Log(title = "解析ETL", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(ParaseSqlEtlsql paraseSqlEtlsql) {
		return toAjax(paraseSqlEtlsqlService.updateParaseSqlEtlsql(paraseSqlEtlsql));
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
		logger.info("【通用实体查询】 分页显示 解析ETL ，Map参数：" + params.toString());
		TableDataInfo tableDataInfo = new TableDataInfo();
		params.put("pageNum", 0);
		params.put("pageSize", 100);
		if (params.containsKey("sortC")) { // 如果传过来的参数是驼峰式，这里需要将驼峰转成下划线式
			params.put("sortC", StringConvert.camelhumpToUnderline(params.get("sortC").toString()));
		}
		PageInfo<CommonEntity> page = paraseSqlEtlsqlService.queryPageInfoEntity(params);
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
		logger.info("【通用实体查询】 分页显示 解析ETL ，Map参数：" + params.toString());
		List<CommonEntity> listEntity = paraseSqlEtlsqlService.commonList(params);
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
		logger.info("【通用实体查询】 解析ETL ，Map参数：" + params.toString());
		CommonEntity commonEntity = paraseSqlEtlsqlService.queryOne(params);
		return commonEntity;

	}

	/**
	 * @function 删除解析ETL
	 */
	@RequiresPermissions("etlsqlparase:etlsql:remove")
	@Log(title = "解析ETL", businessType = BusinessType.DELETE)
	@PostMapping("/remove")
	@ResponseBody
	public AjaxResult remove(String ids) {
		return toAjax(paraseSqlEtlsqlService.deleteParaseSqlEtlsqlByIds(ids));
	}

	/**
	 * @throws ParseException
	 * @throws IOException
	 * @throws SemanticException
	 * @function 删除解析ETL
	 */
	@RequiresPermissions("etlsqlparase:etlsql:parase")
	@Log(title = "解析ETL", businessType = BusinessType.INSERT)
	@PostMapping("/parasesql")
	@ResponseBody
	public AjaxResult paraseSql(String ids) throws SemanticException, IOException, ParseException {

		HiveParse hiveParse = new HiveParse();
		ParaseSqlEtlsql paraseSqlEtlsqlQueryEtlsql = paraseSqlEtlsqlService.selectParaseSqlEtlsqlById(ids);

		if (paraseSqlEtlsqlQueryEtlsql == null) {
			return AjaxResult.success("id对应的数据库sql为空！" + ids);
		}
		String etlsqlString = paraseSqlEtlsqlQueryEtlsql.getEtlSql();
		if (etlsqlString.equals("") || etlsqlString == null) {
			return AjaxResult.success("id对应的数据库sql为空！" + ids);
		}
		String strFromTabString = "";
		String strTargetTabString = "";
		String strColnamesString = "";
	    String strFromTabCnNameString="";
	    String strTargetTabCnNameString="";
		String strColnamesCnString = "";	    
		List<Map<String, Object>> listMapRtn = hiveParse.paraseSql(etlsqlString, "");
		if (listMapRtn != null && listMapRtn.size() != 0) {

			for (int ii = 0; ii < listMapRtn.size(); ii++) {
				Map<String, Object> mpOneMap = listMapRtn.get(ii);
				if (mpOneMap != null || mpOneMap.size() != 0) {
					strFromTabString = strFromTabString + mpOneMap.get("sourceTable").toString()
							+ System.lineSeparator();
					strTargetTabString = strTargetTabString + mpOneMap.get("targetTable").toString()
							+ System.lineSeparator();
					strColnamesString = strColnamesString + mpOneMap.get("colname").toString() + System.lineSeparator();
				}
			}
		}
		strFromTabString = filterRepeatLine(strFromTabString, System.lineSeparator());
		strColnamesString = filterRepeatLine(strColnamesString, System.lineSeparator());
		strTargetTabString = filterRepeatLine(strTargetTabString, System.lineSeparator());
		
		strFromTabCnNameString = getCnTableName(strFromTabString, System.lineSeparator());
		strTargetTabCnNameString = getCnTableName(strFromTabString, System.lineSeparator());
		strColnamesCnString = getCnColsName(strColnamesString, System.lineSeparator());
		
		paraseSqlEtlsqlQueryEtlsql.setSourceTblenname(strFromTabString);
		paraseSqlEtlsqlQueryEtlsql.setColumEnrelations(strColnamesString);
		paraseSqlEtlsqlQueryEtlsql.setTargetTblenname(strTargetTabString);
		return toAjax(paraseSqlEtlsqlService.updateParaseSqlEtlsql(paraseSqlEtlsqlQueryEtlsql));

	}

	public String filterRepeatLine(String inString, String splitString) {
		String outString = "";
		if (inString.equals("") || inString == null) {
		return outString;
		} else {
			String[] strSplitStrings = inString.split(splitString);
			Set<String> set = new HashSet<String>(Arrays.asList(strSplitStrings));
			outString = String.join(splitString, set);

		}
		return outString;
	}

	public String getCnTableName(String tabelName,String splitString) {
		String outString = "";
		if (tabelName.equals("") || tabelName == null) {
		return outString;
		} else {
			String[] strSplitStrings = tabelName.split(splitString);
			List<String> lstList=Arrays.asList(strSplitStrings);
			if(lstList!=null &lstList.size()!=0) {
				for(int jj=0;jj<lstList.size(); jj++) {
					
					String tableNameTmpString = lstList.get(jj).toString();
					logger.info("要分割一个英文表名"+tableNameTmpString);
					if(tableNameTmpString.equals("")) continue;
					
					String[] strTableStrings = tableNameTmpString.split( "\\." );
					logger.info("分割后的字符串数据长度" +strTableStrings.length);
					if(strTableStrings.length!=0) {

						CdmJsnxodsTableall  cdmJsnxodsTableall = new CdmJsnxodsTableall();
						String strQuyerTableNameString = strTableStrings[strTableStrings.length -1];
						logger.info("得到点以后，最后一个字符串，作为查询表为：" +strTableStrings[strTableStrings.length -1]);
						if(strTableStrings[strTableStrings.length -1]!=null&&strTableStrings[strTableStrings.length -1]!="") {
						cdmJsnxodsTableall.setTblEnname(strQuyerTableNameString);
					    List<CdmJsnxodsTableall>	lstCdmJsnxodsTablealls=cdmJsnxodsTableallService.selectCdmJsnxodsTableallList(cdmJsnxodsTableall);
						if(lstCdmJsnxodsTablealls!=null&&lstCdmJsnxodsTablealls.size()>0) {
							outString = outString+lstCdmJsnxodsTablealls.get(0).getTblCnname()+System.lineSeparator();
						}
						}
					}
				}
			}


		}	
		return outString;
	}

	public String getCnColsName(String tabelName,String splitString) {
		String outString = "";
		if (tabelName.equals("") || tabelName == null) {
		return outString;
		} else {
			if(tabelName.equals("")) {
				return outString;
			}
			String[] strSplitStrings = tabelName.split(splitString);
			logger.info("要分割一个英文表名加字段名"+tabelName );
			List<String> lstList=Arrays.asList(strSplitStrings);

			if(lstList!=null &lstList.size()!=0) {
				for(int jj=0;jj<lstList.size(); jj++) {
					if(!lstList.get(jj).toString().contains( "\\." )) {
						continue;
					}
					logger.info("要分割的字段名"+lstList.get(jj) );
					String strBeforeString = lstList.get(jj).toString();
					String[] strTableStrings = strBeforeString.split( "." );
					logger.info("按点分割后的List长度"+strTableStrings.length );		
					List<String> listTmpList = Arrays.asList(strTableStrings);
					logger.info("按点分割后的List长度"+listTmpList.size() );					
					if(listTmpList.size()>=2&&listTmpList!=null) {

						CdmJsnxodsDictionary  cdmJsnxodsDictionary = new CdmJsnxodsDictionary();
						String strQuyerTableNameString = listTmpList.get(listTmpList.size()-2);
						String strQueryColNameString =  listTmpList.get(listTmpList.size()-1);
						cdmJsnxodsDictionary.setFldEnname(strQueryColNameString);
						cdmJsnxodsDictionary.setTblEnname(strQuyerTableNameString);
					    List<CdmJsnxodsDictionary>	lstCdmJsnxodsTablealls=cdmJsnxodsDictionaryService.selectCdmJsnxodsDictionaryList(cdmJsnxodsDictionary);
						if(lstCdmJsnxodsTablealls!=null&&lstCdmJsnxodsTablealls.size()>0) {
							outString = outString+lstCdmJsnxodsTablealls.get(0).getTblCnname()+"."+lstCdmJsnxodsTablealls.get(0).getFldCnname();
						}
					}
				}
			}


		}	
		
		return outString;
	}
}
