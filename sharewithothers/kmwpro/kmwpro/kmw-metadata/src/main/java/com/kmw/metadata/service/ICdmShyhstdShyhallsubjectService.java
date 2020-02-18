package com.kmw.metadata.service;

import com.github.pagehelper.PageInfo;
import com.kmw.common.CommonEntity;
import com.kmw.metadata.domain.CdmShyhstdShyhallsubject;
import java.util.List;
import java.util.Map;

/**
 * 商业银行案例四Service接口
 * 
 * @author kmw
 * @date 2020-02-16
 */
public interface ICdmShyhstdShyhallsubjectService 
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
     * 批量删除商业银行案例四
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCdmShyhstdShyhallsubjectByIds(String ids);

    /**
     * 删除商业银行案例四信息
     * 
     * @param id 商业银行案例四ID
     * @return 结果
     */
    public int deleteCdmShyhstdShyhallsubjectById(Long id);
    
	/**
	 * 分页展示(可带条件查询)
	 * 返回的是通用实体，不受实体属性限制，相当于map
	 * @param params
	 * @return
	 */
    
	public PageInfo<CommonEntity> queryPageInfoEntity(Map<String, Object> params);
	
	/**
	 * 列表(可带条件查询)
	 * 返回的是通用实体，不受实体属性限制，相当于map
	 * @param params
	 * @return List<CommonEntity>
	 */
	
	public List<CommonEntity> commonList(Map<String, Object> params);
	
	/**
	 * 根据不同条件查询一条数据
	 * @param params
	 * @return
	 */
	public CommonEntity queryOne(Map<String, Object> params);
}
