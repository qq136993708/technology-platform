package com.pcitc.service.file;


import com.pcitc.base.common.FileModel;

import java.util.List;

/**
 * @author ty
 */
public interface FileCommonService {
    List<FileModel> query(String dataId);

    void save (FileModel fm);

    void updateFileData (String fileIds,String dataId,String baseSsecretLevel);

    void updateFileData (String fileIds,String dataId);

    FileModel downLoad(String id);


}
