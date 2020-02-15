package com.kmw.metadata.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kmw.metadata.mapper.CdmZsyhstdZsyhsubjectcuMapper;
import com.kmw.metadata.domain.CdmZsyhstdZsyhsubjectcu;
import com.kmw.metadata.service.ICdmZsyhstdZsyhsubjectcuService;
import com.kmw.common.core.text.Convert;

/**
 * 数据标准客户主题Service业务层处理
 * 
 * @author kmw
 * @date 2020-02-13
 */
@Service
public class CdmZsyhstdZsyhsubjectcuServiceImpl implements ICdmZsyhstdZsyhsubjectcuService 
{
    @Autowired
    private CdmZsyhstdZsyhsubjectcuMapper cdmZsyhstdZsyhsubjectcuMapper;

    /**
     * 查询数据标准客户主题
     * 
     * @param id 数据标准客户主题ID
     * @return 数据标准客户主题
     */
    @Override
    public CdmZsyhstdZsyhsubjectcu selectCdmZsyhstdZsyhsubjectcuById(Long id)
    {
        return cdmZsyhstdZsyhsubjectcuMapper.selectCdmZsyhstdZsyhsubjectcuById(id);
    }

    /**
     * 查询数据标准客户主题列表
     * 
     * @param cdmZsyhstdZsyhsubjectcu 数据标准客户主题
     * @return 数据标准客户主题
     */
    @Override
    public List<CdmZsyhstdZsyhsubjectcu> selectCdmZsyhstdZsyhsubjectcuList(CdmZsyhstdZsyhsubjectcu cdmZsyhstdZsyhsubjectcu)
    {
        return cdmZsyhstdZsyhsubjectcuMapper.selectCdmZsyhstdZsyhsubjectcuList(cdmZsyhstdZsyhsubjectcu);
    }

    /**
     * 新增数据标准客户主题
     * 
     * @param cdmZsyhstdZsyhsubjectcu 数据标准客户主题
     * @return 结果
     */
    @Override
    public int insertCdmZsyhstdZsyhsubjectcu(CdmZsyhstdZsyhsubjectcu cdmZsyhstdZsyhsubjectcu)
    {
        return cdmZsyhstdZsyhsubjectcuMapper.insertCdmZsyhstdZsyhsubjectcu(cdmZsyhstdZsyhsubjectcu);
    }

    /**
     * 修改数据标准客户主题
     * 
     * @param cdmZsyhstdZsyhsubjectcu 数据标准客户主题
     * @return 结果
     */
    @Override
    public int updateCdmZsyhstdZsyhsubjectcu(CdmZsyhstdZsyhsubjectcu cdmZsyhstdZsyhsubjectcu)
    {
        return cdmZsyhstdZsyhsubjectcuMapper.updateCdmZsyhstdZsyhsubjectcu(cdmZsyhstdZsyhsubjectcu);
    }

    /**
     * 删除数据标准客户主题对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCdmZsyhstdZsyhsubjectcuByIds(String ids)
    {
        return cdmZsyhstdZsyhsubjectcuMapper.deleteCdmZsyhstdZsyhsubjectcuByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除数据标准客户主题信息
     * 
     * @param id 数据标准客户主题ID
     * @return 结果
     */
    @Override
    public int deleteCdmZsyhstdZsyhsubjectcuById(Long id)
    {
        return cdmZsyhstdZsyhsubjectcuMapper.deleteCdmZsyhstdZsyhsubjectcuById(id);
    }
}
