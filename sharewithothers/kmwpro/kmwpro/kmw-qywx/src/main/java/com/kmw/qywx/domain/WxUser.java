package com.kmw.qywx.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.kmw.common.annotation.Excel;
import com.kmw.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 企业微信用户信息对象 wx_user
 * 
 * @author kmw
 * @date 2020-03-07
 */
public class WxUser extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	/** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 帐号 */
    @Excel(name = "帐号")
    private String account;

    /** 别名 */
    @Excel(name = "别名")
    private String alaisname;

    /** 职务 */
    @Excel(name = "职务")
    private String duties;

    /** 部门 */
    @Excel(name = "部门")
    private String dept;

    /** 性别 */
    @Excel(name = "性别")
    private String sex;

    /** 手机 */
    @Excel(name = "手机")
    private String mobile;

    /** 座机 */
    @Excel(name = "座机")
    private String phone;

    /** 个人邮箱 */
    @Excel(name = "个人邮箱")
    private String email;

    /** 地址 */
    @Excel(name = "地址")
    private String address;

    /** 企业简称 */
    @Excel(name = "企业简称")
    private String shortcorname;

    /** 激活状态 */
    @Excel(name = "激活状态")
    private String isactive;

    /** 禁用状态 */
    @Excel(name = "禁用状态")
    private String isforbidden;

    /** 微工作台 */
    @Excel(name = "微工作台")
    private String wxplat;

    /** 登录日期 */
    @Excel(name = "登录日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date loginDate;

    /** 用户登录的机器IP */
    @Excel(name = "用户登录的机器IP")
    private String loginIp;

    /** 用户所在项目组ID */
    @Excel(name = "用户所在项目组ID")
    private String projectGroupId;

    /** 主键 */
    private String id;

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setAccount(String account) 
    {
        this.account = account;
    }

    public String getAccount() 
    {
        return account;
    }
    public void setAlaisname(String alaisname) 
    {
        this.alaisname = alaisname;
    }

    public String getAlaisname() 
    {
        return alaisname;
    }
    public void setDuties(String duties) 
    {
        this.duties = duties;
    }

    public String getDuties() 
    {
        return duties;
    }
    public void setDept(String dept) 
    {
        this.dept = dept;
    }

    public String getDept() 
    {
        return dept;
    }
    public void setSex(String sex) 
    {
        this.sex = sex;
    }

    public String getSex() 
    {
        return sex;
    }
    public void setMobile(String mobile) 
    {
        this.mobile = mobile;
    }

    public String getMobile() 
    {
        return mobile;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getEmail() 
    {
        return email;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setShortcorname(String shortcorname) 
    {
        this.shortcorname = shortcorname;
    }

    public String getShortcorname() 
    {
        return shortcorname;
    }
    public void setIsactive(String isactive) 
    {
        this.isactive = isactive;
    }

    public String getIsactive() 
    {
        return isactive;
    }
    public void setIsforbidden(String isforbidden) 
    {
        this.isforbidden = isforbidden;
    }

    public String getIsforbidden() 
    {
        return isforbidden;
    }
    public void setWxplat(String wxplat) 
    {
        this.wxplat = wxplat;
    }

    public String getWxplat() 
    {
        return wxplat;
    }
    public void setLoginDate(Date loginDate) 
    {
        this.loginDate = loginDate;
    }

    public Date getLoginDate() 
    {
        return loginDate;
    }
    public void setLoginIp(String loginIp) 
    {
        this.loginIp = loginIp;
    }

    public String getLoginIp() 
    {
        return loginIp;
    }
    public void setProjectGroupId(String projectGroupId) 
    {
        this.projectGroupId = projectGroupId;
    }

    public String getProjectGroupId() 
    {
        return projectGroupId;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("name", getName())
            .append("account", getAccount())
            .append("alaisname", getAlaisname())
            .append("duties", getDuties())
            .append("dept", getDept())
            .append("sex", getSex())
            .append("mobile", getMobile())
            .append("phone", getPhone())
            .append("email", getEmail())
            .append("address", getAddress())
            .append("shortcorname", getShortcorname())
            .append("isactive", getIsactive())
            .append("isforbidden", getIsforbidden())
            .append("wxplat", getWxplat())
            .append("loginDate", getLoginDate())
            .append("loginIp", getLoginIp())
            .append("projectGroupId", getProjectGroupId())
            .append("id", getId())
            .toString();
    }
}
