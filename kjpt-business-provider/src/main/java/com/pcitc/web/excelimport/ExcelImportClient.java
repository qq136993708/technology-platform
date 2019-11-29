package com.pcitc.web.excelimport;


import com.pcitc.service.excelimport.ExcelData2DbService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ty
 */
@Api(value = "excelImport-api", description = "excel导入")
@RestController
@RequestMapping(value = "/excelImport-api")
public class ExcelImportClient {

    @Autowired
    private ExcelData2DbService e2s;

    @ApiOperation(value="Excel导入")
    @RequestMapping(value = "/import/{importType}/{currentUser}/{pid}", method = RequestMethod.POST)
    public List kgjImport(@RequestBody List<List<Object>> dataList, @PathVariable String importType, @PathVariable String currentUser, @PathVariable String pid)  {
        e2s.excelData2Db(currentUser,pid,importType,dataList);
        return null;
    }
}
