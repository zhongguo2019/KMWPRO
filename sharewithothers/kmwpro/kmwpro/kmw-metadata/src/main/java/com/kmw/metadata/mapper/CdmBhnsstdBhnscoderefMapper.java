package com.kmw.metadata.mapper;

import com.kmw.metadata.domain.CdmBhnsstdBhnscoderef;
import java.util.List;

/**
 * 各主题代码参数表Mapper接口
 * 
 * @author kmw
 * @date 2020-02-12
 */
public interface CdmBhnsstdBhnscoderefMapper 
{
    /**
     * 查询各主题代码参数表
     * 
     * @param id 各主题代码参数表ID
     * @return 各主题代码参数表
     */
    public CdmBhnsstdBhnscoderef selectCdmBhnsstdBhnscoderefById(Long id);

    /**
     * 查询各主题代码参数表列表
     * 
     * @param cdmBhnsstdBhnscoderef 各主题代码参数表
     * @return 各主题代码参数表集合
     */
    public List<CdmBhnsstdBhnscoderef> selectCdmBhnsstdBhnscoderefList(CdmBhnsstdBhnscoderef cdmBhnsstdBhnscoderef);

    /**
     * 新增各主题代码参数表
     * 
     * @param cdmBhnsstdBhnscoderef 各主题代码参数表
     * @return 结果
     */
    public int insertCdmBhnsstdBhnscoderef(CdmBhnsstdBhnscoderef cdmBhnsstdBhnscoderef);

    /**
     * 修改各主题代码参数表
     * 
     * @param cdmBhnsstdBhnscoderef 各主题代码参数表
     * @return 结果
     */
    public int updateCdmBhnsstdBhnscoderef(CdmBhnsstdBhnscoderef cdmBhnsstdBhnscoderef);

    /**
     * 删除各主题代码参数表
     * 
     * @param id 各主题代码参数表ID
     * @return 结果
     */
    public int deleteCdmBhnsstdBhnscoderefById(Long id);

    /**
     * 批量删除各主题代码参数表
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCdmBhnsstdBhnscoderefByIds(String[] ids);
}
