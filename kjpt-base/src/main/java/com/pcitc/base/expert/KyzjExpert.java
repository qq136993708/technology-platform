package com.pcitc.base.expert;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

/***
 * @Author xiaoh
 * @Description 科研专家维护
 * @Date 2020/6/2 16:29
 * @param null
 * @return
 **/
public class KyzjExpert {
    private String id="";

    /**
     * 删除状态（0未删除，1删除）
     */
    private String deleted="";
    private String deletedStr;


    /**
     * 数量
     */
    private int num;

    /**
     * 科研专家类型
     */
    private String expertType="";

    private String expertTypeStr = "";

    /**
     * 年份
     */
    private String yearStr="";

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 创建人
     */
    private String createUser="";

    /**
     * 修改时间
     */
    private Date updateDate;

    /**
     * 修改人
     */
    private String updateUser="";

    /**
     * 创建人所在单位
     */
    private String createUnitId;

    private String createUnitName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    public String getDeletedStr() {
        return deletedStr;
    }

    public void setDeletedStr(String deletedStr) {
        this.deletedStr = deletedStr;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getExpertType() {
        return expertType;
    }

    public void setExpertType(String expertType) {
        this.expertType = expertType;
    }

    public String getExpertTypeStr() {
        return expertTypeStr;
    }

    public void setExpertTypeStr(String expertTypeStr) {
        this.expertTypeStr = expertTypeStr;
    }

    public String getYearStr() {
        return yearStr;
    }

    public void setYearStr(String yearStr) {
        this.yearStr = yearStr;
    }

    /*@JsonFormat(pattern = "yyyy-MM-dd")*/
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    /*@JsonFormat(pattern = "yyyy-MM-dd")*/
    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public String getCreateUnitId() {
        return createUnitId;
    }

    public void setCreateUnitId(String createUnitId) {
        this.createUnitId = createUnitId;
    }

    public String getCreateUnitName() {
        return createUnitName;
    }

    public void setCreateUnitName(String createUnitName) {
        this.createUnitName = createUnitName;
    }
}