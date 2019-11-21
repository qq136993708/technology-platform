package com.pcitc.mapper.file;


import com.pcitc.base.common.FileModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ty
 */
public interface FileCommonMapper {

    List<FileModel> query(String dataId);

    void save (List dataList);

    FileModel downLoad(String id);

    int delete(@Param("dataId") String dataId,@Param("list") List<String> list);
}
