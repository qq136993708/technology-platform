package com.pcitc.service.treatise.impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pcitc.base.common.ChartData;
import com.pcitc.base.computersoftware.ComputerSoftware;
import com.pcitc.base.patent.PatentInfo;
import com.pcitc.base.researchplatform.PlatformInfoModel;
import com.pcitc.base.trademarkinfo.TrademarkInfo;
import com.pcitc.mapper.achieve.AchieveMaintainMapper;
import com.pcitc.mapper.computersoftware.ComputerSoftwareMapper;
import com.pcitc.mapper.out.OutPersonMapper;
import com.pcitc.mapper.patent.PatentInfoMapper;
import com.pcitc.mapper.researchplatform.PlatformMapper;
import com.pcitc.mapper.trademarkinfo.TrademarkInfoMapper;
import com.pcitc.mapper.treatise.TreatiseInfoMapper;
import com.pcitc.service.treatise.StatisticalService;


@Service
public class StatisticalServiceImpl implements StatisticalService
{
	
	    @Autowired
	    private TreatiseInfoMapper treatiseInfoMapper;//论文
	    @Autowired
	    private PatentInfoMapper   patentInfoMapper;//专利
	    @Autowired
	    private TrademarkInfoMapper    trademarkInfoMapper;//商标
	    @Autowired
	    private ComputerSoftwareMapper computerSoftwareMapper;//软件著作权管理
	    @Autowired
	    private OutPersonMapper outPersonMapper;//软件著作权管理
	    @Autowired
	    private AchieveMaintainMapper achieveMaintainMapper;//软件著作权管理
	    
	    @Autowired
	    private PlatformMapper platformMapper;
	    
	    
	    
	    public List<ChartData> getTongjiList()
		{
			return outPersonMapper.getTongjiList();
		}
	    
	    public Map getRightsMap()//知识产权
	    {
	    	Map result =new HashMap();
	    	Map param =new HashMap();
	    	param.put("deleted", "1");
	    	List list=treatiseInfoMapper.query(param);
	    	List<PatentInfo> patentInfoList=patentInfoMapper.queryPatentList(param) ;
	    	List<TrademarkInfo> trademarkInfoList=trademarkInfoMapper.queryTrademarkList(param) ;
	    	List<ComputerSoftware> computerSoftwarelist=computerSoftwareMapper.query(param);
	    	result.put("patentCount", patentInfoList.size());
	    	result.put("trademarkInfoCount", trademarkInfoList.size());
	    	result.put("computerSoftwareCount", computerSoftwarelist.size());
	    	result.put("treatiseInfoCount", list.size());
	    	return result;
	    }
	    
	    public List getAchieveMaintainGrupCountList()//成果获奖
	    {
	    	return achieveMaintainMapper.getAchieveMaintainGrupCountList();
	    }
	    
	    
	    public List<PlatformInfoModel> getPlatFormList(Map param)
	    {
	    	return platformMapper.getPlatFormList(param);
	    }
	    

}
