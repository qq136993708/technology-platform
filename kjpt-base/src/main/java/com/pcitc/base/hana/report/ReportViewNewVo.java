package com.pcitc.base.hana.report;

import java.io.Serializable;

/**
 * @author:Administrator
 * @date:2018/7/2
 */
public class ReportViewNewVo implements Serializable {
    private static final long serialVersionUID = 1L;

    public ReportViewNewVo() {

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
    private String G0BKT;
    private String G0LTEXT;
    private String G0KHCWB;

    private String G0NAME1;
    private String G0TXT50;
    private String K0QMYE;
    private String G0ZFZHS05;
    private String G0SEGMENT;
    private String G0ZKUNNR;
    private String G0GYS;
    private String G0RBUSA;
    private String G0RFAREA;
    private String G0PRCTR;
    private String G0RACCT;
    private String G0AWTYP;

    private String G0RTCUR;
    private String G0SHKZG;

    public String getG0RTCUR() {
        return G0RTCUR;
    }

    public void setG0RTCUR(String g0RTCUR) {
        G0RTCUR = g0RTCUR;
    }

    public String getG0SHKZG() {
        return G0SHKZG;
    }

    public void setG0SHKZG(String g0SHKZG) {
        G0SHKZG = g0SHKZG;
    }

    public String getG0GSDM() {
        return G0GSDM;
    }

    public void setG0GSDM(String g0GSDM) {
        G0GSDM = g0GSDM;
    }

    public String getG0GJAHR() {
        return G0GJAHR;
    }

    public void setG0GJAHR(String g0GJAHR) {
        G0GJAHR = g0GJAHR;
    }

    private String G0GSDM;
    private String G0GJAHR;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getG0BKT() {
        return G0BKT;
    }

    public void setG0BKT(String g0BKT) {
        G0BKT = g0BKT;
    }

    public String getG0LTEXT() {
        return G0LTEXT;
    }

    public void setG0LTEXT(String g0LTEXT) {
        G0LTEXT = g0LTEXT;
    }

    public String getG0KHCWB() {
        return G0KHCWB;
    }

    public void setG0KHCWB(String g0KHCWB) {
        G0KHCWB = g0KHCWB;
    }

    public String getG0NAME1() {
        return G0NAME1;
    }

    public void setG0NAME1(String g0NAME1) {
        G0NAME1 = g0NAME1;
    }

    public String getG0TXT50() {
        return G0TXT50;
    }

    public void setG0TXT50(String g0TXT50) {
        G0TXT50 = g0TXT50;
    }

    public String getK0QMYE() {
        return K0QMYE;
    }

    public void setK0QMYE(String k0QMYE) {
        K0QMYE = k0QMYE;
    }

    public String getG0ZFZHS05() {
        return G0ZFZHS05;
    }

    public void setG0ZFZHS05(String g0ZFZHS05) {
        G0ZFZHS05 = g0ZFZHS05;
    }

    public String getG0SEGMENT() {
        return G0SEGMENT;
    }

    public void setG0SEGMENT(String g0SEGMENT) {
        G0SEGMENT = g0SEGMENT;
    }

    public String getG0ZKUNNR() {
        return G0ZKUNNR;
    }

    public void setG0ZKUNNR(String g0ZKUNNR) {
        G0ZKUNNR = g0ZKUNNR;
    }

    public String getG0GYS() {
        return G0GYS;
    }

    public void setG0GYS(String g0GYS) {
        G0GYS = g0GYS;
    }

    public String getG0RBUSA() {
        return G0RBUSA;
    }

    public void setG0RBUSA(String g0RBUSA) {
        G0RBUSA = g0RBUSA;
    }

    public String getG0RFAREA() {
        return G0RFAREA;
    }

    public void setG0RFAREA(String g0RFAREA) {
        G0RFAREA = g0RFAREA;
    }

    public String getG0PRCTR() {
        return G0PRCTR;
    }

    public void setG0PRCTR(String g0PRCTR) {
        G0PRCTR = g0PRCTR;
    }

    public String getG0RACCT() {
        return G0RACCT;
    }

    public void setG0RACCT(String g0RACCT) {
        G0RACCT = g0RACCT;
    }

    public String getG0AWTYP() {
        return G0AWTYP;
    }

    public void setG0AWTYP(String g0AWTYP) {
        G0AWTYP = g0AWTYP;
    }
}

