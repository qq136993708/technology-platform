package com.pcitc.base.expert;

import com.pcitc.base.common.DataEntity;


import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * <p>实体类</p>
 * <p>Table: zjk_base_info - 专家-基本信息</p>
 *
 * @since 2018-12-19 10:34:01
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ZjkBaseInfo extends DataEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id -
     */
    private String id;

    /**
     * name - 姓名
     */
    private String name;

    /**
     * email - 邮箱
     */
    private String email;

    /**
     * company_name - 机构名称
     */
    private String companyName;

    /**
     * company - 所属组织
     */
    private String company;

    /**
     * user_desc - 简介
     */
    private String userDesc;

    /**
     * zhicheng - 职称
     */
    private String zhicheng;

    /**
     * age_between - 年龄段
     */
    private String ageBetween;

    /**
     * age - 年龄
     */
    private String age;

    /**
     * csrq - 出生日期
     */
    private String csrq;

    /**
     * hyly_name - 行业领域名称
     */
    private String hylyName;

    /**
     * hyly - 行业领域
     */
    private String hyly;

    /**
     * dz - 居住地地址
     */
    private String dz;

    /**
     * byyx - 毕业院校
     */
    private String byyx;

    /**
     * sheng - 省
     */
    private String sheng;

    /**
     * shi - 市
     */
    private String shi;

    /**
     * xian - 县
     */
    private String xian;

    /**
     * je_count - 参与金额数量
     */
    private String jeCount;

    /**
     * zl_count - 专利数量
     */
    private String zlCount;

    /**
     * xm_count - 参与项目数量
     */
    private String xmCount;

    /**
     * jg_count - 参与机构数量
     */
    private String jgCount;

    /**
     * cg_count - 成果数量
     */
    private String cgCount;

    /**
     * jwd - 经纬度
     */
    private String jwd;

    /**
     * DATA_CODE - 数据编码
     */
    private String dataCode;

    /**
     * SYS_FLAG - 系统标识
     */
    private String sysFlag;

    /**
     * DATA_ORDER - 数据排序
     */
    private String dataOrder;

    /**
     * STATUS - 数据状态
     */
    private String status;

    /**
     * DEL_FLAG - 是否删除
     */
    private String delFlag;

    /**
     * CREATE_DATE - 创建日期
     */
    private String createDate;

    /**
     * CREATE_USER - 创建用户
     */
    private String createUser;

    /**
     * CREATE_USER_NAME - 创建用户名称
     */
    private String createUserName;

    /**
     * UPDATE_DATE - 修改日期
     */
    private String updateDate;

    /**
     * UPDATE_USER - 修改用户
     */
    private String updateUser;

    /**
     * UPDATE_USER_NAME - 修改用户名称
     */
    private String updateUserName;

    /**
     * bak1 - 是否指派
     */
    private String bak1;

    /**
     * bak2 -
     */
    private String bak2;

    /**
     * bak3 -
     */
    private String bak3;

    /**
     * bak4 -
     */
    private String bak4;

    /**
     * bak5 -
     */
    private String bak5;

    /**
     * bak6 -
     */
    private String bak6;

    /**
     * user_id - 用户ID
     */
    private String userId;

    /**
     * dh - 电话
     */
    private String dh;

    /**
     * zc - 职称
     */
    private String zc;


    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompany() {
        return this.company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getUserDesc() {
        return this.userDesc;
    }

    public void setUserDesc(String userDesc) {
        this.userDesc = userDesc;
    }

    public String getZhicheng() {
        return this.zhicheng;
    }

    public void setZhicheng(String zhicheng) {
        this.zhicheng = zhicheng;
    }

    public String getAgeBetween() {
        return this.ageBetween;
    }

    public void setAgeBetween(String ageBetween) {
        this.ageBetween = ageBetween;
    }

    public String getAge() {
        return this.age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCsrq() {
        return this.csrq;
    }

    public void setCsrq(String csrq) {
        this.csrq = csrq;
    }

    public String getHylyName() {
        return this.hylyName;
    }

    public void setHylyName(String hylyName) {
        this.hylyName = hylyName;
    }

    public String getHyly() {
        return this.hyly;
    }

    public void setHyly(String hyly) {
        this.hyly = hyly;
    }

    public String getDz() {
        return this.dz;
    }

    public void setDz(String dz) {
        this.dz = dz;
    }

    public String getByyx() {
        return this.byyx;
    }

    public void setByyx(String byyx) {
        this.byyx = byyx;
    }

    public String getSheng() {
        return this.sheng;
    }

    public void setSheng(String sheng) {
        this.sheng = sheng;
    }

    public String getShi() {
        return this.shi;
    }

    public void setShi(String shi) {
        this.shi = shi;
    }

    public String getXian() {
        return this.xian;
    }

    public void setXian(String xian) {
        this.xian = xian;
    }

    public String getJeCount() {
        return this.jeCount;
    }

    public void setJeCount(String jeCount) {
        this.jeCount = jeCount;
    }

    public String getZlCount() {
        return this.zlCount;
    }

    public void setZlCount(String zlCount) {
        this.zlCount = zlCount;
    }

    public String getXmCount() {
        return this.xmCount;
    }

    public void setXmCount(String xmCount) {
        this.xmCount = xmCount;
    }

    public String getJgCount() {
        return this.jgCount;
    }

    public void setJgCount(String jgCount) {
        this.jgCount = jgCount;
    }

    public String getCgCount() {
        return this.cgCount;
    }

    public void setCgCount(String cgCount) {
        this.cgCount = cgCount;
    }

    public String getJwd() {
        return this.jwd;
    }

    public void setJwd(String jwd) {
        this.jwd = jwd;
    }

    public String getDataCode() {
        return this.dataCode;
    }

    public void setDataCode(String dataCode) {
        this.dataCode = dataCode;
    }

    public String getSysFlag() {
        return this.sysFlag;
    }

    public void setSysFlag(String sysFlag) {
        this.sysFlag = sysFlag;
    }

    public String getDataOrder() {
        return this.dataOrder;
    }

    public void setDataOrder(String dataOrder) {
        this.dataOrder = dataOrder;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDelFlag() {
        return this.delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getCreateUser() {
        return this.createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getCreateUserName() {
        return this.createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    public String getUpdateDate() {
        return this.updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateUser() {
        return this.updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public String getUpdateUserName() {
        return this.updateUserName;
    }

    public void setUpdateUserName(String updateUserName) {
        this.updateUserName = updateUserName;
    }

    public String getBak1() {
        return this.bak1;
    }

    public void setBak1(String bak1) {
        this.bak1 = bak1;
    }

    public String getBak2() {
        return this.bak2;
    }

    public void setBak2(String bak2) {
        this.bak2 = bak2;
    }

    public String getBak3() {
        return this.bak3;
    }

    public void setBak3(String bak3) {
        this.bak3 = bak3;
    }

    public String getBak4() {
        return this.bak4;
    }

    public void setBak4(String bak4) {
        this.bak4 = bak4;
    }

    public String getBak5() {
        return this.bak5;
    }

    public void setBak5(String bak5) {
        this.bak5 = bak5;
    }

    public String getBak6() {
        return this.bak6;
    }

    public void setBak6(String bak6) {
        this.bak6 = bak6;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDh() {
        return this.dh;
    }

    public void setDh(String dh) {
        this.dh = dh;
    }

    public String getZc() {
        return this.zc;
    }

    public void setZc(String zc) {
        this.zc = zc;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }

        ZjkBaseInfo other = (ZjkBaseInfo) that;


        return
                (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId())) &&

                        (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName())) &&

                        (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail())) &&

                        (this.getCompanyName() == null ? other.getCompanyName() == null : this.getCompanyName().equals(other.getCompanyName())) &&

                        (this.getCompany() == null ? other.getCompany() == null : this.getCompany().equals(other.getCompany())) &&

                        (this.getUserDesc() == null ? other.getUserDesc() == null : this.getUserDesc().equals(other.getUserDesc())) &&

                        (this.getZhicheng() == null ? other.getZhicheng() == null : this.getZhicheng().equals(other.getZhicheng())) &&

                        (this.getAgeBetween() == null ? other.getAgeBetween() == null : this.getAgeBetween().equals(other.getAgeBetween())) &&

                        (this.getAge() == null ? other.getAge() == null : this.getAge().equals(other.getAge())) &&

                        (this.getCsrq() == null ? other.getCsrq() == null : this.getCsrq().equals(other.getCsrq())) &&

                        (this.getHylyName() == null ? other.getHylyName() == null : this.getHylyName().equals(other.getHylyName())) &&

                        (this.getHyly() == null ? other.getHyly() == null : this.getHyly().equals(other.getHyly())) &&

                        (this.getDz() == null ? other.getDz() == null : this.getDz().equals(other.getDz())) &&

                        (this.getByyx() == null ? other.getByyx() == null : this.getByyx().equals(other.getByyx())) &&

                        (this.getSheng() == null ? other.getSheng() == null : this.getSheng().equals(other.getSheng())) &&

                        (this.getShi() == null ? other.getShi() == null : this.getShi().equals(other.getShi())) &&

                        (this.getXian() == null ? other.getXian() == null : this.getXian().equals(other.getXian())) &&

                        (this.getJeCount() == null ? other.getJeCount() == null : this.getJeCount().equals(other.getJeCount())) &&

                        (this.getZlCount() == null ? other.getZlCount() == null : this.getZlCount().equals(other.getZlCount())) &&

                        (this.getXmCount() == null ? other.getXmCount() == null : this.getXmCount().equals(other.getXmCount())) &&

                        (this.getJgCount() == null ? other.getJgCount() == null : this.getJgCount().equals(other.getJgCount())) &&

                        (this.getCgCount() == null ? other.getCgCount() == null : this.getCgCount().equals(other.getCgCount())) &&

                        (this.getJwd() == null ? other.getJwd() == null : this.getJwd().equals(other.getJwd())) &&

                        (this.getDataCode() == null ? other.getDataCode() == null : this.getDataCode().equals(other.getDataCode())) &&

                        (this.getSysFlag() == null ? other.getSysFlag() == null : this.getSysFlag().equals(other.getSysFlag())) &&

                        (this.getDataOrder() == null ? other.getDataOrder() == null : this.getDataOrder().equals(other.getDataOrder())) &&

                        (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus())) &&

                        (this.getDelFlag() == null ? other.getDelFlag() == null : this.getDelFlag().equals(other.getDelFlag())) &&

                        (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate())) &&

                        (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser())) &&

                        (this.getCreateUserName() == null ? other.getCreateUserName() == null : this.getCreateUserName().equals(other.getCreateUserName())) &&

                        (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate())) &&

                        (this.getUpdateUser() == null ? other.getUpdateUser() == null : this.getUpdateUser().equals(other.getUpdateUser())) &&

                        (this.getUpdateUserName() == null ? other.getUpdateUserName() == null : this.getUpdateUserName().equals(other.getUpdateUserName())) &&

                        (this.getBak1() == null ? other.getBak1() == null : this.getBak1().equals(other.getBak1())) &&

                        (this.getBak2() == null ? other.getBak2() == null : this.getBak2().equals(other.getBak2())) &&

                        (this.getBak3() == null ? other.getBak3() == null : this.getBak3().equals(other.getBak3())) &&

                        (this.getBak4() == null ? other.getBak4() == null : this.getBak4().equals(other.getBak4())) &&

                        (this.getBak5() == null ? other.getBak5() == null : this.getBak5().equals(other.getBak5())) &&

                        (this.getBak6() == null ? other.getBak6() == null : this.getBak6().equals(other.getBak6())) &&

                        (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId())) &&

                        (this.getDh() == null ? other.getDh() == null : this.getDh().equals(other.getDh())) &&

                        (this.getZc() == null ? other.getZc() == null : this.getZc().equals(other.getZc()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getCompanyName() == null) ? 0 : getCompanyName().hashCode());
        result = prime * result + ((getCompany() == null) ? 0 : getCompany().hashCode());
        result = prime * result + ((getUserDesc() == null) ? 0 : getUserDesc().hashCode());
        result = prime * result + ((getZhicheng() == null) ? 0 : getZhicheng().hashCode());
        result = prime * result + ((getAgeBetween() == null) ? 0 : getAgeBetween().hashCode());
        result = prime * result + ((getAge() == null) ? 0 : getAge().hashCode());
        result = prime * result + ((getCsrq() == null) ? 0 : getCsrq().hashCode());
        result = prime * result + ((getHylyName() == null) ? 0 : getHylyName().hashCode());
        result = prime * result + ((getHyly() == null) ? 0 : getHyly().hashCode());
        result = prime * result + ((getDz() == null) ? 0 : getDz().hashCode());
        result = prime * result + ((getByyx() == null) ? 0 : getByyx().hashCode());
        result = prime * result + ((getSheng() == null) ? 0 : getSheng().hashCode());
        result = prime * result + ((getShi() == null) ? 0 : getShi().hashCode());
        result = prime * result + ((getXian() == null) ? 0 : getXian().hashCode());
        result = prime * result + ((getJeCount() == null) ? 0 : getJeCount().hashCode());
        result = prime * result + ((getZlCount() == null) ? 0 : getZlCount().hashCode());
        result = prime * result + ((getXmCount() == null) ? 0 : getXmCount().hashCode());
        result = prime * result + ((getJgCount() == null) ? 0 : getJgCount().hashCode());
        result = prime * result + ((getCgCount() == null) ? 0 : getCgCount().hashCode());
        result = prime * result + ((getJwd() == null) ? 0 : getJwd().hashCode());
        result = prime * result + ((getDataCode() == null) ? 0 : getDataCode().hashCode());
        result = prime * result + ((getSysFlag() == null) ? 0 : getSysFlag().hashCode());
        result = prime * result + ((getDataOrder() == null) ? 0 : getDataOrder().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getDelFlag() == null) ? 0 : getDelFlag().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getCreateUserName() == null) ? 0 : getCreateUserName().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        result = prime * result + ((getUpdateUser() == null) ? 0 : getUpdateUser().hashCode());
        result = prime * result + ((getUpdateUserName() == null) ? 0 : getUpdateUserName().hashCode());
        result = prime * result + ((getBak1() == null) ? 0 : getBak1().hashCode());
        result = prime * result + ((getBak2() == null) ? 0 : getBak2().hashCode());
        result = prime * result + ((getBak3() == null) ? 0 : getBak3().hashCode());
        result = prime * result + ((getBak4() == null) ? 0 : getBak4().hashCode());
        result = prime * result + ((getBak5() == null) ? 0 : getBak5().hashCode());
        result = prime * result + ((getBak6() == null) ? 0 : getBak6().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getDh() == null) ? 0 : getDh().hashCode());
        result = prime * result + ((getZc() == null) ? 0 : getZc().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", email=").append(email);
        sb.append(", companyName=").append(companyName);
        sb.append(", company=").append(company);
        sb.append(", userDesc=").append(userDesc);
        sb.append(", zhicheng=").append(zhicheng);
        sb.append(", ageBetween=").append(ageBetween);
        sb.append(", age=").append(age);
        sb.append(", csrq=").append(csrq);
        sb.append(", hylyName=").append(hylyName);
        sb.append(", hyly=").append(hyly);
        sb.append(", dz=").append(dz);
        sb.append(", byyx=").append(byyx);
        sb.append(", sheng=").append(sheng);
        sb.append(", shi=").append(shi);
        sb.append(", xian=").append(xian);
        sb.append(", jeCount=").append(jeCount);
        sb.append(", zlCount=").append(zlCount);
        sb.append(", xmCount=").append(xmCount);
        sb.append(", jgCount=").append(jgCount);
        sb.append(", cgCount=").append(cgCount);
        sb.append(", jwd=").append(jwd);
        sb.append(", dataCode=").append(dataCode);
        sb.append(", sysFlag=").append(sysFlag);
        sb.append(", dataOrder=").append(dataOrder);
        sb.append(", status=").append(status);
        sb.append(", delFlag=").append(delFlag);
        sb.append(", createDate=").append(createDate);
        sb.append(", createUser=").append(createUser);
        sb.append(", createUserName=").append(createUserName);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", updateUserName=").append(updateUserName);
        sb.append(", bak1=").append(bak1);
        sb.append(", bak2=").append(bak2);
        sb.append(", bak3=").append(bak3);
        sb.append(", bak4=").append(bak4);
        sb.append(", bak5=").append(bak5);
        sb.append(", bak6=").append(bak6);
        sb.append(", userId=").append(userId);
        sb.append(", dh=").append(dh);
        sb.append(", zc=").append(zc);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}