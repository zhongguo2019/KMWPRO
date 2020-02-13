package com.kmw.metadata.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.kmw.common.annotation.Excel;
import com.kmw.common.core.domain.BaseEntity;

/**
 * 江苏农信省联社给各法人下发的数据库对象 cdm_jsnxods2inst_tablelist
 * 
 * @author kmw
 * @date 2020-02-06
 */
public class CdmJsnxods2instTablelist extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    @Excel(name = "序号")
    private String orderSort;

    /** 源系统 */
    @Excel(name = "源系统")
    private String sourceSysname;

    /** 表英文名 */
    @Excel(name = "表英文名")
    private String tableEnname;

    /** 表中文名 */
    @Excel(name = "表中文名")
    private String tableCnname;

    /** 加载频度 */
    @Excel(name = "加载频度")
    private String loadFrequence;

    /** 加载方式(全量或增量) */
    @Excel(name = "加载方式(全量或增量)")
    private String loadWay;

    /** 是否拆分 */
    @Excel(name = "是否拆分")
    private String loadSplit;

    /** 法人号 */
    @Excel(name = "法人号")
    private String loadCrtno;

    /** 源系统中文名称 */
    @Excel(name = "源系统中文名称")
    private String sourceSyscnname;

    /** 主键 */
    private Long id;

    public void setOrderSort(String orderSort) 
    {
        this.orderSort = orderSort;
    }

    public String getOrderSort() 
    {
        return orderSort;
    }
    public void setSourceSysname(String sourceSysname) 
    {
        this.sourceSysname = sourceSysname;
    }

    public String getSourceSysname() 
    {
        return sourceSysname;
    }
    public void setTableEnname(String tableEnname) 
    {
        this.tableEnname = tableEnname;
    }

    public String getTableEnname() 
    {
        return tableEnname;
    }
    public void setTableCnname(String tableCnname) 
    {
        this.tableCnname = tableCnname;
    }

    public String getTableCnname() 
    {
        return tableCnname;
    }
    public void setLoadFrequence(String loadFrequence) 
    {
        this.loadFrequence = loadFrequence;
    }

    public String getLoadFrequence() 
    {
        return loadFrequence;
    }
    public void setLoadWay(String loadWay) 
    {
        this.loadWay = loadWay;
    }

    public String getLoadWay() 
    {
        return loadWay;
    }
    public void setLoadSplit(String loadSplit) 
    {
        this.loadSplit = loadSplit;
    }

    public String getLoadSplit() 
    {
        return loadSplit;
    }
    public void setLoadCrtno(String loadCrtno) 
    {
        this.loadCrtno = loadCrtno;
    }

    public String getLoadCrtno() 
    {
        return loadCrtno;
    }
    public void setSourceSyscnname(String sourceSyscnname) 
    {
        this.sourceSyscnname = sourceSyscnname;
    }

    public String getSourceSyscnname() 
    {
        return sourceSyscnname;
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
            .append("orderSort", getOrderSort())
            .append("sourceSysname", getSourceSysname())
            .append("tableEnname", getTableEnname())
            .append("tableCnname", getTableCnname())
            .append("loadFrequence", getLoadFrequence())
            .append("loadWay", getLoadWay())
            .append("loadSplit", getLoadSplit())
            .append("loadCrtno", getLoadCrtno())
            .append("sourceSyscnname", getSourceSyscnname())
            .append("id", getId())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
