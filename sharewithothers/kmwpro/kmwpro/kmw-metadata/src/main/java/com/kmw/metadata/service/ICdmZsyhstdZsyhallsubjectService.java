package com.kmw.metadata.service;

import com.kmw.metadata.domain.CdmZsyhstdZsyhallsubject;
import java.util.List;

/**
 * 案例二数据标准Service接口
 * 
 * @author kmw
 * @date 2020-02-12
 */
public interface ICdmZsyhstdZsyhallsubjectService 
{
    /**
     * 查询案例二数据标准
     * 
     * @param id 案例二数据标准ID
     * @return 案例二数据标准
     */
    public CdmZsyhstdZsyhallsubject selectCdmZsyhstdZsyhallsubjectById(Long id);

    /**
     * 查询案例二数据标准列表
     * 
     * @param cdmZsyhstdZsyhallsubject 案例二数据标准
     * @return 案例二数据标准集合
     */
    public List<CdmZsyhstdZsyhallsubject> selectCdmZsyhstdZsyhallsubjectList(CdmZsyhstdZsyhallsubject cdmZsyhstdZsyhallsubject);

    /**
     * 新增案例二数据标准
     * 
     * @param cdmZsyhstdZsyhallsubject 案例二数据标准
     * @return 结果
     */
    public int insertCdmZsyhstdZsyhallsubject(CdmZsyhstdZsyhallsubject cdmZsyhstdZsyhallsubject);

    /**
     * 修改案例二数据标准
     * 
     * @param cdmZsyhstdZsyhallsubject 案例二数据标准
     * @return 结果
     */
    public int updateCdmZsyhstdZsyhallsubject(CdmZsyhstdZsyhallsubject cdmZsyhstdZsyhallsubject);

    /**
     * 批量删除案例二数据标准
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCdmZsyhstdZsyhallsubjectByIds(String ids);

    /**
     * 删除案例二数据标准信息
     * 
     * @param id 案例二数据标准ID
     * @return 结果
     */
    public int deleteCdmZsyhstdZsyhallsubjectById(Long id);
}
