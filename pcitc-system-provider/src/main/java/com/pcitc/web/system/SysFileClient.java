package com.pcitc.web.system;

import com.pcitc.base.util.DateUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.FileResult;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.common.UploadType;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.system.SysFile;
import com.pcitc.base.system.SysFileVo;
import com.pcitc.es.clientmanager.ClientFactoryBuilder;
import com.pcitc.mapper.system.SysFileMapper;
import com.pcitc.service.doc.AccessorService;
import com.pcitc.service.doc.IndexAccessorService;
import com.pcitc.service.doc.SysFileShareService;
import com.pcitc.service.system.SysFileConfigService;
import com.pcitc.service.system.SysFileService;

/**
 * <p>服务接口</p>
 * <p>Table: sys_file - </p>
 *
 * @since 2018-05-08 02:04:50
 */
@Api(value = "SysFileClient-API", description = "文件操作服务接口")
@RestController
public class SysFileClient {

    private final static Logger logger = LoggerFactory.getLogger(SysFileClient.class);

    @Autowired
    SysFileService sysFileService;

    @Autowired
    SysFileConfigService sysFileConfigService;

    @Autowired
    SysFileShareService sysFileShareService;

    @Autowired
    SysFileMapper sysFileMapper;

    @Autowired
    private IndexAccessorService indexAccessorService;

    @Autowired
    private AccessorService accessorService = new ClientFactoryBuilder
            .Config()
            .setConfigPath("elasticsearch.properties")
            .initConfig(true)
            .createByConfig();

    //文件上传路径
    @Value("${uploaderPath}")
    private String uploaderPath;

    @ApiOperation(value = "文件和表物理删除", notes = "文件和表物理删除,无返回值)")
    @RequestMapping(value = "/sysfile-provider/sysfile/deleteSysFileByIdReal", method = RequestMethod.POST)
    public void deleteSysFileByIdReal(){
        sysFileService.deleteSysFileByIdReal();
    }

    @ApiOperation(value = "Layui多文件上传&解析文件到ES", notes = "Layui多上传文件并解析文件内容到ES,返回文件列表(JSON字符串)")
    @RequestMapping(value = "/sysfile-provider/sysfile/uploadFileSaveLayui", method = RequestMethod.POST)
    public String uploadFileSaveLayui(@RequestParam(value = "file", required = false) MultipartFile filePart,
                                      HttpServletRequest request, HttpServletResponse response, String filename, String filepathconfig, String userid, String uuid,String formId,String flag) throws IOException {
        return sysFileService.uploadFileSaveLayui(filePart, request, response, filename, filepathconfig, userid, uuid,formId,flag);
    }

    /**
     * 跳转到通用文件上传窗口
     *
     * @return
     */
    @ApiOperation(value = "文件上传页面跳转", notes = "文件上传页面跳转,返回跳转地址")
    @RequestMapping(value = "/sysfile-provider/sysfile/uploader", method = RequestMethod.GET)
    public String uploader(String config, HttpServletRequest request) {
        request.setAttribute("config", config);
        return "base/file/file_uploader";
    }

    @ApiOperation(value = "多文件上传", notes = "多上传文件,返回FileResult对象")
    @RequestMapping(value = "/sysfile-provider/sysfile/uploadFile", method = RequestMethod.POST)
    @ResponseBody
    public FileResult uploadFile(@RequestParam(value = "file", required = false) MultipartFile file,
                                 HttpServletRequest request, HttpServletResponse response, String filename) throws IOException {
        MultipartFile[] files = new MultipartFile[]{file};
        return sysFileService.uploadMultipleFile(files, request, response, filename);
    }

    @ApiOperation(value = "多文件上传&解析文件到ES", notes = "多上传文件并解析文件内容到ES,返回文件列表(JSON字符串)")
    @RequestMapping(value = "/sysfile-provider/sysfile/uploadFileSavetest", method = RequestMethod.POST)
    public String uploadFileSavetest(@RequestParam(value = "file", required = false) MultipartFile filePart,
                                     HttpServletRequest request, HttpServletResponse response, String filename, String filepathconfig, String userid, String uuid) throws IOException {
        return sysFileService.uploadFileSavetest(filePart, request, response, filename, filepathconfig, userid, uuid);
    }

    /**
     * 单文件上传返回文件信息
     */
    @ApiOperation(value = "单文件上传", notes = "单文件上传,返回List<SysFile>类型文件列表")
    @RequestMapping(value = "/sysfile-provider/sysfile/uploadFileSave", method = RequestMethod.POST)
    public List<SysFile> uploadFileSave(@RequestParam(value = "file", required = false) MultipartFile filePart,
                                        HttpServletRequest request, HttpServletResponse response, String filename, String filepathconfig, String userid, String uuid) throws IOException {
        return sysFileService.uploadFileSave(filePart, request, response, filename, filepathconfig, userid, uuid);
    }

    /**
     * 多文件上传，用于uploadAsync=false(同步多文件上传使用)
     *
     * @param files
     * @param request
     * @param response
     * @return
     */
    @ApiOperation(value = "多文件上传", notes = "同步多文件上传,返回FileResult对象")
    @RequestMapping(value = "/sysfile-provider/sysfile/uploadMultipleFile", method = RequestMethod.POST)
    @ResponseBody
    public FileResult uploadMultipleFile(@RequestParam(value = "file", required = false) MultipartFile[] files,
                                         HttpServletRequest request, HttpServletResponse response, String filename) throws IOException {
        return sysFileService.uploadMultipleFile(files, request, response, filename);
    }


    @ApiOperation(value = "删除文件", notes = "根据文件ID删除文件,返回Result对象")
    @RequestMapping(value = "/sysfile-provider/sysfile/delete", method = RequestMethod.POST)
    @ResponseBody
    public Result delete(String id, HttpServletRequest request) {
        return sysFileService.delete(id, request);
    }

    @ApiOperation(value = "多文件下载", notes = "根据文件ID下载文件,返回字节流")
    @RequestMapping(value = "/sysfile-provider/sysfile/downloads/{id}")
    public void downloadFiles(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws IOException {
        sysFileService.downloadFiles(id, request, response);
    }

    @ApiOperation(value = "文件预览", notes = "根据文件ID获取文件,返回字节流")
    @RequestMapping(value = "/sysfile-provider/sysfile/previewImgagByByteBase64/{id}")
    public void previewImgagByByteBase64(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws IOException {
        sysFileService.previewImgagByByteBase64(id, request, response);
    }

    @ApiOperation(value = "单文件下载", notes = "根据文件ID下载文件,返回字节流")
    @RequestMapping(value = "/sysfile-provider/sysfile/download/{id}")
    public void downloadFile(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws IOException {
        sysFileService.downloadFile(id, request, response);
    }

    @ApiOperation(value = "文件是否存在查询", notes = "根据文件ID查询下载文件,返回状态")
    @RequestMapping(value = "/sysfile-provider/sysfile/showFlag/{id}")
    @ResponseBody
    public Object getFileFlag(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws IOException {
        return sysFileService.getFileFlag(id, request, response);
    }

    /**
     * 获取字体图标map,base-file控件使用
     */
    @ApiOperation(value = "获取字体图标", notes = "获取字体图标,返回Map对象")
    @RequestMapping(value = "/sysfile-provider/sysfile/icons", method = RequestMethod.POST)
    @ResponseBody
    public Map getIcons() {
        return UploadType.fileIconMap;
    }

    /**
     * 根据文件名获取icon
     *
     * @param fileName 文件
     * @return
     */
    @ApiOperation(value = "获取文件icon", notes = "根据文件名获取icon,返回String类型")
    public String getFileIcon(String fileName) {
        return sysFileService.getFileIcon(fileName);
    }

    /**
     * 根据附件IDS获取文件
     *
     * @param fileIds
     * @param request
     * @return
     */
    @ApiOperation(value = "获取文件列表", notes = "根据附件IDS获取文件,返回FileResult类型对象")
    @RequestMapping(value = "/sysfile-provider/sysfile/getFiles", method = RequestMethod.POST)
    @ResponseBody
    public FileResult getFiles(String fileIds, HttpServletRequest request) {
        return sysFileService.getFiles(fileIds, request);
    }

    @ApiOperation(value = "Layui获取文件列表", notes = "Layui根据附件IDS获取文件,返回FileResult类型对象")
    @RequestMapping(value = "/sysfile-provider/sysfile/getFilesLayui", method = RequestMethod.POST)
    @ResponseBody
    public FileResult getFilesLayui(String fileIds, HttpServletRequest request) {
        return sysFileService.getFilesLayui(fileIds, request);
    }

    @ApiOperation(value = "Layui根据表单ID获取文件列表", notes = "Layui根据表单ID获取文件列表,返回FileResult类型对象")
    @RequestMapping(value = "/sysfile-provider/sysfile/getFilesLayuiByFormId", method = RequestMethod.POST)
    @ResponseBody
    public FileResult getFilesLayuiByFormId(String fileIds, HttpServletRequest request) {
        System.out.println(fileIds+"------------getFilesLayuiByFormId------------");
        return sysFileService.getFilesLayuiByFormId(fileIds, request);
    }
    /**
     * 回填已有文件的缩略图
     *
     * @param fileList 文件列表
     * @param request
     * @return initialPreiview initialPreviewConfig fileIds
     */
    @ApiOperation(value = "回填已有文件的缩略图", notes = "根据文件IDS回填已有文件的缩略图,返回FileResult类型对象")
    public FileResult getPreivewSettings(List<SysFile> fileList, HttpServletRequest request) {
        return sysFileService.getPreivewSettings(fileList, request);
    }

    @ApiOperation(value = "获取文件列表预览对象", notes = "根据文件IDS获取文件列表预览对象,返回FileResult类型对象")
    @RequestMapping(value = "/sysfile-provider/sysfile/getPreivewSettings", method = RequestMethod.POST)
    public FileResult getPreivewSettingsByController(@RequestBody FileResult result, HttpServletRequest request) {
        return sysFileService.getPreivewSettingsByController(result, request);
    }

    /**
     * 获取菜单---节点树形展示
     *
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "文件树形展示", notes = "文件列表树形展示,返回List类型对象")
    @RequestMapping(value = "/sysfile-provider/sysfile/tree-data")
    @ResponseBody
    public List selectObjectByTree() throws Exception {
        return sysFileService.selectObjectByTree();
    }

    /**
     * 查询菜单相信信息-展示
     *
     * @param sysFileId
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "获取文件详情", notes = "根据文件ID获取文件详情,返回SysFile类型对象")
    @RequestMapping(value = "/sysfile-provider/sysfile/get-sysfile/{sysFileId}")
    public SysFile selectSysFileByMenuId(@PathVariable(value = "sysFileId", required = true) String sysFileId) throws Exception {
        return sysFileService.selectByPrimaryKey(sysFileId);
    }

    /**
     * 更新文件信息
     *
     * @param sysFile
     * @return
     */
    @ApiOperation(value = "更新文件信息", notes = "根据文件ID更新文件信息,返回200状态")
    @RequestMapping(value = "/sysfile-provider/sysfile/update-sysfile")
    public Serializable updateSysFile(@RequestBody SysFile sysFile) {
        sysFileService.updateByPrimaryKey(sysFile);
        DataOperationStatusEnum status = DataOperationStatusEnum.UPD_OK;
        return status;
    }

    /**
     * 删除文件信息-false
     *
     * @param sysFilecId
     * @return
     */
    @ApiOperation(value = "伪删除文件信息", notes = "根据文件ID伪删除文件信息,返回200状态")
    @RequestMapping(value = "/sysfile-provider/sysfile/del-sysfile/{sysFileId}")
    public Serializable deleteSysFile(@PathVariable("sysFileId") String sysFilecId) {
        return sysFileService.deleteSysFile(sysFilecId);
    }

    /**
     * 删除文件信息-true
     *
     * @param sysFilecId
     * @return
     */
    @ApiOperation(value = "删除文件信息", notes = "根据文件ID删除文件信息,返回200状态")
    @RequestMapping(value = "/sysfile-provider/sysfile/del-sysfile-real/{sysFileId}", method = RequestMethod.POST)
    public Serializable deleteSysFileReal(@PathVariable("sysFileId") String sysFilecId) {
        sysFileService.deleteSysFileReal(sysFilecId);
        return DataOperationStatusEnum.DEL_OK;
    }

    /**
     * 更新文件状态
     *
     * @param dataId
     * @return
     */
    @ApiOperation(value = "更新文件状态", notes = "根据表单ID更新文件状态,返回200状态")
    @RequestMapping(value = "/sysfile-provider/sysfile/update-file-flag/{dataId}", method = RequestMethod.POST)
    public Serializable updateSysFileFlag(@PathVariable("dataId") String dataId) {
        sysFileService.updateSysFileFlag(dataId);
        return DataOperationStatusEnum.UPD_OK;
    }

    /**
     * 增加文件信息
     *
     * @param sysFile
     * @return
     */
    @ApiOperation(value = "新增文件信息", notes = "新增文件信息,返回SysFile类型对象")
    @RequestMapping(value = "/sysfile-provider/sysfile/add-sysfile", method = RequestMethod.POST)
    public SysFile insertSysFile(@RequestBody SysFile sysFile) {
        return sysFileService.insertObject(sysFile);
    }

    /**
     * 分页查询
     *
     * @param jsonStr
     * @return
     */
    @ApiOperation(value = "分页查询文件信息", notes = "分页查询文件信息,返回JSONObject类型对象")
    @RequestMapping(value = "/sysfile-provider/sysfile-page")
    public JSONObject selectSysFileByPage(@RequestParam(value = "jsonStr", required = false) String jsonStr) {
        //JSONObject.fromObject(sysFileService.findSysFileByPage(jsonStr));
    	return JSONObject.parseObject(JSONObject.toJSONString(sysFileService.findSysFileByPage(jsonStr)));
    }

    /**
     * 分页查询
     *
     * @param vo
     * @return
     */
    @ApiOperation(value = "分页查询文件信息", notes = "分页查询文件信息,返回String类型对象(JSONObject)")
    @RequestMapping(value = "/sysfile-provider/sysfile/getTableData", method = RequestMethod.POST)
    public String selectSysFileByPage(@RequestBody SysFileVo vo) {
        JSONObject tem = null;
        try {
            tem = sysFileService.selectSysFileList(vo);
        } catch (Exception e) {
            logger.error("[分页查询文件信息失败：]", e);
            e.printStackTrace();
        }
        return tem == null ? "" : tem.toString();
    }

    /**
     * 查询文件存储ES
     *
     * @param vo
     * @return
     */
    @ApiOperation(value = "ES分页查询文件信息", notes = "ES分页查询文件信息,返回String类型对象(JSONObject)")
    @RequestMapping(value = "/sysfile-provider/sysfile/getTableDataEs", method = RequestMethod.POST)
    public String selectSysFileByPageEs(@RequestBody SysFileVo vo) {
        JSONObject tem = null;
        try {
            tem = sysFileService.selectSysFileListEs(vo);
        } catch (Exception e) {
            logger.error("[文件查询-ES分页查询文件信息失败：]", e);
            e.printStackTrace();
        }
        return tem == null ? "" : tem.toString();
    }

    /**
     * 分页查询
     *
     * @param param
     * @return
     */
    @ApiOperation(value = "分页查询文件信息Layui", notes = "分页查询文件信息,返回String类型对象(JSONObject)")
    @RequestMapping(value = "/sysfile-provider/sysfile/list", method = RequestMethod.POST)
    public Object selectSysFileByPages(@RequestBody LayuiTableParam param) {
        LayuiTableData tem = null;
        try {
            tem = sysFileService.selectSysFileByPage(param);
        } catch (Exception e) {
            logger.error("[分页查询文件信息Layui：]", e);
            e.printStackTrace();
        }
        return tem;
    }
    //    @RequestMapping("/sysfile-provider/sysfile/avatarUpload")
//    @ResponseBody
//    public AvatarResult avatarUpload(String userId, HttpServletRequest httpRequest, HttpSession session) throws Exception {
//
//        MultipartHttpServletRequest request = (MultipartHttpServletRequest) httpRequest;
//        String strFormId = request.getParameter("id").toString();
//        Map<String, MultipartFile> fileMap = request.getFileMap();
//        String contentType = request.getContentType();
//        if (contentType.indexOf("multipart/form-data") >= 0) {
//            AvatarResult result = new AvatarResult();
//            result.setAvatarUrls(new ArrayList());
//            result.setSuccess(false);
//            result.setMsg("Failure!");
//
//            // 定义一个变量用以储存当前头像的序号
//            int avatarNumber = 1;
////            User user = uploaderService.get(User.class, userId);
////            if (user == null) {
////                user = new User();
////                user.setName("new");
////            }
//            // 文件名
//            String fileName = strFormId + "_" + (new Date()).getTime() + ".jpg";
//            String relPath = PropertiesUtil.getValue("avatarPath");
//            String dirPath = request.getRealPath("/");
//
//            String initParams = "";
//
//            BufferedInputStream inputStream;
//            BufferedOutputStream outputStream;
//            for (Iterator<Map.Entry<String, MultipartFile>> it = fileMap.entrySet().iterator(); it.hasNext(); avatarNumber++) {
//                File filePath = new File(dirPath + relPath);
//                if (!filePath.exists()) {
//                    filePath.mkdirs();
//                }
//                Map.Entry<String, MultipartFile> entry = it.next();
//                MultipartFile mFile = entry.getValue();
//                String fieldName = entry.getKey();
//                Boolean isSourcePic = fieldName.equals("__source"); // 是否是原始图片域名称
//                // 文件名，如果是本地或网络图片为原始文件名（不含扩展名）、如果是摄像头拍照则为 *FromWebcam
//                // String name = fileItem.getName();
//                // 当前头像基于原图的初始化参数（即只有上传原图时才会发送该数据），用于修改头像时保证界面的视图跟保存头像时一致，提升用户体验度。
//                // 修改头像时设置默认加载的原图url为当前原图url+该参数即可，可直接附加到原图url中储存，不影响图片呈现。
//                if (fieldName.equals("__initParams")) {
//                    inputStream = new BufferedInputStream(mFile.getInputStream());
//                    byte[] bytes = new byte[mFile.getInputStream().available()];
//                    inputStream.read(bytes);
//                    initParams = new String(bytes, "UTF-8");
//                    inputStream.close();
//                } else if (isSourcePic || fieldName.startsWith("__avatar")) {
//                    String virtualPath = dirPath + relPath + "\\" + fileName;
//                    if (avatarNumber > 1) {
//                        fileName = avatarNumber + fileName;
//                        virtualPath = dirPath + relPath + "\\" + fileName;
//                    }
//                    // 原始图片(file 域的名称：__source，如果客户端定义可以上传的话，可在此处理）。
//                    if (isSourcePic) {
//                        fileName = "source" + fileName;
//                        virtualPath = dirPath + relPath + "\\" + fileName;
//                        result.setSourceUrl(relPath + "/" + fileName);
//                    }
//                    // 头像图片(file 域的名称：__avatar1,2,3...)。
//                    else {
//                        result.getAvatarUrls().add(relPath + "/" + fileName);
//                    }
//
//                    inputStream = new BufferedInputStream(mFile.getInputStream());
//                    outputStream = new BufferedOutputStream(new FileOutputStream(virtualPath.replace("/", "\\")));
//                    Streams.copy(inputStream, outputStream, true);
//                    inputStream.close();
//                    outputStream.flush();
//                    outputStream.close();
//                    // 保存图片信息
//                    // TODO: 2018/5/8 改为返回当前用户ID
//                    result.setMsg(strFormId);
////                    result.setMsg(uploaderService.saveAvatar(userId, fileName, relPath + File.separator + fileName, dirPath));
//                }
//
//            }
//            if (result.getSourceUrl() != null) {
//                result.setSourceUrl(result.getSourceUrl() + initParams);
//            }
//            result.setSuccess(true);
//            return result;
//        }
//        return null;
//    }

//    /**
//     * markdown组件上传图片
//     */
//    @RequestMapping(value = "/sysfile-provider/sysfile/markdownUpload", method = RequestMethod.POST)
//    @ResponseBody
//    public MarkDownResult markdownUpload(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "editormd-image-file", required = false) MultipartFile attach) {
//        try {
//            String relPath = PropertiesUtil.getValue("markdownPath");
//            String dirPath = request.getRealPath("/");
//            //不存在目录 则创建
//            File filePath = new File(dirPath + relPath);
//            if (!filePath.exists()) {
//                filePath.mkdirs();
//            }
//            File realFile = new File(dirPath + relPath + File.separator + attach.getOriginalFilename());
//            //上传的文件已存在 则对新上传的文件重命名
//            if (realFile.exists()) {
//                String fileName = DateUtil.format(new Date(), "yyyyMMddHHmmss") + "_" + attach.getOriginalFilename();
//                realFile = new File(dirPath + relPath + File.separator + fileName);
//            }
//            boolean iscreate = FileUtil.copyInputStreamToFile(attach.getInputStream(), realFile);
//            if (iscreate) {
//                String url = relPath + File.separator + realFile.getName();
//                url = request.getAttribute("basePath").toString() + url.replaceAll("\\\\", "/");
//                return new MarkDownResult(1, "上传成功", url);
//            } else {
//                return new MarkDownResult(0, "上传失败", null);
//            }
//        } catch (IOException ex) {
//            return new MarkDownResult(0, "上传失败:原因" + ex.getMessage().toString(), null);
//        }
//    }

    /**
     * 更新文件状态
     *
     * @param dataId
     * @return
     */
    @ApiOperation(value = "删除表单关联文件", notes = "根据表单ID删除表单关联文件,返回200状态")
    @RequestMapping(value = "/sysfile-provider/sysfile/delete-form-file/{dataId}", method = RequestMethod.POST)
    public Serializable deleteSysFileByDataId(@PathVariable("dataId") String dataId) {
        sysFileService.updateSysFileFlag(dataId);
        return DataOperationStatusEnum.UPD_OK;
    }

}
