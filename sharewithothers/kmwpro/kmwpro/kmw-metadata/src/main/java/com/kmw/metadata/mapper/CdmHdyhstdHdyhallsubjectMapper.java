package com.kmw.metadata.mapper;

import com.kmw.metadata.domain.CdmHdyhstdHdyhallsubject;
import java.util.List;

/**
 * 商业银行案例三Mapper接口
 * 
 * @author kmw
 * @date 2020-02-16
 */
public interface CdmHdyhstdHdyhallsubjectMapper 
{
    /**
     * 查询商业银行案例三
     * 
     * @param id 商业银行案例三ID
     * @return 商业银行案例三
     */
    public CdmHdyhstdHdyhallsubject selectCdmHdyhstdHdyhallsubjectById(Long id);

    /**
     * 查询商业银行案例三列表
     * 
     * @param cdmHdyhstdHdyhallsubject 商业银行案例三
     * @return 商业银行案例三集合
     */
    public List<CdmHdyhstdHdyhallsubject> selectCdmHdyhstdHdyhallsubjectList(CdmHdyhstdHdyhallsubject cdmHdyhstdHdyhallsubject);

    /**
     * 新增商业银行案例三
     * 
     * @param cdmHdyhstdHdyhallsubject 商业银行案例三
     * @return 结果
     */
    public int insertCdmHdyhstdHdyhallsubject(CdmHdyhstdHdyhallsubject cdmHdyhstdHdyhallsubject);

    /**
     * 修改商业银行案例三
     * 
     * @param cdmHdyhstdHdyhallsubject 商业银行案例三
     * @return 结果
     */
    public int updateCdmHdyhstdHdyhallsubject(CdmHdyhstdHdyhallsubject cdmHdyhstdHdyhallsubject);

    /**
     * 删除商业银行案例三
     * 
     * @param id 商业银行案例三ID
     * @return 结果
     */
    public int deleteCdmHdyhstdHdyhallsubjectById(Long id);

    /**
     * 批量删除商业银行案例三
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCdmHdyhstdHdyhallsubjectByIds(String[] ids);
}
