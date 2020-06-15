package com.pcitc.base.out;

import java.io.Serializable;
import java.util.Date;

public class OutPersonVo implements Serializable{
	
	 private String zjyxlmc;
	 private String zjyxwmc;
	 
	 
	 private String pernr;//人员编号，专家的主键
	 private String zdwbm;//单位编码 
	 private String zdwqc;//单位全称 
	 private String nachn;//姓名
	 private String gesch;//性别
	 private String gbdat;//出生日期
	 private String icnum;//身份证号码
	 private String zdwmc;//单位名称
	 
	 
	 private String zzwjbmc;//职务级别名称
	 private String zzwjbbm;//职务级别编码
	 private String zjyzx;//最高学历
	 private String zjyxlbmn;//最高学历编码
	 
	 private String zprzyjszwjbbm;//聘任专业技术职务级别 编码
	 private String zprzyjszwjbmc;//聘任专业技术职务级别 名称
	 
	 private String zzyjszgmcmc;//专业技术资格名称
	 private String zzyjszgmcbm;//专业技术资格编码
	    
	 
    
    
    
	 
	 
	 private String zhdzlsj;//获得专利时间
	 private String seqnr9009;//序号 
	 private String zfmzlsj;//专利名称
	 private String zzlh;//专利号
	 private String zzlpm;//专利排名
	 
	 
	 
	 private String seqnr9010;//序号 
	 private String zlzmc;//论文、著作名称
	 private String zfbsj;//发表时间
	 private String zzzfs;//著作方式
	 private String zcbsmc;//刊物或出版社名称
	 private String zcbgj;//出版国家
	 private String zlzbz;//备注
	 
	 
	 private String seqnr9007;//序号
	 private String zgccrcdjbm;//高层次人才等级编码 
	 private String zgccrcdjmc;//高层次人才等级名称
	 private String zgccrclb1bm;//高层次人才类别编码 
	 private String zgccrclb1mc;//高层次人才类别名称
	 private String zhjlb;//获奖类别编码
	 private String zhjlbms;//获奖类别名称 
	 private String zhjjb;//获奖级别编码
	 private String zhjjbms;//获奖级别名称
	 private String zsysj;//授予时间
	 private String zsysjStr;
	 
	 
	 
	 
	 
	 private String seqnr9025;//序号
	 private String zjcmc;//奖励或惩罚名称
	 private String zjlzl;//奖励种类
	 private String zjlzlbm;
	 private String zjclb;//奖惩类别
	 private String zjclbbm;
	 private String zjcqkms;//奖惩情况描述
	 private String zjcjb;//奖惩级别
	 private String zjcjbbm;
	 private String zjcpbdw;//奖惩批准单位
	 private String zpzsj;//批准时间
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	public String getZzyjszgmcmc() {
		return zzyjszgmcmc;
	}
	public void setZzyjszgmcmc(String zzyjszgmcmc) {
		this.zzyjszgmcmc = zzyjszgmcmc;
	}
	public String getZzyjszgmcbm() {
		return zzyjszgmcbm;
	}
	public void setZzyjszgmcbm(String zzyjszgmcbm) {
		this.zzyjszgmcbm = zzyjszgmcbm;
	}
	public String getZjyxlbmn() {
		return zjyxlbmn;
	}
	public void setZjyxlbmn(String zjyxlbmn) {
		this.zjyxlbmn = zjyxlbmn;
	}
	public String getZjlzlbm() {
		return zjlzlbm;
	}
	public void setZjlzlbm(String zjlzlbm) {
		this.zjlzlbm = zjlzlbm;
	}
	public String getZjclb() {
		return zjclb;
	}
	public void setZjclb(String zjclb) {
		this.zjclb = zjclb;
	}
	public String getZjclbbm() {
		return zjclbbm;
	}
	public void setZjclbbm(String zjclbbm) {
		this.zjclbbm = zjclbbm;
	}
	public String getZjcjbbm() {
		return zjcjbbm;
	}
	public void setZjcjbbm(String zjcjbbm) {
		this.zjcjbbm = zjcjbbm;
	}
	public String getZpzsj() {
		return zpzsj;
	}
	public void setZpzsj(String zpzsj) {
		this.zpzsj = zpzsj;
	}
	public String getSeqnr9025() {
		return seqnr9025;
	}
	public void setSeqnr9025(String seqnr9025) {
		this.seqnr9025 = seqnr9025;
	}
	public String getZjcmc() {
		return zjcmc;
	}
	public void setZjcmc(String zjcmc) {
		this.zjcmc = zjcmc;
	}
	public String getZjlzl() {
		return zjlzl;
	}
	public void setZjlzl(String zjlzl) {
		this.zjlzl = zjlzl;
	}
	
	public String getZjcqkms() {
		return zjcqkms;
	}
	public void setZjcqkms(String zjcqkms) {
		this.zjcqkms = zjcqkms;
	}
	public String getZjcjb() {
		return zjcjb;
	}
	public void setZjcjb(String zjcjb) {
		this.zjcjb = zjcjb;
	}
	public String getZjcpbdw() {
		return zjcpbdw;
	}
	public void setZjcpbdw(String zjcpbdw) {
		this.zjcpbdw = zjcpbdw;
	}
	public String getZjyxlmc() {
		return zjyxlmc;
	}
	public void setZjyxlmc(String zjyxlmc) {
		this.zjyxlmc = zjyxlmc;
	}
	public String getZjyxwmc() {
		return zjyxwmc;
	}
	public void setZjyxwmc(String zjyxwmc) {
		this.zjyxwmc = zjyxwmc;
	}
	public String getPernr() {
		return pernr;
	}
	public void setPernr(String pernr) {
		this.pernr = pernr;
	}
	public String getZdwbm() {
		return zdwbm;
	}
	public void setZdwbm(String zdwbm) {
		this.zdwbm = zdwbm;
	}
	public String getZdwqc() {
		return zdwqc;
	}
	public void setZdwqc(String zdwqc) {
		this.zdwqc = zdwqc;
	}
	public String getNachn() {
		return nachn;
	}
	public void setNachn(String nachn) {
		this.nachn = nachn;
	}
	public String getGesch() {
		return gesch;
	}
	public void setGesch(String gesch) {
		this.gesch = gesch;
	}
	public String getGbdat() {
		return gbdat;
	}
	public void setGbdat(String gbdat) {
		this.gbdat = gbdat;
	}
	public String getIcnum() {
		return icnum;
	}
	public void setIcnum(String icnum) {
		this.icnum = icnum;
	}
	public String getZdwmc() {
		return zdwmc;
	}
	public void setZdwmc(String zdwmc) {
		this.zdwmc = zdwmc;
	}
	public String getZzwjbmc() {
		return zzwjbmc;
	}
	public void setZzwjbmc(String zzwjbmc) {
		this.zzwjbmc = zzwjbmc;
	}
	public String getZzwjbbm() {
		return zzwjbbm;
	}
	public void setZzwjbbm(String zzwjbbm) {
		this.zzwjbbm = zzwjbbm;
	}
	public String getZjyzx() {
		return zjyzx;
	}
	public void setZjyzx(String zjyzx) {
		this.zjyzx = zjyzx;
	}
	public String getZprzyjszwjbbm() {
		return zprzyjszwjbbm;
	}
	public void setZprzyjszwjbbm(String zprzyjszwjbbm) {
		this.zprzyjszwjbbm = zprzyjszwjbbm;
	}
	public String getZprzyjszwjbmc() {
		return zprzyjszwjbmc;
	}
	public void setZprzyjszwjbmc(String zprzyjszwjbmc) {
		this.zprzyjszwjbmc = zprzyjszwjbmc;
	}
	public String getZhdzlsj() {
		return zhdzlsj;
	}
	public void setZhdzlsj(String zhdzlsj) {
		this.zhdzlsj = zhdzlsj;
	}
	public String getSeqnr9009() {
		return seqnr9009;
	}
	public void setSeqnr9009(String seqnr9009) {
		this.seqnr9009 = seqnr9009;
	}
	public String getZfmzlsj() {
		return zfmzlsj;
	}
	public void setZfmzlsj(String zfmzlsj) {
		this.zfmzlsj = zfmzlsj;
	}
	public String getZzlh() {
		return zzlh;
	}
	public void setZzlh(String zzlh) {
		this.zzlh = zzlh;
	}
	public String getZzlpm() {
		return zzlpm;
	}
	public void setZzlpm(String zzlpm) {
		this.zzlpm = zzlpm;
	}
	public String getSeqnr9010() {
		return seqnr9010;
	}
	public void setSeqnr9010(String seqnr9010) {
		this.seqnr9010 = seqnr9010;
	}
	public String getZlzmc() {
		return zlzmc;
	}
	public void setZlzmc(String zlzmc) {
		this.zlzmc = zlzmc;
	}
	public String getZfbsj() {
		return zfbsj;
	}
	public void setZfbsj(String zfbsj) {
		this.zfbsj = zfbsj;
	}
	public String getZzzfs() {
		return zzzfs;
	}
	public void setZzzfs(String zzzfs) {
		this.zzzfs = zzzfs;
	}
	public String getZcbsmc() {
		return zcbsmc;
	}
	public void setZcbsmc(String zcbsmc) {
		this.zcbsmc = zcbsmc;
	}
	public String getZcbgj() {
		return zcbgj;
	}
	public void setZcbgj(String zcbgj) {
		this.zcbgj = zcbgj;
	}
	public String getZlzbz() {
		return zlzbz;
	}
	public void setZlzbz(String zlzbz) {
		this.zlzbz = zlzbz;
	}
	public String getSeqnr9007() {
		return seqnr9007;
	}
	public void setSeqnr9007(String seqnr9007) {
		this.seqnr9007 = seqnr9007;
	}
	public String getZgccrcdjbm() {
		return zgccrcdjbm;
	}
	public void setZgccrcdjbm(String zgccrcdjbm) {
		this.zgccrcdjbm = zgccrcdjbm;
	}
	public String getZgccrcdjmc() {
		return zgccrcdjmc;
	}
	public void setZgccrcdjmc(String zgccrcdjmc) {
		this.zgccrcdjmc = zgccrcdjmc;
	}
	public String getZgccrclb1bm() {
		return zgccrclb1bm;
	}
	public void setZgccrclb1bm(String zgccrclb1bm) {
		this.zgccrclb1bm = zgccrclb1bm;
	}
	public String getZgccrclb1mc() {
		return zgccrclb1mc;
	}
	public void setZgccrclb1mc(String zgccrclb1mc) {
		this.zgccrclb1mc = zgccrclb1mc;
	}
	public String getZhjlb() {
		return zhjlb;
	}
	public void setZhjlb(String zhjlb) {
		this.zhjlb = zhjlb;
	}
	public String getZhjlbms() {
		return zhjlbms;
	}
	public void setZhjlbms(String zhjlbms) {
		this.zhjlbms = zhjlbms;
	}
	public String getZhjjb() {
		return zhjjb;
	}
	public void setZhjjb(String zhjjb) {
		this.zhjjb = zhjjb;
	}
	public String getZhjjbms() {
		return zhjjbms;
	}
	public void setZhjjbms(String zhjjbms) {
		this.zhjjbms = zhjjbms;
	}
	public String getZsysj() {
		return zsysj;
	}
	public void setZsysj(String zsysj) {
		this.zsysj = zsysj;
	}
	public String getZsysjStr() {
		return zsysjStr;
	}
	public void setZsysjStr(String zsysjStr) {
		this.zsysjStr = zsysjStr;
	}
	 
	 
	
	    
	 
	 
	
	 

}
