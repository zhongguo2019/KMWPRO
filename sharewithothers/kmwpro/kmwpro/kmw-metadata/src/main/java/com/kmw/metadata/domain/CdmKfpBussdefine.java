package com.kmw.metadata.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.kmw.common.annotation.Excel;
import com.kmw.common.core.domain.BaseEntity;

/**
 * 银行束语定义集对象 cdm_kfp_bussdefine
 * 
 * @author kmw
 * @date 2020-02-17
 */
public class CdmKfpBussdefine extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long id;

    /** 业务主题 */
    @Excel(name = "业务主题")
    private String busSubject;

    /** 一级分类 */
    @Excel(name = "一级分类")
    private String busLeve1;

    /** 二级分类 */
    @Excel(name = "二级分类")
    private String busLeve2;

    /** 三级分类 */
    @Excel(name = "三级分类")
    private String busLeve3;

    /** 代码 */
    @Excel(name = "代码")
    private String busCode;

    /** 中文名称 */
    @Excel(name = "中文名称")
    private String busCnname;

    /** 英文名称 */
    @Excel(name = "英文名称")
    private String busEnname;

    /** 业务定义一 */
    @Excel(name = "业务定义一")
    private String busMean1;

    /** 业务定义二 */
    @Excel(name = "业务定义二")
    private String busMean2;

    /** 业务定义三 */
    @Excel(name = "业务定义三")
    private String busMean3;

    /** 业务定义四 */
    @Excel(name = "业务定义四")
    private String busMean4;

    /** 业务定义五 */
    @Excel(name = "业务定义五")
    private String busMean5;

    /** 适用场景 */
    @Excel(name = "适用场景")
    private String busFitEnv;

    /** 参考来源 */
    @Excel(name = "参考来源")
    private String busAccord;

    /** 使用部门 */
    @Excel(name = "使用部门")
    private String busUseDept;

    /** 使用部门 */
    @Excel(name = "使用部门")
    private String busNote;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setBusSubject(String busSubject) 
    {
        this.busSubject = busSubject;
    }

    public String getBusSubject() 
    {
        return busSubject;
    }
    public void setBusLeve1(String busLeve1) 
    {
        this.busLeve1 = busLeve1;
    }

    public String getBusLeve1() 
    {
        return busLeve1;
    }
    public void setBusLeve2(String busLeve2) 
    {
        this.busLeve2 = busLeve2;
    }

    public String getBusLeve2() 
    {
        return busLeve2;
    }
    public void setBusLeve3(String busLeve3) 
    {
        this.busLeve3 = busLeve3;
    }

    public String getBusLeve3() 
    {
        return busLeve3;
    }
    public void setBusCode(String busCode) 
    {
        this.busCode = busCode;
    }

    public String getBusCode() 
    {
        return busCode;
    }
    public void setBusCnname(String busCnname) 
    {
        this.busCnname = busCnname;
    }

    public String getBusCnname() 
    {
        return busCnname;
    }
    public void setBusEnname(String busEnname) 
    {
        this.busEnname = busEnname;
    }

    public String getBusEnname() 
    {
        return busEnname;
    }
    public void setBusMean1(String busMean1) 
    {
        this.busMean1 = busMean1;
    }

    public String getBusMean1() 
    {
        return busMean1;
    }
    public void setBusMean2(String busMean2) 
    {
        this.busMean2 = busMean2;
    }

    public String getBusMean2() 
    {
        return busMean2;
    }
    public void setBusMean3(String busMean3) 
    {
        this.busMean3 = busMean3;
    }

    public String getBusMean3() 
    {
        return busMean3;
    }
    public void setBusMean4(String busMean4) 
    {
        this.busMean4 = busMean4;
    }

    public String getBusMean4() 
    {
        return busMean4;
    }
    public void setBusMean5(String busMean5) 
    {
        this.busMean5 = busMean5;
    }

    public String getBusMean5() 
    {
        return busMean5;
    }
    public void setBusFitEnv(String busFitEnv) 
    {
        this.busFitEnv = busFitEnv;
    }

    public String getBusFitEnv() 
    {
        return busFitEnv;
    }
    public void setBusAccord(String busAccord) 
    {
        this.busAccord = busAccord;
    }

    public String getBusAccord() 
    {
        return busAccord;
    }
    public void setBusUseDept(String busUseDept) 
    {
        this.busUseDept = busUseDept;
    }

    public String getBusUseDept() 
    {
        return busUseDept;
    }
    public void setBusNote(String busNote) 
    {
        this.busNote = busNote;
    }

    public String getBusNote() 
    {
        return busNote;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("busSubject", getBusSubject())
            .append("busLeve1", getBusLeve1())
            .append("busLeve2", getBusLeve2())
            .append("busLeve3", getBusLeve3())
            .append("busCode", getBusCode())
            .append("busCnname", getBusCnname())
            .append("busEnname", getBusEnname())
            .append("busMean1", getBusMean1())
            .append("busMean2", getBusMean2())
            .append("busMean3", getBusMean3())
            .append("busMean4", getBusMean4())
            .append("busMean5", getBusMean5())
            .append("busFitEnv", getBusFitEnv())
            .append("busAccord", getBusAccord())
            .append("busUseDept", getBusUseDept())
            .append("busNote", getBusNote())
            .toString();
    }
}
