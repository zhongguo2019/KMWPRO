package com.kmw.metadata.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.kmw.common.annotation.Excel;
import com.kmw.common.core.domain.BaseEntity;

/**
 * 银监报送报来源分析对象 cdm_jsnxods_cbrcsrctbl
 * 
 * @author kmw
 * @date 2020-02-07
 */
public class CdmJsnxodsCbrcsrctbl extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long orderno;

    /** 业务主题 */
    @Excel(name = "业务主题")
    private String subjectname;

    /** 报表编码 */
    @Excel(name = "报表编码")
    private String rptcode;

    /** 报表名称 */
    @Excel(name = "报表名称")
    private String rptname;

    /** 报送频度 */
    @Excel(name = "报送频度")
    private String seq;

    /** 来源表1 */
    @Excel(name = "来源表1")
    private String srctbl01;

    /** 来源表2 */
    @Excel(name = "来源表2")
    private String srctbl02;

    /** 来源表3 */
    @Excel(name = "来源表3")
    private String srctbl03;

    /** 来源表4 */
    @Excel(name = "来源表4")
    private String srctbl04;

    /** 来源表5 */
    @Excel(name = "来源表5")
    private String srctbl05;

    /** 来源表6 */
    @Excel(name = "来源表6")
    private String srctbl06;

    /** 来源表7 */
    @Excel(name = "来源表7")
    private String srctbl07;

    /** 来源表8 */
    @Excel(name = "来源表8")
    private String srctbl08;

    /** 来源表9 */
    @Excel(name = "来源表9")
    private String srctbl09;

    /** 来源表10 */
    @Excel(name = "来源表10")
    private String srctbl10;

    /** 来源表11 */
    @Excel(name = "来源表11")
    private String srctbl11;

    /** 来源表12 */
    @Excel(name = "来源表12")
    private String srctbl12;

    /** 来源表13 */
    @Excel(name = "来源表13")
    private String srctbl13;

    /** 来源表14 */
    @Excel(name = "来源表14")
    private String srctbl14;

    public void setOrderno(Long orderno) 
    {
        this.orderno = orderno;
    }

    public Long getOrderno() 
    {
        return orderno;
    }
    public void setSubjectname(String subjectname) 
    {
        this.subjectname = subjectname;
    }

    public String getSubjectname() 
    {
        return subjectname;
    }
    public void setRptcode(String rptcode) 
    {
        this.rptcode = rptcode;
    }

    public String getRptcode() 
    {
        return rptcode;
    }
    public void setRptname(String rptname) 
    {
        this.rptname = rptname;
    }

    public String getRptname() 
    {
        return rptname;
    }
    public void setSeq(String seq) 
    {
        this.seq = seq;
    }

    public String getSeq() 
    {
        return seq;
    }
    public void setSrctbl01(String srctbl01) 
    {
        this.srctbl01 = srctbl01;
    }

    public String getSrctbl01() 
    {
        return srctbl01;
    }
    public void setSrctbl02(String srctbl02) 
    {
        this.srctbl02 = srctbl02;
    }

    public String getSrctbl02() 
    {
        return srctbl02;
    }
    public void setSrctbl03(String srctbl03) 
    {
        this.srctbl03 = srctbl03;
    }

    public String getSrctbl03() 
    {
        return srctbl03;
    }
    public void setSrctbl04(String srctbl04) 
    {
        this.srctbl04 = srctbl04;
    }

    public String getSrctbl04() 
    {
        return srctbl04;
    }
    public void setSrctbl05(String srctbl05) 
    {
        this.srctbl05 = srctbl05;
    }

    public String getSrctbl05() 
    {
        return srctbl05;
    }
    public void setSrctbl06(String srctbl06) 
    {
        this.srctbl06 = srctbl06;
    }

    public String getSrctbl06() 
    {
        return srctbl06;
    }
    public void setSrctbl07(String srctbl07) 
    {
        this.srctbl07 = srctbl07;
    }

    public String getSrctbl07() 
    {
        return srctbl07;
    }
    public void setSrctbl08(String srctbl08) 
    {
        this.srctbl08 = srctbl08;
    }

    public String getSrctbl08() 
    {
        return srctbl08;
    }
    public void setSrctbl09(String srctbl09) 
    {
        this.srctbl09 = srctbl09;
    }

    public String getSrctbl09() 
    {
        return srctbl09;
    }
    public void setSrctbl10(String srctbl10) 
    {
        this.srctbl10 = srctbl10;
    }

    public String getSrctbl10() 
    {
        return srctbl10;
    }
    public void setSrctbl11(String srctbl11) 
    {
        this.srctbl11 = srctbl11;
    }

    public String getSrctbl11() 
    {
        return srctbl11;
    }
    public void setSrctbl12(String srctbl12) 
    {
        this.srctbl12 = srctbl12;
    }

    public String getSrctbl12() 
    {
        return srctbl12;
    }
    public void setSrctbl13(String srctbl13) 
    {
        this.srctbl13 = srctbl13;
    }

    public String getSrctbl13() 
    {
        return srctbl13;
    }
    public void setSrctbl14(String srctbl14) 
    {
        this.srctbl14 = srctbl14;
    }

    public String getSrctbl14() 
    {
        return srctbl14;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("orderno", getOrderno())
            .append("subjectname", getSubjectname())
            .append("rptcode", getRptcode())
            .append("rptname", getRptname())
            .append("seq", getSeq())
            .append("srctbl01", getSrctbl01())
            .append("srctbl02", getSrctbl02())
            .append("srctbl03", getSrctbl03())
            .append("srctbl04", getSrctbl04())
            .append("srctbl05", getSrctbl05())
            .append("srctbl06", getSrctbl06())
            .append("srctbl07", getSrctbl07())
            .append("srctbl08", getSrctbl08())
            .append("srctbl09", getSrctbl09())
            .append("srctbl10", getSrctbl10())
            .append("srctbl11", getSrctbl11())
            .append("srctbl12", getSrctbl12())
            .append("srctbl13", getSrctbl13())
            .append("srctbl14", getSrctbl14())
            .toString();
    }
}
