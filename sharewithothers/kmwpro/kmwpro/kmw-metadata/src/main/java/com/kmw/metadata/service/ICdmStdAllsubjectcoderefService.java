package com.kmw.metadata.service;

import com.kmw.metadata.domain.CdmStdAllsubjectcoderef;
import java.util.List;

/**
 * 数据标准所有主题码值对照Service接口
 * 
 * @author kmw
 * @date 2020-02-12
 */
public interface ICdmStdAllsubjectcoderefService 
{
    /**
     * 查询数据标准所有主题码值对照
     * 
     * @param id 数据标准所有主题码值对照ID
     * @return 数据标准所有主题码值对照
     */
    public CdmStdAllsubjectcoderef selectCdmStdAllsubjectcoderefById(Long id);

    /**
     * 查询数据标准所有主题码值对照列表
     * 
     * @param cdmStdAllsubjectcoderef 数据标准所有主题码值对照
     * @return 数据标准所有主题码值对照集合
     */
    public List<CdmStdAllsubjectcoderef> selectCdmStdAllsubjectcoderefList(CdmStdAllsubjectcoderef cdmStdAllsubjectcoderef);

    /**
     * 新增数据标准所有主题码值对照
     * 
     * @param cdmStdAllsubjectcoderef 数据标准所有主题码值对照
     * @return 结果
     */
    public int insertCdmStdAllsubjectcoderef(CdmStdAllsubjectcoderef cdmStdAllsubjectcoderef);

    /**
     * 修改数据标准所有主题码值对照
     * 
     * @param cdmStdAllsubjectcoderef 数据标准所有主题码值对照
     * @return 结果
     */
    public int updateCdmStdAllsubjectcoderef(CdmStdAllsubjectcoderef cdmStdAllsubjectcoderef);

    /**
     * 批量删除数据标准所有主题码值对照
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCdmStdAllsubjectcoderefByIds(String ids);

    /**
     * 删除数据标准所有主题码值对照信息
     * 
     * @param id 数据标准所有主题码值对照ID
     * @return 结果
     */
    public int deleteCdmStdAllsubjectcoderefById(Long id);
}
