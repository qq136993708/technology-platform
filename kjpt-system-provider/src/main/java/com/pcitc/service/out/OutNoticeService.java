package com.pcitc.service.out;

import java.util.List;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.out.OutNotice;

/**
 * @author zhf
 * 其他外部系统的通知公告
 */
public interface OutNoticeService {

	public int insertNoticeDataBatch(List<OutNotice> list, String noticeType);
	
	public int deleteNoticeByType(String noticeType);
	
	
	public LayuiTableData getOutNoticePage(LayuiTableParam param);
	
	public OutNotice getOutNoticeDetails(String dataId);
	
}
