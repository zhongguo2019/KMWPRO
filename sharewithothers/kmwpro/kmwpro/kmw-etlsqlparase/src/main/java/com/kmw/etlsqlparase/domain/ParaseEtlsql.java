package com.kmw.etlsqlparase.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.kmw.common.annotation.Excel;
import com.kmw.common.core.domain.BaseEntity;

/**
 * 解析ETL加工过程的SQL语法得到中文解释对象 parase_etlsql
 * 
 * @author kmw
 * @date 2020-03-02
 */
public class ParaseEtlsql extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private String id;

    /** 目标表表名英文 */
    @Excel(name = "目标表表名英文")
    private String targetTblenname;

    /** 目标表表名中文 */
    @Excel(name = "目标表表名中文")
    private String targetTblcnname;

    /** 来源表表名英文 */
    @Excel(name = "来源表表名英文")
    private String sourceTblenname;

    /** 来源表表名中文 */
    @Excel(name = "来源表表名中文")
    private String sourceTblcnname;

    /** 目标表字段名英文 */
    @Excel(name = "目标表字段名英文")
    private String targetColenname;

    /** 目标表字段名中文 */
    @Excel(name = "目标表字段名中文")
    private String targetColcnname;

    /** 来源表字段名英文 */
    @Excel(name = "来源表字段名英文")
    private String sourceColenname;

    /** 来源表字段名中文 */
    @Excel(name = "来源表字段名中文")
    private String sourceColcnname;

    /** 字段英文关系 */
    @Excel(name = "字段英文关系")
    private String columEnrelations;

    /** 字段中文关系 */
    @Excel(name = "字段中文关系")
    private String columCnrelations;

    /** SQL类型 */
    @Excel(name = "SQL类型")
    private String etlSqlType;

    /** 数据库类型 */
    @Excel(name = "数据库类型")
    private String etlDbType;

    /** SQL中的通配符 */
    @Excel(name = "SQL中的通配符")
    private String etlWildcards;

    /** 解析的SQL */
    @Excel(name = "解析的SQL")
    private String etlSql;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setTargetTblenname(String targetTblenname) 
    {
        this.targetTblenname = targetTblenname;
    }

    public String getTargetTblenname() 
    {
        return targetTblenname;
    }
    public void setTargetTblcnname(String targetTblcnname) 
    {
        this.targetTblcnname = targetTblcnname;
    }

    public String getTargetTblcnname() 
    {
        return targetTblcnname;
    }
    public void setSourceTblenname(String sourceTblenname) 
    {
        this.sourceTblenname = sourceTblenname;
    }

    public String getSourceTblenname() 
    {
        return sourceTblenname;
    }
    public void setSourceTblcnname(String sourceTblcnname) 
    {
        this.sourceTblcnname = sourceTblcnname;
    }

    public String getSourceTblcnname() 
    {
        return sourceTblcnname;
    }
    public void setTargetColenname(String targetColenname) 
    {
        this.targetColenname = targetColenname;
    }

    public String getTargetColenname() 
    {
        return targetColenname;
    }
    public void setTargetColcnname(String targetColcnname) 
    {
        this.targetColcnname = targetColcnname;
    }

    public String getTargetColcnname() 
    {
        return targetColcnname;
    }
    public void setSourceColenname(String sourceColenname) 
    {
        this.sourceColenname = sourceColenname;
    }

    public String getSourceColenname() 
    {
        return sourceColenname;
    }
    public void setSourceColcnname(String sourceColcnname) 
    {
        this.sourceColcnname = sourceColcnname;
    }

    public String getSourceColcnname() 
    {
        return sourceColcnname;
    }
    public void setColumEnrelations(String columEnrelations) 
    {
        this.columEnrelations = columEnrelations;
    }

    public String getColumEnrelations() 
    {
        return columEnrelations;
    }
    public void setColumCnrelations(String columCnrelations) 
    {
        this.columCnrelations = columCnrelations;
    }

    public String getColumCnrelations() 
    {
        return columCnrelations;
    }
    public void setEtlSqlType(String etlSqlType) 
    {
        this.etlSqlType = etlSqlType;
    }

    public String getEtlSqlType() 
    {
        return etlSqlType;
    }
    public void setEtlDbType(String etlDbType) 
    {
        this.etlDbType = etlDbType;
    }

    public String getEtlDbType() 
    {
        return etlDbType;
    }
    public void setEtlWildcards(String etlWildcards) 
    {
        this.etlWildcards = etlWildcards;
    }

    public String getEtlWildcards() 
    {
        return etlWildcards;
    }
    public void setEtlSql(String etlSql) 
    {
        this.etlSql = etlSql;
    }

    public String getEtlSql() 
    {
        return etlSql;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("targetTblenname", getTargetTblenname())
            .append("targetTblcnname", getTargetTblcnname())
            .append("sourceTblenname", getSourceTblenname())
            .append("sourceTblcnname", getSourceTblcnname())
            .append("targetColenname", getTargetColenname())
            .append("targetColcnname", getTargetColcnname())
            .append("sourceColenname", getSourceColenname())
            .append("sourceColcnname", getSourceColcnname())
            .append("columEnrelations", getColumEnrelations())
            .append("columCnrelations", getColumCnrelations())
            .append("etlSqlType", getEtlSqlType())
            .append("etlDbType", getEtlDbType())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("etlWildcards", getEtlWildcards())
            .append("etlSql", getEtlSql())
            .toString();
    }
}
