package com.kmw.metadata.service;

import com.kmw.metadata.domain.CdmZsyhstdZsyhsubjectpd;
import java.util.List;

/**
 * 数据标准产品主题Service接口
 * 
 * @author kmw
 * @date 2020-02-13
 */
public interface ICdmZsyhstdZsyhsubjectpdService 
{
    /**
     * 查询数据标准产品主题
     * 
     * @param id 数据标准产品主题ID
     * @return 数据标准产品主题
     */
    public CdmZsyhstdZsyhsubjectpd selectCdmZsyhstdZsyhsubjectpdById(Long id);

    /**
     * 查询数据标准产品主题列表
     * 
     * @param cdmZsyhstdZsyhsubjectpd 数据标准产品主题
     * @return 数据标准产品主题集合
     */
    public List<CdmZsyhstdZsyhsubjectpd> selectCdmZsyhstdZsyhsubjectpdList(CdmZsyhstdZsyhsubjectpd cdmZsyhstdZsyhsubjectpd);

    /**
     * 新增数据标准产品主题
     * 
     * @param cdmZsyhstdZsyhsubjectpd 数据标准产品主题
     * @return 结果
     */
    public int insertCdmZsyhstdZsyhsubjectpd(CdmZsyhstdZsyhsubjectpd cdmZsyhstdZsyhsubjectpd);

    /**
     * 修改数据标准产品主题
     * 
     * @param cdmZsyhstdZsyhsubjectpd 数据标准产品主题
     * @return 结果
     */
    public int updateCdmZsyhstdZsyhsubjectpd(CdmZsyhstdZsyhsubjectpd cdmZsyhstdZsyhsubjectpd);

    /**
     * 批量删除数据标准产品主题
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCdmZsyhstdZsyhsubjectpdByIds(String ids);

    /**
     * 删除数据标准产品主题信息
     * 
     * @param id 数据标准产品主题ID
     * @return 结果
     */
    public int deleteCdmZsyhstdZsyhsubjectpdById(Long id);
}
