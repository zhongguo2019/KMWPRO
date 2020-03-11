package com.kmw.qywx.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.kmw.common.annotation.Excel;
import com.kmw.common.core.domain.BaseEntity;

/**
 * 企业微信部门信息对象 wx_department
 * 
 * @author kmw
 * @date 2020-03-07
 */
public class WxDepartment extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 部门ID */
    @Excel(name = "部门ID")
    private String departId;

    /** 部门名称 */
    @Excel(name = "部门名称")
    private String departName;

    /** 上级部门ID */
    @Excel(name = "上级部门ID")
    private String departParentId;

    /** 序号 */
    @Excel(name = "序号")
    private String departOrder;

    /** 主键 */
    private String id;

    public void setDepartId(String departId) 
    {
        this.departId = departId;
    }

    public String getDepartId() 
    {
        return departId;
    }
    public void setDepartName(String departName) 
    {
        this.departName = departName;
    }

    public String getDepartName() 
    {
        return departName;
    }
    public void setDepartParentId(String departParentId) 
    {
        this.departParentId = departParentId;
    }

    public String getDepartParentId() 
    {
        return departParentId;
    }
    public void setDepartOrder(String departOrder) 
    {
        this.departOrder = departOrder;
    }

    public String getDepartOrder() 
    {
        return departOrder;
    }
    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("departId", getDepartId())
            .append("departName", getDepartName())
            .append("departParentId", getDepartParentId())
            .append("departOrder", getDepartOrder())
            .append("id", getId())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
