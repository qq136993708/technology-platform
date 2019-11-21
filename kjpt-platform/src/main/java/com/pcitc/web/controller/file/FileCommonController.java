package com.pcitc.web.controller.file;

import com.pcitc.base.common.FileModel;
import com.pcitc.base.researchPlatform.PlatformInfoModel;
import com.pcitc.web.common.RestBaseController;
import com.pcitc.web.utils.FileUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
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

    @Autowired
    private FileUtil fileUtil;

    @ApiOperation(value = "获取文件列表", notes = "获取文件列表")
    @RequestMapping(value="/query/{dataId}",method = RequestMethod.GET)
    @ResponseBody
    public List<FileModel> query(@PathVariable(value = "dataId") String dataId){
        ResponseEntity<List> responseEntity = this.restTemplate.exchange(query+dataId, HttpMethod.GET, new HttpEntity(this.httpHeaders), List.class);
        return responseEntity.getBody();
    }

    @ApiOperation(value = "文件上传", notes = "文件上传")
    @RequestMapping(value="/upload",method = RequestMethod.POST)
    @ResponseBody
    public FileModel upload(@RequestParam(value = "file") MultipartFile file,@RequestParam(value = "dataId") String dataId) throws IOException {
        FileModel f = fileUtil.upload(file);
        f.setCreator(this.getUserProfile().getUserName());
        f.setDataId(dataId);
        f.setUpdator(this.getUserProfile().getUserName());
        f.setUpdateDate(new Date());
        f.setDeleted("0");
        return f;
    }

    @ApiOperation(value = "保存文件对应数据关系", notes = "保存文件对应数据关系")
    @RequestMapping(value="/save/{dataId}",method = RequestMethod.POST)
    @ResponseBody
    public List<FileModel> save(@PathVariable String dataId,@RequestBody List<FileModel> list){
        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<List> responseEntity = this.restTemplate.exchange(save+dataId, HttpMethod.POST, new HttpEntity<List>(list,this.httpHeaders), List.class);
        return responseEntity.getBody();
    }

    @ApiOperation(value = "文件下载", notes = "文件下载")
    @RequestMapping(value="/downLoad",method = RequestMethod.GET)
    @ResponseBody
    public void downLoad(@RequestBody FileModel fm) throws IOException {
        FileUtil.fileDownload(fm,this.getCurrentResponse());
    }


}



