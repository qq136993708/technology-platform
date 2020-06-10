package com.pcitc.service.patent.impl;

import com.pcitc.base.indexHome.calResult;
import com.pcitc.config.MockCondition;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/***
 * @Author xiaoh
 * @Description 知识产权-领导驾驶舱
 * @Date 2020/6/9 16:35
 * @param
 * @return
 **/
@Conditional(MockCondition.class)
@Service("PatentInfoBIServiceImpl")
public class PatentInfoBIMockServiceImpl extends PatentInfoBIServiceImpl {

    @Override
    public List<calResult> getPatentCountByYear(Map param) {
        List<calResult> cList = new ArrayList<calResult>();
        String[] years = {"2016","2017","2018","2019","2020"};
        String[] textsSub = {"申请专利","授权专利"};
        String[] texts = {"发明","实用新型","外观设计"};
        int[][][] nums = {{{9,13,2},{5,11,2}},{{19,3,2},{2,7,2}},{{9,10,2},{9,10,2}},{{0,7,2},{12,7,2}},{{1,12,2},{7,15,2}}};
        for(int i=0;i<years.length;i++){
            for(int j=0;j<textsSub.length;j++){
                for(int k=0;k<texts.length;k++){
                    calResult temp = new calResult();
                    temp.setTextTitle(years[i]);
                    temp.setTextSub(textsSub[j]);
                    temp.setText(texts[k]);
                    temp.setCalValue(BigDecimal.valueOf(nums[i][j][k]));
                    cList.add(temp);
                }
            }
        }
        return cList;
    }

    @Override
    public List<calResult> getPatentCountByLegelStatus(Map param) {
        List<calResult> cList = new ArrayList<calResult>();
        String[] texts = {"授权","申请","无效"};
        int[] nums = {63,119,24};
        for(int i=0;i<texts.length;i++){
            calResult temp = new calResult();
            temp.setText(texts[i]);
            temp.setCalValue(BigDecimal.valueOf(nums[i]));
            cList.add(temp);
        }
        return cList;
    }

    @Override
    public List<calResult> getPatentCountByOffice(Map param) {
        List<calResult> cList = new ArrayList<calResult>();
        String[] affiliatedUnitText = {"中国核电","中国原子能","中国铀业","中国核建","中核环保","中核中原","中核浦原","中核宝原","中核资本","核动力院","中核工程","原子能院","西物院","战略规划总院","中和咨询","中核能源","新华发电"};
        String[] texts = {"授权","申请","无效"};
        int[][] nums = {{10,20,1},{80,10,12},{60,10,1},{30,0,1},{80,0,13},{80,0,13},{80,0,13},{80,0,13},{80,0,13},{80,0,13},{80,0,13},{80,0,13},{80,0,13},{80,0,13},{80,0,13},{80,0,13},{80,0,13}};
        for(int i=0;i<affiliatedUnitText.length;i++){
            for(int j=0;j<texts.length;j++){
                calResult temp = new calResult();
                temp.setText(affiliatedUnitText[i]);
                temp.setTextSub(texts[j]);
                temp.setCalValue(BigDecimal.valueOf(nums[i][j]));
                cList.add(temp);
            }
        }
        return cList;
    }
}