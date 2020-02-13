package com.kmw.metadata.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kmw.metadata.mapper.CdmStdAllsubjectcoderefMapper;
import com.kmw.metadata.domain.CdmStdAllsubjectcoderef;
import com.kmw.metadata.service.ICdmStdAllsubjectcoderefService;
import com.kmw.common.core.text.Convert;

/**
 * 数据标准所有主题码值对照Service业务层处理
 * 
 * @author kmw
 * @date 2020-02-12
 */
@Service
public class CdmStdAllsubjectcoderefServiceImpl implements ICdmStdAllsubjectcoderefService 
{
    @Autowired
    private CdmStdAllsubjectcoderefMapper cdmStdAllsubjectcoderefMapper;

    /**
     * 查询数据标准所有主题码值对照
     * 
     * @param id 数据标准所有主题码值对照ID
     * @return 数据标准所有主题码值对照
     */
    @Override
    public CdmStdAllsubjectcoderef selectCdmStdAllsubjectcoderefById(Long id)
    {
        return cdmStdAllsubjectcoderefMapper.selectCdmStdAllsubjectcoderefById(id);
    }

    /**
     * 查询数据标准所有主题码值对照列表
     * 
     * @param cdmStdAllsubjectcoderef 数据标准所有主题码值对照
     * @return 数据标准所有主题码值对照
     */
    @Override
    public List<CdmStdAllsubjectcoderef> selectCdmStdAllsubjectcoderefList(CdmStdAllsubjectcoderef cdmStdAllsubjectcoderef)
    {
        return cdmStdAllsubjectcoderefMapper.selectCdmStdAllsubjectcoderefList(cdmStdAllsubjectcoderef);
    }

    /**
     * 新增数据标准所有主题码值对照
     * 
     * @param cdmStdAllsubjectcoderef 数据标准所有主题码值对照
     * @return 结果
     */
    @Override
    public int insertCdmStdAllsubjectcoderef(CdmStdAllsubjectcoderef cdmStdAllsubjectcoderef)
    {
        return cdmStdAllsubjectcoderefMapper.insertCdmStdAllsubjectcoderef(cdmStdAllsubjectcoderef);
    }

    /**
     * 修改数据标准所有主题码值对照
     * 
     * @param cdmStdAllsubjectcoderef 数据标准所有主题码值对照
     * @return 结果
     */
    @Override
    public int updateCdmStdAllsubjectcoderef(CdmStdAllsubjectcoderef cdmStdAllsubjectcoderef)
    {
        return cdmStdAllsubjectcoderefMapper.updateCdmStdAllsubjectcoderef(cdmStdAllsubjectcoderef);
    }

    /**
     * 删除数据标准所有主题码值对照对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCdmStdAllsubjectcoderefByIds(String ids)
    {
        return cdmStdAllsubjectcoderefMapper.deleteCdmStdAllsubjectcoderefByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除数据标准所有主题码值对照信息
     * 
     * @param id 数据标准所有主题码值对照ID
     * @return 结果
     */
    @Override
    public int deleteCdmStdAllsubjectcoderefById(Long id)
    {
        return cdmStdAllsubjectcoderefMapper.deleteCdmStdAllsubjectcoderefById(id);
    }
}
