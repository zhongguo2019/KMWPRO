package com.kmw.qywx.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kmw.qywx.mapper.KrmEmployeesMapper;
import com.kmw.qywx.domain.KrmEmployees;
import com.kmw.qywx.service.IKrmEmployeesService;
import com.kmw.system.service.ISysConfigService;
import com.kmw.common.core.text.Convert;
import com.kmw.common.exception.BusinessException;
import com.kmw.common.utils.DateUtils;
import com.kmw.common.utils.StringUtils;
import com.kmw.common.CommonEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 员工信息KRMService业务层处理
 * 
 * @author kmw
 * @date 2020-03-20
 */
@Service
public class KrmEmployeesServiceImpl implements IKrmEmployeesService {
	@Autowired
	private KrmEmployeesMapper krmEmployeesMapper;
	@Autowired
	private ISysConfigService configService;

	protected Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 查询员工信息KRM
	 * 
	 * @param id 员工信息KRMID
	 * @return 员工信息KRM
	 */
	@Override
	public KrmEmployees selectKrmEmployeesById(String id) {
		return krmEmployeesMapper.selectKrmEmployeesById(id);
	}

	/**
	 * 查询员工信息KRM列表
	 * 
	 * @param krmEmployees 员工信息KRM
	 * @return 员工信息KRM
	 */
	@Override
	public List<KrmEmployees> selectKrmEmployeesList(KrmEmployees krmEmployees) {
		return krmEmployeesMapper.selectKrmEmployeesList(krmEmployees);
	}

	/**
	 * 新增员工信息KRM
	 * 
	 * @param krmEmployees 员工信息KRM
	 * @return 结果
	 */
	@Override
	public int insertKrmEmployees(KrmEmployees krmEmployees) {
		return krmEmployeesMapper.insertKrmEmployees(krmEmployees);
	}

	/**
	 * 修改员工信息KRM
	 * 
	 * @param krmEmployees 员工信息KRM
	 * @return 结果
	 */
	@Override
	public int updateKrmEmployees(KrmEmployees krmEmployees) {
		return krmEmployeesMapper.updateKrmEmployees(krmEmployees);
	}

	/**
	 * 删除员工信息KRM对象
	 * 
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	@Override
	public int deleteKrmEmployeesByIds(String ids) {
		return krmEmployeesMapper.deleteKrmEmployeesByIds(Convert.toStrArray(ids));
	}

	/**
	 * 删除员工信息KRM信息
	 * 
	 * @param id 员工信息KRMID
	 * @return 结果
	 */
	@Override
	public int deleteKrmEmployeesById(String id) {
		return krmEmployeesMapper.deleteKrmEmployeesById(id);
	}

	/**
	 * 分页展示(可带条件查询) 员工信息KRM信息 通用实体查询，Map参数 返回的是通用实体，不受实体属性限制，相当于map
	 * 
	 * @param params
	 * @return
	 */
	public PageInfo<CommonEntity> queryPageInfoEntity(Map<String, Object> params) {
		List<CommonEntity> list = null;
		try {
			logger.info("#=================开始分页查询【员工信息KRM】数据，带动态权限========================#");
			PageHelper.startPage(params);
			list = krmEmployeesMapper.queryPageInfo(params);
			logger.info("#=================动态权限查询成功！=================================#");
		} catch (Exception e) {
			logger.info("#=================动态权限查询出错，原因如下：========================#");
			logger.info("#                 1、此表没有和机构或者用户相关联的字段                               #");
			logger.info(
					"#                 2、角色配置不正确                                                                     #");
			logger.info(
					"#                 3、SQL本身语法错误                                                                   #");
			logger.info("#=================系统默认处理机制：查询所有数据======================#");
			params.remove("dynamicSQL");
			PageHelper.startPage(params);
			list = krmEmployeesMapper.queryPageInfo(params);
		}
		return new PageInfo<CommonEntity>(list);
	}

	/**
	 * 列表(可带条件查询) 员工信息KRM信息 通用实体查询，Map参数 返回的是通用实体，不受实体属性限制，相当于map
	 * 
	 * @param params
	 * @return List<CommonEntity>
	 */
	public List<CommonEntity> commonList(Map<String, Object> params) {
		logger.info("#=================开始根据不同条件查询【员工信息KRM】列表数据，返回通用对象========================#");
		List<CommonEntity> list = krmEmployeesMapper.queryEntityList(params);
		return list;
	}

	/**
	 * 通用实体查询，Map参数,根据不同条件查询一条数据 员工信息KRM信息
	 * 
	 * @param params
	 * @return
	 */
	public CommonEntity queryOne(Map<String, Object> params) {
		logger.info("#=================开始根据不同条件查询一条【员工信息KRM】数据，返回实体对象========================#");

		return krmEmployeesMapper.queryOneCommon(params);

	}

	/**
	 * 更新操作
	 * 
	 * @param KrmEmployees
	 * @return
	 */
	public int updateBatch(List<KrmEmployees> list) {
		logger.info("#=================开始传入的实体列表更新【员工信息KRM】数据========================#");
		return krmEmployeesMapper.updateBatchEntity(list);
	}

	/**
	 * 根据不同组合条件删除
	 * 
	 * @param params
	 * @return
	 */
	public int deleteByParams(Map<String, Object> params) {
		logger.info("#=================开始根据不同条件删除【员工信息KRM】数据========================#");
		return krmEmployeesMapper.deleteByParams(params);
	}

	/**
	 * 批量保存操作
	 * 
	 * @param list
	 * @return
	 */
	public int insertBatch(List<KrmEmployees> list) {
		return krmEmployeesMapper.insertBatch(list);
	}

	/**
	 * 删除表中所有数据
	 * 
	 * @return int
	 */
	public int deleteAll() {
		logger.info("#=================删除表【员工信息KRM】所有数据========================#");
		return krmEmployeesMapper.deleteKrmEmployeesAll();
	}

	/**
	 * 列表(可带条件查询) 当天工作记录信息信息 通用实体查询，Map参数 返回的是通用实体，不受实体属性限制，相当于map
	 * 
	 * @param params
	 * @return List<krmEmployees>
	 */
	public List<KrmEmployees> entityList(Map<String, Object> params) {
		logger.info("#=================开始根据不同条件查询【【员工信息KRM】列表数据，返回通用对象========================#");
		List<KrmEmployees> list = krmEmployeesMapper.entityList(params);
		return list;
	}

	/**
	 * 导入员工信息
	 * 
	 * @param userList        用户数据列表
	 * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
	 * @param operName        操作用户
	 * @return 结果
	 */
	@Override
	public String importKrmEmployees(List<KrmEmployees> krmEmployeesList, Boolean isUpdateSupport, String operName) {
		if (krmEmployeesList == null || krmEmployeesList.size() == 0) {
			throw new BusinessException("导入用户数据不能为空！");
		}
		int successNum = 0;
		int failureNum = 0;
		StringBuilder successMsg = new StringBuilder();
		StringBuilder failureMsg = new StringBuilder();
		String password = configService.selectConfigByKey("sys.user.initPassword");
		for (KrmEmployees krmEmployees : krmEmployeesList) {
			try {

				Map<String, Object> paramsMap = new HashMap<String, Object>();
				paramsMap.put("oaCode", krmEmployees.getOaCode());

				// 验证是否已经存在
				List<KrmEmployees> lstQueryEmployees = krmEmployeesMapper.entityList(paramsMap);
                  
				if (lstQueryEmployees.size() == 0 || lstQueryEmployees == null) {
					String uuid = UUID.randomUUID().toString().replaceAll("-","");
					krmEmployees.setId(uuid);
					String strExcelDateString = krmEmployees.getEmpDate().toString();
					
                    krmEmployees.setEmpDate(DateUtils.getDateByDate10(strExcelDateString));
                    String strExcelDateString2 = krmEmployees.getBirDate();
                    krmEmployees.setBirDate(DateUtils.getDateByDate10( strExcelDateString2));
                    
                    
                    String strExcelDateString3 = krmEmployees.getGraduateTime();
                    krmEmployees.setGraduateTime(DateUtils.getDateByDate10( strExcelDateString3));
					this.insertKrmEmployees(krmEmployees);
					successNum++;
					successMsg.append("<br/>" + successNum + "、姓名 " + krmEmployees.getName() + " 导入成功");
				} else if (lstQueryEmployees.size() == 1) {
					krmEmployees.setUpdateBy(operName);
					this.updateKrmEmployees(krmEmployees);
					successNum++;
					successMsg.append("<br/>" + successNum + "、姓名 " + krmEmployees.getName() + " 更新成功");
				} else {
					failureNum++;
					failureMsg.append("<br/>" + failureNum + "、姓名 " + krmEmployees.getName() + " 已存在");
				}
			} catch (Exception e) {
				failureNum++;
				String msg = "<br/>" + failureNum + "、账号 " + krmEmployees.getName() + " 导入失败：";
				failureMsg.append(msg + e.getMessage());
				logger.error(msg, e);
			}
		}
		if (failureNum > 0) {
			failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
			throw new BusinessException(failureMsg.toString());
		} else {
			successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
		}
		return successMsg.toString();
	}

}
