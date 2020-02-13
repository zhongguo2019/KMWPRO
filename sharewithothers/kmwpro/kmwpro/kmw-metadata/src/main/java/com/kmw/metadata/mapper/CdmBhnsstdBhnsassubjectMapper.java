package com.kmw.metadata.mapper;

import com.kmw.metadata.domain.CdmBhnsstdBhnsassubject;
import java.util.List;

/**
 * 资产主题Mapper接口
 * 
 * @author kmw
 * @date 2020-02-07
 */
public interface CdmBhnsstdBhnsassubjectMapper 
{
    /**
     * 查询资产主题
     * 
     * @param id 资产主题ID
     * @return 资产主题
     */
    public CdmBhnsstdBhnsassubject selectCdmBhnsstdBhnsassubjectById(Long id);

    /**
     * 查询资产主题列表
     * 
     * @param cdmBhnsstdBhnsassubject 资产主题
     * @return 资产主题集合
     */
    public List<CdmBhnsstdBhnsassubject> selectCdmBhnsstdBhnsassubjectList(CdmBhnsstdBhnsassubject cdmBhnsstdBhnsassubject);

    /**
     * 新增资产主题
     * 
     * @param cdmBhnsstdBhnsassubject 资产主题
     * @return 结果
     */
    public int insertCdmBhnsstdBhnsassubject(CdmBhnsstdBhnsassubject cdmBhnsstdBhnsassubject);

    /**
     * 修改资产主题
     * 
     * @param cdmBhnsstdBhnsassubject 资产主题
     * @return 结果
     */
    public int updateCdmBhnsstdBhnsassubject(CdmBhnsstdBhnsassubject cdmBhnsstdBhnsassubject);

    /**
     * 删除资产主题
     * 
     * @param id 资产主题ID
     * @return 结果
     */
    public int deleteCdmBhnsstdBhnsassubjectById(Long id);

    /**
     * 批量删除资产主题
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCdmBhnsstdBhnsassubjectByIds(String[] ids);
}
