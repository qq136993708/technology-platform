package com.pcitc.web.patent;


import com.pcitc.base.patent.KgjImportModel;
import com.pcitc.service.patent.KgjImportService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>科工局录入</p>
 */
@Api(value = "kgjImport-api", description = "科工局导入")
@RestController
@RequestMapping(value = "/kgjImport-api")
public class KgjImportClient {


	   @Autowired private KgjImportService ks;

	   @RequestMapping(value="/kgjImport/{currrentUser}",method =RequestMethod.POST)
	   public List<KgjImportModel> kgjImport(@PathVariable(value="currrentUser") String currrentUser, @RequestBody List<List<String>> dataList){ return ks.kgjImport(dataList,currrentUser); }

}
