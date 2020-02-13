package com.kmw.metadata.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kmw.metadata.mapper.CdmBhnsstdBhnsallsubjectBhnsallcoderefMapper;
import com.kmw.metadata.domain.CdmBhnsstdBhnsallsubjectBhnsallcoderef;
import com.kmw.metadata.service.ICdmBhnsstdBhnsallsubjectBhnsallcoderefService;
import com.kmw.common.core.text.Convert;

/**
 * 商业银行案例一数据标准所有主题码值对照Service业务层处理
 * 
 * @author kmw
 * @date 2020-02-07
 */
@Service
public class CdmBhnsstdBhnsallsubjectBhnsallcoderefServiceImpl implements ICdmBhnsstdBhnsallsubjectBhnsallcoderefService 
{
    @Autowired
    private CdmBhnsstdBhnsallsubjectBhnsallcoderefMapper cdmBhnsstdBhnsallsubjectBhnsallcoderefMapper;

    /**
     * 查询商业银行案例一数据标准所有主题码值对照
     * 
     * @param id 商业银行案例一数据标准所有主题码值对照ID
     * @return 商业银行案例一数据标准所有主题码值对照
     */
    @Override
    public CdmBhnsstdBhnsallsubjectBhnsallcoderef selectCdmBhnsstdBhnsallsubjectBhnsallcoderefById(Long id)
    {
        return cdmBhnsstdBhnsallsubjectBhnsallcoderefMapper.selectCdmBhnsstdBhnsallsubjectBhnsallcoderefById(id);
    }

    /**
     * 查询商业银行案例一数据标准所有主题码值对照列表
     * 
     * @param cdmBhnsstdBhnsallsubjectBhnsallcoderef 商业银行案例一数据标准所有主题码值对照
     * @return 商业银行案例一数据标准所有主题码值对照
     */
    @Override
    public List<CdmBhnsstdBhnsallsubjectBhnsallcoderef> selectCdmBhnsstdBhnsallsubjectBhnsallcoderefList(CdmBhnsstdBhnsallsubjectBhnsallcoderef cdmBhnsstdBhnsallsubjectBhnsallcoderef)
    {
        return cdmBhnsstdBhnsallsubjectBhnsallcoderefMapper.selectCdmBhnsstdBhnsallsubjectBhnsallcoderefList(cdmBhnsstdBhnsallsubjectBhnsallcoderef);
    }

    /**
     * 新增商业银行案例一数据标准所有主题码值对照
     * 
     * @param cdmBhnsstdBhnsallsubjectBhnsallcoderef 商业银行案例一数据标准所有主题码值对照
     * @return 结果
     */
    @Override
    public int insertCdmBhnsstdBhnsallsubjectBhnsallcoderef(CdmBhnsstdBhnsallsubjectBhnsallcoderef cdmBhnsstdBhnsallsubjectBhnsallcoderef)
    {
        return cdmBhnsstdBhnsallsubjectBhnsallcoderefMapper.insertCdmBhnsstdBhnsallsubjectBhnsallcoderef(cdmBhnsstdBhnsallsubjectBhnsallcoderef);
    }

    /**
     * 修改商业银行案例一数据标准所有主题码值对照
     * 
     * @param cdmBhnsstdBhnsallsubjectBhnsallcoderef 商业银行案例一数据标准所有主题码值对照
     * @return 结果
     */
    @Override
    public int updateCdmBhnsstdBhnsallsubjectBhnsallcoderef(CdmBhnsstdBhnsallsubjectBhnsallcoderef cdmBhnsstdBhnsallsubjectBhnsallcoderef)
    {
        return cdmBhnsstdBhnsallsubjectBhnsallcoderefMapper.updateCdmBhnsstdBhnsallsubjectBhnsallcoderef(cdmBhnsstdBhnsallsubjectBhnsallcoderef);
    }

    /**
     * 删除商业银行案例一数据标准所有主题码值对照对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCdmBhnsstdBhnsallsubjectBhnsallcoderefByIds(String ids)
    {
        return cdmBhnsstdBhnsallsubjectBhnsallcoderefMapper.deleteCdmBhnsstdBhnsallsubjectBhnsallcoderefByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除商业银行案例一数据标准所有主题码值对照信息
     * 
     * @param id 商业银行案例一数据标准所有主题码值对照ID
     * @return 结果
     */
    @Override
    public int deleteCdmBhnsstdBhnsallsubjectBhnsallcoderefById(Long id)
    {
        return cdmBhnsstdBhnsallsubjectBhnsallcoderefMapper.deleteCdmBhnsstdBhnsallsubjectBhnsallcoderefById(id);
    }
}
