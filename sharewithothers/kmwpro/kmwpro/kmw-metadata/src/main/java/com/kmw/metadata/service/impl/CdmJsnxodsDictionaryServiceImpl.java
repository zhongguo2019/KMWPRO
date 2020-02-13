package com.kmw.metadata.service.impl;

import java.util.List;
import com.kmw.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kmw.metadata.mapper.CdmJsnxodsDictionaryMapper;
import com.kmw.metadata.domain.CdmJsnxodsDictionary;
import com.kmw.metadata.service.ICdmJsnxodsDictionaryService;
import com.kmw.common.core.text.Convert;

/**
 * 江苏农信ODS数据字典Service业务层处理
 * 
 * @author kmw
 * @date 2020-02-06
 */
@Service
public class CdmJsnxodsDictionaryServiceImpl implements ICdmJsnxodsDictionaryService 
{
    @Autowired
    private CdmJsnxodsDictionaryMapper cdmJsnxodsDictionaryMapper;

    /**
     * 查询江苏农信ODS数据字典
     * 
     * @param id 江苏农信ODS数据字典ID
     * @return 江苏农信ODS数据字典
     */
    @Override
    public CdmJsnxodsDictionary selectCdmJsnxodsDictionaryById(Integer id)
    {
        return cdmJsnxodsDictionaryMapper.selectCdmJsnxodsDictionaryById(id);
    }

    /**
     * 查询江苏农信ODS数据字典列表
     * 
     * @param cdmJsnxodsDictionary 江苏农信ODS数据字典
     * @return 江苏农信ODS数据字典
     */
    @Override
    public List<CdmJsnxodsDictionary> selectCdmJsnxodsDictionaryList(CdmJsnxodsDictionary cdmJsnxodsDictionary)
    {
        return cdmJsnxodsDictionaryMapper.selectCdmJsnxodsDictionaryList(cdmJsnxodsDictionary);
    }

    /**
     * 新增江苏农信ODS数据字典
     * 
     * @param cdmJsnxodsDictionary 江苏农信ODS数据字典
     * @return 结果
     */
    @Override
    public int insertCdmJsnxodsDictionary(CdmJsnxodsDictionary cdmJsnxodsDictionary)
    {
        cdmJsnxodsDictionary.setCreateTime(DateUtils.getNowDate());
        return cdmJsnxodsDictionaryMapper.insertCdmJsnxodsDictionary(cdmJsnxodsDictionary);
    }

    /**
     * 修改江苏农信ODS数据字典
     * 
     * @param cdmJsnxodsDictionary 江苏农信ODS数据字典
     * @return 结果
     */
    @Override
    public int updateCdmJsnxodsDictionary(CdmJsnxodsDictionary cdmJsnxodsDictionary)
    {
        cdmJsnxodsDictionary.setUpdateTime(DateUtils.getNowDate());
        return cdmJsnxodsDictionaryMapper.updateCdmJsnxodsDictionary(cdmJsnxodsDictionary);
    }

    /**
     * 删除江苏农信ODS数据字典对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCdmJsnxodsDictionaryByIds(String ids)
    {
        return cdmJsnxodsDictionaryMapper.deleteCdmJsnxodsDictionaryByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除江苏农信ODS数据字典信息
     * 
     * @param id 江苏农信ODS数据字典ID
     * @return 结果
     */
    @Override
    public int deleteCdmJsnxodsDictionaryById(Integer id)
    {
        return cdmJsnxodsDictionaryMapper.deleteCdmJsnxodsDictionaryById(id);
    }
}
