package com.kmw.metadata.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.kmw.common.annotation.Excel;
import com.kmw.common.core.domain.BaseEntity;

/**
 * 商业银行案例一数据标准所有主题码值对照对象 cdm_bhnsstd_bhnsallsubject_bhnsallcoderef
 * 
 * @author kmw
 * @date 2020-02-07
 */
public class CdmBhnsstdBhnsallsubjectBhnsallcoderef extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 所属主题 */
    @Excel(name = "所属主题")
    private String codeSubject;

    /** 代码编号 */
    @Excel(name = "代码编号")
    private String codeId;

    /** 标准名称 */
    @Excel(name = "标准名称")
    private String codeStdname;

    /** 编码取值 */
    @Excel(name = "编码取值")
    private String codeValue;

    /** 编码说明 */
    @Excel(name = "编码说明")
    private String codeDesc;

    /** 备注 */
    @Excel(name = "备注")
    private String codeNote;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCodeSubject(String codeSubject) 
    {
        this.codeSubject = codeSubject;
    }

    public String getCodeSubject() 
    {
        return codeSubject;
    }
    public void setCodeId(String codeId) 
    {
        this.codeId = codeId;
    }

    public String getCodeId() 
    {
        return codeId;
    }
    public void setCodeStdname(String codeStdname) 
    {
        this.codeStdname = codeStdname;
    }

    public String getCodeStdname() 
    {
        return codeStdname;
    }
    public void setCodeValue(String codeValue) 
    {
        this.codeValue = codeValue;
    }

    public String getCodeValue() 
    {
        return codeValue;
    }
    public void setCodeDesc(String codeDesc) 
    {
        this.codeDesc = codeDesc;
    }

    public String getCodeDesc() 
    {
        return codeDesc;
    }
    public void setCodeNote(String codeNote) 
    {
        this.codeNote = codeNote;
    }

    public String getCodeNote() 
    {
        return codeNote;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("codeSubject", getCodeSubject())
            .append("codeId", getCodeId())
            .append("codeStdname", getCodeStdname())
            .append("codeValue", getCodeValue())
            .append("codeDesc", getCodeDesc())
            .append("codeNote", getCodeNote())
            .toString();
    }
}
