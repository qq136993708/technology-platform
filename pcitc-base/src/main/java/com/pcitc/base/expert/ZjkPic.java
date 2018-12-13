package com.pcitc.base.expert;

import com.pcitc.base.common.DataEntity;


import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * <p>实体类</p>
 * <p>Table: zjk_pic - </p>
 *
 * @since 2018-12-12 02:58:24
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ZjkPic extends DataEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id -
     */
    private String id;

    /**
     * sql_sql -
     */
    private String sqlSql;

    /**
     * echar_type -
     */
    private String echarType;

    /**
     * x -
     */
    private String x;

    /**
     * y -
     */
    private String y;

    /**
     * is_dz - 0:是,1否
     */
    private String isDz;

    /**
     * title -
     */
    private String title;

    /**
     * sub_title -
     */
    private String subTitle;

    /**
     * call_back_class -
     */
    private String callBackClass;

    /**
     * call_back_js -
     */
    private String callBackJs;

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


    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSqlSql() {
        return this.sqlSql;
    }

    public void setSqlSql(String sqlSql) {
        this.sqlSql = sqlSql;
    }

    public String getEcharType() {
        return this.echarType;
    }

    public void setEcharType(String echarType) {
        this.echarType = echarType;
    }

    public String getX() {
        return this.x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return this.y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public String getIsDz() {
        return this.isDz;
    }

    public void setIsDz(String isDz) {
        this.isDz = isDz;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return this.subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getCallBackClass() {
        return this.callBackClass;
    }

    public void setCallBackClass(String callBackClass) {
        this.callBackClass = callBackClass;
    }

    public String getCallBackJs() {
        return this.callBackJs;
    }

    public void setCallBackJs(String callBackJs) {
        this.callBackJs = callBackJs;
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

        ZjkPic other = (ZjkPic) that;


        return
                (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId())) &&

                        (this.getSqlSql() == null ? other.getSqlSql() == null : this.getSqlSql().equals(other.getSqlSql())) &&

                        (this.getEcharType() == null ? other.getEcharType() == null : this.getEcharType().equals(other.getEcharType())) &&

                        (this.getX() == null ? other.getX() == null : this.getX().equals(other.getX())) &&

                        (this.getY() == null ? other.getY() == null : this.getY().equals(other.getY())) &&

                        (this.getIsDz() == null ? other.getIsDz() == null : this.getIsDz().equals(other.getIsDz())) &&

                        (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle())) &&

                        (this.getSubTitle() == null ? other.getSubTitle() == null : this.getSubTitle().equals(other.getSubTitle())) &&

                        (this.getCallBackClass() == null ? other.getCallBackClass() == null : this.getCallBackClass().equals(other.getCallBackClass())) &&

                        (this.getCallBackJs() == null ? other.getCallBackJs() == null : this.getCallBackJs().equals(other.getCallBackJs())) &&

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

                        (this.getBak6() == null ? other.getBak6() == null : this.getBak6().equals(other.getBak6()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSqlSql() == null) ? 0 : getSqlSql().hashCode());
        result = prime * result + ((getEcharType() == null) ? 0 : getEcharType().hashCode());
        result = prime * result + ((getX() == null) ? 0 : getX().hashCode());
        result = prime * result + ((getY() == null) ? 0 : getY().hashCode());
        result = prime * result + ((getIsDz() == null) ? 0 : getIsDz().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getSubTitle() == null) ? 0 : getSubTitle().hashCode());
        result = prime * result + ((getCallBackClass() == null) ? 0 : getCallBackClass().hashCode());
        result = prime * result + ((getCallBackJs() == null) ? 0 : getCallBackJs().hashCode());
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
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", sqlSql=").append(sqlSql);
        sb.append(", echarType=").append(echarType);
        sb.append(", x=").append(x);
        sb.append(", y=").append(y);
        sb.append(", isDz=").append(isDz);
        sb.append(", title=").append(title);
        sb.append(", subTitle=").append(subTitle);
        sb.append(", callBackClass=").append(callBackClass);
        sb.append(", callBackJs=").append(callBackJs);
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
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}