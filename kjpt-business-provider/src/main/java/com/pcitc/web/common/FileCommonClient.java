package com.pcitc.web.common;

import com.pcitc.base.common.FileModel;
import com.pcitc.service.file.FileCommonService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api(value = "FileCommonClient-api", description = "文件")
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

    @RequestMapping(value="/file/save",method = RequestMethod.POST)
    public void save(@RequestBody FileModel fm){
         fileCommonService.save(fm);
    }

    @RequestMapping(value="/file/updateFileData/{dataId}",method = RequestMethod.POST)
    public void updateFileData(@PathVariable String dataId,@RequestParam String fileds){
        fileCommonService.updateFileData(fileds,dataId);
    }

    @RequestMapping(value="/file/downLoad/{id}",method = RequestMethod.GET)
    public FileModel downLoad(@PathVariable String id){
        return fileCommonService.downLoad(id);
    }

}
