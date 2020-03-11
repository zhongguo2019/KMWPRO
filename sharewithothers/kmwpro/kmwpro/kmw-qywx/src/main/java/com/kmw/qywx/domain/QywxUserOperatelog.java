package com.kmw.qywx.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.kmw.common.annotation.Excel;
import com.kmw.common.core.domain.BaseEntity;

/**
 * 保留用户每次提交的消息内容对象 qywx_user_operatelog
 * 
 * @author kmw
 * @date 2020-03-04
 */
public class QywxUserOperatelog extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private String id;

    /** 微信操作类型 */
    @Excel(name = "微信操作类型")
    private String operType;

    /** 提交文本 */
    @Excel(name = "提交文本")
    private String submitText;

    /** 消息来源IP */
    @Excel(name = "消息来源IP")
    private String messFromIp;

    /** 消息分类 */
    @Excel(name = "消息分类")
    private String messType;

    /** 报告日期 */
    @Excel(name = "报告日期")
    private String reportDate;

    /** 补报、日报 */
    @Excel(name = "补报、日报")
    private String reportType;

    /** 所在项目组 */
    @Excel(name = "所在项目组")
    private String groupCode;

    /** 用户账号 */
    @Excel(name = "用户账号")
    private String userAccount;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setOperType(String operType) 
    {
        this.operType = operType;
    }

    public String getOperType() 
    {
        return operType;
    }
    public void setSubmitText(String submitText) 
    {
        this.submitText = submitText;
    }

    public String getSubmitText() 
    {
        return submitText;
    }
    public void setMessFromIp(String messFromIp) 
    {
        this.messFromIp = messFromIp;
    }

    public String getMessFromIp() 
    {
        return messFromIp;
    }
    public void setMessType(String messType) 
    {
        this.messType = messType;
    }

    public String getMessType() 
    {
        return messType;
    }
    public void setReportDate(String reportDate) 
    {
        this.reportDate = reportDate;
    }

    public String getReportDate() 
    {
        return reportDate;
    }
    public void setReportType(String reportType) 
    {
        this.reportType = reportType;
    }

    public String getReportType() 
    {
        return reportType;
    }
    public void setGroupCode(String groupCode) 
    {
        this.groupCode = groupCode;
    }

    public String getGroupCode() 
    {
        return groupCode;
    }
    public void setUserAccount(String userAccount) 
    {
        this.userAccount = userAccount;
    }

    public String getUserAccount() 
    {
        return userAccount;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("operType", getOperType())
            .append("submitText", getSubmitText())
            .append("messFromIp", getMessFromIp())
            .append("messType", getMessType())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("reportDate", getReportDate())
            .append("reportType", getReportType())
            .append("groupCode", getGroupCode())
            .append("userAccount", getUserAccount())
            .toString();
    }
}
