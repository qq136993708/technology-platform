package com.pcitc.web.system;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.io.IOException;

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
import org.springframework.web.bind.annotation.RestController;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.system.SysFile;
import com.pcitc.service.doc.IndexAccessorService;
import com.pcitc.service.doc.SysFileShareService;
import com.pcitc.service.system.SysFileConfigService;
import com.pcitc.service.system.SysFileService;

/**
 * <p>文档管理相关的操作功能，文档管理的独立功能</p>
 * <p>Table: sys_file - </p>
 *
 * @since 2019-02-14 12:04:50
 */
@Api(value = "SysFileCommonClient-API", description = "文档操作服务接口")
@RestController
public class SysFileCommonClient {

	private final static Logger logger = LoggerFactory.getLogger(SysFileCommonClient.class);

	@Autowired
	SysFileService sysFileService;

	@Autowired
	SysFileConfigService sysFileConfigService;

	@Autowired
	SysFileShareService sysFileShareService;

	@Autowired
	private IndexAccessorService indexAccessorService;

	//@Autowired
	//private AccessorService accessorService = new ClientFactoryBuilder.Config().setConfigPath("elasticsearch.properties").initConfig(true).createByConfig();

	// 文件上传路径
	@Value("${uploaderPath}")
	private String uploaderPath;

	/**
	 * 文档管理的查询方法，查询公共的和分享给自己文件
	 */
	@ApiOperation(value = "分页查询文档信息", notes = "公共的和分享给自己文件")
	@RequestMapping(value = "/file-common-provider/files/common/data-list", method = RequestMethod.POST)
	public LayuiTableData selectFileListForPublic(@RequestBody LayuiTableParam param) throws Exception {
		LayuiTableData tem = sysFileService.selectFileListForPublic(param);
		return tem;
	}

	/**
	 * 查询收藏的文件信息
	 */
	@ApiOperation(value = "查询收藏的文件信息", notes = "个人收藏，文件可能不存在")
	@RequestMapping(value = "/file-common-provider/files/collect/data-list", method = RequestMethod.POST)
	public LayuiTableData selectFileListForCollect(@RequestBody LayuiTableParam param) throws Exception {
		LayuiTableData tem = sysFileService.selectFileListForCollect(param);
		return tem;
	}

	@ApiOperation(value = "多文件下载", notes = "历史版本下载,返回字节流")
	@RequestMapping(value = "/file-common-provider/version/downloads/{versionUUID}")
	public void downloadFiles(@PathVariable("versionUUID") String versionUUID, HttpServletRequest request, HttpServletResponse response) throws IOException {
		sysFileShareService.downloadFiles(versionUUID, request, response);
	}

	@ApiOperation(value = "单文件下载", notes = "历史版本下载,返回字节流")
	@RequestMapping(value = "/file-common-provider/version/download/{versionUUID}")
	public void downloadFile(@PathVariable("versionUUID") String versionUUID, HttpServletRequest request, HttpServletResponse response) throws IOException {
		sysFileShareService.downloadFile(versionUUID, request, response);
	}
	
	@ApiOperation(value = "替换历史文件中的错误文件", notes = "替换后，此历史记录文件地址、名称等发生变化")
	@RequestMapping(value = "/file-common-provider/history/error/replace", method = RequestMethod.POST)
	public int historyErrorReplace(@RequestBody SysFile sysFile) throws Exception {
		int retInt = sysFileService.historyErrorReplace(sysFile);
		return retInt;
	}

}
