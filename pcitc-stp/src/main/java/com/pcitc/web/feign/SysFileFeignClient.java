package com.pcitc.web.feign;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.pcitc.web.config.FeignMultipartSupportConfig;

import java.io.IOException;

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
    public void videoFiles(@PathVariable("id") String id, @RequestParam("request") HttpServletRequest request, @RequestParam("response") HttpServletResponse response);
//    public ResponseEntity<byte[]> videoFiles(@PathVariable("id") String id, @RequestParam("request") HttpServletRequest request, @RequestParam("response") HttpServletResponse response);
}