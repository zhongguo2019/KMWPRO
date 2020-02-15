package com.kmw.metadata.service;

import com.kmw.metadata.domain.CdmZsyhstdZsyhsubjectch;
import java.util.List;

/**
 * 数据标准渠道主题Service接口
 * 
 * @author kmw
 * @date 2020-02-13
 */
public interface ICdmZsyhstdZsyhsubjectchService 
{
    /**
     * 查询数据标准渠道主题
     * 
     * @param id 数据标准渠道主题ID
     * @return 数据标准渠道主题
     */
    public CdmZsyhstdZsyhsubjectch selectCdmZsyhstdZsyhsubjectchById(Long id);

    /**
     * 查询数据标准渠道主题列表
     * 
     * @param cdmZsyhstdZsyhsubjectch 数据标准渠道主题
     * @return 数据标准渠道主题集合
     */
    public List<CdmZsyhstdZsyhsubjectch> selectCdmZsyhstdZsyhsubjectchList(CdmZsyhstdZsyhsubjectch cdmZsyhstdZsyhsubjectch);

    /**
     * 新增数据标准渠道主题
     * 
     * @param cdmZsyhstdZsyhsubjectch 数据标准渠道主题
     * @return 结果
     */
    public int insertCdmZsyhstdZsyhsubjectch(CdmZsyhstdZsyhsubjectch cdmZsyhstdZsyhsubjectch);

    /**
     * 修改数据标准渠道主题
     * 
     * @param cdmZsyhstdZsyhsubjectch 数据标准渠道主题
     * @return 结果
     */
    public int updateCdmZsyhstdZsyhsubjectch(CdmZsyhstdZsyhsubjectch cdmZsyhstdZsyhsubjectch);

    /**
     * 批量删除数据标准渠道主题
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCdmZsyhstdZsyhsubjectchByIds(String ids);

    /**
     * 删除数据标准渠道主题信息
     * 
     * @param id 数据标准渠道主题ID
     * @return 结果
     */
    public int deleteCdmZsyhstdZsyhsubjectchById(Long id);
}
