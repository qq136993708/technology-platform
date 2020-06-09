package com.pcitc.service.standardmaintain.impl;

import com.pcitc.base.standardmaintain.StandardMaintainBI;
import com.pcitc.config.MockCondition;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/***
 * @Author xiaoh
 * @Description 质量标准-领导驾驶舱
 * @Date 2020/6/8 17:24
 * @param
 * @return
 **/
@Conditional(MockCondition.class)
@Service("StandardMaintainBIServiceImpl")
public class StandardMaintainBIMockServiceImpl extends StandardMaintainBIServiceImpl {
    @Override
    public List<StandardMaintainBI> getInternalResearchList(Map param) {
        List<StandardMaintainBI> rlist = new ArrayList<StandardMaintainBI>();
        String[] standardType = {"国家标准GB","国家军用标准GJB","核行业标准EJ","核电标准NB","企业标准QB"};
        int[] nums={12,20,20,20,20};
        for (int i=0;i<standardType.length;i++){
            StandardMaintainBI temp = new StandardMaintainBI();
            temp.setStandardTypeText(standardType[i]);
            temp.setStandardType(i+"");
            temp.setResearchCount(nums[i]);
            rlist.add(temp);
        }
        return rlist;
    }

    @Override
    public List<StandardMaintainBI> getInternalPublishList(Map param) {
        List<StandardMaintainBI> rlist = new ArrayList<StandardMaintainBI>();
        String[] standardType = {"国家标准GB","国家军用标准GJB","核行业标准EJ","核电标准NB","企业标准QB"};
        int[] nums={10,12,18,20,25};
        for (int i=0;i<standardType.length;i++){
            StandardMaintainBI temp = new StandardMaintainBI();
            temp.setStandardTypeText(standardType[i]);
            temp.setStandardType(i+"");
            temp.setPublishCount(nums[i]);
            rlist.add(temp);
        }
        return rlist;
    }

    @Override
    public List<StandardMaintainBI> getInternationalAllList(Map param) {
        List<StandardMaintainBI> rlist = new ArrayList<StandardMaintainBI>();
        String[] standardType = {"国际标准在研","累计发布数"};
        int[] nums={12,20};
        for (int i=0;i<standardType.length;i++){
            StandardMaintainBI temp = new StandardMaintainBI();
            temp.setStandardName(standardType[i]);
            temp.setAllCount(nums[i]);
            rlist.add(temp);
        }
        return rlist;
    }


}
