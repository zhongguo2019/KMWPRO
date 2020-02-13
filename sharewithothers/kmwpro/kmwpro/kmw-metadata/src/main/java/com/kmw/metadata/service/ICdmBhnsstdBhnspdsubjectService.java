package com.kmw.metadata.service;

import com.kmw.metadata.domain.CdmBhnsstdBhnspdsubject;
import java.util.List;

/**
 * 产品主题Service接口
 * 
 * @author kmw
 * @date 2020-02-07
 */
public interface ICdmBhnsstdBhnspdsubjectService 
{
    /**
     * 查询产品主题
     * 
     * @param id 产品主题ID
     * @return 产品主题
     */
    public CdmBhnsstdBhnspdsubject selectCdmBhnsstdBhnspdsubjectById(Long id);

    /**
     * 查询产品主题列表
     * 
     * @param cdmBhnsstdBhnspdsubject 产品主题
     * @return 产品主题集合
     */
    public List<CdmBhnsstdBhnspdsubject> selectCdmBhnsstdBhnspdsubjectList(CdmBhnsstdBhnspdsubject cdmBhnsstdBhnspdsubject);

    /**
     * 新增产品主题
     * 
     * @param cdmBhnsstdBhnspdsubject 产品主题
     * @return 结果
     */
    public int insertCdmBhnsstdBhnspdsubject(CdmBhnsstdBhnspdsubject cdmBhnsstdBhnspdsubject);

    /**
     * 修改产品主题
     * 
     * @param cdmBhnsstdBhnspdsubject 产品主题
     * @return 结果
     */
    public int updateCdmBhnsstdBhnspdsubject(CdmBhnsstdBhnspdsubject cdmBhnsstdBhnspdsubject);

    /**
     * 批量删除产品主题
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCdmBhnsstdBhnspdsubjectByIds(String ids);

    /**
     * 删除产品主题信息
     * 
     * @param id 产品主题ID
     * @return 结果
     */
    public int deleteCdmBhnsstdBhnspdsubjectById(Long id);
}
