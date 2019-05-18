package com.pcitc.web.controller.system;

import java.io.*;
import java.net.URLEncoder;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pcitc.base.util.*;
import com.pcitc.web.utils.RestfulHttpClient;
import feign.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.FileResult;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.common.UploadType;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.system.SysFile;
import com.pcitc.base.system.SysFileVo;
import com.pcitc.base.system.SysUser;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.feign.SysFileFeignClient;

/**
 * <p>
 * 控制类
 * </p>
 * <p>
 * Table: sys_file -
 * </p>
 *
 * @since 2018-05-08 02:04:50
 */
@RestController
public class SysFileController extends BaseController {

    @Autowired
    private SysFileFeignClient sysFileFeignClient;

    private static final String LIST = "http://pcitc-zuul/system-proxy/sysfile-provider/sysfile/list";

    private static final String getTableData = "http://pcitc-zuul/system-proxy/sysfile-provider/sysfile/getTableData";

    private static final String getTableDataEs = "http://pcitc-zuul/system-proxy/sysfile-provider/sysfile/getTableDataEs";

    private static final String GET = "http://pcitc-zuul/system-proxy/sysfile-provider/sysfile/get-sysfile/";
    private static final String TREE_DATA = "http://pcitc-zuul/system-proxy/sysfile-provider/sysfile/tree-data";
    private static final String ADD = "http://pcitc-zuul/system-proxy/sysfile-provider/sysfile/add-sysfile";
    private static final String UPDATE = "http://pcitc-zuul/system-proxy/sysfile-provider/sysfile/update-sysfile";
    private static final String DEL = "http://pcitc-zuul/system-proxy/sysfile-provider/sysfile/del-sysfile/";
    private static final String DEL_REAL = "http://pcitc-zuul/system-proxy/sysfile-provider/sysfile/del-sysfile-real/";
    /**
     * 更新文件状态
     */
    private static final String UPDATE_FILE_FLAG = "http://pcitc-zuul/system-proxy/sysfile-provider/sysfile/update-file-flag/";
    /**
     * 删除表单文件
     */
    private static final String DELETE_FILE_FORM = "http://pcitc-zuul/system-proxy/sysfile-provider/sysfile/delete-form-file/";

    private static final String avatarUpload = "http://pcitc-zuul/system-proxy/sysfile-provider/sysfile/avatarUpload";
    /**
     * markdown组件上传图片
     */
    private static final String markdownUpload = "http://pcitc-zuul/system-proxy/sysfile-provider/sysfile/markdownUpload";
    /**
     * 跳转到通用文件上传窗口
     */
    private static final String uploader = "http://pcitc-zuul/system-proxy/sysfile-provider/sysfile/uploader";
    /**
     * 通用文件上传接口，存储到固定地址，以后存储到文件服务器地址
     */
    private static final String uploadFile = "http://pcitc-zuul/system-proxy/sysfile-provider/sysfile/uploadFile";
    /**
     * 多文件上传，用于uploadAsync=false(同步多文件上传使用)
     */
    private static final String uploadMultipleFile = "http://pcitc-zuul/system-proxy/sysfile-provider/sysfile/uploadMultipleFile";
    /**
     * 删除某一项文件
     */
    private static final String delete = "http://pcitc-zuul/system-proxy/sysfile-provider/sysfile/delete";
    /**
     * 下载
     */
    private static final String download = "http://pcitc-zuul/system-proxy/sysfile-provider/sysfile/download/";
    private static final String video = "http://pcitc-zuul/system-proxy/sysfile-provider/sysfile/video/";
    private static final String downloads = "http://pcitc-zuul/system-proxy/sysfile-provider/sysfile/downloads/";
    private static final String previewImgagByByteBase64 = "http://pcitc-zuul/system-proxy/sysfile-provider/sysfile/previewImgagByByteBase64/";
    private static final String showFlag = "http://pcitc-zuul/system-proxy/sysfile-provider/sysfile/showFlag/";
    /**
     * 获取字体图标map,base-file控件使用
     */
    private static final String icons = "http://pcitc-zuul/system-proxy/sysfile-provider/sysfile/icons";
    /**
     * 获取上传文件
     */
    private static final String getFiles = "http://pcitc-zuul/system-proxy/sysfile-provider/sysfile/getFiles";
    private static final String getFilesLayui = "http://pcitc-zuul/system-proxy/sysfile-provider/sysfile/getFilesLayui";
    private static final String getFilesLayuiByFormId = "http://pcitc-zuul/system-proxy/sysfile-provider/sysfile/getFilesLayuiByFormId";
    /**
     * 组装展示页面
     */
    private static final String getPreivewSettings = "http://pcitc-zuul/system-proxy/sysfile-provider/sysfile/getPreivewSettings";
    /**
     * 单文件上传获取文件信息
     */
    private static final String uploadFileSave = "http://pcitc-zuul/system-proxy/sysfile-provider/sysfile/uploadFileSave";

    private static final String uploadFileSavetest = "http://pcitc-zuul/system-proxy/sysfile-provider/sysfile/uploadFileSavetest";

    /**
     * 查询用户信息
     */
    private static final String USER_DETAILS_URL = "http://pcitc-zuul/system-proxy/user-provider/user/user-details/";

    private static final String commonFileList = "http://pcitc-zuul/system-proxy/file-common-provider/files/common/data-list";

    // 文件上传路径
    @Value("${uploaderPathTemp}")
    private String uploaderPathTemp;

    @RequestMapping(value = "/sysfile/uploadMultipleFileLayuiCroppers", method = RequestMethod.POST)
    @ResponseBody
    public FileResult uploadMultipleFileLayuiCroppers(@RequestParam(value = "file", required = false) MultipartFile[] files) throws IOException {

        String filedflag = request.getParameter("filedflag");//值
        String formId = request.getParameter("formId");//菜单ID
        String flag = "0";//标志
        String tempFileName = "header.png";
        FileResult result = null;

        String param = request.getParameter("param");
        JSONArray jsonArray = new JSONArray();
        if (param != null && !"".equals(param)) {
            jsonArray = JSONArray.parseArray(param);
        }
        try {
            List<SysFile> fileList = new ArrayList<>();
            for (int i = 0; i < files.length; i++) {
                MultipartFile file = files[i];
                String uuid = IdUtil.createIdByTime();
                JSONObject jsonObjects = (jsonArray.size() == 0) ? (new JSONObject()) : (JSONObject) jsonArray.get(i);
                jsonObjects.put("flag", flag);
                sysFileFeignClient.uploadFileSaveLayui(file, request, response, tempFileName, filedflag, sysUserInfo.getUserId(), uuid, formId, jsonObjects.toJSONString());
                SysFile sysFile = this.restTemplate.exchange(GET + uuid, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), SysFile.class).getBody();
                fileList.add(sysFile);
            }
            result = new FileResult();
            result.setList(fileList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping(value = "/sysfile/uploadMultipleFileLayui", method = RequestMethod.POST)
    @ResponseBody
    public FileResult uploadMultipleFileLayui(@RequestParam(value = "file", required = false) MultipartFile[] files, HttpServletRequest request, HttpServletResponse response) throws IOException {
        FileResult result = null;
        try {
            List<SysFile> fileList = new ArrayList<>();
            for (int i = 0; i < files.length; i++) {
                /** 转换文件 */
                MultipartFile file = files[i];
                String tempFileName = file.getOriginalFilename();
                if (tempFileName.indexOf("\\") > -1) {
                    tempFileName = tempFileName.substring(tempFileName.lastIndexOf("\\") + 1, tempFileName.length());
                }
                String uuid = IdUtil.createIdByTime();
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("flag", request.getParameter("flag"));
                sysFileFeignClient.uploadFileSaveLayui(file, request, response, tempFileName, request.getParameter("filedflag"), sysUserInfo.getUserId(), uuid, request.getParameter("formId"), jsonObject.toJSONString());
                SysFile sysFile = this.restTemplate.exchange(GET + uuid, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), SysFile.class).getBody();
                fileList.add(sysFile);
            }
            result = new FileResult();
            result.setList(fileList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.addHeader("Access-Control-Allow-Origin", "*");
        return result;
    }

    @RequestMapping(value = "/sysfile/mobileUploadMultipleFileLayui", method = RequestMethod.POST)
    @ResponseBody
    public Object mobileUploadMultipleFileLayui(@RequestParam(value = "file", required = false) MultipartFile[] files, HttpServletRequest request, HttpServletResponse response) throws IOException {
        FileResult result = null;
        String param = request.getParameter("param");
        JSONArray jsonArray = JSONArray.parseArray(param);
        List<SysFile> fileList = new ArrayList<>();
        try {
            for (int i = 0; i < files.length; i++) {
                MultipartFile file = files[i];
                String tempFileName = file.getOriginalFilename();
                if (tempFileName.indexOf("\\") > -1) {
                    tempFileName = tempFileName.substring(tempFileName.lastIndexOf("\\") + 1, tempFileName.length());
                }
                JSONObject jsonObjects = (JSONObject) jsonArray.get(i);
                jsonObjects.put("flag", request.getParameter("flag"));
                String uuid = IdUtil.createIdByTime();
                sysFileFeignClient.uploadFileSaveLayui(file, request, response, tempFileName, request.getParameter("filedflag"), "mobile", uuid, request.getParameter("formId"), jsonObjects.toJSONString());
                SysFile sysFile = this.restTemplate.exchange(GET + uuid, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), SysFile.class).getBody();
                fileList.add(sysFile);
            }
            result = new FileResult();
            result.setList(fileList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.addHeader("Access-Control-Allow-Origin", "*");
        JSONObject retuJson = new JSONObject();
        if (result == null || result.getList().size() == 0) {
            retuJson.put("status", "fail");
        } else {
            retuJson.put("picId", fileList.get(0).getId());
            retuJson.put("picName", fileList.get(0).getFileName());
            String createDateTime = fileList.get(0).getCreateDateTime();
            retuJson.put("createDateTime", createDateTime.substring(0, createDateTime.lastIndexOf(" ")));
            retuJson.put("picPath", fileList.get(0).getFilePath());
            retuJson.put("bak8", fileList.get(0).getBak8());
            retuJson.put("status", "success");
        }
        return retuJson;
    }

    @RequestMapping(value = "/sysfile/uploadMultipleFileLayuiIE", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public FileResult uploadMultipleFileLayuiIE(@RequestParam(value = "file", required = false) MultipartFile[] files, HttpServletRequest request, HttpServletResponse response) throws IOException {
        FileResult result = null;
        try {
            List<SysFile> fileList = new ArrayList<>();
            for (int i = 0; i < files.length; i++) {
                /** 转换文件 */
                MultipartFile file = files[i];
                String tempFileName = file.getOriginalFilename();
                if (tempFileName.indexOf("\\") > -1) {
                    tempFileName = tempFileName.substring(tempFileName.lastIndexOf("\\") + 1, tempFileName.length());
                }
                String uuid = IdUtil.createIdByTime();
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("flag", request.getParameter("flag"));
                sysFileFeignClient.uploadFileSaveLayui(file, request, response, tempFileName, request.getParameter("filedflag"), sysUserInfo.getUserId(), uuid, request.getParameter("formId"), jsonObject.toJSONString());
                SysFile sysFile = this.restTemplate.exchange(GET + uuid, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), SysFile.class).getBody();
                fileList.add(sysFile);
            }
            result = new FileResult();
            result.setList(fileList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.addHeader("Access-Control-Allow-Origin", "*");
        return result;
        //        FileResult result = null;
//        String param = request.getParameter("param");
//        String flag = request.getParameter("flag");
//        JSONArray jsonArray = new JSONArray();
//        if(param!=null&&!"".equals(param)){
//            jsonArray = JSONArray.parseArray(param);
//        }
//        try {
//            List<SysFile> fileList = new ArrayList<>();
//            for (int i = 0; i < files.length; i++) {
//                /** 转换文件 */
//                MultipartFile file = files[i];
//                String tempFileName = file.getOriginalFilename();
//                if (tempFileName.indexOf("\\") > -1) {
//                    tempFileName = tempFileName.substring(tempFileName.lastIndexOf("\\") + 1, tempFileName.length());
//                }
//                JSONObject jsonObjects  = (jsonArray.size()==0)?(new JSONObject()):(JSONObject) jsonArray.get(i);
//                jsonObjects.put("flag",flag);
//                String uuid = IdUtil.createIdByTime();
//                sysFileFeignClient.uploadFileSaveLayui(file, request, response, tempFileName, request.getParameter("filedflag"), sysUserInfo.getUserId(), uuid, request.getParameter("formId"), jsonObjects.toJSONString());
//                SysFile sysFile = this.restTemplate.exchange(GET + uuid, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), SysFile.class).getBody();
//                fileList.add(sysFile);
//            }
//            result = new FileResult();
//            result.setList(fileList);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        response.addHeader("Access-Control-Allow-Origin", "*");
//        return result;
    }

    @RequestMapping(value = "/sysfile/download/{id}", method = RequestMethod.GET, produces = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<byte[]> downloadFile(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws IOException {
        MultiValueMap<String, String> form = new LinkedMultiValueMap<>();
        form.add("id", id);
        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(form, this.httpHeaders);
        ResponseEntity<byte[]> responseEntity = this.restTemplate.postForEntity(((id.split("\\|").length > 1) ? downloads : download) + id, httpEntity, byte[].class);
        byte[] result = responseEntity.getBody();
        httpHeaders.add("x-frame-options", "SAMEORIGIN");
        response.addHeader("x-frame-options", "SAMEORIGIN");
        return responseEntity;
    }

    //    @RequestMapping(value = "/sysfile/video/{id}", method = RequestMethod.GET, produces = MediaType.MULTIPART_FORM_DATA_VALUE)
    @RequestMapping(value = "/sysfile/video/{id}", method = RequestMethod.GET)
    public ResponseEntity<InputStreamResource> videoFile(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) {
//    public ResponseEntity<byte[]> videoFile(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response){

        this.httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> form1 = new LinkedMultiValueMap<String, String>();
        form1.add("fileIds", id);
        HttpEntity<MultiValueMap<String, String>> httpEntity1 = new HttpEntity<>(form1, httpHeaders);
        ResponseEntity<FileResult> responseEntity1 = this.restTemplate.postForEntity(getFilesLayuiByFormId, httpEntity1, FileResult.class);
        FileResult fileResult = responseEntity1.getBody();
        if ((fileResult.getList().size() == 0)) {
            return null;
        }
        id = fileResult.getList().get(0).getId();
        ResponseEntity<InputStreamResource> inputStreamResource = null;
        Response res = sysFileFeignClient.videoFiles(id, request, response);
        Response.Body body = res.body();
        try {
            InputStream inputStream = body.asInputStream();
            InputStreamResource resource = new InputStreamResource(inputStream);
            inputStreamResource = ResponseEntity.ok().contentType(MediaType.APPLICATION_OCTET_STREAM).headers(httpHeaders).body(resource);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return inputStreamResource;
        }

//        this.httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//        MultiValueMap<String, String> form1 = new LinkedMultiValueMap<String, String>();
//        form1.add("fileIds", id);
//        HttpEntity<MultiValueMap<String, String>> httpEntity1 = new HttpEntity<>(form1, httpHeaders);
//        ResponseEntity<FileResult> responseEntity1 = this.restTemplate.postForEntity(getFilesLayuiByFormId, httpEntity1, FileResult.class);
//        FileResult fileResult = responseEntity1.getBody();
//        if ((fileResult.getList().size() == 0)) {
//            return null;
//        }
//        id = fileResult.getList().get(0).getId();
//        MultiValueMap<String, String> form = new LinkedMultiValueMap<>();
//        form.add("id", id);
//        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(form, this.httpHeaders);
//        ResponseEntity<byte[]> responseEntity = this.restTemplate.postForEntity(video+ id, httpEntity, byte[].class);
//        httpHeaders.add("x-frame-options", "ALLOW-FROM");
//        response.addHeader("x-frame-options", "ALLOW-FROM");
//        return responseEntity;
    }

    /**
     * 通过md5值，查询sys_file（存在多个），判断当前人，是否有这些file的权限，只要有权限，就能下载这个文件
     */
    @RequestMapping(value = "/sysfile/md5/download/{fileMd5}")
    public Result downloadFileByMd5(@PathVariable("fileMd5") String fileMd5, HttpServletRequest request, HttpServletResponse response) {
        LayuiTableParam param = new LayuiTableParam();
        param.getParam().put("userId", sysUserInfo.getUserId());
        param.getParam().put("fileMd5", fileMd5);

        LayuiTableData layuiTableData = new LayuiTableData();
        HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
        ResponseEntity<LayuiTableData> fileEntity = restTemplate.exchange(commonFileList, HttpMethod.POST, entity, LayuiTableData.class);
        layuiTableData = fileEntity.getBody();
        Result retJson = new Result();
        retJson.setSuccess(false);
        if (layuiTableData.getData().size() > 0) {
            JSONArray array = JSONArray.parseArray(JSON.toJSONString(layuiTableData.getData()));
            String fileId = array.getJSONObject(0).getString("id");
            retJson.setSuccess(true);
            retJson.setData(fileId);
        }
        return retJson;
    }

    @RequestMapping(value = "/sysfile/viewPic/{id}", method = RequestMethod.GET)
    public String viewPic(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws IOException {
        MultiValueMap<String, String> form = new LinkedMultiValueMap<>();
        form.add("id", id);
        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(form, this.httpHeaders);
        ResponseEntity<byte[]> responseEntity = this.restTemplate.postForEntity(((id.split("\\|").length > 1) ? downloads : download) + id, httpEntity, byte[].class);
        byte[] bytes = responseEntity.getBody();
        String picBase64 = "data:image/png;base64,";
        return picBase64 + new sun.misc.BASE64Encoder().encode(bytes);

    }

    @RequestMapping(value = "/sysfile/viewPicByte/{id}", method = RequestMethod.GET)
    public ResponseEntity<byte[]> viewPic2(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws IOException {
        MultiValueMap<String, String> form = new LinkedMultiValueMap<>();
        form.add("id", id);
        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(form, this.httpHeaders);
        ResponseEntity<byte[]> responseEntity = this.restTemplate.postForEntity(((id.split("\\|").length > 1) ? downloads : download) + id, httpEntity, byte[].class);

        return responseEntity;
    }

    @RequestMapping(value = "/sysfile/previewImgagByByteBase64/{id}", method = RequestMethod.GET)
    public ResponseEntity<byte[]> previewImgagByByteBase64(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws IOException {
        MultiValueMap<String, String> form = new LinkedMultiValueMap<>();
        form.add("id", id);
        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(form, this.httpHeaders);
        ResponseEntity<byte[]> responseEntity = this.restTemplate.postForEntity(previewImgagByByteBase64 + id, httpEntity, byte[].class);
        return responseEntity;
    }

    @RequestMapping(value = "/sysfile/previewImgagByByteBase64String/{id}", method = RequestMethod.GET)
    public String previewImgagByByteBase64String(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws IOException {
        MultiValueMap<String, String> form = new LinkedMultiValueMap<>();
        form.add("id", id);
        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(form, this.httpHeaders);
        ResponseEntity<byte[]> responseEntity = this.restTemplate.postForEntity(previewImgagByByteBase64 + id, httpEntity, byte[].class);
        byte[] bytes = responseEntity.getBody();
        String picBase64 = "data:image/png;base64,";
        return picBase64 + new sun.misc.BASE64Encoder().encode(bytes);
    }

    /**
     * 根据附件IDS 获取文件
     *
     * @param fileIds
     * @param request
     * @return
     */
    @RequestMapping(value = "/sysfile/getFiles", method = RequestMethod.POST)
    @ResponseBody
    public FileResult getFiles(String fileIds, HttpServletRequest request) {
        // this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        this.httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> form = new LinkedMultiValueMap<String, String>();
        form.add("fileIds", fileIds);
        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(form, httpHeaders);
        ResponseEntity<FileResult> responseEntity = this.restTemplate.postForEntity(getFiles, httpEntity, FileResult.class);

        return responseEntity.getBody();
    }

    /**
     * 根据附件IDS 获取文件
     *
     * @param fileIds
     * @param request
     * @return
     */
    @RequestMapping(value = "/sysfile/getFilesLayui", method = RequestMethod.POST)
    @ResponseBody
    public FileResult getFilesLayui(String fileIds, HttpServletRequest request) {
        // this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        this.httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> form = new LinkedMultiValueMap<String, String>();
        form.add("fileIds", fileIds);
        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(form, httpHeaders);
        ResponseEntity<FileResult> responseEntity = this.restTemplate.postForEntity(getFilesLayui, httpEntity, FileResult.class);
        return responseEntity.getBody();
    }

    /**
     * 根据文件ID 获取文件
     *
     * @param fileIds
     * @param request
     * @return
     */
    @RequestMapping(value = "/sysfile/getFilesLayuiByFormId", method = RequestMethod.POST)
    @ResponseBody
    public FileResult getFilesLayuiByFormId(String fileIds, HttpServletRequest request) {
        // this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        this.httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> form = new LinkedMultiValueMap<String, String>();
        form.add("fileIds", fileIds);
        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(form, httpHeaders);
        ResponseEntity<FileResult> responseEntity = this.restTemplate.postForEntity(getFilesLayuiByFormId, httpEntity, FileResult.class);
        return responseEntity.getBody();
    }

    @RequestMapping(value = "/sysfile/getFilesLayuiByFormIdReturnBase64", method = RequestMethod.GET)
    public String getFilesLayuiByFormIdReturnBase64(String fileIds, HttpServletRequest request) {
        this.httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> form = new LinkedMultiValueMap<String, String>();
        fileIds = (request.getParameter("fileIds"));
        form.add("fileIds", fileIds);
        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(form, httpHeaders);
        ResponseEntity<FileResult> responseEntity = this.restTemplate.postForEntity(getFilesLayuiByFormId, httpEntity, FileResult.class);
//		return responseEntity.getBody();
        FileResult fileResult = responseEntity.getBody();
        if ((fileResult.getList().size() == 0)) {
            return null;
        }
        String strId = fileResult.getList().get(0).getId();
        MultiValueMap<String, String> form64 = new LinkedMultiValueMap<>();
        form.add("id", strId);
        HttpEntity<MultiValueMap<String, String>> httpEntity64 = new HttpEntity<>(form, this.httpHeaders);
        ResponseEntity<byte[]> responseEntity64 = this.restTemplate.postForEntity(download + strId, httpEntity64, byte[].class);
        return "data:image/png;base64," + new sun.misc.BASE64Encoder().encode(responseEntity64.getBody());
    }

    /**
     * @param id
     * @param request
     * @return
     */
    @RequestMapping(value = "/sysfile/getFilesLayuiByFormIdReturnBase64Image/{id}", method = RequestMethod.GET)
    public ResponseEntity<byte[]> getFilesLayuiByFormIdReturnBase64Image(@PathVariable("id") String id, HttpServletRequest request) {
        String str = "";
        ResponseEntity<byte[]> responseEntity64 = null;
        try {
            this.httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
            MultiValueMap<String, String> form = new LinkedMultiValueMap<String, String>();
            form.add("fileIds", id);
            HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(form, httpHeaders);
            ResponseEntity<FileResult> responseEntity = this.restTemplate.postForEntity(getFilesLayuiByFormId, httpEntity, FileResult.class);
            FileResult fileResult = responseEntity.getBody();
            if ((fileResult.getList().size() == 0)) {
                return null;
            }
            String strId = fileResult.getList().get(0).getId();
            this.httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
            MultiValueMap<String, String> form64 = new LinkedMultiValueMap<>();
            form64.add("id", strId);
            HttpEntity<MultiValueMap<String, String>> httpEntity64 = new HttpEntity<>(form64, this.httpHeaders);
            responseEntity64 = this.restTemplate.postForEntity(download + strId, httpEntity64, byte[].class);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return responseEntity64;
        }
    }

    /**
     * 获取字体图标map,base-file控件使用
     */
    @RequestMapping(value = "/sysfile/icons", method = RequestMethod.POST)
    @ResponseBody
    public Map getIcons() {
        return UploadType.fileIconMap;
    }

    // 删除某一项文件
    @RequestMapping(value = "/sysfile/delete", method = RequestMethod.POST)
    @ResponseBody
    public Result delete(String id) {
        MultiValueMap<String, String> form = new LinkedMultiValueMap<String, String>();
        form.add("id", id);
        this.httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, String>> files = new HttpEntity<>(form, httpHeaders);
        ResponseEntity<Result> responseEntity = null;
        responseEntity = this.restTemplate.postForEntity(delete, files, Result.class);

        return responseEntity.getBody();
    }

    /**
     * 跳转到通用文件上传窗口
     *
     * @return
     */
    @RequestMapping(value = "/sysfile/uploader")
    public void uploader(String config, HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("config", config);
        try {
            // response.sendRedirect("/common/uploadfiledialog");
            request.getRequestDispatcher("/common/uploadfiledialog").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String handleFileUpload(HttpServletRequest request) {
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        MultipartFile file = null;
        BufferedOutputStream stream = null;
        for (int i = 0; i < files.size(); ++i) {
            file = files.get(i);
            String filePath = "D://aim//";
            if (!file.isEmpty()) {
                try {
                    byte[] bytes = file.getBytes();
                    stream = new BufferedOutputStream(new FileOutputStream(new File(filePath + file.getOriginalFilename())));// 设置文件路径及名字
                    stream.write(bytes);// 写入
                    stream.close();
                } catch (Exception e) {
                    stream = null;
                    return "第 " + i + " 个文件上传失败  ==> " + e.getMessage();
                }
            } else {
                return "第 " + i + " 个文件上传失败因为文件为空";
            }
        }
        return "上传成功";
    }

    @RequestMapping(value = "/sysfile/uploadSignMultipleFile", method = RequestMethod.POST)
    @ResponseBody
    public SysFile uploadSignMultipleFile(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 单个文件上传
        String uuid = IdUtil.createIdByTime();

        String rsStr = sysFileFeignClient.uploadFileSavetest(file, request, response, file.getOriginalFilename(), request.getParameter("fileId"), sysUserInfo.getUserId(), uuid);
        JSONArray array = JSON.parseArray(rsStr);
        
        SysFile sysFile = JSON.toJavaObject(JSON.parseObject(array.get(0).toString()), SysFile.class);
        System.out.println("=============");
        System.out.println(JSON.toJSONString(sysFile));
        return sysFile;
    }

    /**
     * 多文件上传，用于uploadAsync=false(同步多文件上传使用)
     *
     * @param
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/sysfile/uploadMultipleFile", method = RequestMethod.POST)
    @ResponseBody
    public FileResult uploadMultipleFile(@RequestParam(value = "file", required = false) MultipartFile[] files, HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 文件上传到指定目录
        // 保存文件信息
        // 返回
        // 异步调用
        FileResult rs = null;
        try {
            List<SysFile> fileList = new ArrayList<>();
            for (int i = 0; i < files.length; i++) {
                /** 转换文件 */
                MultipartFile file = files[i];
                String tempFileName = file.getOriginalFilename();// .substring(0,file.getOriginalFilename().lastIndexOf("."))
                String uuid = IdUtil.createIdByTime();
                sysFileFeignClient.uploadFileSavetest(file, request, response, tempFileName, request.getParameter("id"), sysUserInfo.getUserId(), uuid);
                SysFile sysFile = this.restTemplate.exchange(GET + uuid, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), SysFile.class).getBody();
                ;
                fileList.add(sysFile);
            }
            FileResult result = new FileResult();
            result.setList(fileList);

            HttpEntity<Object> entity = new HttpEntity<Object>(result, this.httpHeaders);
            rs = this.restTemplate.exchange(getPreivewSettings, HttpMethod.POST, entity, FileResult.class).getBody();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    /**
     * 通用文件上传接口，存储到固定地址，以后存储到文件服务器地址
     */
    @RequestMapping(value = "/sysfile-provider/sysfile/uploadFile", method = RequestMethod.POST)
    @ResponseBody
    public FileResult uploadFile(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws IOException {
        /** 转换文件 */
        String tempFileName = file.getOriginalFilename();// .substring(0,file.getOriginalFilename().lastIndexOf("."))
        String tempFilePath = uploaderPathTemp + "\\" + UUID.randomUUID();
        if (!new File(tempFilePath).exists()) {
            new File(tempFilePath).mkdirs();
        }
        File tempFile = new File((tempFilePath + "\\" + tempFileName));
        file.transferTo(tempFile);

        FileSystemResource fileSystemResource = new FileSystemResource(tempFilePath + "\\" + tempFileName);
        /** 设置文件头 */
        MediaType type = MediaType.parseMediaType("multipart/form-data; charset=UTF-8");
        // MediaType type = MediaType.parseMediaType("multipart/form-data");
        this.httpHeaders.setContentType(type);
        String cd = "filename=\"" + file.getOriginalFilename() + "\"";
        httpHeaders.add("Content-Disposition", cd);
        MultiValueMap<String, Object> form = new LinkedMultiValueMap<String, Object>();
        form.add("file", fileSystemResource);
        form.add("filename", tempFileName);
        HttpEntity<MultiValueMap<String, Object>> files = new HttpEntity<>(form, httpHeaders);
        ResponseEntity<FileResult> responseEntity = null;
        responseEntity = this.restTemplate.postForEntity(uploadFile, files, FileResult.class);
        try {
            tempFile.delete();
            new File(tempFilePath).delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseEntity.getBody();
    }

    /**
     * 查询菜单信息
     *
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/sysfile/get/{id}")
    @ResponseBody
    public String getSysFileInfo(@PathVariable String id) throws Exception {
        SysFile sysFile = this.restTemplate.exchange(GET + id, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), SysFile.class).getBody();
        return JSONObject.toJSONString(sysFile);
    }

    @RequestMapping(value = "/sysfile/tree-data")
    public Object getSysFileTreeData() throws Exception {
        TreeNode node = this.restTemplate.exchange(TREE_DATA, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), TreeNode.class).getBody();
        return node;
    }

    @RequestMapping(value = "/sysfile/tree-datas")
    @ResponseBody
    public String getSysFileTreeDatas() throws Exception {
        List list = this.restTemplate.exchange(TREE_DATA, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), List.class).getBody();
        return JSONUtils.toJSONString(list);
    }

    @RequestMapping(value = "/sysfile/add")
    public Object addSysFile(SysFile sysFile) throws Exception {
        HttpEntity<Object> entity = new HttpEntity<Object>(sysFile, this.httpHeaders);
        SysFile rs = this.restTemplate.exchange(ADD, HttpMethod.POST, entity, SysFile.class).getBody();
        return JSONObject.toJSONString(rs);
    }

    @RequestMapping(value = "/sysfile/update")
    public Object updateSysFile(SysFile sysFile) throws Exception {
        DataOperationStatusEnum rs = this.restTemplate.exchange(UPDATE, HttpMethod.POST, new HttpEntity<Object>(sysFile, this.httpHeaders), DataOperationStatusEnum.class).getBody();
        return rs;
    }

    @RequestMapping(value = "/sysfile/del")
    public Object delSysFile(String sysFileId) throws Exception {
        DataOperationStatusEnum rs = this.restTemplate.exchange(DEL + sysFileId, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), DataOperationStatusEnum.class).getBody();
        return rs;
    }

    @RequestMapping(value = "/sysfile/del-real")
    public Object delSysFileReal(String id) throws Exception {
        DataOperationStatusEnum rs = this.restTemplate.exchange(DEL_REAL + id, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), DataOperationStatusEnum.class).getBody();
        return rs;
    }

    /**
     * 更新文件状态
     *
     * @param dataId
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/sysfile/update-file-flag")
    public Object updateSysFileFlag(String dataId) throws Exception {
        DataOperationStatusEnum rs = this.restTemplate.exchange(UPDATE_FILE_FLAG + dataId, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), DataOperationStatusEnum.class).getBody();
        return rs;
    }

    /**
     * 删除文件通过表单ID
     *
     * @param dataId
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/sysfile/delete-form-file")
    public Object deleteSysFileByFormId(String dataId) throws Exception {
        DataOperationStatusEnum rs = this.restTemplate.exchange(DELETE_FILE_FORM + dataId, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), DataOperationStatusEnum.class).getBody();
        return rs;
    }

    @RequestMapping(value = "/sysfile/getTableData", method = RequestMethod.POST)
    @ResponseBody
    public Object getTableData(@ModelAttribute("param") LayuiTableParam param) throws IOException {
        DataTableInfoVo dataTableInfoVo = new DataTableInfoVo();
        dataTableInfoVo.setiDisplayLength(param.getLimit());
        dataTableInfoVo.setiDisplayStart((param.getPage() - 1) * param.getLimit());
        SysFileVo vo = new SysFileVo();
        vo.setDataTableInfoVo(dataTableInfoVo);
        if (param.getParam().get("parentId") != null) {
            vo.setFormId(param.getParam().get("parentId").toString());
        }
        if (param.getParam().get("fileName") != null) {
            vo.setFileName(param.getParam().get("fileName").toString());
        }
        if (param.getParam().get("fileKind") != null) {
            vo.setFileKind(param.getParam().get("fileKind").toString());
        }
        if (param.getParam().get("bak1") != null) {
            vo.setBak1(param.getParam().get("bak1").toString());
        }
        if (param.getParam().get("filePublish") != null) {
            vo.setFilePublish(sysUserInfo.getUserId());
        }
        // 查询用户岗位,部门,ID--start
        SysUser userDetails = this.restTemplate.exchange(USER_DETAILS_URL + sysUserInfo.getUserId(), HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SysUser.class).getBody();
        List<String> strings = new ArrayList<>();
        // strings.addAll(userInfo.getRoles());//用户角色
        strings.add(sysUserInfo.getUserId());// 用户ID
        strings.add(userDetails.getUserUnit());// 岗位
        vo.setValues(strings);
        // 查询用户岗位,部门,ID--end
        HttpEntity<SysFileVo> entity = new HttpEntity<SysFileVo>(vo, this.httpHeaders);
        ResponseEntity<String> responseEntity = this.restTemplate.exchange(getTableData, HttpMethod.POST, entity, String.class);
        String result = responseEntity.getBody();
        JSONObject retJson = JSONObject.parseObject(result);
        LayuiTableData data = new LayuiTableData();
        if (retJson != null) {
            int totalCount = retJson.get("totalCount") != null ? Integer.parseInt(retJson.get("totalCount").toString()) : 0;
            List<SysFile> SysFileList = JSONObject.parseArray(retJson.getJSONArray("list").toJSONString(), SysFile.class);
            if (SysFileList.size() > 0) {
                for (int i = 0; i < SysFileList.size(); i++) {
                    if ("1".equals(SysFileList.get(i).getBak3())) {
                        SysFileList.get(i).setBak3("是");
                    } else {
                        SysFileList.get(i).setBak3("否");
                    }
                }
            }
            data.setData(SysFileList);
            data.setCount(totalCount);
        }
        return JSON.toJSON(data).toString();
    }

    /**
     * ES查询
     *
     * @param param
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/sysfile/getTableDataEs", method = RequestMethod.POST)
    @ResponseBody
    public Object getTableDataEs(@ModelAttribute("param") LayuiTableParam param) throws IOException {
        DataTableInfoVo dataTableInfoVo = new DataTableInfoVo();
        dataTableInfoVo.setiDisplayLength(param.getLimit());
        dataTableInfoVo.setiDisplayStart((param.getPage() - 1) * param.getLimit());
        SysFileVo vo = new SysFileVo();
        vo.setDataTableInfoVo(dataTableInfoVo);
        if (param.getParam().get("bak4") != null) {
            vo.setFileName(param.getParam().get("bak4").toString());
        }
        if (param.getParam().get("fileKind") != null) {
            vo.setFileKind(param.getParam().get("fileKind").toString());
        }

        // if (ja.getJSONObject(i).getString("name").equals("bak4")) {
        // vo.setFileName(ja.getJSONObject(i).getString("value"));
        // }
        // else if (ja.getJSONObject(i).getString("name").equals("fileKind")) {
        // vo.setFileKind(ja.getJSONObject(i).getString("value"));
        // }
        HttpEntity<SysFileVo> entity = new HttpEntity<SysFileVo>(vo, this.httpHeaders);
        ResponseEntity<String> responseEntity = this.restTemplate.exchange(getTableDataEs, HttpMethod.POST, entity, String.class);
        String result = responseEntity.getBody();
        JSONObject retJson = JSONObject.parseObject(result);
        // DataTableParameter data = new DataTableParameter();
        LayuiTableData data = new LayuiTableData();
        if (retJson != null) {
            int totalCount = retJson.get("totalCount") != null ? Integer.parseInt(retJson.get("totalCount").toString()) : 0;
            List<SysFile> SysFileList = JSONObject.parseArray(retJson.getJSONArray("list").toJSONString(), SysFile.class);
            data.setData(SysFileList);
            // 要显示的总条数
            data.setCount(totalCount);
        }
        return data;
    }

    //
    // /**
    // * 文件查看-分页查询
    // * @param param
    // * @return
    // * @throws IOException
    // */
    // @RequestMapping(value = "/sysfile/list", method = RequestMethod.POST)
    // @ResponseBody
    // public Object getTableData(@ModelAttribute("param")LayuiTableParam param)
    // throws IOException {
    // HttpEntity<LayuiTableParam> entity = new
    // HttpEntity<LayuiTableParam>(param, this.httpHeaders);
    // ResponseEntity<LayuiTableData> responseEntity =
    // this.restTemplate.exchange(LIST, HttpMethod.POST, entity,
    // LayuiTableData.class);
    // LayuiTableData data = responseEntity.getBody();
    // return JSON.toJSON(data).toString();
    // }

    // @RequestMapping(value = "/sysfile/getTableData", method =
    // RequestMethod.POST)
    // @ResponseBody
    // public Object getTableData(@RequestBody List<Object> aoData,
    // HttpServletRequest request) throws IOException {
    // String token = request.getHeader("access-token");
    // httpHeaders.set("Authorization", "Bearer " + token);
    // httpHeaders.setContentType(MediaType.APPLICATION_JSON);
    // DataTableInfoVo dataTableInfoVo = DateTableUtil.getAllParam(aoData);
    // SysFileVo vo = new SysFileVo();
    // vo.setDataTableInfoVo(dataTableInfoVo);
    // JSONArray ja = JSONArray.fromObject(aoData);
    // SysUser userInfo = JwtTokenUtil.getUserFromToken(httpHeaders);
    // for (int i = 0; i < ja.size(); i++) {
    // if (ja.getJSONObject(i).getString("name").equals("parentId")) {
    // vo.setFormId(ja.getJSONObject(i).getString("value"));
    // }
    // else if (ja.getJSONObject(i).getString("name").equals("fileName")) {
    // vo.setFileName(ja.getJSONObject(i).getString("value"));
    // }
    // else if (ja.getJSONObject(i).getString("name").equals("fileKind")) {
    // vo.setFileKind(ja.getJSONObject(i).getString("value"));
    // }
    // else if (ja.getJSONObject(i).getString("name").equals("bak1")) {
    // vo.setBak1(ja.getJSONObject(i).getString("value"));
    // }
    // else if (ja.getJSONObject(i).getString("name").equals("filePublish")) {
    // vo.setFilePublish(userInfo.getUserId());
    // }
    // }
    // //查询用户岗位,部门,ID--start
    // SysUser userDetails = this.restTemplate.exchange(USER_DETAILS_URL +
    // userInfo.getUserId(), HttpMethod.GET, new
    // HttpEntity<Object>(this.httpHeaders), SysUser.class).getBody();
    // List<String> strings = new ArrayList<>();
    // // strings.addAll(userInfo.getRoles());//用户角色
    // strings.add(userInfo.getUserId());//用户ID
    // strings.add(userDetails.getUserUnit());//岗位
    // vo.setValues(strings);
    // //查询用户岗位,部门,ID--end
    // HttpEntity<SysFileVo> entity = new HttpEntity<SysFileVo>(vo,
    // this.httpHeaders);
    // ResponseEntity<String> responseEntity =
    // this.restTemplate.exchange(getTableData, HttpMethod.POST, entity,
    // String.class);
    // String result = responseEntity.getBody();
    // JSONObject retJson = JSONObject.fromObject(result);
    // DataTableParameter data = new DataTableParameter();
    // if(retJson != null){
    // Long totalCount = retJson.get("totalCount") != null?
    // Long.parseLong(retJson.get("totalCount").toString()):0l;
    // List<SysFile> SysFileList =
    // JSONArray.toList(retJson.getJSONArray("list"), new SysFile(), new
    // JsonConfig());
    // data.setAaData(SysFileList);
    // //要显示的总条数
    // data.setiTotalDisplayRecords(totalCount);
    // //真实的总条数
    // data.setiTotalRecords(totalCount);
    // }
    // return data;
    // }
    @RequestMapping(value = "/sysfile/getFileFlag/", method = RequestMethod.POST)
    @ResponseBody
    public String getFileFlag(String id) throws Exception {
        MultiValueMap<String, String> form = new LinkedMultiValueMap<>();
        form.add("id", id);
        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(form, this.httpHeaders);
        ResponseEntity<JSONObject> postForEntity = this.restTemplate.postForEntity(showFlag + id, httpEntity, JSONObject.class);
        return postForEntity.getBody().get("flag").toString();
    }

    @Value("${ckfilepath}")
    private String ckfilepath;

    @RequestMapping(value = "/sysfile/ckupload", method = RequestMethod.POST)
    public void ckupload(@RequestParam(value = "upload", required = false) MultipartFile files) {
        PrintWriter out = null;
        String originalFilename = files.getOriginalFilename();
        String fileType = originalFilename.substring(originalFilename.lastIndexOf(".", originalFilename.length()));
        String imageUrl = "ckupload";
        String msg = "";
        String fileName = "";
        String strFilePath = "";
        boolean isComplete = false;
        JSONObject result = new JSONObject();
        try {
//            String filePrefixFormat = "yyyyMMddHHmmssS";
//            String date = "";
//            String date = DateUtil.format(new Date(), filePrefixFormat);
//            File path = new File(ResourceUtils.getURL("classpath:").getPath());
//            if(!path.exists()) path = new File("");
//            File upload = new File(path.getAbsolutePath(),imageUrl);

//            File upload = new File(serverPath+imageUrl);
//            if(!upload.exists()) upload.mkdirs();

            String date = sysUserInfo.getUserId();
            strFilePath = ckfilepath + imageUrl + File.separator + date + File.separator;
            File filePath = new File(strFilePath);
            if (!filePath.exists()) filePath.mkdirs();
            fileName = UUID.randomUUID().toString() + fileType;
            String savedName = strFilePath + File.separator + fileName;
            isComplete = FileUtil.copyInputStreamToFile(files.getInputStream(), new File(savedName));
            if (isComplete == true) {
                out = response.getWriter();
                imageUrl = imageUrl + File.separator + date + File.separator + fileName;
                imageUrl = imageUrl.replace("\\", "/");
                imageUrl = imageUrl.replace("\\\\", "/");
            }

            //统一上传---文件不能传输到后台,使用独立上传
//            String tempFileName = files.getOriginalFilename();
//            if (tempFileName.indexOf("\\") > -1) {
//                tempFileName = tempFileName.substring(tempFileName.lastIndexOf("\\") + 1, tempFileName.length());
//            }
//            String uuid = IdUtil.createIdByTime();
//            JSONObject jsonObject = new JSONObject();
//            jsonObject.put("bak10","");
//            jsonObject.put("bak9","");
//            jsonObject.put("flag","0");
//            jsonObject.put("lastModifiedDate","");
//            sysFileFeignClient.uploadFileSaveLayui(files, request, response, tempFileName, "ff8129325ed94773bfd9f33145ccd080", sysUserInfo.getUserId(), uuid, "ckupload", jsonObject.toJSONString());
//            SysFile sysFile = this.restTemplate.exchange(GET + uuid, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), SysFile.class).getBody();

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("富文本编辑器上传图片时发生异常", e);
            msg = "服务器异常";
        } finally {
            if (!StrUtil.isBlank(msg)) {
                //上传失败
                result.put("uploaded", 0);
                JSONObject errorObj = new JSONObject();
                errorObj.put("message", msg);
                result.put("error", errorObj);
            } else {
                //上传成功
                result.put("uploaded", 1);
                result.put("fileName", fileName);
                result.put("url", File.separator + imageUrl);
            }
            out.println(result.toJSONString());
        }
    }
}