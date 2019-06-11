package com.pcitc.service.system.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.system.SysLog;
import com.pcitc.base.system.SysLogExample;
import com.pcitc.base.system.SysLogExample.Criteria;
import com.pcitc.base.util.DateUtil;
import com.pcitc.mapper.system.SysLogMapper;
import com.pcitc.service.system.SysLogService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;


@Service("sysLog")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class SysLogServiceImpl implements SysLogService {

	@Autowired
	private SysLogMapper sysLogMapper;

	public Integer insertLog(SysLog log) {
		return sysLogMapper.insert(log);
	}

	@Override
	public JSONObject selectSysLogList(SysLog obj) throws Exception {
		if(Integer.parseInt(obj.getLimit()) < 0) {
			SysLogExample ex = new SysLogExample();
			//拼接查询条件
			Criteria or = ex.or();
			if (StringUtils.isNotEmpty(obj.getLogActionName())) {
				or.andLogActionNameLike("%"+obj.getLogActionName()+"%");
				//or.andLogActionNameEqualTo(obj.getLogActionName());
			}
			if (StringUtils.isNotEmpty(obj.getLogAction())) {
				or.andLogActionLike("%"+obj.getLogAction()+"%");
			}
			if (StringUtils.isNotEmpty(obj.getLogsTime())) {
			    String logsTime = obj.getLogsTime();
			    String beginDate = logsTime.split(" - ")[0];
                String endDate = logsTime.split(" - ")[1];
                or.andLogTimeBetween(DateUtil.strToDate(beginDate, DateUtil.FMT_DD), DateUtil.strToDate(endDate, DateUtil.FMT_DD));
			}
			/*if (StringUtils.isNotEmpty(obj.getParams_0())) {
				if (StringUtils.isNotEmpty(obj.getParams_1())) {
					if(obj.getParams_0().equals(obj.getParams_1())) {
						or.andLogTimeLike("%"+obj.getParams_0()+"%");
					} else {
						or.andLogTimeBetween(DateUtil.strToDate(obj.getParams_0(), DateUtil.FMT_DD), DateUtil.strToDate(obj.getParams_1(), DateUtil.FMT_DD));
					}
				} else {
					or.andLogTimeGreaterThanOrEqualTo(DateUtil.strToDate(obj.getParams_0(), DateUtil.FMT_DD));
				}
			} else {
				if (StringUtils.isNotEmpty(obj.getParams_1())) {
					or.andLogTimeLessThanOrEqualTo(DateUtil.strToDate(obj.getParams_1(), DateUtil.FMT_DD));
				}
			}*/
			List<SysLog> list = sysLogMapper.selectByExample(ex);
			JSONObject result = new JSONObject();
			result.put("list", list);
			return result;
		}
		// 每页显示条数
		int pageSize = Integer.parseInt(obj.getLimit());
		// 当前是第几页
		int pageNum = Integer.parseInt(obj.getPage());
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(pageNum, pageSize);
		// 2、执行查询
		SysLogExample ex = new SysLogExample();
		ex.setOrderByClause("log_time DESC");
		//拼接查询条件
		Criteria or = ex.or();
		if (StringUtils.isNotEmpty(obj.getLogActionName())) {
			or.andLogActionNameLike("%"+obj.getLogActionName()+"%");
			//or.andLogActionNameEqualTo(obj.getLogActionName());
		}
		if (StringUtils.isNotEmpty(obj.getLogAction())) {
			or.andLogActionLike("%"+obj.getLogAction()+"%");
		}
        if (StringUtils.isNotEmpty(obj.getLogsTime())) {
            String logsTime = obj.getLogsTime();
            String beginDate = logsTime.split(" - ")[0];
            String endDate = logsTime.split(" - ")[1];
            or.andLogTimeBetween(DateUtil.strToDate(beginDate, DateUtil.FMT_DD), DateUtil.strToDate(endDate, DateUtil.FMT_DD));
        }
		List<SysLog> list = sysLogMapper.selectByExample(ex);
		// 3、获取分页查询后的数据
		PageInfo<SysLog> pageInfo = new PageInfo<SysLog>(list);
		// 4、封装需要返回的分页实体
		JSONObject result = new JSONObject();
		result.put("totalCount", pageInfo.getTotal());
		result.put("list", list);
		return result;
	}

	@Override
	public int deleteSysLog(String id) throws Exception {
		int result = 500;
		if (StringUtils.isNotEmpty(id)) {
			String[] arr = id.split(",");
			List<String> ids = Arrays.asList(arr);
			if(sysLogMapper.deleteSysLogById(ids) > 0)
				result = 200;
		}
		return result;
	}

	@Override
	public int insertBatch(List<SysLog> list) throws Exception {
		int result = 500;
		if(sysLogMapper.insertBatch(list)>0)
			result = 200;
		return result;
	}
}