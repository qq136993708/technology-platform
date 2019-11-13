package com.pcitc.service.expert;

import com.alibaba.fastjson.JSON;
import com.netflix.discovery.converters.Auto;
import com.pcitc.StpProviderApplication;
import com.pcitc.base.expert.*;
import com.pcitc.base.util.DateUtil;
import com.pcitc.base.util.StrUtil;
import com.pcitc.mapper.expert.ZjkExpertMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

import static org.junit.Assert.*;

/**
 * @author:Administrator
 * @date:2018/11/5
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes = StpProviderApplication.class)// 指定spring-boot的启动类
public class ZjkBaseInfoServiceTest {

    @Autowired
    private ZjkBaseInfoService zjkBaseInfoService;

    @Autowired
    private ZjkDataService zjkDataService;

    @Autowired
    private ZjkExpertMapper zjkExpertMapper;

    @Autowired
    private ZjkExpertProjectService zjkExpertProjectService;

    @Autowired
    private ZjkZhuanliService zjkZhuanliService;
    //@Test
    public void excelInto_zjkExpertPatent() {
        System.out.println("导入专家zhuanli信息开始:");
        Map<String, Object> map = new HashMap<>();
        String sql = "SELECT zjk_expert.data_id,zjk_expert.expert_name,temp_zl.* from zjk_expert,temp_zl WHERE zjk_expert.bak3='1' and zjk_expert.bak5=temp_zl.`文档编号`";
        map.put("sqlval", sql);
        List<Map<String, Object>> maps = zjkExpertMapper.listSqlResult(map);
        for (int i = 0; i < maps.size(); i++) {
            Map<String, Object> d = maps.get(i);
            ZjkPatent e = new ZjkPatent();
            e.setDataId(UUID.randomUUID().toString().replace("-", ""));

            e.setDocId(StrUtil.objectToString(d.get("文档编号")));
            e.setNd(StrUtil.objectToString(d.get("年度")));
            e.setPatentName(StrUtil.objectToString(d.get("专利名称")));
            e.setCountry(StrUtil.objectToString(d.get("授权国")));
            e.setPatentCode(StrUtil.objectToString(d.get("专利号")));
            e.setExpertId(StrUtil.objectToString(d.get("data_id")));
            e.setIsResult(StrUtil.objectToString(d.get("是否形成工业化成果")));
            e.setInventPeopleName(StrUtil.objectToString(d.get("发明人（按顺序列出前3位）")));

            e.setBak1(StrUtil.objectToString(d.get("年度")));//2010

            e.setSysFlag("0");
            e.setDataOrder(i);
            e.setDelFlag(0);
            e.setCreateUser("165553436ed_dfd5e137");
            e.setCreateUserDisp("aaaaa");
            e.setCreateDate(DateUtil.dateToStr(new Date(), DateUtil.FMT_DD));
            e.setStatus("0");
            e.setAuditStatus("0");
            System.out.println(JSON.toJSONString(e));
//            zjkZhuanliService.insert(e);
        }
        System.out.println("导入专家zhuanli信息结束");

    }

    //@Test
    public void excelInto_zjkExpertProject() {
        System.out.println("导入专家项目信息开始:");
        Map<String, Object> map = new HashMap<>();
        String sql = "SELECT zjk_expert.data_id,zjk_expert.expert_name,temp_year.* from zjk_expert,temp_year WHERE zjk_expert.bak3='1' and zjk_expert.bak5=temp_year.`文档编号`";
        map.put("sqlval", sql);
        List<Map<String, Object>> maps = zjkExpertMapper.listSqlResult(map);
        for (int i = 0; i < maps.size(); i++) {
            Map<String, Object> d = maps.get(i);
            ZjkExpertProject e = new ZjkExpertProject();
            e.setDataId(UUID.randomUUID().toString().replace("-", ""));

            e.setAmount(StrUtil.objectToString(d.get("经费")));
            e.setDocId(StrUtil.objectToString(d.get("文档编号")));
            e.setYear(StrUtil.objectToString(d.get("年度")));
            e.setProjectName(StrUtil.objectToString(d.get("项目名称及编号")));
            e.setProjectType(StrUtil.objectToString(d.get("项目类")));
            e.setPeople(StrUtil.objectToString(d.get("承担人")));
            e.setExpertId(StrUtil.objectToString(d.get("data_id")));
            e.setStartEnd(StrUtil.objectToString(d.get("起止时间")));

            e.setBak1(StrUtil.objectToString(d.get("年度")));

            e.setSysFlag("0");
            e.setDataOrder(i);
            e.setDelFlag(0);
            e.setCreateUser("165553436ed_dfd5e137");
            e.setCreateUserDisp("aaaaa");
            e.setCreateDate(DateUtil.dateToStr(new Date(), DateUtil.FMT_DD));
            e.setStatus("0");
            e.setAuditStatus("0");
            System.out.println(JSON.toJSONString(e));
//            zjkExpertProjectService.insert(e);
        }
        System.out.println("导入专家项目信息结束");

    }

    //@Test
    public void generatorCode0() {
        //修改bak3的数据
//        Map<String, Object> map = new HashMap<>();
//        String flag = "2";
//        map.put("sqlval", "SELECT * FROM zjk_expert where bak3='"+flag+"'");
//        List<Map<String, Object>> maps = zjkExpertMapper.listSqlResult(map);
//        int leng = 0;
//        Map<String,String> stringStringMap = new HashMap<>();
//        for (int i = 0; i < maps.size(); i++) {
//            Map<String, Object> d = maps.get(i);
//            String expertName = d.get("expert_name").toString();
//            map.put("sqlval", "SELECT * FROM zjk_expert where bak3='"+flag+"' and expert_name='" + expertName + "'");
//            List<Map<String, Object>> mapTemp = zjkExpertMapper.listSqlResult(map);
//            if (mapTemp.size() > 1) {
//                stringStringMap.put(expertName,expertName);
//                String string = "";
//                for (int j = 0; j < mapTemp.size(); j++) {
//                    string = (j == 0 ? "" : (string + ",")) + StrUtil.objectToString(mapTemp.get(j).get("college"));
//                }
//                string = StrUtil.replaceBlank(string);
//                System.out.println(i+"--------------- "+expertName+"-"+i);
//                System.out.println(string);
//                map.put("sqlval", "update zjk_expert set college = '" + string + "',bak3='"+flag+flag+"' where  bak3='"+flag+"' and expert_name='" + d.get("expert_name") + "'");
//                zjkExpertMapper.updateResult(map);
//            }
//        }
//        System.out.println("leng:"+stringStringMap.size());
    }

    //高级专家
    //@Test
    public void generatorCode1() {

//        System.out.println("测试开始");
//        ZjkDataExample ex = new ZjkDataExample();
//        Map<String, Object> map = new HashMap<>();
//        map.put("sqlval", "SELECT * FROM sheet2");
//        List<Map<String, Object>> maps = zjkExpertMapper.listSqlResult(map);
//
//        for (int i = 0; i < maps.size(); i++) {
//            ZjkExpert e = new ZjkExpert();
//            Map<String, Object> d = maps.get(i);
//            e.setDataId(UUID.randomUUID().toString().replace("-", ""));
//            e.setAge("");
//            e.setExpertName(StrUtil.objectToString(d.get("姓名")));
//            e.setSex("男".equals(StrUtil.objectToString(d.get("性别"))) ? "ROOT_UNIVERSAL_XB_N" : "ROOT_UNIVERSAL_XB_V");
//            e.setBirthDate(StrUtil.objectToString(d.get("出生年月")));
//            e.setCompanyName(StrUtil.objectToString(d.get("单位")));
//            e.setAdministrativeDuties(StrUtil.objectToString(d.get("兼任职务")));
//            e.setExpertProfessionalFieldName(StrUtil.objectToString(d.get("专业技术领域")) + "-" + StrUtil.objectToString(d.get("专业方向")) + "-" + StrUtil.objectToString(d.get("专业方向（归）")));
//            e.setEducation(StrUtil.objectToString(d.get("学历学位")));
//            e.setCollege(StrUtil.objectToString(StrUtil.objectToString(d.get("学历学位"))+"-"+d.get("毕业院校")) + "-" + StrUtil.objectToString(d.get("所学专业")) + "-" + StrUtil.objectToString(d.get("毕业时间")));
//            e.setExpertProfessinal(StrUtil.objectToString(d.get("职称"))+"-"+StrUtil.objectToString(d.get("当选时间"))+"-"+StrUtil.objectToString(d.get("续聘时间")));
//            e.setTechnicalPositiion(StrUtil.objectToString(d.get("专业技术职位")));
//
//            e.setBak4(StrUtil.objectToString(d.get("人员编号")));
//
////            e.setPoliticalFace(d.getPoliticalFace());
////            e.setPlaceOrigin(d.getPlaceOrigin());
////            e.setNation(d.getNation());
////            e.setUnitBelongs(d.getUnitBelongs());
////            e.setProfessionalAndTime(d.getProfessionalAndTime());
////            e.setMobile(d.getMobile());
////            e.setEmail(d.getEmail());
////            e.setUserDesc(d.getUserDesc());
////            e.setAwardsTitle(d.getAwardsTitle());
////            e.setBriefDesc(d.getBriefDesc());
//
//            //add
//            e.setAmountCount("0");
//            e.setPatentCount("0");
//            e.setProjectCount("0");
//            e.setCompanyCount("0");
//            e.setAchievementCount("0");
////            e.setBak2(d.getAge());
////            e.setBak1(d.getBirthDate());
//            e.setSysFlag("0");
//            e.setDataOrder(1);
//            e.setDelFlag(0);
//            e.setCreateUser("165553436ed_dfd5e137");
//            e.setCreateUserDisp("aaaaa");
//            e.setCreateDate(DateUtil.dateToStr(new Date(), DateUtil.FMT_DD));
//            e.setStatus("0");
//            e.setAuditStatus("0");
//            e.setBak3("3");
//            zjkBaseInfoService.insert(e);
//        }
//        System.out.println("结束");
    }

    //首席专家
    //@Test
    public void generatorCode2() {
//        System.out.println("测试开始");
//        ZjkDataExample ex = new ZjkDataExample();
//        Map<String, Object> map = new HashMap<>();
//        map.put("sqlval","SELECT * FROM sheet1");
//        List<Map<String, Object>> maps = zjkExpertMapper.listSqlResult(map);
//
//        for (int i = 0; i < maps.size(); i++) {
//            ZjkExpert e = new ZjkExpert();
//            Map<String, Object> d = maps.get(i);
//            System.out.println(d);
//            e.setDataId(UUID.randomUUID().toString().replace("-",""));
//            e.setAge("");
//            e.setExpertName(StrUtil.objectToString(d.get("姓名")));
//            e.setSex("男".equals(StrUtil.objectToString(d.get("性别")))?"ROOT_UNIVERSAL_XB_N":"ROOT_UNIVERSAL_XB_V");
//            e.setBirthDate(StrUtil.objectToString(d.get("出生年月")));
//            e.setCompanyName(StrUtil.objectToString(d.get("单位")));
//            e.setAdministrativeDuties(StrUtil.objectToString(d.get("原职务")));
//            e.setExpertProfessionalFieldName(StrUtil.objectToString(d.get("专业技术领域"))+"-"+StrUtil.objectToString(d.get("专业方向"))+"-"+StrUtil.objectToString(d.get("专业方向（归）")));
//            e.setEducation(StrUtil.objectToString(d.get("学历学位")));
//
//            e.setCollege(StrUtil.objectToString(StrUtil.objectToString(d.get("学历学位"))+"-"+d.get("毕业院校")) + "-" + StrUtil.objectToString(d.get("所学专业")) + "-" + StrUtil.objectToString(d.get("毕业时间")));
//            e.setExpertProfessinal(StrUtil.objectToString(d.get("职称"))+"-"+StrUtil.objectToString(d.get("当选时间"))+"-"+StrUtil.objectToString(d.get("续聘时间")));
//
//            e.setTechnicalPositiion(StrUtil.objectToString(d.get("专业技术职位")));
//
////            e.setPoliticalFace(d.getPoliticalFace());
////            e.setPlaceOrigin(d.getPlaceOrigin());
////            e.setNation(d.getNation());
////            e.setUnitBelongs(d.getUnitBelongs());
////            e.setProfessionalAndTime(d.getProfessionalAndTime());
////            e.setMobile(d.getMobile());
////            e.setEmail(d.getEmail());
////            e.setUserDesc(d.getUserDesc());
////            e.setAwardsTitle(d.getAwardsTitle());
////            e.setBriefDesc(d.getBriefDesc());
//
//            //add
//            e.setAmountCount("0");
//            e.setPatentCount("0");
//            e.setProjectCount("0");
//            e.setCompanyCount("0");
//            e.setAchievementCount("0");
////            e.setBak2(d.getAge());
////            e.setBak1(d.getBirthDate());
//            e.setSysFlag("0");
//            e.setDataOrder(1);
//            e.setDelFlag(0);
//            e.setCreateUser("165553436ed_dfd5e137");
//            e.setCreateUserDisp("aaaaa");
//            e.setCreateDate(DateUtil.dateToStr(new Date(),DateUtil.FMT_DD));
//            e.setStatus("0");
//            e.setAuditStatus("0");
//            e.setBak3("2");
//            zjkBaseInfoService.insert(e);
//        }
//        System.out.println("结束");
    }

//    //@Test
//    public void generatorCode() {
//        System.out.println("测试开始");
//        ZjkDataExample ex = new ZjkDataExample();
//        List<ZjkData> experts = zjkDataService.selectByExample(ex);
//        for (int i = 0; i < experts.size(); i++) {
//            ZjkExpert e = new ZjkExpert();
//            ZjkData d = experts.get(i);
//            e.setDataId(UUID.randomUUID().toString().replace("-",""));
//            e.setAge(d.getAge());
//            e.setExpertName(d.getExpertName());
//            e.setSex("男".equals(d.getSex())?"ROOT_UNIVERSAL_XB_N":"ROOT_UNIVERSAL_XB_V");
//            e.setBirthDate(d.getBirthDate());
//            e.setPoliticalFace(d.getPoliticalFace());
//            e.setPlaceOrigin(d.getPlaceOrigin());
//            e.setNation(d.getNation());
//            e.setCollege(d.getCollege());
//            e.setEducation(d.getEducation());
//            e.setUnitBelongs(d.getUnitBelongs());
//            e.setProfessionalAndTime(d.getProfessionalAndTime());
//            e.setTechnicalPositiion(d.getTechnicalPositiion());
//            e.setAdministrativeDuties(d.getAdministrativeDuties());
//            e.setMobile(d.getMobile());
//            e.setEmail(d.getEmail());
//            e.setUserDesc(d.getUserDesc());
//            e.setAwardsTitle(d.getAwardsTitle());
//            e.setBriefDesc(d.getBriefDesc());
//
//            //add
//            e.setAmountCount("0");
//            e.setPatentCount("0");
//            e.setProjectCount("0");
//            e.setCompanyCount("0");
//            e.setAchievementCount("0");
//            e.setBak2(d.getAge());
//            e.setBak1(d.getBirthDate());
//            e.setSysFlag("0");
//            e.setDataOrder(1);
//            e.setDelFlag(0);
//            e.setCreateUser("165553436ed_dfd5e137");
//            e.setCreateUserDisp("aaaaa");
//            e.setCreateDate(DateUtil.dateToStr(new Date(),DateUtil.FMT_DD));
//            e.setStatus("0");
//            e.setAuditStatus("0");
//            e.setBak3("2");
//            System.out.println(e);
//            zjkBaseInfoService.insert(e);
//        }
//        System.out.println("结束");
//    }
}