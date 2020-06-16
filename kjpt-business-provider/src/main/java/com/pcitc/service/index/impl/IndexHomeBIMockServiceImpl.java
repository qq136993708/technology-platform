package com.pcitc.service.index.impl;

import com.pcitc.base.indexHome.calResult;
import com.pcitc.config.MockCondition;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Conditional(MockCondition.class)
@Service("IndexHomeBIServiceImpl")
public class IndexHomeBIMockServiceImpl extends IndexHomeBIServiceImpl {

    @Override
    public List<calResult> getTechnologyExpert(Map param) {
        List<calResult> cList = new ArrayList<calResult>();
        String[] texts = {"中科院院士","中国工程院院士","国家高级人才计划","各省人才计划","集团首席科技带路人","项目两总"};
        int[] nums = {691,98,90,103,20,19};
        for(int i=0;i<texts.length;i++){
            calResult temp = new calResult();
            temp.setText(texts[i]);
            temp.setCalValue(BigDecimal.valueOf(nums[i]));
            cList.add(temp);
        }
        return cList;
    }

    @Override
    public List<calResult> getTechnologyPlatform(Map param) {
        List<calResult> cList = new ArrayList<calResult>();
        String[] texts = {"国家级","国家部委级","地方省级","集团级","版块级"};
        int[] nums = {9,12,10,8,11};
        for(int i=0;i<texts.length;i++){
            calResult temp = new calResult();
            temp.setText(texts[i]);
            temp.setCalValue(BigDecimal.valueOf(nums[i]));
            cList.add(temp);
        }
        return cList;
    }

    @Override
    public List<calResult> getAchieveAward(Map param) {
        List<calResult> cList = new ArrayList<calResult>();
        String[] texts = {"国家级奖","省部级奖","集团奖","社会奖项"};
        int[] nums = {9,12,10,8};
        for(int i=0;i<texts.length;i++){
            calResult temp = new calResult();
            temp.setText(texts[i]);
            temp.setCalValue(BigDecimal.valueOf(nums[i]));
            cList.add(temp);
        }
        return cList;
    }

    @Override
    public List<calResult> getIntellectualProperty(Map param) {
        List<calResult> cList = new ArrayList<calResult>();
        String[] texts = {"专利","商标","软件著作权","论文"};
        int[] nums = {226,98,109,26};
        for(int i=0;i<texts.length;i++){
            calResult temp = new calResult();
            temp.setText(texts[i]);
            temp.setCalValue(BigDecimal.valueOf(nums[i]));
            cList.add(temp);
        }
        return cList;
    }

    @Override
    public List<calResult> getPatent(Map param) {
        List<calResult> cList = new ArrayList<calResult>();
        String[] texts = {"外观设计","发明","实用新型"};
        int[] nums = {24,9,24};
        for(int i=0;i<texts.length;i++){
            calResult temp = new calResult();
            temp.setText(texts[i]);
            temp.setCalValue(BigDecimal.valueOf(nums[i]));
            cList.add(temp);
        }
        return cList;
    }

    @Override
    public List<calResult> getAchieveTransfer(Map param) {
        List<calResult> cList = new ArrayList<calResult>();
        String[] texts = {"申请数量","完成数量","完成金额"};
        int[] nums = {226,119,1019};
        for(int i=0;i<texts.length;i++){
            calResult temp = new calResult();
            temp.setText(texts[i]);
            temp.setCalValue(BigDecimal.valueOf(nums[i]));
            cList.add(temp);
        }
        return cList;
    }

    @Override
    public List<calResult> getTechnologyProject(Map param) {
        List<calResult> cList = new ArrayList<calResult>();
        String[] texts = {"核能开发","集中研发","国防基础","国防技术基础"};
        String[] textsSub = {"在研","已完成"};
        int[][] nums = {{0,13},{25,70},{4,28},{14,37}};
        for(int i=0;i<texts.length;i++){
            for(int j=0;j<textsSub.length;j++){
                calResult temp = new calResult();
                temp.setText(texts[i]);
                temp.setTextSub(textsSub[j]);
                temp.setCalValue(BigDecimal.valueOf(nums[i][j]));
                cList.add(temp);
            }
        }
        return cList;
    }

    @Override
    public List<calResult> getProjectInvest(Map param) {
        List<calResult> cList = new ArrayList<calResult>();
        String[] texts = {"核能开发","集中研发","国防基础","国防技术基础"};
        int[] nums = {100037,2000,1007,1007};
        int[] numsub = {9000980,700980,9980,9980};
        for(int i=0;i<texts.length;i++){
            calResult temp = new calResult();
            temp.setText(texts[i]);
            temp.setCalValue(BigDecimal.valueOf(nums[i]));
            temp.setCalValueSub(BigDecimal.valueOf(numsub[i]));
            cList.add(temp);
        }
        return cList;
    }

    @Override
    public List<calResult> getQualityInfo(Map param) {
        List<calResult> cList = new ArrayList<calResult>();
        String[] texts = {"质量事故事件数","非计划停堆停机数"};
        int[] nums = {226,119};
        for(int i=0;i<texts.length;i++){
            calResult temp = new calResult();
            temp.setText(texts[i]);
            temp.setCalValue(BigDecimal.valueOf(nums[i]));
            cList.add(temp);
        }
        return cList;
    }
}
