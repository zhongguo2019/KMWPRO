package com.kmw.qywx.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.kmw.common.annotation.Excel;
import com.kmw.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 当天工作记录信息对象 doufu_today_work
 * 
 * @author kmw
 * @date 2020-02-20
 */
public class DoufuTodayWork extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 所在项目组名称 */
    @Excel(name = "所在项目组名称")
    private String projectGroupId;

    /** 项目名称 */
    @Excel(name = "项目名称")
    private String projectId;

    /** 对应产品 */
    @Excel(name = "对应产品")
    private String productId;

    /** 工作内容简写 */
    @Excel(name = "工作内容简写")
    private String workContents;

    /** 工作内容详细描述 */
    @Excel(name = "工作内容详细描述")
    private String workDetail;

    /** 完成比例 */
    @Excel(name = "完成比例")
    private String finishPercent;

    /** 延迟原因 */
    @Excel(name = "延迟原因")
    private String delayReason;

    /** 对应计划 */
    @Excel(name = "对应计划")
    private String accordYesterday;

    /** 是否重要 */
    @Excel(name = "是否重要")
    private String isImportant;

    /** 是否紧急 */
    @Excel(name = "是否紧急")
    private String isEmergency;

    /** 重要级别 */
    @Excel(name = "重要级别")
    private String impoLevel;

    /** 主键 */
    private String id;

    /** 逻辑删除标记(0.正常，1.删除) */
    @Excel(name = "逻辑删除标记(0.正常，1.删除)")
    private String delFlag;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    /** 机构ID */
    @Excel(name = "机构ID")
    private String instId;

    /** 登录IP */
    @Excel(name = "登录IP")
    private String loginIp;

    /** 登录日期 */
    @Excel(name = "登录日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date loginDate;

    /** 创建时间 */
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createDate;

    /** 最近修改时间 */
    @Excel(name = "最近修改时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updateDate;

    /** 描述 */
    @Excel(name = "描述")
    private String remarks;

    /** 报告日期 */
    @Excel(name = "报告日期")
    private String reportDate;

    /** 产品名称 */
    @Excel(name = "产品名称")
    private String productName;

    /** 报告人ID */
    @Excel(name = "报告人ID")
    private String reporterId;

    /** 报告人名称 */
    @Excel(name = "报告人名称")
    private String reporterName;

    /** 录入内容序号 */
    @Excel(name = "录入内容序号")
    private int inputOrder;

    /** 是否为补报的日报 */
    @Excel(name = "是否为补报的日报")
    private String isAfter;

    public void setProjectGroupId(String projectGroupId) 
    {
        this.projectGroupId = projectGroupId;
    }

    public String getProjectGroupId() 
    {
        return projectGroupId;
    }
    public void setProjectId(String projectId) 
    {
        this.projectId = projectId;
    }

    public String getProjectId() 
    {
        return projectId;
    }
    public void setProductId(String productId) 
    {
        this.productId = productId;
    }

    public String getProductId() 
    {
        return productId;
    }
    public void setWorkContents(String workContents) 
    {
        this.workContents = workContents;
    }

    public String getWorkContents() 
    {
        return workContents;
    }
    public void setWorkDetail(String workDetail) 
    {
        this.workDetail = workDetail;
    }

    public String getWorkDetail() 
    {
        return workDetail;
    }
    public void setFinishPercent(String finishPercent) 
    {
        this.finishPercent = finishPercent;
    }

    public String getFinishPercent() 
    {
        return finishPercent;
    }
    public void setDelayReason(String delayReason) 
    {
        this.delayReason = delayReason;
    }

    public String getDelayReason() 
    {
        return delayReason;
    }
    public void setAccordYesterday(String accordYesterday) 
    {
        this.accordYesterday = accordYesterday;
    }

    public String getAccordYesterday() 
    {
        return accordYesterday;
    }
    public void setIsImportant(String isImportant) 
    {
        this.isImportant = isImportant;
    }

    public String getIsImportant() 
    {
        return isImportant;
    }
    public void setIsEmergency(String isEmergency) 
    {
        this.isEmergency = isEmergency;
    }

    public String getIsEmergency() 
    {
        return isEmergency;
    }
    public void setImpoLevel(String impoLevel) 
    {
        this.impoLevel = impoLevel;
    }

    public String getImpoLevel() 
    {
        return impoLevel;
    }
    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setInstId(String instId) 
    {
        this.instId = instId;
    }

    public String getInstId() 
    {
        return instId;
    }
    public void setLoginIp(String loginIp) 
    {
        this.loginIp = loginIp;
    }

    public String getLoginIp() 
    {
        return loginIp;
    }
    public void setLoginDate(Date loginDate) 
    {
        this.loginDate = loginDate;
    }

    public Date getLoginDate() 
    {
        return loginDate;
    }
    public void setCreateDate(Date createDate) 
    {
        this.createDate = createDate;
    }

    public Date getCreateDate() 
    {
        return createDate;
    }
    public void setUpdateDate(Date updateDate) 
    {
        this.updateDate = updateDate;
    }

    public Date getUpdateDate() 
    {
        return updateDate;
    }
    public void setRemarks(String remarks) 
    {
        this.remarks = remarks;
    }

    public String getRemarks() 
    {
        return remarks;
    }
    public void setReportDate(String reportDate) 
    {
        this.reportDate = reportDate;
    }

    public String getReportDate() 
    {
        return reportDate;
    }
    public void setProductName(String productName) 
    {
        this.productName = productName;
    }

    public String getProductName() 
    {
        return productName;
    }
    public void setReporterId(String reporterId) 
    {
        this.reporterId = reporterId;
    }

    public String getReporterId() 
    {
        return reporterId;
    }
    public void setReporterName(String reporterName) 
    {
        this.reporterName = reporterName;
    }

    public String getReporterName() 
    {
        return reporterName;
    }
    public void setInputOrder(int iorder) 
    {
        this.inputOrder = iorder;
    }

    public int getInputOrder() 
    {
        return inputOrder;
    }
    public void setIsAfter(String isAfter) 
    {
        this.isAfter = isAfter;
    }

    public String getIsAfter() 
    {
        return isAfter;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("projectGroupId", getProjectGroupId())
            .append("projectId", getProjectId())
            .append("productId", getProductId())
            .append("workContents", getWorkContents())
            .append("workDetail", getWorkDetail())
            .append("finishPercent", getFinishPercent())
            .append("delayReason", getDelayReason())
            .append("accordYesterday", getAccordYesterday())
            .append("isImportant", getIsImportant())
            .append("isEmergency", getIsEmergency())
            .append("impoLevel", getImpoLevel())
            .append("id", getId())
            .append("delFlag", getDelFlag())
            .append("status", getStatus())
            .append("instId", getInstId())
            .append("loginIp", getLoginIp())
            .append("loginDate", getLoginDate())
            .append("createBy", getCreateBy())
            .append("createDate", getCreateDate())
            .append("updateBy", getUpdateBy())
            .append("updateDate", getUpdateDate())
            .append("remarks", getRemarks())
            .append("reportDate", getReportDate())
            .append("productName", getProductName())
            .append("reporterId", getReporterId())
            .append("reporterName", getReporterName())
            .append("inputOrder", getInputOrder())
            .append("isAfter", getIsAfter())
            .toString();
    }
}
