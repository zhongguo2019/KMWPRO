package com.kmw.metadata.service;

import com.kmw.metadata.domain.CdmZsyhstdZsyhsubjectag;
import java.util.List;

/**
 * 数据标准协议主题Service接口
 * 
 * @author kmw
 * @date 2020-02-13
 */
public interface ICdmZsyhstdZsyhsubjectagService 
{
    /**
     * 查询数据标准协议主题
     * 
     * @param id 数据标准协议主题ID
     * @return 数据标准协议主题
     */
    public CdmZsyhstdZsyhsubjectag selectCdmZsyhstdZsyhsubjectagById(Long id);

    /**
     * 查询数据标准协议主题列表
     * 
     * @param cdmZsyhstdZsyhsubjectag 数据标准协议主题
     * @return 数据标准协议主题集合
     */
    public List<CdmZsyhstdZsyhsubjectag> selectCdmZsyhstdZsyhsubjectagList(CdmZsyhstdZsyhsubjectag cdmZsyhstdZsyhsubjectag);

    /**
     * 新增数据标准协议主题
     * 
     * @param cdmZsyhstdZsyhsubjectag 数据标准协议主题
     * @return 结果
     */
    public int insertCdmZsyhstdZsyhsubjectag(CdmZsyhstdZsyhsubjectag cdmZsyhstdZsyhsubjectag);

    /**
     * 修改数据标准协议主题
     * 
     * @param cdmZsyhstdZsyhsubjectag 数据标准协议主题
     * @return 结果
     */
    public int updateCdmZsyhstdZsyhsubjectag(CdmZsyhstdZsyhsubjectag cdmZsyhstdZsyhsubjectag);

    /**
     * 批量删除数据标准协议主题
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCdmZsyhstdZsyhsubjectagByIds(String ids);

    /**
     * 删除数据标准协议主题信息
     * 
     * @param id 数据标准协议主题ID
     * @return 结果
     */
    public int deleteCdmZsyhstdZsyhsubjectagById(Long id);
}
