package com.pcitc.service.achieve.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.JsonObject;
import com.pcitc.base.achieve.AchieveRecord;
import com.pcitc.base.achieve.AchieveReward;
import com.pcitc.base.achieve.AchieveSubmit;
import com.pcitc.base.util.IsEmptyUtil;
import com.pcitc.mapper.achieve.AchieveRecordMapper;
import com.pcitc.mapper.achieve.AchieveRewardMapper;
import com.pcitc.service.achieve.AchieveRecordService;
import com.pcitc.service.file.FileCommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author
 */
@Service
public class AchieveRecordServiceImpl implements AchieveRecordService {

    @Autowired
    private AchieveRecordMapper arm;

    @Autowired
    private AchieveRewardMapper arw;

    @Autowired
    private FileCommonService fs;

    @Override
    public AchieveRecord load(String id) {
        AchieveRecord ar = arm.load(id);
        ar.setAchieveRewards(arw.getByRecordId(id));
        return ar;
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(AchieveSubmit as) {

        AchieveRecord aRecord = as.getAchieveRecord();
        AchieveReward aReward = as.getAchieveReward();
        IsEmptyUtil.isEmpty(aRecord);
        if(arm.load(aRecord.getId()) ==null){
            aRecord.setCreateDate(as.getUpdateDate());
            aRecord.setCreator(as.getUpdator());
            arm.add(aRecord);
            uploadAchieveFile(aRecord);

            if(aReward != null){
                aReward.setCreateDate(as.getUpdateDate());
                aReward.setCreator(as.getUpdator());
                arw.add(aReward);
                uploadRewardFile(aReward);
                //修改备案的总额
                arw.updateRewardMoney(aRecord.getId());
            }
        }
        else{
            arm.update(aRecord);
            uploadAchieveFile(aRecord);
            if(aReward != null) {
                if(arw.load(aReward.getId())!=null){
                    arw.add(aReward);
                    uploadRewardFile(aReward);
                    arw.updateRewardMoney(aRecord.getId());
                };
            }
        }

    }

    @Override
    public void simpleSave(AchieveSubmit as) {
        AchieveRecord aRecord = as.getAchieveRecord();
        AchieveReward aReward = as.getAchieveReward();
        IsEmptyUtil.isEmpty(aRecord);
        if(arm.load(aRecord.getId()) ==null){
            aRecord.setCreateDate(as.getUpdateDate());
            aRecord.setCreator(as.getUpdator());
            arm.add(aRecord);

            if(aReward != null){
                aReward.setCreateDate(as.getUpdateDate());
                aReward.setCreator(as.getUpdator());
                arw.add(aReward);
                //修改备案的总额
                arw.updateRewardMoney(aRecord.getId());
            }
        }
        else{
            arm.update(aRecord);
            uploadAchieveFile(aRecord);
            if(aReward != null) {
                if(arw.load(aReward.getId())!=null){
                    arw.add(aReward);
                    arw.updateRewardMoney(aRecord.getId());
                };
            }
        }
    }

    public void uploadAchieveFile(AchieveRecord aRecord){
        //授拟-（文件上传）：材料
        JSONObject grantDoc =  JSONObject.parseObject(aRecord.getGrantDoc());
        for(String key:grantDoc.keySet()){
            fs.updateFileData(key,grantDoc.get(key) == null?"":grantDoc.get(key).toString());
        }
        //公示结果：材料
        JSONObject transPublicDoc =  JSONObject.parseObject(aRecord.getTransPublicDoc());
        for(String key:transPublicDoc.keySet()){
            fs.updateFileData(key,transPublicDoc.get(key) == null?"":transPublicDoc.get(key).toString());
        }
        //合同文本：材料
        JSONObject transContractDoc =  JSONObject.parseObject(aRecord.getTransContractDoc());
        for(String key:transContractDoc.keySet()){
            fs.updateFileData(key,transContractDoc.get(key) == null?"":transContractDoc.get(key).toString());
        }
        //评估报告：材料
        JSONObject transAssessDoc =  JSONObject.parseObject(aRecord.getTransAssessDoc());
        for(String key:transAssessDoc.keySet()){
            fs.updateFileData(key,transAssessDoc.get(key) == null?"":transAssessDoc.get(key).toString());
        }
        //决策会议纪要：材料
        JSONObject decisionMeetingDoc =  JSONObject.parseObject(aRecord.getDecisionMeetingDoc());
        for(String key:decisionMeetingDoc.keySet()){
            fs.updateFileData(key,decisionMeetingDoc.get(key) == null?"":decisionMeetingDoc.get(key).toString());
        }
        //规章制度：材料
        JSONObject decisionRuleDoc =  JSONObject.parseObject(aRecord.getDecisionRuleDoc());
        for(String key:decisionRuleDoc.keySet()){
            fs.updateFileData(key,decisionRuleDoc.get(key) == null?"":decisionRuleDoc.get(key).toString());
        }

        //科技成果评价报告（文件上传）
        JSONObject appraisalDoc =  JSONObject.parseObject(aRecord.getAppraisalDoc());
        for(String key:appraisalDoc.keySet()){
            fs.updateFileData(key,appraisalDoc.get(key) == null?"":appraisalDoc.get(key).toString());
        }
    }

    public void uploadRewardFile(AchieveReward aReward){
        //成果核算：材料
        JSONObject rewardAccountingDoc =  JSONObject.parseObject(aReward.getRewardAccountingDoc());
        for(String key:rewardAccountingDoc.keySet()){
            fs.updateFileData(key,rewardAccountingDoc.get(key) == null?"":rewardAccountingDoc.get(key).toString());
        }
        //净收入计算报告：材料
        JSONObject incomeReportDoc =  JSONObject.parseObject(aReward.getIncomeReportDoc());
        for(String key:rewardAccountingDoc.keySet()){
            fs.updateFileData(key,incomeReportDoc.get(key) == null?"":incomeReportDoc.get(key).toString());
        }
        //激励方案：材料
        JSONObject assignPlanDoc =  JSONObject.parseObject(aReward.getAssignPlanDoc());
        for(String key:assignPlanDoc.keySet()){
            fs.updateFileData(key,assignPlanDoc.get(key) == null?"":assignPlanDoc.get(key).toString());
        }
    }

    @Override
    public Integer delete(String ids) {
        String[] idArr = ids.split(",");
        return arm.delete(idArr);
    }

    @Override
    public PageInfo query(Map param) {
        int pageNum = (int)param.get("pageNum");
        int pageSize = (int)param.get("pageSize");
        PageHelper.startPage(pageNum, pageSize);
        List dataList = arm.query(param);
        PageInfo pageInfo = new PageInfo(dataList);
        return pageInfo;
    }
}
