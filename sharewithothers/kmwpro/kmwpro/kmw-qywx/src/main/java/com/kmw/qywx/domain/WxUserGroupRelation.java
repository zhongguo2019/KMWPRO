package com.kmw.qywx.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.kmw.common.annotation.Excel;
import com.kmw.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 分组信息与用户对应关系对象 wx_user_group_relation
 * 
 * @author kmw
 * @date 2020-02-27
 */
public class WxUserGroupRelation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private String id;

    /** 小组负责人代码 */
    @Excel(name = "小组负责人代码")
    private String groupGusercode;

    /** 用户名称 */
    @Excel(name = "用户名称")
    private String groupGusername;

    /** 分组代码 */
    @Excel(name = "分组代码")
    private String groupGcode;

    /** 分组的中文组名 */
    @Excel(name = "分组的中文组名")
    private String groupGcname;

    /** 用户信息表中用户的代码 */
    @Excel(name = "用户信息表中用户的代码")
    private String userUaccount;

    /** 用户信息表中用户的名称 */
    @Excel(name = "用户信息表中用户的名称")
    private String userUname;

    /** 逻辑删除标记(0.正常，1.删除) */
    @Excel(name = "逻辑删除标记(0.正常，1.删除)")
    private String delFlag;

    /** 创建时间 */
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createDate;

    /** 最近修改时间 */
    @Excel(name = "最近修改时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updateDate;

    /** SASS模式机构代码 */
    @Excel(name = "SASS模式机构代码", width = 30, dateFormat = "yyyy-MM-dd")
    private Date instId;

    /** SASS模式机构名称 */
    @Excel(name = "SASS模式机构名称", width = 30, dateFormat = "yyyy-MM-dd")
    private Date instName;

    /** 描述 */
    @Excel(name = "描述")
    private String remarks;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setGroupGusercode(String groupGusercode) 
    {
        this.groupGusercode = groupGusercode;
    }

    public String getGroupGusercode() 
    {
        return groupGusercode;
    }
    public void setGroupGusername(String groupGusername) 
    {
        this.groupGusername = groupGusername;
    }

    public String getGroupGusername() 
    {
        return groupGusername;
    }
    public void setGroupGcode(String groupGcode) 
    {
        this.groupGcode = groupGcode;
    }

    public String getGroupGcode() 
    {
        return groupGcode;
    }
    public void setGroupGcname(String groupGcname) 
    {
        this.groupGcname = groupGcname;
    }

    public String getGroupGcname() 
    {
        return groupGcname;
    }
    public void setUserUaccount(String userUaccount) 
    {
        this.userUaccount = userUaccount;
    }

    public String getUserUaccount() 
    {
        return userUaccount;
    }
    public void setUserUname(String userUname) 
    {
        this.userUname = userUname;
    }

    public String getUserUname() 
    {
        return userUname;
    }
    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
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
    public void setInstId(Date instId) 
    {
        this.instId = instId;
    }

    public Date getInstId() 
    {
        return instId;
    }
    public void setInstName(Date instName) 
    {
        this.instName = instName;
    }

    public Date getInstName() 
    {
        return instName;
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
            .append("id", getId())
            .append("groupGusercode", getGroupGusercode())
            .append("groupGusername", getGroupGusername())
            .append("groupGcode", getGroupGcode())
            .append("groupGcname", getGroupGcname())
            .append("userUaccount", getUserUaccount())
            .append("userUname", getUserUname())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createDate", getCreateDate())
            .append("updateBy", getUpdateBy())
            .append("updateDate", getUpdateDate())
            .append("instId", getInstId())
            .append("instName", getInstName())
            .append("remarks", getRemarks())
            .toString();
    }
}
