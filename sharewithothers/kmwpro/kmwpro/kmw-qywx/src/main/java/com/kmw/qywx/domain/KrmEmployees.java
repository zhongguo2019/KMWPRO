package com.kmw.qywx.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.kmw.common.annotation.Excel;
import com.kmw.common.core.domain.BaseEntity;

/**
 * 员工信息KRM对象 krm_employees
 * 
 * @author kmw
 * @date 2020-03-20
 */
public class KrmEmployees extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    @Excel(name = "序号")
    private String id;

    /** OA编号 */
    @Excel(name = "OA编号")
    private String oaCode;

    /** 入职地 */
    @Excel(name = "入职地")
    private String empBaseAddr;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 性别 */
    @Excel(name = "性别")
    private String gender;

    /** 入职时间 */
    @Excel(name = "入职时间")
    private String empDate;

    /** 转正日期 */
    @Excel(name = "转正日期")
    private String posiDate;

    /** 本司工龄 */
    @Excel(name = "本司工龄")
    private String srvLength;

    /** 所属部门 */
    @Excel(name = "所属部门")
    private String department;

    /** 本司职务 */
    @Excel(name = "本司职务")
    private String duty;

    /** 身份证号 */
    @Excel(name = "身份证号")
    private String idCode;

    /** 出生年月 */
    @Excel(name = "出生年月")
    private String birDate;

    /** 年龄 */
    @Excel(name = "年龄")
    private String age;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String tel;

    /** QQ号码 */
    @Excel(name = "QQ号码")
    private String qq;

    /** 私人邮箱 */
    @Excel(name = "私人邮箱")
    private String perEmail;

    /** 浦发工资卡号 */
    @Excel(name = "浦发工资卡号")
    private String salaCard;

    /** 社保公积金基数 */
    @Excel(name = "社保公积金基数")
    private String shbGjjLine;

    /** 社保基数 */
    @Excel(name = "社保基数")
    private String shbBaseLine;

    /** 公积金基数 */
    @Excel(name = "公积金基数")
    private String gjjBaseLine;

    /** 社保起始月 */
    @Excel(name = "社保起始月")
    private String shbStartMon;

    /** 公积金起始月 */
    @Excel(name = "公积金起始月")
    private String gjjStartMon;

    /** 缴费人员类别 */
    @Excel(name = "缴费人员类别")
    private String jfType;

    /** 户口所在地-籍贯 */
    @Excel(name = "户口所在地-籍贯")
    private String homeAddr;

    /** 有效劳动合同期 */
    @Excel(name = "有效劳动合同期")
    private String htDate;

    /** 婚否 */
    @Excel(name = "婚否")
    private String isMarry;

    /** 民族 */
    @Excel(name = "民族")
    private String nation;

    /** 毕业院校 */
    @Excel(name = "毕业院校")
    private String graduate;

    /** 学历 */
    @Excel(name = "学历")
    private String education;

    /** 专业 */
    @Excel(name = "专业")
    private String specilialition;

    /** 毕业时间 */
    @Excel(name = "毕业时间")
    private String graduateTime;

    /** 职称/职业资格 */
    @Excel(name = "职称/职业资格")
    private String workLevel;

    /** 现住址 */
    @Excel(name = "现住址")
    private String nowAddress;

    /** 紧急联系方式 */
    @Excel(name = "紧急联系方式")
    private String emrTel;

    /** 公司邮箱 */
    @Excel(name = "公司邮箱")
    private String comEmail;

    /** 预留 */
    @Excel(name = "预留")
    private String resrFld01;

    /** 预留 */
    @Excel(name = "预留")
    private String resrFld02;

    /** 预留 */
    @Excel(name = "预留")
    private String resrFld03;

    /** 预留 */
    @Excel(name = "预留")
    private String resrFld04;

    /** 预留 */
    @Excel(name = "预留")
    private String resrFld05;

    /** 预留 */
    @Excel(name = "预留")
    private String resrFld06;

    /** 预留 */
    @Excel(name = "预留")
    private String resrFld07;

    /** 预留 */
    @Excel(name = "预留")
    private String resrFld08;

    /** 预留 */
    @Excel(name = "预留")
    private String resrFld09;

    /** 预留 */
    @Excel(name = "预留")
    private String resrFld10;

    /** 预留 */
    @Excel(name = "预留")
    private String resrFld11;

    /** 预留 */
    @Excel(name = "预留")
    private String resrFld12;

    /** 预留 */
    @Excel(name = "预留")
    private String resrFld13;

    /** 预留 */
    @Excel(name = "预留")
    private String resrFld14;

    /** 预留 */
    @Excel(name = "预留")
    private String resrFld15;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setOaCode(String oaCode) 
    {
        this.oaCode = oaCode;
    }

    public String getOaCode() 
    {
        return oaCode;
    }
    public void setEmpBaseAddr(String empBaseAddr) 
    {
        this.empBaseAddr = empBaseAddr;
    }

    public String getEmpBaseAddr() 
    {
        return empBaseAddr;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setGender(String gender) 
    {
        this.gender = gender;
    }

    public String getGender() 
    {
        return gender;
    }
    public void setEmpDate(String empDate) 
    {
        this.empDate = empDate;
    }

    public String getEmpDate() 
    {
        return empDate;
    }
    public void setPosiDate(String posiDate) 
    {
        this.posiDate = posiDate;
    }

    public String getPosiDate() 
    {
        return posiDate;
    }
    public void setSrvLength(String srvLength) 
    {
        this.srvLength = srvLength;
    }

    public String getSrvLength() 
    {
        return srvLength;
    }
    public void setDepartment(String department) 
    {
        this.department = department;
    }

    public String getDepartment() 
    {
        return department;
    }
    public void setDuty(String duty) 
    {
        this.duty = duty;
    }

    public String getDuty() 
    {
        return duty;
    }
    public void setIdCode(String idCode) 
    {
        this.idCode = idCode;
    }

    public String getIdCode() 
    {
        return idCode;
    }
    public void setBirDate(String birDate) 
    {
        this.birDate = birDate;
    }

    public String getBirDate() 
    {
        return birDate;
    }
    public void setAge(String age) 
    {
        this.age = age;
    }

    public String getAge() 
    {
        return age;
    }
    public void setTel(String tel) 
    {
        this.tel = tel;
    }

    public String getTel() 
    {
        return tel;
    }
    public void setQq(String qq) 
    {
        this.qq = qq;
    }

    public String getQq() 
    {
        return qq;
    }
    public void setPerEmail(String perEmail) 
    {
        this.perEmail = perEmail;
    }

    public String getPerEmail() 
    {
        return perEmail;
    }
    public void setSalaCard(String salaCard) 
    {
        this.salaCard = salaCard;
    }

    public String getSalaCard() 
    {
        return salaCard;
    }
    public void setShbGjjLine(String shbGjjLine) 
    {
        this.shbGjjLine = shbGjjLine;
    }

    public String getShbGjjLine() 
    {
        return shbGjjLine;
    }
    public void setShbBaseLine(String shbBaseLine) 
    {
        this.shbBaseLine = shbBaseLine;
    }

    public String getShbBaseLine() 
    {
        return shbBaseLine;
    }
    public void setGjjBaseLine(String gjjBaseLine) 
    {
        this.gjjBaseLine = gjjBaseLine;
    }

    public String getGjjBaseLine() 
    {
        return gjjBaseLine;
    }
    public void setShbStartMon(String shbStartMon) 
    {
        this.shbStartMon = shbStartMon;
    }

    public String getShbStartMon() 
    {
        return shbStartMon;
    }
    public void setGjjStartMon(String gjjStartMon) 
    {
        this.gjjStartMon = gjjStartMon;
    }

    public String getGjjStartMon() 
    {
        return gjjStartMon;
    }
    public void setJfType(String jfType) 
    {
        this.jfType = jfType;
    }

    public String getJfType() 
    {
        return jfType;
    }
    public void setHomeAddr(String homeAddr) 
    {
        this.homeAddr = homeAddr;
    }

    public String getHomeAddr() 
    {
        return homeAddr;
    }
    public void setHtDate(String htDate) 
    {
        this.htDate = htDate;
    }

    public String getHtDate() 
    {
        return htDate;
    }
    public void setIsMarry(String isMarry) 
    {
        this.isMarry = isMarry;
    }

    public String getIsMarry() 
    {
        return isMarry;
    }
    public void setNation(String nation) 
    {
        this.nation = nation;
    }

    public String getNation() 
    {
        return nation;
    }
    public void setGraduate(String graduate) 
    {
        this.graduate = graduate;
    }

    public String getGraduate() 
    {
        return graduate;
    }
    public void setEducation(String education) 
    {
        this.education = education;
    }

    public String getEducation() 
    {
        return education;
    }
    public void setSpecilialition(String specilialition) 
    {
        this.specilialition = specilialition;
    }

    public String getSpecilialition() 
    {
        return specilialition;
    }
    public void setGraduateTime(String graduateTime) 
    {
        this.graduateTime = graduateTime;
    }

    public String getGraduateTime() 
    {
        return graduateTime;
    }
    public void setWorkLevel(String workLevel) 
    {
        this.workLevel = workLevel;
    }

    public String getWorkLevel() 
    {
        return workLevel;
    }
    public void setNowAddress(String nowAddress) 
    {
        this.nowAddress = nowAddress;
    }

    public String getNowAddress() 
    {
        return nowAddress;
    }
    public void setEmrTel(String emrTel) 
    {
        this.emrTel = emrTel;
    }

    public String getEmrTel() 
    {
        return emrTel;
    }
    public void setComEmail(String comEmail) 
    {
        this.comEmail = comEmail;
    }

    public String getComEmail() 
    {
        return comEmail;
    }
    public void setResrFld01(String resrFld01) 
    {
        this.resrFld01 = resrFld01;
    }

    public String getResrFld01() 
    {
        return resrFld01;
    }
    public void setResrFld02(String resrFld02) 
    {
        this.resrFld02 = resrFld02;
    }

    public String getResrFld02() 
    {
        return resrFld02;
    }
    public void setResrFld03(String resrFld03) 
    {
        this.resrFld03 = resrFld03;
    }

    public String getResrFld03() 
    {
        return resrFld03;
    }
    public void setResrFld04(String resrFld04) 
    {
        this.resrFld04 = resrFld04;
    }

    public String getResrFld04() 
    {
        return resrFld04;
    }
    public void setResrFld05(String resrFld05) 
    {
        this.resrFld05 = resrFld05;
    }

    public String getResrFld05() 
    {
        return resrFld05;
    }
    public void setResrFld06(String resrFld06) 
    {
        this.resrFld06 = resrFld06;
    }

    public String getResrFld06() 
    {
        return resrFld06;
    }
    public void setResrFld07(String resrFld07) 
    {
        this.resrFld07 = resrFld07;
    }

    public String getResrFld07() 
    {
        return resrFld07;
    }
    public void setResrFld08(String resrFld08) 
    {
        this.resrFld08 = resrFld08;
    }

    public String getResrFld08() 
    {
        return resrFld08;
    }
    public void setResrFld09(String resrFld09) 
    {
        this.resrFld09 = resrFld09;
    }

    public String getResrFld09() 
    {
        return resrFld09;
    }
    public void setResrFld10(String resrFld10) 
    {
        this.resrFld10 = resrFld10;
    }

    public String getResrFld10() 
    {
        return resrFld10;
    }
    public void setResrFld11(String resrFld11) 
    {
        this.resrFld11 = resrFld11;
    }

    public String getResrFld11() 
    {
        return resrFld11;
    }
    public void setResrFld12(String resrFld12) 
    {
        this.resrFld12 = resrFld12;
    }

    public String getResrFld12() 
    {
        return resrFld12;
    }
    public void setResrFld13(String resrFld13) 
    {
        this.resrFld13 = resrFld13;
    }

    public String getResrFld13() 
    {
        return resrFld13;
    }
    public void setResrFld14(String resrFld14) 
    {
        this.resrFld14 = resrFld14;
    }

    public String getResrFld14() 
    {
        return resrFld14;
    }
    public void setResrFld15(String resrFld15) 
    {
        this.resrFld15 = resrFld15;
    }

    public String getResrFld15() 
    {
        return resrFld15;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("oaCode", getOaCode())
            .append("empBaseAddr", getEmpBaseAddr())
            .append("name", getName())
            .append("gender", getGender())
            .append("empDate", getEmpDate())
            .append("posiDate", getPosiDate())
            .append("srvLength", getSrvLength())
            .append("department", getDepartment())
            .append("duty", getDuty())
            .append("idCode", getIdCode())
            .append("birDate", getBirDate())
            .append("age", getAge())
            .append("tel", getTel())
            .append("qq", getQq())
            .append("perEmail", getPerEmail())
            .append("salaCard", getSalaCard())
            .append("shbGjjLine", getShbGjjLine())
            .append("shbBaseLine", getShbBaseLine())
            .append("gjjBaseLine", getGjjBaseLine())
            .append("shbStartMon", getShbStartMon())
            .append("gjjStartMon", getGjjStartMon())
            .append("jfType", getJfType())
            .append("homeAddr", getHomeAddr())
            .append("htDate", getHtDate())
            .append("isMarry", getIsMarry())
            .append("nation", getNation())
            .append("graduate", getGraduate())
            .append("education", getEducation())
            .append("specilialition", getSpecilialition())
            .append("graduateTime", getGraduateTime())
            .append("workLevel", getWorkLevel())
            .append("nowAddress", getNowAddress())
            .append("emrTel", getEmrTel())
            .append("comEmail", getComEmail())
            .append("resrFld01", getResrFld01())
            .append("resrFld02", getResrFld02())
            .append("resrFld03", getResrFld03())
            .append("resrFld04", getResrFld04())
            .append("resrFld05", getResrFld05())
            .append("resrFld06", getResrFld06())
            .append("resrFld07", getResrFld07())
            .append("resrFld08", getResrFld08())
            .append("resrFld09", getResrFld09())
            .append("resrFld10", getResrFld10())
            .append("resrFld11", getResrFld11())
            .append("resrFld12", getResrFld12())
            .append("resrFld13", getResrFld13())
            .append("resrFld14", getResrFld14())
            .append("resrFld15", getResrFld15())
            .toString();
    }
}
