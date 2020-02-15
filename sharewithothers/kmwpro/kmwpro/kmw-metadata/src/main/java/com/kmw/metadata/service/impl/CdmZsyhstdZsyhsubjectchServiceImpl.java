package com.kmw.metadata.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kmw.metadata.mapper.CdmZsyhstdZsyhsubjectchMapper;
import com.kmw.metadata.domain.CdmZsyhstdZsyhsubjectch;
import com.kmw.metadata.service.ICdmZsyhstdZsyhsubjectchService;
import com.kmw.common.core.text.Convert;

/**
 * 数据标准渠道主题Service业务层处理
 * 
 * @author kmw
 * @date 2020-02-13
 */
@Service
public class CdmZsyhstdZsyhsubjectchServiceImpl implements ICdmZsyhstdZsyhsubjectchService 
{
    @Autowired
    private CdmZsyhstdZsyhsubjectchMapper cdmZsyhstdZsyhsubjectchMapper;

    /**
     * 查询数据标准渠道主题
     * 
     * @param id 数据标准渠道主题ID
     * @return 数据标准渠道主题
     */
    @Override
    public CdmZsyhstdZsyhsubjectch selectCdmZsyhstdZsyhsubjectchById(Long id)
    {
        return cdmZsyhstdZsyhsubjectchMapper.selectCdmZsyhstdZsyhsubjectchById(id);
    }

    /**
     * 查询数据标准渠道主题列表
     * 
     * @param cdmZsyhstdZsyhsubjectch 数据标准渠道主题
     * @return 数据标准渠道主题
     */
    @Override
    public List<CdmZsyhstdZsyhsubjectch> selectCdmZsyhstdZsyhsubjectchList(CdmZsyhstdZsyhsubjectch cdmZsyhstdZsyhsubjectch)
    {
        return cdmZsyhstdZsyhsubjectchMapper.selectCdmZsyhstdZsyhsubjectchList(cdmZsyhstdZsyhsubjectch);
    }

    /**
     * 新增数据标准渠道主题
     * 
     * @param cdmZsyhstdZsyhsubjectch 数据标准渠道主题
     * @return 结果
     */
    @Override
    public int insertCdmZsyhstdZsyhsubjectch(CdmZsyhstdZsyhsubjectch cdmZsyhstdZsyhsubjectch)
    {
        return cdmZsyhstdZsyhsubjectchMapper.insertCdmZsyhstdZsyhsubjectch(cdmZsyhstdZsyhsubjectch);
    }

    /**
     * 修改数据标准渠道主题
     * 
     * @param cdmZsyhstdZsyhsubjectch 数据标准渠道主题
     * @return 结果
     */
    @Override
    public int updateCdmZsyhstdZsyhsubjectch(CdmZsyhstdZsyhsubjectch cdmZsyhstdZsyhsubjectch)
    {
        return cdmZsyhstdZsyhsubjectchMapper.updateCdmZsyhstdZsyhsubjectch(cdmZsyhstdZsyhsubjectch);
    }

    /**
     * 删除数据标准渠道主题对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCdmZsyhstdZsyhsubjectchByIds(String ids)
    {
        return cdmZsyhstdZsyhsubjectchMapper.deleteCdmZsyhstdZsyhsubjectchByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除数据标准渠道主题信息
     * 
     * @param id 数据标准渠道主题ID
     * @return 结果
     */
    @Override
    public int deleteCdmZsyhstdZsyhsubjectchById(Long id)
    {
        return cdmZsyhstdZsyhsubjectchMapper.deleteCdmZsyhstdZsyhsubjectchById(id);
    }
}
