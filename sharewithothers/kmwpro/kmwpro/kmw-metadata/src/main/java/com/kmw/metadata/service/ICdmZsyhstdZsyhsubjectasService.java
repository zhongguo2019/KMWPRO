package com.kmw.metadata.service;

import com.kmw.metadata.domain.CdmZsyhstdZsyhsubjectas;
import java.util.List;

/**
 * 数据标准资产主题Service接口
 * 
 * @author kmw
 * @date 2020-02-13
 */
public interface ICdmZsyhstdZsyhsubjectasService 
{
    /**
     * 查询数据标准资产主题
     * 
     * @param id 数据标准资产主题ID
     * @return 数据标准资产主题
     */
    public CdmZsyhstdZsyhsubjectas selectCdmZsyhstdZsyhsubjectasById(Long id);

    /**
     * 查询数据标准资产主题列表
     * 
     * @param cdmZsyhstdZsyhsubjectas 数据标准资产主题
     * @return 数据标准资产主题集合
     */
    public List<CdmZsyhstdZsyhsubjectas> selectCdmZsyhstdZsyhsubjectasList(CdmZsyhstdZsyhsubjectas cdmZsyhstdZsyhsubjectas);

    /**
     * 新增数据标准资产主题
     * 
     * @param cdmZsyhstdZsyhsubjectas 数据标准资产主题
     * @return 结果
     */
    public int insertCdmZsyhstdZsyhsubjectas(CdmZsyhstdZsyhsubjectas cdmZsyhstdZsyhsubjectas);

    /**
     * 修改数据标准资产主题
     * 
     * @param cdmZsyhstdZsyhsubjectas 数据标准资产主题
     * @return 结果
     */
    public int updateCdmZsyhstdZsyhsubjectas(CdmZsyhstdZsyhsubjectas cdmZsyhstdZsyhsubjectas);

    /**
     * 批量删除数据标准资产主题
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCdmZsyhstdZsyhsubjectasByIds(String ids);

    /**
     * 删除数据标准资产主题信息
     * 
     * @param id 数据标准资产主题ID
     * @return 结果
     */
    public int deleteCdmZsyhstdZsyhsubjectasById(Long id);
}
