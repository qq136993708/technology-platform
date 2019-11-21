package com.pcitc.web.common;

import com.pcitc.base.common.FileModel;
import com.pcitc.service.file.FileCommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
public class FileCommonClient {

    @Autowired
    private FileCommonService fileCommonService;

    @RequestMapping(value="/file/query/{dataId}",method = RequestMethod.GET)
    public List<FileModel> query(@PathVariable(value = "dataId") String dataId){
        return fileCommonService.query(dataId);
    }

    /*@RequestMapping(value="/file/upload",method = RequestMethod.POST)
    public FileModel upload(@RequestParam(value = "dataId") String dataId) throws IOException {
        return fileCommonService.upload(dataId);
    }*/

    @RequestMapping(value="/file/save/{dataId}",method = RequestMethod.POST)
    public List<FileModel> save(@PathVariable String dataId,@RequestBody  List<FileModel> dataList){
        return fileCommonService.save(dataList,dataId);
    }

    /*@RequestMapping(value="/file/downLoad",method = RequestMethod.GET)
    public FileModel downLoad(String id){

        return null;
    }*/

}
