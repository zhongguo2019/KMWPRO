package com.kmw.metadata.mapper;

import com.kmw.metadata.domain.CdmBhnsstdBhnsallsubjectBhnsallcoderef;
import java.util.List;

/**
 * 商业银行案例一数据标准所有主题码值对照Mapper接口
 * 
 * @author kmw
 * @date 2020-02-07
 */
public interface CdmBhnsstdBhnsallsubjectBhnsallcoderefMapper 
{
    /**
     * 查询商业银行案例一数据标准所有主题码值对照
     * 
     * @param id 商业银行案例一数据标准所有主题码值对照ID
     * @return 商业银行案例一数据标准所有主题码值对照
     */
    public CdmBhnsstdBhnsallsubjectBhnsallcoderef selectCdmBhnsstdBhnsallsubjectBhnsallcoderefById(Long id);

    /**
     * 查询商业银行案例一数据标准所有主题码值对照列表
     * 
     * @param cdmBhnsstdBhnsallsubjectBhnsallcoderef 商业银行案例一数据标准所有主题码值对照
     * @return 商业银行案例一数据标准所有主题码值对照集合
     */
    public List<CdmBhnsstdBhnsallsubjectBhnsallcoderef> selectCdmBhnsstdBhnsallsubjectBhnsallcoderefList(CdmBhnsstdBhnsallsubjectBhnsallcoderef cdmBhnsstdBhnsallsubjectBhnsallcoderef);

    /**
     * 新增商业银行案例一数据标准所有主题码值对照
     * 
     * @param cdmBhnsstdBhnsallsubjectBhnsallcoderef 商业银行案例一数据标准所有主题码值对照
     * @return 结果
     */
    public int insertCdmBhnsstdBhnsallsubjectBhnsallcoderef(CdmBhnsstdBhnsallsubjectBhnsallcoderef cdmBhnsstdBhnsallsubjectBhnsallcoderef);

    /**
     * 修改商业银行案例一数据标准所有主题码值对照
     * 
     * @param cdmBhnsstdBhnsallsubjectBhnsallcoderef 商业银行案例一数据标准所有主题码值对照
     * @return 结果
     */
    public int updateCdmBhnsstdBhnsallsubjectBhnsallcoderef(CdmBhnsstdBhnsallsubjectBhnsallcoderef cdmBhnsstdBhnsallsubjectBhnsallcoderef);

    /**
     * 删除商业银行案例一数据标准所有主题码值对照
     * 
     * @param id 商业银行案例一数据标准所有主题码值对照ID
     * @return 结果
     */
    public int deleteCdmBhnsstdBhnsallsubjectBhnsallcoderefById(Long id);

    /**
     * 批量删除商业银行案例一数据标准所有主题码值对照
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCdmBhnsstdBhnsallsubjectBhnsallcoderefByIds(String[] ids);
}
