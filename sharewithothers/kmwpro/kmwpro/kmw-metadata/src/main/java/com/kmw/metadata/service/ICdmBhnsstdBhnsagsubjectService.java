package com.kmw.metadata.service;

import com.kmw.metadata.domain.CdmBhnsstdBhnsagsubject;
import java.util.List;

/**
 * 协议主题Service接口
 * 
 * @author kmw
 * @date 2020-02-07
 */
public interface ICdmBhnsstdBhnsagsubjectService 
{
    /**
     * 查询协议主题
     * 
     * @param id 协议主题ID
     * @return 协议主题
     */
    public CdmBhnsstdBhnsagsubject selectCdmBhnsstdBhnsagsubjectById(Long id);

    /**
     * 查询协议主题列表
     * 
     * @param cdmBhnsstdBhnsagsubject 协议主题
     * @return 协议主题集合
     */
    public List<CdmBhnsstdBhnsagsubject> selectCdmBhnsstdBhnsagsubjectList(CdmBhnsstdBhnsagsubject cdmBhnsstdBhnsagsubject);

    /**
     * 新增协议主题
     * 
     * @param cdmBhnsstdBhnsagsubject 协议主题
     * @return 结果
     */
    public int insertCdmBhnsstdBhnsagsubject(CdmBhnsstdBhnsagsubject cdmBhnsstdBhnsagsubject);

    /**
     * 修改协议主题
     * 
     * @param cdmBhnsstdBhnsagsubject 协议主题
     * @return 结果
     */
    public int updateCdmBhnsstdBhnsagsubject(CdmBhnsstdBhnsagsubject cdmBhnsstdBhnsagsubject);

    /**
     * 批量删除协议主题
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCdmBhnsstdBhnsagsubjectByIds(String ids);

    /**
     * 删除协议主题信息
     * 
     * @param id 协议主题ID
     * @return 结果
     */
    public int deleteCdmBhnsstdBhnsagsubjectById(Long id);
}
