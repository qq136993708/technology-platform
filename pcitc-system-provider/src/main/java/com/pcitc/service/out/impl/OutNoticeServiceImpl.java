package com.pcitc.service.out.impl;

import java.util.ArrayList;
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

	/*
	 * (non-Javadoc) 批量插入其他系统的公告信息
	 */
	public int insertNoticeDataBatch(List<OutNotice> list, String noticeType) {
		OutNoticeExample example = new OutNoticeExample();
		OutNoticeExample.Criteria criteria = example.createCriteria();
		criteria.andNoticeSystemTypeEqualTo(noticeType);

		outNoticeMapper.deleteByExample(example);

		// 通知公告数据不多,暂时for插入
		for (int i = 0; i < list.size(); i++) {
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

		// 项目管理系统的通知公告
		OutNoticeExample example = new OutNoticeExample();
		OutNoticeExample.Criteria criteria = example.createCriteria();
		criteria.andNoticeSystemTypeEqualTo("项目管理系统");
		example.setOrderByClause(" notice_date desc ");
		List<OutNotice> list1 = outNoticeMapper.selectByExample(example);

		PageInfo<OutNotice> pageInfo1 = new PageInfo<OutNotice>(list1);
		System.out.println("项目管理系统>>>>>>>>>查询分页结果" + pageInfo1.getList().size());

		List<OutNotice> xmList = pageInfo1.getList();
		Long xmTotal = pageInfo1.getTotal();

		// 成果鉴定系统的通知公告
		example.clear();
		criteria = example.createCriteria();
		criteria.andNoticeSystemTypeEqualTo("成果鉴定系统");
		example.setOrderByClause(" notice_date desc ");
		List<OutNotice> list2 = outNoticeMapper.selectByExample(example);

		PageInfo<OutNotice> pageInfo2 = new PageInfo<OutNotice>(list2);
		System.out.println("成果鉴定系统>>>>>>>>>查询分页结果" + pageInfo2.getList().size());

		List<OutNotice> cgList = pageInfo2.getList();
		Long cgTotal = pageInfo2.getTotal();

		// 科技奖励系统的通知公告
		example.clear();
		criteria = example.createCriteria();
		criteria.andNoticeSystemTypeEqualTo("科技奖励系统");
		example.setOrderByClause(" notice_date desc ");
		List<OutNotice> list3 = outNoticeMapper.selectByExample(example);

		PageInfo<OutNotice> pageInfo3 = new PageInfo<OutNotice>(list3);
		System.out.println("科技奖励系统>>>>>>>>>查询分页结果" + pageInfo3.getList().size());

		List<OutNotice> jlList = pageInfo3.getList();
		Long jlTotal = pageInfo3.getTotal();

		List<OutNotice> reList = new ArrayList<OutNotice>();
		reList.addAll(xmList);
		reList.addAll(cgList);
		reList.addAll(jlList);
		LayuiTableData data = new LayuiTableData();
		data.setData(reList);
		data.setCount(xmTotal.intValue() + cgTotal.intValue() + jlTotal.intValue());
		return data;
	}

	public OutNotice getOutNoticeDetails(String dataId) {
		OutNotice notice = outNoticeMapper.selectByPrimaryKey(dataId);
		return notice;
	}
}
