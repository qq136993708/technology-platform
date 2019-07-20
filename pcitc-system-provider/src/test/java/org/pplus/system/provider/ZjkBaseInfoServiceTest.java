//package org.pplus.system.provider;
//
//import com.alibaba.fastjson.JSON;
//import com.pcitc.SystemProviderApplication;
//import com.pcitc.base.common.HotWord;
//import com.pcitc.base.expert.ZjkExpertProject;
//import com.pcitc.base.expert.ZjkPatent;
//import com.pcitc.base.stp.techFamily.TechFamily;
//import com.pcitc.base.system.SearchLog;
//import com.pcitc.base.system.SysFile;
//import com.pcitc.base.system.SysFileExample;
//import com.pcitc.base.util.DateUtil;
//import com.pcitc.base.util.StrUtil;
//import com.pcitc.es.clientmanager.ClientFactoryBuilder;
//import com.pcitc.service.doc.IndexAccessorService;
//import com.pcitc.service.system.IndexOutProjectInfoService;
//import com.pcitc.service.system.SysFileService;
//import com.pcitc.web.feign.TechFamilyProviderClient;
//import org.elasticsearch.action.admin.indices.analyze.AnalyzeRequest;
//import org.elasticsearch.action.admin.indices.analyze.AnalyzeResponse;
//import org.elasticsearch.client.transport.TransportClient;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import java.util.*;
//
///**
// * @author:Administrator
// * @date:2018/11/5
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes = SystemProviderApplication.class)// 指定spring-boot的启动类
//public class ZjkBaseInfoServiceTest {
//
//    @Autowired
//    private ClientFactoryBuilder clientFactoryBuilder;
//    @Autowired
//    private SysFileService sysFileService;
//    @Autowired
//    private IndexOutProjectInfoService index;
//
//    @Autowired
//    private IndexAccessorService indexAccessorService;
//    @Autowired
//    private TechFamilyProviderClient techFamilyProviderClient;
//
////    @Test
////    public void testselectHotWord() {
////        List<SysFile> sysFiles = sysFileService.selectByExample(new SysFileExample());
////        for (int i = 0; i < sysFiles.size(); i++) {
////            SearchLog searchLog = new SearchLog();
////            searchLog.setName(sysFiles.get(i).getFileName());
////            indexAccessorService.saveSearchLogToEs(searchLog);
////        }
////        HotWord hotWord = new HotWord();
////        hotWord.setField("name");
////        hotWord.setIndices("search");
////        hotWord.setSize(10);
////        hotWord.setTerms("hotWord");
////        hotWord.setTypes("searchlog");
////        indexAccessorService.selectHotWord(hotWord);
////    }
//
//    //    @Test
//    public void excelInto_zjkExpertPatent() {
//
////        index.selectTfcToIndexProjectInfo();
//
////        TransportClient client = clientFactoryBuilder.getClient();
////
////        AnalyzeRequest analyzeRequest = new AnalyzeRequest("files")
////                .text("压裂用覆膜支撑剂性能评价研究")
////                    .analyzer("ik_max_word");
////
////        List<AnalyzeResponse.AnalyzeToken> tokens = client.admin().indices()
////                .analyze(analyzeRequest)
////                .actionGet()
////                .getTokens();
////
////        for (AnalyzeResponse.AnalyzeToken token : tokens) {
////            System.out.println(token.getTerm());
////        }
//
//    }
//
//}