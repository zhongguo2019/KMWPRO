package com.kmw.metadata.mapper;

import com.kmw.metadata.domain.CdmBhnsstdBhnstrsubject;
import java.util.List;

/**
 * 事件主题Mapper接口
 * 
 * @author kmw
 * @date 2020-02-07
 */
public interface CdmBhnsstdBhnstrsubjectMapper 
{
    /**
     * 查询事件主题
     * 
     * @param id 事件主题ID
     * @return 事件主题
     */
    public CdmBhnsstdBhnstrsubject selectCdmBhnsstdBhnstrsubjectById(Long id);

    /**
     * 查询事件主题列表
     * 
     * @param cdmBhnsstdBhnstrsubject 事件主题
     * @return 事件主题集合
     */
    public List<CdmBhnsstdBhnstrsubject> selectCdmBhnsstdBhnstrsubjectList(CdmBhnsstdBhnstrsubject cdmBhnsstdBhnstrsubject);

    /**
     * 新增事件主题
     * 
     * @param cdmBhnsstdBhnstrsubject 事件主题
     * @return 结果
     */
    public int insertCdmBhnsstdBhnstrsubject(CdmBhnsstdBhnstrsubject cdmBhnsstdBhnstrsubject);

    /**
     * 修改事件主题
     * 
     * @param cdmBhnsstdBhnstrsubject 事件主题
     * @return 结果
     */
    public int updateCdmBhnsstdBhnstrsubject(CdmBhnsstdBhnstrsubject cdmBhnsstdBhnstrsubject);

    /**
     * 删除事件主题
     * 
     * @param id 事件主题ID
     * @return 结果
     */
    public int deleteCdmBhnsstdBhnstrsubjectById(Long id);

    /**
     * 批量删除事件主题
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCdmBhnsstdBhnstrsubjectByIds(String[] ids);
}
