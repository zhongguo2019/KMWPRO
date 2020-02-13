package com.kmw.metadata.service;

import com.kmw.metadata.domain.CdmBhnsstdBhnschsubject;
import java.util.List;

/**
 * 渠道主题Service接口
 * 
 * @author kmw
 * @date 2020-02-07
 */
public interface ICdmBhnsstdBhnschsubjectService 
{
    /**
     * 查询渠道主题
     * 
     * @param id 渠道主题ID
     * @return 渠道主题
     */
    public CdmBhnsstdBhnschsubject selectCdmBhnsstdBhnschsubjectById(Long id);

    /**
     * 查询渠道主题列表
     * 
     * @param cdmBhnsstdBhnschsubject 渠道主题
     * @return 渠道主题集合
     */
    public List<CdmBhnsstdBhnschsubject> selectCdmBhnsstdBhnschsubjectList(CdmBhnsstdBhnschsubject cdmBhnsstdBhnschsubject);

    /**
     * 新增渠道主题
     * 
     * @param cdmBhnsstdBhnschsubject 渠道主题
     * @return 结果
     */
    public int insertCdmBhnsstdBhnschsubject(CdmBhnsstdBhnschsubject cdmBhnsstdBhnschsubject);

    /**
     * 修改渠道主题
     * 
     * @param cdmBhnsstdBhnschsubject 渠道主题
     * @return 结果
     */
    public int updateCdmBhnsstdBhnschsubject(CdmBhnsstdBhnschsubject cdmBhnsstdBhnschsubject);

    /**
     * 批量删除渠道主题
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCdmBhnsstdBhnschsubjectByIds(String ids);

    /**
     * 删除渠道主题信息
     * 
     * @param id 渠道主题ID
     * @return 结果
     */
    public int deleteCdmBhnsstdBhnschsubjectById(Long id);
}
