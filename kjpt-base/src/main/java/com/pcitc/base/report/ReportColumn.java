package com.pcitc.base.report;

import com.pcitc.base.common.DataEntity;


import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>实体类</p>
 * <p>Table: report_column - 报表字段配置信息</p>
 *
 * @since 2018-08-03 10:29:19
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReportColumn extends DataEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id -
     */
    private String id;

    /**
     * report_config_id - 关联报表配置ID
     */
    private String reportConfigId;

    /**
     * field - field
     */
    private String field;

    /**
     * title - title
     */
    private String title;

    /**
     * width - width
     */
    private String width;

    /**
     * minWidth -
     */
    private String minwidth;

    /**
     * type -
     */
    private String type;

    /**
     * sort -
     */
    private String sort;

    /**
     * unresize -
     */
    private String unresize;

    /**
     * edit -
     */
    private String edit;

    /**
     * event -
     */
    private String event;

    /**
     * style -
     */
    private String style;

    /**
     * align - 位置
     */
    private String align;

    /**
     * colspan -
     */
    private String colspan;

    /**
     * rowspan -
     */
    private String rowspan;

    /**
     * templet -
     */
    private String templet;

    /**
     * toolbar -
     */
    private String toolbar;

    /**
     * role - 角色
     */
    private String role;

    /**
     * sf_showlist - 是否默认显示列表
     */
    private String sfShowlist;

    /**
     * sf_x - 默认显示图表X轴
     */
    private String sfX;

    /**
     * sf_y - 是否显示图表Y轴
     */
    private String sfY;

    /**
     * sf_ajax - 是否选择
     */
    private String sfAjax;

    /**
     * stype - 条件或者指标类型
     */
    private String stype;

    /**
     * ssort - 排序
     */
    private String ssort;

    /**
     * sf_show - 是否显示
     */
    private String sfShow;

    /**
     * sf_del - 是否删除
     */
    private String sfDel;

    /**
     * sf_use - 是否启用停用
     */
    private String sfUse;

    /**
     * bak1 -
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
     * create_user - 创建人
     */
    private String createUser;

    /**
     * create_user_id - 创建人id
     */
    private String createUserId;

    /**
     * create_date - 创建时间
     */
    private String createDate;

    /**
     * status - 业务表单状态(1、生效；0、作废，默认1)
     */
    private String status;

    /**
     * update_date - 修改时间
     */
    private String updateDate;

    /**
     * update_user - 修改人
     */
    private String updateUser;

    /**
     * remarks - 业务表单说明/备注/注释
     */
    private String remarks;

    /**
     * audit_status - 审批状态(审批状态，0未审批、1审批通过、2审批中、3未通过)
     */
    private String auditStatus;

    /**
     * fileId - 文件ID集合
     */
    private String fileid;


    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReportConfigId() {
        return this.reportConfigId;
    }

    public void setReportConfigId(String reportConfigId) {
        this.reportConfigId = reportConfigId;
    }

    public String getField() {
        return this.field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWidth() {
        return this.width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getMinwidth() {
        return this.minwidth;
    }

    public void setMinwidth(String minwidth) {
        this.minwidth = minwidth;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSort() {
        return this.sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getUnresize() {
        return this.unresize;
    }

    public void setUnresize(String unresize) {
        this.unresize = unresize;
    }

    public String getEdit() {
        return this.edit;
    }

    public void setEdit(String edit) {
        this.edit = edit;
    }

    public String getEvent() {
        return this.event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getStyle() {
        return this.style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getAlign() {
        return this.align;
    }

    public void setAlign(String align) {
        this.align = align;
    }

    public String getColspan() {
        return this.colspan;
    }

    public void setColspan(String colspan) {
        this.colspan = colspan;
    }

    public String getRowspan() {
        return this.rowspan;
    }

    public void setRowspan(String rowspan) {
        this.rowspan = rowspan;
    }

    public String getTemplet() {
        return this.templet;
    }

    public void setTemplet(String templet) {
        this.templet = templet;
    }

    public String getToolbar() {
        return this.toolbar;
    }

    public void setToolbar(String toolbar) {
        this.toolbar = toolbar;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSfShowlist() {
        return this.sfShowlist;
    }

    public void setSfShowlist(String sfShowlist) {
        this.sfShowlist = sfShowlist;
    }

    public String getSfX() {
        return this.sfX;
    }

    public void setSfX(String sfX) {
        this.sfX = sfX;
    }

    public String getSfY() {
        return this.sfY;
    }

    public void setSfY(String sfY) {
        this.sfY = sfY;
    }

    public String getSfAjax() {
        return this.sfAjax;
    }

    public void setSfAjax(String sfAjax) {
        this.sfAjax = sfAjax;
    }

    public String getStype() {
        return this.stype;
    }

    public void setStype(String stype) {
        this.stype = stype;
    }

    public String getSsort() {
        return this.ssort;
    }

    public void setSsort(String ssort) {
        this.ssort = ssort;
    }

    public String getSfShow() {
        return this.sfShow;
    }

    public void setSfShow(String sfShow) {
        this.sfShow = sfShow;
    }

    public String getSfDel() {
        return this.sfDel;
    }

    public void setSfDel(String sfDel) {
        this.sfDel = sfDel;
    }

    public String getSfUse() {
        return this.sfUse;
    }

    public void setSfUse(String sfUse) {
        this.sfUse = sfUse;
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

    public String getCreateUser() {
        return this.createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getCreateUserId() {
        return this.createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public String getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getRemarks() {
        return this.remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getAuditStatus() {
        return this.auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getFileid() {
        return this.fileid;
    }

    public void setFileid(String fileid) {
        this.fileid = fileid;
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

        ReportColumn other = (ReportColumn) that;


        return
                (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId())) &&

                        (this.getReportConfigId() == null ? other.getReportConfigId() == null : this.getReportConfigId().equals(other.getReportConfigId())) &&

                        (this.getField() == null ? other.getField() == null : this.getField().equals(other.getField())) &&

                        (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle())) &&

                        (this.getWidth() == null ? other.getWidth() == null : this.getWidth().equals(other.getWidth())) &&

                        (this.getMinwidth() == null ? other.getMinwidth() == null : this.getMinwidth().equals(other.getMinwidth())) &&

                        (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType())) &&

                        (this.getSort() == null ? other.getSort() == null : this.getSort().equals(other.getSort())) &&

                        (this.getUnresize() == null ? other.getUnresize() == null : this.getUnresize().equals(other.getUnresize())) &&

                        (this.getEdit() == null ? other.getEdit() == null : this.getEdit().equals(other.getEdit())) &&

                        (this.getEvent() == null ? other.getEvent() == null : this.getEvent().equals(other.getEvent())) &&

                        (this.getStyle() == null ? other.getStyle() == null : this.getStyle().equals(other.getStyle())) &&

                        (this.getAlign() == null ? other.getAlign() == null : this.getAlign().equals(other.getAlign())) &&

                        (this.getColspan() == null ? other.getColspan() == null : this.getColspan().equals(other.getColspan())) &&

                        (this.getRowspan() == null ? other.getRowspan() == null : this.getRowspan().equals(other.getRowspan())) &&

                        (this.getTemplet() == null ? other.getTemplet() == null : this.getTemplet().equals(other.getTemplet())) &&

                        (this.getToolbar() == null ? other.getToolbar() == null : this.getToolbar().equals(other.getToolbar())) &&

                        (this.getRole() == null ? other.getRole() == null : this.getRole().equals(other.getRole())) &&

                        (this.getSfShowlist() == null ? other.getSfShowlist() == null : this.getSfShowlist().equals(other.getSfShowlist())) &&

                        (this.getSfX() == null ? other.getSfX() == null : this.getSfX().equals(other.getSfX())) &&

                        (this.getSfY() == null ? other.getSfY() == null : this.getSfY().equals(other.getSfY())) &&

                        (this.getSfAjax() == null ? other.getSfAjax() == null : this.getSfAjax().equals(other.getSfAjax())) &&

                        (this.getStype() == null ? other.getStype() == null : this.getStype().equals(other.getStype())) &&

                        (this.getSsort() == null ? other.getSsort() == null : this.getSsort().equals(other.getSsort())) &&

                        (this.getSfShow() == null ? other.getSfShow() == null : this.getSfShow().equals(other.getSfShow())) &&

                        (this.getSfDel() == null ? other.getSfDel() == null : this.getSfDel().equals(other.getSfDel())) &&

                        (this.getSfUse() == null ? other.getSfUse() == null : this.getSfUse().equals(other.getSfUse())) &&

                        (this.getBak1() == null ? other.getBak1() == null : this.getBak1().equals(other.getBak1())) &&

                        (this.getBak2() == null ? other.getBak2() == null : this.getBak2().equals(other.getBak2())) &&

                        (this.getBak3() == null ? other.getBak3() == null : this.getBak3().equals(other.getBak3())) &&

                        (this.getBak4() == null ? other.getBak4() == null : this.getBak4().equals(other.getBak4())) &&

                        (this.getBak5() == null ? other.getBak5() == null : this.getBak5().equals(other.getBak5())) &&

                        (this.getBak6() == null ? other.getBak6() == null : this.getBak6().equals(other.getBak6())) &&

                        (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser())) &&

                        (this.getCreateUserId() == null ? other.getCreateUserId() == null : this.getCreateUserId().equals(other.getCreateUserId())) &&

                        (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate())) &&

                        (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus())) &&

                        (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate())) &&

                        (this.getUpdateUser() == null ? other.getUpdateUser() == null : this.getUpdateUser().equals(other.getUpdateUser())) &&

                        (this.getRemarks() == null ? other.getRemarks() == null : this.getRemarks().equals(other.getRemarks())) &&

                        (this.getAuditStatus() == null ? other.getAuditStatus() == null : this.getAuditStatus().equals(other.getAuditStatus())) &&

                        (this.getFileid() == null ? other.getFileid() == null : this.getFileid().equals(other.getFileid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getReportConfigId() == null) ? 0 : getReportConfigId().hashCode());
        result = prime * result + ((getField() == null) ? 0 : getField().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getWidth() == null) ? 0 : getWidth().hashCode());
        result = prime * result + ((getMinwidth() == null) ? 0 : getMinwidth().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getSort() == null) ? 0 : getSort().hashCode());
        result = prime * result + ((getUnresize() == null) ? 0 : getUnresize().hashCode());
        result = prime * result + ((getEdit() == null) ? 0 : getEdit().hashCode());
        result = prime * result + ((getEvent() == null) ? 0 : getEvent().hashCode());
        result = prime * result + ((getStyle() == null) ? 0 : getStyle().hashCode());
        result = prime * result + ((getAlign() == null) ? 0 : getAlign().hashCode());
        result = prime * result + ((getColspan() == null) ? 0 : getColspan().hashCode());
        result = prime * result + ((getRowspan() == null) ? 0 : getRowspan().hashCode());
        result = prime * result + ((getTemplet() == null) ? 0 : getTemplet().hashCode());
        result = prime * result + ((getToolbar() == null) ? 0 : getToolbar().hashCode());
        result = prime * result + ((getRole() == null) ? 0 : getRole().hashCode());
        result = prime * result + ((getSfShowlist() == null) ? 0 : getSfShowlist().hashCode());
        result = prime * result + ((getSfX() == null) ? 0 : getSfX().hashCode());
        result = prime * result + ((getSfY() == null) ? 0 : getSfY().hashCode());
        result = prime * result + ((getSfAjax() == null) ? 0 : getSfAjax().hashCode());
        result = prime * result + ((getStype() == null) ? 0 : getStype().hashCode());
        result = prime * result + ((getSsort() == null) ? 0 : getSsort().hashCode());
        result = prime * result + ((getSfShow() == null) ? 0 : getSfShow().hashCode());
        result = prime * result + ((getSfDel() == null) ? 0 : getSfDel().hashCode());
        result = prime * result + ((getSfUse() == null) ? 0 : getSfUse().hashCode());
        result = prime * result + ((getBak1() == null) ? 0 : getBak1().hashCode());
        result = prime * result + ((getBak2() == null) ? 0 : getBak2().hashCode());
        result = prime * result + ((getBak3() == null) ? 0 : getBak3().hashCode());
        result = prime * result + ((getBak4() == null) ? 0 : getBak4().hashCode());
        result = prime * result + ((getBak5() == null) ? 0 : getBak5().hashCode());
        result = prime * result + ((getBak6() == null) ? 0 : getBak6().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getCreateUserId() == null) ? 0 : getCreateUserId().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        result = prime * result + ((getUpdateUser() == null) ? 0 : getUpdateUser().hashCode());
        result = prime * result + ((getRemarks() == null) ? 0 : getRemarks().hashCode());
        result = prime * result + ((getAuditStatus() == null) ? 0 : getAuditStatus().hashCode());
        result = prime * result + ((getFileid() == null) ? 0 : getFileid().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", reportConfigId=").append(reportConfigId);
        sb.append(", field=").append(field);
        sb.append(", title=").append(title);
        sb.append(", width=").append(width);
        sb.append(", minwidth=").append(minwidth);
        sb.append(", type=").append(type);
        sb.append(", sort=").append(sort);
        sb.append(", unresize=").append(unresize);
        sb.append(", edit=").append(edit);
        sb.append(", event=").append(event);
        sb.append(", style=").append(style);
        sb.append(", align=").append(align);
        sb.append(", colspan=").append(colspan);
        sb.append(", rowspan=").append(rowspan);
        sb.append(", templet=").append(templet);
        sb.append(", toolbar=").append(toolbar);
        sb.append(", role=").append(role);
        sb.append(", sfShowlist=").append(sfShowlist);
        sb.append(", sfX=").append(sfX);
        sb.append(", sfY=").append(sfY);
        sb.append(", sfAjax=").append(sfAjax);
        sb.append(", stype=").append(stype);
        sb.append(", ssort=").append(ssort);
        sb.append(", sfShow=").append(sfShow);
        sb.append(", sfDel=").append(sfDel);
        sb.append(", sfUse=").append(sfUse);
        sb.append(", bak1=").append(bak1);
        sb.append(", bak2=").append(bak2);
        sb.append(", bak3=").append(bak3);
        sb.append(", bak4=").append(bak4);
        sb.append(", bak5=").append(bak5);
        sb.append(", bak6=").append(bak6);
        sb.append(", createUser=").append(createUser);
        sb.append(", createUserId=").append(createUserId);
        sb.append(", createDate=").append(createDate);
        sb.append(", status=").append(status);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", remarks=").append(remarks);
        sb.append(", auditStatus=").append(auditStatus);
        sb.append(", fileid=").append(fileid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    /**
     * <p>实体类</p>
     * <p>Table: report_config - 报表配置</p>
     *
     * @since 2018-08-21 09:09:02
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class ReportConfig extends DataEntity implements Serializable {

        private static final long serialVersionUID = 1L;

        /**
         * id -
         */
        private String id;

        /**
         * name - 名称
         */
        private String name;

        /**
         * sf_y - 是否双Y轴
         */
        private String sfY;

        /**
         * pic_type - 图表类型选择
         */
        private String picType;

        /**
         * model_name - 模型名称
         */
        private String modelName;

        /**
         * model_index - 模型索引
         */
        private String modelIndex;

        /**
         * bak1 -
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
         * create_user - 创建人
         */
        private String createUser;

        /**
         * create_user_id - 创建人id
         */
        private String createUserId;

        /**
         * create_date - 创建时间
         */
        private String createDate;

        /**
         * status - 业务表单状态(1、生效；0、作废，默认1)
         */
        private String status;

        /**
         * update_date - 修改时间
         */
        private String updateDate;

        /**
         * update_user - 修改人
         */
        private String updateUser;

        /**
         * remarks - 业务表单说明/备注/注释
         */
        private String remarks;

        /**
         * audit_status - 审批状态(审批状态，0未审批、1审批通过、2审批中、3未通过)
         */
        private String auditStatus;


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

        public String getSfY() {
            return this.sfY;
        }

        public void setSfY(String sfY) {
            this.sfY = sfY;
        }

        public String getPicType() {
            return this.picType;
        }

        public void setPicType(String picType) {
            this.picType = picType;
        }

        public String getModelName() {
            return this.modelName;
        }

        public void setModelName(String modelName) {
            this.modelName = modelName;
        }

        public String getModelIndex() {
            return this.modelIndex;
        }

        public void setModelIndex(String modelIndex) {
            this.modelIndex = modelIndex;
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

        public String getCreateUser() {
            return this.createUser;
        }

        public void setCreateUser(String createUser) {
            this.createUser = createUser;
        }

        public String getCreateUserId() {
            return this.createUserId;
        }

        public void setCreateUserId(String createUserId) {
            this.createUserId = createUserId;
        }

        public String getCreateDate() {
            return this.createDate;
        }

        public void setCreateDate(String createDate) {
            this.createDate = createDate;
        }

        public String getStatus() {
            return this.status;
        }

        public void setStatus(String status) {
            this.status = status;
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

        public String getRemarks() {
            return this.remarks;
        }

        public void setRemarks(String remarks) {
            this.remarks = remarks;
        }

        public String getAuditStatus() {
            return this.auditStatus;
        }

        public void setAuditStatus(String auditStatus) {
            this.auditStatus = auditStatus;
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

            ReportConfig other = (ReportConfig) that;


            return
                    (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId())) &&

                            (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName())) &&

                            (this.getSfY() == null ? other.getSfY() == null : this.getSfY().equals(other.getSfY())) &&

                            (this.getPicType() == null ? other.getPicType() == null : this.getPicType().equals(other.getPicType())) &&

                            (this.getModelName() == null ? other.getModelName() == null : this.getModelName().equals(other.getModelName())) &&

                            (this.getModelIndex() == null ? other.getModelIndex() == null : this.getModelIndex().equals(other.getModelIndex())) &&

                            (this.getBak1() == null ? other.getBak1() == null : this.getBak1().equals(other.getBak1())) &&

                            (this.getBak2() == null ? other.getBak2() == null : this.getBak2().equals(other.getBak2())) &&

                            (this.getBak3() == null ? other.getBak3() == null : this.getBak3().equals(other.getBak3())) &&

                            (this.getBak4() == null ? other.getBak4() == null : this.getBak4().equals(other.getBak4())) &&

                            (this.getBak5() == null ? other.getBak5() == null : this.getBak5().equals(other.getBak5())) &&

                            (this.getBak6() == null ? other.getBak6() == null : this.getBak6().equals(other.getBak6())) &&

                            (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser())) &&

                            (this.getCreateUserId() == null ? other.getCreateUserId() == null : this.getCreateUserId().equals(other.getCreateUserId())) &&

                            (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate())) &&

                            (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus())) &&

                            (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate())) &&

                            (this.getUpdateUser() == null ? other.getUpdateUser() == null : this.getUpdateUser().equals(other.getUpdateUser())) &&

                            (this.getRemarks() == null ? other.getRemarks() == null : this.getRemarks().equals(other.getRemarks())) &&

                            (this.getAuditStatus() == null ? other.getAuditStatus() == null : this.getAuditStatus().equals(other.getAuditStatus()));
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
            result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
            result = prime * result + ((getSfY() == null) ? 0 : getSfY().hashCode());
            result = prime * result + ((getPicType() == null) ? 0 : getPicType().hashCode());
            result = prime * result + ((getModelName() == null) ? 0 : getModelName().hashCode());
            result = prime * result + ((getModelIndex() == null) ? 0 : getModelIndex().hashCode());
            result = prime * result + ((getBak1() == null) ? 0 : getBak1().hashCode());
            result = prime * result + ((getBak2() == null) ? 0 : getBak2().hashCode());
            result = prime * result + ((getBak3() == null) ? 0 : getBak3().hashCode());
            result = prime * result + ((getBak4() == null) ? 0 : getBak4().hashCode());
            result = prime * result + ((getBak5() == null) ? 0 : getBak5().hashCode());
            result = prime * result + ((getBak6() == null) ? 0 : getBak6().hashCode());
            result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
            result = prime * result + ((getCreateUserId() == null) ? 0 : getCreateUserId().hashCode());
            result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
            result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
            result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
            result = prime * result + ((getUpdateUser() == null) ? 0 : getUpdateUser().hashCode());
            result = prime * result + ((getRemarks() == null) ? 0 : getRemarks().hashCode());
            result = prime * result + ((getAuditStatus() == null) ? 0 : getAuditStatus().hashCode());
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
            sb.append(", sfY=").append(sfY);
            sb.append(", picType=").append(picType);
            sb.append(", modelName=").append(modelName);
            sb.append(", modelIndex=").append(modelIndex);
            sb.append(", bak1=").append(bak1);
            sb.append(", bak2=").append(bak2);
            sb.append(", bak3=").append(bak3);
            sb.append(", bak4=").append(bak4);
            sb.append(", bak5=").append(bak5);
            sb.append(", bak6=").append(bak6);
            sb.append(", createUser=").append(createUser);
            sb.append(", createUserId=").append(createUserId);
            sb.append(", createDate=").append(createDate);
            sb.append(", status=").append(status);
            sb.append(", updateDate=").append(updateDate);
            sb.append(", updateUser=").append(updateUser);
            sb.append(", remarks=").append(remarks);
            sb.append(", auditStatus=").append(auditStatus);
            sb.append(", serialVersionUID=").append(serialVersionUID);
            sb.append("]");
            return sb.toString();
        }
    }

    public static class ReportConfigExample {

        protected String orderByClause;

        protected boolean distinct;

        protected List<Criteria> oredCriteria;

        private Integer limit;

        private Integer offset;

        public ReportConfigExample() {
            oredCriteria = new ArrayList<Criteria>();
        }

        public void setOrderByClause(String orderByClause) {
            this.orderByClause = orderByClause;
        }

        public String getOrderByClause() {
            return orderByClause;
        }

        public void setDistinct(boolean distinct) {
            this.distinct = distinct;
        }

        public boolean isDistinct() {
            return distinct;
        }

        public List<Criteria> getOredCriteria() {
            return oredCriteria;
        }

        public void or(Criteria criteria) {
            oredCriteria.add(criteria);
        }

        public Criteria or() {
            Criteria criteria = createCriteriaInternal();
            oredCriteria.add(criteria);
            return criteria;
        }

        public Criteria createCriteria() {
            Criteria criteria = createCriteriaInternal();
            if (oredCriteria.size() == 0) {
                oredCriteria.add(criteria);
            }
            return criteria;
        }

        protected Criteria createCriteriaInternal() {
            Criteria criteria = new Criteria();
            return criteria;
        }

        public void clear() {
            oredCriteria.clear();
            orderByClause = null;
            distinct = false;
        }

        public void setLimit(Integer limit) {
            this.limit = limit;
        }

        public Integer getLimit() {
            return limit;
        }

        public void setOffset(Integer offset) {
            this.offset = offset;
        }

        public Integer getOffset() {
            return offset;
        }

        protected abstract static class GeneratedCriteria {
            protected List<Criterion> criteria;

            protected GeneratedCriteria() {
                super();
                criteria = new ArrayList<Criterion>();
            }

            public boolean isValid() {
                return criteria.size() > 0;
            }

            public List<Criterion> getAllCriteria() {
                return criteria;
            }

            public List<Criterion> getCriteria() {
                return criteria;
            }

            protected void addCriterion(String condition) {
                if (condition == null) {
                    throw new RuntimeException("Value for condition cannot be null");
                }
                criteria.add(new Criterion(condition));
            }

            protected void addCriterion(String condition, Object value, String property) {
                if (value == null) {
                    throw new RuntimeException("Value for " + property + " cannot be null");
                }
                criteria.add(new Criterion(condition, value));
            }

            protected void addCriterion(String condition, Object value1, Object value2, String property) {
                if (value1 == null || value2 == null) {
                    throw new RuntimeException("Between values for " + property + " cannot be null");
                }
                criteria.add(new Criterion(condition, value1, value2));
            }


            public Criteria andIdIsNull() {
                addCriterion("id is null");
                return (Criteria) this;
            }

            public Criteria andIdIsNotNull() {
                addCriterion("id is not null");
                return (Criteria) this;
            }

            public Criteria andIdEqualTo(String value) {
                addCriterion("id =", value, "id");
                return (Criteria) this;
            }

            public Criteria andIdNotEqualTo(String value) {
                addCriterion("id <>", value, "id");
                return (Criteria) this;
            }

            public Criteria andIdGreaterThan(String value) {
                addCriterion("id >", value, "id");
                return (Criteria) this;
            }

            public Criteria andIdGreaterThanOrEqualTo(String value) {
                addCriterion("id >=", value, "id");
                return (Criteria) this;
            }

            public Criteria andIdLessThan(String value) {
                addCriterion("id <", value, "id");
                return (Criteria) this;
            }

            public Criteria andIdLessThanOrEqualTo(String value) {
                addCriterion("id <=", value, "id");
                return (Criteria) this;
            }

            public Criteria andIdLike(String value) {
                addCriterion("id like", value, "id");
                return (Criteria) this;
            }

            public Criteria andIdNotLike(String value) {
                addCriterion("id not like", value, "id");
                return (Criteria) this;
            }

            public Criteria andIdIn(List<String> values) {
                addCriterion("id in", values, "id");
                return (Criteria) this;
            }

            public Criteria andIdNotIn(List<String> values) {
                addCriterion("id not in", values, "id");
                return (Criteria) this;
            }

            public Criteria andIdBetween(String value1, String value2) {
                addCriterion("id between", value1, value2, "id");
                return (Criteria) this;
            }

            public Criteria andIdNotBetween(String value1, String value2) {
                addCriterion("id not between", value1, value2, "id");
                return (Criteria) this;
            }

            public Criteria andNameIsNull() {
                addCriterion("name is null");
                return (Criteria) this;
            }

            public Criteria andNameIsNotNull() {
                addCriterion("name is not null");
                return (Criteria) this;
            }

            public Criteria andNameEqualTo(String value) {
                addCriterion("name =", value, "name");
                return (Criteria) this;
            }

            public Criteria andNameNotEqualTo(String value) {
                addCriterion("name <>", value, "name");
                return (Criteria) this;
            }

            public Criteria andNameGreaterThan(String value) {
                addCriterion("name >", value, "name");
                return (Criteria) this;
            }

            public Criteria andNameGreaterThanOrEqualTo(String value) {
                addCriterion("name >=", value, "name");
                return (Criteria) this;
            }

            public Criteria andNameLessThan(String value) {
                addCriterion("name <", value, "name");
                return (Criteria) this;
            }

            public Criteria andNameLessThanOrEqualTo(String value) {
                addCriterion("name <=", value, "name");
                return (Criteria) this;
            }

            public Criteria andNameLike(String value) {
                addCriterion("name like", value, "name");
                return (Criteria) this;
            }

            public Criteria andNameNotLike(String value) {
                addCriterion("name not like", value, "name");
                return (Criteria) this;
            }

            public Criteria andNameIn(List<String> values) {
                addCriterion("name in", values, "name");
                return (Criteria) this;
            }

            public Criteria andNameNotIn(List<String> values) {
                addCriterion("name not in", values, "name");
                return (Criteria) this;
            }

            public Criteria andNameBetween(String value1, String value2) {
                addCriterion("name between", value1, value2, "name");
                return (Criteria) this;
            }

            public Criteria andNameNotBetween(String value1, String value2) {
                addCriterion("name not between", value1, value2, "name");
                return (Criteria) this;
            }

            public Criteria andSfYIsNull() {
                addCriterion("sf_y is null");
                return (Criteria) this;
            }

            public Criteria andSfYIsNotNull() {
                addCriterion("sf_y is not null");
                return (Criteria) this;
            }

            public Criteria andSfYEqualTo(String value) {
                addCriterion("sf_y =", value, "sfY");
                return (Criteria) this;
            }

            public Criteria andSfYNotEqualTo(String value) {
                addCriterion("sf_y <>", value, "sfY");
                return (Criteria) this;
            }

            public Criteria andSfYGreaterThan(String value) {
                addCriterion("sf_y >", value, "sfY");
                return (Criteria) this;
            }

            public Criteria andSfYGreaterThanOrEqualTo(String value) {
                addCriterion("sf_y >=", value, "sfY");
                return (Criteria) this;
            }

            public Criteria andSfYLessThan(String value) {
                addCriterion("sf_y <", value, "sfY");
                return (Criteria) this;
            }

            public Criteria andSfYLessThanOrEqualTo(String value) {
                addCriterion("sf_y <=", value, "sfY");
                return (Criteria) this;
            }

            public Criteria andSfYLike(String value) {
                addCriterion("sf_y like", value, "sfY");
                return (Criteria) this;
            }

            public Criteria andSfYNotLike(String value) {
                addCriterion("sf_y not like", value, "sfY");
                return (Criteria) this;
            }

            public Criteria andSfYIn(List<String> values) {
                addCriterion("sf_y in", values, "sfY");
                return (Criteria) this;
            }

            public Criteria andSfYNotIn(List<String> values) {
                addCriterion("sf_y not in", values, "sfY");
                return (Criteria) this;
            }

            public Criteria andSfYBetween(String value1, String value2) {
                addCriterion("sf_y between", value1, value2, "sfY");
                return (Criteria) this;
            }

            public Criteria andSfYNotBetween(String value1, String value2) {
                addCriterion("sf_y not between", value1, value2, "sfY");
                return (Criteria) this;
            }

            public Criteria andPicTypeIsNull() {
                addCriterion("pic_type is null");
                return (Criteria) this;
            }

            public Criteria andPicTypeIsNotNull() {
                addCriterion("pic_type is not null");
                return (Criteria) this;
            }

            public Criteria andPicTypeEqualTo(String value) {
                addCriterion("pic_type =", value, "picType");
                return (Criteria) this;
            }

            public Criteria andPicTypeNotEqualTo(String value) {
                addCriterion("pic_type <>", value, "picType");
                return (Criteria) this;
            }

            public Criteria andPicTypeGreaterThan(String value) {
                addCriterion("pic_type >", value, "picType");
                return (Criteria) this;
            }

            public Criteria andPicTypeGreaterThanOrEqualTo(String value) {
                addCriterion("pic_type >=", value, "picType");
                return (Criteria) this;
            }

            public Criteria andPicTypeLessThan(String value) {
                addCriterion("pic_type <", value, "picType");
                return (Criteria) this;
            }

            public Criteria andPicTypeLessThanOrEqualTo(String value) {
                addCriterion("pic_type <=", value, "picType");
                return (Criteria) this;
            }

            public Criteria andPicTypeLike(String value) {
                addCriterion("pic_type like", value, "picType");
                return (Criteria) this;
            }

            public Criteria andPicTypeNotLike(String value) {
                addCriterion("pic_type not like", value, "picType");
                return (Criteria) this;
            }

            public Criteria andPicTypeIn(List<String> values) {
                addCriterion("pic_type in", values, "picType");
                return (Criteria) this;
            }

            public Criteria andPicTypeNotIn(List<String> values) {
                addCriterion("pic_type not in", values, "picType");
                return (Criteria) this;
            }

            public Criteria andPicTypeBetween(String value1, String value2) {
                addCriterion("pic_type between", value1, value2, "picType");
                return (Criteria) this;
            }

            public Criteria andPicTypeNotBetween(String value1, String value2) {
                addCriterion("pic_type not between", value1, value2, "picType");
                return (Criteria) this;
            }

            public Criteria andModelNameIsNull() {
                addCriterion("model_name is null");
                return (Criteria) this;
            }

            public Criteria andModelNameIsNotNull() {
                addCriterion("model_name is not null");
                return (Criteria) this;
            }

            public Criteria andModelNameEqualTo(String value) {
                addCriterion("model_name =", value, "modelName");
                return (Criteria) this;
            }

            public Criteria andModelNameNotEqualTo(String value) {
                addCriterion("model_name <>", value, "modelName");
                return (Criteria) this;
            }

            public Criteria andModelNameGreaterThan(String value) {
                addCriterion("model_name >", value, "modelName");
                return (Criteria) this;
            }

            public Criteria andModelNameGreaterThanOrEqualTo(String value) {
                addCriterion("model_name >=", value, "modelName");
                return (Criteria) this;
            }

            public Criteria andModelNameLessThan(String value) {
                addCriterion("model_name <", value, "modelName");
                return (Criteria) this;
            }

            public Criteria andModelNameLessThanOrEqualTo(String value) {
                addCriterion("model_name <=", value, "modelName");
                return (Criteria) this;
            }

            public Criteria andModelNameLike(String value) {
                addCriterion("model_name like", value, "modelName");
                return (Criteria) this;
            }

            public Criteria andModelNameNotLike(String value) {
                addCriterion("model_name not like", value, "modelName");
                return (Criteria) this;
            }

            public Criteria andModelNameIn(List<String> values) {
                addCriterion("model_name in", values, "modelName");
                return (Criteria) this;
            }

            public Criteria andModelNameNotIn(List<String> values) {
                addCriterion("model_name not in", values, "modelName");
                return (Criteria) this;
            }

            public Criteria andModelNameBetween(String value1, String value2) {
                addCriterion("model_name between", value1, value2, "modelName");
                return (Criteria) this;
            }

            public Criteria andModelNameNotBetween(String value1, String value2) {
                addCriterion("model_name not between", value1, value2, "modelName");
                return (Criteria) this;
            }

            public Criteria andModelIndexIsNull() {
                addCriterion("model_index is null");
                return (Criteria) this;
            }

            public Criteria andModelIndexIsNotNull() {
                addCriterion("model_index is not null");
                return (Criteria) this;
            }

            public Criteria andModelIndexEqualTo(String value) {
                addCriterion("model_index =", value, "modelIndex");
                return (Criteria) this;
            }

            public Criteria andModelIndexNotEqualTo(String value) {
                addCriterion("model_index <>", value, "modelIndex");
                return (Criteria) this;
            }

            public Criteria andModelIndexGreaterThan(String value) {
                addCriterion("model_index >", value, "modelIndex");
                return (Criteria) this;
            }

            public Criteria andModelIndexGreaterThanOrEqualTo(String value) {
                addCriterion("model_index >=", value, "modelIndex");
                return (Criteria) this;
            }

            public Criteria andModelIndexLessThan(String value) {
                addCriterion("model_index <", value, "modelIndex");
                return (Criteria) this;
            }

            public Criteria andModelIndexLessThanOrEqualTo(String value) {
                addCriterion("model_index <=", value, "modelIndex");
                return (Criteria) this;
            }

            public Criteria andModelIndexLike(String value) {
                addCriterion("model_index like", value, "modelIndex");
                return (Criteria) this;
            }

            public Criteria andModelIndexNotLike(String value) {
                addCriterion("model_index not like", value, "modelIndex");
                return (Criteria) this;
            }

            public Criteria andModelIndexIn(List<String> values) {
                addCriterion("model_index in", values, "modelIndex");
                return (Criteria) this;
            }

            public Criteria andModelIndexNotIn(List<String> values) {
                addCriterion("model_index not in", values, "modelIndex");
                return (Criteria) this;
            }

            public Criteria andModelIndexBetween(String value1, String value2) {
                addCriterion("model_index between", value1, value2, "modelIndex");
                return (Criteria) this;
            }

            public Criteria andModelIndexNotBetween(String value1, String value2) {
                addCriterion("model_index not between", value1, value2, "modelIndex");
                return (Criteria) this;
            }

            public Criteria andBak1IsNull() {
                addCriterion("bak1 is null");
                return (Criteria) this;
            }

            public Criteria andBak1IsNotNull() {
                addCriterion("bak1 is not null");
                return (Criteria) this;
            }

            public Criteria andBak1EqualTo(String value) {
                addCriterion("bak1 =", value, "bak1");
                return (Criteria) this;
            }

            public Criteria andBak1NotEqualTo(String value) {
                addCriterion("bak1 <>", value, "bak1");
                return (Criteria) this;
            }

            public Criteria andBak1GreaterThan(String value) {
                addCriterion("bak1 >", value, "bak1");
                return (Criteria) this;
            }

            public Criteria andBak1GreaterThanOrEqualTo(String value) {
                addCriterion("bak1 >=", value, "bak1");
                return (Criteria) this;
            }

            public Criteria andBak1LessThan(String value) {
                addCriterion("bak1 <", value, "bak1");
                return (Criteria) this;
            }

            public Criteria andBak1LessThanOrEqualTo(String value) {
                addCriterion("bak1 <=", value, "bak1");
                return (Criteria) this;
            }

            public Criteria andBak1Like(String value) {
                addCriterion("bak1 like", value, "bak1");
                return (Criteria) this;
            }

            public Criteria andBak1NotLike(String value) {
                addCriterion("bak1 not like", value, "bak1");
                return (Criteria) this;
            }

            public Criteria andBak1In(List<String> values) {
                addCriterion("bak1 in", values, "bak1");
                return (Criteria) this;
            }

            public Criteria andBak1NotIn(List<String> values) {
                addCriterion("bak1 not in", values, "bak1");
                return (Criteria) this;
            }

            public Criteria andBak1Between(String value1, String value2) {
                addCriterion("bak1 between", value1, value2, "bak1");
                return (Criteria) this;
            }

            public Criteria andBak1NotBetween(String value1, String value2) {
                addCriterion("bak1 not between", value1, value2, "bak1");
                return (Criteria) this;
            }

            public Criteria andBak2IsNull() {
                addCriterion("bak2 is null");
                return (Criteria) this;
            }

            public Criteria andBak2IsNotNull() {
                addCriterion("bak2 is not null");
                return (Criteria) this;
            }

            public Criteria andBak2EqualTo(String value) {
                addCriterion("bak2 =", value, "bak2");
                return (Criteria) this;
            }

            public Criteria andBak2NotEqualTo(String value) {
                addCriterion("bak2 <>", value, "bak2");
                return (Criteria) this;
            }

            public Criteria andBak2GreaterThan(String value) {
                addCriterion("bak2 >", value, "bak2");
                return (Criteria) this;
            }

            public Criteria andBak2GreaterThanOrEqualTo(String value) {
                addCriterion("bak2 >=", value, "bak2");
                return (Criteria) this;
            }

            public Criteria andBak2LessThan(String value) {
                addCriterion("bak2 <", value, "bak2");
                return (Criteria) this;
            }

            public Criteria andBak2LessThanOrEqualTo(String value) {
                addCriterion("bak2 <=", value, "bak2");
                return (Criteria) this;
            }

            public Criteria andBak2Like(String value) {
                addCriterion("bak2 like", value, "bak2");
                return (Criteria) this;
            }

            public Criteria andBak2NotLike(String value) {
                addCriterion("bak2 not like", value, "bak2");
                return (Criteria) this;
            }

            public Criteria andBak2In(List<String> values) {
                addCriterion("bak2 in", values, "bak2");
                return (Criteria) this;
            }

            public Criteria andBak2NotIn(List<String> values) {
                addCriterion("bak2 not in", values, "bak2");
                return (Criteria) this;
            }

            public Criteria andBak2Between(String value1, String value2) {
                addCriterion("bak2 between", value1, value2, "bak2");
                return (Criteria) this;
            }

            public Criteria andBak2NotBetween(String value1, String value2) {
                addCriterion("bak2 not between", value1, value2, "bak2");
                return (Criteria) this;
            }

            public Criteria andBak3IsNull() {
                addCriterion("bak3 is null");
                return (Criteria) this;
            }

            public Criteria andBak3IsNotNull() {
                addCriterion("bak3 is not null");
                return (Criteria) this;
            }

            public Criteria andBak3EqualTo(String value) {
                addCriterion("bak3 =", value, "bak3");
                return (Criteria) this;
            }

            public Criteria andBak3NotEqualTo(String value) {
                addCriterion("bak3 <>", value, "bak3");
                return (Criteria) this;
            }

            public Criteria andBak3GreaterThan(String value) {
                addCriterion("bak3 >", value, "bak3");
                return (Criteria) this;
            }

            public Criteria andBak3GreaterThanOrEqualTo(String value) {
                addCriterion("bak3 >=", value, "bak3");
                return (Criteria) this;
            }

            public Criteria andBak3LessThan(String value) {
                addCriterion("bak3 <", value, "bak3");
                return (Criteria) this;
            }

            public Criteria andBak3LessThanOrEqualTo(String value) {
                addCriterion("bak3 <=", value, "bak3");
                return (Criteria) this;
            }

            public Criteria andBak3Like(String value) {
                addCriterion("bak3 like", value, "bak3");
                return (Criteria) this;
            }

            public Criteria andBak3NotLike(String value) {
                addCriterion("bak3 not like", value, "bak3");
                return (Criteria) this;
            }

            public Criteria andBak3In(List<String> values) {
                addCriterion("bak3 in", values, "bak3");
                return (Criteria) this;
            }

            public Criteria andBak3NotIn(List<String> values) {
                addCriterion("bak3 not in", values, "bak3");
                return (Criteria) this;
            }

            public Criteria andBak3Between(String value1, String value2) {
                addCriterion("bak3 between", value1, value2, "bak3");
                return (Criteria) this;
            }

            public Criteria andBak3NotBetween(String value1, String value2) {
                addCriterion("bak3 not between", value1, value2, "bak3");
                return (Criteria) this;
            }

            public Criteria andBak4IsNull() {
                addCriterion("bak4 is null");
                return (Criteria) this;
            }

            public Criteria andBak4IsNotNull() {
                addCriterion("bak4 is not null");
                return (Criteria) this;
            }

            public Criteria andBak4EqualTo(String value) {
                addCriterion("bak4 =", value, "bak4");
                return (Criteria) this;
            }

            public Criteria andBak4NotEqualTo(String value) {
                addCriterion("bak4 <>", value, "bak4");
                return (Criteria) this;
            }

            public Criteria andBak4GreaterThan(String value) {
                addCriterion("bak4 >", value, "bak4");
                return (Criteria) this;
            }

            public Criteria andBak4GreaterThanOrEqualTo(String value) {
                addCriterion("bak4 >=", value, "bak4");
                return (Criteria) this;
            }

            public Criteria andBak4LessThan(String value) {
                addCriterion("bak4 <", value, "bak4");
                return (Criteria) this;
            }

            public Criteria andBak4LessThanOrEqualTo(String value) {
                addCriterion("bak4 <=", value, "bak4");
                return (Criteria) this;
            }

            public Criteria andBak4Like(String value) {
                addCriterion("bak4 like", value, "bak4");
                return (Criteria) this;
            }

            public Criteria andBak4NotLike(String value) {
                addCriterion("bak4 not like", value, "bak4");
                return (Criteria) this;
            }

            public Criteria andBak4In(List<String> values) {
                addCriterion("bak4 in", values, "bak4");
                return (Criteria) this;
            }

            public Criteria andBak4NotIn(List<String> values) {
                addCriterion("bak4 not in", values, "bak4");
                return (Criteria) this;
            }

            public Criteria andBak4Between(String value1, String value2) {
                addCriterion("bak4 between", value1, value2, "bak4");
                return (Criteria) this;
            }

            public Criteria andBak4NotBetween(String value1, String value2) {
                addCriterion("bak4 not between", value1, value2, "bak4");
                return (Criteria) this;
            }

            public Criteria andBak5IsNull() {
                addCriterion("bak5 is null");
                return (Criteria) this;
            }

            public Criteria andBak5IsNotNull() {
                addCriterion("bak5 is not null");
                return (Criteria) this;
            }

            public Criteria andBak5EqualTo(String value) {
                addCriterion("bak5 =", value, "bak5");
                return (Criteria) this;
            }

            public Criteria andBak5NotEqualTo(String value) {
                addCriterion("bak5 <>", value, "bak5");
                return (Criteria) this;
            }

            public Criteria andBak5GreaterThan(String value) {
                addCriterion("bak5 >", value, "bak5");
                return (Criteria) this;
            }

            public Criteria andBak5GreaterThanOrEqualTo(String value) {
                addCriterion("bak5 >=", value, "bak5");
                return (Criteria) this;
            }

            public Criteria andBak5LessThan(String value) {
                addCriterion("bak5 <", value, "bak5");
                return (Criteria) this;
            }

            public Criteria andBak5LessThanOrEqualTo(String value) {
                addCriterion("bak5 <=", value, "bak5");
                return (Criteria) this;
            }

            public Criteria andBak5Like(String value) {
                addCriterion("bak5 like", value, "bak5");
                return (Criteria) this;
            }

            public Criteria andBak5NotLike(String value) {
                addCriterion("bak5 not like", value, "bak5");
                return (Criteria) this;
            }

            public Criteria andBak5In(List<String> values) {
                addCriterion("bak5 in", values, "bak5");
                return (Criteria) this;
            }

            public Criteria andBak5NotIn(List<String> values) {
                addCriterion("bak5 not in", values, "bak5");
                return (Criteria) this;
            }

            public Criteria andBak5Between(String value1, String value2) {
                addCriterion("bak5 between", value1, value2, "bak5");
                return (Criteria) this;
            }

            public Criteria andBak5NotBetween(String value1, String value2) {
                addCriterion("bak5 not between", value1, value2, "bak5");
                return (Criteria) this;
            }

            public Criteria andBak6IsNull() {
                addCriterion("bak6 is null");
                return (Criteria) this;
            }

            public Criteria andBak6IsNotNull() {
                addCriterion("bak6 is not null");
                return (Criteria) this;
            }

            public Criteria andBak6EqualTo(String value) {
                addCriterion("bak6 =", value, "bak6");
                return (Criteria) this;
            }

            public Criteria andBak6NotEqualTo(String value) {
                addCriterion("bak6 <>", value, "bak6");
                return (Criteria) this;
            }

            public Criteria andBak6GreaterThan(String value) {
                addCriterion("bak6 >", value, "bak6");
                return (Criteria) this;
            }

            public Criteria andBak6GreaterThanOrEqualTo(String value) {
                addCriterion("bak6 >=", value, "bak6");
                return (Criteria) this;
            }

            public Criteria andBak6LessThan(String value) {
                addCriterion("bak6 <", value, "bak6");
                return (Criteria) this;
            }

            public Criteria andBak6LessThanOrEqualTo(String value) {
                addCriterion("bak6 <=", value, "bak6");
                return (Criteria) this;
            }

            public Criteria andBak6Like(String value) {
                addCriterion("bak6 like", value, "bak6");
                return (Criteria) this;
            }

            public Criteria andBak6NotLike(String value) {
                addCriterion("bak6 not like", value, "bak6");
                return (Criteria) this;
            }

            public Criteria andBak6In(List<String> values) {
                addCriterion("bak6 in", values, "bak6");
                return (Criteria) this;
            }

            public Criteria andBak6NotIn(List<String> values) {
                addCriterion("bak6 not in", values, "bak6");
                return (Criteria) this;
            }

            public Criteria andBak6Between(String value1, String value2) {
                addCriterion("bak6 between", value1, value2, "bak6");
                return (Criteria) this;
            }

            public Criteria andBak6NotBetween(String value1, String value2) {
                addCriterion("bak6 not between", value1, value2, "bak6");
                return (Criteria) this;
            }

            public Criteria andCreateUserIsNull() {
                addCriterion("create_user is null");
                return (Criteria) this;
            }

            public Criteria andCreateUserIsNotNull() {
                addCriterion("create_user is not null");
                return (Criteria) this;
            }

            public Criteria andCreateUserEqualTo(String value) {
                addCriterion("create_user =", value, "createUser");
                return (Criteria) this;
            }

            public Criteria andCreateUserNotEqualTo(String value) {
                addCriterion("create_user <>", value, "createUser");
                return (Criteria) this;
            }

            public Criteria andCreateUserGreaterThan(String value) {
                addCriterion("create_user >", value, "createUser");
                return (Criteria) this;
            }

            public Criteria andCreateUserGreaterThanOrEqualTo(String value) {
                addCriterion("create_user >=", value, "createUser");
                return (Criteria) this;
            }

            public Criteria andCreateUserLessThan(String value) {
                addCriterion("create_user <", value, "createUser");
                return (Criteria) this;
            }

            public Criteria andCreateUserLessThanOrEqualTo(String value) {
                addCriterion("create_user <=", value, "createUser");
                return (Criteria) this;
            }

            public Criteria andCreateUserLike(String value) {
                addCriterion("create_user like", value, "createUser");
                return (Criteria) this;
            }

            public Criteria andCreateUserNotLike(String value) {
                addCriterion("create_user not like", value, "createUser");
                return (Criteria) this;
            }

            public Criteria andCreateUserIn(List<String> values) {
                addCriterion("create_user in", values, "createUser");
                return (Criteria) this;
            }

            public Criteria andCreateUserNotIn(List<String> values) {
                addCriterion("create_user not in", values, "createUser");
                return (Criteria) this;
            }

            public Criteria andCreateUserBetween(String value1, String value2) {
                addCriterion("create_user between", value1, value2, "createUser");
                return (Criteria) this;
            }

            public Criteria andCreateUserNotBetween(String value1, String value2) {
                addCriterion("create_user not between", value1, value2, "createUser");
                return (Criteria) this;
            }

            public Criteria andCreateUserIdIsNull() {
                addCriterion("create_user_id is null");
                return (Criteria) this;
            }

            public Criteria andCreateUserIdIsNotNull() {
                addCriterion("create_user_id is not null");
                return (Criteria) this;
            }

            public Criteria andCreateUserIdEqualTo(String value) {
                addCriterion("create_user_id =", value, "createUserId");
                return (Criteria) this;
            }

            public Criteria andCreateUserIdNotEqualTo(String value) {
                addCriterion("create_user_id <>", value, "createUserId");
                return (Criteria) this;
            }

            public Criteria andCreateUserIdGreaterThan(String value) {
                addCriterion("create_user_id >", value, "createUserId");
                return (Criteria) this;
            }

            public Criteria andCreateUserIdGreaterThanOrEqualTo(String value) {
                addCriterion("create_user_id >=", value, "createUserId");
                return (Criteria) this;
            }

            public Criteria andCreateUserIdLessThan(String value) {
                addCriterion("create_user_id <", value, "createUserId");
                return (Criteria) this;
            }

            public Criteria andCreateUserIdLessThanOrEqualTo(String value) {
                addCriterion("create_user_id <=", value, "createUserId");
                return (Criteria) this;
            }

            public Criteria andCreateUserIdLike(String value) {
                addCriterion("create_user_id like", value, "createUserId");
                return (Criteria) this;
            }

            public Criteria andCreateUserIdNotLike(String value) {
                addCriterion("create_user_id not like", value, "createUserId");
                return (Criteria) this;
            }

            public Criteria andCreateUserIdIn(List<String> values) {
                addCriterion("create_user_id in", values, "createUserId");
                return (Criteria) this;
            }

            public Criteria andCreateUserIdNotIn(List<String> values) {
                addCriterion("create_user_id not in", values, "createUserId");
                return (Criteria) this;
            }

            public Criteria andCreateUserIdBetween(String value1, String value2) {
                addCriterion("create_user_id between", value1, value2, "createUserId");
                return (Criteria) this;
            }

            public Criteria andCreateUserIdNotBetween(String value1, String value2) {
                addCriterion("create_user_id not between", value1, value2, "createUserId");
                return (Criteria) this;
            }

            public Criteria andCreateDateIsNull() {
                addCriterion("create_date is null");
                return (Criteria) this;
            }

            public Criteria andCreateDateIsNotNull() {
                addCriterion("create_date is not null");
                return (Criteria) this;
            }

            public Criteria andCreateDateEqualTo(String value) {
                addCriterion("create_date =", value, "createDate");
                return (Criteria) this;
            }

            public Criteria andCreateDateNotEqualTo(String value) {
                addCriterion("create_date <>", value, "createDate");
                return (Criteria) this;
            }

            public Criteria andCreateDateGreaterThan(String value) {
                addCriterion("create_date >", value, "createDate");
                return (Criteria) this;
            }

            public Criteria andCreateDateGreaterThanOrEqualTo(String value) {
                addCriterion("create_date >=", value, "createDate");
                return (Criteria) this;
            }

            public Criteria andCreateDateLessThan(String value) {
                addCriterion("create_date <", value, "createDate");
                return (Criteria) this;
            }

            public Criteria andCreateDateLessThanOrEqualTo(String value) {
                addCriterion("create_date <=", value, "createDate");
                return (Criteria) this;
            }

            public Criteria andCreateDateLike(String value) {
                addCriterion("create_date like", value, "createDate");
                return (Criteria) this;
            }

            public Criteria andCreateDateNotLike(String value) {
                addCriterion("create_date not like", value, "createDate");
                return (Criteria) this;
            }

            public Criteria andCreateDateIn(List<String> values) {
                addCriterion("create_date in", values, "createDate");
                return (Criteria) this;
            }

            public Criteria andCreateDateNotIn(List<String> values) {
                addCriterion("create_date not in", values, "createDate");
                return (Criteria) this;
            }

            public Criteria andCreateDateBetween(String value1, String value2) {
                addCriterion("create_date between", value1, value2, "createDate");
                return (Criteria) this;
            }

            public Criteria andCreateDateNotBetween(String value1, String value2) {
                addCriterion("create_date not between", value1, value2, "createDate");
                return (Criteria) this;
            }

            public Criteria andStatusIsNull() {
                addCriterion("status is null");
                return (Criteria) this;
            }

            public Criteria andStatusIsNotNull() {
                addCriterion("status is not null");
                return (Criteria) this;
            }

            public Criteria andStatusEqualTo(String value) {
                addCriterion("status =", value, "status");
                return (Criteria) this;
            }

            public Criteria andStatusNotEqualTo(String value) {
                addCriterion("status <>", value, "status");
                return (Criteria) this;
            }

            public Criteria andStatusGreaterThan(String value) {
                addCriterion("status >", value, "status");
                return (Criteria) this;
            }

            public Criteria andStatusGreaterThanOrEqualTo(String value) {
                addCriterion("status >=", value, "status");
                return (Criteria) this;
            }

            public Criteria andStatusLessThan(String value) {
                addCriterion("status <", value, "status");
                return (Criteria) this;
            }

            public Criteria andStatusLessThanOrEqualTo(String value) {
                addCriterion("status <=", value, "status");
                return (Criteria) this;
            }

            public Criteria andStatusLike(String value) {
                addCriterion("status like", value, "status");
                return (Criteria) this;
            }

            public Criteria andStatusNotLike(String value) {
                addCriterion("status not like", value, "status");
                return (Criteria) this;
            }

            public Criteria andStatusIn(List<String> values) {
                addCriterion("status in", values, "status");
                return (Criteria) this;
            }

            public Criteria andStatusNotIn(List<String> values) {
                addCriterion("status not in", values, "status");
                return (Criteria) this;
            }

            public Criteria andStatusBetween(String value1, String value2) {
                addCriterion("status between", value1, value2, "status");
                return (Criteria) this;
            }

            public Criteria andStatusNotBetween(String value1, String value2) {
                addCriterion("status not between", value1, value2, "status");
                return (Criteria) this;
            }

            public Criteria andUpdateDateIsNull() {
                addCriterion("update_date is null");
                return (Criteria) this;
            }

            public Criteria andUpdateDateIsNotNull() {
                addCriterion("update_date is not null");
                return (Criteria) this;
            }

            public Criteria andUpdateDateEqualTo(String value) {
                addCriterion("update_date =", value, "updateDate");
                return (Criteria) this;
            }

            public Criteria andUpdateDateNotEqualTo(String value) {
                addCriterion("update_date <>", value, "updateDate");
                return (Criteria) this;
            }

            public Criteria andUpdateDateGreaterThan(String value) {
                addCriterion("update_date >", value, "updateDate");
                return (Criteria) this;
            }

            public Criteria andUpdateDateGreaterThanOrEqualTo(String value) {
                addCriterion("update_date >=", value, "updateDate");
                return (Criteria) this;
            }

            public Criteria andUpdateDateLessThan(String value) {
                addCriterion("update_date <", value, "updateDate");
                return (Criteria) this;
            }

            public Criteria andUpdateDateLessThanOrEqualTo(String value) {
                addCriterion("update_date <=", value, "updateDate");
                return (Criteria) this;
            }

            public Criteria andUpdateDateLike(String value) {
                addCriterion("update_date like", value, "updateDate");
                return (Criteria) this;
            }

            public Criteria andUpdateDateNotLike(String value) {
                addCriterion("update_date not like", value, "updateDate");
                return (Criteria) this;
            }

            public Criteria andUpdateDateIn(List<String> values) {
                addCriterion("update_date in", values, "updateDate");
                return (Criteria) this;
            }

            public Criteria andUpdateDateNotIn(List<String> values) {
                addCriterion("update_date not in", values, "updateDate");
                return (Criteria) this;
            }

            public Criteria andUpdateDateBetween(String value1, String value2) {
                addCriterion("update_date between", value1, value2, "updateDate");
                return (Criteria) this;
            }

            public Criteria andUpdateDateNotBetween(String value1, String value2) {
                addCriterion("update_date not between", value1, value2, "updateDate");
                return (Criteria) this;
            }

            public Criteria andUpdateUserIsNull() {
                addCriterion("update_user is null");
                return (Criteria) this;
            }

            public Criteria andUpdateUserIsNotNull() {
                addCriterion("update_user is not null");
                return (Criteria) this;
            }

            public Criteria andUpdateUserEqualTo(String value) {
                addCriterion("update_user =", value, "updateUser");
                return (Criteria) this;
            }

            public Criteria andUpdateUserNotEqualTo(String value) {
                addCriterion("update_user <>", value, "updateUser");
                return (Criteria) this;
            }

            public Criteria andUpdateUserGreaterThan(String value) {
                addCriterion("update_user >", value, "updateUser");
                return (Criteria) this;
            }

            public Criteria andUpdateUserGreaterThanOrEqualTo(String value) {
                addCriterion("update_user >=", value, "updateUser");
                return (Criteria) this;
            }

            public Criteria andUpdateUserLessThan(String value) {
                addCriterion("update_user <", value, "updateUser");
                return (Criteria) this;
            }

            public Criteria andUpdateUserLessThanOrEqualTo(String value) {
                addCriterion("update_user <=", value, "updateUser");
                return (Criteria) this;
            }

            public Criteria andUpdateUserLike(String value) {
                addCriterion("update_user like", value, "updateUser");
                return (Criteria) this;
            }

            public Criteria andUpdateUserNotLike(String value) {
                addCriterion("update_user not like", value, "updateUser");
                return (Criteria) this;
            }

            public Criteria andUpdateUserIn(List<String> values) {
                addCriterion("update_user in", values, "updateUser");
                return (Criteria) this;
            }

            public Criteria andUpdateUserNotIn(List<String> values) {
                addCriterion("update_user not in", values, "updateUser");
                return (Criteria) this;
            }

            public Criteria andUpdateUserBetween(String value1, String value2) {
                addCriterion("update_user between", value1, value2, "updateUser");
                return (Criteria) this;
            }

            public Criteria andUpdateUserNotBetween(String value1, String value2) {
                addCriterion("update_user not between", value1, value2, "updateUser");
                return (Criteria) this;
            }

            public Criteria andRemarksIsNull() {
                addCriterion("remarks is null");
                return (Criteria) this;
            }

            public Criteria andRemarksIsNotNull() {
                addCriterion("remarks is not null");
                return (Criteria) this;
            }

            public Criteria andRemarksEqualTo(String value) {
                addCriterion("remarks =", value, "remarks");
                return (Criteria) this;
            }

            public Criteria andRemarksNotEqualTo(String value) {
                addCriterion("remarks <>", value, "remarks");
                return (Criteria) this;
            }

            public Criteria andRemarksGreaterThan(String value) {
                addCriterion("remarks >", value, "remarks");
                return (Criteria) this;
            }

            public Criteria andRemarksGreaterThanOrEqualTo(String value) {
                addCriterion("remarks >=", value, "remarks");
                return (Criteria) this;
            }

            public Criteria andRemarksLessThan(String value) {
                addCriterion("remarks <", value, "remarks");
                return (Criteria) this;
            }

            public Criteria andRemarksLessThanOrEqualTo(String value) {
                addCriterion("remarks <=", value, "remarks");
                return (Criteria) this;
            }

            public Criteria andRemarksLike(String value) {
                addCriterion("remarks like", value, "remarks");
                return (Criteria) this;
            }

            public Criteria andRemarksNotLike(String value) {
                addCriterion("remarks not like", value, "remarks");
                return (Criteria) this;
            }

            public Criteria andRemarksIn(List<String> values) {
                addCriterion("remarks in", values, "remarks");
                return (Criteria) this;
            }

            public Criteria andRemarksNotIn(List<String> values) {
                addCriterion("remarks not in", values, "remarks");
                return (Criteria) this;
            }

            public Criteria andRemarksBetween(String value1, String value2) {
                addCriterion("remarks between", value1, value2, "remarks");
                return (Criteria) this;
            }

            public Criteria andRemarksNotBetween(String value1, String value2) {
                addCriterion("remarks not between", value1, value2, "remarks");
                return (Criteria) this;
            }

            public Criteria andAuditStatusIsNull() {
                addCriterion("audit_status is null");
                return (Criteria) this;
            }

            public Criteria andAuditStatusIsNotNull() {
                addCriterion("audit_status is not null");
                return (Criteria) this;
            }

            public Criteria andAuditStatusEqualTo(String value) {
                addCriterion("audit_status =", value, "auditStatus");
                return (Criteria) this;
            }

            public Criteria andAuditStatusNotEqualTo(String value) {
                addCriterion("audit_status <>", value, "auditStatus");
                return (Criteria) this;
            }

            public Criteria andAuditStatusGreaterThan(String value) {
                addCriterion("audit_status >", value, "auditStatus");
                return (Criteria) this;
            }

            public Criteria andAuditStatusGreaterThanOrEqualTo(String value) {
                addCriterion("audit_status >=", value, "auditStatus");
                return (Criteria) this;
            }

            public Criteria andAuditStatusLessThan(String value) {
                addCriterion("audit_status <", value, "auditStatus");
                return (Criteria) this;
            }

            public Criteria andAuditStatusLessThanOrEqualTo(String value) {
                addCriterion("audit_status <=", value, "auditStatus");
                return (Criteria) this;
            }

            public Criteria andAuditStatusLike(String value) {
                addCriterion("audit_status like", value, "auditStatus");
                return (Criteria) this;
            }

            public Criteria andAuditStatusNotLike(String value) {
                addCriterion("audit_status not like", value, "auditStatus");
                return (Criteria) this;
            }

            public Criteria andAuditStatusIn(List<String> values) {
                addCriterion("audit_status in", values, "auditStatus");
                return (Criteria) this;
            }

            public Criteria andAuditStatusNotIn(List<String> values) {
                addCriterion("audit_status not in", values, "auditStatus");
                return (Criteria) this;
            }

            public Criteria andAuditStatusBetween(String value1, String value2) {
                addCriterion("audit_status between", value1, value2, "auditStatus");
                return (Criteria) this;
            }

            public Criteria andAuditStatusNotBetween(String value1, String value2) {
                addCriterion("audit_status not between", value1, value2, "auditStatus");
                return (Criteria) this;
            }
        }

        public static class Criteria extends GeneratedCriteria {

            protected Criteria() {
                super();
            }
        }

        public static class Criterion {
            private String condition;

            private Object value;

            private Object secondValue;

            private boolean noValue;

            private boolean singleValue;

            private boolean betweenValue;

            private boolean listValue;

            private String typeHandler;

            public String getCondition() {
                return condition;
            }

            public Object getValue() {
                return value;
            }

            public Object getSecondValue() {
                return secondValue;
            }

            public boolean isNoValue() {
                return noValue;
            }

            public boolean isSingleValue() {
                return singleValue;
            }

            public boolean isBetweenValue() {
                return betweenValue;
            }

            public boolean isListValue() {
                return listValue;
            }

            public String getTypeHandler() {
                return typeHandler;
            }

            protected Criterion(String condition) {
                super();
                this.condition = condition;
                this.typeHandler = null;
                this.noValue = true;
            }

            protected Criterion(String condition, Object value, String typeHandler) {
                super();
                this.condition = condition;
                this.value = value;
                this.typeHandler = typeHandler;
                if (value instanceof List<?>) {
                    this.listValue = true;
                } else {
                    this.singleValue = true;
                }
            }

            protected Criterion(String condition, Object value) {
                this(condition, value, null);
            }

            protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
                super();
                this.condition = condition;
                this.value = value;
                this.secondValue = secondValue;
                this.typeHandler = typeHandler;
                this.betweenValue = true;
            }

            protected Criterion(String condition, Object value, Object secondValue) {
                this(condition, value, secondValue, null);
            }
        }

    }
}