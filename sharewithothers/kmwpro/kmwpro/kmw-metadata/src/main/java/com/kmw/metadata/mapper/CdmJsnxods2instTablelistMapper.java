package com.kmw.metadata.mapper;

import com.kmw.metadata.domain.CdmJsnxods2instTablelist;
import java.util.List;

/**
 * 江苏农信省联社给各法人下发的数据库Mapper接口
 * 
 * @author kmw
 * @date 2020-02-06
 */
public interface CdmJsnxods2instTablelistMapper 
{
    /**
     * 查询江苏农信省联社给各法人下发的数据库
     * 
     * @param id 江苏农信省联社给各法人下发的数据库ID
     * @return 江苏农信省联社给各法人下发的数据库
     */
    public CdmJsnxods2instTablelist selectCdmJsnxods2instTablelistById(Long id);

    /**
     * 查询江苏农信省联社给各法人下发的数据库列表
     * 
     * @param cdmJsnxods2instTablelist 江苏农信省联社给各法人下发的数据库
     * @return 江苏农信省联社给各法人下发的数据库集合
     */
    public List<CdmJsnxods2instTablelist> selectCdmJsnxods2instTablelistList(CdmJsnxods2instTablelist cdmJsnxods2instTablelist);

    /**
     * 新增江苏农信省联社给各法人下发的数据库
     * 
     * @param cdmJsnxods2instTablelist 江苏农信省联社给各法人下发的数据库
     * @return 结果
     */
    public int insertCdmJsnxods2instTablelist(CdmJsnxods2instTablelist cdmJsnxods2instTablelist);

    /**
     * 修改江苏农信省联社给各法人下发的数据库
     * 
     * @param cdmJsnxods2instTablelist 江苏农信省联社给各法人下发的数据库
     * @return 结果
     */
    public int updateCdmJsnxods2instTablelist(CdmJsnxods2instTablelist cdmJsnxods2instTablelist);

    /**
     * 删除江苏农信省联社给各法人下发的数据库
     * 
     * @param id 江苏农信省联社给各法人下发的数据库ID
     * @return 结果
     */
    public int deleteCdmJsnxods2instTablelistById(Long id);

    /**
     * 批量删除江苏农信省联社给各法人下发的数据库
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCdmJsnxods2instTablelistByIds(String[] ids);
}
