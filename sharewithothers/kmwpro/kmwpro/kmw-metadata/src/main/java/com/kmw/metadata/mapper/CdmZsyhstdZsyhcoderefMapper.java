package com.kmw.metadata.mapper;

import com.kmw.metadata.domain.CdmZsyhstdZsyhcoderef;
import java.util.List;

/**
 * VIEWMapper接口
 * 
 * @author kmw
 * @date 2020-02-13
 */
public interface CdmZsyhstdZsyhcoderefMapper 
{
    /**
     * 查询VIEW
     * 
     * @param id VIEWID
     * @return VIEW
     */
    public CdmZsyhstdZsyhcoderef selectCdmZsyhstdZsyhcoderefById(Long id);

    /**
     * 查询VIEW列表
     * 
     * @param cdmZsyhstdZsyhcoderef VIEW
     * @return VIEW集合
     */
    public List<CdmZsyhstdZsyhcoderef> selectCdmZsyhstdZsyhcoderefList(CdmZsyhstdZsyhcoderef cdmZsyhstdZsyhcoderef);

    /**
     * 新增VIEW
     * 
     * @param cdmZsyhstdZsyhcoderef VIEW
     * @return 结果
     */
    public int insertCdmZsyhstdZsyhcoderef(CdmZsyhstdZsyhcoderef cdmZsyhstdZsyhcoderef);

    /**
     * 修改VIEW
     * 
     * @param cdmZsyhstdZsyhcoderef VIEW
     * @return 结果
     */
    public int updateCdmZsyhstdZsyhcoderef(CdmZsyhstdZsyhcoderef cdmZsyhstdZsyhcoderef);

    /**
     * 删除VIEW
     * 
     * @param id VIEWID
     * @return 结果
     */
    public int deleteCdmZsyhstdZsyhcoderefById(Long id);

    /**
     * 批量删除VIEW
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCdmZsyhstdZsyhcoderefByIds(String[] ids);
}
