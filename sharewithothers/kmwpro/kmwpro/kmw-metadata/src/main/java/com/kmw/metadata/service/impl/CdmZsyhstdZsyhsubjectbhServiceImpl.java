package com.kmw.metadata.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kmw.metadata.mapper.CdmZsyhstdZsyhsubjectbhMapper;
import com.kmw.metadata.domain.CdmZsyhstdZsyhsubjectbh;
import com.kmw.metadata.service.ICdmZsyhstdZsyhsubjectbhService;
import com.kmw.common.core.text.Convert;

/**
 * 数据标准机构主题Service业务层处理
 * 
 * @author kmw
 * @date 2020-02-13
 */
@Service
public class CdmZsyhstdZsyhsubjectbhServiceImpl implements ICdmZsyhstdZsyhsubjectbhService 
{
    @Autowired
    private CdmZsyhstdZsyhsubjectbhMapper cdmZsyhstdZsyhsubjectbhMapper;

    /**
     * 查询数据标准机构主题
     * 
     * @param id 数据标准机构主题ID
     * @return 数据标准机构主题
     */
    @Override
    public CdmZsyhstdZsyhsubjectbh selectCdmZsyhstdZsyhsubjectbhById(Long id)
    {
        return cdmZsyhstdZsyhsubjectbhMapper.selectCdmZsyhstdZsyhsubjectbhById(id);
    }

    /**
     * 查询数据标准机构主题列表
     * 
     * @param cdmZsyhstdZsyhsubjectbh 数据标准机构主题
     * @return 数据标准机构主题
     */
    @Override
    public List<CdmZsyhstdZsyhsubjectbh> selectCdmZsyhstdZsyhsubjectbhList(CdmZsyhstdZsyhsubjectbh cdmZsyhstdZsyhsubjectbh)
    {
        return cdmZsyhstdZsyhsubjectbhMapper.selectCdmZsyhstdZsyhsubjectbhList(cdmZsyhstdZsyhsubjectbh);
    }

    /**
     * 新增数据标准机构主题
     * 
     * @param cdmZsyhstdZsyhsubjectbh 数据标准机构主题
     * @return 结果
     */
    @Override
    public int insertCdmZsyhstdZsyhsubjectbh(CdmZsyhstdZsyhsubjectbh cdmZsyhstdZsyhsubjectbh)
    {
        return cdmZsyhstdZsyhsubjectbhMapper.insertCdmZsyhstdZsyhsubjectbh(cdmZsyhstdZsyhsubjectbh);
    }

    /**
     * 修改数据标准机构主题
     * 
     * @param cdmZsyhstdZsyhsubjectbh 数据标准机构主题
     * @return 结果
     */
    @Override
    public int updateCdmZsyhstdZsyhsubjectbh(CdmZsyhstdZsyhsubjectbh cdmZsyhstdZsyhsubjectbh)
    {
        return cdmZsyhstdZsyhsubjectbhMapper.updateCdmZsyhstdZsyhsubjectbh(cdmZsyhstdZsyhsubjectbh);
    }

    /**
     * 删除数据标准机构主题对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCdmZsyhstdZsyhsubjectbhByIds(String ids)
    {
        return cdmZsyhstdZsyhsubjectbhMapper.deleteCdmZsyhstdZsyhsubjectbhByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除数据标准机构主题信息
     * 
     * @param id 数据标准机构主题ID
     * @return 结果
     */
    @Override
    public int deleteCdmZsyhstdZsyhsubjectbhById(Long id)
    {
        return cdmZsyhstdZsyhsubjectbhMapper.deleteCdmZsyhstdZsyhsubjectbhById(id);
    }
}
