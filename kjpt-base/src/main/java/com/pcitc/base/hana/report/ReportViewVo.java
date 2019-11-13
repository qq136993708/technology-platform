package com.pcitc.base.hana.report;

import java.io.Serializable;

/**
 * @author:Administrator
 * @date:2018/7/2
 */
public class ReportViewVo implements Serializable {
    private static final long serialVersionUID = 1L;

    public ReportViewVo(){

    }

    private String id;

    private String pid;

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    private String index;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    /**
     * 板块
     */
    private String G0BK;
    /**
     * 板块描述
     */
    private String G0BKT;
    /**
     * 二级单位
     */
    private String G0RJDW;
    /**
     * 二级单位描述
     */
    private String G0RJDWT;
    /**
     * 基金中心
     */
    private String G0FISTL;
    /**
     * 基金中心名称
     */
    private String G0BEZEICH;
    /**
     * 公司代码
     */
    private String G0GSDM;
    /**
     * 日历年月
     */
    private String CALMONTH;
    /**
     * 业务范围
     */
    private String G0GSBER;
    /**
     * 数据版本状态
     */
    private String G0BBZT;
    /**
     * 所在状态
     */
    private String G0XMBM;
    /**
     * 修理费预算
     */
    private String K0YSXLF;
    /**
     * 低耗预算
     */
    private String K0YSDH;
    /**
     * 物耗费用
     */
    private String K0YSWH;
    /**
     * 修理费承诺项目金额
     */
    private String K0XLFCNX;
    /**
     * 低耗承诺项金额
     */
    private String K0DHCNX;
    /**
     * 物耗承诺项金额
     */
    private String K0WHCNX;

    public String getK0YSXLF() {
        return K0YSXLF;
    }

    public void setK0YSXLF(String k0YSXLF) {
        K0YSXLF = k0YSXLF;
    }

    public String getK0YSDH() {
        return K0YSDH;
    }

    public void setK0YSDH(String k0YSDH) {
        K0YSDH = k0YSDH;
    }

    public String getK0YSWH() {
        return K0YSWH;
    }

    public void setK0YSWH(String k0YSWH) {
        K0YSWH = k0YSWH;
    }

    public String getK0XLFCNX() {
        return K0XLFCNX;
    }

    public void setK0XLFCNX(String k0XLFCNX) {
        K0XLFCNX = k0XLFCNX;
    }

    public String getK0DHCNX() {
        return K0DHCNX;
    }

    public void setK0DHCNX(String k0DHCNX) {
        K0DHCNX = k0DHCNX;
    }

    public String getK0WHCNX() {
        return K0WHCNX;
    }

    public void setK0WHCNX(String k0WHCNX) {
        K0WHCNX = k0WHCNX;
    }


    public String getG0BK() {
        return G0BK;
    }

    public void setG0BK(String g0BK) {
        G0BK = g0BK;
    }

    public String getG0BKT() {
        return G0BKT;
    }

    public void setG0BKT(String g0BKT) {
        G0BKT = g0BKT;
    }

    public String getG0RJDW() {
        return G0RJDW;
    }

    public void setG0RJDW(String g0RJDW) {
        G0RJDW = g0RJDW;
    }

    public String getG0RJDWT() {
        return G0RJDWT;
    }

    public void setG0RJDWT(String g0RJDWT) {
        G0RJDWT = g0RJDWT;
    }

    public String getG0FISTL() {
        return G0FISTL;
    }

    public void setG0FISTL(String g0FISTL) {
        G0FISTL = g0FISTL;
    }

    public String getG0BEZEICH() {
        return G0BEZEICH;
    }

    public void setG0BEZEICH(String g0BEZEICH) {
        G0BEZEICH = g0BEZEICH;
    }

    public String getG0GSDM() {
        return G0GSDM;
    }

    public void setG0GSDM(String g0GSDM) {
        G0GSDM = g0GSDM;
    }

    public String getCALMONTH() {
        return CALMONTH;
    }

    public void setCALMONTH(String CALMONTH) {
        this.CALMONTH = CALMONTH;
    }

    public String getG0GSBER() {
        return G0GSBER;
    }

    public void setG0GSBER(String g0GSBER) {
        G0GSBER = g0GSBER;
    }

    public String getG0BBZT() {
        return G0BBZT;
    }

    public void setG0BBZT(String g0BBZT) {
        G0BBZT = g0BBZT;
    }

    public String getG0XMBM() {
        return G0XMBM;
    }

    public void setG0XMBM(String g0XMBM) {
        G0XMBM = g0XMBM;
    }
}

