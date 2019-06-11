package com.pcitc.service.system;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.system.SysNotice;
import com.pcitc.base.system.SysNoticeVo;

/**
 * @author ms 公告管理逻辑层
 */
public interface SysNoticeService {

	/**
	 * 条件查询公告列表
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	JSONObject selectSysNoticeList(SysNoticeVo vo) throws Exception;
	
	/**
	 * 新增或修改公告
	 * @param function
	 * @return
	 * @throws Exception
	 */
	int updateOrInsertSysNotice(SysNotice function) throws Exception;
	
	/**
	 * 删除公告
	 * @param id
	 * @return
	 * @throws Exception
	 */
	int deleteSysNotice(String id) throws Exception;
	
	/**
     * 根据id查询公告
     * @param id
     * @return
     */
    SysNotice getSysNoticeById(String id) throws Exception;

    /**
     * 发布公告
     * @param id
     * @return
     */
	SysNotice publishSysNotice(String id) throws Exception;

	/**
	 * 首页:查询新闻信息
	 * @param record
	 * @return
	 */
	List<SysNotice> selectNoticeMain(SysNotice record);
	
	/**
	 * 条件查询全部公告列表
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	JSONObject selectSysNoticeAll(SysNoticeVo vo) throws Exception;

	/**
	 * 首页:查看公告信息
	 * @param vo
	 * @return
	 */
	SysNotice getSysNoticeView(SysNoticeVo vo);

	/**
	 * 首页:查询公告数量
	 * @param vo
	 * @return
	 */
	Long getSysNoticeCount(SysNoticeVo vo);
}
