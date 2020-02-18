package com.kmw.metadata.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kmw.metadata.mapper.CdmKfpBussdefineMapper;
import com.kmw.metadata.domain.CdmKfpBussdefine;
import com.kmw.metadata.service.ICdmKfpBussdefineService;
import com.kmw.common.core.text.Convert;

/**
 * 银行束语定义集Service业务层处理
 * 
 * @author kmw
 * @date 2020-02-17
 */
@Service
public class CdmKfpBussdefineServiceImpl implements ICdmKfpBussdefineService 
{
    @Autowired
    private CdmKfpBussdefineMapper cdmKfpBussdefineMapper;

    /**
     * 查询银行束语定义集
     * 
     * @param id 银行束语定义集ID
     * @return 银行束语定义集
     */
    @Override
    public CdmKfpBussdefine selectCdmKfpBussdefineById(Long id)
    {
        return cdmKfpBussdefineMapper.selectCdmKfpBussdefineById(id);
    }

    /**
     * 查询银行束语定义集列表
     * 
     * @param cdmKfpBussdefine 银行束语定义集
     * @return 银行束语定义集
     */
    @Override
    public List<CdmKfpBussdefine> selectCdmKfpBussdefineList(CdmKfpBussdefine cdmKfpBussdefine)
    {
        return cdmKfpBussdefineMapper.selectCdmKfpBussdefineList(cdmKfpBussdefine);
    }

    /**
     * 新增银行束语定义集
     * 
     * @param cdmKfpBussdefine 银行束语定义集
     * @return 结果
     */
    @Override
    public int insertCdmKfpBussdefine(CdmKfpBussdefine cdmKfpBussdefine)
    {
        return cdmKfpBussdefineMapper.insertCdmKfpBussdefine(cdmKfpBussdefine);
    }

    /**
     * 修改银行束语定义集
     * 
     * @param cdmKfpBussdefine 银行束语定义集
     * @return 结果
     */
    @Override
    public int updateCdmKfpBussdefine(CdmKfpBussdefine cdmKfpBussdefine)
    {
        return cdmKfpBussdefineMapper.updateCdmKfpBussdefine(cdmKfpBussdefine);
    }

    /**
     * 删除银行束语定义集对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCdmKfpBussdefineByIds(String ids)
    {
        return cdmKfpBussdefineMapper.deleteCdmKfpBussdefineByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除银行束语定义集信息
     * 
     * @param id 银行束语定义集ID
     * @return 结果
     */
    @Override
    public int deleteCdmKfpBussdefineById(Long id)
    {
        return cdmKfpBussdefineMapper.deleteCdmKfpBussdefineById(id);
    }
}
