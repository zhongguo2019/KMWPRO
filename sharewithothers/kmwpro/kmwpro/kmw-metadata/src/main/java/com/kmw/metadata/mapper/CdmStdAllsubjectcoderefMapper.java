package com.kmw.metadata.mapper;

import com.kmw.metadata.domain.CdmStdAllsubjectcoderef;
import java.util.List;

/**
 * 数据标准所有主题码值对照Mapper接口
 * 
 * @author kmw
 * @date 2020-02-12
 */
public interface CdmStdAllsubjectcoderefMapper 
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
     * 删除数据标准所有主题码值对照
     * 
     * @param id 数据标准所有主题码值对照ID
     * @return 结果
     */
    public int deleteCdmStdAllsubjectcoderefById(Long id);

    /**
     * 批量删除数据标准所有主题码值对照
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCdmStdAllsubjectcoderefByIds(String[] ids);
    
    /**
     * 按银行名称查询代码参数
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */ 
    public List<CdmStdAllsubjectcoderef>  selectCdmStdAllsubjectcoderefByBankName(CdmStdAllsubjectcoderef cdmStdAllsubjectcoderef);
   

}
