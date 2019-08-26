package com.pcitc.web.feign;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.pcitc.base.common.Result;
import com.pcitc.base.system.SysFile;
import com.pcitc.base.system.SysReqLogs;
import com.pcitc.web.config.FeignMultipartSupportConfig;

import feign.Response;

@FeignClient(value = "pcitc-system-provider", configuration = FeignMultipartSupportConfig.class)
public interface SysFileFeignClient {

    @RequestMapping(method = RequestMethod.POST, value = "/sysfile-provider/sysfile/uploadFileSavetest",
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE},
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String uploadFileSavetest(@RequestPart(value = "file") MultipartFile filePart,
                                     @RequestParam("request") HttpServletRequest request, @RequestParam("response") HttpServletResponse response,
                                     @RequestParam("filename") String filename, @RequestParam("filepathconfig") String filepathconfig, @RequestParam("userid") String userid, @RequestParam("uuid") String uuid);

     @RequestMapping(method = RequestMethod.POST, value = "/sysfile-provider/sysfile/uploadFileSaveLayui",
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE},
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String uploadFileSaveLayui(@RequestPart(value = "file") MultipartFile filePart,
                                      @RequestParam("request") HttpServletRequest request, @RequestParam("response") HttpServletResponse response,
                                      @RequestParam("filename") String filename, @RequestParam("filepathconfig") String filepathconfig, @RequestParam("userid") String userid, @RequestParam("uuid") String uuid, @RequestParam("formId") String formId, @RequestParam("flag") String flag);

    @RequestMapping(value = "/sysfile-provider/sysfile/video/{id}")
    public Response videoFiles(@RequestParam("id") String id, @RequestParam("request") HttpServletRequest request, @RequestParam("response") HttpServletResponse response);
    
    
    @RequestMapping(value = "/sysfile-provider/sysfile/get-sysfile/{sysFileId}")
    public SysFile selectSysFileByMenuId(@PathVariable(value = "sysFileId", required = true) String sysFileId) throws Exception;

    @RequestMapping(value = "/sys-provider/processlogs/process-logs-save", method = RequestMethod.POST)
	public Result saveSysReqLogs(@RequestBody SysReqLogs bean);

    @RequestMapping(method = RequestMethod.POST, value = "/sysfile-provider/sysfile/uploadFileByValueUpload",
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE},
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String uploadFileByValueUpload(@RequestPart(value = "upload") MultipartFile filePart,
                                      @RequestParam("request") HttpServletRequest request, @RequestParam("response") HttpServletResponse response,
                                      @RequestParam("filename") String filename, @RequestParam("filepathconfig") String filepathconfig, @RequestParam("userid") String userid, @RequestParam("uuid") String uuid, @RequestParam("formId") String formId, @RequestParam("flag") String flag);

}