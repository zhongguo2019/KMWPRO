package com.kmw.metadata.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.kmw.common.annotation.Excel;
import com.kmw.common.core.domain.BaseEntity;

/**
 * 江苏农信ODS数据字典对象 cdm_jsnxods_dictionary
 * 
 * @author kmw
 * @date 2020-02-06
 */
public class CdmJsnxodsDictionary extends BaseEntity
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

    /** 序号 */
    @Excel(name = "序号")
    private String orderSort;

    /** 字段英文名 */
    @Excel(name = "字段英文名")
    private String fldEnname;

    /** 字段中文名 */
    @Excel(name = "字段中文名")
    private String fldCnname;

    /** 字段类型 */
    @Excel(name = "字段类型")
    private String fldType;

    /** 长度 */
    @Excel(name = "长度")
    private String fldLen;

    /** 精度 */
    @Excel(name = "精度")
    private String fldPrecision;

    /** 主键否 */
    @Excel(name = "主键否")
    private String fldIskey;

    /** 空值否 */
    @Excel(name = "空值否")
    private String fldIsnull;

    /** 分区否 */
    @Excel(name = "分区否")
    private String isPartion;

    /** 表空间名 */
    @Excel(name = "表空间名")
    private String tblspaceName;

    /** 代码 */
    @Excel(name = "代码")
    private String fldCode;

    /** 备注 */
    @Excel(name = "备注")
    private String fldCommet;

    /** 系统中文名称 */
    @Excel(name = "系统中文名称")
    private String systemCnname;

    /** 主键 */
    private Integer id;

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
    public void setOrderSort(String orderSort) 
    {
        this.orderSort = orderSort;
    }

    public String getOrderSort() 
    {
        return orderSort;
    }
    public void setFldEnname(String fldEnname) 
    {
        this.fldEnname = fldEnname;
    }

    public String getFldEnname() 
    {
        return fldEnname;
    }
    public void setFldCnname(String fldCnname) 
    {
        this.fldCnname = fldCnname;
    }

    public String getFldCnname() 
    {
        return fldCnname;
    }
    public void setFldType(String fldType) 
    {
        this.fldType = fldType;
    }

    public String getFldType() 
    {
        return fldType;
    }
    public void setFldLen(String fldLen) 
    {
        this.fldLen = fldLen;
    }

    public String getFldLen() 
    {
        return fldLen;
    }
    public void setFldPrecision(String fldPrecision) 
    {
        this.fldPrecision = fldPrecision;
    }

    public String getFldPrecision() 
    {
        return fldPrecision;
    }
    public void setFldIskey(String fldIskey) 
    {
        this.fldIskey = fldIskey;
    }

    public String getFldIskey() 
    {
        return fldIskey;
    }
    public void setFldIsnull(String fldIsnull) 
    {
        this.fldIsnull = fldIsnull;
    }

    public String getFldIsnull() 
    {
        return fldIsnull;
    }
    public void setIsPartion(String isPartion) 
    {
        this.isPartion = isPartion;
    }

    public String getIsPartion() 
    {
        return isPartion;
    }
    public void setTblspaceName(String tblspaceName) 
    {
        this.tblspaceName = tblspaceName;
    }

    public String getTblspaceName() 
    {
        return tblspaceName;
    }
    public void setFldCode(String fldCode) 
    {
        this.fldCode = fldCode;
    }

    public String getFldCode() 
    {
        return fldCode;
    }
    public void setFldCommet(String fldCommet) 
    {
        this.fldCommet = fldCommet;
    }

    public String getFldCommet() 
    {
        return fldCommet;
    }
    public void setSystemCnname(String systemCnname) 
    {
        this.systemCnname = systemCnname;
    }

    public String getSystemCnname() 
    {
        return systemCnname;
    }
    public void setId(Integer id) 
    {
        this.id = id;
    }

    public Integer getId() 
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
            .append("orderSort", getOrderSort())
            .append("fldEnname", getFldEnname())
            .append("fldCnname", getFldCnname())
            .append("fldType", getFldType())
            .append("fldLen", getFldLen())
            .append("fldPrecision", getFldPrecision())
            .append("fldIskey", getFldIskey())
            .append("fldIsnull", getFldIsnull())
            .append("isPartion", getIsPartion())
            .append("tblspaceName", getTblspaceName())
            .append("fldCode", getFldCode())
            .append("fldCommet", getFldCommet())
            .append("systemCnname", getSystemCnname())
            .append("id", getId())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
