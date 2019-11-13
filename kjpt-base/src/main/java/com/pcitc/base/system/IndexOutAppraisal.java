package com.pcitc.base.system;

import com.pcitc.base.common.DataEntity;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * <p>实体类</p>
 * <p>Table: index_out_appraisal - </p>
 *
 * @since 2019-05-24 09:47:07
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IndexOutAppraisal extends DataEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * data_id -
     */
    private String dataId;

    /**
     * cgid -
     */
    private String cgid;

    /**
     * nd -
     */
    private String nd;

    /**
     * cgmc -
     */
    private String cgmc;

    /**
     * sqjddw -
     */
    private String sqjddw;

    /**
     * sqdjh -
     */
    private String sqdjh;

    /**
     * startTime -
     */
    private String starttime;

    /**
     * endTime -
     */
    private String endtime;

    /**
     * cglx -
     */
    private String cglx;

    /**
     * zy -
     */
    private String zy;

    /**
     * jdh -
     */
    private String jdh;

    /**
     * issczs -
     */
    private String issczs;

    /**
     * sbzt -
     */
    private String sbzt;

    /**
     * jdjg -
     */
    private String jdjg;

    /**
     * create_date -
     */
    private String createDate;

    /**
     * create_user_id -
     */
    private String createUserId;

    /**
     * update_date -
     */
    private String updateDate;

    /**
     * update_user_id -
     */
    private String updateUserId;

    /**
     * status -
     */
    private String status;

    /**
     * remarks -
     */
    private String remarks;

    /**
     * hth - 合同号
     */
    private String hth;

    /**
     * xmmc - 项目名称
     */
    private String xmmc;

    /**
     * rwly - 任务来源
     */
    private String rwly;

    /**
     * define1 - 研究院简称
     */
    private String define1;

    /**
     * define2 -
     */
    private String define2;

    /**
     * define3 -
     */
    private String define3;

    /**
     * define4 -
     */
    private String define4;

    /**
     * define5 -
     */
    private String define5;

    /**
     * define6 -
     */
    private String define6;

    /**
     * tfm_type_id - 分类id
     */
    private String tfmTypeId;

    /**
     * type_code - 分类编码
     */
    private String typeCode;

    /**
     * type_name - 分类名称
     */
    private String typeName;

    /**
     * parent_id - 父节点id
     */
    private String parentId;

    /**
     * parent_code - 父节点编码
     */
    private String parentCode;

    /**
     * is_parent - 是否是父亲节点
     */
    private String isParent;

    /**
     * type_index - 检索辅助字段
     */
    private String typeIndex;

    public String getDataId() {
        return this.dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String getCgid() {
        return this.cgid;
    }

    public void setCgid(String cgid) {
        this.cgid = cgid;
    }

    public String getNd() {
        return this.nd;
    }

    public void setNd(String nd) {
        this.nd = nd;
    }

    public String getCgmc() {
        return this.cgmc;
    }

    public void setCgmc(String cgmc) {
        this.cgmc = cgmc;
    }

    public String getSqjddw() {
        return this.sqjddw;
    }

    public void setSqjddw(String sqjddw) {
        this.sqjddw = sqjddw;
    }

    public String getSqdjh() {
        return this.sqdjh;
    }

    public void setSqdjh(String sqdjh) {
        this.sqdjh = sqdjh;
    }

    public String getStarttime() {
        return this.starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return this.endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getCglx() {
        return this.cglx;
    }

    public void setCglx(String cglx) {
        this.cglx = cglx;
    }

    public String getZy() {
        return this.zy;
    }

    public void setZy(String zy) {
        this.zy = zy;
    }

    public String getJdh() {
        return this.jdh;
    }

    public void setJdh(String jdh) {
        this.jdh = jdh;
    }

    public String getIssczs() {
        return this.issczs;
    }

    public void setIssczs(String issczs) {
        this.issczs = issczs;
    }

    public String getSbzt() {
        return this.sbzt;
    }

    public void setSbzt(String sbzt) {
        this.sbzt = sbzt;
    }

    public String getJdjg() {
        return this.jdjg;
    }

    public void setJdjg(String jdjg) {
        this.jdjg = jdjg;
    }

    public String getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getCreateUserId() {
        return this.createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public String getUpdateDate() {
        return this.updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateUserId() {
        return this.updateUserId;
    }

    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemarks() {
        return this.remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getHth() {
        return this.hth;
    }

    public void setHth(String hth) {
        this.hth = hth;
    }

    public String getXmmc() {
        return this.xmmc;
    }

    public void setXmmc(String xmmc) {
        this.xmmc = xmmc;
    }

    public String getRwly() {
        return this.rwly;
    }

    public void setRwly(String rwly) {
        this.rwly = rwly;
    }

    public String getDefine1() {
        return this.define1;
    }

    public void setDefine1(String define1) {
        this.define1 = define1;
    }

    public String getDefine2() {
        return this.define2;
    }

    public void setDefine2(String define2) {
        this.define2 = define2;
    }

    public String getDefine3() {
        return this.define3;
    }

    public void setDefine3(String define3) {
        this.define3 = define3;
    }

    public String getDefine4() {
        return this.define4;
    }

    public void setDefine4(String define4) {
        this.define4 = define4;
    }

    public String getDefine5() {
        return this.define5;
    }

    public void setDefine5(String define5) {
        this.define5 = define5;
    }

    public String getDefine6() {
        return this.define6;
    }

    public void setDefine6(String define6) {
        this.define6 = define6;
    }

    public String getTfmTypeId() {
        return this.tfmTypeId;
    }

    public void setTfmTypeId(String tfmTypeId) {
        this.tfmTypeId = tfmTypeId;
    }

    public String getTypeCode() {
        return this.typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getTypeName() {
        return this.typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getParentId() {
        return this.parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getParentCode() {
        return this.parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getIsParent() {
        return this.isParent;
    }

    public void setIsParent(String isParent) {
        this.isParent = isParent;
    }

    public String getTypeIndex() {
        return this.typeIndex;
    }

    public void setTypeIndex(String typeIndex) {
        this.typeIndex = typeIndex;
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

        IndexOutAppraisal other = (IndexOutAppraisal) that;

        return
                (this.getDataId() == null ? other.getDataId() == null : this.getDataId().equals(other.getDataId())) &&

                        (this.getCgid() == null ? other.getCgid() == null : this.getCgid().equals(other.getCgid())) &&

                        (this.getNd() == null ? other.getNd() == null : this.getNd().equals(other.getNd())) &&

                        (this.getCgmc() == null ? other.getCgmc() == null : this.getCgmc().equals(other.getCgmc())) &&

                        (this.getSqjddw() == null ? other.getSqjddw() == null : this.getSqjddw().equals(other.getSqjddw())) &&

                        (this.getSqdjh() == null ? other.getSqdjh() == null : this.getSqdjh().equals(other.getSqdjh())) &&

                        (this.getStarttime() == null ? other.getStarttime() == null : this.getStarttime().equals(other.getStarttime())) &&

                        (this.getEndtime() == null ? other.getEndtime() == null : this.getEndtime().equals(other.getEndtime())) &&

                        (this.getCglx() == null ? other.getCglx() == null : this.getCglx().equals(other.getCglx())) &&

                        (this.getZy() == null ? other.getZy() == null : this.getZy().equals(other.getZy())) &&

                        (this.getJdh() == null ? other.getJdh() == null : this.getJdh().equals(other.getJdh())) &&

                        (this.getIssczs() == null ? other.getIssczs() == null : this.getIssczs().equals(other.getIssczs())) &&

                        (this.getSbzt() == null ? other.getSbzt() == null : this.getSbzt().equals(other.getSbzt())) &&

                        (this.getJdjg() == null ? other.getJdjg() == null : this.getJdjg().equals(other.getJdjg())) &&

                        (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate())) &&

                        (this.getCreateUserId() == null ? other.getCreateUserId() == null : this.getCreateUserId().equals(other.getCreateUserId())) &&

                        (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate())) &&

                        (this.getUpdateUserId() == null ? other.getUpdateUserId() == null : this.getUpdateUserId().equals(other.getUpdateUserId())) &&

                        (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus())) &&

                        (this.getRemarks() == null ? other.getRemarks() == null : this.getRemarks().equals(other.getRemarks())) &&

                        (this.getHth() == null ? other.getHth() == null : this.getHth().equals(other.getHth())) &&

                        (this.getXmmc() == null ? other.getXmmc() == null : this.getXmmc().equals(other.getXmmc())) &&

                        (this.getRwly() == null ? other.getRwly() == null : this.getRwly().equals(other.getRwly())) &&

                        (this.getDefine1() == null ? other.getDefine1() == null : this.getDefine1().equals(other.getDefine1())) &&

                        (this.getDefine2() == null ? other.getDefine2() == null : this.getDefine2().equals(other.getDefine2())) &&

                        (this.getDefine3() == null ? other.getDefine3() == null : this.getDefine3().equals(other.getDefine3())) &&

                        (this.getDefine4() == null ? other.getDefine4() == null : this.getDefine4().equals(other.getDefine4())) &&

                        (this.getDefine5() == null ? other.getDefine5() == null : this.getDefine5().equals(other.getDefine5())) &&

                        (this.getDefine6() == null ? other.getDefine6() == null : this.getDefine6().equals(other.getDefine6())) &&

                        (this.getTfmTypeId() == null ? other.getTfmTypeId() == null : this.getTfmTypeId().equals(other.getTfmTypeId())) &&

                        (this.getTypeCode() == null ? other.getTypeCode() == null : this.getTypeCode().equals(other.getTypeCode())) &&

                        (this.getTypeName() == null ? other.getTypeName() == null : this.getTypeName().equals(other.getTypeName())) &&

                        (this.getParentId() == null ? other.getParentId() == null : this.getParentId().equals(other.getParentId())) &&

                        (this.getParentCode() == null ? other.getParentCode() == null : this.getParentCode().equals(other.getParentCode())) &&

                        (this.getIsParent() == null ? other.getIsParent() == null : this.getIsParent().equals(other.getIsParent())) &&

                        (this.getTypeIndex() == null ? other.getTypeIndex() == null : this.getTypeIndex().equals(other.getTypeIndex()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDataId() == null) ? 0 : getDataId().hashCode());
        result = prime * result + ((getCgid() == null) ? 0 : getCgid().hashCode());
        result = prime * result + ((getNd() == null) ? 0 : getNd().hashCode());
        result = prime * result + ((getCgmc() == null) ? 0 : getCgmc().hashCode());
        result = prime * result + ((getSqjddw() == null) ? 0 : getSqjddw().hashCode());
        result = prime * result + ((getSqdjh() == null) ? 0 : getSqdjh().hashCode());
        result = prime * result + ((getStarttime() == null) ? 0 : getStarttime().hashCode());
        result = prime * result + ((getEndtime() == null) ? 0 : getEndtime().hashCode());
        result = prime * result + ((getCglx() == null) ? 0 : getCglx().hashCode());
        result = prime * result + ((getZy() == null) ? 0 : getZy().hashCode());
        result = prime * result + ((getJdh() == null) ? 0 : getJdh().hashCode());
        result = prime * result + ((getIssczs() == null) ? 0 : getIssczs().hashCode());
        result = prime * result + ((getSbzt() == null) ? 0 : getSbzt().hashCode());
        result = prime * result + ((getJdjg() == null) ? 0 : getJdjg().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getCreateUserId() == null) ? 0 : getCreateUserId().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        result = prime * result + ((getUpdateUserId() == null) ? 0 : getUpdateUserId().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getRemarks() == null) ? 0 : getRemarks().hashCode());
        result = prime * result + ((getHth() == null) ? 0 : getHth().hashCode());
        result = prime * result + ((getXmmc() == null) ? 0 : getXmmc().hashCode());
        result = prime * result + ((getRwly() == null) ? 0 : getRwly().hashCode());
        result = prime * result + ((getDefine1() == null) ? 0 : getDefine1().hashCode());
        result = prime * result + ((getDefine2() == null) ? 0 : getDefine2().hashCode());
        result = prime * result + ((getDefine3() == null) ? 0 : getDefine3().hashCode());
        result = prime * result + ((getDefine4() == null) ? 0 : getDefine4().hashCode());
        result = prime * result + ((getDefine5() == null) ? 0 : getDefine5().hashCode());
        result = prime * result + ((getDefine6() == null) ? 0 : getDefine6().hashCode());
        result = prime * result + ((getTfmTypeId() == null) ? 0 : getTfmTypeId().hashCode());
        result = prime * result + ((getTypeCode() == null) ? 0 : getTypeCode().hashCode());
        result = prime * result + ((getTypeName() == null) ? 0 : getTypeName().hashCode());
        result = prime * result + ((getParentId() == null) ? 0 : getParentId().hashCode());
        result = prime * result + ((getParentCode() == null) ? 0 : getParentCode().hashCode());
        result = prime * result + ((getIsParent() == null) ? 0 : getIsParent().hashCode());
        result = prime * result + ((getTypeIndex() == null) ? 0 : getTypeIndex().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", dataId=").append(dataId);
        sb.append(", cgid=").append(cgid);
        sb.append(", nd=").append(nd);
        sb.append(", cgmc=").append(cgmc);
        sb.append(", sqjddw=").append(sqjddw);
        sb.append(", sqdjh=").append(sqdjh);
        sb.append(", starttime=").append(starttime);
        sb.append(", endtime=").append(endtime);
        sb.append(", cglx=").append(cglx);
        sb.append(", zy=").append(zy);
        sb.append(", jdh=").append(jdh);
        sb.append(", issczs=").append(issczs);
        sb.append(", sbzt=").append(sbzt);
        sb.append(", jdjg=").append(jdjg);
        sb.append(", createDate=").append(createDate);
        sb.append(", createUserId=").append(createUserId);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", updateUserId=").append(updateUserId);
        sb.append(", status=").append(status);
        sb.append(", remarks=").append(remarks);
        sb.append(", hth=").append(hth);
        sb.append(", xmmc=").append(xmmc);
        sb.append(", rwly=").append(rwly);
        sb.append(", define1=").append(define1);
        sb.append(", define2=").append(define2);
        sb.append(", define3=").append(define3);
        sb.append(", define4=").append(define4);
        sb.append(", define5=").append(define5);
        sb.append(", define6=").append(define6);
        sb.append(", tfmTypeId=").append(tfmTypeId);
        sb.append(", typeCode=").append(typeCode);
        sb.append(", typeName=").append(typeName);
        sb.append(", parentId=").append(parentId);
        sb.append(", parentCode=").append(parentCode);
        sb.append(", isParent=").append(isParent);
        sb.append(", typeIndex=").append(typeIndex);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}