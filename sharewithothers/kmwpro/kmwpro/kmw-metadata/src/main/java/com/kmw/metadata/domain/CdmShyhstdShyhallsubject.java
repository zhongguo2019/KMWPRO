package com.kmw.metadata.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.kmw.common.annotation.Excel;
import com.kmw.common.core.domain.BaseEntity;

/**
 * 商业银行案例四对象 cdm_shyhstd_shyhallsubject
 * 
 * @author kmw
 * @date 2020-02-16
 */
public class CdmShyhstdShyhallsubject extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long id;

    /** 标准层次 */
    @Excel(name = "标准层次")
    private String busStdLevel;

    /** 标准编号 */
    @Excel(name = "标准编号")
    private String busStdCode;

    /** 标准主题 */
    @Excel(name = "标准主题")
    private String busStdSubject;

    /** 一级分类 */
    @Excel(name = "一级分类")
    private String busLevOne;

    /** 二级分类 */
    @Excel(name = "二级分类")
    private String busLevTwo;

    /** 三级分类 */
    @Excel(name = "三级分类")
    private String busLevThree;

    /** 中文名称 */
    @Excel(name = "中文名称")
    private String busCnName;

    /** 英文名称 */
    @Excel(name = "英文名称")
    private String busEnName;

    /** 常用名称 */
    @Excel(name = "常用名称")
    private String busNickName;

    /** 业务定义 */
    @Excel(name = "业务定义")
    private String busBussMean;

    /** 适用类型 */
    @Excel(name = "适用类型")
    private String busIsSuit;

    /** 适用条件 */
    @Excel(name = "适用条件")
    private String busForceCondition;

    /** 制定依据 */
    @Excel(name = "制定依据")
    private String forceAccord;

    /** 监管标志 */
    @Excel(name = "监管标志")
    private String busIsSupervision;

    /** 业务数据类型 */
    @Excel(name = "业务数据类型")
    private String busDataType;

    /** 备注 */
    @Excel(name = "备注")
    private String busNote;

    /** 数据类型 */
    @Excel(name = "数据类型")
    private String techDataType;

    /** 度量单位 */
    @Excel(name = "度量单位")
    private String techMeasureUnit;

    /** 数据长度 */
    @Excel(name = "数据长度")
    private String techDataLength;

    /** 数据精度 */
    @Excel(name = "数据精度")
    private String techDataPrecision;

    /** 取值范围 */
    @Excel(name = "取值范围")
    private String techDatasScope;

    /** 数据格式 */
    @Excel(name = "数据格式")
    private String techDataFormat;

    /** 公共代码主题 */
    @Excel(name = "公共代码主题")
    private String techPublicSubject;

    /** 引用代码 */
    @Excel(name = "引用代码")
    private String techAccordCode;

    /** 代码链接 */
    @Excel(name = "代码链接")
    private String techCodeLink;

    /** 校验规则 */
    @Excel(name = "校验规则")
    private String techCheckrule;

    /** 主管部门 */
    @Excel(name = "主管部门")
    private String manageBusinessDepartment;

    /** 发布状态 */
    @Excel(name = "发布状态")
    private String manageDeployStatus;

    /** 发布时间 */
    @Excel(name = "发布时间")
    private String manageDeployTime;

    /** 备注 */
    @Excel(name = "备注")
    private String manageNote;

    /** 银行名称 */
    @Excel(name = "银行名称")
    private String bankName;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setBusStdLevel(String busStdLevel) 
    {
        this.busStdLevel = busStdLevel;
    }

    public String getBusStdLevel() 
    {
        return busStdLevel;
    }
    public void setBusStdCode(String busStdCode) 
    {
        this.busStdCode = busStdCode;
    }

    public String getBusStdCode() 
    {
        return busStdCode;
    }
    public void setBusStdSubject(String busStdSubject) 
    {
        this.busStdSubject = busStdSubject;
    }

    public String getBusStdSubject() 
    {
        return busStdSubject;
    }
    public void setBusLevOne(String busLevOne) 
    {
        this.busLevOne = busLevOne;
    }

    public String getBusLevOne() 
    {
        return busLevOne;
    }
    public void setBusLevTwo(String busLevTwo) 
    {
        this.busLevTwo = busLevTwo;
    }

    public String getBusLevTwo() 
    {
        return busLevTwo;
    }
    public void setBusLevThree(String busLevThree) 
    {
        this.busLevThree = busLevThree;
    }

    public String getBusLevThree() 
    {
        return busLevThree;
    }
    public void setBusCnName(String busCnName) 
    {
        this.busCnName = busCnName;
    }

    public String getBusCnName() 
    {
        return busCnName;
    }
    public void setBusEnName(String busEnName) 
    {
        this.busEnName = busEnName;
    }

    public String getBusEnName() 
    {
        return busEnName;
    }
    public void setBusNickName(String busNickName) 
    {
        this.busNickName = busNickName;
    }

    public String getBusNickName() 
    {
        return busNickName;
    }
    public void setBusBussMean(String busBussMean) 
    {
        this.busBussMean = busBussMean;
    }

    public String getBusBussMean() 
    {
        return busBussMean;
    }
    public void setBusIsSuit(String busIsSuit) 
    {
        this.busIsSuit = busIsSuit;
    }

    public String getBusIsSuit() 
    {
        return busIsSuit;
    }
    public void setBusForceCondition(String busForceCondition) 
    {
        this.busForceCondition = busForceCondition;
    }

    public String getBusForceCondition() 
    {
        return busForceCondition;
    }
    public void setForceAccord(String forceAccord) 
    {
        this.forceAccord = forceAccord;
    }

    public String getForceAccord() 
    {
        return forceAccord;
    }
    public void setBusIsSupervision(String busIsSupervision) 
    {
        this.busIsSupervision = busIsSupervision;
    }

    public String getBusIsSupervision() 
    {
        return busIsSupervision;
    }
    public void setBusDataType(String busDataType) 
    {
        this.busDataType = busDataType;
    }

    public String getBusDataType() 
    {
        return busDataType;
    }
    public void setBusNote(String busNote) 
    {
        this.busNote = busNote;
    }

    public String getBusNote() 
    {
        return busNote;
    }
    public void setTechDataType(String techDataType) 
    {
        this.techDataType = techDataType;
    }

    public String getTechDataType() 
    {
        return techDataType;
    }
    public void setTechMeasureUnit(String techMeasureUnit) 
    {
        this.techMeasureUnit = techMeasureUnit;
    }

    public String getTechMeasureUnit() 
    {
        return techMeasureUnit;
    }
    public void setTechDataLength(String techDataLength) 
    {
        this.techDataLength = techDataLength;
    }

    public String getTechDataLength() 
    {
        return techDataLength;
    }
    public void setTechDataPrecision(String techDataPrecision) 
    {
        this.techDataPrecision = techDataPrecision;
    }

    public String getTechDataPrecision() 
    {
        return techDataPrecision;
    }
    public void setTechDatasScope(String techDatasScope) 
    {
        this.techDatasScope = techDatasScope;
    }

    public String getTechDatasScope() 
    {
        return techDatasScope;
    }
    public void setTechDataFormat(String techDataFormat) 
    {
        this.techDataFormat = techDataFormat;
    }

    public String getTechDataFormat() 
    {
        return techDataFormat;
    }
    public void setTechPublicSubject(String techPublicSubject) 
    {
        this.techPublicSubject = techPublicSubject;
    }

    public String getTechPublicSubject() 
    {
        return techPublicSubject;
    }
    public void setTechAccordCode(String techAccordCode) 
    {
        this.techAccordCode = techAccordCode;
    }

    public String getTechAccordCode() 
    {
        return techAccordCode;
    }
    public void setTechCodeLink(String techCodeLink) 
    {
        this.techCodeLink = techCodeLink;
    }

    public String getTechCodeLink() 
    {
        return techCodeLink;
    }
    public void setTechCheckrule(String techCheckrule) 
    {
        this.techCheckrule = techCheckrule;
    }

    public String getTechCheckrule() 
    {
        return techCheckrule;
    }
    public void setManageBusinessDepartment(String manageBusinessDepartment) 
    {
        this.manageBusinessDepartment = manageBusinessDepartment;
    }

    public String getManageBusinessDepartment() 
    {
        return manageBusinessDepartment;
    }
    public void setManageDeployStatus(String manageDeployStatus) 
    {
        this.manageDeployStatus = manageDeployStatus;
    }

    public String getManageDeployStatus() 
    {
        return manageDeployStatus;
    }
    public void setManageDeployTime(String manageDeployTime) 
    {
        this.manageDeployTime = manageDeployTime;
    }

    public String getManageDeployTime() 
    {
        return manageDeployTime;
    }
    public void setManageNote(String manageNote) 
    {
        this.manageNote = manageNote;
    }

    public String getManageNote() 
    {
        return manageNote;
    }
    public void setBankName(String bankName) 
    {
        this.bankName = bankName;
    }

    public String getBankName() 
    {
        return bankName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("busStdLevel", getBusStdLevel())
            .append("busStdCode", getBusStdCode())
            .append("busStdSubject", getBusStdSubject())
            .append("busLevOne", getBusLevOne())
            .append("busLevTwo", getBusLevTwo())
            .append("busLevThree", getBusLevThree())
            .append("busCnName", getBusCnName())
            .append("busEnName", getBusEnName())
            .append("busNickName", getBusNickName())
            .append("busBussMean", getBusBussMean())
            .append("busIsSuit", getBusIsSuit())
            .append("busForceCondition", getBusForceCondition())
            .append("forceAccord", getForceAccord())
            .append("busIsSupervision", getBusIsSupervision())
            .append("busDataType", getBusDataType())
            .append("busNote", getBusNote())
            .append("techDataType", getTechDataType())
            .append("techMeasureUnit", getTechMeasureUnit())
            .append("techDataLength", getTechDataLength())
            .append("techDataPrecision", getTechDataPrecision())
            .append("techDatasScope", getTechDatasScope())
            .append("techDataFormat", getTechDataFormat())
            .append("techPublicSubject", getTechPublicSubject())
            .append("techAccordCode", getTechAccordCode())
            .append("techCodeLink", getTechCodeLink())
            .append("techCheckrule", getTechCheckrule())
            .append("manageBusinessDepartment", getManageBusinessDepartment())
            .append("manageDeployStatus", getManageDeployStatus())
            .append("manageDeployTime", getManageDeployTime())
            .append("manageNote", getManageNote())
            .append("bankName", getBankName())
            .toString();
    }
}
