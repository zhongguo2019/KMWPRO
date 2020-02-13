package com.kmw.metadata.mapper;

import com.kmw.metadata.domain.CdmBhnsstdBhnsbhsubject;
import java.util.List;

/**
 * 机构主题Mapper接口
 * 
 * @author kmw
 * @date 2020-02-07
 */
public interface CdmBhnsstdBhnsbhsubjectMapper 
{
    /**
     * 查询机构主题
     * 
     * @param id 机构主题ID
     * @return 机构主题
     */
    public CdmBhnsstdBhnsbhsubject selectCdmBhnsstdBhnsbhsubjectById(Long id);

    /**
     * 查询机构主题列表
     * 
     * @param cdmBhnsstdBhnsbhsubject 机构主题
     * @return 机构主题集合
     */
    public List<CdmBhnsstdBhnsbhsubject> selectCdmBhnsstdBhnsbhsubjectList(CdmBhnsstdBhnsbhsubject cdmBhnsstdBhnsbhsubject);

    /**
     * 新增机构主题
     * 
     * @param cdmBhnsstdBhnsbhsubject 机构主题
     * @return 结果
     */
    public int insertCdmBhnsstdBhnsbhsubject(CdmBhnsstdBhnsbhsubject cdmBhnsstdBhnsbhsubject);

    /**
     * 修改机构主题
     * 
     * @param cdmBhnsstdBhnsbhsubject 机构主题
     * @return 结果
     */
    public int updateCdmBhnsstdBhnsbhsubject(CdmBhnsstdBhnsbhsubject cdmBhnsstdBhnsbhsubject);

    /**
     * 删除机构主题
     * 
     * @param id 机构主题ID
     * @return 结果
     */
    public int deleteCdmBhnsstdBhnsbhsubjectById(Long id);

    /**
     * 批量删除机构主题
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCdmBhnsstdBhnsbhsubjectByIds(String[] ids);
}
