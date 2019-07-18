package com.pcitc.service.out.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.out.OutNotice;
import com.pcitc.base.stp.out.OutNoticeExample;
import com.pcitc.mapper.out.OutNoticeMapper;
import com.pcitc.service.out.OutNoticeService;

@Service("outNoticeService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class OutNoticeServiceImpl implements OutNoticeService {

	@Autowired
	private OutNoticeMapper outNoticeMapper;

	private final static Logger logger = LoggerFactory.getLogger(OutNoticeServiceImpl.class);
	
	/* (non-Javadoc)
	 * 批量插入其他系统的公告信息
	 */
	public int insertNoticeDataBatch(List<OutNotice> list, String noticeType) {
		OutNoticeExample example = new OutNoticeExample();
		OutNoticeExample.Criteria criteria = example.createCriteria();
		criteria.andNoticeSystemTypeEqualTo(noticeType);
		
		outNoticeMapper.deleteByExample(example);
		
		// 通知公告数据不多,暂时for插入
		for (int i = 0 ; i < list.size(); i++) {
			OutNotice notice = list.get(i);
			outNoticeMapper.insert(notice);
		}
		return 1;
	}
	
	public int deleteNoticeByType(String noticeType) {
		OutNoticeExample example = new OutNoticeExample();
		OutNoticeExample.Criteria criteria = example.createCriteria();
		criteria.andNoticeSystemTypeEqualTo(noticeType);
		
		outNoticeMapper.deleteByExample(example);
		return 1;
	}
	
	public LayuiTableData getOutNoticePage(LayuiTableParam param) {
		PageHelper.startPage(param.getPage(), param.getLimit());

		String title = (String) param.getParam().get("title");

		OutNoticeExample example = new OutNoticeExample();
		OutNoticeExample.Criteria criteria = example.createCriteria();
		example.setOrderByClause(" notice_date desc ");
		List<OutNotice> list = outNoticeMapper.selectByExample(example);

		PageInfo<OutNotice> pageInfo = new PageInfo<OutNotice>(list);
		System.out.println(">>>>>>>>>查询分页结果" + pageInfo.getList().size());

		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
		return data;
	}
	
	public OutNotice getOutNoticeDetails(String dataId) {
		OutNotice notice = outNoticeMapper.selectByPrimaryKey(dataId);
		return notice;
	}
}
