package com.pcitc.base.system;

import com.pcitc.base.common.DataEntity;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * <p>实体类</p>
 * <p>Table: index_out_patent - </p>
 *
 * @since 2019-05-24 09:47:14
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IndexOutPatent extends DataEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * data_id -
     */
    private String dataId;

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

    /**
     * SQH - 申请号
     */
    private String sqh;

    /**
     * SQRI - 申请日
     */
    private String sqri;

    /**
     * FMMC - 发明名称
     */
    private String fmmc;

    /**
     * ZHY - 摘要
     */
    private String zhy;

    /**
     * GKH - 公开号
     */
    private String gkh;

    /**
     * GKR - 公开日
     */
    private String gkr;

    /**
     * WXLX - 文献类型
     */
    private String wxlx;

    /**
     * SHENQR - 申请人
     */
    private String shenqr;

    /**
     * FMR - 发明人
     */
    private String fmr;

    /**
     * SQRDZ - 申请人地址
     */
    private String sqrdz;

    /**
     * DLR - 代理人
     */
    private String dlr;

    /**
     * DLJG - 代理机构
     */
    private String dljg;

    /**
     * GBDM - 申请人的国别代码
     */
    private String gbdm;

    /**
     * IPCFLH - ipc分类号
     */
    private String ipcflh;

    /**
     * CPCFLH - cpc分类号
     */
    private String cpcflh;

    /**
     * LJNFLH - 洛迦诺分类号
     */
    private String ljnflh;

    /**
     * YXQH - 优先权号
     */
    private String yxqh;

    /**
     * YXQR - 优先权日
     */
    private String yxqr;

    /**
     * DQFLZT - 当前法律状态
     */
    private String dqflzt;

    /**
     * FLZTLSXX - 法律状态历史详细信息
     */
    private String flztlsxx;

    /**
     * FLZTGGRQ - 法律状态公告日期
     */
    private String flztggrq;

    /**
     * FLZTYJ - 法律状态一级
     */
    private String flztyj;

    /**
     * FLZTEJ - 法律状态二级
     */
    private String flztej;

    /**
     * SHOUQR - 授权日
     */
    private String shouqr;

    /**
     * SQGGH - 授权公告号
     */
    private String sqggh;

    /**
     * ZSH - 证书号
     */
    private String zsh;

    /**
     * ZLQR - 专利权人
     */
    private String zlqr;

    /**
     * ZLH - 专利号
     */
    private String zlh;

    /**
     * QLYQ - 权利要求
     */
    private String qlyq;

    /**
     * ZLPDF - 专利PDF文件
     */
    private String zlpdf;

    /**
     * SCYJTZSFWR - 审查意见通知书发文日
     */
    private String scyjtzsfwr;

    /**
     * SCYJDFR - 审查意见答复日
     */
    private String scyjdfr;

    /**
     * SCYJBZR - 审查意见补正日
     */
    private String scyjbzr;

    /**
     * BZTZFFWR - 办登(证)通知书发文日
     */
    private String bztzffwr;

    /**
     * BHTZSFWR - 驳回通知书发文日
     */
    private String bhtzsfwr;

    /**
     * FSQQR - 复审请求日
     */
    private String fsqqr;

    /**
     * FSSLFWR - 复审受理发文日
     */
    private String fsslfwr;

    /**
     * DFGCWJ - 答复的过程文件
     */
    private String dfgcwj;

    /**
     * SQBZ - 国内、涉外专利标志
     */
    private String sqbz;

    /**
     * RKSJ - 入库时间
     */
    private String rksj;

    /**
     * GMJJHYML - 国民经济行业门类
     */
    private String gmjjhyml;

    /**
     * GMJJHYDL - 国民经济行业大类
     */
    private String gmjjhydl;

    /**
     * GMJJHYZL - 国民经济行业中类
     */
    private String gmjjhyzl;

    /**
     * ZXCYYJ - 战新产业一级
     */
    private String zxcyyj;

    /**
     * ZXCYEJ - 战新产业二级
     */
    private String zxcyej;

    /**
     * ZXCYSJ - 战新产业三级
     */
    private String zxcysj;

    /**
     * BYZCS - 被引总次数
     */
    private String byzcs;

    /**
     * BFMRYYCS - 被发明人引用次数
     */
    private String bfmryycs;

    /**
     * BSCYYYCS - 被审查员引用次数
     */
    private String bscyyycs;

    /**
     * ZYCS - 自引次数
     */
    private String zycs;

    /**
     * TYCS - 他引次数
     */
    private String tycs;

    /**
     * SQRDM - 申请人代码
     */
    private String sqrdm;

    /**
     * JGHDMC - 加工后的名称
     */
    private String jghdmc;

    /**
     * JSWTHYYXG - 解决的技术问题和有益效果
     */
    private String jswthyyxg;

    /**
     * FMDHHXFA - 发明点和核心方案
     */
    private String fmdhhxfa;

    /**
     * YT - 用途
     */
    private String yt;

    /**
     * CREATE_DATE -
     */
    private String createDate;

    /**
     * CREATE_USER_ID -
     */
    private String createUserId;

    /**
     * REMARKS -
     */
    private String remarks;

    /**
     * STATUS - 研究院
     */
    private String status;

    /**
     * GJ - 国家
     */
    private String gj;

    /**
     * DEFINE1 -
     */
    private String define1;

    /**
     * DEFINE2 - 8个研究院
     */
    private String define2;

    /**
     * DEFINE3 - 9个类型公司
     */
    private String define3;

    /**
     * DEFINE4 -
     */
    private String define4;

    public String getDataId() {
        return this.dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
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

    public String getSqh() {
        return this.sqh;
    }

    public void setSqh(String sqh) {
        this.sqh = sqh;
    }

    public String getSqri() {
        return this.sqri;
    }

    public void setSqri(String sqri) {
        this.sqri = sqri;
    }

    public String getFmmc() {
        return this.fmmc;
    }

    public void setFmmc(String fmmc) {
        this.fmmc = fmmc;
    }

    public String getZhy() {
        return this.zhy;
    }

    public void setZhy(String zhy) {
        this.zhy = zhy;
    }

    public String getGkh() {
        return this.gkh;
    }

    public void setGkh(String gkh) {
        this.gkh = gkh;
    }

    public String getGkr() {
        return this.gkr;
    }

    public void setGkr(String gkr) {
        this.gkr = gkr;
    }

    public String getWxlx() {
        return this.wxlx;
    }

    public void setWxlx(String wxlx) {
        this.wxlx = wxlx;
    }

    public String getShenqr() {
        return this.shenqr;
    }

    public void setShenqr(String shenqr) {
        this.shenqr = shenqr;
    }

    public String getFmr() {
        return this.fmr;
    }

    public void setFmr(String fmr) {
        this.fmr = fmr;
    }

    public String getSqrdz() {
        return this.sqrdz;
    }

    public void setSqrdz(String sqrdz) {
        this.sqrdz = sqrdz;
    }

    public String getDlr() {
        return this.dlr;
    }

    public void setDlr(String dlr) {
        this.dlr = dlr;
    }

    public String getDljg() {
        return this.dljg;
    }

    public void setDljg(String dljg) {
        this.dljg = dljg;
    }

    public String getGbdm() {
        return this.gbdm;
    }

    public void setGbdm(String gbdm) {
        this.gbdm = gbdm;
    }

    public String getIpcflh() {
        return this.ipcflh;
    }

    public void setIpcflh(String ipcflh) {
        this.ipcflh = ipcflh;
    }

    public String getCpcflh() {
        return this.cpcflh;
    }

    public void setCpcflh(String cpcflh) {
        this.cpcflh = cpcflh;
    }

    public String getLjnflh() {
        return this.ljnflh;
    }

    public void setLjnflh(String ljnflh) {
        this.ljnflh = ljnflh;
    }

    public String getYxqh() {
        return this.yxqh;
    }

    public void setYxqh(String yxqh) {
        this.yxqh = yxqh;
    }

    public String getYxqr() {
        return this.yxqr;
    }

    public void setYxqr(String yxqr) {
        this.yxqr = yxqr;
    }

    public String getDqflzt() {
        return this.dqflzt;
    }

    public void setDqflzt(String dqflzt) {
        this.dqflzt = dqflzt;
    }

    public String getFlztlsxx() {
        return this.flztlsxx;
    }

    public void setFlztlsxx(String flztlsxx) {
        this.flztlsxx = flztlsxx;
    }

    public String getFlztggrq() {
        return this.flztggrq;
    }

    public void setFlztggrq(String flztggrq) {
        this.flztggrq = flztggrq;
    }

    public String getFlztyj() {
        return this.flztyj;
    }

    public void setFlztyj(String flztyj) {
        this.flztyj = flztyj;
    }

    public String getFlztej() {
        return this.flztej;
    }

    public void setFlztej(String flztej) {
        this.flztej = flztej;
    }

    public String getShouqr() {
        return this.shouqr;
    }

    public void setShouqr(String shouqr) {
        this.shouqr = shouqr;
    }

    public String getSqggh() {
        return this.sqggh;
    }

    public void setSqggh(String sqggh) {
        this.sqggh = sqggh;
    }

    public String getZsh() {
        return this.zsh;
    }

    public void setZsh(String zsh) {
        this.zsh = zsh;
    }

    public String getZlqr() {
        return this.zlqr;
    }

    public void setZlqr(String zlqr) {
        this.zlqr = zlqr;
    }

    public String getZlh() {
        return this.zlh;
    }

    public void setZlh(String zlh) {
        this.zlh = zlh;
    }

    public String getQlyq() {
        return this.qlyq;
    }

    public void setQlyq(String qlyq) {
        this.qlyq = qlyq;
    }

    public String getZlpdf() {
        return this.zlpdf;
    }

    public void setZlpdf(String zlpdf) {
        this.zlpdf = zlpdf;
    }

    public String getScyjtzsfwr() {
        return this.scyjtzsfwr;
    }

    public void setScyjtzsfwr(String scyjtzsfwr) {
        this.scyjtzsfwr = scyjtzsfwr;
    }

    public String getScyjdfr() {
        return this.scyjdfr;
    }

    public void setScyjdfr(String scyjdfr) {
        this.scyjdfr = scyjdfr;
    }

    public String getScyjbzr() {
        return this.scyjbzr;
    }

    public void setScyjbzr(String scyjbzr) {
        this.scyjbzr = scyjbzr;
    }

    public String getBztzffwr() {
        return this.bztzffwr;
    }

    public void setBztzffwr(String bztzffwr) {
        this.bztzffwr = bztzffwr;
    }

    public String getBhtzsfwr() {
        return this.bhtzsfwr;
    }

    public void setBhtzsfwr(String bhtzsfwr) {
        this.bhtzsfwr = bhtzsfwr;
    }

    public String getFsqqr() {
        return this.fsqqr;
    }

    public void setFsqqr(String fsqqr) {
        this.fsqqr = fsqqr;
    }

    public String getFsslfwr() {
        return this.fsslfwr;
    }

    public void setFsslfwr(String fsslfwr) {
        this.fsslfwr = fsslfwr;
    }

    public String getDfgcwj() {
        return this.dfgcwj;
    }

    public void setDfgcwj(String dfgcwj) {
        this.dfgcwj = dfgcwj;
    }

    public String getSqbz() {
        return this.sqbz;
    }

    public void setSqbz(String sqbz) {
        this.sqbz = sqbz;
    }

    public String getRksj() {
        return this.rksj;
    }

    public void setRksj(String rksj) {
        this.rksj = rksj;
    }

    public String getGmjjhyml() {
        return this.gmjjhyml;
    }

    public void setGmjjhyml(String gmjjhyml) {
        this.gmjjhyml = gmjjhyml;
    }

    public String getGmjjhydl() {
        return this.gmjjhydl;
    }

    public void setGmjjhydl(String gmjjhydl) {
        this.gmjjhydl = gmjjhydl;
    }

    public String getGmjjhyzl() {
        return this.gmjjhyzl;
    }

    public void setGmjjhyzl(String gmjjhyzl) {
        this.gmjjhyzl = gmjjhyzl;
    }

    public String getZxcyyj() {
        return this.zxcyyj;
    }

    public void setZxcyyj(String zxcyyj) {
        this.zxcyyj = zxcyyj;
    }

    public String getZxcyej() {
        return this.zxcyej;
    }

    public void setZxcyej(String zxcyej) {
        this.zxcyej = zxcyej;
    }

    public String getZxcysj() {
        return this.zxcysj;
    }

    public void setZxcysj(String zxcysj) {
        this.zxcysj = zxcysj;
    }

    public String getByzcs() {
        return this.byzcs;
    }

    public void setByzcs(String byzcs) {
        this.byzcs = byzcs;
    }

    public String getBfmryycs() {
        return this.bfmryycs;
    }

    public void setBfmryycs(String bfmryycs) {
        this.bfmryycs = bfmryycs;
    }

    public String getBscyyycs() {
        return this.bscyyycs;
    }

    public void setBscyyycs(String bscyyycs) {
        this.bscyyycs = bscyyycs;
    }

    public String getZycs() {
        return this.zycs;
    }

    public void setZycs(String zycs) {
        this.zycs = zycs;
    }

    public String getTycs() {
        return this.tycs;
    }

    public void setTycs(String tycs) {
        this.tycs = tycs;
    }

    public String getSqrdm() {
        return this.sqrdm;
    }

    public void setSqrdm(String sqrdm) {
        this.sqrdm = sqrdm;
    }

    public String getJghdmc() {
        return this.jghdmc;
    }

    public void setJghdmc(String jghdmc) {
        this.jghdmc = jghdmc;
    }

    public String getJswthyyxg() {
        return this.jswthyyxg;
    }

    public void setJswthyyxg(String jswthyyxg) {
        this.jswthyyxg = jswthyyxg;
    }

    public String getFmdhhxfa() {
        return this.fmdhhxfa;
    }

    public void setFmdhhxfa(String fmdhhxfa) {
        this.fmdhhxfa = fmdhhxfa;
    }

    public String getYt() {
        return this.yt;
    }

    public void setYt(String yt) {
        this.yt = yt;
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

    public String getRemarks() {
        return this.remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGj() {
        return this.gj;
    }

    public void setGj(String gj) {
        this.gj = gj;
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

        IndexOutPatent other = (IndexOutPatent) that;

        return
                (this.getDataId() == null ? other.getDataId() == null : this.getDataId().equals(other.getDataId())) &&

                        (this.getTfmTypeId() == null ? other.getTfmTypeId() == null : this.getTfmTypeId().equals(other.getTfmTypeId())) &&

                        (this.getTypeCode() == null ? other.getTypeCode() == null : this.getTypeCode().equals(other.getTypeCode())) &&

                        (this.getTypeName() == null ? other.getTypeName() == null : this.getTypeName().equals(other.getTypeName())) &&

                        (this.getParentId() == null ? other.getParentId() == null : this.getParentId().equals(other.getParentId())) &&

                        (this.getParentCode() == null ? other.getParentCode() == null : this.getParentCode().equals(other.getParentCode())) &&

                        (this.getIsParent() == null ? other.getIsParent() == null : this.getIsParent().equals(other.getIsParent())) &&

                        (this.getTypeIndex() == null ? other.getTypeIndex() == null : this.getTypeIndex().equals(other.getTypeIndex())) &&

                        (this.getSqh() == null ? other.getSqh() == null : this.getSqh().equals(other.getSqh())) &&

                        (this.getSqri() == null ? other.getSqri() == null : this.getSqri().equals(other.getSqri())) &&

                        (this.getFmmc() == null ? other.getFmmc() == null : this.getFmmc().equals(other.getFmmc())) &&

                        (this.getZhy() == null ? other.getZhy() == null : this.getZhy().equals(other.getZhy())) &&

                        (this.getGkh() == null ? other.getGkh() == null : this.getGkh().equals(other.getGkh())) &&

                        (this.getGkr() == null ? other.getGkr() == null : this.getGkr().equals(other.getGkr())) &&

                        (this.getWxlx() == null ? other.getWxlx() == null : this.getWxlx().equals(other.getWxlx())) &&

                        (this.getShenqr() == null ? other.getShenqr() == null : this.getShenqr().equals(other.getShenqr())) &&

                        (this.getFmr() == null ? other.getFmr() == null : this.getFmr().equals(other.getFmr())) &&

                        (this.getSqrdz() == null ? other.getSqrdz() == null : this.getSqrdz().equals(other.getSqrdz())) &&

                        (this.getDlr() == null ? other.getDlr() == null : this.getDlr().equals(other.getDlr())) &&

                        (this.getDljg() == null ? other.getDljg() == null : this.getDljg().equals(other.getDljg())) &&

                        (this.getGbdm() == null ? other.getGbdm() == null : this.getGbdm().equals(other.getGbdm())) &&

                        (this.getIpcflh() == null ? other.getIpcflh() == null : this.getIpcflh().equals(other.getIpcflh())) &&

                        (this.getCpcflh() == null ? other.getCpcflh() == null : this.getCpcflh().equals(other.getCpcflh())) &&

                        (this.getLjnflh() == null ? other.getLjnflh() == null : this.getLjnflh().equals(other.getLjnflh())) &&

                        (this.getYxqh() == null ? other.getYxqh() == null : this.getYxqh().equals(other.getYxqh())) &&

                        (this.getYxqr() == null ? other.getYxqr() == null : this.getYxqr().equals(other.getYxqr())) &&

                        (this.getDqflzt() == null ? other.getDqflzt() == null : this.getDqflzt().equals(other.getDqflzt())) &&

                        (this.getFlztlsxx() == null ? other.getFlztlsxx() == null : this.getFlztlsxx().equals(other.getFlztlsxx())) &&

                        (this.getFlztggrq() == null ? other.getFlztggrq() == null : this.getFlztggrq().equals(other.getFlztggrq())) &&

                        (this.getFlztyj() == null ? other.getFlztyj() == null : this.getFlztyj().equals(other.getFlztyj())) &&

                        (this.getFlztej() == null ? other.getFlztej() == null : this.getFlztej().equals(other.getFlztej())) &&

                        (this.getShouqr() == null ? other.getShouqr() == null : this.getShouqr().equals(other.getShouqr())) &&

                        (this.getSqggh() == null ? other.getSqggh() == null : this.getSqggh().equals(other.getSqggh())) &&

                        (this.getZsh() == null ? other.getZsh() == null : this.getZsh().equals(other.getZsh())) &&

                        (this.getZlqr() == null ? other.getZlqr() == null : this.getZlqr().equals(other.getZlqr())) &&

                        (this.getZlh() == null ? other.getZlh() == null : this.getZlh().equals(other.getZlh())) &&

                        (this.getQlyq() == null ? other.getQlyq() == null : this.getQlyq().equals(other.getQlyq())) &&

                        (this.getZlpdf() == null ? other.getZlpdf() == null : this.getZlpdf().equals(other.getZlpdf())) &&

                        (this.getScyjtzsfwr() == null ? other.getScyjtzsfwr() == null : this.getScyjtzsfwr().equals(other.getScyjtzsfwr())) &&

                        (this.getScyjdfr() == null ? other.getScyjdfr() == null : this.getScyjdfr().equals(other.getScyjdfr())) &&

                        (this.getScyjbzr() == null ? other.getScyjbzr() == null : this.getScyjbzr().equals(other.getScyjbzr())) &&

                        (this.getBztzffwr() == null ? other.getBztzffwr() == null : this.getBztzffwr().equals(other.getBztzffwr())) &&

                        (this.getBhtzsfwr() == null ? other.getBhtzsfwr() == null : this.getBhtzsfwr().equals(other.getBhtzsfwr())) &&

                        (this.getFsqqr() == null ? other.getFsqqr() == null : this.getFsqqr().equals(other.getFsqqr())) &&

                        (this.getFsslfwr() == null ? other.getFsslfwr() == null : this.getFsslfwr().equals(other.getFsslfwr())) &&

                        (this.getDfgcwj() == null ? other.getDfgcwj() == null : this.getDfgcwj().equals(other.getDfgcwj())) &&

                        (this.getSqbz() == null ? other.getSqbz() == null : this.getSqbz().equals(other.getSqbz())) &&

                        (this.getRksj() == null ? other.getRksj() == null : this.getRksj().equals(other.getRksj())) &&

                        (this.getGmjjhyml() == null ? other.getGmjjhyml() == null : this.getGmjjhyml().equals(other.getGmjjhyml())) &&

                        (this.getGmjjhydl() == null ? other.getGmjjhydl() == null : this.getGmjjhydl().equals(other.getGmjjhydl())) &&

                        (this.getGmjjhyzl() == null ? other.getGmjjhyzl() == null : this.getGmjjhyzl().equals(other.getGmjjhyzl())) &&

                        (this.getZxcyyj() == null ? other.getZxcyyj() == null : this.getZxcyyj().equals(other.getZxcyyj())) &&

                        (this.getZxcyej() == null ? other.getZxcyej() == null : this.getZxcyej().equals(other.getZxcyej())) &&

                        (this.getZxcysj() == null ? other.getZxcysj() == null : this.getZxcysj().equals(other.getZxcysj())) &&

                        (this.getByzcs() == null ? other.getByzcs() == null : this.getByzcs().equals(other.getByzcs())) &&

                        (this.getBfmryycs() == null ? other.getBfmryycs() == null : this.getBfmryycs().equals(other.getBfmryycs())) &&

                        (this.getBscyyycs() == null ? other.getBscyyycs() == null : this.getBscyyycs().equals(other.getBscyyycs())) &&

                        (this.getZycs() == null ? other.getZycs() == null : this.getZycs().equals(other.getZycs())) &&

                        (this.getTycs() == null ? other.getTycs() == null : this.getTycs().equals(other.getTycs())) &&

                        (this.getSqrdm() == null ? other.getSqrdm() == null : this.getSqrdm().equals(other.getSqrdm())) &&

                        (this.getJghdmc() == null ? other.getJghdmc() == null : this.getJghdmc().equals(other.getJghdmc())) &&

                        (this.getJswthyyxg() == null ? other.getJswthyyxg() == null : this.getJswthyyxg().equals(other.getJswthyyxg())) &&

                        (this.getFmdhhxfa() == null ? other.getFmdhhxfa() == null : this.getFmdhhxfa().equals(other.getFmdhhxfa())) &&

                        (this.getYt() == null ? other.getYt() == null : this.getYt().equals(other.getYt())) &&

                        (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate())) &&

                        (this.getCreateUserId() == null ? other.getCreateUserId() == null : this.getCreateUserId().equals(other.getCreateUserId())) &&

                        (this.getRemarks() == null ? other.getRemarks() == null : this.getRemarks().equals(other.getRemarks())) &&

                        (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus())) &&

                        (this.getGj() == null ? other.getGj() == null : this.getGj().equals(other.getGj())) &&

                        (this.getDefine1() == null ? other.getDefine1() == null : this.getDefine1().equals(other.getDefine1())) &&

                        (this.getDefine2() == null ? other.getDefine2() == null : this.getDefine2().equals(other.getDefine2())) &&

                        (this.getDefine3() == null ? other.getDefine3() == null : this.getDefine3().equals(other.getDefine3())) &&

                        (this.getDefine4() == null ? other.getDefine4() == null : this.getDefine4().equals(other.getDefine4()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDataId() == null) ? 0 : getDataId().hashCode());
        result = prime * result + ((getTfmTypeId() == null) ? 0 : getTfmTypeId().hashCode());
        result = prime * result + ((getTypeCode() == null) ? 0 : getTypeCode().hashCode());
        result = prime * result + ((getTypeName() == null) ? 0 : getTypeName().hashCode());
        result = prime * result + ((getParentId() == null) ? 0 : getParentId().hashCode());
        result = prime * result + ((getParentCode() == null) ? 0 : getParentCode().hashCode());
        result = prime * result + ((getIsParent() == null) ? 0 : getIsParent().hashCode());
        result = prime * result + ((getTypeIndex() == null) ? 0 : getTypeIndex().hashCode());
        result = prime * result + ((getSqh() == null) ? 0 : getSqh().hashCode());
        result = prime * result + ((getSqri() == null) ? 0 : getSqri().hashCode());
        result = prime * result + ((getFmmc() == null) ? 0 : getFmmc().hashCode());
        result = prime * result + ((getZhy() == null) ? 0 : getZhy().hashCode());
        result = prime * result + ((getGkh() == null) ? 0 : getGkh().hashCode());
        result = prime * result + ((getGkr() == null) ? 0 : getGkr().hashCode());
        result = prime * result + ((getWxlx() == null) ? 0 : getWxlx().hashCode());
        result = prime * result + ((getShenqr() == null) ? 0 : getShenqr().hashCode());
        result = prime * result + ((getFmr() == null) ? 0 : getFmr().hashCode());
        result = prime * result + ((getSqrdz() == null) ? 0 : getSqrdz().hashCode());
        result = prime * result + ((getDlr() == null) ? 0 : getDlr().hashCode());
        result = prime * result + ((getDljg() == null) ? 0 : getDljg().hashCode());
        result = prime * result + ((getGbdm() == null) ? 0 : getGbdm().hashCode());
        result = prime * result + ((getIpcflh() == null) ? 0 : getIpcflh().hashCode());
        result = prime * result + ((getCpcflh() == null) ? 0 : getCpcflh().hashCode());
        result = prime * result + ((getLjnflh() == null) ? 0 : getLjnflh().hashCode());
        result = prime * result + ((getYxqh() == null) ? 0 : getYxqh().hashCode());
        result = prime * result + ((getYxqr() == null) ? 0 : getYxqr().hashCode());
        result = prime * result + ((getDqflzt() == null) ? 0 : getDqflzt().hashCode());
        result = prime * result + ((getFlztlsxx() == null) ? 0 : getFlztlsxx().hashCode());
        result = prime * result + ((getFlztggrq() == null) ? 0 : getFlztggrq().hashCode());
        result = prime * result + ((getFlztyj() == null) ? 0 : getFlztyj().hashCode());
        result = prime * result + ((getFlztej() == null) ? 0 : getFlztej().hashCode());
        result = prime * result + ((getShouqr() == null) ? 0 : getShouqr().hashCode());
        result = prime * result + ((getSqggh() == null) ? 0 : getSqggh().hashCode());
        result = prime * result + ((getZsh() == null) ? 0 : getZsh().hashCode());
        result = prime * result + ((getZlqr() == null) ? 0 : getZlqr().hashCode());
        result = prime * result + ((getZlh() == null) ? 0 : getZlh().hashCode());
        result = prime * result + ((getQlyq() == null) ? 0 : getQlyq().hashCode());
        result = prime * result + ((getZlpdf() == null) ? 0 : getZlpdf().hashCode());
        result = prime * result + ((getScyjtzsfwr() == null) ? 0 : getScyjtzsfwr().hashCode());
        result = prime * result + ((getScyjdfr() == null) ? 0 : getScyjdfr().hashCode());
        result = prime * result + ((getScyjbzr() == null) ? 0 : getScyjbzr().hashCode());
        result = prime * result + ((getBztzffwr() == null) ? 0 : getBztzffwr().hashCode());
        result = prime * result + ((getBhtzsfwr() == null) ? 0 : getBhtzsfwr().hashCode());
        result = prime * result + ((getFsqqr() == null) ? 0 : getFsqqr().hashCode());
        result = prime * result + ((getFsslfwr() == null) ? 0 : getFsslfwr().hashCode());
        result = prime * result + ((getDfgcwj() == null) ? 0 : getDfgcwj().hashCode());
        result = prime * result + ((getSqbz() == null) ? 0 : getSqbz().hashCode());
        result = prime * result + ((getRksj() == null) ? 0 : getRksj().hashCode());
        result = prime * result + ((getGmjjhyml() == null) ? 0 : getGmjjhyml().hashCode());
        result = prime * result + ((getGmjjhydl() == null) ? 0 : getGmjjhydl().hashCode());
        result = prime * result + ((getGmjjhyzl() == null) ? 0 : getGmjjhyzl().hashCode());
        result = prime * result + ((getZxcyyj() == null) ? 0 : getZxcyyj().hashCode());
        result = prime * result + ((getZxcyej() == null) ? 0 : getZxcyej().hashCode());
        result = prime * result + ((getZxcysj() == null) ? 0 : getZxcysj().hashCode());
        result = prime * result + ((getByzcs() == null) ? 0 : getByzcs().hashCode());
        result = prime * result + ((getBfmryycs() == null) ? 0 : getBfmryycs().hashCode());
        result = prime * result + ((getBscyyycs() == null) ? 0 : getBscyyycs().hashCode());
        result = prime * result + ((getZycs() == null) ? 0 : getZycs().hashCode());
        result = prime * result + ((getTycs() == null) ? 0 : getTycs().hashCode());
        result = prime * result + ((getSqrdm() == null) ? 0 : getSqrdm().hashCode());
        result = prime * result + ((getJghdmc() == null) ? 0 : getJghdmc().hashCode());
        result = prime * result + ((getJswthyyxg() == null) ? 0 : getJswthyyxg().hashCode());
        result = prime * result + ((getFmdhhxfa() == null) ? 0 : getFmdhhxfa().hashCode());
        result = prime * result + ((getYt() == null) ? 0 : getYt().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getCreateUserId() == null) ? 0 : getCreateUserId().hashCode());
        result = prime * result + ((getRemarks() == null) ? 0 : getRemarks().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getGj() == null) ? 0 : getGj().hashCode());
        result = prime * result + ((getDefine1() == null) ? 0 : getDefine1().hashCode());
        result = prime * result + ((getDefine2() == null) ? 0 : getDefine2().hashCode());
        result = prime * result + ((getDefine3() == null) ? 0 : getDefine3().hashCode());
        result = prime * result + ((getDefine4() == null) ? 0 : getDefine4().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", dataId=").append(dataId);
        sb.append(", tfmTypeId=").append(tfmTypeId);
        sb.append(", typeCode=").append(typeCode);
        sb.append(", typeName=").append(typeName);
        sb.append(", parentId=").append(parentId);
        sb.append(", parentCode=").append(parentCode);
        sb.append(", isParent=").append(isParent);
        sb.append(", typeIndex=").append(typeIndex);
        sb.append(", sqh=").append(sqh);
        sb.append(", sqri=").append(sqri);
        sb.append(", fmmc=").append(fmmc);
        sb.append(", zhy=").append(zhy);
        sb.append(", gkh=").append(gkh);
        sb.append(", gkr=").append(gkr);
        sb.append(", wxlx=").append(wxlx);
        sb.append(", shenqr=").append(shenqr);
        sb.append(", fmr=").append(fmr);
        sb.append(", sqrdz=").append(sqrdz);
        sb.append(", dlr=").append(dlr);
        sb.append(", dljg=").append(dljg);
        sb.append(", gbdm=").append(gbdm);
        sb.append(", ipcflh=").append(ipcflh);
        sb.append(", cpcflh=").append(cpcflh);
        sb.append(", ljnflh=").append(ljnflh);
        sb.append(", yxqh=").append(yxqh);
        sb.append(", yxqr=").append(yxqr);
        sb.append(", dqflzt=").append(dqflzt);
        sb.append(", flztlsxx=").append(flztlsxx);
        sb.append(", flztggrq=").append(flztggrq);
        sb.append(", flztyj=").append(flztyj);
        sb.append(", flztej=").append(flztej);
        sb.append(", shouqr=").append(shouqr);
        sb.append(", sqggh=").append(sqggh);
        sb.append(", zsh=").append(zsh);
        sb.append(", zlqr=").append(zlqr);
        sb.append(", zlh=").append(zlh);
        sb.append(", qlyq=").append(qlyq);
        sb.append(", zlpdf=").append(zlpdf);
        sb.append(", scyjtzsfwr=").append(scyjtzsfwr);
        sb.append(", scyjdfr=").append(scyjdfr);
        sb.append(", scyjbzr=").append(scyjbzr);
        sb.append(", bztzffwr=").append(bztzffwr);
        sb.append(", bhtzsfwr=").append(bhtzsfwr);
        sb.append(", fsqqr=").append(fsqqr);
        sb.append(", fsslfwr=").append(fsslfwr);
        sb.append(", dfgcwj=").append(dfgcwj);
        sb.append(", sqbz=").append(sqbz);
        sb.append(", rksj=").append(rksj);
        sb.append(", gmjjhyml=").append(gmjjhyml);
        sb.append(", gmjjhydl=").append(gmjjhydl);
        sb.append(", gmjjhyzl=").append(gmjjhyzl);
        sb.append(", zxcyyj=").append(zxcyyj);
        sb.append(", zxcyej=").append(zxcyej);
        sb.append(", zxcysj=").append(zxcysj);
        sb.append(", byzcs=").append(byzcs);
        sb.append(", bfmryycs=").append(bfmryycs);
        sb.append(", bscyyycs=").append(bscyyycs);
        sb.append(", zycs=").append(zycs);
        sb.append(", tycs=").append(tycs);
        sb.append(", sqrdm=").append(sqrdm);
        sb.append(", jghdmc=").append(jghdmc);
        sb.append(", jswthyyxg=").append(jswthyyxg);
        sb.append(", fmdhhxfa=").append(fmdhhxfa);
        sb.append(", yt=").append(yt);
        sb.append(", createDate=").append(createDate);
        sb.append(", createUserId=").append(createUserId);
        sb.append(", remarks=").append(remarks);
        sb.append(", status=").append(status);
        sb.append(", gj=").append(gj);
        sb.append(", define1=").append(define1);
        sb.append(", define2=").append(define2);
        sb.append(", define3=").append(define3);
        sb.append(", define4=").append(define4);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}