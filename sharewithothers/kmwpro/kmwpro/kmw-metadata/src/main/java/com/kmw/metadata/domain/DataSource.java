package com.kmw.metadata.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.kmw.common.annotation.Excel;
import com.kmw.common.core.domain.BaseEntity;

/**
 * 数据源管理对象 cdm_data_source
 * 
 * @author 赵祖龙
 * @date 2020-03-24
 */
public class DataSource extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 数据源编码 */
    @Excel(name = "数据源编码")
    private String dscode;

    /** 数据源名称 */
    @Excel(name = "数据源名称")
    private String dsname;

    /** 数据源类型 */
    @Excel(name = "数据源类型")
    private Integer dstype;

    /** 驱动类全名 */
    @Excel(name = "驱动类全名")
    private String dsdriver;

    /** jdbc链接 */
    @Excel(name = "jdbc链接")
    private String dsurl;

    /** 用户名 */
    @Excel(name = "用户名")
    private String username;

    /** 机构编码 */
    @Excel(name = "机构编码")
    private String organCode;

    /** 工具 */
    @Excel(name = "工具")
    private String defaultschema;

    /** 排序 */
    @Excel(name = "排序")
    private Integer showOrder;

    /** 创建机构 */
    @Excel(name = "创建机构")
    private String createOrgan;

    /** 创建用户 */
    @Excel(name = "创建用户")
    private String createUser;

    /** 密码 */
    @Excel(name = "密码")
    private String userpwd;

    /** 初始化链接大小 */
    @Excel(name = "初始化链接大小")
    private Integer initialsize;

    /** 最小空闲链接 */
    @Excel(name = "最小空闲链接")
    private Integer minidle;

    /** 最大空闲链接 */
    @Excel(name = "最大空闲链接")
    private Integer maxactive;

    /** 是否进行链接遗漏检测 */
    @Excel(name = "是否进行链接遗漏检测")
    private Integer removeabandoned;

    /** 链接活动时间(超过该时间即被回收) */
    @Excel(name = "链接活动时间(超过该时间即被回收)")
    private Integer removeabandonedtimeout;

    /** 最大获取链接时间 */
    @Excel(name = "最大获取链接时间")
    private Integer maxwait;

    /** 遗漏检测间隔时间 */
    @Excel(name = "遗漏检测间隔时间")
    private Integer timebetweenevictionrunsmillis;

    /** 是否缓存游标 */
    @Excel(name = "是否缓存游标")
    private Integer poolpreparedstatements;

    /** 主键 */
    private String id;

    public void setDscode(String dscode) 
    {
        this.dscode = dscode;
    }

    public String getDscode() 
    {
        return dscode;
    }
    public void setDsname(String dsname) 
    {
        this.dsname = dsname;
    }

    public String getDsname() 
    {
        return dsname;
    }
    public void setDstype(Integer dstype) 
    {
        this.dstype = dstype;
    }

    public Integer getDstype() 
    {
        return dstype;
    }
    public void setDsdriver(String dsdriver) 
    {
        this.dsdriver = dsdriver;
    }

    public String getDsdriver() 
    {
        return dsdriver;
    }
    public void setDsurl(String dsurl) 
    {
        this.dsurl = dsurl;
    }

    public String getDsurl() 
    {
        return dsurl;
    }
    public void setUsername(String username) 
    {
        this.username = username;
    }

    public String getUsername() 
    {
        return username;
    }
    public void setOrganCode(String organCode) 
    {
        this.organCode = organCode;
    }

    public String getOrganCode() 
    {
        return organCode;
    }
    public void setDefaultschema(String defaultschema) 
    {
        this.defaultschema = defaultschema;
    }

    public String getDefaultschema() 
    {
        return defaultschema;
    }
    public void setShowOrder(Integer showOrder) 
    {
        this.showOrder = showOrder;
    }

    public Integer getShowOrder() 
    {
        return showOrder;
    }
    public void setCreateOrgan(String createOrgan) 
    {
        this.createOrgan = createOrgan;
    }

    public String getCreateOrgan() 
    {
        return createOrgan;
    }
    public void setCreateUser(String createUser) 
    {
        this.createUser = createUser;
    }

    public String getCreateUser() 
    {
        return createUser;
    }
    public void setUserpwd(String userpwd) 
    {
        this.userpwd = userpwd;
    }

    public String getUserpwd() 
    {
        return userpwd;
    }
    public void setInitialsize(Integer initialsize) 
    {
        this.initialsize = initialsize;
    }

    public Integer getInitialsize() 
    {
        return initialsize;
    }
    public void setMinidle(Integer minidle) 
    {
        this.minidle = minidle;
    }

    public Integer getMinidle() 
    {
        return minidle;
    }
    public void setMaxactive(Integer maxactive) 
    {
        this.maxactive = maxactive;
    }

    public Integer getMaxactive() 
    {
        return maxactive;
    }
    public void setRemoveabandoned(Integer removeabandoned) 
    {
        this.removeabandoned = removeabandoned;
    }

    public Integer getRemoveabandoned() 
    {
        return removeabandoned;
    }
    public void setRemoveabandonedtimeout(Integer removeabandonedtimeout) 
    {
        this.removeabandonedtimeout = removeabandonedtimeout;
    }

    public Integer getRemoveabandonedtimeout() 
    {
        return removeabandonedtimeout;
    }
    public void setMaxwait(Integer maxwait) 
    {
        this.maxwait = maxwait;
    }

    public Integer getMaxwait() 
    {
        return maxwait;
    }
    public void setTimebetweenevictionrunsmillis(Integer timebetweenevictionrunsmillis) 
    {
        this.timebetweenevictionrunsmillis = timebetweenevictionrunsmillis;
    }

    public Integer getTimebetweenevictionrunsmillis() 
    {
        return timebetweenevictionrunsmillis;
    }
    public void setPoolpreparedstatements(Integer poolpreparedstatements) 
    {
        this.poolpreparedstatements = poolpreparedstatements;
    }

    public Integer getPoolpreparedstatements() 
    {
        return poolpreparedstatements;
    }
    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("dscode", getDscode())
            .append("dsname", getDsname())
            .append("dstype", getDstype())
            .append("dsdriver", getDsdriver())
            .append("dsurl", getDsurl())
            .append("username", getUsername())
            .append("organCode", getOrganCode())
            .append("defaultschema", getDefaultschema())
            .append("showOrder", getShowOrder())
            .append("createOrgan", getCreateOrgan())
            .append("createUser", getCreateUser())
            .append("userpwd", getUserpwd())
            .append("initialsize", getInitialsize())
            .append("minidle", getMinidle())
            .append("maxactive", getMaxactive())
            .append("removeabandoned", getRemoveabandoned())
            .append("removeabandonedtimeout", getRemoveabandonedtimeout())
            .append("maxwait", getMaxwait())
            .append("timebetweenevictionrunsmillis", getTimebetweenevictionrunsmillis())
            .append("poolpreparedstatements", getPoolpreparedstatements())
            .append("id", getId())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
