package com.pcitc.service.system.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.FileResult;
import com.pcitc.base.common.GetLocation;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.common.UploadType;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.doc.SysFileShare;
import com.pcitc.base.doc.SysFileShareExample;
import com.pcitc.base.system.SysFile;
import com.pcitc.base.system.SysFileConfig;
import com.pcitc.base.system.SysFileExample;
import com.pcitc.base.system.SysFileVo;
import com.pcitc.base.util.DataTableInfoVo;
import com.pcitc.base.util.DateUtil;
import com.pcitc.base.util.IdUtil;
import com.pcitc.base.util.JsonUtil;
import com.pcitc.base.util.StrUtil;
import com.pcitc.es.builder.BooleanCondtionBuilder;
import com.pcitc.es.clientmanager.ClientFactoryBuilder;
import com.pcitc.es.clientmanager.IndexHelperBuilder;
import com.pcitc.es.common.Result;
import com.pcitc.mapper.system.SysFileMapper;
import com.pcitc.service.doc.AccessorService;
import com.pcitc.service.doc.IndexAccessorService;
import com.pcitc.service.doc.SysFileShareService;
import com.pcitc.service.doc.impl.AccessorServiceImpl;
import com.pcitc.service.system.FileService;
import com.pcitc.service.system.SysFileConfigService;
import com.pcitc.service.system.SysFileService;
import com.pcitc.service.system.SysFunctionService;
import com.pcitc.utils.GetTextFromFile;
import com.pcitc.utils.ImageUtils;
import com.pcitc.utils.OSSUtil;
import com.pcitc.utils.StringUtils;

// import com.pcitc.service.system.SysSerialService;

/**
 * <p>
 * 接口实现类
 * </p>
 * <p>
 * Table: sys_file -
 * </p>
 *
 * @since 2018-05-08 02:04:50
 */
@Service("sysFile")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class SysFileServiceImpl implements SysFileService {

	@Autowired
	private FileService				fileService;

	@Autowired
	private SysFileMapper			sysFileMapper;

	@Autowired
	private SysFunctionService		functionService;

	@Autowired
	private SysFileShareService		sysFileShareService;

	@Autowired
	SysFileConfigService			sysFileConfigService;

	@Autowired
	private ClientFactoryBuilder	clientFactoryBuilder;

	// @Autowired
	// SysSerialService sysSerialService;

	// 文件上传路径
	@Value("${uploaderPath}")
	private String					uploaderPath;

	public String saveAvatar(String userId, String fileName, String filePath, String dirPath) {
		// UserAvatar avatar = null;
		// if(!StrUtil.isEmpty(userId)&&!userId.equals("0"))
		// avatar=userService.getAvatarByUserId(userId);
		// String avatar_id=avatar==null?null:avatar.getId();
		// //图片替换
		// if (avatar != null) {
		// File file = new File(dirPath + avatar.getSrc());
		// if (file.exists())
		// file.delete();
		// avatar.setName(fileName);
		// avatar.setSrc(filePath);
		// avatar.setUpdateDateTime(new Date());
		// this.update(avatar);
		// }
		// // 新增图片
		// else {
		// avatar = new UserAvatar();
		// avatar.setName(fileName);
		// avatar.setSrc(filePath);
		// avatar.setCreateDateTime(new Date());
		// avatar.setUserId(userId);
		// avatar_id=this.save(avatar).toString();
		// }
		// return avatar_id;
		return "";
	}

	@Override
	public long countByExample(SysFileExample example) {
		return sysFileMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(SysFileExample example) {
		return sysFileMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(String menuId) {
		return sysFileMapper.deleteByPrimaryKey(menuId);
	}

	@Override
	public int deleteSysFileReal(String menuId) {
		return sysFileMapper.deleteByPrimaryKey(menuId);
	}

	@Override
	public int insert(SysFile record) {
		record.setIsDel("0");
		return sysFileMapper.insert(record);
	}

	@Override
	public int insertSelective(SysFile record) {
		return sysFileMapper.insertSelective(record);
	}

	public SysFile insertObject(SysFile record) {
		this.insert(record);
		return record;
	}

	@Override
	public List<SysFile> selectByExample(SysFileExample example) {
		return sysFileMapper.selectByExample(example);
	}

	@Override
	public SysFile selectByPrimaryKey(String menuId) {
		SysFile sysFile = sysFileMapper.selectByPrimaryKey(menuId);
		String strBak8 = sysFile==null ? "" : sysFile.getBak8();
		if (strBak8!=null&&!"".equals(strBak8)) {
			String[] strings = strBak8.split(",");
			if (strBak8.indexOf("°")>-1) {
				sysFile.setBak8(GetLocation.dssConvertlonglat(strings[0])+","+GetLocation.dssConvertlonglat(strings[1]));
			}
		}
		return sysFile;
	}

	@Override
	public int updateByExampleSelective(@Param("record") SysFile record, @Param("example") SysFileExample example) {
		return sysFileMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(@Param("record") SysFile record, @Param("example") SysFileExample example) {
		return sysFileMapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(SysFile record) {
		return sysFileMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(SysFile record) {
		return sysFileMapper.updateByPrimaryKey(record);
	}

	@Override
	public DataOperationStatusEnum deleteSysFile(Serializable sysFileId) {
		try {
			SysFile menu = sysFileMapper.selectByPrimaryKey(sysFileId.toString());
			if (menu!=null) {
				sysFileMapper.updateByPrimaryKey(menu);
			}
			return DataOperationStatusEnum.DEL_OK;
		} catch (Exception e) {
			return DataOperationStatusEnum.DEL_DATA_ERROR;
		}
	}

	@Override
	public PageInfo<SysFile> findSysFileByPage(String jsonStr) {
		int pageLength = 10;
		int startPage = 0;
		Map<String, Object> paramMap = JsonUtil.parseJsonToMap(jsonStr);
		if (paramMap.get("iDisplayLength")!=null) {
			pageLength = Integer.parseInt(paramMap.get("iDisplayLength").toString());
		}
		if (paramMap.get("iDisplayStart")!=null) {
			startPage = Integer.parseInt(paramMap.get("iDisplayStart").toString());
		}
		String menuName = (String) paramMap.get("menuName");
		startPage = startPage/pageLength+1;
		PageHelper.startPage(startPage, pageLength);
		SysFileExample example = new SysFileExample();

		List<SysFile> list = sysFileMapper.selectByExample(example);
		return new PageInfo<SysFile>(list);
	}

	/**
	 * 树形菜单
	 *
	 * @return
	 */
	@Override
	public List<TreeNode> selectObjectByTree() {
		List<TreeNode> nodes = new ArrayList<TreeNode>();
		return null;
	}

	/**
	 * 根据条件分页搜索
	 *
	 * @param param
	 * @param example
	 * @return
	 */
	private LayuiTableData findByExample(LayuiTableParam param, SysFileExample example) {
		// 每页显示条数
		int pageSize = param.getLimit();
		// 从第多少条开始
		int pageStart = (param.getPage()-1)*pageSize;
		// 当前是第几页
		int pageNum = pageStart/pageSize+1;
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(pageNum, pageSize);

		List<SysFile> list = sysFileMapper.selectByExample(example);
		// 3、获取分页查询后的数据
		PageInfo<SysFile> pageInfo = new PageInfo<SysFile>(list);
		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
		return data;
	}

	@Override
	public LayuiTableData selectSysFileByPage(LayuiTableParam param) {
		SysFileExample ex = new SysFileExample();
		SysFileExample.Criteria c = ex.createCriteria();
		if (param.getParam().get("fileName")!=null&&!StringUtils.isBlank(param.getParam().get("fileName")+"")) {
			c.andFileNameLike("%"+param.getParam().get("fileName")+"%");
		}
		ex.setOrderByClause("update_date_time desc");

		// 每页显示条数
		int pageSize = param.getLimit();
		// 从第多少条开始
		int pageStart = (param.getPage()-1)*pageSize;
		// 当前是第几页
		int pageNum = pageStart/pageSize+1;
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(pageNum, pageSize);

		List<SysFile> list = sysFileMapper.selectByExample(ex);
		// 3、获取分页查询后的数据
		PageInfo<SysFile> pageInfo = new PageInfo<SysFile>(list);
		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
		return data;
	}

	@Override
	public JSONObject selectSysFileList(SysFileVo vo) throws Exception {

		// 递归查询菜单所有IDS
		List<com.pcitc.base.common.TreeNode> treeNodeList = functionService.findSons(vo.getFormId());
		List<String> strings = new ArrayList<>();
		functionService.getIds(treeNodeList, strings);

		DataTableInfoVo dataTableInfoVo = vo.getDataTableInfoVo();
		// 每页显示条数
		int pageSize = dataTableInfoVo.getiDisplayLength();
		// 从第多少条开始
		int pageStart = dataTableInfoVo.getiDisplayStart();
		// 当前是第几页
		int pageNum = pageStart/pageSize+1;
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(pageNum, pageSize);
		// 2、执行查询
		SysFileExample ex = new SysFileExample();
		SysFileExample.Criteria or = ex.or();
		or.andIsDelNotEqualTo("1");
		ex.setOrderByClause("update_date_time desc");
		// if (dataTableInfoVo.getiSortCol() != null &&
		// dataTableInfoVo.getiSortCol().length() > 0 &&
		// !"null".equalsIgnoreCase(dataTableInfoVo.getiSortCol())) {
		// if (dataTableInfoVo.getsSortDir_0() != null &&
		// dataTableInfoVo.getsSortDir_0().length() > 0 &&
		// !"null".equalsIgnoreCase(dataTableInfoVo.getsSortDir_0())) {
		// ex.setOrderByClause(dataTableInfoVo.getiSortCol() + " " +
		// dataTableInfoVo.getsSortDir_0());
		// } else {
		// ex.setOrderByClause(dataTableInfoVo.getiSortCol());
		// }
		// }
		if (vo.getFormId()!=null&&vo.getFormId().length()>0) {
			strings.add(vo.getFormId());
			or.andFormIdIn(strings);
		}
		if (vo.getFileName()!=null&&vo.getFileName().length()>0) {
			or.andFileNameLike("%"+vo.getFileName()+"%");
		}

		if (vo.getFileKind()!=null&&vo.getFileKind().length()>0) {
			or.andFileKindEqualTo(vo.getFileKind());
		}
		if (vo.getBak1()!=null&&vo.getBak1().length()>0) {
			or.andBak1EqualTo(vo.getBak1());
		}
		if (vo.getFilePublish()!=null&&vo.getFilePublish().length()>0) {
			or.andFilePublishEqualTo(vo.getFilePublish());
		}

		if (vo.getCreateUserId()!=null&&vo.getCreateUserId().length()>0) {
			or.andCreateUserIdEqualTo(vo.getCreateUserId());
		}

		if ("private".equals(vo.getBak1())) {
			SysFileExample.Criteria criteria2 = ex.or();
			criteria2.andFilePublishEqualTo(vo.getFilePublish());
			criteria2.andFileKindEqualTo(vo.getFileKind());
			criteria2.andFileNameLike("%"+vo.getFileName()+"%");
			criteria2.andIsDelNotEqualTo("1");
			ex.or(criteria2);
		}
		List<SysFile> list = null;
		// 分享文件添加条件
		if ("share".equals(vo.getBak1())) {
			// ex = new SysFileExample();
			SysFileShareExample sysFileShareExample = new SysFileShareExample();
			SysFileShareExample.Criteria criteria = sysFileShareExample.or();
			if (vo.getFileKind()!=null&&vo.getFileKind().length()>0) {
				criteria.andStypeEqualTo(vo.getFileKind());
			}
			criteria.andAreaIn(vo.getValues());
			List<SysFileShare> sysFileShares = sysFileShareService.selectByExample(sysFileShareExample);
			List<String> stringList = new ArrayList<>();
			for (int i = 0; i<sysFileShares.size(); i++) {
				stringList.add(sysFileShares.get(i).getFileId());
			}
			SysFileExample.Criteria criteria2 = ex.or();
			if (vo.getFileName()!=null&&vo.getFileName().length()>0) {
				criteria2.andFileNameLike("%"+vo.getFileName()+"%");
			}
			criteria2.andIsDelNotEqualTo("1");
			if (stringList.size()>0) {
				criteria2.andIdIn(stringList);
				ex.or(criteria2);
			} else {
				criteria2.andIdEqualTo("");
				ex.or(criteria2);
			}
			list = sysFileMapper.selectByExample(ex);
		} else {
			list = sysFileMapper.selectByExample(ex);
		}

		// 3、获取分页查询后的数据
		PageInfo<SysFile> pageInfo = new PageInfo<SysFile>(list);
		for (int i = 0; i<pageInfo.getList().size(); i++) {
			SysFile sysFile = pageInfo.getList().get(i);
			sysFile.setCreateDateTime(new SimpleDateFormat(DateUtil.FMT_SS).format(DateUtil.strToDate(sysFile.getCreateDateTime(), DateUtil.FMT_SS)));
			sysFile.setFileSize(StrUtil.getDoubledigit((Double.parseDouble(sysFile.getFileSize())/1024))+"");
		}
		// 4、封装需要返回的分页实体
		JSONObject result = new JSONObject();
		result.put("totalCount", pageInfo.getTotal());
		result.put("list", list);
		return result;
	}

	@Override
	public JSONObject selectSysFileListEs(SysFileVo vo) throws Exception {

		DataTableInfoVo dataTableInfoVo = vo.getDataTableInfoVo();
		// 每页显示条数
		int pageSize = dataTableInfoVo.getiDisplayLength();
		// 从第多少条开始
		int pageStart = dataTableInfoVo.getiDisplayStart();

		// AccessorService accessor = new
		// ClientFactoryBuilder.Config().setConfigPath("elasticsearch.properties").initConfig(true).createByConfig();
		AccessorService accessor = new AccessorServiceImpl(clientFactoryBuilder.getClient());
		BooleanCondtionBuilder.Builder builder = new BooleanCondtionBuilder.Builder();
		Map<String, String> queryMap = new HashMap<>();
		Map<String, String> highLightList = new HashMap<>();

		if (vo.getFileName()!=null&&vo.getFileName().length()>0) {
			// 设置查询条件
			queryMap.put("bak4", vo.getFileName());
			queryMap.put("fileName", vo.getFileName());
			builder.setQueryMap(queryMap);
			// 设置高亮
			highLightList.put("bak4", "bak4");
			highLightList.put("fileName", "fileName");
			builder.setHighLightFileds(highLightList);
		}
		if (vo.getFileKind()!=null&&vo.getFileKind().length()>0) {
			queryMap.put("fileKind", vo.getFileKind());
		}
		builder.setStart(pageStart);
		builder.setRow(pageSize);
		System.out.println("selectSysFileListEs------"+pageSize+"-----"+pageStart);
		Result result = accessor.searchFun(SysFile.class, builder.builder());
		List<SysFile> list = result.getList();

		// 4、封装需要返回的分页实体
		// PageInfo<SysFile> pageInfo = new PageInfo<SysFile>(list);

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("totalCount", result.getSearchHits().getTotalHits());
		jsonObject.put("list", list);
		return jsonObject;
	}

	public List<SysFile> getSysFileByMd5(String strFileMd5) {
		if (strFileMd5==null||"".equals(strFileMd5)) {
			return new ArrayList<SysFile>();
		} else {
			SysFileExample example = new SysFileExample();
			example.getOredCriteria().add(example.createCriteria().andFileMdEqualTo(strFileMd5));
			return this.selectByExample(example);
		}
	}

	public String selectMaxEsId() {
		return sysFileMapper.selectMaxEsId();
	}

	/**
	 * Layui文件上传
	 *
	 * @param filePart
	 * @param request
	 * @param response
	 * @param filename
	 * @param filepathconfig
	 * @param userid
	 * @param uuid
	 * @return
	 */
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public String uploadFileSaveLayui(@RequestParam(value = "file", required = false) MultipartFile filePart, HttpServletRequest request, HttpServletResponse response, String filename, String filepathconfig, String userid, String uuid, String formId, String flag) {
		System.out.println(filePart);
		MultipartFile[] files = new MultipartFile[] { filePart };
		String strUserId = userid;
		FileResult msg = new FileResult();
		ArrayList<Integer> arr = new ArrayList<>();
		String strSavePath = "";
		SysFileConfig sysFileConfig = sysFileConfigService.selectByPrimaryKey(filepathconfig);
		strSavePath = sysFileConfig.getPosition();
		JSONObject jsonObject = JSONObject.parseObject(flag);
		String strCjsj = jsonObject.getString("lastModifiedDate");
		String mobile_longlat = jsonObject.getString("bak10");// 经纬度
		String mobile_address = jsonObject.getString("bak9");// 地址
		if (strCjsj!=null&&!"".equals(strCjsj)) {
			strCjsj = DateUtil.dateAddHour(strCjsj, DateUtil.FMT_SS, 8);
		} else {
			strCjsj = "";
		}
		flag = jsonObject.getString("flag");
		// 缓存当前的文件
		List<SysFile> fileList = new ArrayList<>();
		for (int i = 0; i<files.length; i++) {
			MultipartFile file = files[i];
			if (!file.isEmpty()) {
				InputStream in = null;
				OutputStream out = null;
				SysFile sysFile = null;
				String strFileSuffix = "";
				try {
					// 获取文件MD5
					String strMd5 = fileService.getMD5ByInputStream(file.getInputStream());
					// 查询数量
					List<SysFile> sysFiles = getSysFileByMd5(strMd5);
					if (sysFiles!=null&&sysFiles.size()>0) {
						sysFile = sysFiles.get(0);
						strFileSuffix = sysFile.getFileSuffix().toLowerCase();
						// 这样也可以上传同名文件了
						String filePrefixFormat = "yyyyMMddHHmmssS";
						String savedName = DateUtil.format(new Date(), filePrefixFormat)+"_"+filename;
						sysFile.setId(uuid);
						sysFile.setFileName(filename);
						sysFile.setSavedName(savedName);
						sysFile.setCreateDateTime(DateUtil.format(new Date(), DateUtil.FMT_SSS));
						sysFile.setUpdateDateTime(DateUtil.format(new Date(), DateUtil.FMT_SSS));
						sysFile.setCreateUserId(strUserId);
						sysFile.setDeleted("0");
						sysFile.setIsDel("0");
						sysFile.setFileMd(strMd5);
						sysFile.setVersion(filepathconfig);
						sysFile.setFormId(sysFileConfig.getMenuId());
						sysFile.setStartTime("");
						sysFile.setEndTime("");
						sysFile.setFilePublish("");
						sysFile.setFilePwd("");
						sysFile.setFileKind("");
						sysFile.setBak4("");
						sysFile.setBak3("");
						sysFile.setBak2("");
						sysFile.setBak1("");
						sysFile.setFlag((flag==null||"".equals(flag)) ? "" : flag.toString());
						sysFile.setDataid((formId==null||"".equals(formId)) ? "" : formId.toString());
						this.insert(sysFile);
					} else {
						String filePrefixFormat = "yyyyMMddHHmmssS";
						String strSuffix = filename.substring(filename.lastIndexOf(".")+1);
						// 文件名，带后缀
						String savedName = DateUtil.format(new Date(), filePrefixFormat)+"_"+IdUtil.createFileIdByTime()+"."+strSuffix;
						// 将文件写入oss服务器
						String filePath = OSSUtil.uploadFileByInputStream(file.getInputStream(), uploaderPath+strSavePath+"/", savedName);
						sysFile = new SysFile();
						sysFile.setId(uuid);
						sysFile.setFileName(filename);
						sysFile.setSavedName(savedName);
						sysFile.setCreateDateTime(DateUtil.format(new Date(), DateUtil.FMT_SSS));
						sysFile.setUpdateDateTime(DateUtil.format(new Date(), DateUtil.FMT_SSS));
						sysFile.setCreateUserId(strUserId);
						sysFile.setDeleted("0");
						sysFile.setFileMd(strMd5);
						sysFile.setVersion(filepathconfig);
						sysFile.setFormId(sysFileConfig.getMenuId());
						sysFile.setFileSize(file.getSize()+"");
						sysFile.setFilePath(filePath);
						sysFile.setFileSuffix(strSuffix);
						sysFile.setFlag((flag==null||"".equals(flag)) ? "" : flag.toString());
						sysFile.setDataid((formId==null||"".equals(formId)) ? "" : formId.toString());
						sysFile.setBak5(strSavePath+File.separator+savedName);

						strSuffix = strSuffix.toLowerCase();

						// 获取文件经纬度,创建时间
						sysFile.setBak6(strCjsj);// 文件实际创建时间
						if ("jpg".equals(strSuffix)||"jpeg".equals(strSuffix)) {
							String[] strings = fileService.getFileLatAndLong(sysFile.getFilePath(), new String[] { "GPS Longitude", "GPS Latitude", "Date/Time" });
							if (strings[0]!=null&&!"".equals(strings[0])) {
								sysFile.setBak8(strings[0]+","+strings[1]);// 文件经纬度
								sysFile.setBak7(GetLocation.getLocationPosition(strings[0], strings[1]));// 地址
							}
							if (strings[2]!=null&&!"".equals(strings[2])) {
								sysFile.setBak6(strings[2].substring(0, strings[2].indexOf(" ")).replace(":", "-")+strings[2].substring(strings[2].indexOf(" "), strings[2].length()));// 手机端获取日期
							}
							sysFile.setBak8((mobile_longlat==null||"".equals(mobile_longlat)) ? sysFile.getBak8() : mobile_longlat);
							sysFile.setBak7((mobile_address==null||"".equals(mobile_address)) ? sysFile.getBak7() : mobile_address);
						}
						sysFile.setBak7(mobile_address);
						if ("jpg".equals(strSuffix)||"jpeg".equals(strSuffix)||"png".equals(strSuffix)||"bmp".equals(strSuffix)) {
							// 保存图片路径，压缩图片
							sysFile.setPartImgPath(uploaderPath+strSavePath+File.separator+"img_"+savedName);
							// 压缩
							String strImgType = sysFileConfig.getImgType();
							String strImgDesc = sysFileConfig.getImgDesc();
							if ("0".equals(strImgType)) {
								String[] strImgTypeArray = strImgDesc.split(":");
								ImageUtils.getImgSize(Integer.parseInt(strImgTypeArray[0]), Integer.parseInt(strImgTypeArray[1]), uploaderPath+strSavePath+File.separator+savedName, uploaderPath+strSavePath+File.separator+"img_"+savedName);
							} else if ("1".equals(strImgType)) {
								strImgDesc = strImgDesc==null ? "0.5" : strImgDesc;
								ImageUtils.getImgScale(Double.parseDouble(strImgDesc), uploaderPath+strSavePath+File.separator+savedName, uploaderPath+strSavePath+File.separator+"img_"+savedName);
							} else if ("2".equals(strImgType)) {
								String[] strImgTypeArray = strImgDesc.split(":");
								ImageUtils.getImgSizeNoScale(Integer.parseInt(strImgTypeArray[0]), Integer.parseInt(strImgTypeArray[1]), uploaderPath+strSavePath+File.separator+savedName, uploaderPath+strSavePath+File.separator+"img_"+savedName);
							} else {
								ImageUtils.getImgScale(0.5f, uploaderPath+strSavePath+File.separator+savedName, uploaderPath+strSavePath+File.separator+"img_"+savedName);
							}
						}
						insert(sysFile);

						if (sysFile.getFileSuffix()!=null) {
							if ("docx".equals(sysFile.getFileSuffix())||"doc".equals(sysFile.getFileSuffix())||"txt".equals(sysFile.getFileSuffix())||"xls".equals(sysFile.getFileSuffix())||"xlsx".equals(sysFile.getFileSuffix())||"pdf".equals(sysFile.getFileSuffix())||"xml".equals(sysFile.getFileSuffix())) {
								fileToEs(sysFile);
							}
						}
					}

					fileList.add(sysFile);
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println(filename+"上传发生异常，异常原因："+e.getMessage());
					arr.add(i);
					return JSONArray.parseArray(JSON.toJSONString(fileList)).toJSONString();
				} finally {
					try {
						if (out!=null) {
							out.close();
						}
						if (in!=null) {
							in.close();
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			} else {
				arr.add(i);
			}
		}

		if (arr.size()>0) {
			msg.setError("文件上传失败！");
			msg.setErrorkeys(arr);
		}
		return JSONArray.parseArray(JSON.toJSONString(fileList)).toJSONString();
	}

	public AccessorService getAccessorService() {
		// AccessorService accessor = new
		// ClientFactoryBuilder.Config().setConfigPath("elasticsearch.properties").initConfig(true).createByConfig();
		AccessorService accessor = new AccessorServiceImpl(clientFactoryBuilder.getClient());
		return accessor;
	}

	public IndexAccessorService getIndexAccessorService(AccessorService accessor) {
		IndexAccessorService indexAccessor = new IndexHelperBuilder.Builder().withClient(accessor.getClient()).creatAccessor();
		return indexAccessor;
	}

	/**
	 * 文件内容到ES
	 *
	 * @param sysFile
	 * @return
	 */
	public byte[] fileToEs(SysFile sysFile) {
		try {
			AccessorService accessor = getAccessorService();
			IndexAccessorService indexAccessor = getIndexAccessorService(accessor);
			indexAccessor.createIndexWithSettings(SysFile.class);
			indexAccessor.createMappingXContentBuilder(SysFile.class);
			sysFile.setEsId((int) (accessor.count(SysFile.class, null)));
			sysFile.setBak4(GetTextFromFile.getText(sysFile.getFilePath()));
			accessor.add(sysFile);
		} catch (Exception e) {
			System.out.println("文件写入ES异常");
			e.printStackTrace();
		} finally {

		}
		return null;
	}

	public FileResult getPreivewSettingsByController(@RequestBody FileResult result, HttpServletRequest request) {
		List<SysFile> fileList = result.getList();
		FileResult fileResult = new FileResult();
		List<String> previews = new ArrayList<>();
		List<FileResult.PreviewConfig> previewConfigs = new ArrayList<>();
		// 缓存当前的文件
		if (fileList==null) { return new FileResult(); }
		String[] fileArr = new String[fileList.size()];
		int index = 0;
		for (SysFile sysFile : fileList) {
			// 上传后预览 TODO 该预览样式暂时不支持theme:explorer的样式，后续可以再次扩展
			// 如果其他文件可预览txt、xml、html、pdf等 可在此配置
			if (fileService.isImage(sysFile.getFilePath())) {
				previews.add("<img src='"+sysFile.getFilePath()+"' class='file-preview-image kv-preview-data' "+"style='width:auto;height:160px' alt='"+sysFile.getFileName()+" title='"+sysFile.getFileName()+"''>");
			} else {
				previews.add("<div class='kv-preview-data file-preview-other-frame'><div class='file-preview-other'>"+"<span class='file-other-icon'>"+getFileIcon(sysFile.getFileName())+"</span></div></div>");
			}
			// 上传后预览配置
			FileResult.PreviewConfig previewConfig = new FileResult.PreviewConfig();
			previewConfig.setWidth("120px");
			previewConfig.setCaption(sysFile.getFileName());
			previewConfig.setKey(sysFile.getId());
			// previewConfig.setUrl("http://h.hiphotos.baidu.com/image/pic/item/a5c27d1ed21b0ef48c509cecd1c451da80cb3ec3.jpg");
			previewConfig.setExtra(new FileResult.PreviewConfig.Extra(sysFile.getId()));
			previewConfig.setSize(Long.parseLong(sysFile.getFileSize()));
			previewConfigs.add(previewConfig);
			fileArr[index++] = sysFile.getId();
		}
		fileResult.setInitialPreview(previews);
		fileResult.setInitialPreviewConfig(previewConfigs);
		fileResult.setFileIds(StrUtil.join(fileArr));
		return fileResult;
	}

	public FileResult getPreivewSettings(List<SysFile> fileList, HttpServletRequest request) {
		FileResult fileResult = new FileResult();
		List<String> previews = new ArrayList<>();
		List<FileResult.PreviewConfig> previewConfigs = new ArrayList<>();
		// 缓存当前的文件
		String[] fileArr = new String[fileList.size()];
		int index = 0;
		for (SysFile sysFile : fileList) {
			// 上传后预览 TODO 该预览样式暂时不支持theme:explorer的样式，后续可以再次扩展
			// 如果其他文件可预览txt、xml、html、pdf等 可在此配置
			if (fileService.isImage(sysFile.getFilePath())) {
				previews.add("<img src='"+sysFile.getFilePath()+"' class='file-preview-image kv-preview-data' "+"style='width:auto;height:160px' alt='"+sysFile.getFileName()+" title='"+sysFile.getFileName()+"''>");
			} else {
				previews.add("<div class='kv-preview-data file-preview-other-frame'><div class='file-preview-other'>"+"<span class='file-other-icon'>"+getFileIcon(sysFile.getFileName())+"</span></div></div>");
			}
			// 上传后预览配置
			FileResult.PreviewConfig previewConfig = new FileResult.PreviewConfig();
			previewConfig.setWidth("120px");
			previewConfig.setCaption(sysFile.getFileName());
			previewConfig.setKey(sysFile.getId());
			// previewConfig.setUrl("http://h.hiphotos.baidu.com/image/pic/item/a5c27d1ed21b0ef48c509cecd1c451da80cb3ec3.jpg");
			previewConfig.setExtra(new FileResult.PreviewConfig.Extra(sysFile.getId()));
			previewConfig.setSize(Long.parseLong(sysFile.getFileSize()));
			previewConfigs.add(previewConfig);
			fileArr[index++] = sysFile.getId();
		}
		fileResult.setInitialPreview(previews);
		fileResult.setInitialPreviewConfig(previewConfigs);
		fileResult.setFileIds(StrUtil.join(fileArr));
		return fileResult;
	}

	public FileResult getFilesLayui(String fileIds, HttpServletRequest request) {
		List<SysFile> fileList = new ArrayList<>();
		if (!StrUtil.isEmpty(fileIds)) {
			String[] fileIdArr = fileIds.split(",");
			SysFileExample sysFileExample = new SysFileExample();
			sysFileExample.getOredCriteria().add(sysFileExample.createCriteria().andIdIn(Arrays.asList(fileIdArr)));
			sysFileExample.setOrderByClause("create_date_time desc");
			fileList = this.selectByExample(sysFileExample);
		}
		FileResult fileResult = new FileResult();
		fileResult.setList(fileList);
		fileResult.setFileIds(fileIds);
		return fileResult;
	}

	public FileResult getFilesLayuiByFormId(String fileIds, HttpServletRequest request) {
		List<SysFile> fileList = new ArrayList<>();
		if (!StrUtil.isEmpty(fileIds)) {
			String[] fileIdArr = fileIds.split(",");
			SysFileExample sysFileExample = new SysFileExample();
			sysFileExample.createCriteria().andDataidIn(Arrays.asList(fileIdArr)).andIsDelEqualTo("0");
			// sysFileExample.createCriteria().andDataidIn(Arrays.asList(fileIdArr)).andFlagNotEqualTo("0").andIsDelEqualTo("0");
			sysFileExample.setOrderByClause("create_date_time desc");
			fileList = this.selectByExample(sysFileExample);
		}

		// 添加坐标
		for (int i = 0; i<fileList.size(); i++) {
			String strLongLat = fileList.get(i).getBak8();
			if (strLongLat!=null) {
				String[] strings = strLongLat.split(",");
				if (strLongLat.indexOf("°")>-1) {
					fileList.get(i).setBak8(GetLocation.dssConvertlonglat(strings[0])+","+GetLocation.dssConvertlonglat(strings[1]));
				}
			} else {
				fileList.get(i).setBak8("");
			}
		}
		FileResult fileResult = new FileResult();
		fileResult.setList(fileList);
		fileResult.setFileIds(fileIds);
		return fileResult;
	}

	public FileResult getFiles(String fileIds, HttpServletRequest request) {
		List<SysFile> fileList = new ArrayList<>();
		if (!StrUtil.isEmpty(fileIds)) {
			String[] fileIdArr = fileIds.split(",");
			SysFileExample sysFileExample = new SysFileExample();
			sysFileExample.getOredCriteria().add(sysFileExample.createCriteria().andIdIn(Arrays.asList(fileIdArr)));
			sysFileExample.setOrderByClause("create_date_time desc");
			fileList = selectByExample(sysFileExample);
		}
		FileResult fileResult = new FileResult();
		fileResult.setList(fileList);
		fileResult.setFileIds(fileIds);
		return fileResult;
	}

	public Object getFileFlag(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws IOException {
		File file = null;
		JSONObject jsonObject = new JSONObject();
		if (id.split("\\|").length>1) {
			String dir = UUID.randomUUID().toString();
			String[] array_id = id.split("\\|");
			String[] fileNames = new String[array_id.length];
			for (int i = 0; i<array_id.length; i++) {
				SysFile sysFile = this.selectByPrimaryKey(array_id[i]);
				if (sysFile==null) {
					continue;
				}
				fileNames[i] = sysFile.getFilePath();
			}
			// 文件压缩
			String zipFileName = fileService.generateZipFileZdy(uploaderPath+File.separator+dir, dir+".zip", fileNames);
			if (zipFileName!=null) {
				jsonObject.put("flag", "true");
			} else {
				jsonObject.put("flag", "false");
			}
		} else {
			SysFile sysfile = this.selectByPrimaryKey(id);
			if (sysfile!=null && sysfile.getIsDel().equals("0")) {
				jsonObject.put("flag", "true");
			} else {
				jsonObject.put("flag", "false");
			}
		}

		return jsonObject;
	}

	public void downloadFileViewPicThumbnail(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws IOException {
		SysFile sysfile = selectByPrimaryKey(id);
		InputStream is = null;
		OutputStream os = null;
		try {
			if (sysfile!=null) {
				is = OSSUtil.getOssFileIS(sysfile.getFilePath().split(OSSUtil.OSSPATH+"/"+OSSUtil.BUCKET+"/")[1]);
				long filelength = is.available();
				// 设置输出的格式
				os = response.getOutputStream();
				response.setContentType("application/x-msdownload");
				response.setContentLength((int) filelength);
				// 只有GBK才可以
				response.addHeader("Content-Disposition", "attachment; filename=\""+new String(sysfile.getFileName().getBytes("GBK"), "iso8859-1")+"\"");
				// 循环取出流中的数据
				byte[] b = new byte[4096];
				int len;
				while ((len = is.read(b))>0) {
					os.write(b, 0, len);
				}
			} else {
				response.getWriter().println("<script>");
				response.getWriter().println(" modals.info('文件不存在!');");
				response.getWriter().println("</script>");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (is!=null) {
				is.close();
			}
			if (os!=null) {
				os.close();
			}
		}
	}

	public void downloadFile(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws IOException {
		SysFile sysfile = selectByPrimaryKey(id);
		InputStream is = null;
		OutputStream os = null;
		try {
			if (sysfile!=null) {
				is = OSSUtil.getOssFileIS(sysfile.getFilePath().split(OSSUtil.OSSPATH+"/"+OSSUtil.BUCKET+"/")[1]);
				long filelength = is.available();
				// 设置输出的格式
				os = response.getOutputStream();
				response.setContentType("application/x-msdownload");
				response.setContentLength((int) filelength);
				// 只有GBK才可以
				response.addHeader("Content-Disposition", "attachment; filename=\""+new String(sysfile.getFileName().getBytes("GBK"), "iso8859-1")+"\"");
				// 循环取出流中的数据
				byte[] b = new byte[4096];
				int len;
				while ((len = is.read(b))>0) {
					os.write(b, 0, len);
				}
			} else {
				response.getWriter().println("<script>");
				response.getWriter().println(" modals.info('文件不存在!');");
				response.getWriter().println("</script>");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (is!=null) {
				is.close();
			}
			if (os!=null) {
				os.close();
			}
		}
	}

	public void previewImgagByByteBase64(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) {
		SysFile sysfile = selectByPrimaryKey(id);
		InputStream is = null;
		OutputStream os = null;
		try {
			if (sysfile!=null) {
				is = OSSUtil.getOssFileIS(sysfile.getFilePath().split(OSSUtil.OSSPATH+"/"+OSSUtil.BUCKET+"/")[1]);
				long filelength = is.available();
				// 设置输出的格式
				os = response.getOutputStream();
				response.setContentType("application/x-msdownload");
				response.setContentLength((int) filelength);
				// 只有GBK才可以
				response.addHeader("Content-Disposition", "attachment; filename=\""+new String(sysfile.getFileName().getBytes("GBK"), "iso8859-1")+"\"");
				// 循环取出流中的数据
				byte[] b = new byte[4096];
				int len;
				while ((len = is.read(b))>0) {
					os.write(b, 0, len);
				}
			} else {
				response.getWriter().println("<script>");
				response.getWriter().println(" modals.info('文件不存在!');");
				response.getWriter().println("</script>");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (is!=null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (os!=null) {
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void downloadFiles(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 遍历ids,取出文件
		String dir = UUID.randomUUID().toString().replaceAll("-", "");
		String zip = DateUtil.format(new Date(), DateUtil.FMT_DD);
		String[] array_id = id.split("\\|");
		String[] fileNames = new String[array_id.length];
		for (int i = 0; i<array_id.length; i++) {
			SysFile sysFile = selectByPrimaryKey(array_id[i]);
			if (sysFile==null) {
				continue;
			}
			fileNames[i] = sysFile.getFilePath();
		}
		// 文件压缩
		String zipFileName = fileService.generateZipFileZdy(uploaderPath+File.separator+dir, dir+".zip", fileNames);
		// 文件发送
		InputStream is = null;
		OutputStream os = null;
		File file = null;
		try {
			if (zipFileName==null) {
				response.getWriter().println("");
			} else {
				file = new File(zipFileName);
				if (zipFileName!=null&&file!=null&&file.exists()&&file.isFile()) {
					long filelength = file.length();
					is = new FileInputStream(file);
					// 设置输出的格式
					os = response.getOutputStream();
					response.setContentType("application/x-msdownload");
					response.setContentLength((int) filelength);
					// 只有GBK才可以
					response.addHeader("Content-Disposition", "attachment; filename=\""+new String((zip+".zip").getBytes("GBK"), "iso8859-1")+"\"");
					// 循环取出流中的数据
					byte[] b = new byte[4096];
					int len;
					while ((len = is.read(b))>0) {
						os.write(b, 0, len);
					}
				} else {
					response.getWriter().println("<script>");
					response.getWriter().println(" modals.info('文件不存在!');");
					response.getWriter().println("</script>");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (is!=null) {
				is.close();
			}
			if (os!=null) {
				os.close();
			}
			if (file!=null&&file.exists()) {
				file.delete();
			}
		}
	}

	public void deleteSysFileByIdReal() {
		SysFileExample ex = new SysFileExample();
		SysFileExample.Criteria c = ex.createCriteria();
		c.andIsDelEqualTo("1");
		c.andExpDateLessThanOrEqualTo(new Date().getTime()+"");
		List<SysFile> sysFiles = this.selectByExample(ex);
		for (int i = 0; i<sysFiles.size(); i++) {
			deleteByPrimaryKey(sysFiles.get(i).getId());
			List<SysFile> sysFileByMd5 = this.getSysFileByMd5(sysFiles.get(i).getFileMd());
			if (sysFileByMd5!=null&&sysFileByMd5.size()<2) {
				fileService.delFile(sysFiles.get(i).getFilePath());
			}
		}
	}

	public com.pcitc.base.common.Result delete(String id, HttpServletRequest request) {
		String[] idArray = id.split("\\|");
		for (int i = 0; i<idArray.length; i++) {
			SysFile sysFile = selectByPrimaryKey(idArray[i]);
			if (sysFile!=null) {
				// 设置isdel为1，设置最后修改日期：当前日期+6个月
				sysFile.setIsDel("1");
				sysFile.setExpDate(DateUtil.dateAdd(new Date(), 6).getTime()+"");
				this.updateByPrimaryKeySelective(sysFile);
				// 删除索引
				try {
					String strESId = sysFile.getEsId()+"";
					if (strESId!=null&&!"".equals(strESId)) {
						getAccessorService().delete(sysFile.getEsId()+"", SysFile.class);
					}
				} catch (Exception e) {
					e.printStackTrace();
					continue;
				}
				// 物理删除改为逻辑删除，增加6个月观察期
				// FileUtil.delFile(sysFile.getFilePath());
			}
			// }
			// deleteByPrimaryKey(idArray[i]);
			try {
				sysFileShareService.deleteObjByParam(idArray[i]);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return new com.pcitc.base.common.Result();
	}

	public FileResult uploadMultipleFile(@RequestParam(value = "file", required = false) MultipartFile[] files, HttpServletRequest request, HttpServletResponse response, String filename) throws IOException {
		String strUserId = "userid";
		FileResult msg = new FileResult();
		ArrayList<Integer> arr = new ArrayList<>();
		// 缓存当前的文件
		List<SysFile> fileList = new ArrayList<>();
		for (int i = 0; i<files.length; i++) {
			MultipartFile file = files[i];

			if (!file.isEmpty()) {
				InputStream in = null;
				OutputStream out = null;
				try {
					String filePrefixFormat = "yyyyMMddHHmmssS";
					String savedName = DateUtil.format(new Date(), filePrefixFormat)+"_"+filename;
					// 将文件写入oss服务器
					String filePath = OSSUtil.uploadFileByInputStream(file.getInputStream(), uploaderPath, savedName);

					SysFile sysFile = new SysFile();
					sysFile.setId(UUID.randomUUID().toString());
					sysFile.setFileName(filename);
					sysFile.setSavedName(savedName);
					sysFile.setCreateDateTime(DateUtil.format(new Date(), DateUtil.FMT_SSS));
					sysFile.setUpdateDateTime(DateUtil.format(new Date(), DateUtil.FMT_SSS));
					sysFile.setCreateUserId(strUserId);
					sysFile.setDeleted("0");
					sysFile.setFileSize(file.getSize()+"");
					sysFile.setFilePath(filePath);
					sysFile.setFileSuffix(filename.substring(filename.lastIndexOf(".")+1));
					insert(sysFile);
					fileList.add(sysFile);
				} catch (Exception e) {
					System.out.println(filename+"上传发生异常，异常原因："+e.getMessage());
					arr.add(i);
				} finally {
					if (out!=null) {
						out.close();
					}
					if (in!=null) {
						in.close();
					}
				}
			} else {
				arr.add(i);
			}
		}

		if (arr.size()>0) {
			msg.setError("文件上传失败！");
			msg.setErrorkeys(arr);
		}
		FileResult preview = getPreivewSettings(fileList, request);
		msg.setInitialPreview(preview.getInitialPreview());
		msg.setInitialPreviewConfig(preview.getInitialPreviewConfig());
		msg.setFileIds(preview.getFileIds());
		return msg;
	}

	public List<SysFile> uploadFileSave(@RequestParam(value = "file", required = false) MultipartFile filePart, HttpServletRequest request, HttpServletResponse response, String filename, String filepathconfig, String userid, String uuid) throws IOException {
		MultipartFile[] files = new MultipartFile[] { filePart };
		String strUserId = userid;
		FileResult msg = new FileResult();
		ArrayList<Integer> arr = new ArrayList<>();
		String strSavePath = "";
		SysFileConfig sysFileConfig = sysFileConfigService.selectByPrimaryKey(filepathconfig);
		strSavePath = sysFileConfig.getPosition();
		// 缓存当前的文件
		List<SysFile> fileList = new ArrayList<>();
		for (int i = 0; i<files.length; i++) {
			MultipartFile file = files[i];

			if (!file.isEmpty()) {
				InputStream in = null;
				OutputStream out = null;
				try {
					String filePrefixFormat = "yyyyMMddHHmmssS";
					String savedName = DateUtil.format(new Date(), filePrefixFormat)+"_"+filename;

					// 将文件写入oss服务器
					String filePath = OSSUtil.uploadFileByInputStream(file.getInputStream(), uploaderPath+strSavePath+"/", savedName);
					SysFile sysFile = new SysFile();
					sysFile.setId(uuid);
					sysFile.setFileName(filename);
					sysFile.setSavedName(savedName);
					sysFile.setCreateDateTime(DateUtil.format(new Date(), DateUtil.FMT_SSS));
					sysFile.setUpdateDateTime(DateUtil.format(new Date(), DateUtil.FMT_SSS));
					sysFile.setCreateUserId(strUserId);
					sysFile.setDeleted("0");
					sysFile.setVersion(filepathconfig);
					sysFile.setFormId(sysFileConfig.getMenuId());
					sysFile.setFileSize(file.getSize()+"");
					sysFile.setFilePath(filePath);
					sysFile.setFileSuffix(filename.substring(filename.lastIndexOf(".")+1));
					insert(sysFile);
					fileList.add(sysFile);
				} catch (Exception e) {
					System.out.println(filename+"上传发生异常，异常原因："+e.getMessage());
					arr.add(i);
				} finally {
					if (out!=null) {
						out.close();
					}
					if (in!=null) {
						in.close();
					}
				}
			} else {
				arr.add(i);
			}
		}

		if (arr.size()>0) {
			msg.setError("文件上传失败！");
			msg.setErrorkeys(arr);
		}
		return fileList;
	}

	public String uploadFileSavetest(@RequestParam(value = "file", required = false) MultipartFile filePart, HttpServletRequest request, HttpServletResponse response, String filename, String filepathconfig, String userid, String uuid) throws IOException {
		MultipartFile[] files = new MultipartFile[] { filePart };
		String strUserId = userid;
		FileResult msg = new FileResult();
		ArrayList<Integer> arr = new ArrayList<>();
		String strSavePath = "";
		SysFileConfig sysFileConfig = sysFileConfigService.selectByPrimaryKey(filepathconfig);
		strSavePath = sysFileConfig.getPosition();
		// 缓存当前的文件
		List<SysFile> fileList = new ArrayList<>();
		for (int i = 0; i<files.length; i++) {
			MultipartFile file = files[i];
			if (!file.isEmpty()) {
				InputStream in = null;
				OutputStream out = null;
				try {
					String filePrefixFormat = "yyyyMMddHHmmssS";
					String savedName = DateUtil.format(new Date(), filePrefixFormat)+"_"+filename;
					// 将文件写入oss服务器
					String filePath = OSSUtil.uploadFileByInputStream(file.getInputStream(), uploaderPath+strSavePath+"/", savedName);

					SysFile sysFile = new SysFile();
					sysFile.setId(uuid);
					sysFile.setFileName(filename);
					sysFile.setSavedName(savedName);
					sysFile.setCreateDateTime(DateUtil.format(new Date(), DateUtil.FMT_SSS));
					sysFile.setUpdateDateTime(DateUtil.format(new Date(), DateUtil.FMT_SSS));
					sysFile.setCreateUserId(strUserId);
					sysFile.setDeleted("0");
					sysFile.setVersion(filepathconfig);
					sysFile.setFormId(sysFileConfig.getMenuId());
					sysFile.setFileSize(file.getSize()+"");
					sysFile.setFilePath(filePath);
					sysFile.setFileSuffix(filename.substring(filename.lastIndexOf(".")+1));
					// 查询最大值es_id
					String strEsId = selectMaxEsId();
					strEsId = (strEsId==null||"".equals(strEsId)) ? "0" : strEsId;
					sysFile.setEsId(Integer.parseInt(strEsId)+1);
					insert(sysFile);
					// es-start
					if (sysFile.getFileSuffix()!=null) {
						if ("docx".equals(sysFile.getFileSuffix())||"doc".equals(sysFile.getFileSuffix())||"txt".equals(sysFile.getFileSuffix())||"xls".equals(sysFile.getFileSuffix())||"xlsx".equals(sysFile.getFileSuffix())||"pdf".equals(sysFile.getFileSuffix())||"xml".equals(sysFile.getFileSuffix())) {
							fileToEs(sysFile);
						}
					}
					fileList.add(sysFile);

				} catch (Exception e) {
					System.out.println(filename+"上传发生异常，异常原因："+e.getMessage());
					arr.add(i);
				} finally {
					if (out!=null) {
						out.close();
					}
					if (in!=null) {
						in.close();
					}
				}
			} else {
				arr.add(i);
			}
		}

		if (arr.size()>0) {
			msg.setError("文件上传失败！");
			msg.setErrorkeys(arr);
		}
		return JSONArray.parseArray(JSON.toJSONString(fileList)).toString();
	}

	public String getFileIcon(String fileName) {
		String ext = StrUtil.getExtName(fileName);
		return UploadType.fileIconMap.get(ext)==null ? UploadType.fileIconMap.get("default").toString() : UploadType.fileIconMap.get(ext).toString();
	}

	public void updateSysFileFlag(String dataId) {
		Map<String, String> map = new HashMap<>();
		map.put("formid", dataId);
		sysFileMapper.updateSysFileFlag(map);
	}

	public void deleteSysFileByDataId(String dataId) {

		// 调用删除功能
		SysFileExample sysFileExample = new SysFileExample();
		sysFileExample.createCriteria().andDataidEqualTo(dataId);
		List<SysFile> sysFiles = this.selectByExample(sysFileExample);
		if (sysFiles!=null&&sysFiles.size()>0) {
			for (int i = 0; i<sysFiles.size(); i++) {
				this.delete(sysFiles.get(i).getId(), null);
			}
		}
		// Map<String,String> map = new HashMap<>();
		// map.put("formid",dataId);
		// sysFileMapper.deleteSysFileByDataId(map);

	}

	/**
	 * 文档管理的查询方法，查询公共的和分享给自己文件
	 */
	@Override
	public LayuiTableData selectFileListForPublic(LayuiTableParam param) throws Exception {
		// 每页显示条数
		int pageSize = param.getLimit();
		// 当前是第几页
		int pageNum = param.getPage();
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(pageNum, pageSize);

		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		if (param.getParam().get("fileKind")!=null&&!StringUtils.isBlank(param.getParam().get("fileKind")+"")) {
			hashmap.put("fileKind", param.getParam().get("fileKind"));
		}

		if (param.getParam().get("fileMd5")!=null&&!StringUtils.isBlank(param.getParam().get("fileMd5")+"")) {
			hashmap.put("fileMd5", param.getParam().get("fileMd5"));
		}

		if (param.getParam().get("fileName")!=null&&!StringUtils.isBlank(param.getParam().get("fileName")+"")) {
			hashmap.put("fileName", param.getParam().get("fileName"));
		}

		if (param.getParam().get("fileKindPath")!=null&&!StringUtils.isBlank(param.getParam().get("fileKindPath")+"")) {
			hashmap.put("fileKindPath", param.getParam().get("fileKindPath"));
		}

		hashmap.put("userId", param.getParam().get("userId"));

		List<SysFile> list = sysFileMapper.selectFileListForPublic(hashmap);
		System.out.println("1>>>>>>>>>查询分页结果"+list.size());
		for (int i = 0; i<list.size(); i++) {
			SysFile sf = list.get(i);
			sf.setFileSize(StrUtil.getDoubledigit((Double.parseDouble(sf.getFileSize())/1024))+"");
		}
		PageInfo<SysFile> pageInfo = new PageInfo<SysFile>(list);

		System.out.println("2>>>>>>>>>查询分页结果"+pageInfo.getList().size());

		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
		return data;
	}

	/**
	 * 文档收藏的查询方法
	 */
	@Override
	public LayuiTableData selectFileListForCollect(LayuiTableParam param) {
		// 每页显示条数
		int pageSize = param.getLimit();
		// 当前是第几页
		int pageNum = param.getPage();
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(pageNum, pageSize);

		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		if (param.getParam().get("fileKind")!=null&&!StringUtils.isBlank(param.getParam().get("fileKind")+"")) {
			hashmap.put("fileKind", param.getParam().get("fileKind"));
		}

		if (param.getParam().get("fileName")!=null&&!StringUtils.isBlank(param.getParam().get("fileName")+"")) {
			hashmap.put("fileName", param.getParam().get("fileName"));
		}

		hashmap.put("userId", param.getParam().get("userId"));

		List<SysFile> list = sysFileMapper.selectFileListForCollect(hashmap);
		System.out.println("1>>>>>>>>>查询分页结果"+list.size());
		PageInfo<SysFile> pageInfo = new PageInfo<SysFile>(list);

		System.out.println("2>>>>>>>>>查询分页结果"+pageInfo.getList().size());

		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
		return data;
	}

	/**
	 * 复制文件数据到sys_file_version中
	 */
	public int copySysFile(SysFile sysFile) {
		sysFileMapper.copySysFile(sysFile);
		return 1;
	}

	/**
	 * 获取文件历史版本信息
	 */
	public LayuiTableData selectFileHistoryList(LayuiTableParam param) {

		// 每页显示条数
		int pageSize = param.getLimit();
		// 当前是第几页
		int pageNum = param.getPage();
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(pageNum, pageSize);

		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		if (param.getParam().get("fileId")!=null&&!StringUtils.isBlank(param.getParam().get("fileId")+"")) {
			hashmap.put("fileId", param.getParam().get("fileId"));
		}

		if (param.getParam().get("fileName")!=null&&!StringUtils.isBlank(param.getParam().get("fileName")+"")) {
			hashmap.put("fileName", param.getParam().get("fileName"));
		}

		List<SysFile> list = sysFileMapper.selectFileHistoryList(hashmap);
		System.out.println("1>>>>>>>>>查询分页结果"+list.size());
		for (int i = 0; i<list.size(); i++) {
			SysFile sf = list.get(i);
			sf.setFileSize(StrUtil.getDoubledigit((Double.parseDouble(sf.getFileSize())/1024))+"");
		}
		PageInfo<SysFile> pageInfo = new PageInfo<SysFile>(list);

		System.out.println("2>>>>>>>>>查询分页结果"+pageInfo.getList().size());

		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
		return data;

	}

	/**
	 * 替换历史文件中的错误文件
	 */
	public int historyErrorReplace(SysFile sysFile) {
		// 把文件地址、文件名称等信息替换到文档历史版本中（通过版本的唯一标识bak3）
		sysFileMapper.updateSysFileHistoryErrorVersion(sysFile);

		// 删除syfile中的此条文档数据
		sysFileMapper.deleteByPrimaryKey(sysFile.getId());
		return 1;
	}

	/**
	 * 文档查询，和sys_file_kind关联查询
	 */
	public LayuiTableData selectFileInfoList(LayuiTableParam param) {

		Map<String, Object> paraMap = param.getParam();

		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(param.getPage(), param.getLimit());

		List<SysFile> fileList = sysFileMapper.selectFileInfoList(paraMap);

		PageInfo<SysFile> pageInfo = new PageInfo<SysFile>(fileList);

		for (int i = 0; i<pageInfo.getList().size(); i++) {
			SysFile sysFile = pageInfo.getList().get(i);
			sysFile.setCreateDateTime(new SimpleDateFormat(DateUtil.FMT_SS).format(DateUtil.strToDate(sysFile.getCreateDateTime(), DateUtil.FMT_SS)));
			sysFile.setFileSize(StrUtil.getDoubledigit((Double.parseDouble(sysFile.getFileSize())/1024))+"");
		}

		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());

		return data;
	}

	public void videoFiles(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws IOException {
		InputStream is = null;
		OutputStream os = null;
		try {
			SysFile sysfile = selectByPrimaryKey(id);
			if (sysfile!=null) {
				is = OSSUtil.getOssFileIS(sysfile.getFilePath().split(OSSUtil.OSSPATH+"/"+OSSUtil.BUCKET+"/")[1]);
				long filelength = is.available();
				// 设置输出的格式
				response.setContentType("video/mp4");
				response.setHeader("Content-Disposition", "attachment; filename=\""+new String(sysfile.getFileName().getBytes("GBK")+"\""));
				response.setContentLength((int) filelength);
				response.setHeader("Content-Range", ""+Integer.valueOf((int) (filelength-1)));
				response.setHeader("Accept-Ranges", "bytes");
				response.setHeader("Etag", "W/\"9767057-1323779115364\"");

				os = response.getOutputStream();

				byte[] b = new byte[4096];
				int len;
				while ((len = is.read(b))>0) {
					os.write(b, 0, len);
				}
			} else {
				response.getWriter().println("<script>");
				response.getWriter().println(" modals.info('文件不存在!');");
				response.getWriter().println("</script>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (is!=null) {
				is.close();
			}
			if (os!=null) {
				os.close();
			}
		}
	}

}