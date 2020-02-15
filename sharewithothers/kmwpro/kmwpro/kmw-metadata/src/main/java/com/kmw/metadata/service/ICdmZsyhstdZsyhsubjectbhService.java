package com.kmw.metadata.service;

import com.kmw.metadata.domain.CdmZsyhstdZsyhsubjectbh;
import java.util.List;

/**
 * 数据标准机构主题Service接口
 * 
 * @author kmw
 * @date 2020-02-13
 */
public interface ICdmZsyhstdZsyhsubjectbhService 
{
    /**
     * 查询数据标准机构主题
     * 
     * @param id 数据标准机构主题ID
     * @return 数据标准机构主题
     */
    public CdmZsyhstdZsyhsubjectbh selectCdmZsyhstdZsyhsubjectbhById(Long id);

    /**
     * 查询数据标准机构主题列表
     * 
     * @param cdmZsyhstdZsyhsubjectbh 数据标准机构主题
     * @return 数据标准机构主题集合
     */
    public List<CdmZsyhstdZsyhsubjectbh> selectCdmZsyhstdZsyhsubjectbhList(CdmZsyhstdZsyhsubjectbh cdmZsyhstdZsyhsubjectbh);

    /**
     * 新增数据标准机构主题
     * 
     * @param cdmZsyhstdZsyhsubjectbh 数据标准机构主题
     * @return 结果
     */
    public int insertCdmZsyhstdZsyhsubjectbh(CdmZsyhstdZsyhsubjectbh cdmZsyhstdZsyhsubjectbh);

    /**
     * 修改数据标准机构主题
     * 
     * @param cdmZsyhstdZsyhsubjectbh 数据标准机构主题
     * @return 结果
     */
    public int updateCdmZsyhstdZsyhsubjectbh(CdmZsyhstdZsyhsubjectbh cdmZsyhstdZsyhsubjectbh);

    /**
     * 批量删除数据标准机构主题
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCdmZsyhstdZsyhsubjectbhByIds(String ids);

    /**
     * 删除数据标准机构主题信息
     * 
     * @param id 数据标准机构主题ID
     * @return 结果
     */
    public int deleteCdmZsyhstdZsyhsubjectbhById(Long id);
}
