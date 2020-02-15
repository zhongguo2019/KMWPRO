package com.kmw.metadata.service;

import com.kmw.metadata.domain.CdmZsyhstdZsyhsubjectcu;
import java.util.List;

/**
 * 数据标准客户主题Service接口
 * 
 * @author kmw
 * @date 2020-02-13
 */
public interface ICdmZsyhstdZsyhsubjectcuService 
{
    /**
     * 查询数据标准客户主题
     * 
     * @param id 数据标准客户主题ID
     * @return 数据标准客户主题
     */
    public CdmZsyhstdZsyhsubjectcu selectCdmZsyhstdZsyhsubjectcuById(Long id);

    /**
     * 查询数据标准客户主题列表
     * 
     * @param cdmZsyhstdZsyhsubjectcu 数据标准客户主题
     * @return 数据标准客户主题集合
     */
    public List<CdmZsyhstdZsyhsubjectcu> selectCdmZsyhstdZsyhsubjectcuList(CdmZsyhstdZsyhsubjectcu cdmZsyhstdZsyhsubjectcu);

    /**
     * 新增数据标准客户主题
     * 
     * @param cdmZsyhstdZsyhsubjectcu 数据标准客户主题
     * @return 结果
     */
    public int insertCdmZsyhstdZsyhsubjectcu(CdmZsyhstdZsyhsubjectcu cdmZsyhstdZsyhsubjectcu);

    /**
     * 修改数据标准客户主题
     * 
     * @param cdmZsyhstdZsyhsubjectcu 数据标准客户主题
     * @return 结果
     */
    public int updateCdmZsyhstdZsyhsubjectcu(CdmZsyhstdZsyhsubjectcu cdmZsyhstdZsyhsubjectcu);

    /**
     * 批量删除数据标准客户主题
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCdmZsyhstdZsyhsubjectcuByIds(String ids);

    /**
     * 删除数据标准客户主题信息
     * 
     * @param id 数据标准客户主题ID
     * @return 结果
     */
    public int deleteCdmZsyhstdZsyhsubjectcuById(Long id);
}
