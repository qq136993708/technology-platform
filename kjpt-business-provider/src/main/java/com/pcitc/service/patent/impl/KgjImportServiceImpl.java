package com.pcitc.service.patent.impl;

import com.pcitc.base.patent.KgjImportModel;
import com.pcitc.base.util.DateUtil;
import com.pcitc.base.util.IsEmptyUtil;
import com.pcitc.mapper.patent.KgjImportMapper;
import com.pcitc.service.patent.KgjImportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author ty
 */
@Service
public class KgjImportServiceImpl implements KgjImportService {

    @Autowired
    private KgjImportMapper kgjImportMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List kgjImport(List dataList,String currentUser) {
        IsEmptyUtil.isEmpty(dataList);
        IsEmptyUtil.isEmpty(currentUser);
        String batchId = UUID.randomUUID().toString().replace("-","");
        List<KgjImportModel> list = new ArrayList<>();
        for (int i = 0; i < dataList.size(); i++) {
            List<Object> lo = (List<Object>) dataList.get(i);
            KgjImportModel kgj = new KgjImportModel();
            kgj.setId(UUID.randomUUID().toString().replace("-",""));
            kgj.setBatchId(batchId);
            kgj.setUnitName(String.valueOf(lo.get(0)));
            kgj.setApplicant(String.valueOf(lo.get(1)));
            kgj.setPatentName(String.valueOf(lo.get(2)));
            kgj.setInventor(String.valueOf(lo.get(3)));
            kgj.setApplicationType(String.valueOf(lo.get(4)));
            kgj.setPatentType(String.valueOf(lo.get(5)));
            kgj.setLegalStatus(String.valueOf(lo.get(6)));
            kgj.setDate(DateUtil.strToDate(String.valueOf(lo.get(7)),"yyyy-MM-dd"));
            kgj.setApplicationNumber(String.valueOf(lo.get(8)));
            kgj.setPatentRange(String.valueOf(lo.get(9)));
            kgj.setAgency(String.valueOf(lo.get(10)));
            kgj.setEntryPerson(String.valueOf(lo.get(11)));
            kgj.setApplicationDate(DateUtil.strToDate(String.valueOf(lo.get(12)),"yyyy-MM-dd"));
            kgj.setEntryDate(DateUtil.strToDate(String.valueOf(lo.get(13)),"yyyy-MM-dd"));
            kgj.setApplicationCost(new BigDecimal(String.valueOf(lo.get(14))));
            kgj.setRemark(String.valueOf(lo.get(15)));
            kgj.setSummary(String.valueOf(lo.get(16)));
            kgj.setApplicationOfPatentTransformation(String.valueOf(lo.get(17)));
            kgj.setMajorApplication(String.valueOf(lo.get(18)));
            kgj.setUnenforcedReason(String.valueOf(lo.get(19)));
            kgj.setLicensee(String.valueOf(lo.get(20)));
            kgj.setLicenseeMode(String.valueOf(lo.get(21)));
            kgj.setLicenseeProfit(new BigDecimal(String.valueOf(lo.get(22))));
            kgj.setAssignor(String.valueOf(lo.get(23)));
            kgj.setAssignProfit(new BigDecimal(String.valueOf(lo.get(24))));
            kgj.setPatentRange(currentUser);
            kgj.setCreateDate(new Date());
            list.add(kgj);
        }
        kgjImportMapper.kgjData2Db(list);
        return kgjImportMapper.handlerKgjImport(batchId);
    }
}
