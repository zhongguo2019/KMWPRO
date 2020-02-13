package com.kmw.metadata.service;

import com.kmw.metadata.domain.CdmBhnsstdBhnscusubject;
import java.util.List;

/**
 * VIEWService接口
 * 
 * @author kmw
 * @date 2020-02-07
 */
public interface ICdmBhnsstdBhnscusubjectService 
{
    /**
     * 查询VIEW
     * 
     * @param id VIEWID
     * @return VIEW
     */
    public CdmBhnsstdBhnscusubject selectCdmBhnsstdBhnscusubjectById(Long id);

    /**
     * 查询VIEW列表
     * 
     * @param cdmBhnsstdBhnscusubject VIEW
     * @return VIEW集合
     */
    public List<CdmBhnsstdBhnscusubject> selectCdmBhnsstdBhnscusubjectList(CdmBhnsstdBhnscusubject cdmBhnsstdBhnscusubject);

    /**
     * 新增VIEW
     * 
     * @param cdmBhnsstdBhnscusubject VIEW
     * @return 结果
     */
    public int insertCdmBhnsstdBhnscusubject(CdmBhnsstdBhnscusubject cdmBhnsstdBhnscusubject);

    /**
     * 修改VIEW
     * 
     * @param cdmBhnsstdBhnscusubject VIEW
     * @return 结果
     */
    public int updateCdmBhnsstdBhnscusubject(CdmBhnsstdBhnscusubject cdmBhnsstdBhnscusubject);

    /**
     * 批量删除VIEW
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCdmBhnsstdBhnscusubjectByIds(String ids);

    /**
     * 删除VIEW信息
     * 
     * @param id VIEWID
     * @return 结果
     */
    public int deleteCdmBhnsstdBhnscusubjectById(Long id);
}
