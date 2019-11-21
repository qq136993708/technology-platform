package com.pcitc.service.file;


import com.pcitc.base.common.FileModel;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @author ty
 */
public interface FileCommonService {
    List<FileModel> query(String dataId);

    FileModel upload (String dataId) throws IOException;

    List<FileModel> save (List<FileModel>  dataList,String dataId);

    FileModel downLoad(String id);

}
