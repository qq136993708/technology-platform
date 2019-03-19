package com.pcitc.service.doc.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
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
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.common.enums.DelFlagEnum;
import com.pcitc.base.doc.SysFileShare;
import com.pcitc.base.doc.SysFileShareExample;
import com.pcitc.base.system.SysFile;
import com.pcitc.base.system.SysUnit;
import com.pcitc.base.util.DateUtil;
import com.pcitc.base.util.FileUtil;
import com.pcitc.base.util.IdUtil;
import com.pcitc.base.util.JsonUtil;
import com.pcitc.base.util.TreeNodeUtil;
import com.pcitc.mapper.doc.SysFileShareMapper;
import com.pcitc.mapper.system.SysFileMapper;
import com.pcitc.service.doc.SysFileShareService;

/**
 * <p>接口实现类</p>
 * <p>Table: sys_file_share - 文件分享信息</p>
 *
 * @since 2018-06-19 03:58:11
 */
@Service("sysFileShareService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class SysFileShareServiceImpl implements SysFileShareService {

	@Autowired
	private SysFileMapper sysFileMapper;

	@Autowired
	private SysFileShareMapper sysFileShareMapper;

	// 文件上传路径
	@Value("${uploaderPath}")
	private String uploaderPath;

	public List<SysFileShare> findSysFileShareList(SysFileShare sysFileShare) {
		List<SysFileShare> record = sysFileShareMapper.findSysFileShareList(sysFileShare);
		return record;
	}

	public void saveSysFileShare(SysFileShare sysFileShare) {
		String[] arrayArea = sysFileShare.getArea().split("\\|");
		String[] arraybak1 = sysFileShare.getBak1().split("\\|");
		String[] arrayField = sysFileShare.getFileId().split("\\|");
		for (int i = 0; i < arrayField.length; i++) {
			// 删除
			sysFileShareMapper.deleteObjByParam(arrayField[i]);
			// 更新文件表
			SysFile sysFile = sysFileMapper.selectByPrimaryKey(arrayField[i]);
			sysFile.setBak3("1");
			sysFileMapper.updateByPrimaryKey(sysFile);
			// 插入分享内容
			for (int j = 0; j < arrayArea.length; j++) {
				sysFileShare.setArea(arrayArea[j]);
				sysFileShare.setBak1(arraybak1[j]);
				sysFileShare.setFileId(arrayField[i]);
				sysFileShare.setCreateDate(DateUtil.format(new Date(), DateUtil.FMT_SS));
				insert(sysFileShare);
			}
		}
	}

	@Override
	public int updateOrInsertSysFileShare(SysFileShare sysFileShare) throws Exception {
		int result = 500;
		if (sysFileShare.getId() != null && sysFileShare.getId() != null) {
			sysFileShareMapper.updateByPrimaryKey(sysFileShare);
		} else {
			sysFileShare.setId(IdUtil.createIdByTime());
			sysFileShareMapper.insertSelective(sysFileShare);
		}
		result = 200;
		return result;
	}

	@Override
	public int deleteSysFileShareById(String id) throws Exception {
		int result = 500;
		if (id != null) {
			sysFileShareMapper.deleteByPrimaryKey(id);
		}
		result = 200;
		return result;
	}

	@Override
	public SysFileShare getSysFileShareInfo(String id) throws Exception {

		return sysFileShareMapper.selectByPrimaryKey(id);
	}

	@Override
	public long countByExample(SysFileShareExample example) {
		return sysFileShareMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(SysFileShareExample example) {
		return sysFileShareMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(String recordId) {
		return sysFileShareMapper.deleteByPrimaryKey(recordId);
	}

	@Override
	public int deleteSysFileShareReal(String recordId) {
		return sysFileShareMapper.deleteByPrimaryKey(recordId);
	}

	@Override
	public int insert(SysFileShare record) {
		record.setId(IdUtil.createIdByTime());
		return sysFileShareMapper.insert(record);
	}

	@Override
	public int insertSelective(SysFileShare record) {
		return sysFileShareMapper.insertSelective(record);
	}

	public SysFileShare insertObject(SysFileShare record) {
		this.insert(record);
		return record;
	}

	@Override
	public List<SysFileShare> selectByExample(SysFileShareExample example) {
		return sysFileShareMapper.selectByExample(example);
	}

	@Override
	public SysFileShare selectByPrimaryKey(String recordId) {
		return sysFileShareMapper.selectByPrimaryKey(recordId);
	}

	@Override
	public int updateByExampleSelective(@Param("record") SysFileShare record, @Param("example") SysFileShareExample example) {
		return sysFileShareMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(@Param("record") SysFileShare record, @Param("example") SysFileShareExample example) {
		return sysFileShareMapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(SysFileShare record) {
		return sysFileShareMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(SysFileShare record) {
		if (record.getStatus() == null) {
			record.setStatus("");
		}
		return sysFileShareMapper.updateByPrimaryKey(record);
	}

	@Override
	public DataOperationStatusEnum deleteSysFileShare(Serializable sysFileShareId) {
		try {
			SysFileShare record = sysFileShareMapper.selectByPrimaryKey(sysFileShareId.toString());
			if (record != null) {
				record.setStatus(DelFlagEnum.STATUS_DEL.getCode() + "");
				sysFileShareMapper.updateByPrimaryKey(record);
			}
			return DataOperationStatusEnum.DEL_OK;
		} catch (Exception e) {
			return DataOperationStatusEnum.DEL_DATA_ERROR;
		}
	}

	@Override
	public PageInfo<SysFileShare> findSysFileShareByPage(String jsonStr) {
		int pageLength = 10;
		int startPage = 0;
		Map<String, Object> paramMap = JsonUtil.parseJsonToMap(jsonStr);
		if (paramMap.get("iDisplayLength") != null) {
			pageLength = Integer.parseInt(paramMap.get("iDisplayLength").toString());
		}
		if (paramMap.get("iDisplayStart") != null) {
			startPage = Integer.parseInt(paramMap.get("iDisplayStart").toString());
		}

		startPage = startPage / pageLength + 1;
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(startPage, pageLength);
		//
		// TTestExample example = new TTestExample();
		// com.pcitc.base.system.TTestExample.Criteria c =
		// example.createCriteria();
		// System.out.println(paramMap.get("name"));
		// if(!StrUtil.isBlankOrNull(paramMap.get("name")+"")){
		// c.andNameLike("%"+paramMap.get("name")+"%");
		// }
		// List<SysFileShare> list =sysFileShareMapper.selectByExample(example);
		List<SysFileShare> list = sysFileShareMapper.findSysFileShareByPage(paramMap);
		PageInfo<SysFileShare> pageInfo = new PageInfo<SysFileShare>(list);
		PageHelper.clearPage();
		return pageInfo;

	}

	/**
	 * 树形菜单
	 *
	 * @return
	 * @throws Exception 
	 */
	@Override
	public List<TreeNode> selectObjectByTree() {
		List<TreeNode> nodes = new ArrayList<TreeNode>();
		SysFileShareExample example = new SysFileShareExample();
		example.getOredCriteria().add(example.createCriteria().andStatusNotEqualTo(DataOperationStatusEnum.DEL_OK.getStatusCode().toString()));
		List<SysFileShare> records = sysFileShareMapper.selectByExample(example);
		for (SysFileShare record : records) {
			TreeNode node = new TreeNode();
			node.setId(record.getId());
			// node.setLevelCode(record.getUnitLevel().toString());
			node.setParentId(record.getParentId());
			nodes.add(node);
		}
		// 构建树形结构(从根节点开始的树形结构)

		SysFileShareExample sysFileShareExample = new SysFileShareExample();
		String strParentId = sysFileShareMapper.selectByExample(sysFileShareExample).get(0).getId();
		List<TreeNode> orderNodes = TreeNodeUtil.getChildrenNode(strParentId, nodes);

		return orderNodes;
	}

	public void deleteObjByParam(String strFileId) {
		sysFileShareMapper.deleteObjByParam(strFileId);
	}

	/**
	 * 替换sysFIle，保存进历史版本
	 * @param versionUUID
	 * @return
	 */
	public int replaceSysFile(String versionUUID) {

		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		hashmap.put("bak3", versionUUID);

		List<SysFile> list = sysFileMapper.selectFileHistoryList(hashmap);

		if (list != null && list.size() == 1) {
			SysFile temSF = list.get(0);

			SysFile oldFile = sysFileMapper.selectByPrimaryKey(temSF.getId());

			// 历史版本唯一标识id, 替换时使用
			oldFile.setBak3(UUID.randomUUID().toString().replaceAll("-", ""));
			sysFileMapper.copySysFile(oldFile);

			sysFileMapper.updateByPrimaryKey(temSF);
		}
		return 1;
	}

	/**
	 * 历史版本文档下载
	 */
	public void downloadFiles(@PathVariable("versionUUID") String versionUUID, HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("1versionUUID============="+versionUUID);
		String dir = UUID.randomUUID().toString();
		String zip = DateUtil.format(new Date(), DateUtil.FMT_DD);
		String[] versionFileIds = versionUUID.split("\\|");
		String[] fileNames = new String[versionFileIds.length];

		for (int i = 0; i < versionFileIds.length; i++) {
			HashMap<String, Object> hashmap = new HashMap<String, Object>();
			hashmap.put("bak3", versionFileIds[i]);

			List<SysFile> list = sysFileMapper.selectFileHistoryList(hashmap);
			if (list != null && list.size() == 1) {
				System.out.println("2versionUUID============="+versionUUID);
				SysFile sysFile = list.get(0);
				fileNames[i] = sysFile.getFilePath();
			}
		}
		System.out.println("3versionUUID============="+uploaderPath);
		// 文件压缩
		String zipFileName = FileUtil.generateZipFileZdy(uploaderPath + File.separator + dir, dir + ".zip", fileNames);
		// 文件发送
		InputStream is = null;
		OutputStream os = null;
		File file = null;
		System.out.println("3versionUUID============="+zipFileName);
		try {
			if (zipFileName == null) {
				response.getWriter().println("");
			} else {
				file = new File(zipFileName);
				if (zipFileName != null && file != null && file.exists() && file.isFile()) {
					System.out.println("4versionUUID============="+zipFileName);
					long filelength = file.length();
					is = new FileInputStream(file);
					// 设置输出的格式
					os = response.getOutputStream();
					response.setContentType("application/x-msdownload");
					response.setContentLength((int) filelength);

					// 只有GBK才可以
					response.addHeader("Content-Disposition", "attachment; filename=\"" + new String((zip + ".zip").getBytes("GBK"), "iso8859-1") + "\"");
					// 循环取出流中的数据
					byte[] b = new byte[4096];
					int len;
					while ((len = is.read(b)) > 0) {
						os.write(b, 0, len);
					}
					System.out.println("3versionUUID============="+versionUUID);
				} else {
					response.getWriter().println("<script>");
					response.getWriter().println(" modals.info('file not exist');");
					response.getWriter().println("</script>");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (is != null) {
				is.close();
			}
			if (os != null) {
				os.close();
			}
			if (file != null && file.exists()) {
				file.delete();
			}
		}
	}

	/**
	 * 历史版本文档下载
	 */
	public void downloadFile(@PathVariable("versionUUID") String versionUUID, HttpServletRequest request, HttpServletResponse response) throws IOException {
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		hashmap.put("bak3", versionUUID);
		System.out.println("1versionUUID============="+versionUUID);
		List<SysFile> list = sysFileMapper.selectFileHistoryList(hashmap);
		if (list != null && list.size() == 1) {
			
			SysFile sysFile = list.get(0);
			System.out.println("2versionUUID============="+sysFile.getFilePath());
			InputStream is = null;
			OutputStream os = null;
			File file = null;
			try {
				file = new File(sysFile.getFilePath());
				if (file != null && file.exists() && file.isFile()) {
					System.out.println("3versionUUID============="+sysFile.getFilePath());
					long filelength = file.length();
					is = new FileInputStream(file);
					// 设置输出的格式
					os = response.getOutputStream();
					response.setContentType("application/x-msdownload");
					response.setContentLength((int) filelength);
					// 只有GBK才可以
					response.addHeader("Content-Disposition", "attachment; filename=\"" + new String(sysFile.getFileName().getBytes("GBK"), "iso8859-1") + "\"");
					// 循环取出流中的数据
					byte[] b = new byte[4096];
					int len;
					while ((len = is.read(b)) > 0) {
						os.write(b, 0, len);
					}
					System.out.println("4versionUUID============="+sysFile.getFilePath());
				} else {
					response.getWriter().println("<script>");
					response.getWriter().println(" modals.info('file not exist');");
					response.getWriter().println("</script>");
				}

			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (is != null) {
					is.close();
				}
				if (os != null) {
					os.close();
				}
			}
		}

	}
	
	/**
	 * 查询某种条件下的组织机构节点，有组织机构和人员、岗位
	 * 包含文件已分享信息
	 */
	public List<TreeNode> getUnitTreeAndPostAndUserCond(SysUnit unit) {
		return sysFileShareMapper.getUnitTreeAndPostAndUserCond(unit);
	}
}