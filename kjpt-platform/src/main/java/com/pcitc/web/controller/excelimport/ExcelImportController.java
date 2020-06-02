package com.pcitc.web.controller.excelimport;

import com.alibaba.fastjson.JSON;
import com.pcitc.base.exception.SysException;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.common.RestBaseController;
import com.pcitc.web.utils.ImportExcelUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.List;

/**
 * @author ty
 */
@Api(value = "excel-api", description = "excel公用导入接口")
@RestController
public class ExcelImportController extends BaseController {
    /**
     * 根据ID获取对象信息
     */
    private static final String importPath = "http://kjpt-zuul/stp-proxy/excelImport-api/import/%s/%s/%s";

    @ApiOperation(value="Excel导入")
    @RequestMapping(value = {"/excelImport/{importType}"}, method = RequestMethod.POST,produces="text/plain;charset=UTF-8")
    public String kgjImport(@RequestParam(value = "file", required = false) MultipartFile impExcel, @PathVariable String importType, @RequestParam(value="pid",required=false) String pid, HttpServletRequest request) throws Exception {
        InputStream in = new BufferedInputStream(impExcel.getInputStream());
        String fileName = impExcel.getOriginalFilename();
        List dataList = null;
        if(fileName.contains("xml")){
            dataList = new ImportExcelUtil().generateData(in);
        }else{
            dataList = new ImportExcelUtil().getBankListByExcel(in, impExcel.getOriginalFilename());
        }
        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<List> responseEntity = this.restTemplate.exchange(String.format(importPath,importType,this.getUserProfile().getUserName(),pid), HttpMethod.POST,  new HttpEntity<List<List<String>>>(dataList, this.httpHeaders), List.class);
        if(!responseEntity.getBody().isEmpty() && !"kgjimp".equals(importType)){
            SysException sys = new SysException(JSON.toJSONString(responseEntity.getBody()));
            sys.setCode("1");
            throw sys;
        }
        return responseEntity.getBody().toString();
    }

}
