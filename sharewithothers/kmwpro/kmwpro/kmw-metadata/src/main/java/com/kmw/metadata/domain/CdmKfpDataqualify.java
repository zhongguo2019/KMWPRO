package com.kmw.metadata.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.kmw.common.annotation.Excel;
import com.kmw.common.core.domain.BaseEntity;

/**
 * 数据质量检核配置对象 cdm_kfp_dataqualify
 * 
 * @author kmw
 * @date 2020-03-13
 */
public class CdmKfpDataqualify extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private String id;

    /** 检查点分类01对应的业务源系统名称 */
    @Excel(name = "检查点分类01对应的业务源系统名称")
    private String checkpntTag01;

    /** 检查点分类02对应的业务源系统主题分类 */
    @Excel(name = "检查点分类02对应的业务源系统主题分类")
    private String checkpntTag02;

    /** 检查点分类03是针对表的检查点，还是针对字段的检查点 */
    @Excel(name = "检查点分类03是针对表的检查点，还是针对字段的检查点")
    private String checkpntTag03;

    /** 检查点分类04中文名称 */
    @Excel(name = "检查点分类04中文名称")
    private String checkpntTag04;

    /** 检查点分类05英文名称 */
    @Excel(name = "检查点分类05英文名称")
    private String checkpntTag05;

    /** 检查点分类06规则中文描述 */
    @Excel(name = "检查点分类06规则中文描述")
    private String checkpntTag06;

    /** 检查点分类07规则对应的效果检查部门银监，人民银行，行内经营 */
    @Excel(name = "检查点分类07规则对应的效果检查部门银监，人民银行，行内经营")
    private String checkpntTag07;

    /** 检查点分类08版本号 */
    @Excel(name = "检查点分类08版本号")
    private String checkpntTag08;

    /** 检查点分类09 */
    @Excel(name = "检查点分类09")
    private String checkpntTag09;

    /** 检查点分类10 */
    @Excel(name = "检查点分类10")
    private String checkpntTag10;

    /** 检查点分类11 */
    @Excel(name = "检查点分类11")
    private String checkpntTag11;

    /** 检查点分类12 */
    @Excel(name = "检查点分类12")
    private String checkpntTag12;

    /** 检查点分类13 */
    @Excel(name = "检查点分类13")
    private String checkpntTag13;

    /** 检查点分类14 */
    @Excel(name = "检查点分类14")
    private String checkpntTag14;

    /** 检查点分类15 */
    @Excel(name = "检查点分类15")
    private String checkpntTag15;

    /** 检查规则英文表达SQL */
    @Excel(name = "检查规则英文表达SQL")
    private String checkpntRulCndesc;

    /** 检查规则中文表达 */
    @Excel(name = "检查规则中文表达")
    private String checkpntRulEndesc;

    /** 检查的实体中文名称 */
    @Excel(name = "检查的实体中文名称")
    private String checkpntChkEntityCnname;

    /** 检查的实体英文名称 */
    @Excel(name = "检查的实体英文名称")
    private String checkpntChkEntityEnname;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setCheckpntTag01(String checkpntTag01) 
    {
        this.checkpntTag01 = checkpntTag01;
    }

    public String getCheckpntTag01() 
    {
        return checkpntTag01;
    }
    public void setCheckpntTag02(String checkpntTag02) 
    {
        this.checkpntTag02 = checkpntTag02;
    }

    public String getCheckpntTag02() 
    {
        return checkpntTag02;
    }
    public void setCheckpntTag03(String checkpntTag03) 
    {
        this.checkpntTag03 = checkpntTag03;
    }

    public String getCheckpntTag03() 
    {
        return checkpntTag03;
    }
    public void setCheckpntTag04(String checkpntTag04) 
    {
        this.checkpntTag04 = checkpntTag04;
    }

    public String getCheckpntTag04() 
    {
        return checkpntTag04;
    }
    public void setCheckpntTag05(String checkpntTag05) 
    {
        this.checkpntTag05 = checkpntTag05;
    }

    public String getCheckpntTag05() 
    {
        return checkpntTag05;
    }
    public void setCheckpntTag06(String checkpntTag06) 
    {
        this.checkpntTag06 = checkpntTag06;
    }

    public String getCheckpntTag06() 
    {
        return checkpntTag06;
    }
    public void setCheckpntTag07(String checkpntTag07) 
    {
        this.checkpntTag07 = checkpntTag07;
    }

    public String getCheckpntTag07() 
    {
        return checkpntTag07;
    }
    public void setCheckpntTag08(String checkpntTag08) 
    {
        this.checkpntTag08 = checkpntTag08;
    }

    public String getCheckpntTag08() 
    {
        return checkpntTag08;
    }
    public void setCheckpntTag09(String checkpntTag09) 
    {
        this.checkpntTag09 = checkpntTag09;
    }

    public String getCheckpntTag09() 
    {
        return checkpntTag09;
    }
    public void setCheckpntTag10(String checkpntTag10) 
    {
        this.checkpntTag10 = checkpntTag10;
    }

    public String getCheckpntTag10() 
    {
        return checkpntTag10;
    }
    public void setCheckpntTag11(String checkpntTag11) 
    {
        this.checkpntTag11 = checkpntTag11;
    }

    public String getCheckpntTag11() 
    {
        return checkpntTag11;
    }
    public void setCheckpntTag12(String checkpntTag12) 
    {
        this.checkpntTag12 = checkpntTag12;
    }

    public String getCheckpntTag12() 
    {
        return checkpntTag12;
    }
    public void setCheckpntTag13(String checkpntTag13) 
    {
        this.checkpntTag13 = checkpntTag13;
    }

    public String getCheckpntTag13() 
    {
        return checkpntTag13;
    }
    public void setCheckpntTag14(String checkpntTag14) 
    {
        this.checkpntTag14 = checkpntTag14;
    }

    public String getCheckpntTag14() 
    {
        return checkpntTag14;
    }
    public void setCheckpntTag15(String checkpntTag15) 
    {
        this.checkpntTag15 = checkpntTag15;
    }

    public String getCheckpntTag15() 
    {
        return checkpntTag15;
    }
    public void setCheckpntRulCndesc(String checkpntRulCndesc) 
    {
        this.checkpntRulCndesc = checkpntRulCndesc;
    }

    public String getCheckpntRulCndesc() 
    {
        return checkpntRulCndesc;
    }
    public void setCheckpntRulEndesc(String checkpntRulEndesc) 
    {
        this.checkpntRulEndesc = checkpntRulEndesc;
    }

    public String getCheckpntRulEndesc() 
    {
        return checkpntRulEndesc;
    }
    public void setCheckpntChkEntityCnname(String checkpntChkEntityCnname) 
    {
        this.checkpntChkEntityCnname = checkpntChkEntityCnname;
    }

    public String getCheckpntChkEntityCnname() 
    {
        return checkpntChkEntityCnname;
    }
    public void setCheckpntChkEntityEnname(String checkpntChkEntityEnname) 
    {
        this.checkpntChkEntityEnname = checkpntChkEntityEnname;
    }

    public String getCheckpntChkEntityEnname() 
    {
        return checkpntChkEntityEnname;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("checkpntTag01", getCheckpntTag01())
            .append("checkpntTag02", getCheckpntTag02())
            .append("checkpntTag03", getCheckpntTag03())
            .append("checkpntTag04", getCheckpntTag04())
            .append("checkpntTag05", getCheckpntTag05())
            .append("checkpntTag06", getCheckpntTag06())
            .append("checkpntTag07", getCheckpntTag07())
            .append("checkpntTag08", getCheckpntTag08())
            .append("checkpntTag09", getCheckpntTag09())
            .append("checkpntTag10", getCheckpntTag10())
            .append("checkpntTag11", getCheckpntTag11())
            .append("checkpntTag12", getCheckpntTag12())
            .append("checkpntTag13", getCheckpntTag13())
            .append("checkpntTag14", getCheckpntTag14())
            .append("checkpntTag15", getCheckpntTag15())
            .append("checkpntRulCndesc", getCheckpntRulCndesc())
            .append("checkpntRulEndesc", getCheckpntRulEndesc())
            .append("checkpntChkEntityCnname", getCheckpntChkEntityCnname())
            .append("checkpntChkEntityEnname", getCheckpntChkEntityEnname())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
