package com.kmw.metadata.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kmw.metadata.mapper.CdmBhnsstdBhnsallsubjectMapper;
import com.kmw.metadata.domain.CdmBhnsstdBhnsallsubject;
import com.kmw.metadata.service.ICdmBhnsstdBhnsallsubjectService;
import com.kmw.common.core.text.Convert;

/**
 * 商业银行案例一数据标准_所有主题Service业务层处理
 * 
 * @author kmw
 * @date 2020-02-07
 */
@Service
public class CdmBhnsstdBhnsallsubjectServiceImpl implements ICdmBhnsstdBhnsallsubjectService 
{
    @Autowired
    private CdmBhnsstdBhnsallsubjectMapper cdmBhnsstdBhnsallsubjectMapper;

    /**
     * 查询商业银行案例一数据标准_所有主题
     * 
     * @param id 商业银行案例一数据标准_所有主题ID
     * @return 商业银行案例一数据标准_所有主题
     */
    @Override
    public CdmBhnsstdBhnsallsubject selectCdmBhnsstdBhnsallsubjectById(Long id)
    {
        return cdmBhnsstdBhnsallsubjectMapper.selectCdmBhnsstdBhnsallsubjectById(id);
    }

    /**
     * 查询商业银行案例一数据标准_所有主题列表
     * 
     * @param cdmBhnsstdBhnsallsubject 商业银行案例一数据标准_所有主题
     * @return 商业银行案例一数据标准_所有主题
     */
    @Override
    public List<CdmBhnsstdBhnsallsubject> selectCdmBhnsstdBhnsallsubjectList(CdmBhnsstdBhnsallsubject cdmBhnsstdBhnsallsubject)
    {
        return cdmBhnsstdBhnsallsubjectMapper.selectCdmBhnsstdBhnsallsubjectList(cdmBhnsstdBhnsallsubject);
    }

    /**
     * 新增商业银行案例一数据标准_所有主题
     * 
     * @param cdmBhnsstdBhnsallsubject 商业银行案例一数据标准_所有主题
     * @return 结果
     */
    @Override
    public int insertCdmBhnsstdBhnsallsubject(CdmBhnsstdBhnsallsubject cdmBhnsstdBhnsallsubject)
    {
        return cdmBhnsstdBhnsallsubjectMapper.insertCdmBhnsstdBhnsallsubject(cdmBhnsstdBhnsallsubject);
    }

    /**
     * 修改商业银行案例一数据标准_所有主题
     * 
     * @param cdmBhnsstdBhnsallsubject 商业银行案例一数据标准_所有主题
     * @return 结果
     */
    @Override
    public int updateCdmBhnsstdBhnsallsubject(CdmBhnsstdBhnsallsubject cdmBhnsstdBhnsallsubject)
    {
        return cdmBhnsstdBhnsallsubjectMapper.updateCdmBhnsstdBhnsallsubject(cdmBhnsstdBhnsallsubject);
    }

    /**
     * 删除商业银行案例一数据标准_所有主题对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCdmBhnsstdBhnsallsubjectByIds(String ids)
    {
        return cdmBhnsstdBhnsallsubjectMapper.deleteCdmBhnsstdBhnsallsubjectByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除商业银行案例一数据标准_所有主题信息
     * 
     * @param id 商业银行案例一数据标准_所有主题ID
     * @return 结果
     */
    @Override
    public int deleteCdmBhnsstdBhnsallsubjectById(Long id)
    {
        return cdmBhnsstdBhnsallsubjectMapper.deleteCdmBhnsstdBhnsallsubjectById(id);
    }
}
