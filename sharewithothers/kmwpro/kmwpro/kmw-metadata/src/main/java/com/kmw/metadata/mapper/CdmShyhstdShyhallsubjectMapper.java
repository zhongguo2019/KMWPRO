package com.kmw.metadata.mapper;

import com.kmw.common.CommonEntity;
import com.kmw.metadata.domain.CdmShyhstdShyhallsubject;
import java.util.List;
import java.util.Map;

/**
 * 商业银行案例四Mapper接口
 * 
 * @author kmw
 * @date 2020-02-16
 */
public interface CdmShyhstdShyhallsubjectMapper 
{
    /**
     * 查询商业银行案例四
     * 
     * @param id 商业银行案例四ID
     * @return 商业银行案例四
     */
    public CdmShyhstdShyhallsubject selectCdmShyhstdShyhallsubjectById(Long id);

    /**
     * 查询商业银行案例四列表
     * 
     * @param cdmShyhstdShyhallsubject 商业银行案例四
     * @return 商业银行案例四集合
     */
    public List<CdmShyhstdShyhallsubject> selectCdmShyhstdShyhallsubjectList(CdmShyhstdShyhallsubject cdmShyhstdShyhallsubject);

    /**
     * 新增商业银行案例四
     * 
     * @param cdmShyhstdShyhallsubject 商业银行案例四
     * @return 结果
     */
    public int insertCdmShyhstdShyhallsubject(CdmShyhstdShyhallsubject cdmShyhstdShyhallsubject);

    /**
     * 修改商业银行案例四
     * 
     * @param cdmShyhstdShyhallsubject 商业银行案例四
     * @return 结果
     */
    public int updateCdmShyhstdShyhallsubject(CdmShyhstdShyhallsubject cdmShyhstdShyhallsubject);

    /**
     * 删除商业银行案例四
     * 
     * @param id 商业银行案例四ID
     * @return 结果
     */
    public int deleteCdmShyhstdShyhallsubjectById(Long id);

    /**
     * 批量删除商业银行案例四
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCdmShyhstdShyhallsubjectByIds(String[] ids);
    
    
    
	/**
	 * 通用实体查询，Map参数 列表查询,返回的是通用实体，不受实体属性限制，相当于map
	 */
	List<CommonEntity> queryPageInfo(Map<String, Object> params);
	
	/**
	 * 通用实体查询，Map参数 列表查询,返回的是通用实体，不受实体属性限制，相当于map
	 */
	List<CommonEntity> queryEntityList(Map<String, Object> params);
	
	/**
	 * 通用实体查询，Map参数 查询单条数据,返回的是通用实体，不受实体属性限制，相当于map
	 */
	CommonEntity queryOneCommon(Map<String, Object> params);
	
	
}
