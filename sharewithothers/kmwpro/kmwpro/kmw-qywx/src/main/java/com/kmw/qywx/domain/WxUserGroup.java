package com.kmw.qywx.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.kmw.common.annotation.Excel;
import com.kmw.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 微信用户分组信息对象 wx_user_group
 * 
 * @author kmw
 * @date 2020-02-20
 */
public class WxUserGroup extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 小组负责人 */
    @Excel(name = "小组负责人")
    private String userId;

    /** 用户编码 */
    @Excel(name = "用户编码")
    private String userCode;

    /** 用户名称 */
    @Excel(name = "用户名称")
    private String username;

    /** 用户分组编码 */
    @Excel(name = "用户分组编码")
    private String groupCode;

    /** 负责小组名称 广东农信;南京银行MAST; */
    @Excel(name = "负责小组名称 广东农信;南京银行MAST;")
    private String groupCname;

    /** 是否要通知微信消息 */
    @Excel(name = "是否要通知微信消息")
    private String isMsg;

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

    public void setUserId(String userId) 
    {
        this.userId = userId;
    }

    public String getUserId() 
    {
        return userId;
    }
    public void setUserCode(String userCode) 
    {
        this.userCode = userCode;
    }

    public String getUserCode() 
    {
        return userCode;
    }
    public void setUsername(String username) 
    {
        this.username = username;
    }

    public String getUsername() 
    {
        return username;
    }
    public void setGroupCode(String groupCode) 
    {
        this.groupCode = groupCode;
    }

    public String getGroupCode() 
    {
        return groupCode;
    }
    public void setGroupCname(String groupCname) 
    {
        this.groupCname = groupCname;
    }

    public String getGroupCname() 
    {
        return groupCname;
    }
    public void setIsMsg(String isMsg) 
    {
        this.isMsg = isMsg;
    }

    public String getIsMsg() 
    {
        return isMsg;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("userId", getUserId())
            .append("userCode", getUserCode())
            .append("username", getUsername())
            .append("groupCode", getGroupCode())
            .append("groupCname", getGroupCname())
            .append("isMsg", getIsMsg())
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
            .toString();
    }
}
