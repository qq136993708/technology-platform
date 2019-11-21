package com.pcitc.service.file.impl;

import com.pcitc.base.common.FileModel;
import com.pcitc.mapper.file.FileCommonMapper;
import com.pcitc.service.file.FileCommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

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
    public FileModel upload( String dataId) throws IOException {
            /*fm.setId(UUID.randomUUID().toString().replace("-",""));
            fm.setFileName(file.getName());
            fm.setCreateDate(new Date());
            fm.setFileSize(file.getSize());
            fm.setType(file.getName().split(",")[1]);
            //上传附件
            upFile(file);*/
        return null;
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<FileModel> save(List<FileModel> dataList,String dataId) {
        //获取保存的文件的list
        List<String> inputDataIdList = dataList.stream().map(FileModel :: getId).collect(Collectors.toList());
        //先去库里处理不在输入的文件列表的数据，逻辑删除掉
        fcm.delete(dataId,inputDataIdList);
        //查询库里的数据
        List<FileModel> dbFileList = query(dataId);
        //把传入数据和库里的数据做对比找出差集
        List<FileModel> differenceList = dataList.stream()
                                        .filter(item -> !dbFileList.stream()
                                        .map(db -> db.getId())
                                        .collect(Collectors.toList())
                                        .contains(item.getId()))
                                        .collect(Collectors.toList());
        //把差集保存到库里如果没差集那就不用保存了
        if(differenceList.size()>0){
            fcm.save(differenceList);
        }
        return dataList;
    }

    @Override
    public FileModel downLoad(String id) {
        return fcm.downLoad(id);
    }
}
