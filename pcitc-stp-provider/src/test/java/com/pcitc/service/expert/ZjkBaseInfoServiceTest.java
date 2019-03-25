//package com.pcitc.service.expert;
//
//import com.pcitc.StpProviderApplication;
//import com.pcitc.base.expert.ZjkData;
//import com.pcitc.base.expert.ZjkDataExample;
//import com.pcitc.base.expert.ZjkExpert;
//import com.pcitc.base.expert.ZjkExpertExample;
//import com.pcitc.base.util.DateUtil;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import java.util.Date;
//import java.util.List;
//import java.util.UUID;
//
//import static org.junit.Assert.*;
//
///**
// * @author:Administrator
// * @date:2018/11/5
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes = StpProviderApplication.class)// 指定spring-boot的启动类
//public class ZjkBaseInfoServiceTest {
//
//    @Autowired
//    private ZjkBaseInfoService zjkBaseInfoService;
//
//    @Autowired
//    private ZjkDataService zjkDataService;
//
//    @Test
//    public void generatorCode() {
//        System.out.println("测试开始");
//        ZjkDataExample ex = new ZjkDataExample();
//        List<ZjkData> experts = zjkDataService.selectByExample(ex);
////        for (int i = 0; i < 1; i++) {
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
////            System.out.println(e);
////            zjkBaseInfoService.insert(e);
//        }
//        System.out.println("结束");
//    }
//}