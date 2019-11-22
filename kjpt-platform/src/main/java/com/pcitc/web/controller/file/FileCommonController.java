package com.pcitc.web.controller.file;

import com.pcitc.base.common.FileModel;
import com.pcitc.web.common.RestBaseController;
import com.pcitc.web.utils.FileUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * 附件
 * @author ty
 */

@Controller
@Api(value = "file-api", description = "文件")
@RequestMapping(value="/file")
public class FileCommonController extends RestBaseController {

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

    @Autowired
    private FileUtil fileUtil;

    @ApiOperation(value = "获取文件列表", notes = "获取文件列表")
    @RequestMapping(value="/query/{dataId}",method = RequestMethod.GET)
    @ResponseBody
    public List<FileModel> query(@PathVariable(value = "dataId") String dataId){
        ResponseEntity<List> responseEntity = this.restTemplate.exchange(query+dataId, HttpMethod.GET, new HttpEntity(this.httpHeaders), List.class);
        return responseEntity.getBody();
    }


    @ApiOperation(value = "上传附件立即保存", notes = "上传附件立即保存")
    @RequestMapping(value="/upload",method = RequestMethod.POST)
    @ResponseBody
    public FileModel upload(@RequestParam(value = "file") MultipartFile file) throws IOException {
        FileModel f = fileUtil.upload(file);
        this.setBaseData(f);
        f.setCreateDate(new Date());
        f.setCreator(this.getUserProfile().getUserName());
        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        this.restTemplate.exchange(save, HttpMethod.POST, new HttpEntity<FileModel>(f,this.httpHeaders), (Class<Object>) null);
        return f;
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
        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<FileModel> responseEntity = this.restTemplate.exchange(downLoad+fileId, HttpMethod.GET, new HttpEntity<String>(fileId,this.httpHeaders), FileModel.class);
        fileUtil.responseFile(responseEntity.getBody(),false,this.getCurrentResponse());
    }



}



