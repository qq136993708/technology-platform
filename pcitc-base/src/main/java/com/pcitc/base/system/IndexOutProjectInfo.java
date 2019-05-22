package com.pcitc.base.system;

import java.util.Date;
import com.pcitc.base.common.DataEntity;


import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
/**
 * <p>实体类</p>
 * <p>Table: index_out_project_info - 首页-科研项目</p>
 *
 * @since 2019-05-22 03:38:17
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IndexOutProjectInfo  extends DataEntity implements Serializable  {

    private static final long serialVersionUID = 1L;

    /** data_id -  */
    private String dataId;

    /** tfm_type_id - 分类id */
    private String tfmTypeId;

    /** nd - 年度 */
    private String nd;

    /** xmid - 项目id，sap抽取的数据和data_id一致 */
    private String xmid;

    /** hth - 合同号 */
    private String hth;

    /** xmmc - 项目名称 */
    private String xmmc;

    /** xmjb -  */
    private String xmjb;

    /** ysnd - 预算的年度 */
    private String ysnd;

    /** yshf - 实际花费 */
    private String yshf;

    /** ysxd - 本年下达经费（报销系统） */
    private String ysxd;

    /** yszbxje - 预算资本性金额 */
    private String yszbxje;

    /** ysfyxje - 预算费用性金额 */
    private String ysfyxje;

    /** ysje - 本年预算金额 */
    private String ysje;

    /** jf - 项目经费总额 */
    private String jf;

    /** fwdxbm - 服务对象编码 */
    private String fwdxbm;

    /** fwdx - 服务对象 */
    private String fwdx;

    /** zylbbm - 专业类别编码 */
    private String zylbbm;

    /** zylb - 专业类别 */
    private String zylb;

    /** fzdwbm - 负责单位编码 */
    private String fzdwbm;

    /** fzdw - 负责单位 */
    private String fzdw;

    /** jtfzdwbm - 具体负责单位编码 */
    private String jtfzdwbm;

    /** jtfzdw - 具体负责单位 */
    private String jtfzdw;

    /** fzryx -  */
    private String fzryx;

    /** fzrdh -  */
    private String fzrdh;

    /** fzrxm - 负责人姓名 */
    private String fzrxm;

    /** lxrdh -  */
    private String lxrdh;

    /** lxryx -  */
    private String lxryx;

    /** lxrxm -  */
    private String lxrxm;

    /** jssxxm - 技术首席姓名 */
    private String jssxxm;

    /** jssj - 结束时间 */
    private String jssj;

    /** kssj - 开始时间 */
    private String kssj;

    /** yjsj - 研究时间 */
    private String yjsj;

    /** zyly - 专业来源 */
    private String zyly;

    /** zysx - 专业属性 */
    private String zysx;

    /** sjid -  */
    private String sjid;

    /** lxbj - 立项背景 */
    private String lxbj;

    /** yjnr - 研究内容 */
    private String yjnr;

    /** jdap - 进度安排 */
    private String jdap;

    /** yjmb - 研究目标 */
    private String yjmb;

    /** create_date - 创建时间 */
    private Date createDate;

    /** create_person - 创建人 */
    private String createPerson;

    /** status - 状态 */
    private String status;

    /** update_date - 修改时间 */
    private Date updateDate;

    /** project_id - 项目(课题)id */
    private String projectId;

    /** parent_project_id - 父节点id */
    private String parentProjectId;

    /** project_type - 0独立项目，1项目组，2课题（隶属于某个项目组） */
    private String projectType;

    /** erp_project_code - erp中课题编码多个以逗号隔开 */
    private String erpProjectCode;

    /** erp_project_name - erp中课题名称多个以逗号隔开 */
    private String erpProjectName;

    /** project_scope - 项目范畴，新开课题、结转课题 */
    private String projectScope;

    /** project_level - 项目或课题级别，1、科研国拨；2、科研横向课题；3、科研纵向课题；4、科研院控课题 */
    private String projectLevel;

    /** project_property - 项目属性。1、国家项目；2、重大专项；3、重点；4、其他；5、十条龙 */
    private String projectProperty;

    /** project_abc - 项目级别，A、B、C */
    private String projectAbc;

    /** project_source - 项目来源 */
    private String projectSource;

    /** yjsjks -  */
    private String yjsjks;

    /** yjsjjs -  */
    private String yjsjjs;

    /** xmlbbm -  */
    private String xmlbbm;

    /** xmlbmc -  */
    private String xmlbmc;

    /** gsbmmc -  */
    private String gsbmmc;

    /** gsbmbm -  */
    private String gsbmbm;

    /** zycmc - 专业处名称 */
    private String zycmc;

    /** zycbm - 专业处编码 */
    private String zycbm;

    /** fzdwunitcw - 负责单位所属组织机构（细-财务用） */
    private String fzdwunitcw;

    /** fzdwunit - 负责单位对应的机构分类（粗-本质属性，与财务无关） */
    private String fzdwunit;

    /** type_flag - 直属院、盈科、分子公司、集团单位、外部单位等，和合同签订时经费来源有关系 */
    private String typeFlag;

    /** define1 - 资本性项目、费用性项目 */
    private String define1;

    /** define2 - 8大研究院及其他三级单位属性 */
    private String define2;

    /** define3 - sap系统过来的数据,其他系统标识 */
    private String define3;

    /** define4 -  */
    private String define4;

    /** define5 - 各类技术简称 */
    private String define5;

    /** define6 - 十条龙项目，负责单位、协作单位、组长单位等标识 */
    private String define6;

    /** define7 - 预算（当年）是否已经关闭 */
    private String define7;

    /** define8 - 承担单位名称 */
    private String define8;

    /** define9 - 承担单位编码 */
    private String define9;

    /** define10 - 科技部各个处室、各个部 */
    private String define10;

    /** define11 - 经费来源，股份公司、集团公司、资产公司，和合同签订有关系 */
    private String define11;

    /** define12 - 公司性质，和out_unit本质一致，公司本质的属性，和合同没关系 */
    private String define12;

    /** define13 - 十条龙项目附件列表 */
    private String define13;

    /** define14 -  */
    private String define14;

    /** define15 -  */
    private String define15;

    /** define16 -  */
    private String define16;

    /** define17 -  */
    private String define17;

    /** define18 -  */
    private String define18;

    /** define19 -  */
    private String define19;

    /** type_code - 分类编码 */
    private String typeCode;

    /** type_name - 分类名称 */
    private String typeName;

    /** parent_id - 父节点id */
    private String parentId;

    /** parent_code - 父节点编码 */
    private String parentCode;

    /** is_parent - 是否是父亲节点 */
    private String isParent;

    /** type_index - 检索辅助字段 */
    private String typeIndex;


    public String getDataId(){
        return this.dataId;
    }
    public void setDataId(String dataId){
        this.dataId = dataId;
    }

    public String getTfmTypeId(){
        return this.tfmTypeId;
    }
    public void setTfmTypeId(String tfmTypeId){
        this.tfmTypeId = tfmTypeId;
    }

    public String getNd(){
        return this.nd;
    }
    public void setNd(String nd){
        this.nd = nd;
    }

    public String getXmid(){
        return this.xmid;
    }
    public void setXmid(String xmid){
        this.xmid = xmid;
    }

    public String getHth(){
        return this.hth;
    }
    public void setHth(String hth){
        this.hth = hth;
    }

    public String getXmmc(){
        return this.xmmc;
    }
    public void setXmmc(String xmmc){
        this.xmmc = xmmc;
    }

    public String getXmjb(){
        return this.xmjb;
    }
    public void setXmjb(String xmjb){
        this.xmjb = xmjb;
    }

    public String getYsnd(){
        return this.ysnd;
    }
    public void setYsnd(String ysnd){
        this.ysnd = ysnd;
    }

    public String getYshf(){
        return this.yshf;
    }
    public void setYshf(String yshf){
        this.yshf = yshf;
    }

    public String getYsxd(){
        return this.ysxd;
    }
    public void setYsxd(String ysxd){
        this.ysxd = ysxd;
    }

    public String getYszbxje(){
        return this.yszbxje;
    }
    public void setYszbxje(String yszbxje){
        this.yszbxje = yszbxje;
    }

    public String getYsfyxje(){
        return this.ysfyxje;
    }
    public void setYsfyxje(String ysfyxje){
        this.ysfyxje = ysfyxje;
    }

    public String getYsje(){
        return this.ysje;
    }
    public void setYsje(String ysje){
        this.ysje = ysje;
    }

    public String getJf(){
        return this.jf;
    }
    public void setJf(String jf){
        this.jf = jf;
    }

    public String getFwdxbm(){
        return this.fwdxbm;
    }
    public void setFwdxbm(String fwdxbm){
        this.fwdxbm = fwdxbm;
    }

    public String getFwdx(){
        return this.fwdx;
    }
    public void setFwdx(String fwdx){
        this.fwdx = fwdx;
    }

    public String getZylbbm(){
        return this.zylbbm;
    }
    public void setZylbbm(String zylbbm){
        this.zylbbm = zylbbm;
    }

    public String getZylb(){
        return this.zylb;
    }
    public void setZylb(String zylb){
        this.zylb = zylb;
    }

    public String getFzdwbm(){
        return this.fzdwbm;
    }
    public void setFzdwbm(String fzdwbm){
        this.fzdwbm = fzdwbm;
    }

    public String getFzdw(){
        return this.fzdw;
    }
    public void setFzdw(String fzdw){
        this.fzdw = fzdw;
    }

    public String getJtfzdwbm(){
        return this.jtfzdwbm;
    }
    public void setJtfzdwbm(String jtfzdwbm){
        this.jtfzdwbm = jtfzdwbm;
    }

    public String getJtfzdw(){
        return this.jtfzdw;
    }
    public void setJtfzdw(String jtfzdw){
        this.jtfzdw = jtfzdw;
    }

    public String getFzryx(){
        return this.fzryx;
    }
    public void setFzryx(String fzryx){
        this.fzryx = fzryx;
    }

    public String getFzrdh(){
        return this.fzrdh;
    }
    public void setFzrdh(String fzrdh){
        this.fzrdh = fzrdh;
    }

    public String getFzrxm(){
        return this.fzrxm;
    }
    public void setFzrxm(String fzrxm){
        this.fzrxm = fzrxm;
    }

    public String getLxrdh(){
        return this.lxrdh;
    }
    public void setLxrdh(String lxrdh){
        this.lxrdh = lxrdh;
    }

    public String getLxryx(){
        return this.lxryx;
    }
    public void setLxryx(String lxryx){
        this.lxryx = lxryx;
    }

    public String getLxrxm(){
        return this.lxrxm;
    }
    public void setLxrxm(String lxrxm){
        this.lxrxm = lxrxm;
    }

    public String getJssxxm(){
        return this.jssxxm;
    }
    public void setJssxxm(String jssxxm){
        this.jssxxm = jssxxm;
    }

    public String getJssj(){
        return this.jssj;
    }
    public void setJssj(String jssj){
        this.jssj = jssj;
    }

    public String getKssj(){
        return this.kssj;
    }
    public void setKssj(String kssj){
        this.kssj = kssj;
    }

    public String getYjsj(){
        return this.yjsj;
    }
    public void setYjsj(String yjsj){
        this.yjsj = yjsj;
    }

    public String getZyly(){
        return this.zyly;
    }
    public void setZyly(String zyly){
        this.zyly = zyly;
    }

    public String getZysx(){
        return this.zysx;
    }
    public void setZysx(String zysx){
        this.zysx = zysx;
    }

    public String getSjid(){
        return this.sjid;
    }
    public void setSjid(String sjid){
        this.sjid = sjid;
    }

    public String getLxbj(){
        return this.lxbj;
    }
    public void setLxbj(String lxbj){
        this.lxbj = lxbj;
    }

    public String getYjnr(){
        return this.yjnr;
    }
    public void setYjnr(String yjnr){
        this.yjnr = yjnr;
    }

    public String getJdap(){
        return this.jdap;
    }
    public void setJdap(String jdap){
        this.jdap = jdap;
    }

    public String getYjmb(){
        return this.yjmb;
    }
    public void setYjmb(String yjmb){
        this.yjmb = yjmb;
    }

    public Date getCreateDate(){
        return this.createDate;
    }
    public void setCreateDate(Date createDate){
        this.createDate = createDate;
    }

    public String getCreatePerson(){
        return this.createPerson;
    }
    public void setCreatePerson(String createPerson){
        this.createPerson = createPerson;
    }

    public String getStatus(){
        return this.status;
    }
    public void setStatus(String status){
        this.status = status;
    }

    public Date getUpdateDate(){
        return this.updateDate;
    }
    public void setUpdateDate(Date updateDate){
        this.updateDate = updateDate;
    }

    public String getProjectId(){
        return this.projectId;
    }
    public void setProjectId(String projectId){
        this.projectId = projectId;
    }

    public String getParentProjectId(){
        return this.parentProjectId;
    }
    public void setParentProjectId(String parentProjectId){
        this.parentProjectId = parentProjectId;
    }

    public String getProjectType(){
        return this.projectType;
    }
    public void setProjectType(String projectType){
        this.projectType = projectType;
    }

    public String getErpProjectCode(){
        return this.erpProjectCode;
    }
    public void setErpProjectCode(String erpProjectCode){
        this.erpProjectCode = erpProjectCode;
    }

    public String getErpProjectName(){
        return this.erpProjectName;
    }
    public void setErpProjectName(String erpProjectName){
        this.erpProjectName = erpProjectName;
    }

    public String getProjectScope(){
        return this.projectScope;
    }
    public void setProjectScope(String projectScope){
        this.projectScope = projectScope;
    }

    public String getProjectLevel(){
        return this.projectLevel;
    }
    public void setProjectLevel(String projectLevel){
        this.projectLevel = projectLevel;
    }

    public String getProjectProperty(){
        return this.projectProperty;
    }
    public void setProjectProperty(String projectProperty){
        this.projectProperty = projectProperty;
    }

    public String getProjectAbc(){
        return this.projectAbc;
    }
    public void setProjectAbc(String projectAbc){
        this.projectAbc = projectAbc;
    }

    public String getProjectSource(){
        return this.projectSource;
    }
    public void setProjectSource(String projectSource){
        this.projectSource = projectSource;
    }

    public String getYjsjks(){
        return this.yjsjks;
    }
    public void setYjsjks(String yjsjks){
        this.yjsjks = yjsjks;
    }

    public String getYjsjjs(){
        return this.yjsjjs;
    }
    public void setYjsjjs(String yjsjjs){
        this.yjsjjs = yjsjjs;
    }

    public String getXmlbbm(){
        return this.xmlbbm;
    }
    public void setXmlbbm(String xmlbbm){
        this.xmlbbm = xmlbbm;
    }

    public String getXmlbmc(){
        return this.xmlbmc;
    }
    public void setXmlbmc(String xmlbmc){
        this.xmlbmc = xmlbmc;
    }

    public String getGsbmmc(){
        return this.gsbmmc;
    }
    public void setGsbmmc(String gsbmmc){
        this.gsbmmc = gsbmmc;
    }

    public String getGsbmbm(){
        return this.gsbmbm;
    }
    public void setGsbmbm(String gsbmbm){
        this.gsbmbm = gsbmbm;
    }

    public String getZycmc(){
        return this.zycmc;
    }
    public void setZycmc(String zycmc){
        this.zycmc = zycmc;
    }

    public String getZycbm(){
        return this.zycbm;
    }
    public void setZycbm(String zycbm){
        this.zycbm = zycbm;
    }

    public String getFzdwunitcw(){
        return this.fzdwunitcw;
    }
    public void setFzdwunitcw(String fzdwunitcw){
        this.fzdwunitcw = fzdwunitcw;
    }

    public String getFzdwunit(){
        return this.fzdwunit;
    }
    public void setFzdwunit(String fzdwunit){
        this.fzdwunit = fzdwunit;
    }

    public String getTypeFlag(){
        return this.typeFlag;
    }
    public void setTypeFlag(String typeFlag){
        this.typeFlag = typeFlag;
    }

    public String getDefine1(){
        return this.define1;
    }
    public void setDefine1(String define1){
        this.define1 = define1;
    }

    public String getDefine2(){
        return this.define2;
    }
    public void setDefine2(String define2){
        this.define2 = define2;
    }

    public String getDefine3(){
        return this.define3;
    }
    public void setDefine3(String define3){
        this.define3 = define3;
    }

    public String getDefine4(){
        return this.define4;
    }
    public void setDefine4(String define4){
        this.define4 = define4;
    }

    public String getDefine5(){
        return this.define5;
    }
    public void setDefine5(String define5){
        this.define5 = define5;
    }

    public String getDefine6(){
        return this.define6;
    }
    public void setDefine6(String define6){
        this.define6 = define6;
    }

    public String getDefine7(){
        return this.define7;
    }
    public void setDefine7(String define7){
        this.define7 = define7;
    }

    public String getDefine8(){
        return this.define8;
    }
    public void setDefine8(String define8){
        this.define8 = define8;
    }

    public String getDefine9(){
        return this.define9;
    }
    public void setDefine9(String define9){
        this.define9 = define9;
    }

    public String getDefine10(){
        return this.define10;
    }
    public void setDefine10(String define10){
        this.define10 = define10;
    }

    public String getDefine11(){
        return this.define11;
    }
    public void setDefine11(String define11){
        this.define11 = define11;
    }

    public String getDefine12(){
        return this.define12;
    }
    public void setDefine12(String define12){
        this.define12 = define12;
    }

    public String getDefine13(){
        return this.define13;
    }
    public void setDefine13(String define13){
        this.define13 = define13;
    }

    public String getDefine14(){
        return this.define14;
    }
    public void setDefine14(String define14){
        this.define14 = define14;
    }

    public String getDefine15(){
        return this.define15;
    }
    public void setDefine15(String define15){
        this.define15 = define15;
    }

    public String getDefine16(){
        return this.define16;
    }
    public void setDefine16(String define16){
        this.define16 = define16;
    }

    public String getDefine17(){
        return this.define17;
    }
    public void setDefine17(String define17){
        this.define17 = define17;
    }

    public String getDefine18(){
        return this.define18;
    }
    public void setDefine18(String define18){
        this.define18 = define18;
    }

    public String getDefine19(){
        return this.define19;
    }
    public void setDefine19(String define19){
        this.define19 = define19;
    }

    public String getTypeCode(){
        return this.typeCode;
    }
    public void setTypeCode(String typeCode){
        this.typeCode = typeCode;
    }

    public String getTypeName(){
        return this.typeName;
    }
    public void setTypeName(String typeName){
        this.typeName = typeName;
    }

    public String getParentId(){
        return this.parentId;
    }
    public void setParentId(String parentId){
        this.parentId = parentId;
    }

    public String getParentCode(){
        return this.parentCode;
    }
    public void setParentCode(String parentCode){
        this.parentCode = parentCode;
    }

    public String getIsParent(){
        return this.isParent;
    }
    public void setIsParent(String isParent){
        this.isParent = isParent;
    }

    public String getTypeIndex(){
        return this.typeIndex;
    }
    public void setTypeIndex(String typeIndex){
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

IndexOutProjectInfo other = (IndexOutProjectInfo) that;


return
    (this.getDataId() == null ? other.getDataId() == null : this.getDataId().equals(other.getDataId()))&&
    
    (this.getTfmTypeId() == null ? other.getTfmTypeId() == null : this.getTfmTypeId().equals(other.getTfmTypeId()))&&
    
    (this.getNd() == null ? other.getNd() == null : this.getNd().equals(other.getNd()))&&
    
    (this.getXmid() == null ? other.getXmid() == null : this.getXmid().equals(other.getXmid()))&&
    
    (this.getHth() == null ? other.getHth() == null : this.getHth().equals(other.getHth()))&&
    
    (this.getXmmc() == null ? other.getXmmc() == null : this.getXmmc().equals(other.getXmmc()))&&
    
    (this.getXmjb() == null ? other.getXmjb() == null : this.getXmjb().equals(other.getXmjb()))&&
    
    (this.getYsnd() == null ? other.getYsnd() == null : this.getYsnd().equals(other.getYsnd()))&&
    
    (this.getYshf() == null ? other.getYshf() == null : this.getYshf().equals(other.getYshf()))&&
    
    (this.getYsxd() == null ? other.getYsxd() == null : this.getYsxd().equals(other.getYsxd()))&&
    
    (this.getYszbxje() == null ? other.getYszbxje() == null : this.getYszbxje().equals(other.getYszbxje()))&&
    
    (this.getYsfyxje() == null ? other.getYsfyxje() == null : this.getYsfyxje().equals(other.getYsfyxje()))&&
    
    (this.getYsje() == null ? other.getYsje() == null : this.getYsje().equals(other.getYsje()))&&
    
    (this.getJf() == null ? other.getJf() == null : this.getJf().equals(other.getJf()))&&
    
    (this.getFwdxbm() == null ? other.getFwdxbm() == null : this.getFwdxbm().equals(other.getFwdxbm()))&&
    
    (this.getFwdx() == null ? other.getFwdx() == null : this.getFwdx().equals(other.getFwdx()))&&
    
    (this.getZylbbm() == null ? other.getZylbbm() == null : this.getZylbbm().equals(other.getZylbbm()))&&
    
    (this.getZylb() == null ? other.getZylb() == null : this.getZylb().equals(other.getZylb()))&&
    
    (this.getFzdwbm() == null ? other.getFzdwbm() == null : this.getFzdwbm().equals(other.getFzdwbm()))&&
    
    (this.getFzdw() == null ? other.getFzdw() == null : this.getFzdw().equals(other.getFzdw()))&&
    
    (this.getJtfzdwbm() == null ? other.getJtfzdwbm() == null : this.getJtfzdwbm().equals(other.getJtfzdwbm()))&&
    
    (this.getJtfzdw() == null ? other.getJtfzdw() == null : this.getJtfzdw().equals(other.getJtfzdw()))&&
    
    (this.getFzryx() == null ? other.getFzryx() == null : this.getFzryx().equals(other.getFzryx()))&&
    
    (this.getFzrdh() == null ? other.getFzrdh() == null : this.getFzrdh().equals(other.getFzrdh()))&&
    
    (this.getFzrxm() == null ? other.getFzrxm() == null : this.getFzrxm().equals(other.getFzrxm()))&&
    
    (this.getLxrdh() == null ? other.getLxrdh() == null : this.getLxrdh().equals(other.getLxrdh()))&&
    
    (this.getLxryx() == null ? other.getLxryx() == null : this.getLxryx().equals(other.getLxryx()))&&
    
    (this.getLxrxm() == null ? other.getLxrxm() == null : this.getLxrxm().equals(other.getLxrxm()))&&
    
    (this.getJssxxm() == null ? other.getJssxxm() == null : this.getJssxxm().equals(other.getJssxxm()))&&
    
    (this.getJssj() == null ? other.getJssj() == null : this.getJssj().equals(other.getJssj()))&&
    
    (this.getKssj() == null ? other.getKssj() == null : this.getKssj().equals(other.getKssj()))&&
    
    (this.getYjsj() == null ? other.getYjsj() == null : this.getYjsj().equals(other.getYjsj()))&&
    
    (this.getZyly() == null ? other.getZyly() == null : this.getZyly().equals(other.getZyly()))&&
    
    (this.getZysx() == null ? other.getZysx() == null : this.getZysx().equals(other.getZysx()))&&
    
    (this.getSjid() == null ? other.getSjid() == null : this.getSjid().equals(other.getSjid()))&&
    
    (this.getLxbj() == null ? other.getLxbj() == null : this.getLxbj().equals(other.getLxbj()))&&
    
    (this.getYjnr() == null ? other.getYjnr() == null : this.getYjnr().equals(other.getYjnr()))&&
    
    (this.getJdap() == null ? other.getJdap() == null : this.getJdap().equals(other.getJdap()))&&
    
    (this.getYjmb() == null ? other.getYjmb() == null : this.getYjmb().equals(other.getYjmb()))&&
    
    (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))&&
    
    (this.getCreatePerson() == null ? other.getCreatePerson() == null : this.getCreatePerson().equals(other.getCreatePerson()))&&
    
    (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))&&
    
    (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()))&&
    
    (this.getProjectId() == null ? other.getProjectId() == null : this.getProjectId().equals(other.getProjectId()))&&
    
    (this.getParentProjectId() == null ? other.getParentProjectId() == null : this.getParentProjectId().equals(other.getParentProjectId()))&&
    
    (this.getProjectType() == null ? other.getProjectType() == null : this.getProjectType().equals(other.getProjectType()))&&
    
    (this.getErpProjectCode() == null ? other.getErpProjectCode() == null : this.getErpProjectCode().equals(other.getErpProjectCode()))&&
    
    (this.getErpProjectName() == null ? other.getErpProjectName() == null : this.getErpProjectName().equals(other.getErpProjectName()))&&
    
    (this.getProjectScope() == null ? other.getProjectScope() == null : this.getProjectScope().equals(other.getProjectScope()))&&
    
    (this.getProjectLevel() == null ? other.getProjectLevel() == null : this.getProjectLevel().equals(other.getProjectLevel()))&&
    
    (this.getProjectProperty() == null ? other.getProjectProperty() == null : this.getProjectProperty().equals(other.getProjectProperty()))&&
    
    (this.getProjectAbc() == null ? other.getProjectAbc() == null : this.getProjectAbc().equals(other.getProjectAbc()))&&
    
    (this.getProjectSource() == null ? other.getProjectSource() == null : this.getProjectSource().equals(other.getProjectSource()))&&
    
    (this.getYjsjks() == null ? other.getYjsjks() == null : this.getYjsjks().equals(other.getYjsjks()))&&
    
    (this.getYjsjjs() == null ? other.getYjsjjs() == null : this.getYjsjjs().equals(other.getYjsjjs()))&&
    
    (this.getXmlbbm() == null ? other.getXmlbbm() == null : this.getXmlbbm().equals(other.getXmlbbm()))&&
    
    (this.getXmlbmc() == null ? other.getXmlbmc() == null : this.getXmlbmc().equals(other.getXmlbmc()))&&
    
    (this.getGsbmmc() == null ? other.getGsbmmc() == null : this.getGsbmmc().equals(other.getGsbmmc()))&&
    
    (this.getGsbmbm() == null ? other.getGsbmbm() == null : this.getGsbmbm().equals(other.getGsbmbm()))&&
    
    (this.getZycmc() == null ? other.getZycmc() == null : this.getZycmc().equals(other.getZycmc()))&&
    
    (this.getZycbm() == null ? other.getZycbm() == null : this.getZycbm().equals(other.getZycbm()))&&
    
    (this.getFzdwunitcw() == null ? other.getFzdwunitcw() == null : this.getFzdwunitcw().equals(other.getFzdwunitcw()))&&
    
    (this.getFzdwunit() == null ? other.getFzdwunit() == null : this.getFzdwunit().equals(other.getFzdwunit()))&&
    
    (this.getTypeFlag() == null ? other.getTypeFlag() == null : this.getTypeFlag().equals(other.getTypeFlag()))&&
    
    (this.getDefine1() == null ? other.getDefine1() == null : this.getDefine1().equals(other.getDefine1()))&&
    
    (this.getDefine2() == null ? other.getDefine2() == null : this.getDefine2().equals(other.getDefine2()))&&
    
    (this.getDefine3() == null ? other.getDefine3() == null : this.getDefine3().equals(other.getDefine3()))&&
    
    (this.getDefine4() == null ? other.getDefine4() == null : this.getDefine4().equals(other.getDefine4()))&&
    
    (this.getDefine5() == null ? other.getDefine5() == null : this.getDefine5().equals(other.getDefine5()))&&
    
    (this.getDefine6() == null ? other.getDefine6() == null : this.getDefine6().equals(other.getDefine6()))&&
    
    (this.getDefine7() == null ? other.getDefine7() == null : this.getDefine7().equals(other.getDefine7()))&&
    
    (this.getDefine8() == null ? other.getDefine8() == null : this.getDefine8().equals(other.getDefine8()))&&
    
    (this.getDefine9() == null ? other.getDefine9() == null : this.getDefine9().equals(other.getDefine9()))&&
    
    (this.getDefine10() == null ? other.getDefine10() == null : this.getDefine10().equals(other.getDefine10()))&&
    
    (this.getDefine11() == null ? other.getDefine11() == null : this.getDefine11().equals(other.getDefine11()))&&
    
    (this.getDefine12() == null ? other.getDefine12() == null : this.getDefine12().equals(other.getDefine12()))&&
    
    (this.getDefine13() == null ? other.getDefine13() == null : this.getDefine13().equals(other.getDefine13()))&&
    
    (this.getDefine14() == null ? other.getDefine14() == null : this.getDefine14().equals(other.getDefine14()))&&
    
    (this.getDefine15() == null ? other.getDefine15() == null : this.getDefine15().equals(other.getDefine15()))&&
    
    (this.getDefine16() == null ? other.getDefine16() == null : this.getDefine16().equals(other.getDefine16()))&&
    
    (this.getDefine17() == null ? other.getDefine17() == null : this.getDefine17().equals(other.getDefine17()))&&
    
    (this.getDefine18() == null ? other.getDefine18() == null : this.getDefine18().equals(other.getDefine18()))&&
    
    (this.getDefine19() == null ? other.getDefine19() == null : this.getDefine19().equals(other.getDefine19()))&&
    
    (this.getTypeCode() == null ? other.getTypeCode() == null : this.getTypeCode().equals(other.getTypeCode()))&&
    
    (this.getTypeName() == null ? other.getTypeName() == null : this.getTypeName().equals(other.getTypeName()))&&
    
    (this.getParentId() == null ? other.getParentId() == null : this.getParentId().equals(other.getParentId()))&&
    
    (this.getParentCode() == null ? other.getParentCode() == null : this.getParentCode().equals(other.getParentCode()))&&
    
    (this.getIsParent() == null ? other.getIsParent() == null : this.getIsParent().equals(other.getIsParent()))&&
    
    (this.getTypeIndex() == null ? other.getTypeIndex() == null : this.getTypeIndex().equals(other.getTypeIndex()));
}

@Override
public int hashCode() {
final int prime = 31;
int result = 1;
result = prime * result + ((getDataId() == null) ? 0 : getDataId().hashCode());
result = prime * result + ((getTfmTypeId() == null) ? 0 : getTfmTypeId().hashCode());
result = prime * result + ((getNd() == null) ? 0 : getNd().hashCode());
result = prime * result + ((getXmid() == null) ? 0 : getXmid().hashCode());
result = prime * result + ((getHth() == null) ? 0 : getHth().hashCode());
result = prime * result + ((getXmmc() == null) ? 0 : getXmmc().hashCode());
result = prime * result + ((getXmjb() == null) ? 0 : getXmjb().hashCode());
result = prime * result + ((getYsnd() == null) ? 0 : getYsnd().hashCode());
result = prime * result + ((getYshf() == null) ? 0 : getYshf().hashCode());
result = prime * result + ((getYsxd() == null) ? 0 : getYsxd().hashCode());
result = prime * result + ((getYszbxje() == null) ? 0 : getYszbxje().hashCode());
result = prime * result + ((getYsfyxje() == null) ? 0 : getYsfyxje().hashCode());
result = prime * result + ((getYsje() == null) ? 0 : getYsje().hashCode());
result = prime * result + ((getJf() == null) ? 0 : getJf().hashCode());
result = prime * result + ((getFwdxbm() == null) ? 0 : getFwdxbm().hashCode());
result = prime * result + ((getFwdx() == null) ? 0 : getFwdx().hashCode());
result = prime * result + ((getZylbbm() == null) ? 0 : getZylbbm().hashCode());
result = prime * result + ((getZylb() == null) ? 0 : getZylb().hashCode());
result = prime * result + ((getFzdwbm() == null) ? 0 : getFzdwbm().hashCode());
result = prime * result + ((getFzdw() == null) ? 0 : getFzdw().hashCode());
result = prime * result + ((getJtfzdwbm() == null) ? 0 : getJtfzdwbm().hashCode());
result = prime * result + ((getJtfzdw() == null) ? 0 : getJtfzdw().hashCode());
result = prime * result + ((getFzryx() == null) ? 0 : getFzryx().hashCode());
result = prime * result + ((getFzrdh() == null) ? 0 : getFzrdh().hashCode());
result = prime * result + ((getFzrxm() == null) ? 0 : getFzrxm().hashCode());
result = prime * result + ((getLxrdh() == null) ? 0 : getLxrdh().hashCode());
result = prime * result + ((getLxryx() == null) ? 0 : getLxryx().hashCode());
result = prime * result + ((getLxrxm() == null) ? 0 : getLxrxm().hashCode());
result = prime * result + ((getJssxxm() == null) ? 0 : getJssxxm().hashCode());
result = prime * result + ((getJssj() == null) ? 0 : getJssj().hashCode());
result = prime * result + ((getKssj() == null) ? 0 : getKssj().hashCode());
result = prime * result + ((getYjsj() == null) ? 0 : getYjsj().hashCode());
result = prime * result + ((getZyly() == null) ? 0 : getZyly().hashCode());
result = prime * result + ((getZysx() == null) ? 0 : getZysx().hashCode());
result = prime * result + ((getSjid() == null) ? 0 : getSjid().hashCode());
result = prime * result + ((getLxbj() == null) ? 0 : getLxbj().hashCode());
result = prime * result + ((getYjnr() == null) ? 0 : getYjnr().hashCode());
result = prime * result + ((getJdap() == null) ? 0 : getJdap().hashCode());
result = prime * result + ((getYjmb() == null) ? 0 : getYjmb().hashCode());
result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
result = prime * result + ((getCreatePerson() == null) ? 0 : getCreatePerson().hashCode());
result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
result = prime * result + ((getProjectId() == null) ? 0 : getProjectId().hashCode());
result = prime * result + ((getParentProjectId() == null) ? 0 : getParentProjectId().hashCode());
result = prime * result + ((getProjectType() == null) ? 0 : getProjectType().hashCode());
result = prime * result + ((getErpProjectCode() == null) ? 0 : getErpProjectCode().hashCode());
result = prime * result + ((getErpProjectName() == null) ? 0 : getErpProjectName().hashCode());
result = prime * result + ((getProjectScope() == null) ? 0 : getProjectScope().hashCode());
result = prime * result + ((getProjectLevel() == null) ? 0 : getProjectLevel().hashCode());
result = prime * result + ((getProjectProperty() == null) ? 0 : getProjectProperty().hashCode());
result = prime * result + ((getProjectAbc() == null) ? 0 : getProjectAbc().hashCode());
result = prime * result + ((getProjectSource() == null) ? 0 : getProjectSource().hashCode());
result = prime * result + ((getYjsjks() == null) ? 0 : getYjsjks().hashCode());
result = prime * result + ((getYjsjjs() == null) ? 0 : getYjsjjs().hashCode());
result = prime * result + ((getXmlbbm() == null) ? 0 : getXmlbbm().hashCode());
result = prime * result + ((getXmlbmc() == null) ? 0 : getXmlbmc().hashCode());
result = prime * result + ((getGsbmmc() == null) ? 0 : getGsbmmc().hashCode());
result = prime * result + ((getGsbmbm() == null) ? 0 : getGsbmbm().hashCode());
result = prime * result + ((getZycmc() == null) ? 0 : getZycmc().hashCode());
result = prime * result + ((getZycbm() == null) ? 0 : getZycbm().hashCode());
result = prime * result + ((getFzdwunitcw() == null) ? 0 : getFzdwunitcw().hashCode());
result = prime * result + ((getFzdwunit() == null) ? 0 : getFzdwunit().hashCode());
result = prime * result + ((getTypeFlag() == null) ? 0 : getTypeFlag().hashCode());
result = prime * result + ((getDefine1() == null) ? 0 : getDefine1().hashCode());
result = prime * result + ((getDefine2() == null) ? 0 : getDefine2().hashCode());
result = prime * result + ((getDefine3() == null) ? 0 : getDefine3().hashCode());
result = prime * result + ((getDefine4() == null) ? 0 : getDefine4().hashCode());
result = prime * result + ((getDefine5() == null) ? 0 : getDefine5().hashCode());
result = prime * result + ((getDefine6() == null) ? 0 : getDefine6().hashCode());
result = prime * result + ((getDefine7() == null) ? 0 : getDefine7().hashCode());
result = prime * result + ((getDefine8() == null) ? 0 : getDefine8().hashCode());
result = prime * result + ((getDefine9() == null) ? 0 : getDefine9().hashCode());
result = prime * result + ((getDefine10() == null) ? 0 : getDefine10().hashCode());
result = prime * result + ((getDefine11() == null) ? 0 : getDefine11().hashCode());
result = prime * result + ((getDefine12() == null) ? 0 : getDefine12().hashCode());
result = prime * result + ((getDefine13() == null) ? 0 : getDefine13().hashCode());
result = prime * result + ((getDefine14() == null) ? 0 : getDefine14().hashCode());
result = prime * result + ((getDefine15() == null) ? 0 : getDefine15().hashCode());
result = prime * result + ((getDefine16() == null) ? 0 : getDefine16().hashCode());
result = prime * result + ((getDefine17() == null) ? 0 : getDefine17().hashCode());
result = prime * result + ((getDefine18() == null) ? 0 : getDefine18().hashCode());
result = prime * result + ((getDefine19() == null) ? 0 : getDefine19().hashCode());
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
sb.append(", tfmTypeId=").append(tfmTypeId);
sb.append(", nd=").append(nd);
sb.append(", xmid=").append(xmid);
sb.append(", hth=").append(hth);
sb.append(", xmmc=").append(xmmc);
sb.append(", xmjb=").append(xmjb);
sb.append(", ysnd=").append(ysnd);
sb.append(", yshf=").append(yshf);
sb.append(", ysxd=").append(ysxd);
sb.append(", yszbxje=").append(yszbxje);
sb.append(", ysfyxje=").append(ysfyxje);
sb.append(", ysje=").append(ysje);
sb.append(", jf=").append(jf);
sb.append(", fwdxbm=").append(fwdxbm);
sb.append(", fwdx=").append(fwdx);
sb.append(", zylbbm=").append(zylbbm);
sb.append(", zylb=").append(zylb);
sb.append(", fzdwbm=").append(fzdwbm);
sb.append(", fzdw=").append(fzdw);
sb.append(", jtfzdwbm=").append(jtfzdwbm);
sb.append(", jtfzdw=").append(jtfzdw);
sb.append(", fzryx=").append(fzryx);
sb.append(", fzrdh=").append(fzrdh);
sb.append(", fzrxm=").append(fzrxm);
sb.append(", lxrdh=").append(lxrdh);
sb.append(", lxryx=").append(lxryx);
sb.append(", lxrxm=").append(lxrxm);
sb.append(", jssxxm=").append(jssxxm);
sb.append(", jssj=").append(jssj);
sb.append(", kssj=").append(kssj);
sb.append(", yjsj=").append(yjsj);
sb.append(", zyly=").append(zyly);
sb.append(", zysx=").append(zysx);
sb.append(", sjid=").append(sjid);
sb.append(", lxbj=").append(lxbj);
sb.append(", yjnr=").append(yjnr);
sb.append(", jdap=").append(jdap);
sb.append(", yjmb=").append(yjmb);
sb.append(", createDate=").append(createDate);
sb.append(", createPerson=").append(createPerson);
sb.append(", status=").append(status);
sb.append(", updateDate=").append(updateDate);
sb.append(", projectId=").append(projectId);
sb.append(", parentProjectId=").append(parentProjectId);
sb.append(", projectType=").append(projectType);
sb.append(", erpProjectCode=").append(erpProjectCode);
sb.append(", erpProjectName=").append(erpProjectName);
sb.append(", projectScope=").append(projectScope);
sb.append(", projectLevel=").append(projectLevel);
sb.append(", projectProperty=").append(projectProperty);
sb.append(", projectAbc=").append(projectAbc);
sb.append(", projectSource=").append(projectSource);
sb.append(", yjsjks=").append(yjsjks);
sb.append(", yjsjjs=").append(yjsjjs);
sb.append(", xmlbbm=").append(xmlbbm);
sb.append(", xmlbmc=").append(xmlbmc);
sb.append(", gsbmmc=").append(gsbmmc);
sb.append(", gsbmbm=").append(gsbmbm);
sb.append(", zycmc=").append(zycmc);
sb.append(", zycbm=").append(zycbm);
sb.append(", fzdwunitcw=").append(fzdwunitcw);
sb.append(", fzdwunit=").append(fzdwunit);
sb.append(", typeFlag=").append(typeFlag);
sb.append(", define1=").append(define1);
sb.append(", define2=").append(define2);
sb.append(", define3=").append(define3);
sb.append(", define4=").append(define4);
sb.append(", define5=").append(define5);
sb.append(", define6=").append(define6);
sb.append(", define7=").append(define7);
sb.append(", define8=").append(define8);
sb.append(", define9=").append(define9);
sb.append(", define10=").append(define10);
sb.append(", define11=").append(define11);
sb.append(", define12=").append(define12);
sb.append(", define13=").append(define13);
sb.append(", define14=").append(define14);
sb.append(", define15=").append(define15);
sb.append(", define16=").append(define16);
sb.append(", define17=").append(define17);
sb.append(", define18=").append(define18);
sb.append(", define19=").append(define19);
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