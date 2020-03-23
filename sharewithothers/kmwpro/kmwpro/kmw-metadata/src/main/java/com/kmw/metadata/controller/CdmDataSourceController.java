package com.kmw.metadata.controller;
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
import com.github.pagehelper.PageInfo;
import com.kmw.common.CommonEntity;
import com.kmw.common.annotation.Log;
import com.kmw.common.enums.BusinessType;
import com.kmw.metadata.domain.CdmDataSource;
import com.kmw.metadata.service.ICdmDataSourceService;
import com.kmw.common.utils.StringConvert;
import com.kmw.common.core.controller.BaseController;
import com.kmw.common.core.domain.AjaxResult;
import com.kmw.common.utils.poi.ExcelUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.kmw.common.core.page.TableDataInfo;


/**
 * 数据源管理Controller
 * 
 * @author kmw
 * @date 2020-03-23
 */
@Controller
@RequestMapping("/metadata/source")
public class CdmDataSourceController extends BaseController
{
    private String prefix = "metadata/source";

    @Autowired
    private ICdmDataSourceService cdmDataSourceService;
    protected Logger logger = LoggerFactory.getLogger(getClass());
    @RequiresPermissions("metadata:source:view")
    @GetMapping()
    public String source()
    {
        return prefix + "/source";
    }

 /**
 *@function 查询数据源管理列表
 */
    @RequiresPermissions("metadata:source:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CdmDataSource cdmDataSource)
    {
        startPage();
        List<CdmDataSource> list = cdmDataSourceService.selectCdmDataSourceList(cdmDataSource);
        return getDataTable(list);
    }

/**
*@function  导出数据源管理列表
*/
    @RequiresPermissions("metadata:source:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CdmDataSource cdmDataSource)
    {
        List<CdmDataSource> list = cdmDataSourceService.selectCdmDataSourceList(cdmDataSource);
        ExcelUtil<CdmDataSource> util = new ExcelUtil<CdmDataSource>(CdmDataSource.class);
        return util.exportExcel(list, "source");
    }

/**
*@function  新增数据源管理
*/
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

/**
*@function  新增保存数据源管理
*/
    @RequiresPermissions("metadata:source:add")
    @Log(title = "数据源管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CdmDataSource cdmDataSource)
    {
        String uuid = UUID.randomUUID().toString().replaceAll("-","");
    	cdmDataSource.setId(uuid);
        return toAjax(cdmDataSourceService.insertCdmDataSource(cdmDataSource));
    }

/**
*@function 修改数据源管理
*/
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        CdmDataSource cdmDataSource = cdmDataSourceService.selectCdmDataSourceById(id);
        mmap.put("cdmDataSource", cdmDataSource);
        return prefix + "/edit";
    }

/**
*@function 修改保存数据源管理
*/
    @RequiresPermissions("metadata:source:edit")
    @Log(title = "数据源管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CdmDataSource cdmDataSource)
    {
        return toAjax(cdmDataSourceService.updateCdmDataSource(cdmDataSource));
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
		logger.info("【通用实体查询】 分页显示 数据源管理 ，Map参数：" + params.toString());
		TableDataInfo tableDataInfo = new TableDataInfo();
		params.put("pageNum", 0);
		params.put("pageSize", 100);
		if (params.containsKey("sortC")) { // 如果传过来的参数是驼峰式，这里需要将驼峰转成下划线式
			params.put("sortC", StringConvert.camelhumpToUnderline(params.get("sortC").toString()));
		}
		PageInfo<CommonEntity> page = cdmDataSourceService.queryPageInfoEntity(params);
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
		logger.info("【通用实体查询】 分页显示 数据源管理 ，Map参数：" + params.toString());
		List<CommonEntity> listEntity = cdmDataSourceService.commonList(params);
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
		logger.info("【通用实体查询】 数据源管理 ，Map参数：" + params.toString());
		CommonEntity commonEntity = cdmDataSourceService.queryOne(params);
		return commonEntity;

	}



/**
*  @function 删除数据源管理
*/
    @RequiresPermissions("metadata:source:remove")
    @Log(title = "数据源管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(cdmDataSourceService.deleteCdmDataSourceByIds(ids));
    }
}
