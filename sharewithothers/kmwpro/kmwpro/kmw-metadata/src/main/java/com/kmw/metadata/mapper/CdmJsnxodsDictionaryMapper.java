package com.kmw.metadata.mapper;

import com.kmw.metadata.domain.CdmJsnxodsDictionary;
import java.util.List;

/**
 * 江苏农信ODS数据字典Mapper接口
 * 
 * @author kmw
 * @date 2020-02-06
 */
public interface CdmJsnxodsDictionaryMapper 
{
    /**
     * 查询江苏农信ODS数据字典
     * 
     * @param id 江苏农信ODS数据字典ID
     * @return 江苏农信ODS数据字典
     */
    public CdmJsnxodsDictionary selectCdmJsnxodsDictionaryById(Integer id);

    /**
     * 查询江苏农信ODS数据字典列表
     * 
     * @param cdmJsnxodsDictionary 江苏农信ODS数据字典
     * @return 江苏农信ODS数据字典集合
     */
    public List<CdmJsnxodsDictionary> selectCdmJsnxodsDictionaryList(CdmJsnxodsDictionary cdmJsnxodsDictionary);

    /**
     * 新增江苏农信ODS数据字典
     * 
     * @param cdmJsnxodsDictionary 江苏农信ODS数据字典
     * @return 结果
     */
    public int insertCdmJsnxodsDictionary(CdmJsnxodsDictionary cdmJsnxodsDictionary);

    /**
     * 修改江苏农信ODS数据字典
     * 
     * @param cdmJsnxodsDictionary 江苏农信ODS数据字典
     * @return 结果
     */
    public int updateCdmJsnxodsDictionary(CdmJsnxodsDictionary cdmJsnxodsDictionary);

    /**
     * 删除江苏农信ODS数据字典
     * 
     * @param id 江苏农信ODS数据字典ID
     * @return 结果
     */
    public int deleteCdmJsnxodsDictionaryById(Integer id);

    /**
     * 批量删除江苏农信ODS数据字典
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCdmJsnxodsDictionaryByIds(String[] ids);
}
