package com.kmw.metadata.service;

import com.kmw.metadata.domain.CdmZsyhstdZsyhsubjecttr;
import java.util.List;

/**
 * 数据标准事件主题Service接口
 * 
 * @author kmw
 * @date 2020-02-13
 */
public interface ICdmZsyhstdZsyhsubjecttrService 
{
    /**
     * 查询数据标准事件主题
     * 
     * @param id 数据标准事件主题ID
     * @return 数据标准事件主题
     */
    public CdmZsyhstdZsyhsubjecttr selectCdmZsyhstdZsyhsubjecttrById(Long id);

    /**
     * 查询数据标准事件主题列表
     * 
     * @param cdmZsyhstdZsyhsubjecttr 数据标准事件主题
     * @return 数据标准事件主题集合
     */
    public List<CdmZsyhstdZsyhsubjecttr> selectCdmZsyhstdZsyhsubjecttrList(CdmZsyhstdZsyhsubjecttr cdmZsyhstdZsyhsubjecttr);

    /**
     * 新增数据标准事件主题
     * 
     * @param cdmZsyhstdZsyhsubjecttr 数据标准事件主题
     * @return 结果
     */
    public int insertCdmZsyhstdZsyhsubjecttr(CdmZsyhstdZsyhsubjecttr cdmZsyhstdZsyhsubjecttr);

    /**
     * 修改数据标准事件主题
     * 
     * @param cdmZsyhstdZsyhsubjecttr 数据标准事件主题
     * @return 结果
     */
    public int updateCdmZsyhstdZsyhsubjecttr(CdmZsyhstdZsyhsubjecttr cdmZsyhstdZsyhsubjecttr);

    /**
     * 批量删除数据标准事件主题
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCdmZsyhstdZsyhsubjecttrByIds(String ids);

    /**
     * 删除数据标准事件主题信息
     * 
     * @param id 数据标准事件主题ID
     * @return 结果
     */
    public int deleteCdmZsyhstdZsyhsubjecttrById(Long id);
}
