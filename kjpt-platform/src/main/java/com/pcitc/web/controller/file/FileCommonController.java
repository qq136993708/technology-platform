package com.pcitc.web.controller.file;

import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.FileModel;
import com.pcitc.base.common.Result;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.common.RestBaseController;
import com.pcitc.web.utils.FileUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.List;

/**
 * 附件
 * @author ty
 */

@RestController
@Api(value = "file-api", description = "文件")
@RequestMapping(value="/file")
public class FileCommonController extends BaseController {

    /**
     * 查询平台列表
     */
    private static final String query = "http://kjpt-zuul/stp-proxy/file/query/";
    /**
     * 数据及对应附件的信息保存
     */
    private static final String save = "http://kjpt-zuul/stp-proxy/file/save/";
    /**
     * 文件上传
     */
    private static final String upload = "http://kjpt-zuul/stp-proxy/file/upload";
    /**
     * 下载
     */
    private static final String downLoad = "http://kjpt-zuul/stp-proxy/file/downLoad/";
    /**
     * 获取pdf页码
     */
    private static final String getPdfPageCount = "http://10.102.111.142:8099/preview/localPageCount?fileName=%s&filePath=%s";
    //http://10.102.111.142:8099/preview/local?fileName=1&filePath=1

    /**
     * 预览
     */
    private static final String getPrepareContent = "http://10.102.111.142:8099/preview/local?fileName=%s&filePath=%s&page=%s";

    @Autowired
    private FileUtil fileUtil;

    @Value("${baseFilePath}")
    private String fileBasePath;
    @Value("${prepareServerUserName}")
    private String prepareServerUserName;
    @Value("${prepareServerPassword}")
    private String prepareServerPassword;



    @ApiOperation(value = "获取文件列表", notes = "获取文件列表")
    @RequestMapping(value="/query/{dataId}",method = RequestMethod.GET)
    @ResponseBody
    public Result query(@PathVariable(value = "dataId") String dataId){
        ResponseEntity<List> responseEntity = this.restTemplate.exchange(query+dataId, HttpMethod.GET, new HttpEntity(this.httpHeaders), List.class);
        Result r = new Result();
        r.setCode(Result.RESPONSE_SUCC_CODE);
        r.setMessage(Result.RESPONSE_SUCC_MSG);
        r.setData(responseEntity.getBody());
        return r;
    }


    @ApiOperation(value = "上传附件立即保存", notes = "上传附件立即保存")
    @RequestMapping(value="/upload",method = RequestMethod.POST, produces="text/plain;charset=UTF-8")
    public String upload(@RequestParam(value = "file") MultipartFile file) throws IOException {
        FileModel f = fileUtil.upload(file);
        f.setCreateDate(new Date());
        f.setCreator(this.getUserProfile().getUserName());
        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        this.restTemplate.exchange(save, HttpMethod.POST, new HttpEntity<FileModel>(f,this.httpHeaders), (Class<Object>) null);
        Result r = new Result();
        r.setCode(Result.RESPONSE_SUCC_CODE);
        r.setMessage(Result.RESPONSE_SUCC_MSG);
        r.setData(f);
        return JSONObject.toJSONString(r);
    }

    @ApiOperation(value = "文件下载", notes = "文件下载")
    @RequestMapping(value="/downLoadFile/{fileId}",method = RequestMethod.GET)
    public void downLoadFile(@PathVariable String fileId) {
        ResponseEntity<FileModel> responseEntity = this.restTemplate.exchange(downLoad+fileId, HttpMethod.GET, new HttpEntity<String>(fileId,this.httpHeaders), FileModel.class);
        fileUtil.responseFile(responseEntity.getBody(),true,this.getCurrentResponse());
    }

    @ApiOperation(value = "图片展示", notes = "图片展示")
    @RequestMapping(value="/imgFile/{fileId}",method = RequestMethod.GET)
    public void imgFile(@PathVariable String fileId){
        this.addAuth();
        ResponseEntity<FileModel> responseEntity = this.restTemplate.exchange(downLoad+fileId, HttpMethod.GET, new HttpEntity<String>(fileId,this.httpHeaders), FileModel.class);
        FileModel f = responseEntity.getBody();
        f.getFileName();
        f.getFilePath();
        ResponseEntity<Integer> getCount = this.restTemplate.exchange(downLoad+fileId, HttpMethod.GET, new HttpEntity(this.httpHeaders), Integer.class);
        //return getCount.getBody();
    }


    @ApiOperation(value = "获取预览word的pdf的总页码", notes = "获取预览word的pdf的总页码")
    @RequestMapping(value="/getPdfPageCount/{fileId}",method = RequestMethod.GET)
    public Integer getPdfpageCount(@PathVariable String fileId) {
        ResponseEntity<FileModel> responseEntity = this.restTemplate.exchange(downLoad+fileId, HttpMethod.GET, new HttpEntity<String>(fileId,this.httpHeaders), FileModel.class);
        FileModel f = responseEntity.getBody();
        RestTemplate template = new RestTemplate();
        addAuth();
        ResponseEntity<Integer> getCount = template.exchange(String.format(getPdfPageCount,f.getFileName(),getFilePath(f.getFilePath())), HttpMethod.GET, new HttpEntity(this.httpHeaders), Integer.class);
        return getCount.getBody();
    }

    private  void addAuth(){
        String auth = prepareServerUserName + ":" + prepareServerPassword;
        byte[] encodedAuth = Base64.encodeBase64(
                auth.getBytes(Charset.forName("US-ASCII")));
        String authHeader = "Basic " + new String(encodedAuth);
        this.httpHeaders.set("Authorization", authHeader);
    }

    private  HttpHeaders getAuth(){
        HttpHeaders httpHeader = new HttpHeaders();
        String auth = prepareServerUserName + ":" + prepareServerPassword;
        byte[] encodedAuth = Base64.encodeBase64(
                auth.getBytes(Charset.forName("US-ASCII")));
        String authHeader = "Basic " + new String(encodedAuth);
        httpHeader.set("Authorization", authHeader);
        return httpHeader;
    }


    @ApiOperation(value = "获取预览内容", notes = "获取预览内容")
    @RequestMapping(value="/getPdfPageContent/{fileId}/{pageNum}",method = RequestMethod.GET)
    public void getPrepareContent(@PathVariable String fileId,@PathVariable Integer pageNum) {
        ResponseEntity<FileModel> responseEntity = this.restTemplate.exchange(downLoad+fileId, HttpMethod.GET, new HttpEntity<String>(fileId,this.httpHeaders), FileModel.class);
        FileModel f = responseEntity.getBody();
        RestTemplate template = new RestTemplate();
        addAuth();
        ResponseEntity<String> filePath = template.exchange(String.format(getPrepareContent,f.getFileName(),getFilePath(f.getFilePath()),pageNum), HttpMethod.GET, new HttpEntity(this.httpHeaders), String.class);
        FileUtil.prepare(new File(filePath.getBody()),this.getCurrentResponse(),"image/jpeg");
    }

    /**
     *获取文件存储路径
     * @return
     */
    private String getFilePath(String path){
        String dirPath = fileBasePath;

        File file =new File(dirPath+path);
        if  (!file .exists()  && !file .isDirectory())
            {
            file.mkdirs();
        }
        return dirPath+path;
    }


}



