package com.kmw.metadata.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.kmw.common.annotation.Excel;
import com.kmw.common.core.domain.BaseEntity;

/**
 * ODS列对象 cdm_jsnxods_tableall
 * 
 * @author kmw
 * @date 2020-02-06
 */
public class CdmJsnxodsTableall extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 层级 */
    @Excel(name = "层级")
    private String layerName;

    /** 系统名称 */
    @Excel(name = "系统名称")
    private String systemName;

    /** 主题名称 */
    @Excel(name = "主题名称")
    private String subjectName;

    /** 表英文名称 */
    @Excel(name = "表英文名称")
    private String tblEnname;

    /** 表中文名称 */
    @Excel(name = "表中文名称")
    private String tblCnname;

    /** 表空间名 */
    @Excel(name = "表空间名")
    private String tblspaceName;

    /** 系统中文名称 */
    @Excel(name = "系统中文名称")
    private String systemCnname;

    /** 主键 */
    private Long id;

    public void setLayerName(String layerName) 
    {
        this.layerName = layerName;
    }

    public String getLayerName() 
    {
        return layerName;
    }
    public void setSystemName(String systemName) 
    {
        this.systemName = systemName;
    }

    public String getSystemName() 
    {
        return systemName;
    }
    public void setSubjectName(String subjectName) 
    {
        this.subjectName = subjectName;
    }

    public String getSubjectName() 
    {
        return subjectName;
    }
    public void setTblEnname(String tblEnname) 
    {
        this.tblEnname = tblEnname;
    }

    public String getTblEnname() 
    {
        return tblEnname;
    }
    public void setTblCnname(String tblCnname) 
    {
        this.tblCnname = tblCnname;
    }

    public String getTblCnname() 
    {
        return tblCnname;
    }
    public void setTblspaceName(String tblspaceName) 
    {
        this.tblspaceName = tblspaceName;
    }

    public String getTblspaceName() 
    {
        return tblspaceName;
    }
    public void setSystemCnname(String systemCnname) 
    {
        this.systemCnname = systemCnname;
    }

    public String getSystemCnname() 
    {
        return systemCnname;
    }
    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("layerName", getLayerName())
            .append("systemName", getSystemName())
            .append("subjectName", getSubjectName())
            .append("tblEnname", getTblEnname())
            .append("tblCnname", getTblCnname())
            .append("tblspaceName", getTblspaceName())
            .append("systemCnname", getSystemCnname())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .append("updateTime", getUpdateTime())
            .append("updateBy", getUpdateBy())
            .append("id", getId())
            .toString();
    }
}
