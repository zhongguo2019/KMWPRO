package com.kmw.metadata.service.impl;

import java.util.List;
import com.kmw.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kmw.metadata.mapper.CdmJsnxods2instTablelistMapper;
import com.kmw.metadata.domain.CdmJsnxods2instTablelist;
import com.kmw.metadata.service.ICdmJsnxods2instTablelistService;
import com.kmw.common.core.text.Convert;

/**
 * 江苏农信省联社给各法人下发的数据库Service业务层处理
 * 
 * @author kmw
 * @date 2020-02-06
 */
@Service
public class CdmJsnxods2instTablelistServiceImpl implements ICdmJsnxods2instTablelistService 
{
    @Autowired
    private CdmJsnxods2instTablelistMapper cdmJsnxods2instTablelistMapper;

    /**
     * 查询江苏农信省联社给各法人下发的数据库
     * 
     * @param id 江苏农信省联社给各法人下发的数据库ID
     * @return 江苏农信省联社给各法人下发的数据库
     */
    @Override
    public CdmJsnxods2instTablelist selectCdmJsnxods2instTablelistById(Long id)
    {
        return cdmJsnxods2instTablelistMapper.selectCdmJsnxods2instTablelistById(id);
    }

    /**
     * 查询江苏农信省联社给各法人下发的数据库列表
     * 
     * @param cdmJsnxods2instTablelist 江苏农信省联社给各法人下发的数据库
     * @return 江苏农信省联社给各法人下发的数据库
     */
    @Override
    public List<CdmJsnxods2instTablelist> selectCdmJsnxods2instTablelistList(CdmJsnxods2instTablelist cdmJsnxods2instTablelist)
    {
        return cdmJsnxods2instTablelistMapper.selectCdmJsnxods2instTablelistList(cdmJsnxods2instTablelist);
    }

    /**
     * 新增江苏农信省联社给各法人下发的数据库
     * 
     * @param cdmJsnxods2instTablelist 江苏农信省联社给各法人下发的数据库
     * @return 结果
     */
    @Override
    public int insertCdmJsnxods2instTablelist(CdmJsnxods2instTablelist cdmJsnxods2instTablelist)
    {
        cdmJsnxods2instTablelist.setCreateTime(DateUtils.getNowDate());
        return cdmJsnxods2instTablelistMapper.insertCdmJsnxods2instTablelist(cdmJsnxods2instTablelist);
    }

    /**
     * 修改江苏农信省联社给各法人下发的数据库
     * 
     * @param cdmJsnxods2instTablelist 江苏农信省联社给各法人下发的数据库
     * @return 结果
     */
    @Override
    public int updateCdmJsnxods2instTablelist(CdmJsnxods2instTablelist cdmJsnxods2instTablelist)
    {
        cdmJsnxods2instTablelist.setUpdateTime(DateUtils.getNowDate());
        return cdmJsnxods2instTablelistMapper.updateCdmJsnxods2instTablelist(cdmJsnxods2instTablelist);
    }

    /**
     * 删除江苏农信省联社给各法人下发的数据库对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCdmJsnxods2instTablelistByIds(String ids)
    {
        return cdmJsnxods2instTablelistMapper.deleteCdmJsnxods2instTablelistByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除江苏农信省联社给各法人下发的数据库信息
     * 
     * @param id 江苏农信省联社给各法人下发的数据库ID
     * @return 结果
     */
    @Override
    public int deleteCdmJsnxods2instTablelistById(Long id)
    {
        return cdmJsnxods2instTablelistMapper.deleteCdmJsnxods2instTablelistById(id);
    }
}
