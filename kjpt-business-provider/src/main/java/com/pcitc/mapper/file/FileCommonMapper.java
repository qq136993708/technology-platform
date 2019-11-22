package com.pcitc.mapper.file;


import com.pcitc.base.common.FileModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ty
 */
@Mapper
public interface FileCommonMapper {

    List<FileModel> query(String dataId);

    void save(FileModel fm);

    FileModel downLoad(String id);

    //int delete(@Param("dataId") String dataId,@Param("list") List<String> list);

    void delete(String[] fileds);

    void updateSetDataID(@Param("dataId") String dataId,@Param("array") String[] fileds);
}
