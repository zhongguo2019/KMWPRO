package com.kmw.metadata.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kmw.metadata.mapper.CdmShyhstdShyhallsubjectMapper;
import com.kmw.metadata.domain.CdmShyhstdShyhallsubject;
import com.kmw.metadata.service.ICdmShyhstdShyhallsubjectService;
import com.kmw.common.CommonEntity;
import com.kmw.common.core.text.Convert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
/**
 * 商业银行案例四Service业务层处理
 * 
 * @author kmw
 * @date 2020-02-16
 */
@Service
public class CdmShyhstdShyhallsubjectServiceImpl implements ICdmShyhstdShyhallsubjectService 
{
    @Autowired
    private CdmShyhstdShyhallsubjectMapper cdmShyhstdShyhallsubjectMapper;
    protected Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 查询商业银行案例四
     * 
     * @param id 商业银行案例四ID
     * @return 商业银行案例四
     */
    @Override
    public CdmShyhstdShyhallsubject selectCdmShyhstdShyhallsubjectById(Long id)
    {
        return cdmShyhstdShyhallsubjectMapper.selectCdmShyhstdShyhallsubjectById(id);
    }

    /**
     * 查询商业银行案例四列表
     * 
     * @param cdmShyhstdShyhallsubject 商业银行案例四
     * @return 商业银行案例四
     */
    @Override
    public List<CdmShyhstdShyhallsubject> selectCdmShyhstdShyhallsubjectList(CdmShyhstdShyhallsubject cdmShyhstdShyhallsubject)
    {
        return cdmShyhstdShyhallsubjectMapper.selectCdmShyhstdShyhallsubjectList(cdmShyhstdShyhallsubject);
    }

    /**
     * 新增商业银行案例四
     * 
     * @param cdmShyhstdShyhallsubject 商业银行案例四
     * @return 结果
     */
    @Override
    public int insertCdmShyhstdShyhallsubject(CdmShyhstdShyhallsubject cdmShyhstdShyhallsubject)
    {
        return cdmShyhstdShyhallsubjectMapper.insertCdmShyhstdShyhallsubject(cdmShyhstdShyhallsubject);
    }

    /**
     * 修改商业银行案例四
     * 
     * @param cdmShyhstdShyhallsubject 商业银行案例四
     * @return 结果
     */
    @Override
    public int updateCdmShyhstdShyhallsubject(CdmShyhstdShyhallsubject cdmShyhstdShyhallsubject)
    {
        return cdmShyhstdShyhallsubjectMapper.updateCdmShyhstdShyhallsubject(cdmShyhstdShyhallsubject);
    }

    /**
     * 删除商业银行案例四对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCdmShyhstdShyhallsubjectByIds(String ids)
    {
        return cdmShyhstdShyhallsubjectMapper.deleteCdmShyhstdShyhallsubjectByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除商业银行案例四信息
     * 
     * @param id 商业银行案例四ID
     * @return 结果
     */
    @Override
    public int deleteCdmShyhstdShyhallsubjectById(Long id)
    {
        return cdmShyhstdShyhallsubjectMapper.deleteCdmShyhstdShyhallsubjectById(id);
    }
    
	/**
	 * 分页展示(可带条件查询)
	 * 通用实体查询，Map参数 返回的是通用实体，不受实体属性限制，相当于map
	 * @param params
	 * @return
	 */
	public PageInfo<CommonEntity> queryPageInfoEntity(Map<String, Object> params) {
		List<CommonEntity> list = null;
		try {
			logger.info("#=================开始分页查询【当天工作记录信息表】数据，带动态权限========================#");
			PageHelper.startPage(params);
			list = cdmShyhstdShyhallsubjectMapper.queryPageInfo(params);
			logger.info("#=================动态权限查询成功！=================================#");
		} catch (Exception e) {
			logger.info("#=================动态权限查询出错，原因如下：========================#");
			logger.info("#                 1、此表没有和机构或者用户相关联的字段                               #");
			logger.info("#                 2、角色配置不正确                                                                     #");
			logger.info("#                 3、SQL本身语法错误                                                                   #");
			logger.info("#=================系统默认处理机制：查询所有数据======================#");
			params.remove("dynamicSQL");
			PageHelper.startPage(params);
			list = cdmShyhstdShyhallsubjectMapper.queryPageInfo(params);
		}
		return new PageInfo<CommonEntity>(list);
	}
	
	/**
	 * 列表(可带条件查询)
	 * 通用实体查询，Map参数 返回的是通用实体，不受实体属性限制，相当于map
	 * @param params
	 * @return List<CommonEntity>
	 */
	public List<CommonEntity> commonList(Map<String, Object> params) {
		logger.info("#=================开始根据不同条件查询【当天工作记录信息表】列表数据，返回通用对象========================#");
		List<CommonEntity> list = cdmShyhstdShyhallsubjectMapper.queryEntityList(params);
		return list;
	}
	
	/**
	 * 通用实体查询，Map参数,根据不同条件查询一条数据
	 * @param params
	 * @return
	 */
	public CommonEntity queryOne(Map<String, Object> params){
		logger.info("#=================开始根据不同条件查询一条【当天工作记录信息表】数据，返回实体对象========================#");
		if(params.containsKey("id")) {
		return cdmShyhstdShyhallsubjectMapper.queryOneCommon(params);
		}else {
			logger.info("#=================按主键查询一条实体，Map参数中 id不能为空========================#");
	 return null;
		}
	}
    
}
