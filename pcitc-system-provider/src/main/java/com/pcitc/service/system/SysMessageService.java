package com.pcitc.service.system;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.system.SysMessage;

/**
 * @author zhf 
 * 系统消息
 */
public interface SysMessageService {

	
	/**
	 * 新增消息
	 */
	public int insertSysMessage(SysMessage sysMessage);
	
	/**
	 * 查询用户消息列表数据
	 */
	public LayuiTableData getMessageListData(LayuiTableParam param);
	/**
	 * select by Id
	 * @param messageId
	 * @return
	 */
	public SysMessage selectSysMessage(String messageId);
	/**
	 * read msg
	 * @param messageId
	 * @return
	 */
	public SysMessage readSysMessage(String messageId);
}
