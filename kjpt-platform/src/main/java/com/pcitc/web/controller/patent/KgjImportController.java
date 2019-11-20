package com.pcitc.web.controller.patent;


import com.pcitc.base.patent.KgjImportModel;
import com.pcitc.web.common.RestBaseController;
import com.pcitc.web.utils.ImportExcelUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.List;

/**
 *
 * 科工局导入
 * @author ty
 */
@Api(value = "kgjImport-api", description = "科工局导入")
@Controller
@RequestMapping(value = "/kgjImport-api")
public class KgjImportController extends RestBaseController {

    /**
     * 根据ID获取对象信息
     */
    private static final String importPath = "http://kjpt-zuul/stp-proxy/kgjImport-api/kgjImport/";

    @ApiOperation(value="科工局Excel导入")
    @RequestMapping(value = "/kgjImport", method = RequestMethod.POST)
    @ResponseBody
    public List kgjImport(@RequestParam(value = "file", required = false) MultipartFile impExcel) throws Exception {
        InputStream in = new BufferedInputStream(impExcel.getInputStream());
        List dataList = new ImportExcelUtil().getBankListByExcel(in, impExcel.getOriginalFilename());
        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<List> responseEntity = this.restTemplate.exchange(importPath+this.getUserProfile().getUserName(), HttpMethod.POST,  new HttpEntity<List<List<String>>>(dataList, this.httpHeaders), List.class);
        return responseEntity.getBody();
    }

}
