package com.pcitc.service.file.impl;

import com.pcitc.base.common.FileModel;
import com.pcitc.base.exception.SysException;
import com.pcitc.base.util.IsEmptyUtil;
import com.pcitc.mapper.file.FileCommonMapper;
import com.pcitc.service.file.FileCommonService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ty
 */
@Service
public class FileCommonServiceImpl implements FileCommonService {

    @Autowired
    private FileCommonMapper fcm;

    @Override
    public List<FileModel> query(String dataId) {
        return fcm.query(dataId);
    }


    @Override
    public void save(FileModel fm) {
        IsEmptyUtil.isEmpty(fm.getId());
        fcm.save(fm);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateFileData(String fileIds, String dataId,String baseSsecretLevel) {
        String[] fileArr = fileIds.split(",");
        //检查附件的密级有没有大于当前数据的密级的
        if(fcm.checkSecretLevel(baseSsecretLevel,fileArr)>0){
            throw new SysException("附件与当前数据的密级不符，请检查！");
        }
        fcm.delete(dataId);
        fcm.updateSetDataID(dataId,fileArr);
    }

    @Override
    public void updateFileData(String fileIds, String dataId) {
        fcm.delete(dataId);
        if(StringUtils.isNotBlank(fileIds)){
            String[] fileArr = fileIds.split(",");
            fcm.updateSetDataID(dataId,fileArr);
        }

    }

    @Override
    public FileModel downLoad(String id) {
        return fcm.downLoad(id);
    }

}
