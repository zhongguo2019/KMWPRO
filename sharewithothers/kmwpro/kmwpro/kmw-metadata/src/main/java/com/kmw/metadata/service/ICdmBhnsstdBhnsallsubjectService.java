package com.kmw.metadata.service;

import com.kmw.metadata.domain.CdmBhnsstdBhnsallsubject;
import java.util.List;

/**
 * 商业银行案例一数据标准_所有主题Service接口
 * 
 * @author kmw
 * @date 2020-02-07
 */
public interface ICdmBhnsstdBhnsallsubjectService 
{
    /**
     * 查询商业银行案例一数据标准_所有主题
     * 
     * @param id 商业银行案例一数据标准_所有主题ID
     * @return 商业银行案例一数据标准_所有主题
     */
    public CdmBhnsstdBhnsallsubject selectCdmBhnsstdBhnsallsubjectById(Long id);

    /**
     * 查询商业银行案例一数据标准_所有主题列表
     * 
     * @param cdmBhnsstdBhnsallsubject 商业银行案例一数据标准_所有主题
     * @return 商业银行案例一数据标准_所有主题集合
     */
    public List<CdmBhnsstdBhnsallsubject> selectCdmBhnsstdBhnsallsubjectList(CdmBhnsstdBhnsallsubject cdmBhnsstdBhnsallsubject);

    /**
     * 新增商业银行案例一数据标准_所有主题
     * 
     * @param cdmBhnsstdBhnsallsubject 商业银行案例一数据标准_所有主题
     * @return 结果
     */
    public int insertCdmBhnsstdBhnsallsubject(CdmBhnsstdBhnsallsubject cdmBhnsstdBhnsallsubject);

    /**
     * 修改商业银行案例一数据标准_所有主题
     * 
     * @param cdmBhnsstdBhnsallsubject 商业银行案例一数据标准_所有主题
     * @return 结果
     */
    public int updateCdmBhnsstdBhnsallsubject(CdmBhnsstdBhnsallsubject cdmBhnsstdBhnsallsubject);

    /**
     * 批量删除商业银行案例一数据标准_所有主题
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCdmBhnsstdBhnsallsubjectByIds(String ids);

    /**
     * 删除商业银行案例一数据标准_所有主题信息
     * 
     * @param id 商业银行案例一数据标准_所有主题ID
     * @return 结果
     */
    public int deleteCdmBhnsstdBhnsallsubjectById(Long id);
}
