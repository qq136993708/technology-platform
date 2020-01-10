package com.pcitc.web.controller.achieve;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.achieve.AchieveRecord;
import com.pcitc.base.achieve.AchieveReward;
import com.pcitc.base.achieve.AchieveSubmit;
import com.pcitc.base.common.Result;
import com.pcitc.base.system.SysPost;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.base.util.DateUtil;
import com.pcitc.web.common.RestBaseController;
import com.pcitc.web.utils.EquipmentUtils;
import freemarker.template.Configuration;
import freemarker.template.Template;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.BaseFont;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;

/**
 * <p>成果转换备案</p>
 * <p>Table:  achieve_record 成果转换备案</p>
 * @author
 */
@Api(value = "achieveRecord-api", description = "成果转换备案")
@RestController
public class AchieveRecordController extends RestBaseController {
    /**
     * 根据ID获取对象信息
     */
    private static final String load = "http://kjpt-zuul/stp-proxy/achieveRecord-api/load/";
    /**
     * 根据ID获取成果对象信息
     */
    private static final String loadAchieveBase = "http://kjpt-zuul/stp-proxy/achieve-api/load/";
    /**
     * 查询列表
     */
    private static final String query = "http://kjpt-zuul/stp-proxy/achieveRecord-api/query";
    /**
     * 查询列表不分页
     */
    private static final String queryNopage = "http://kjpt-zuul/stp-proxy/achieveRecord-api/queryNoPage";
    /**
     * 保存
     */
    private static final String save = "http://kjpt-zuul/stp-proxy/achieveRecord-api/save";
    /**
     * 简单保存
     */
    private static final String simpleSave = "http://kjpt-zuul/stp-proxy/achieveRecord-api/simpleSave";
    /**
     * 删除
     */
    private static final String delete = "http://kjpt-zuul/stp-proxy/achieveRecord-api/delete/";
    
    /**
     * 流程
     */
    private static final String WORKFLOW_URL = "http://kjpt-zuul/stp-proxy/achieveRecord-api/task/start_activity/";


    /**
     * 辅助决策成果转化明细
     */
    private static final String queryAchieveSubsidiarity = "http://kjpt-zuul/stp-proxy/achieveRecord-api/queryAchieveSubsidiarity";
    /**
     * 辅助决策成果转化明细
     */
    private static final String queryAchieveSubsidiarityExport = "http://kjpt-zuul/stp-proxy/achieveRecord-api/queryAchieveSubsidiarityExport";

    @Value("${achieveFtlPath}")
    private String achieveFtlPath;
    @Value("${achieveFtlName}")
    private String achieveFtlName;
    @Value("${fontPath}")
    private String fontPath;

    @ApiOperation(value="读取")
    @RequestMapping(value = "/achieveRecord-api/load/{id}", method = RequestMethod.GET)
    @ResponseBody
    public AchieveRecord load(@PathVariable String id) {
        ResponseEntity<AchieveRecord> responseEntity = this.restTemplate.exchange(load+id, HttpMethod.GET, new HttpEntity(this.httpHeaders), AchieveRecord.class);
        return responseEntity.getBody();
    }

    @ApiOperation(value="备案信息的导出")
    @RequestMapping(value = "/achieveRecord-api/wordExport/{id}", method = RequestMethod.GET)
    @ResponseBody
    public void wordExport(@PathVariable String id) throws Exception {
        ResponseEntity<AchieveRecord> responseEntity = this.restTemplate.exchange(load+id, HttpMethod.GET, new HttpEntity(this.httpHeaders), AchieveRecord.class);
        AchieveRecord ar = responseEntity.getBody();
        String htmlContent = parseDataToHtml(achieveFtlPath,achieveFtlName,ar);
        htmlConvertPDF(htmlContent);
    }

//    private void parseDataToHtml(String ftlFilePath,String ftlName,String htmlFilePath, AchieveRecord ar) throws IOException {
//        /** 获取文件路径参数 */
//        // 模板所在路径
//       // String filePath = ftlFilePath.substring(0, ftlFilePath.lastIndexOf("/"));
//        // 模板名称
//        // String templateFile = achieveFtlPath.substring(ftlFilePath.lastIndexOf("/") + 1);
//
//        Writer out = null;
//        /** Freemarker 基础配置 */
//        Configuration freemarkerConfig = new Configuration();
//        try {
//            //File file = new File("D:\\opt");
//            File file = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + ftlFilePath);
//            freemarkerConfig.setDirectoryForTemplateLoading(file);
//            freemarkerConfig.setDefaultEncoding("UTF-8");
//            /** 匹配映射模板数据 */
//            Map<String, Object> dataMap = new HashMap<String, Object>(2);
//            dataMap.put("achieveRecord",ar);
//            /** 输出流处理 */
//            out = new OutputStreamWriter(new FileOutputStream(htmlFilePath), "UTF-8");
//            Template template = freemarkerConfig.getTemplate(ftlName);
//            template.process(dataMap, out);
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }finally {
//            out.close();
//        }
//    }



    private String parseDataToHtml(String ftlFilePath,String ftlName,AchieveRecord ar) throws IOException {
        /** 获取文件路径参数 */
        StringWriter  out = new StringWriter();
        /** Freemarker 基础配置 */
        Configuration freemarkerConfig = new Configuration();
        try {
            File file = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + ftlFilePath);
            freemarkerConfig.setDirectoryForTemplateLoading(file);
            freemarkerConfig.setDefaultEncoding("UTF-8");
            /** 匹配映射模板数据 */
            Map<String, Object> dataMap = new HashMap<String, Object>(2);
            dataMap.put("achieveRecord",ar);
            /** 输出流处理 */
            Template template = freemarkerConfig.getTemplate(ftlName);
            template.process(dataMap, out);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            out.close();
        }
        return out.toString();
    }

    /**
     * 转换为pdf文件
     *
     * @param htmlPath
     *            HTML文件所在路径
     * @return
     */
//    private void htmlConvertPDF(String htmlPath) throws IOException {
//        String pdfFileName = htmlPath.substring(htmlPath.lastIndexOf("/") + 1, htmlPath.lastIndexOf(".html"));// PDF文件名称
//        boolean convertResult = false;
//        String outputFile = null;
//        OutputStream os = null;
//        try {
//            os = new FileOutputStream("D:\\opt\\dex.pdf");
//
//            String inputFile = htmlPath;
//            String url = new File(inputFile).toURI().toURL().toString();
//            ITextRenderer renderer = new ITextRenderer();
//            // 解决中文支持问题
//            ITextFontResolver fontResolver = renderer.getFontResolver();
//            fontResolver.addFont("C:/Windows/Fonts/simsun.ttc", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
//             renderer.getSharedContext().setBaseURL("D:\\opt\\dex.pdf");
//            //renderer.setDocument(url);
//            renderer.setDocumentFromString(htmlPath);
//            renderer.layout();
//            renderer.createPDF(os);
//
//            os.close();
//            renderer.getWriter().close();
//        } catch (IOException e1) {
//            e1.printStackTrace();
//        } catch (DocumentException e) {
//            e.printStackTrace();
//        }finally {
//            os.close();
//        }
//    }

    private void htmlConvertPDF(String htmlPath) throws IOException {
        OutputStream os = null;
        try {
            os = this.getCurrentResponse().getOutputStream();

            String inputFile = htmlPath;
            ITextRenderer renderer = new ITextRenderer();
            // 解决中文支持问题
            ITextFontResolver fontResolver = renderer.getFontResolver();
            fontResolver.addFont(getFontPath(), BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
            renderer.setDocumentFromString(htmlPath);
            renderer.layout();
            renderer.createPDF(os);
            os.close();
            renderer.getWriter().close();
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }finally {
            os.close();
        }
    }

    public static String getFontPath() {
        String OS = System.getProperty("os.name").toLowerCase();
        String fontPath = null;
        if (OS.indexOf("mac") >= 0) {
            fontPath = "/library/fonts/Arial Unicode.ttf";
        } else if (OS.indexOf("linux") >= 0) {
            fontPath = "/usr/share/fonts/chinese/simsun.ttc";
        } else if (OS.indexOf("windows") >= 0) {
            fontPath = "C:/Windows/Fonts/simsun.ttc";
        }
        return fontPath;
    }


    @ApiOperation(value = "查询列表", notes = "查询列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页码", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页显示条数", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "achieveName", value = "成果名称", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "finishUnitName", value = "完成单位", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "auditStatus", value = "备案状态", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "startDate", value = "录入开始时间", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "endDate", value = "录入结束时间", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "achieveType", value = "成果类型", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "grantUnitName", value = "成果受让单位", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "achieveTransType", value = "转化方式", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "aboutCompleteInfo", value = "完成情况", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "secretLevel", value = "密级", dataType = "string", paramType = "query")
    })
    @RequestMapping(value = "/achieveRecord-api/query", method = RequestMethod.GET)
    @ResponseBody
    public PageInfo query(
            @RequestParam(required = false,value = "pageNum") Integer pageNum,
            @RequestParam(required = false,value = "pageSize") Integer pageSize,
            @RequestParam(required = false,value = "achieveName") String achieveName,
            @RequestParam(required = false,value = "finishUnitName") String finishUnitName,
            @RequestParam(required = false,value = "auditStatus") String auditStatus,
            @RequestParam(required = false,value = "startDate")@DateTimeFormat(pattern="yyyy-MM-dd") Date startDate,
            @RequestParam(required = false,value = "endDate")@DateTimeFormat(pattern="yyyy-MM-dd") Date endDate,
            @RequestParam(required = false,value = "achieveType") String achieveType,
            @RequestParam(required = false,value = "grantUnitName") String grantUnitName,
            @RequestParam(required = false,value = "achieveTransType") String achieveTransType,
            @RequestParam(required = false,value = "aboutCompleteInfo") String aboutCompleteInfo,
            @RequestParam(required = false,value = "secretLevel") String secretLevel


    ) throws Exception {
        Map<String, Object> condition = new HashMap<>(6);
        SysUser sysUserInfo = this.getUserProfile();
        if (pageNum == null) {
            this.setParam(condition, "pageNum", 1);
        }else {
            this.setParam(condition, "pageNum", pageNum);
        }
        if (pageSize == null) {
            this.setParam(condition, "pageSize", 10);
        }else {
            this.setParam(condition, "pageSize", pageSize);
        }
        if (!StringUtils.isEmpty(achieveName)) {
            this.setParam(condition, "achieveName", achieveName);
        }
        if (!StringUtils.isEmpty(finishUnitName)) {
            this.setParam(condition, "finishUnitName", finishUnitName);
        }
        if (!StringUtils.isEmpty(achieveType)) {
            this.setParam(condition, "achieveType", achieveType);
        }
        if (!StringUtils.isEmpty(auditStatus)) {
            this.setParam(condition, "auditStatus", auditStatus);
        }
        if (!StringUtils.isEmpty(grantUnitName)) {
            this.setParam(condition, "grantUnitName", grantUnitName);
        }
        if (!StringUtils.isEmpty(achieveTransType)) {
            this.setParam(condition, "achieveTransType", achieveTransType);
        }
        if (!StringUtils.isEmpty(aboutCompleteInfo)) {
            this.setParam(condition, "aboutCompleteInfo", aboutCompleteInfo);
        }
        if (!StringUtils.isEmpty(DateUtil.format(startDate,DateUtil.FMT_SS))) {
            this.setParam(condition, "startDate", DateUtil.format(startDate,DateUtil.FMT_SS));
        }
        if (!StringUtils.isEmpty(DateUtil.format(endDate,DateUtil.FMT_SS))) {
            this.setParam(condition, "endDate", DateUtil.format(endDate,DateUtil.FMT_SS));
        }


        if(secretLevel != null){
            this.setParam(condition,"secretLevel",secretLevel);
        }
        this.setBaseParam(condition);

        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<PageInfo> responseEntity = this.restTemplate.exchange(query, HttpMethod.POST, new HttpEntity<Map>(condition, this.httpHeaders), PageInfo.class);
        return responseEntity.getBody();
    }
    @ApiOperation(value = "导出", notes = "导出")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "achieveName", value = "成果名称", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "finishUnitName", value = "完成单位", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "auditStatus", value = "备案状态", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "startDate", value = "录入开始时间", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "endDate", value = "录入结束时间", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "achieveType", value = "成果类型", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "grantUnitName", value = "成果受让单位", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "achieveTransType", value = "转化方式", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "aboutCompleteInfo", value = "完成情况", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "secretLevel", value = "密级", dataType = "string", paramType = "query")
    })

    @RequestMapping(value = "/achieveRecord-api/exportExcel", method = RequestMethod.GET)
    public void exportExcel(
            @RequestParam(required = false,value = "achieveName") String achieveName,
            @RequestParam(required = false,value = "finishUnitName") String finishUnitName,
            @RequestParam(required = false,value = "auditStatus") String auditStatus,
            @RequestParam(required = false,value = "startDate")@DateTimeFormat(pattern="yyyy-MM-dd") Date startDate,
            @RequestParam(required = false,value = "endDate")@DateTimeFormat(pattern="yyyy-MM-dd") Date endDate,
            @RequestParam(required = false,value = "achieveType") String achieveType,
            @RequestParam(required = false,value = "grantUnitName") String grantUnitName,
            @RequestParam(required = false,value = "achieveTransType") String achieveTransType,
            @RequestParam(required = false,value = "aboutCompleteInfo") String aboutCompleteInfo,
            @RequestParam(required = false,value = "secretLevel") String secretLevel
    ) throws Exception {
        Map<String, Object> condition = new HashMap<>(6);
        SysUser sysUserInfo = this.getUserProfile();
        if (!StringUtils.isEmpty(achieveName)) {
            this.setParam(condition, "achieveName", achieveName);
        }
        if (!StringUtils.isEmpty(finishUnitName)) {
            this.setParam(condition, "finishUnitName", finishUnitName);
        }
        if (!StringUtils.isEmpty(achieveType)) {
            this.setParam(condition, "achieveType", achieveType);
        }
        if (!StringUtils.isEmpty(auditStatus)) {
            this.setParam(condition, "auditStatus", auditStatus);
        }
        if (!StringUtils.isEmpty(grantUnitName)) {
            this.setParam(condition, "grantUnitName", grantUnitName);
        }
        if (!StringUtils.isEmpty(achieveTransType)) {
            this.setParam(condition, "achieveTransType", achieveTransType);
        }
        if (!StringUtils.isEmpty(aboutCompleteInfo)) {
            this.setParam(condition, "aboutCompleteInfo", aboutCompleteInfo);
        }
        if (!StringUtils.isEmpty(DateUtil.format(startDate,DateUtil.FMT_SS))) {
            this.setParam(condition, "startDate", DateUtil.format(startDate,DateUtil.FMT_SS));
        }
        if (!StringUtils.isEmpty(DateUtil.format(endDate,DateUtil.FMT_SS))) {
            this.setParam(condition, "endDate", DateUtil.format(endDate,DateUtil.FMT_SS));
        }


        if(secretLevel != null){
            this.setParam(condition,"secretLevel",secretLevel);
        }
       /* this.setParam(condition,"userSecretLevel",sysUserInfo.getSecretLevel());
        this.setParam(condition,"userName",sysUserInfo.getUserName());*/
       this.setBaseParam(condition);

        //默认查询当前人所在机构下所有的成果备案
        //String childUnitIds= EquipmentUtils.getAllChildsByIUnitPath(sysUserInfo.getUnitPath(), restTemplate, httpHeaders);
        //this.setParam(condition,"childUnitIds",childUnitIds);

        String[] headers = { "备案状态",  "成果名称",    "成果基本情况"  , "成果持有单位"  , "拟受让单位"  , "是否核心技术成果"  , "拟转让方式"  , "完成情况"  , "未完成项目预计完成时间"  , "密级"};
        String[] cols =    {"auditStatusText","achieveName","achieveInfo","finishUnitName","grantUnitName","achieveTypeText","achieveTransTypeText","aboutCompleteInfoText","aboutCompleteTime","secretLevelText"};
        ResponseEntity<JSONArray> responseEntity = this.restTemplate.exchange(queryNopage, HttpMethod.POST, new HttpEntity<Map>(condition, this.httpHeaders), JSONArray.class);
        List list = JSONObject.parseArray(responseEntity.getBody().toJSONString(), AchieveRecord.class);
        String fileName = "成果转化表_"+ DateFormatUtils.format(new Date(), "ddhhmmss");
        this.exportExcel(headers,cols,fileName,list);
    }

    @ApiOperation(value="保存")
    @RequestMapping(value = "/achieveRecord-api/save", method = RequestMethod.POST)
    @ResponseBody
    public AchieveSubmit save(@RequestBody AchieveSubmit as){
        this.setBaseData(as);
        setRecord(as);
        as.getAchieveRecord().setAuditStatus("0");
        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        this.restTemplate.exchange(save, HttpMethod.POST, new HttpEntity<AchieveSubmit>(as, this.httpHeaders), AchieveSubmit.class);
        return as;
    }

    @ApiOperation(value="简单保存")
    @RequestMapping(value = "/achieveRecord-api/simpleSave", method = RequestMethod.POST)
    @ResponseBody
    public AchieveSubmit simpleSave(@RequestBody AchieveSubmit as){
        this.setBaseData(as);
        setRecord(as);
        as.getAchieveRecord().setAuditStatus("0");
        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        this.restTemplate.exchange(simpleSave, HttpMethod.POST, new HttpEntity<AchieveSubmit>(as, this.httpHeaders), AchieveSubmit.class);
        return as;
    }


    @ApiOperation(value="提交")
    @RequestMapping(value = "/achieveRecord-api/submit", method = RequestMethod.POST)
    @ResponseBody
    public AchieveSubmit submit(@RequestBody AchieveSubmit as){
        this.setBaseData(as);
        setRecord(as);
        as.getAchieveRecord().setAuditStatus("1");
        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        this.restTemplate.exchange(save, HttpMethod.POST, new HttpEntity<AchieveSubmit>(as, this.httpHeaders), AchieveSubmit.class);
        return as;
    }




    @ApiOperation(value = "辅助决策成果转化明细", notes = "辅助决策成果转化明细")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页码", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页显示条数", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "achieveName", value = "成果名称", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "finishUnitName", value = "完成单位", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "auditStatus", value = "备案状态", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "startDate", value = "录入开始时间", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "endDate", value = "录入结束时间", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "achieveType", value = "完成情况", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "achieveType", value = "是否核心成果", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "secretLevel", value = "密级", dataType = "string", paramType = "query")
    })
    @RequestMapping(value = "/achieveRecord-api/queryAchieveSubsidiarity", method = RequestMethod.GET)
    @ResponseBody
    public PageInfo queryAchieveSubsidiarity(
            @RequestParam(required = false,value = "pageNum") Integer pageNum,
            @RequestParam(required = false,value = "pageSize") Integer pageSize,
            @RequestParam(required = false,value = "achieveName") String achieveName,
            @RequestParam(required = false,value = "finishUnitName") String finishUnitName,
            @RequestParam(required = false,value = "auditStatus") String auditStatus,
            @RequestParam(required = false,value = "startDate")@DateTimeFormat(pattern="yyyy-MM-dd") Date startDate,
            @RequestParam(required = false,value = "endDate")@DateTimeFormat(pattern="yyyy-MM-dd") Date endDate,
            @RequestParam(required = false,value = "aboutCompleteInfo") String aboutCompleteInfo,
            @RequestParam(required = false,value = "achieveType") String achieveType,
            @RequestParam(required = false,value = "secretLevel") String secretLevel


    ) throws Exception {
        Map<String, Object> condition = new HashMap<>(6);
        SysUser sysUserInfo = this.getUserProfile();
        if (pageNum == null) {
            this.setParam(condition, "pageNum", 1);
        }else {
            this.setParam(condition, "pageNum", pageNum);
        }
        if (pageSize == null) {
            this.setParam(condition, "pageSize", 10);
        }else {
            this.setParam(condition, "pageSize", pageSize);
        }
        if (!StringUtils.isEmpty(achieveName)) {
            this.setParam(condition, "achieveName", achieveName);
        }
        if (!StringUtils.isEmpty(finishUnitName)) {
            this.setParam(condition, "finishUnitName", finishUnitName);
        }
        if (!StringUtils.isEmpty(achieveType)) {
            this.setParam(condition, "achieveType", achieveType);
        }
        if (!StringUtils.isEmpty(auditStatus)) {
            this.setParam(condition, "auditStatus", auditStatus);
        }
        if (!StringUtils.isEmpty(aboutCompleteInfo)) {
            this.setParam(condition, "aboutCompleteInfo", aboutCompleteInfo);
        }
        if (!StringUtils.isEmpty(DateUtil.format(startDate,DateUtil.FMT_SS))) {
            this.setParam(condition, "startDate", DateUtil.format(startDate,DateUtil.FMT_SS));
        }
        if (!StringUtils.isEmpty(DateUtil.format(endDate,DateUtil.FMT_SS))) {
            this.setParam(condition, "endDate", DateUtil.format(endDate,DateUtil.FMT_SS));
        }


        if(secretLevel != null){
            this.setParam(condition,"secretLevel",secretLevel);
        }
        this.setBaseParam(condition);
        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<PageInfo> responseEntity = this.restTemplate.exchange(queryAchieveSubsidiarity, HttpMethod.POST, new HttpEntity<Map>(condition, this.httpHeaders), PageInfo.class);
        return responseEntity.getBody();
    }

    @ApiOperation(value = "辅助决策成果转化明细导出", notes = "辅助决策成果转化明细导出")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "achieveName", value = "成果名称", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "finishUnitName", value = "完成单位", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "auditStatus", value = "备案状态", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "startDate", value = "录入开始时间", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "endDate", value = "录入结束时间", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "achieveType", value = "完成情况", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "achieveType", value = "是否核心成果", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "secretLevel", value = "密级", dataType = "string", paramType = "query")
    })
    @RequestMapping(value = "/achieveRecord-api/queryAchieveSubsidiarityExport", method = RequestMethod.GET)
    @ResponseBody
    public void queryAchieveSubsidiarityExport(
            @RequestParam(required = false,value = "achieveName") String achieveName,
            @RequestParam(required = false,value = "finishUnitName") String finishUnitName,
            @RequestParam(required = false,value = "auditStatus") String auditStatus,
            @RequestParam(required = false,value = "startDate")@DateTimeFormat(pattern="yyyy-MM-dd") Date startDate,
            @RequestParam(required = false,value = "endDate")@DateTimeFormat(pattern="yyyy-MM-dd") Date endDate,
            @RequestParam(required = false,value = "aboutCompleteInfo") String aboutCompleteInfo,
            @RequestParam(required = false,value = "achieveType") String achieveType,
            @RequestParam(required = false,value = "secretLevel") String secretLevel


    ) throws Exception {
        Map<String, Object> condition = new HashMap<>(6);
        SysUser sysUserInfo = this.getUserProfile();
        if (!StringUtils.isEmpty(achieveName)) {
            this.setParam(condition, "achieveName", achieveName);
        }
        if (!StringUtils.isEmpty(finishUnitName)) {
            this.setParam(condition, "finishUnitName", finishUnitName);
        }
        if (!StringUtils.isEmpty(achieveType)) {
            this.setParam(condition, "achieveType", achieveType);
        }
        if (!StringUtils.isEmpty(auditStatus)) {
            this.setParam(condition, "auditStatus", auditStatus);
        }
        if (!StringUtils.isEmpty(aboutCompleteInfo)) {
            this.setParam(condition, "aboutCompleteInfo", aboutCompleteInfo);
        }
        if (!StringUtils.isEmpty(DateUtil.format(startDate,DateUtil.FMT_SS))) {
            this.setParam(condition, "startDate", DateUtil.format(startDate,DateUtil.FMT_SS));
        }
        if (!StringUtils.isEmpty(DateUtil.format(endDate,DateUtil.FMT_SS))) {
            this.setParam(condition, "endDate", DateUtil.format(endDate,DateUtil.FMT_SS));
        }


        if(secretLevel != null){
            this.setParam(condition,"secretLevel",secretLevel);
        }
        this.setParam(condition,"userSecretLevel",sysUserInfo.getSecretLevel());

        //默认查询当前人所在机构下所有的成果备案
        //String childUnitIds= EquipmentUtils.getAllChildsByIUnitPath(sysUserInfo.getUnitPath(), restTemplate, httpHeaders);
        //this.setParam(condition,"childUnitIds",childUnitIds);


        String[] headers = { "成果描述",     "项目来源",   "经费支持渠道"  ,"完成团队"  , "完成单位"  , "知识产权情况"  , "是否为核心成果"    , "成果转换状态"        , "单位基本信息", "选择单位的方式", "对受让单位的尽职调查情况", "选择单位的理由", "尽职调查报告", "成果转换方式",       "定价方式",      "定价原则及依据" ,"单位内部决策流程", "决策事项及结果" ,          "转化收入", "成本核算及核算依据", "项目全周期净收入计算", "项目全周期激励方案及制定方案", "激励额度", "工资总额预算来源", "激励人员名单", "激励总额", "激励分配方案"};
        String[] cols =    {"achieveName","projectSource","projectChannel","teamInfo","finishUnitName","intellectualInfo","achieveTypeText"    ,"achieveTransStatusText","grantUnitName","grantChooseWay","grantInvest",               "grantChooseWay", "grantInvest",  "achieveTransTypeText","transPriceWay","transPriceBasis"        ,"decisionFlow"     ,"decisionResult" , "transIncome","checkBasis",      "incomeCalculation" , "rewardRecord" ,                  "rewardQuota" ,"budgetSources" ,"budgetPerson", "budgetAllMoney","assignPlan" };

        ResponseEntity<JSONArray> responseEntity = this.restTemplate.exchange(queryAchieveSubsidiarityExport, HttpMethod.POST, new HttpEntity<Map>(condition, this.httpHeaders), JSONArray.class);
        List list = JSONObject.parseArray(responseEntity.getBody().toJSONString(), Map.class);
        String fileName = "成果转化明细表_"+ DateFormatUtils.format(new Date(), "ddhhmmss");
        this.exportExcel(headers,cols,fileName,list);
    }

    private void setRecord(AchieveSubmit as){
        SysUser sysUserInfo = this.getUserProfile();
        if(as.getAchieveReward()!=null){
            as.getAchieveReward().setCreator(as.getUpdator());
            as.getAchieveReward().setUpdator(as.getUpdator());
            as.getAchieveReward().setCreateDate(as.getUpdateDate());
            as.getAchieveReward().setUpdateDate(as.getUpdateDate());
            as.getAchieveReward().setCreateUnitId(sysUserInfo.getUnitId());
            as.getAchieveReward().setCreateUnitName(sysUserInfo.getUnitName());
        }
    }

    @ApiOperation(value="删除")
    @RequestMapping(value = "/achieveRecord-api/delete/{ids}", method = RequestMethod.DELETE)
    @ResponseBody
    public Integer delete(@PathVariable String ids) {
        ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(delete+ids, HttpMethod.DELETE, new HttpEntity(this.httpHeaders), Integer.class);
        return responseEntity.getBody();
    }


    @ApiOperation(value="初始化")
    @RequestMapping(value = "/achieveRecord-api/newInit", method = RequestMethod.GET)
    @ResponseBody
    public AchieveSubmit newInit() {

     /*   ResponseEntity<AchieveBase> responseEntity = this.restTemplate.exchange(loadAchieveBase+achieveBaseId, HttpMethod.GET, new HttpEntity(this.httpHeaders), AchieveBase.class);
        AchieveBase ab = responseEntity.getBody();*/


        AchieveSubmit as = new AchieveSubmit();


        AchieveRecord a = new AchieveRecord();
        String achieveRecordId = UUID.randomUUID().toString().replace("-","");
        a.setId(achieveRecordId);
        //授拟-（文件上传）：材料
        a.setGrantDoc(UUID.randomUUID().toString().replace("-",""));
        //科技成果评价报告（文件上传）
        a.setAppraisalDoc(UUID.randomUUID().toString().replace("-",""));
        //公示结果：材料
        a.setTransContractDoc(UUID.randomUUID().toString().replace("-",""));
        //评估报告：材料
        a.setTransAssessDoc(UUID.randomUUID().toString().replace("-",""));
        //决策会议纪要：材料
        a.setDecisionMeetingDoc(UUID.randomUUID().toString().replace("-",""));
        //规章制度：材料
        a.setDecisionRuleDoc(UUID.randomUUID().toString().replace("-",""));
        //公示结果：材料
        a.setTransPublicDoc(UUID.randomUUID().toString().replace("-",""));


        String achieveRewardId = UUID.randomUUID().toString().replace("-","");
        AchieveReward ar = new AchieveReward();
        ar.setId(achieveRewardId);
        ar.setAchieveRecordId(achieveRecordId);

        //成果核算：材料
        ar.setRewardAccountingDoc(UUID.randomUUID().toString().replace("-",""));
        //净收入计算报告：材料
        ar.setAssignPlanDoc(UUID.randomUUID().toString().replace("-",""));
        //净收入计算报告：材料
        ar.setIncomeReportDoc(UUID.randomUUID().toString().replace("-",""));

        as.setAchieveRecord(a);
        as.setAchieveReward(ar);
        return as;
    }


    @ApiOperation(value="成果转化备案流程")
    @RequestMapping(value = "/achieveRecord-api/start_workflow",method = RequestMethod.POST)
	public Object start_workflow(HttpServletRequest request, HttpServletResponse response ) throws Exception
	{
    	
    	Result rs = new Result();
		this.httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);//设置参数类型和编码
		String id = CommonUtil.getParameter(request, "id", "");
		String functionId = CommonUtil.getParameter(request, "functionId", "");
		String userIds = CommonUtil.getParameter(request, "userIds", "");
		System.out.println("============start_workflow userIds="+userIds+" functionId="+functionId+" id="+id);
		if(!functionId.equals(""))
		{
			 ResponseEntity<AchieveRecord> responseEntity = this.restTemplate.exchange(load+id, HttpMethod.GET, new HttpEntity(this.httpHeaders), AchieveRecord.class);
			 AchieveRecord achieveBase=  responseEntity.getBody();
	        SysUser sysUserInfo = this.getUserProfile();
			String branchFlag="0";
			Map<String ,Object> paramMap = new HashMap<String ,Object>();
			paramMap.put("id", id);
			paramMap.put("functionId", functionId);
			paramMap.put("processInstanceName", "成果转化备案->"+achieveBase.getAchieveName());
			paramMap.put("authenticatedUserId", sysUserInfo.getUserId());
			paramMap.put("authenticatedUserName", sysUserInfo.getUserDisp());
			paramMap.put("auditor", userIds);
			paramMap.put("branchFlag", branchFlag);
			
			//指定岗位
			String specialAuditor1 = "";//xxx_核心成果转化-岗位代码
			StringBuffer specialAuditor1_sb = new StringBuffer();
			String unitIds=sysUserInfo.getUnitId();
			System.out.println("============unitIds ="+unitIds+" applyUnitName="+sysUserInfo.getUnitName());
			if(unitIds!=null && !unitIds.equals(""))
			{
				String arr[]=unitIds.split(",");
				if(arr!=null && arr.length>0)
				{
					for(int i=0;i<arr.length;i++)
					{
						 String unitId=arr[i];
						
						 List<SysPost> list = EquipmentUtils.getPostListByUnitId(unitId, restTemplate, httpHeaders);
						 if(list!=null && list.size()>0)
						 {
							    for(int j=0;j<list.size();j++)
								{
							    	SysPost sysPost=list.get(j);
							    	String postCode=sysPost.getPostCode();
							    	String postName=sysPost.getPostName();
							    	System.out.println("============ postName ="+ postName);
							    	if(postName.contains("成果转化备案"))
							    	{
							    		specialAuditor1_sb.append(postCode).append("-");
							    	}
							    	
								}
						 }
					}
					
				}
				specialAuditor1=specialAuditor1_sb.toString();
				if(!specialAuditor1.equals(""))
				{
					specialAuditor1= specialAuditor1.substring(0,specialAuditor1.length() - 1);
				}
				
			}
			paramMap.put("specialAuditor1", specialAuditor1);
			System.out.println("============specialAuditor1 ="+specialAuditor1);
			HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(paramMap,this.httpHeaders);
			rs = this.restTemplate.exchange(WORKFLOW_URL + id, HttpMethod.POST, httpEntity, Result.class).getBody();
			
		}else
		{
			rs.setSuccess(false);
		}
		return rs;
	}
}
