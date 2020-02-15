package com.kmw.metadata.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kmw.metadata.mapper.CdmZsyhstdZsyhsubjectpdMapper;
import com.kmw.metadata.domain.CdmZsyhstdZsyhsubjectpd;
import com.kmw.metadata.service.ICdmZsyhstdZsyhsubjectpdService;
import com.kmw.common.core.text.Convert;

/**
 * 数据标准产品主题Service业务层处理
 * 
 * @author kmw
 * @date 2020-02-13
 */
@Service
public class CdmZsyhstdZsyhsubjectpdServiceImpl implements ICdmZsyhstdZsyhsubjectpdService 
{
    @Autowired
    private CdmZsyhstdZsyhsubjectpdMapper cdmZsyhstdZsyhsubjectpdMapper;

    /**
     * 查询数据标准产品主题
     * 
     * @param id 数据标准产品主题ID
     * @return 数据标准产品主题
     */
    @Override
    public CdmZsyhstdZsyhsubjectpd selectCdmZsyhstdZsyhsubjectpdById(Long id)
    {
        return cdmZsyhstdZsyhsubjectpdMapper.selectCdmZsyhstdZsyhsubjectpdById(id);
    }

    /**
     * 查询数据标准产品主题列表
     * 
     * @param cdmZsyhstdZsyhsubjectpd 数据标准产品主题
     * @return 数据标准产品主题
     */
    @Override
    public List<CdmZsyhstdZsyhsubjectpd> selectCdmZsyhstdZsyhsubjectpdList(CdmZsyhstdZsyhsubjectpd cdmZsyhstdZsyhsubjectpd)
    {
        return cdmZsyhstdZsyhsubjectpdMapper.selectCdmZsyhstdZsyhsubjectpdList(cdmZsyhstdZsyhsubjectpd);
    }

    /**
     * 新增数据标准产品主题
     * 
     * @param cdmZsyhstdZsyhsubjectpd 数据标准产品主题
     * @return 结果
     */
    @Override
    public int insertCdmZsyhstdZsyhsubjectpd(CdmZsyhstdZsyhsubjectpd cdmZsyhstdZsyhsubjectpd)
    {
        return cdmZsyhstdZsyhsubjectpdMapper.insertCdmZsyhstdZsyhsubjectpd(cdmZsyhstdZsyhsubjectpd);
    }

    /**
     * 修改数据标准产品主题
     * 
     * @param cdmZsyhstdZsyhsubjectpd 数据标准产品主题
     * @return 结果
     */
    @Override
    public int updateCdmZsyhstdZsyhsubjectpd(CdmZsyhstdZsyhsubjectpd cdmZsyhstdZsyhsubjectpd)
    {
        return cdmZsyhstdZsyhsubjectpdMapper.updateCdmZsyhstdZsyhsubjectpd(cdmZsyhstdZsyhsubjectpd);
    }

    /**
     * 删除数据标准产品主题对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCdmZsyhstdZsyhsubjectpdByIds(String ids)
    {
        return cdmZsyhstdZsyhsubjectpdMapper.deleteCdmZsyhstdZsyhsubjectpdByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除数据标准产品主题信息
     * 
     * @param id 数据标准产品主题ID
     * @return 结果
     */
    @Override
    public int deleteCdmZsyhstdZsyhsubjectpdById(Long id)
    {
        return cdmZsyhstdZsyhsubjectpdMapper.deleteCdmZsyhstdZsyhsubjectpdById(id);
    }
}
